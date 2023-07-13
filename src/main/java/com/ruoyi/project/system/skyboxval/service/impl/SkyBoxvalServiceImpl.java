package com.ruoyi.project.system.skyboxval.service.impl;

import com.ruoyi.common.utils.DateUtils;
import com.ruoyi.common.utils.text.Convert;
import com.ruoyi.project.system.skyboxval.domain.SkyBoxval;
import com.ruoyi.project.system.skyboxval.mapper.SkyBoxvalMapper;
import com.ruoyi.project.system.skyboxval.service.ISkyBoxvalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 速客云变量参数Service业务层处理
 * 
 * @author ruoyi
 * @date 2023-06-03
 */
@Service
public class SkyBoxvalServiceImpl implements ISkyBoxvalService 
{
    @Autowired
    private SkyBoxvalMapper skyBoxvalMapper;

    /**
     * 查询速客云变量参数
     * 
     * @param id 速客云变量参数ID
     * @return 速客云变量参数
     */
    @Override
    public SkyBoxval selectSkyBoxvalById(Long id)
    {
        return skyBoxvalMapper.selectSkyBoxvalById(id);
    }

    /**
     * 查询速客云变量参数列表
     * 
     * @param skyBoxval 速客云变量参数
     * @return 速客云变量参数
     */
    @Override
    public List<SkyBoxval> selectSkyBoxvalList(SkyBoxval skyBoxval)
    {
        return skyBoxvalMapper.selectSkyBoxvalList(skyBoxval);
    }

    /**
     * 新增速客云变量参数
     * 
     * @param skyBoxval 速客云变量参数
     * @return 结果
     */
    @Override
    public int insertSkyBoxval(SkyBoxval skyBoxval)
    {
        return skyBoxvalMapper.insertSkyBoxval(skyBoxval);
    }

    /**
     * 修改速客云变量参数
     * 
     * @param skyBoxval 速客云变量参数
     * @return 结果
     */
    @Override
    public int updateSkyBoxval(SkyBoxval skyBoxval)
    {
        skyBoxval.setUpdateTime(DateUtils.getNowDate());
        return skyBoxvalMapper.updateSkyBoxval(skyBoxval);
    }

    /**
     * 删除速客云变量参数对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    @Override
    public int deleteSkyBoxvalByIds(String ids)
    {
        return skyBoxvalMapper.deleteSkyBoxvalByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除速客云变量参数信息
     * 
     * @param id 速客云变量参数ID
     * @return 结果
     */
    @Override
    public int deleteSkyBoxvalById(Long id)
    {
        return skyBoxvalMapper.deleteSkyBoxvalById(id);
    }
}
