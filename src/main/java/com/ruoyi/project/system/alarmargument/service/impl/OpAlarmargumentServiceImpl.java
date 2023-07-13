package com.ruoyi.project.system.alarmargument.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.project.system.alarmargument.mapper.OpAlarmargumentMapper;
import com.ruoyi.project.system.alarmargument.domain.OpAlarmargument;
import com.ruoyi.project.system.alarmargument.service.IOpAlarmargumentService;
import com.ruoyi.common.utils.text.Convert;

/**
 * 报警配置参数Service业务层处理
 * 
 * @author ruoyi
 * @date 2020-12-08
 */
@Service
public class OpAlarmargumentServiceImpl implements IOpAlarmargumentService 
{
    @Autowired
    private OpAlarmargumentMapper opAlarmargumentMapper;

    /**
     * 查询报警配置参数
     * 
     * @param id 报警配置参数ID
     * @return 报警配置参数
     */
    @Override
    public OpAlarmargument selectOpAlarmargumentById(String id)
    {
        return opAlarmargumentMapper.selectOpAlarmargumentById(id);
    }

    /**
     * 查询报警配置参数列表
     * 
     * @param opAlarmargument 报警配置参数
     * @return 报警配置参数
     */
    @Override
    public List<OpAlarmargument> selectOpAlarmargumentList(OpAlarmargument opAlarmargument)
    {
        return opAlarmargumentMapper.selectOpAlarmargumentList(opAlarmargument);
    }

    /**
     * 新增报警配置参数
     * 
     * @param opAlarmargument 报警配置参数
     * @return 结果
     */
    @Override
    public int insertOpAlarmargument(OpAlarmargument opAlarmargument)
    {
        return opAlarmargumentMapper.insertOpAlarmargument(opAlarmargument);
    }

    /**
     * 修改报警配置参数
     * 
     * @param opAlarmargument 报警配置参数
     * @return 结果
     */
    @Override
    public int updateOpAlarmargument(OpAlarmargument opAlarmargument)
    {
        return opAlarmargumentMapper.updateOpAlarmargument(opAlarmargument);
    }

    /**
     * 删除报警配置参数对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    @Override
    public int deleteOpAlarmargumentByIds(String ids)
    {
        return opAlarmargumentMapper.deleteOpAlarmargumentByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除报警配置参数信息
     * 
     * @param id 报警配置参数ID
     * @return 结果
     */
    @Override
    public int deleteOpAlarmargumentById(String id)
    {
        return opAlarmargumentMapper.deleteOpAlarmargumentById(id);
    }
}
