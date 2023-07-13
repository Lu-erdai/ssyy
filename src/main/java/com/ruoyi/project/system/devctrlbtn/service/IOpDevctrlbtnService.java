package com.ruoyi.project.system.devctrlbtn.service;

import java.util.List;
import com.ruoyi.project.system.devctrlbtn.domain.OpDevctrlbtn;

/**
 * 【请填写功能名称】Service接口
 * 
 * @author ruoyi
 * @date 2020-12-01
 */
public interface IOpDevctrlbtnService 
{
    /**
     * 查询【请填写功能名称】
     * 
     * @param dectbtnId 【请填写功能名称】ID
     * @return 【请填写功能名称】
     */
    public OpDevctrlbtn selectOpDevctrlbtnById(String dectbtnId);

    /**
     * 查询【请填写功能名称】列表
     * 
     * @param opDevctrlbtn 【请填写功能名称】
     * @return 【请填写功能名称】集合
     */
    public List<OpDevctrlbtn> selectOpDevctrlbtnList(OpDevctrlbtn opDevctrlbtn);

    /**
     * 新增【请填写功能名称】
     * 
     * @param opDevctrlbtn 【请填写功能名称】
     * @return 结果
     */
    public int insertOpDevctrlbtn(OpDevctrlbtn opDevctrlbtn);

    /**
     * 修改【请填写功能名称】
     * 
     * @param opDevctrlbtn 【请填写功能名称】
     * @return 结果
     */
    public int updateOpDevctrlbtn(OpDevctrlbtn opDevctrlbtn);

    /**
     * 批量删除【请填写功能名称】
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deleteOpDevctrlbtnByIds(String ids);

    /**
     * 删除【请填写功能名称】信息
     * 
     * @param dectbtnId 【请填写功能名称】ID
     * @return 结果
     */
    public int deleteOpDevctrlbtnById(String dectbtnId);
}
