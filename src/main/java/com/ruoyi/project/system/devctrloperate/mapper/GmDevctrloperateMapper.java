package com.ruoyi.project.system.devctrloperate.mapper;

import java.util.List;
import com.ruoyi.project.system.devctrloperate.domain.GmDevctrloperate;

/**
 * 【请填写功能名称】Mapper接口
 * 
 * @author ruoyi
 * @date 2020-12-02
 */
public interface GmDevctrloperateMapper 
{
    /**
     * 查询【请填写功能名称】
     * 
     * @param decoId 【请填写功能名称】ID
     * @return 【请填写功能名称】
     */
    public GmDevctrloperate selectGmDevctrloperateById(String decoId);

    /**
     * 查询【请填写功能名称】列表
     * 
     * @param gmDevctrloperate 【请填写功能名称】
     * @return 【请填写功能名称】集合
     */
    public List<GmDevctrloperate> selectGmDevctrloperateList(GmDevctrloperate gmDevctrloperate);

    /**
     * 新增【请填写功能名称】
     * 
     * @param gmDevctrloperate 【请填写功能名称】
     * @return 结果
     */
    public int insertGmDevctrloperate(GmDevctrloperate gmDevctrloperate);

    /**
     * 修改【请填写功能名称】
     * 
     * @param gmDevctrloperate 【请填写功能名称】
     * @return 结果
     */
    public int updateGmDevctrloperate(GmDevctrloperate gmDevctrloperate);

    /**
     * 删除【请填写功能名称】
     * 
     * @param decoId 【请填写功能名称】ID
     * @return 结果
     */
    public int deleteGmDevctrloperateById(String decoId);

    /**
     * 批量删除【请填写功能名称】
     * 
     * @param decoIds 需要删除的数据ID
     * @return 结果
     */
    public int deleteGmDevctrloperateByIds(String[] decoIds);
}
