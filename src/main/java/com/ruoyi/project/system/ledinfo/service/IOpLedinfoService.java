package com.ruoyi.project.system.ledinfo.service;

import java.util.List;
import com.ruoyi.project.system.ledinfo.domain.OpLedinfo;

/**
 * 【请填写功能名称】Service接口
 * 
 * @author ruoyi
 * @date 2020-12-07
 */
public interface IOpLedinfoService 
{
    /**
     * 查询【请填写功能名称】
     * 
     * @param ledId 【请填写功能名称】ID
     * @return 【请填写功能名称】
     */
    public OpLedinfo selectOpLedinfoById(String ledId);

    /**
     * 查询【请填写功能名称】列表
     * 
     * @param opLedinfo 【请填写功能名称】
     * @return 【请填写功能名称】集合
     */
    public List<OpLedinfo> selectOpLedinfoList(OpLedinfo opLedinfo);

    /**
     * 新增【请填写功能名称】
     * 
     * @param opLedinfo 【请填写功能名称】
     * @return 结果
     */
    public int insertOpLedinfo(OpLedinfo opLedinfo);

    /**
     * 修改【请填写功能名称】
     * 
     * @param opLedinfo 【请填写功能名称】
     * @return 结果
     */
    public int updateOpLedinfo(OpLedinfo opLedinfo);

    /**
     * 批量删除【请填写功能名称】
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deleteOpLedinfoByIds(String ids);

    /**
     * 删除【请填写功能名称】信息
     * 
     * @param ledId 【请填写功能名称】ID
     * @return 结果
     */
    public int deleteOpLedinfoById(String ledId);
}
