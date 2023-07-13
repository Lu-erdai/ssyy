package com.ruoyi.project.system.historydata.service;

import com.ruoyi.project.system.channel.domain.GmChannel;
import com.ruoyi.project.system.historydata.domain.GmHistorydata;

import java.util.List;

/**
 * 【请填写功能名称】Service接口
 * 
 * @author ruoyi
 * @date 2020-11-30
 */
public interface IGmHistorydataService 
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
     * 批量删除【请填写功能名称】
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deleteGmHistorydataByIds(String ids);

    /**
     * 删除【请填写功能名称】信息
     * 
     * @param hidaId 【请填写功能名称】ID
     * @return 结果
     */
    public int deleteGmHistorydataById(String hidaId);

    void selectLimit144ByCh_id(String chId);

    String getEchartsData(GmChannel channel);

    String getEchartsDataWithTime(GmChannel channel, String startTime, String endTime);


    List<GmHistorydata> selectAllGmHistorydataList(String channelId);


}
