package com.ruoyi.project.system.devctrloperate.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.project.system.devctrloperate.mapper.GmDevctrloperateMapper;
import com.ruoyi.project.system.devctrloperate.domain.GmDevctrloperate;
import com.ruoyi.project.system.devctrloperate.service.IGmDevctrloperateService;
import com.ruoyi.common.utils.text.Convert;

/**
 * 【请填写功能名称】Service业务层处理
 * 
 * @author ruoyi
 * @date 2020-12-02
 */
@Service
public class GmDevctrloperateServiceImpl implements IGmDevctrloperateService 
{
    @Autowired
    private GmDevctrloperateMapper gmDevctrloperateMapper;

    /**
     * 查询【请填写功能名称】
     * 
     * @param decoId 【请填写功能名称】ID
     * @return 【请填写功能名称】
     */
    @Override
    public GmDevctrloperate selectGmDevctrloperateById(String decoId)
    {
        return gmDevctrloperateMapper.selectGmDevctrloperateById(decoId);
    }

    /**
     * 查询【请填写功能名称】列表
     * 
     * @param gmDevctrloperate 【请填写功能名称】
     * @return 【请填写功能名称】
     */
    @Override
    public List<GmDevctrloperate> selectGmDevctrloperateList(GmDevctrloperate gmDevctrloperate)
    {
        return gmDevctrloperateMapper.selectGmDevctrloperateList(gmDevctrloperate);
    }

    /**
     * 新增【请填写功能名称】
     * 
     * @param gmDevctrloperate 【请填写功能名称】
     * @return 结果
     */
    @Override
    public int insertGmDevctrloperate(GmDevctrloperate gmDevctrloperate)
    {
        return gmDevctrloperateMapper.insertGmDevctrloperate(gmDevctrloperate);
    }

    /**
     * 修改【请填写功能名称】
     * 
     * @param gmDevctrloperate 【请填写功能名称】
     * @return 结果
     */
    @Override
    public int updateGmDevctrloperate(GmDevctrloperate gmDevctrloperate)
    {
        return gmDevctrloperateMapper.updateGmDevctrloperate(gmDevctrloperate);
    }

    /**
     * 删除【请填写功能名称】对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    @Override
    public int deleteGmDevctrloperateByIds(String ids)
    {
        return gmDevctrloperateMapper.deleteGmDevctrloperateByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除【请填写功能名称】信息
     * 
     * @param decoId 【请填写功能名称】ID
     * @return 结果
     */
    @Override
    public int deleteGmDevctrloperateById(String decoId)
    {
        return gmDevctrloperateMapper.deleteGmDevctrloperateById(decoId);
    }
}
