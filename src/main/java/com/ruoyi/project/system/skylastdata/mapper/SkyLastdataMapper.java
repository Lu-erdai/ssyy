package com.ruoyi.project.system.skylastdata.mapper;

import java.util.List;
import com.ruoyi.project.system.skylastdata.domain.SkyLastdata;

/**
 * 速控云最新数据Mapper接口
 * 
 * @author ruoyi
 * @date 2023-06-03
 */
public interface SkyLastdataMapper 
{
    /**
     * 查询速控云最新数据
     * 
     * @param id 速控云最新数据ID
     * @return 速控云最新数据
     */
    public SkyLastdata selectSkyLastdataById(Long id);

    /**
     * 查询速控云最新数据列表
     * 
     * @param skyLastdata 速控云最新数据
     * @return 速控云最新数据集合
     */
    public List<SkyLastdata> selectSkyLastdataList(SkyLastdata skyLastdata);

    /**
     * 新增速控云最新数据
     * 
     * @param skyLastdata 速控云最新数据
     * @return 结果
     */
    public int insertSkyLastdata(SkyLastdata skyLastdata);

    /**
     * 修改速控云最新数据
     * 
     * @param skyLastdata 速控云最新数据
     * @return 结果
     */
    public int updateSkyLastdata(SkyLastdata skyLastdata);

    /**
     * 删除速控云最新数据
     * 
     * @param id 速控云最新数据ID
     * @return 结果
     */
    public int deleteSkyLastdataById(Long id);

    /**
     * 批量删除速控云最新数据
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deleteSkyLastdataByIds(String[] ids);
}
