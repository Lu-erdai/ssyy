package com.ruoyi.project.system.alarmargument.mapper;

import java.util.List;
import com.ruoyi.project.system.alarmargument.domain.OpAlarmargument;

/**
 * 报警配置参数Mapper接口
 * 
 * @author ruoyi
 * @date 2020-12-08
 */
public interface OpAlarmargumentMapper 
{
    /**
     * 查询报警配置参数
     * 
     * @param id 报警配置参数ID
     * @return 报警配置参数
     */
    public OpAlarmargument selectOpAlarmargumentById(String id);

    /**
     * 查询报警配置参数列表
     * 
     * @param opAlarmargument 报警配置参数
     * @return 报警配置参数集合
     */
    public List<OpAlarmargument> selectOpAlarmargumentList(OpAlarmargument opAlarmargument);

    /**
     * 新增报警配置参数
     * 
     * @param opAlarmargument 报警配置参数
     * @return 结果
     */
    public int insertOpAlarmargument(OpAlarmargument opAlarmargument);

    /**
     * 修改报警配置参数
     * 
     * @param opAlarmargument 报警配置参数
     * @return 结果
     */
    public int updateOpAlarmargument(OpAlarmargument opAlarmargument);

    /**
     * 删除报警配置参数
     * 
     * @param id 报警配置参数ID
     * @return 结果
     */
    public int deleteOpAlarmargumentById(String id);

    /**
     * 批量删除报警配置参数
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deleteOpAlarmargumentByIds(String[] ids);
}
