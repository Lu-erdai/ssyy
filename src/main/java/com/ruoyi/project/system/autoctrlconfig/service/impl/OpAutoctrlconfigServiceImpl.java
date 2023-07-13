package com.ruoyi.project.system.autoctrlconfig.service.impl;

import com.ruoyi.common.utils.security.ShiroUtils;
import com.ruoyi.common.utils.text.Convert;
import com.ruoyi.project.system.autoctrlconfig.domain.OpAutoctrlconfig;
import com.ruoyi.project.system.autoctrlconfig.mapper.OpAutoctrlconfigMapper;
import com.ruoyi.project.system.autoctrlconfig.service.IOpAutoctrlconfigService;
import com.ruoyi.project.system.autoctrlfactor.domain.OpAutoctrlfactor;
import com.ruoyi.project.system.autoctrlfactor.mapper.OpAutoctrlfactorMapper;
import com.ruoyi.project.system.vo.AutoConfigVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * 自动控制配置Service业务层处理
 * 
 * @author ruoyi
 * @date 2020-12-08
 */
@Service
public class OpAutoctrlconfigServiceImpl implements IOpAutoctrlconfigService 
{
    @Autowired
    private OpAutoctrlconfigMapper opAutoctrlconfigMapper;

    @Autowired
    private OpAutoctrlfactorMapper opAutoctrlfactorMapper;


    /**
     * 查询自动控制配置
     * 
     * @param accId 自动控制配置ID
     * @return 自动控制配置
     */
    @Override
    public OpAutoctrlconfig selectOpAutoctrlconfigById(Long accId)
    {
        return opAutoctrlconfigMapper.selectOpAutoctrlconfigById(accId);
    }

    /**
     * 查询自动控制配置列表
     * 
     * @param opAutoctrlconfig 自动控制配置
     * @return 自动控制配置
     */
    @Override
    public List<OpAutoctrlconfig> selectOpAutoctrlconfigList(OpAutoctrlconfig opAutoctrlconfig)
    {
        return opAutoctrlconfigMapper.selectOpAutoctrlconfigList(opAutoctrlconfig);
    }

    /**
     * 新增自动控制配置
     * 
     * @param opAutoctrlconfig 自动控制配置
     * @return 结果
     */
    @Override
    public int insertOpAutoctrlconfig(OpAutoctrlconfig opAutoctrlconfig)
    {
        return opAutoctrlconfigMapper.insertOpAutoctrlconfig(opAutoctrlconfig);
    }

    /**
     * 修改自动控制配置
     * 
     * @param opAutoctrlconfig 自动控制配置
     * @return 结果
     */
    @Override
    public int updateOpAutoctrlconfig(OpAutoctrlconfig opAutoctrlconfig)
    {
        return opAutoctrlconfigMapper.updateOpAutoctrlconfig(opAutoctrlconfig);
    }

    /**
     * 删除自动控制配置对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    @Override
    public int deleteOpAutoctrlconfigByIds(String ids)
    {
        return opAutoctrlconfigMapper.deleteOpAutoctrlconfigByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除自动控制配置信息
     * 
     * @param accId 自动控制配置ID
     * @return 结果
     */
    @Override
    public int deleteOpAutoctrlconfigById(Long accId)
    {
        return opAutoctrlconfigMapper.deleteOpAutoctrlconfigById(accId);
    }

    @Override
    public List<AutoConfigVO> selectAutoConfigVOList(String sceneId) {
        return opAutoctrlconfigMapper.selectAutoConfigVOList(sceneId);
    }

    @Override
    public int insertConfigAndFactor(AutoConfigVO autoConfigVO) {

        OpAutoctrlconfig opAutoctrlconfig = new OpAutoctrlconfig();

        opAutoctrlconfig.setSceneId(autoConfigVO.getSceneId());
        opAutoctrlconfig.setDectId(autoConfigVO.getDectId());
        opAutoctrlconfig.setDecoType(autoConfigVO.getDecoType());
        opAutoctrlconfig.setAccCond(autoConfigVO.getAccCond());
        opAutoctrlconfig.setAccUser(ShiroUtils.getSysUser().getUserName());
        opAutoctrlconfig.setAccAddtime(new Date());
        opAutoctrlconfig.setAccEnable(autoConfigVO.getAccEnable());


        int i = opAutoctrlconfigMapper.insertOpAutoctrlconfig(opAutoctrlconfig);

        Long accId = opAutoctrlconfig.getAccId();
        OpAutoctrlfactor opAutoctrlfactor = new OpAutoctrlfactor();
        opAutoctrlfactor.setAccId(accId+"");
        opAutoctrlfactor.setChId(autoConfigVO.getChId());
        opAutoctrlfactor.setAccHandle(autoConfigVO.getAccHandle());
        opAutoctrlfactor.setAccCondition(autoConfigVO.getAccCondition());
        opAutoctrlfactor.setAccTrigger(autoConfigVO.getAccTrigger());


        int i1 = opAutoctrlfactorMapper.insertOpAutoctrlfactor(opAutoctrlfactor);

        return i1;
    }

    @Override
    public int deletfactorAndconfig(String accId, String acfId) {
        int i = opAutoctrlfactorMapper.deleteOpAutoctrlfactorByAccIdAndAcfId(accId,acfId);
        int i1 = opAutoctrlconfigMapper.deleteOpAutoctrlconfigById(Long.valueOf(accId));
        return i1;
    }
}
