package com.ruoyi.project.system.htzkhistorydata.mapper;

import com.ruoyi.project.system.htzkhistorydata.domain.GmHtzkHistorydata;

import java.util.List;

/**
 * wuMapper接口
 * 
 * @author ruoyi
 * @date 2020-12-31
 */
public interface GmHtzkHistorydataMapper 
{
    /**
     * 查询wu
     * 
     * @param id wuID
     * @return wu
     */
    public GmHtzkHistorydata selectGmHtzkHistorydataById(Long id);

    /**
     * 查询wu列表
     * 
     * @param gmHtzkHistorydata wu
     * @return wu集合
     */
    public List<GmHtzkHistorydata> selectGmHtzkHistorydataList(GmHtzkHistorydata gmHtzkHistorydata);



    public List<GmHtzkHistorydata> selectHtzkHisDateBySNCodeLimit50(String gatewaySN,String code);

    /**
     * 新增wu
     * 
     * @param gmHtzkHistorydata wu
     * @return 结果
     */
    public int insertGmHtzkHistorydata(GmHtzkHistorydata gmHtzkHistorydata);

    /**
     * 修改wu
     * 
     * @param gmHtzkHistorydata wu
     * @return 结果
     */
    public int updateGmHtzkHistorydata(GmHtzkHistorydata gmHtzkHistorydata);

    /**
     * 删除wu
     * 
     * @param id wuID
     * @return 结果
     */
    public int deleteGmHtzkHistorydataById(Long id);

    /**
     * 批量删除wu
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deleteGmHtzkHistorydataByIds(String[] ids);
}
