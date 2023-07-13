package com.ruoyi.project.system.skyboxval.mapper;

import java.util.List;
import com.ruoyi.project.system.skyboxval.domain.SkyBoxval;

/**
 * 速客云变量参数Mapper接口
 * 
 * @author ruoyi
 * @date 2023-06-03
 */
public interface SkyBoxvalMapper 
{
    /**
     * 查询速客云变量参数
     * 
     * @param id 速客云变量参数ID
     * @return 速客云变量参数
     */
    public SkyBoxval selectSkyBoxvalById(Long id);

    /**
     * 查询速客云变量参数列表
     * 
     * @param skyBoxval 速客云变量参数
     * @return 速客云变量参数集合
     */
    public List<SkyBoxval> selectSkyBoxvalList(SkyBoxval skyBoxval);

    /**
     * 新增速客云变量参数
     * 
     * @param skyBoxval 速客云变量参数
     * @return 结果
     */
    public int insertSkyBoxval(SkyBoxval skyBoxval);

    /**
     * 修改速客云变量参数
     * 
     * @param skyBoxval 速客云变量参数
     * @return 结果
     */
    public int updateSkyBoxval(SkyBoxval skyBoxval);

    /**
     * 删除速客云变量参数
     * 
     * @param id 速客云变量参数ID
     * @return 结果
     */
    public int deleteSkyBoxvalById(Long id);

    /**
     * 批量删除速客云变量参数
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deleteSkyBoxvalByIds(String[] ids);
}
