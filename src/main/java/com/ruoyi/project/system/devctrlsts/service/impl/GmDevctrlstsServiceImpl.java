package com.ruoyi.project.system.devctrlsts.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.project.system.devctrlsts.mapper.GmDevctrlstsMapper;
import com.ruoyi.project.system.devctrlsts.domain.GmDevctrlsts;
import com.ruoyi.project.system.devctrlsts.service.IGmDevctrlstsService;
import com.ruoyi.common.utils.text.Convert;

/**
 * 【请填写功能名称】Service业务层处理
 * 
 * @author ruoyi
 * @date 2020-12-01
 */
@Service
public class GmDevctrlstsServiceImpl implements IGmDevctrlstsService 
{
    @Autowired
    private GmDevctrlstsMapper gmDevctrlstsMapper;

    /**
     * 查询【请填写功能名称】
     * 
     * @param decstId 【请填写功能名称】ID
     * @return 【请填写功能名称】
     */
    @Override
    public GmDevctrlsts selectGmDevctrlstsById(String decstId)
    {
        return gmDevctrlstsMapper.selectGmDevctrlstsById(decstId);
    }

    /**
     * 查询【请填写功能名称】列表
     * 
     * @param gmDevctrlsts 【请填写功能名称】
     * @return 【请填写功能名称】
     */
    @Override
    public List<GmDevctrlsts> selectGmDevctrlstsList(GmDevctrlsts gmDevctrlsts)
    {
        return gmDevctrlstsMapper.selectGmDevctrlstsList(gmDevctrlsts);
    }

    /**
     * 新增【请填写功能名称】
     * 
     * @param gmDevctrlsts 【请填写功能名称】
     * @return 结果
     */
    @Override
    public int insertGmDevctrlsts(GmDevctrlsts gmDevctrlsts)
    {
        return gmDevctrlstsMapper.insertGmDevctrlsts(gmDevctrlsts);
    }

    /**
     * 修改【请填写功能名称】
     * 
     * @param gmDevctrlsts 【请填写功能名称】
     * @return 结果
     */
    @Override
    public int updateGmDevctrlsts(GmDevctrlsts gmDevctrlsts)
    {
        return gmDevctrlstsMapper.updateGmDevctrlsts(gmDevctrlsts);
    }

    /**
     * 删除【请填写功能名称】对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    @Override
    public int deleteGmDevctrlstsByIds(String ids)
    {
        return gmDevctrlstsMapper.deleteGmDevctrlstsByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除【请填写功能名称】信息
     * 
     * @param decstId 【请填写功能名称】ID
     * @return 结果
     */
    @Override
    public int deleteGmDevctrlstsById(String decstId)
    {
        return gmDevctrlstsMapper.deleteGmDevctrlstsById(decstId);
    }
}
