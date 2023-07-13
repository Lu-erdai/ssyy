package com.ruoyi.project.system.devctrlsts.mapper;

import java.util.List;
import com.ruoyi.project.system.devctrlsts.domain.GmDevctrlsts;

/**
 * 【请填写功能名称】Mapper接口
 * 
 * @author ruoyi
 * @date 2020-12-01
 */
public interface GmDevctrlstsMapper 
{
    /**
     * 查询【请填写功能名称】
     * 
     * @param decstId 【请填写功能名称】ID
     * @return 【请填写功能名称】
     */
    public GmDevctrlsts selectGmDevctrlstsById(String decstId);

    /**
     * 查询【请填写功能名称】列表
     * 
     * @param gmDevctrlsts 【请填写功能名称】
     * @return 【请填写功能名称】集合
     */
    public List<GmDevctrlsts> selectGmDevctrlstsList(GmDevctrlsts gmDevctrlsts);

    /**
     * 新增【请填写功能名称】
     * 
     * @param gmDevctrlsts 【请填写功能名称】
     * @return 结果
     */
    public int insertGmDevctrlsts(GmDevctrlsts gmDevctrlsts);

    /**
     * 修改【请填写功能名称】
     * 
     * @param gmDevctrlsts 【请填写功能名称】
     * @return 结果
     */
    public int updateGmDevctrlsts(GmDevctrlsts gmDevctrlsts);

    /**
     * 删除【请填写功能名称】
     * 
     * @param decstId 【请填写功能名称】ID
     * @return 结果
     */
    public int deleteGmDevctrlstsById(String decstId);

    /**
     * 批量删除【请填写功能名称】
     * 
     * @param decstIds 需要删除的数据ID
     * @return 结果
     */
    public int deleteGmDevctrlstsByIds(String[] decstIds);
}
