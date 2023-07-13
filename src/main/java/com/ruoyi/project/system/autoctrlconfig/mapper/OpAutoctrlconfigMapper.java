package com.ruoyi.project.system.autoctrlconfig.mapper;

import com.ruoyi.project.system.autoctrlconfig.domain.OpAutoctrlconfig;
import com.ruoyi.project.system.vo.AutoConfigVO;

import java.util.List;

/**
 * 自动控制配置Mapper接口
 * 
 * @author ruoyi
 * @date 2020-12-08
 */
public interface OpAutoctrlconfigMapper 
{
    /**
     * 查询自动控制配置
     * 
     * @param accId 自动控制配置ID
     * @return 自动控制配置
     */
    public OpAutoctrlconfig selectOpAutoctrlconfigById(Long accId);

    /**
     * 查询自动控制配置列表
     * 
     * @param opAutoctrlconfig 自动控制配置
     * @return 自动控制配置集合
     */
    public List<OpAutoctrlconfig> selectOpAutoctrlconfigList(OpAutoctrlconfig opAutoctrlconfig);

    /**
     * 新增自动控制配置
     * 
     * @param opAutoctrlconfig 自动控制配置
     * @return 结果
     */
    public int insertOpAutoctrlconfig(OpAutoctrlconfig opAutoctrlconfig);

    /**
     * 修改自动控制配置
     * 
     * @param opAutoctrlconfig 自动控制配置
     * @return 结果
     */
    public int updateOpAutoctrlconfig(OpAutoctrlconfig opAutoctrlconfig);

    /**
     * 删除自动控制配置
     * 
     * @param accId 自动控制配置ID
     * @return 结果
     */
    public int deleteOpAutoctrlconfigById(Long accId);

    /**
     * 批量删除自动控制配置
     * 
     * @param accIds 需要删除的数据ID
     * @return 结果
     */
    public int deleteOpAutoctrlconfigByIds(String[] accIds);

    List<AutoConfigVO> selectAutoConfigVOList(String sceneId);
}
