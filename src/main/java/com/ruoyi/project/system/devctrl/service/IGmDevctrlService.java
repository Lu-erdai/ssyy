package com.ruoyi.project.system.devctrl.service;

import com.ruoyi.project.system.devctrl.domain.GmDevctrl;

import java.util.List;

/**
 * 【请填写功能名称】Service接口
 * 
 * @author ruoyi
 * @date 2020-12-01
 */
public interface IGmDevctrlService 
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
     * 批量删除【请填写功能名称】
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deleteGmDevctrlByIds(String ids);

    /**
     * 删除【请填写功能名称】信息
     * 
     * @param dectId 【请填写功能名称】ID
     * @return 结果
     */
    public int deleteGmDevctrlById(String dectId);

    public String getAllDevBut(String sceneId);

    String operate(String dectId, String decoType);

    String operateMsg(String dectId);
}
