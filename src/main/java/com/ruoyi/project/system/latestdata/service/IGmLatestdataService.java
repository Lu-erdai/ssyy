package com.ruoyi.project.system.latestdata.service;

import com.ruoyi.project.system.latestdata.domain.GmLatestdata;

import java.util.List;

/**
 * 【请填写功能名称】Service接口
 * 
 * @author ruoyi
 * @date 2020-11-27
 */
public interface IGmLatestdataService 
{
    /**
     * 查询【请填写功能名称】
     * 
     * @param hidaId 【请填写功能名称】ID
     * @return 【请填写功能名称】
     */
    public GmLatestdata selectGmLatestdataById(String hidaId);

    /**
     * 查询【请填写功能名称】列表
     * 
     * @param gmLatestdata 【请填写功能名称】
     * @return 【请填写功能名称】集合
     */
    public List<GmLatestdata> selectGmLatestdataList(GmLatestdata gmLatestdata);

    /**
     * 新增【请填写功能名称】
     * 
     * @param gmLatestdata 【请填写功能名称】
     * @return 结果
     */
    public int insertGmLatestdata(GmLatestdata gmLatestdata);

    /**
     * 修改【请填写功能名称】
     * 
     * @param gmLatestdata 【请填写功能名称】
     * @return 结果
     */
    public int updateGmLatestdata(GmLatestdata gmLatestdata);

    /**
     * 批量删除【请填写功能名称】
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deleteGmLatestdataByIds(String ids);

    /**
     * 删除【请填写功能名称】信息
     * 
     * @param hidaId 【请填写功能名称】ID
     * @return 结果
     */
    public int deleteGmLatestdataById(String hidaId);





}
