package com.ruoyi.project.system.ledinfo.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.project.system.ledinfo.mapper.OpLedinfoMapper;
import com.ruoyi.project.system.ledinfo.domain.OpLedinfo;
import com.ruoyi.project.system.ledinfo.service.IOpLedinfoService;
import com.ruoyi.common.utils.text.Convert;

/**
 * 【请填写功能名称】Service业务层处理
 * 
 * @author ruoyi
 * @date 2020-12-07
 */
@Service
public class OpLedinfoServiceImpl implements IOpLedinfoService 
{
    @Autowired
    private OpLedinfoMapper opLedinfoMapper;

    /**
     * 查询【请填写功能名称】
     * 
     * @param ledId 【请填写功能名称】ID
     * @return 【请填写功能名称】
     */
    @Override
    public OpLedinfo selectOpLedinfoById(String ledId)
    {
        return opLedinfoMapper.selectOpLedinfoById(ledId);
    }

    /**
     * 查询【请填写功能名称】列表
     * 
     * @param opLedinfo 【请填写功能名称】
     * @return 【请填写功能名称】
     */
    @Override
    public List<OpLedinfo> selectOpLedinfoList(OpLedinfo opLedinfo)
    {
        return opLedinfoMapper.selectOpLedinfoList(opLedinfo);
    }

    /**
     * 新增【请填写功能名称】
     * 
     * @param opLedinfo 【请填写功能名称】
     * @return 结果
     */
    @Override
    public int insertOpLedinfo(OpLedinfo opLedinfo)
    {
        return opLedinfoMapper.insertOpLedinfo(opLedinfo);
    }

    /**
     * 修改【请填写功能名称】
     * 
     * @param opLedinfo 【请填写功能名称】
     * @return 结果
     */
    @Override
    public int updateOpLedinfo(OpLedinfo opLedinfo)
    {
        return opLedinfoMapper.updateOpLedinfo(opLedinfo);
    }

    /**
     * 删除【请填写功能名称】对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    @Override
    public int deleteOpLedinfoByIds(String ids)
    {
        return opLedinfoMapper.deleteOpLedinfoByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除【请填写功能名称】信息
     * 
     * @param ledId 【请填写功能名称】ID
     * @return 结果
     */
    @Override
    public int deleteOpLedinfoById(String ledId)
    {
        return opLedinfoMapper.deleteOpLedinfoById(ledId);
    }
}
