package com.ruoyi.project.system.htzkhistorydata.service.impl;

import com.ruoyi.common.utils.text.Convert;
import com.ruoyi.project.system.htzkhistorydata.domain.GmHtzkHistorydata;
import com.ruoyi.project.system.htzkhistorydata.mapper.GmHtzkHistorydataMapper;
import com.ruoyi.project.system.htzkhistorydata.service.IGmHtzkHistorydataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * wuService业务层处理
 * 
 * @author ruoyi
 * @date 2020-12-31
 */
@Service
public class GmHtzkHistorydataServiceImpl implements IGmHtzkHistorydataService 
{
    @Autowired
    private GmHtzkHistorydataMapper gmHtzkHistorydataMapper;

    /**
     * 查询wu
     * 
     * @param id wuID
     * @return wu
     */
    @Override
    public GmHtzkHistorydata selectGmHtzkHistorydataById(Long id)
    {
        return gmHtzkHistorydataMapper.selectGmHtzkHistorydataById(id);
    }

    /**
     * 查询wu列表
     * 
     * @param gmHtzkHistorydata wu
     * @return wu
     */
    @Override
    public List<GmHtzkHistorydata> selectGmHtzkHistorydataList(GmHtzkHistorydata gmHtzkHistorydata)
    {
        return gmHtzkHistorydataMapper.selectGmHtzkHistorydataList(gmHtzkHistorydata);
    }




    @Override
    public List<GmHtzkHistorydata> selectHtzkHisDateBySNCodeLimit50(String gatewaySN, String code) {
        return gmHtzkHistorydataMapper.selectHtzkHisDateBySNCodeLimit50(gatewaySN,code);
    }

    /**
     * 新增wu
     * 
     * @param gmHtzkHistorydata wu
     * @return 结果
     */
    @Override
    public int insertGmHtzkHistorydata(GmHtzkHistorydata gmHtzkHistorydata)
    {
        return gmHtzkHistorydataMapper.insertGmHtzkHistorydata(gmHtzkHistorydata);
    }

    /**
     * 修改wu
     * 
     * @param gmHtzkHistorydata wu
     * @return 结果
     */
    @Override
    public int updateGmHtzkHistorydata(GmHtzkHistorydata gmHtzkHistorydata)
    {
        return gmHtzkHistorydataMapper.updateGmHtzkHistorydata(gmHtzkHistorydata);
    }

    /**
     * 删除wu对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    @Override
    public int deleteGmHtzkHistorydataByIds(String ids)
    {
        return gmHtzkHistorydataMapper.deleteGmHtzkHistorydataByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除wu信息
     * 
     * @param id wuID
     * @return 结果
     */
    @Override
    public int deleteGmHtzkHistorydataById(Long id)
    {
        return gmHtzkHistorydataMapper.deleteGmHtzkHistorydataById(id);
    }
}
