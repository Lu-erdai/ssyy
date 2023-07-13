package com.ruoyi.project.system.devctrl.mapper;

import java.util.List;
import com.ruoyi.project.system.devctrl.domain.GmDevctrl;

/**
 * 【请填写功能名称】Mapper接口
 * 
 * @author ruoyi
 * @date 2020-12-01
 */
public interface GmDevctrlMapper 
{
    /**
     * 查询【请填写功能名称】
     * 
     * @param dectId 【请填写功能名称】ID
     * @return 【请填写功能名称】
     */
    public GmDevctrl selectGmDevctrlById(String dectId);

    /**
     * 查询【请填写功能名称】列表
     * 
     * @param gmDevctrl 【请填写功能名称】
     * @return 【请填写功能名称】集合
     */
    public List<GmDevctrl> selectGmDevctrlList(GmDevctrl gmDevctrl);

    /**
     * 新增【请填写功能名称】
     * 
     * @param gmDevctrl 【请填写功能名称】
     * @return 结果
     */
    public int insertGmDevctrl(GmDevctrl gmDevctrl);

    /**
     * 修改【请填写功能名称】
     * 
     * @param gmDevctrl 【请填写功能名称】
     * @return 结果
     */
    public int updateGmDevctrl(GmDevctrl gmDevctrl);

    /**
     * 删除【请填写功能名称】
     * 
     * @param dectId 【请填写功能名称】ID
     * @return 结果
     */
    public int deleteGmDevctrlById(String dectId);

    /**
     * 批量删除【请填写功能名称】
     * 
     * @param dectIds 需要删除的数据ID
     * @return 结果
     */
    public int deleteGmDevctrlByIds(String[] dectIds);
}
