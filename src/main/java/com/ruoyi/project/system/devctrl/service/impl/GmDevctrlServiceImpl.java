package com.ruoyi.project.system.devctrl.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.ruoyi.common.utils.security.ShiroUtils;
import com.ruoyi.common.utils.text.Convert;
import com.ruoyi.project.system.devctrl.domain.GmDevctrl;
import com.ruoyi.project.system.devctrl.mapper.GmDevctrlMapper;
import com.ruoyi.project.system.devctrl.service.IGmDevctrlService;
import com.ruoyi.project.system.devctrlbtn.domain.OpDevctrlbtn;
import com.ruoyi.project.system.devctrlbtn.mapper.OpDevctrlbtnMapper;
import com.ruoyi.project.system.devctrloperate.domain.GmDevctrloperate;
import com.ruoyi.project.system.devctrloperate.mapper.GmDevctrloperateMapper;
import com.ruoyi.project.system.devctrlsts.domain.GmDevctrlsts;
import com.ruoyi.project.system.devctrlsts.mapper.GmDevctrlstsMapper;
import com.ruoyi.project.system.user.domain.User;
import com.ruoyi.project.system.vo.DevctrlVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

/**
 * 【请填写功能名称】Service业务层处理
 *
 * @author ruoyi
 * @date 2020-12-01
 */
@Service
public class GmDevctrlServiceImpl implements IGmDevctrlService {
    @Autowired
    private GmDevctrlMapper gmDevctrlMapper;

    @Autowired
    private GmDevctrlstsMapper gmDevctrlstsMapper;

    @Autowired
    private OpDevctrlbtnMapper opDevctrlbtnMapper;

    @Autowired
    private GmDevctrloperateMapper gmDevctrloperateMapper;


    /**
     * 查询【请填写功能名称】
     *
     * @param dectId 【请填写功能名称】ID
     * @return 【请填写功能名称】
     */
    @Override
    public GmDevctrl selectGmDevctrlById(String dectId) {
        return gmDevctrlMapper.selectGmDevctrlById(dectId);
    }

    /**
     * 查询【请填写功能名称】列表
     *
     * @param gmDevctrl 【请填写功能名称】
     * @return 【请填写功能名称】
     */
    @Override
    public List<GmDevctrl> selectGmDevctrlList(GmDevctrl gmDevctrl) {
        return gmDevctrlMapper.selectGmDevctrlList(gmDevctrl);
    }

    /**
     * 新增【请填写功能名称】
     *
     * @param gmDevctrl 【请填写功能名称】
     * @return 结果
     */
    @Override
    public int insertGmDevctrl(GmDevctrl gmDevctrl) {
        return gmDevctrlMapper.insertGmDevctrl(gmDevctrl);
    }

    /**
     * 修改【请填写功能名称】
     *
     * @param gmDevctrl 【请填写功能名称】
     * @return 结果
     */
    @Override
    public int updateGmDevctrl(GmDevctrl gmDevctrl) {
        return gmDevctrlMapper.updateGmDevctrl(gmDevctrl);
    }

    /**
     * 删除【请填写功能名称】对象
     *
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    @Override
    public int deleteGmDevctrlByIds(String ids) {
        return gmDevctrlMapper.deleteGmDevctrlByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除【请填写功能名称】信息
     *
     * @param dectId 【请填写功能名称】ID
     * @return 结果
     */
    @Override
    public int deleteGmDevctrlById(String dectId) {
        return gmDevctrlMapper.deleteGmDevctrlById(dectId);
    }

    @Override
    public String getAllDevBut(String sceneId) {
        Map map = new HashMap();

        GmDevctrl gmDevctrl = new GmDevctrl();
        gmDevctrl.setChOfferser((long) 1);
        gmDevctrl.setDectState((long) 1);
        gmDevctrl.setSceneId(sceneId);
        List<GmDevctrl> gmDevctrls = gmDevctrlMapper.selectGmDevctrlList(gmDevctrl);
        List<DevctrlVO> devctrlVOS = new ArrayList<>();
        //如果配置了按钮
        if (gmDevctrls.size() > 0) {
            for (GmDevctrl gmDevctrl1 : gmDevctrls) {
                DevctrlVO devctrlVO = new DevctrlVO();//增加大类放入所需json字段


                GmDevctrlsts devctrlsts = new GmDevctrlsts();
                devctrlsts.setDectId(gmDevctrl1.getDectId());
                List<GmDevctrlsts> gmDevctrlsts = gmDevctrlstsMapper.selectGmDevctrlstsList(devctrlsts);
                String decoSort = "未知";
                if (gmDevctrlsts != null) {
                    if (gmDevctrlsts.get(0).getDecoSort() != null) {
                        if (gmDevctrlsts.get(0).getDecoSort() == 0) {
                            decoSort = "未知";
                        } else if (gmDevctrlsts.get(0).getDecoSort() == 1) {
                            decoSort = "定时";
                        } else if (gmDevctrlsts.get(0).getDecoSort() == 2) {
                            decoSort = "自动";
                        } else if (gmDevctrlsts.get(0).getDecoSort() == 3) {
                            decoSort = "遥控";
                        } else if (gmDevctrlsts.get(0).getDecoSort() == 4) {
                            decoSort = "手动";
                        } else if (gmDevctrlsts.get(0).getDecoSort() == 5) {
                            decoSort = "异常保护";
                        } else if (gmDevctrlsts.get(0).getDecoSort() == 6) {
                            decoSort = "强制控制";
                        } else if (gmDevctrlsts.get(0).getDecoSort() == 7) {
                            decoSort = "短信控制";
                        }
                        devctrlVO.setGmDevctrl(gmDevctrl1);
                        devctrlVO.setGmDevctrlsts(gmDevctrlsts.get(0));
                        devctrlVO.setDecoSort(decoSort);
                    }
                }

                OpDevctrlbtn opDevctrlbtn = new OpDevctrlbtn();
                opDevctrlbtn.setDectId(gmDevctrl1.getDectId());
                List<OpDevctrlbtn> opDevctrlbtns = opDevctrlbtnMapper.selectOpDevctrlbtnList(opDevctrlbtn);
//                devctrlVO.setGmDevctrl(gmDevctrl1);
//                devctrlVO.setGmDevctrlsts(gmDevctrlsts);
//                devctrlVO.setDecoSort(decoSort);
                devctrlVO.setOpDevctrlbtns((ArrayList<OpDevctrlbtn>) opDevctrlbtns);
                devctrlVOS.add(devctrlVO);
            }
        }
        String jsonObj = JSONObject.toJSONString(devctrlVOS);
        return jsonObj;
    }

    @Override
    public String operate(String dectId, String decoType) {
        String result = "";

        GmDevctrloperate gmDevctrloperate = new GmDevctrloperate();
        gmDevctrloperate.setDectId(dectId);
        List<GmDevctrloperate> gmDevctrloperates = gmDevctrloperateMapper.selectGmDevctrloperateList(gmDevctrloperate);
        if(gmDevctrloperates.size()>0){
            GmDevctrloperate operate = gmDevctrloperates.get(0);
            Long decoState = operate.getDecoState();
            if(decoState!=null && decoState == 0){//空闲状态
                Date deco_time = new Date();
                User sysUser = ShiroUtils.getSysUser();
                operate.setDecoUserid(sysUser.getUserId()+"");
                operate.setDecoUsername(sysUser.getUserName());
                operate.setDecoType(Long.valueOf(decoType));
                operate.setDecoTime(deco_time);
                operate.setDecoState(Long.valueOf(1));
                operate.setDecoSort(Long.valueOf(3));
                operate.setDecoResult(Long.valueOf(0));
                operate.setDecoUserip(sysUser.getLoginIp());
                operate.setDecoUsertype(Long.valueOf(1));
                int i = gmDevctrloperateMapper.updateGmDevctrloperate(operate);
                result = "1";
            }else{
                result = "0";//当前设备已被其他用户控制，请稍后再试！
            }




        }else{
         result = "2";//没有找到设备
        }



        return result;
    }

    @Override
    public String operateMsg(String dectId) {
        GmDevctrloperate gmDevctrloperate = new GmDevctrloperate();
        gmDevctrloperate.setDectId(dectId);
        List<GmDevctrloperate> gmDevctrloperates = gmDevctrloperateMapper.selectGmDevctrloperateList(gmDevctrloperate);
        Map<String, String> map = new HashMap<String, String>();
        map.put("decoType", gmDevctrloperates.get(0).getDecoType() == null ? "" : gmDevctrloperates.get(0).getDecoType().toString());
        map.put("decoState", gmDevctrloperates.get(0).getDecoState() == null ? "" : gmDevctrloperates.get(0).getDecoState().toString());
        map.put("decoResult", gmDevctrloperates.get(0).getDecoResult()==null ? "":gmDevctrloperates.get(0).getDecoResult().toString());
        map.put("decoErrorCode", gmDevctrloperates.get(0).getDecoErrorcode()==null ? "":gmDevctrloperates.get(0).getDecoErrorcode().toString());
        String jsonObj = JSONObject.toJSONString(map);
        return jsonObj;
    }
}
