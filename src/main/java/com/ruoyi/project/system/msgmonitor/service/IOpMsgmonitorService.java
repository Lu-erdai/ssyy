package com.ruoyi.project.system.msgmonitor.service;

import java.util.List;
import com.ruoyi.project.system.msgmonitor.domain.OpMsgmonitor;

/**
 * 短信监控配置信息Service接口
 * 
 * @author ruoyi
 * @date 2020-12-07
 */
public interface IOpMsgmonitorService 
{
    /**
     * 查询短信监控配置信息
     * 
     * @param mesId 短信监控配置信息ID
     * @return 短信监控配置信息
     */
    public OpMsgmonitor selectOpMsgmonitorById(String mesId);

    /**
     * 查询短信监控配置信息列表
     * 
     * @param opMsgmonitor 短信监控配置信息
     * @return 短信监控配置信息集合
     */
    public List<OpMsgmonitor> selectOpMsgmonitorList(OpMsgmonitor opMsgmonitor);

    /**
     * 新增短信监控配置信息
     * 
     * @param opMsgmonitor 短信监控配置信息
     * @return 结果
     */
    public int insertOpMsgmonitor(OpMsgmonitor opMsgmonitor);

    /**
     * 修改短信监控配置信息
     * 
     * @param opMsgmonitor 短信监控配置信息
     * @return 结果
     */
    public int updateOpMsgmonitor(OpMsgmonitor opMsgmonitor);

    /**
     * 批量删除短信监控配置信息
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deleteOpMsgmonitorByIds(String ids);

    /**
     * 删除短信监控配置信息信息
     * 
     * @param mesId 短信监控配置信息ID
     * @return 结果
     */
    public int deleteOpMsgmonitorById(String mesId);
}
