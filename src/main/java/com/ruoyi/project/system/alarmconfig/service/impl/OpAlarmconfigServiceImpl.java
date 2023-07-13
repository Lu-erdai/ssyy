package com.ruoyi.project.system.alarmconfig.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.project.system.alarmconfig.mapper.OpAlarmconfigMapper;
import com.ruoyi.project.system.alarmconfig.domain.OpAlarmconfig;
import com.ruoyi.project.system.alarmconfig.service.IOpAlarmconfigService;
import com.ruoyi.common.utils.text.Convert;

/**
 * 报警配置信息Service业务层处理
 * 
 * @author ruoyi
 * @date 2020-12-08
 */
@Service
public class OpAlarmconfigServiceImpl implements IOpAlarmconfigService 
{
    @Autowired
    private OpAlarmconfigMapper opAlarmconfigMapper;

    /**
     * 查询报警配置信息
     * 
     * @param id 报警配置信息ID
     * @return 报警配置信息
     */
    @Override
    public OpAlarmconfig selectOpAlarmconfigById(String id)
    {
        return opAlarmconfigMapper.selectOpAlarmconfigById(id);
    }

    /**
     * 查询报警配置信息列表
     * 
     * @param opAlarmconfig 报警配置信息
     * @return 报警配置信息
     */
    @Override
    public List<OpAlarmconfig> selectOpAlarmconfigList(OpAlarmconfig opAlarmconfig)
    {
        return opAlarmconfigMapper.selectOpAlarmconfigList(opAlarmconfig);
    }

    /**
     * 新增报警配置信息
     * 
     * @param opAlarmconfig 报警配置信息
     * @return 结果
     */
    @Override
    public int insertOpAlarmconfig(OpAlarmconfig opAlarmconfig)
    {
        return opAlarmconfigMapper.insertOpAlarmconfig(opAlarmconfig);
    }

    /**
     * 修改报警配置信息
     * 
     * @param opAlarmconfig 报警配置信息
     * @return 结果
     */
    @Override
    public int updateOpAlarmconfig(OpAlarmconfig opAlarmconfig)
    {
        return opAlarmconfigMapper.updateOpAlarmconfig(opAlarmconfig);
    }

    /**
     * 删除报警配置信息对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    @Override
    public int deleteOpAlarmconfigByIds(String ids)
    {
        return opAlarmconfigMapper.deleteOpAlarmconfigByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除报警配置信息信息
     * 
     * @param id 报警配置信息ID
     * @return 结果
     */
    @Override
    public int deleteOpAlarmconfigById(String id)
    {
        return opAlarmconfigMapper.deleteOpAlarmconfigById(id);
    }
}
