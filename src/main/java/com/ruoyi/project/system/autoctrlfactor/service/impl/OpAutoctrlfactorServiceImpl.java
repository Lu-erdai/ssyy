package com.ruoyi.project.system.autoctrlfactor.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.project.system.autoctrlfactor.mapper.OpAutoctrlfactorMapper;
import com.ruoyi.project.system.autoctrlfactor.domain.OpAutoctrlfactor;
import com.ruoyi.project.system.autoctrlfactor.service.IOpAutoctrlfactorService;
import com.ruoyi.common.utils.text.Convert;

/**
 * 自动控制配置条件Service业务层处理
 * 
 * @author ruoyi
 * @date 2020-12-08
 */
@Service
public class OpAutoctrlfactorServiceImpl implements IOpAutoctrlfactorService 
{
    @Autowired
    private OpAutoctrlfactorMapper opAutoctrlfactorMapper;

    /**
     * 查询自动控制配置条件
     * 
     * @param acfId 自动控制配置条件ID
     * @return 自动控制配置条件
     */
    @Override
    public OpAutoctrlfactor selectOpAutoctrlfactorById(Long acfId)
    {
        return opAutoctrlfactorMapper.selectOpAutoctrlfactorById(acfId);
    }

    /**
     * 查询自动控制配置条件列表
     * 
     * @param opAutoctrlfactor 自动控制配置条件
     * @return 自动控制配置条件
     */
    @Override
    public List<OpAutoctrlfactor> selectOpAutoctrlfactorList(OpAutoctrlfactor opAutoctrlfactor)
    {
        return opAutoctrlfactorMapper.selectOpAutoctrlfactorList(opAutoctrlfactor);
    }

    /**
     * 新增自动控制配置条件
     * 
     * @param opAutoctrlfactor 自动控制配置条件
     * @return 结果
     */
    @Override
    public int insertOpAutoctrlfactor(OpAutoctrlfactor opAutoctrlfactor)
    {
        return opAutoctrlfactorMapper.insertOpAutoctrlfactor(opAutoctrlfactor);
    }

    /**
     * 修改自动控制配置条件
     * 
     * @param opAutoctrlfactor 自动控制配置条件
     * @return 结果
     */
    @Override
    public int updateOpAutoctrlfactor(OpAutoctrlfactor opAutoctrlfactor)
    {
        return opAutoctrlfactorMapper.updateOpAutoctrlfactor(opAutoctrlfactor);
    }

    /**
     * 删除自动控制配置条件对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    @Override
    public int deleteOpAutoctrlfactorByIds(String ids)
    {
        return opAutoctrlfactorMapper.deleteOpAutoctrlfactorByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除自动控制配置条件信息
     * 
     * @param acfId 自动控制配置条件ID
     * @return 结果
     */
    @Override
    public int deleteOpAutoctrlfactorById(Long acfId)
    {
        return opAutoctrlfactorMapper.deleteOpAutoctrlfactorById(acfId);
    }
}
