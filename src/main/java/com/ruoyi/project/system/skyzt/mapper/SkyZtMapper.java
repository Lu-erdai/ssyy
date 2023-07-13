package com.ruoyi.project.system.skyzt.mapper;

import java.util.List;
import com.ruoyi.project.system.skyzt.domain.SkyZt;

/**
 * 速控云组态链接Mapper接口
 * 
 * @author ruoyi
 * @date 2023-06-28
 */
public interface SkyZtMapper 
{
    /**
     * 查询速控云组态链接
     * 
     * @param id 速控云组态链接ID
     * @return 速控云组态链接
     */
    public SkyZt selectSkyZtById(Long id);

    /**
     * 查询速控云组态链接列表
     * 
     * @param skyZt 速控云组态链接
     * @return 速控云组态链接集合
     */
    public List<SkyZt> selectSkyZtList(SkyZt skyZt);

    /**
     * 新增速控云组态链接
     * 
     * @param skyZt 速控云组态链接
     * @return 结果
     */
    public int insertSkyZt(SkyZt skyZt);

    /**
     * 修改速控云组态链接
     * 
     * @param skyZt 速控云组态链接
     * @return 结果
     */
    public int updateSkyZt(SkyZt skyZt);

    /**
     * 删除速控云组态链接
     * 
     * @param id 速控云组态链接ID
     * @return 结果
     */
    public int deleteSkyZtById(Long id);

    /**
     * 批量删除速控云组态链接
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deleteSkyZtByIds(String[] ids);
}
