package com.ruoyi.project.system.skylastdata.service.impl;

import java.util.List;
import com.ruoyi.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.project.system.skylastdata.mapper.SkyLastdataMapper;
import com.ruoyi.project.system.skylastdata.domain.SkyLastdata;
import com.ruoyi.project.system.skylastdata.service.ISkyLastdataService;
import com.ruoyi.common.utils.text.Convert;

/**
 * 速控云最新数据Service业务层处理
 * 
 * @author ruoyi
 * @date 2023-06-03
 */
@Service
public class SkyLastdataServiceImpl implements ISkyLastdataService 
{
    @Autowired
    private SkyLastdataMapper skyLastdataMapper;

    /**
     * 查询速控云最新数据
     * 
     * @param id 速控云最新数据ID
     * @return 速控云最新数据
     */
    @Override
    public SkyLastdata selectSkyLastdataById(Long id)
    {
        return skyLastdataMapper.selectSkyLastdataById(id);
    }

    /**
     * 查询速控云最新数据列表
     * 
     * @param skyLastdata 速控云最新数据
     * @return 速控云最新数据
     */
    @Override
    public List<SkyLastdata> selectSkyLastdataList(SkyLastdata skyLastdata)
    {
        return skyLastdataMapper.selectSkyLastdataList(skyLastdata);
    }

    /**
     * 新增速控云最新数据
     * 
     * @param skyLastdata 速控云最新数据
     * @return 结果
     */
    @Override
    public int insertSkyLastdata(SkyLastdata skyLastdata)
    {
        return skyLastdataMapper.insertSkyLastdata(skyLastdata);
    }

    /**
     * 修改速控云最新数据
     * 
     * @param skyLastdata 速控云最新数据
     * @return 结果
     */
    @Override
    public int updateSkyLastdata(SkyLastdata skyLastdata)
    {
        skyLastdata.setUpdateTime(DateUtils.getNowDate());
        return skyLastdataMapper.updateSkyLastdata(skyLastdata);
    }

    /**
     * 删除速控云最新数据对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    @Override
    public int deleteSkyLastdataByIds(String ids)
    {
        return skyLastdataMapper.deleteSkyLastdataByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除速控云最新数据信息
     * 
     * @param id 速控云最新数据ID
     * @return 结果
     */
    @Override
    public int deleteSkyLastdataById(Long id)
    {
        return skyLastdataMapper.deleteSkyLastdataById(id);
    }
}
