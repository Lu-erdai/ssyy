package com.ruoyi.project.system.greenhouse.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.project.system.greenhouse.mapper.ProGreenhouseMapper;
import com.ruoyi.project.system.greenhouse.domain.ProGreenhouse;
import com.ruoyi.project.system.greenhouse.service.IProGreenhouseService;
import com.ruoyi.common.utils.text.Convert;

/**
 * 【请填写功能名称】Service业务层处理
 * 
 * @author ruoyi
 * @date 2020-12-04
 */
@Service
public class ProGreenhouseServiceImpl implements IProGreenhouseService 
{
    @Autowired
    private ProGreenhouseMapper proGreenhouseMapper;

    /**
     * 查询【请填写功能名称】
     * 
     * @param greId 【请填写功能名称】ID
     * @return 【请填写功能名称】
     */
    @Override
    public ProGreenhouse selectProGreenhouseById(String greId)
    {
        return proGreenhouseMapper.selectProGreenhouseById(greId);
    }

    /**
     * 查询【请填写功能名称】列表
     * 
     * @param proGreenhouse 【请填写功能名称】
     * @return 【请填写功能名称】
     */
    @Override
    public List<ProGreenhouse> selectProGreenhouseList(ProGreenhouse proGreenhouse)
    {
        return proGreenhouseMapper.selectProGreenhouseList(proGreenhouse);
    }

    /**
     * 新增【请填写功能名称】
     * 
     * @param proGreenhouse 【请填写功能名称】
     * @return 结果
     */
    @Override
    public int insertProGreenhouse(ProGreenhouse proGreenhouse)
    {
        return proGreenhouseMapper.insertProGreenhouse(proGreenhouse);
    }

    /**
     * 修改【请填写功能名称】
     * 
     * @param proGreenhouse 【请填写功能名称】
     * @return 结果
     */
    @Override
    public int updateProGreenhouse(ProGreenhouse proGreenhouse)
    {
        return proGreenhouseMapper.updateProGreenhouse(proGreenhouse);
    }

    /**
     * 删除【请填写功能名称】对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    @Override
    public int deleteProGreenhouseByIds(String ids)
    {
        return proGreenhouseMapper.deleteProGreenhouseByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除【请填写功能名称】信息
     * 
     * @param greId 【请填写功能名称】ID
     * @return 结果
     */
    @Override
    public int deleteProGreenhouseById(String greId)
    {
        return proGreenhouseMapper.deleteProGreenhouseById(greId);
    }
}
