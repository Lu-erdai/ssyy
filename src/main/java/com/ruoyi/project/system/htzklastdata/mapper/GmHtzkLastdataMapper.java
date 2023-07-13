package com.ruoyi.project.system.htzklastdata.mapper;

import com.ruoyi.project.system.htzklastdata.domain.GmHtzkLastdata;

import java.util.List;

/**
 * aaMapper接口
 * 
 * @author ruoyi
 * @date 2021-01-04
 */
public interface GmHtzkLastdataMapper 
{
    /**
     * 查询aa
     * 
     * @param id aaID
     * @return aa
     */
    public GmHtzkLastdata selectGmHtzkLastdataById(Long id);

    /**
     * 查询aa列表
     * 
     * @param gmHtzkLastdata aa
     * @return aa集合
     */
    public List<GmHtzkLastdata> selectGmHtzkLastdataList(GmHtzkLastdata gmHtzkLastdata);

    /**
     * 新增aa
     * 
     * @param gmHtzkLastdata aa
     * @return 结果
     */
    public int insertGmHtzkLastdata(GmHtzkLastdata gmHtzkLastdata);

    /**
     * 修改aa
     * 
     * @param gmHtzkLastdata aa
     * @return 结果
     */
    public int updateGmHtzkLastdata(GmHtzkLastdata gmHtzkLastdata);

    /**
     * 删除aa
     * 
     * @param id aaID
     * @return 结果
     */
    public int deleteGmHtzkLastdataById(Long id);

    /**
     * 批量删除aa
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deleteGmHtzkLastdataByIds(String[] ids);

    List<GmHtzkLastdata> selectAllLastData();

    List<GmHtzkLastdata> selectAllLastDataBySNCode(String gatewaySN, String code);
}
