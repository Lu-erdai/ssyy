package com.ruoyi.project.system.msgmonitor.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.project.system.msgmonitor.mapper.OpMsgmonitorMapper;
import com.ruoyi.project.system.msgmonitor.domain.OpMsgmonitor;
import com.ruoyi.project.system.msgmonitor.service.IOpMsgmonitorService;
import com.ruoyi.common.utils.text.Convert;

/**
 * 短信监控配置信息Service业务层处理
 * 
 * @author ruoyi
 * @date 2020-12-07
 */
@Service
public class OpMsgmonitorServiceImpl implements IOpMsgmonitorService 
{
    @Autowired
    private OpMsgmonitorMapper opMsgmonitorMapper;

    /**
     * 查询短信监控配置信息
     * 
     * @param mesId 短信监控配置信息ID
     * @return 短信监控配置信息
     */
    @Override
    public OpMsgmonitor selectOpMsgmonitorById(String mesId)
    {
        return opMsgmonitorMapper.selectOpMsgmonitorById(mesId);
    }

    /**
     * 查询短信监控配置信息列表
     * 
     * @param opMsgmonitor 短信监控配置信息
     * @return 短信监控配置信息
     */
    @Override
    public List<OpMsgmonitor> selectOpMsgmonitorList(OpMsgmonitor opMsgmonitor)
    {
        return opMsgmonitorMapper.selectOpMsgmonitorList(opMsgmonitor);
    }

    /**
     * 新增短信监控配置信息
     * 
     * @param opMsgmonitor 短信监控配置信息
     * @return 结果
     */
    @Override
    public int insertOpMsgmonitor(OpMsgmonitor opMsgmonitor)
    {
        return opMsgmonitorMapper.insertOpMsgmonitor(opMsgmonitor);
    }

    /**
     * 修改短信监控配置信息
     * 
     * @param opMsgmonitor 短信监控配置信息
     * @return 结果
     */
    @Override
    public int updateOpMsgmonitor(OpMsgmonitor opMsgmonitor)
    {
        return opMsgmonitorMapper.updateOpMsgmonitor(opMsgmonitor);
    }

    /**
     * 删除短信监控配置信息对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    @Override
    public int deleteOpMsgmonitorByIds(String ids)
    {
        return opMsgmonitorMapper.deleteOpMsgmonitorByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除短信监控配置信息信息
     * 
     * @param mesId 短信监控配置信息ID
     * @return 结果
     */
    @Override
    public int deleteOpMsgmonitorById(String mesId)
    {
        return opMsgmonitorMapper.deleteOpMsgmonitorById(mesId);
    }
}
