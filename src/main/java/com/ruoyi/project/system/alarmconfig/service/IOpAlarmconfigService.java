package com.ruoyi.project.system.alarmconfig.service;

import java.util.List;
import com.ruoyi.project.system.alarmconfig.domain.OpAlarmconfig;

/**
 * 报警配置信息Service接口
 * 
 * @author ruoyi
 * @date 2020-12-08
 */
public interface IOpAlarmconfigService 
{
    /**
     * 查询报警配置信息
     * 
     * @param id 报警配置信息ID
     * @return 报警配置信息
     */
    public OpAlarmconfig selectOpAlarmconfigById(String id);

    /**
     * 查询报警配置信息列表
     * 
     * @param opAlarmconfig 报警配置信息
     * @return 报警配置信息集合
     */
    public List<OpAlarmconfig> selectOpAlarmconfigList(OpAlarmconfig opAlarmconfig);

    /**
     * 新增报警配置信息
     * 
     * @param opAlarmconfig 报警配置信息
     * @return 结果
     */
    public int insertOpAlarmconfig(OpAlarmconfig opAlarmconfig);

    /**
     * 修改报警配置信息
     * 
     * @param opAlarmconfig 报警配置信息
     * @return 结果
     */
    public int updateOpAlarmconfig(OpAlarmconfig opAlarmconfig);

    /**
     * 批量删除报警配置信息
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deleteOpAlarmconfigByIds(String ids);

    /**
     * 删除报警配置信息信息
     * 
     * @param id 报警配置信息ID
     * @return 结果
     */
    public int deleteOpAlarmconfigById(String id);
}
