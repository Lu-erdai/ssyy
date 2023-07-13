package com.ruoyi.project.system.historydata.mapper;

import com.ruoyi.project.system.historydata.domain.GmHistorydata;

import java.util.List;

/**
 * 【请填写功能名称】Mapper接口
 * 
 * @author ruoyi
 * @date 2020-11-30
 */
public interface GmHistorydataMapper 
{
    /**
     * 查询【请填写功能名称】
     * 
     * @param hidaId 【请填写功能名称】ID
     * @return 【请填写功能名称】
     */
    public GmHistorydata selectGmHistorydataById(String hidaId);

    /**
     * 查询【请填写功能名称】列表
     * 
     * @param gmHistorydata 【请填写功能名称】
     * @return 【请填写功能名称】集合
     */
    public List<GmHistorydata> selectGmHistorydataList(GmHistorydata gmHistorydata);


    public List<GmHistorydata> selectGmHistorydataListLimit144(String chId, String startTime, String endTime);

    public List<GmHistorydata> selectGmHistorydataListLimit50(String chId);

    /**
     * 新增【请填写功能名称】
     * 
     * @param gmHistorydata 【请填写功能名称】
     * @return 结果
     */
    public int insertGmHistorydata(GmHistorydata gmHistorydata);

    /**
     * 修改【请填写功能名称】
     * 
     * @param gmHistorydata 【请填写功能名称】
     * @return 结果
     */
    public int updateGmHistorydata(GmHistorydata gmHistorydata);

    /**
     * 删除【请填写功能名称】
     * 
     * @param hidaId 【请填写功能名称】ID
     * @return 结果
     */
    public int deleteGmHistorydataById(String hidaId);

    /**
     * 批量删除【请填写功能名称】
     * 
     * @param hidaIds 需要删除的数据ID
     * @return 结果
     */
    public int deleteGmHistorydataByIds(String[] hidaIds);

    List<GmHistorydata> getEchartsDataWithTime(String chId, String startTime, String endTime);

    List<GmHistorydata> selectAllGmHistorydataList(String chId, String startTime, String endTime);
}
