package com.ruoyi.project.system.latestdata.mapper;

import java.util.List;
import com.ruoyi.project.system.latestdata.domain.GmLatestdata;

/**
 * 【请填写功能名称】Mapper接口
 * 
 * @author ruoyi
 * @date 2020-11-27
 */
public interface GmLatestdataMapper 
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
     * 删除【请填写功能名称】
     * 
     * @param hidaId 【请填写功能名称】ID
     * @return 结果
     */
    public int deleteGmLatestdataById(String hidaId);

    /**
     * 批量删除【请填写功能名称】
     * 
     * @param hidaIds 需要删除的数据ID
     * @return 结果
     */
    public int deleteGmLatestdataByIds(String[] hidaIds);
}
