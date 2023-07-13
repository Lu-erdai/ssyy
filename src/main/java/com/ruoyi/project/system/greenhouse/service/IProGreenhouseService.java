package com.ruoyi.project.system.greenhouse.service;

import java.util.List;
import com.ruoyi.project.system.greenhouse.domain.ProGreenhouse;

/**
 * 【请填写功能名称】Service接口
 * 
 * @author ruoyi
 * @date 2020-12-04
 */
public interface IProGreenhouseService 
{
    /**
     * 查询【请填写功能名称】
     * 
     * @param greId 【请填写功能名称】ID
     * @return 【请填写功能名称】
     */
    public ProGreenhouse selectProGreenhouseById(String greId);

    /**
     * 查询【请填写功能名称】列表
     * 
     * @param proGreenhouse 【请填写功能名称】
     * @return 【请填写功能名称】集合
     */
    public List<ProGreenhouse> selectProGreenhouseList(ProGreenhouse proGreenhouse);

    /**
     * 新增【请填写功能名称】
     * 
     * @param proGreenhouse 【请填写功能名称】
     * @return 结果
     */
    public int insertProGreenhouse(ProGreenhouse proGreenhouse);

    /**
     * 修改【请填写功能名称】
     * 
     * @param proGreenhouse 【请填写功能名称】
     * @return 结果
     */
    public int updateProGreenhouse(ProGreenhouse proGreenhouse);

    /**
     * 批量删除【请填写功能名称】
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deleteProGreenhouseByIds(String ids);

    /**
     * 删除【请填写功能名称】信息
     * 
     * @param greId 【请填写功能名称】ID
     * @return 结果
     */
    public int deleteProGreenhouseById(String greId);
}
