package com.ruoyi.project.system.skyinfo.mapper;

import java.util.List;
import com.ruoyi.project.system.skyinfo.domain.SkyInfo;

/**
 * 速客云api请求参数信息Mapper接口
 * 
 * @author ruoyi
 * @date 2023-06-03
 */
public interface SkyInfoMapper 
{
    /**
     * 查询速客云api请求参数信息
     * 
     * @param id 速客云api请求参数信息ID
     * @return 速客云api请求参数信息
     */
    public SkyInfo selectSkyInfoById(Long id);

    /**
     * 查询速客云api请求参数信息列表
     * 
     * @param skyInfo 速客云api请求参数信息
     * @return 速客云api请求参数信息集合
     */
    public List<SkyInfo> selectSkyInfoList(SkyInfo skyInfo);

    /**
     * 新增速客云api请求参数信息
     * 
     * @param skyInfo 速客云api请求参数信息
     * @return 结果
     */
    public int insertSkyInfo(SkyInfo skyInfo);

    /**
     * 修改速客云api请求参数信息
     * 
     * @param skyInfo 速客云api请求参数信息
     * @return 结果
     */
    public int updateSkyInfo(SkyInfo skyInfo);

    /**
     * 删除速客云api请求参数信息
     * 
     * @param id 速客云api请求参数信息ID
     * @return 结果
     */
    public int deleteSkyInfoById(Long id);

    /**
     * 批量删除速客云api请求参数信息
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deleteSkyInfoByIds(String[] ids);
}
