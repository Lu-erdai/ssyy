package com.ruoyi.project.tool.api;

import cn.hutool.http.HttpUtil;
import cn.hutool.json.JSONArray;
import cn.hutool.json.JSONObject;
import cn.hutool.json.JSONUtil;
import com.ruoyi.framework.web.controller.BaseController;
import com.ruoyi.project.system.skyboxval.domain.SkyBoxval;
import com.ruoyi.project.system.skyboxval.service.ISkyBoxvalService;
import com.ruoyi.project.system.skyinfo.domain.SkyInfo;
import com.ruoyi.project.system.skyinfo.service.ISkyInfoService;
import com.ruoyi.project.system.skylastdata.domain.SkyLastdata;
import com.ruoyi.project.system.skylastdata.service.ISkyLastdataService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.HashMap;
import java.util.List;

/**
 * 【请填写功能名称】Controller
 *
 * @author ruoyi
 * @date 2020-11-30
 */
@Api("速控云api")
@RestController
@RequestMapping("/api/skyControl")
public class SkyApi extends BaseController {

    @Autowired
    private ISkyInfoService skyInfoService;
    @Autowired
    private ISkyBoxvalService iSkyBoxvalService;
    @Autowired
    private ISkyLastdataService iSkyLastdataService;


    private static String skyUrl = "http://sukon-cloud.com";//头部
    private static String getVariantsUrl = "/api/v1/base/boxVariants";//获取变量
    private static String setVariantValueUrl = "/api/v1/mndraw/setVariantValue";//设置参数值
    private static String realtimeDatasUrl = "/api/v1/data/realtimeDatas";//获取变量实时值

    private static String getMndrawParams = "/api/v1/mndraw/mndrawParams";//获取组态连接








    @GetMapping("/setVariantValue")
    public String setVariantValue(@RequestParam(value = "operation", required = true) String operation, @RequestParam(value = "projectId", required = true) Long projectId) {


        SkyInfo skyinfo = skyInfoService.selectSkyInfoById(projectId);
        String token = skyinfo.getToken();
        String boxId = skyinfo.getBoxId();

        //1正0负
        //小车前进则，前进正，后退负
        try {
            if (operation.equals("qianjin")) {//前进
                boolean setvalue = setvalue(token, boxId + ":" + 0, 1D);//前进正
                boolean setvalue1 = setvalue(token, boxId + ":" + 1, 0D);//后退负
                boolean setvalue2 = setvalue(token, boxId + ":" + 2, 0D);//停止负
                if (setvalue && setvalue1 && setvalue2) {
                    return "success";
                }
            } else if (operation.equals("houtui")) {//后退
                boolean setvalue = setvalue(token, boxId + ":" + 0, 0D);//前进负
                boolean setvalue1 = setvalue(token, boxId + ":" + 1, 1D);//后退正
                boolean setvalue2 = setvalue(token, boxId + ":" + 2, 0D);//停止负
                if (setvalue && setvalue1 && setvalue2) {
                    return "success";
                }
            } else if (operation.equals("ydtz")) {//停止
                boolean setvalue = setvalue(token, boxId + ":" + 0, 0D);//前进负
                boolean setvalue1 = setvalue(token, boxId + ":" + 1, 0D);//后退负
                boolean setvalue2 = setvalue(token, boxId + ":" + 2, 1D);//停止正
                if (setvalue && setvalue1 && setvalue2) {
                    return "success";
                }

            } else if (operation.equals("jiasu")) {//加速
                setvalue(token, boxId + ":" + 6, 30D);//前进负
            } else if (operation.equals("jiansu")) {//减速
                setvalue(token, boxId + ":" + 6, 10D);//前进负
            } else if (operation.equals("zdtlks")) {//自动投料开始
                boolean setvalue = setvalue(token, boxId + ":" + 7, 1D);//自动投料开始
                if (setvalue) {
                    return "success";
                }
            } else if (operation.equals("zdtltz")) {//自动投料停止
                boolean setvalue = setvalue(token, boxId + ":" + 7, 0D);//自动投料停止
                if (setvalue) {
                    return "success";
                }
            } else if (operation.equals("zdglkq")) {//自动过滤开启
                boolean setvalue = setvalue(token, boxId + ":" + 20, 1D);//自动过滤开启
                if (setvalue) {
                    return "success";
                }
            } else if (operation.equals("zdglgb")) {//自动过滤关闭
                boolean setvalue = setvalue(token, boxId + ":" + 20, 0D);//自动过滤关闭
                if (setvalue) {
                    return "success";
                }
            }
            return "fail";
        } catch (Exception e) {
            e.printStackTrace();
            return "fail";
        }


    }

    public static boolean setvalue(String token, String variantId, Double variantVal) {

        HashMap<String, Object> paramMap = new HashMap<>();
        paramMap.put("token", token);
        paramMap.put("variantId", variantId);
        paramMap.put("variantVal", variantVal);
        String url = skyUrl + setVariantValueUrl;
        String result = HttpUtil.post(url, paramMap);
        JSONObject jsonObject = JSONUtil.parseObj(result);
        boolean success = jsonObject.getBool("success");
        if (success) {
            return true;
        } else {
            return false;
        }

    }


    @GetMapping("/getMndrawParams")
    public String getMndrawParams(){

        String url = skyUrl + getMndrawParams;

        SkyInfo skyinfo = skyInfoService.selectSkyInfoById(1L);
        String token = skyinfo.getToken();
        String projectId = skyinfo.getProjectId();
        //请求参数
        HashMap<String, Object> paramMap = new HashMap<>();
        paramMap.put("token", token);
        paramMap.put("projectId", projectId);
        paramMap.put("for_client", "p");
        String result = HttpUtil.post(url, paramMap);

        JSONObject jsonObject = JSONUtil.parseObj(result);
        Object code = jsonObject.get("code");
        String ztlj = "";
        if (code.equals(70000)) {
            Object data = jsonObject.get("data");
            JSONObject jsonData = JSONUtil.parseObj(data);
            String id = jsonData.getStr("id");
            String type = jsonData.getStr("type");
            String resourceId = jsonData.getStr("resourceId");
            String tokenBack = jsonData.getStr("token");
            String uid = jsonData.getStr("uid");
            ztlj = "http://sukon-cloud.com/mndraw/client?id="+id+"&type="+type+"&resourceId="+resourceId+"&token="+tokenBack+"&uid="+uid;
        }

        return ztlj;
    }


    /**
     * 获取所有变量
     *
     * @return
     */
    @GetMapping("/getAllVarian")
    public String getAllVarian() {


        getVarians(1L);
        getVarians(2L);
        return "0";
    }



    private String getVarians(Long id) {

        SkyInfo skyinfo = skyInfoService.selectSkyInfoById(id);
        String boxId = skyinfo.getBoxId();
        String plcId = skyinfo.getPlcId();
        String boxName = skyinfo.getBoxName();

        String url = skyUrl + getVariantsUrl;

        //请求参数
        HashMap<String, Object> paramMap = new HashMap<>();

        paramMap.put("token", skyinfo.getToken());
        paramMap.put("boxId", skyinfo.getBoxId());
        paramMap.put("plcId", skyinfo.getPlcId());

        String result = HttpUtil.post(url, paramMap);

        JSONObject jsonObject = JSONUtil.parseObj(result);
        Integer code = jsonObject.getInt("code");


        try {
            if (code.equals(50000)) {
                JSONArray data = jsonObject.getJSONArray("data");
                for (int i = 0; i < data.size(); i++) {
                    JSONObject variant = data.getJSONObject(i);
                    Long varId = variant.getLong("variantId");
                    String varName = variant.getStr("name");
                    String varAddr = variant.getStr("addr");
                    String type = variant.getStr("type");
                    SkyBoxval skyBoxval = new SkyBoxval();
//                    skyBoxval.setId(varId);
                    skyBoxval.setBoxId(boxId);
                    skyBoxval.setVariantId(varId);
                    List<SkyBoxval> skyBoxvals = iSkyBoxvalService.selectSkyBoxvalList(skyBoxval);

                    skyBoxval.setBoxName(boxName);
                    skyBoxval.setPlcId(plcId);
                    skyBoxval.setName(varName);
                    skyBoxval.setAddr(varAddr);
                    skyBoxval.setType(type);
                    skyBoxval.setUpdateTime(new Date());
                    if (skyBoxvals.size() < 1) {
                        iSkyBoxvalService.insertSkyBoxval(skyBoxval);
                    } else {
                        iSkyBoxvalService.updateSkyBoxval(skyBoxval);
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
            return e.getMessage();
        }
        return "success";

    }


    /**
     * 获取所有变量最新值
     *
     * @return
     */
    @GetMapping("/getLastDatas")
    public String getLastDatas() {


        getLastData(1L);
        getLastData(2L);

        return "success";

    }


    private void getLastData(Long id) {

        SkyInfo skyInfo = skyInfoService.selectSkyInfoById(id);

        String boxId = skyInfo.getBoxId();
        String boxName = skyInfo.getBoxName();
        String token = skyInfo.getToken();

        String lastDataUrl = skyUrl + realtimeDatasUrl;
        SkyBoxval querySkyBoxval = new SkyBoxval();
        querySkyBoxval.setBoxId(boxId);
        List<SkyBoxval> skyBoxvals = iSkyBoxvalService.selectSkyBoxvalList(querySkyBoxval);

        for (int i = 0; i < skyBoxvals.size(); i++) {
            SkyBoxval skyBoxval = skyBoxvals.get(i);
            Long variantId = skyBoxval.getVariantId();
            String variantName = skyBoxval.getName();
            String variantIds = boxId + "(" + variantId + ")";
            //请求参数
            HashMap<String, Object> paramMap = new HashMap<>();
            paramMap.put("token", token);
            paramMap.put("variantIds", variantIds);
            String result = HttpUtil.post(lastDataUrl, paramMap);

            JSONObject jsonObject = JSONUtil.parseObj(result);
            Integer code = jsonObject.getInt("code");
            if (code.equals(80000)) {

                JSONArray data = jsonObject.getJSONArray("data");
                if (data.size() > 0) {
                    JSONObject variantVal = data.getJSONObject(0);
                    Long value = variantVal.getLong("value");
                    SkyLastdata skyLastdata = new SkyLastdata();

                    skyLastdata.setBoxId(boxId);
                    skyLastdata.setVariantId(variantId);
                    List<SkyLastdata> skyLastdata1 = iSkyLastdataService.selectSkyLastdataList(skyLastdata);//查看数据库是否已经有过数据
                    skyLastdata.setBoxName(boxName);
                    skyLastdata.setVariantName(variantName);
                    skyLastdata.setValue(value);
                    skyLastdata.setUpdateTime(new Date());
                    if (skyLastdata1.size() < 1) {
                        iSkyLastdataService.insertSkyLastdata(skyLastdata);
                    } else {
                        iSkyLastdataService.updateSkyLastdata(skyLastdata);
                    }
                }
            }

        }


    }


}
