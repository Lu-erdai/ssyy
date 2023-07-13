package com.ruoyi.project.system.latestdata.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.project.system.latestdata.mapper.GmLatestdataMapper;
import com.ruoyi.project.system.latestdata.domain.GmLatestdata;
import com.ruoyi.project.system.latestdata.service.IGmLatestdataService;
import com.ruoyi.common.utils.text.Convert;

/**
 * 【请填写功能名称】Service业务层处理
 * 
 * @author ruoyi
 * @date 2020-11-27
 */
@Service
public class GmLatestdataServiceImpl implements IGmLatestdataService 
{
    @Autowired
    private GmLatestdataMapper gmLatestdataMapper;

    /**
     * 查询【请填写功能名称】
     * 
     * @param hidaId 【请填写功能名称】ID
     * @return 【请填写功能名称】
     */
    @Override
    public GmLatestdata selectGmLatestdataById(String hidaId)
    {
        return gmLatestdataMapper.selectGmLatestdataById(hidaId);
    }

    /**
     * 查询【请填写功能名称】列表
     * 
     * @param gmLatestdata 【请填写功能名称】
     * @return 【请填写功能名称】
     */
    @Override
    public List<GmLatestdata> selectGmLatestdataList(GmLatestdata gmLatestdata)
    {
        return gmLatestdataMapper.selectGmLatestdataList(gmLatestdata);
    }

    /**
     * 新增【请填写功能名称】
     * 
     * @param gmLatestdata 【请填写功能名称】
     * @return 结果
     */
    @Override
    public int insertGmLatestdata(GmLatestdata gmLatestdata)
    {
        return gmLatestdataMapper.insertGmLatestdata(gmLatestdata);
    }

    /**
     * 修改【请填写功能名称】
     * 
     * @param gmLatestdata 【请填写功能名称】
     * @return 结果
     */
    @Override
    public int updateGmLatestdata(GmLatestdata gmLatestdata)
    {
        return gmLatestdataMapper.updateGmLatestdata(gmLatestdata);
    }

    /**
     * 删除【请填写功能名称】对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    @Override
    public int deleteGmLatestdataByIds(String ids)
    {
        return gmLatestdataMapper.deleteGmLatestdataByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除【请填写功能名称】信息
     * 
     * @param hidaId 【请填写功能名称】ID
     * @return 结果
     */
    @Override
    public int deleteGmLatestdataById(String hidaId)
    {
        return gmLatestdataMapper.deleteGmLatestdataById(hidaId);
    }
}
