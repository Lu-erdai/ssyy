package com.ruoyi.project.system.htzklastdata.service;

import com.ruoyi.project.system.htzklastdata.domain.GmHtzkLastdata;

import java.util.List;

/**
 * aaService接口
 * 
 * @author ruoyi
 * @date 2021-01-04
 */
public interface IGmHtzkLastdataService 
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


    public List<GmHtzkLastdata> selectAllLastData();

    public List<GmHtzkLastdata> selectAllLastDataBySNCode(String gatewaySN, String code);


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
     * 批量删除aa
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deleteGmHtzkLastdataByIds(String ids);

    /**
     * 删除aa信息
     * 
     * @param id aaID
     * @return 结果
     */
    public int deleteGmHtzkLastdataById(Long id);
}
