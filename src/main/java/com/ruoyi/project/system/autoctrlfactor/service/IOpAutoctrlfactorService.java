package com.ruoyi.project.system.autoctrlfactor.service;

import java.util.List;
import com.ruoyi.project.system.autoctrlfactor.domain.OpAutoctrlfactor;

/**
 * 自动控制配置条件Service接口
 * 
 * @author ruoyi
 * @date 2020-12-08
 */
public interface IOpAutoctrlfactorService 
{
    /**
     * 查询自动控制配置条件
     * 
     * @param acfId 自动控制配置条件ID
     * @return 自动控制配置条件
     */
    public OpAutoctrlfactor selectOpAutoctrlfactorById(Long acfId);

    /**
     * 查询自动控制配置条件列表
     * 
     * @param opAutoctrlfactor 自动控制配置条件
     * @return 自动控制配置条件集合
     */
    public List<OpAutoctrlfactor> selectOpAutoctrlfactorList(OpAutoctrlfactor opAutoctrlfactor);

    /**
     * 新增自动控制配置条件
     * 
     * @param opAutoctrlfactor 自动控制配置条件
     * @return 结果
     */
    public int insertOpAutoctrlfactor(OpAutoctrlfactor opAutoctrlfactor);

    /**
     * 修改自动控制配置条件
     * 
     * @param opAutoctrlfactor 自动控制配置条件
     * @return 结果
     */
    public int updateOpAutoctrlfactor(OpAutoctrlfactor opAutoctrlfactor);

    /**
     * 批量删除自动控制配置条件
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deleteOpAutoctrlfactorByIds(String ids);

    /**
     * 删除自动控制配置条件信息
     * 
     * @param acfId 自动控制配置条件ID
     * @return 结果
     */
    public int deleteOpAutoctrlfactorById(Long acfId);
}
