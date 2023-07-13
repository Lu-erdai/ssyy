package com.ruoyi.project.system.skyinfo.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.project.system.skyinfo.mapper.SkyInfoMapper;
import com.ruoyi.project.system.skyinfo.domain.SkyInfo;
import com.ruoyi.project.system.skyinfo.service.ISkyInfoService;
import com.ruoyi.common.utils.text.Convert;

/**
 * 速客云api请求参数信息Service业务层处理
 * 
 * @author ruoyi
 * @date 2023-06-03
 */
@Service
public class SkyInfoServiceImpl implements ISkyInfoService 
{
    @Autowired
    private SkyInfoMapper skyInfoMapper;

    /**
     * 查询速客云api请求参数信息
     * 
     * @param id 速客云api请求参数信息ID
     * @return 速客云api请求参数信息
     */
    @Override
    public SkyInfo selectSkyInfoById(Long id)
    {
        return skyInfoMapper.selectSkyInfoById(id);
    }

    /**
     * 查询速客云api请求参数信息列表
     * 
     * @param skyInfo 速客云api请求参数信息
     * @return 速客云api请求参数信息
     */
    @Override
    public List<SkyInfo> selectSkyInfoList(SkyInfo skyInfo)
    {
        return skyInfoMapper.selectSkyInfoList(skyInfo);
    }

    /**
     * 新增速客云api请求参数信息
     * 
     * @param skyInfo 速客云api请求参数信息
     * @return 结果
     */
    @Override
    public int insertSkyInfo(SkyInfo skyInfo)
    {
        return skyInfoMapper.insertSkyInfo(skyInfo);
    }

    /**
     * 修改速客云api请求参数信息
     * 
     * @param skyInfo 速客云api请求参数信息
     * @return 结果
     */
    @Override
    public int updateSkyInfo(SkyInfo skyInfo)
    {
        return skyInfoMapper.updateSkyInfo(skyInfo);
    }

    /**
     * 删除速客云api请求参数信息对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    @Override
    public int deleteSkyInfoByIds(String ids)
    {
        return skyInfoMapper.deleteSkyInfoByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除速客云api请求参数信息信息
     * 
     * @param id 速客云api请求参数信息ID
     * @return 结果
     */
    @Override
    public int deleteSkyInfoById(Long id)
    {
        return skyInfoMapper.deleteSkyInfoById(id);
    }
}
