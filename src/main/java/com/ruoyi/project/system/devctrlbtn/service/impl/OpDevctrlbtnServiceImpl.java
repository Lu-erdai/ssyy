package com.ruoyi.project.system.devctrlbtn.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.project.system.devctrlbtn.mapper.OpDevctrlbtnMapper;
import com.ruoyi.project.system.devctrlbtn.domain.OpDevctrlbtn;
import com.ruoyi.project.system.devctrlbtn.service.IOpDevctrlbtnService;
import com.ruoyi.common.utils.text.Convert;

/**
 * 【请填写功能名称】Service业务层处理
 * 
 * @author ruoyi
 * @date 2020-12-01
 */
@Service
public class OpDevctrlbtnServiceImpl implements IOpDevctrlbtnService 
{
    @Autowired
    private OpDevctrlbtnMapper opDevctrlbtnMapper;

    /**
     * 查询【请填写功能名称】
     * 
     * @param dectbtnId 【请填写功能名称】ID
     * @return 【请填写功能名称】
     */
    @Override
    public OpDevctrlbtn selectOpDevctrlbtnById(String dectbtnId)
    {
        return opDevctrlbtnMapper.selectOpDevctrlbtnById(dectbtnId);
    }

    /**
     * 查询【请填写功能名称】列表
     * 
     * @param opDevctrlbtn 【请填写功能名称】
     * @return 【请填写功能名称】
     */
    @Override
    public List<OpDevctrlbtn> selectOpDevctrlbtnList(OpDevctrlbtn opDevctrlbtn)
    {
        return opDevctrlbtnMapper.selectOpDevctrlbtnList(opDevctrlbtn);
    }

    /**
     * 新增【请填写功能名称】
     * 
     * @param opDevctrlbtn 【请填写功能名称】
     * @return 结果
     */
    @Override
    public int insertOpDevctrlbtn(OpDevctrlbtn opDevctrlbtn)
    {
        return opDevctrlbtnMapper.insertOpDevctrlbtn(opDevctrlbtn);
    }

    /**
     * 修改【请填写功能名称】
     * 
     * @param opDevctrlbtn 【请填写功能名称】
     * @return 结果
     */
    @Override
    public int updateOpDevctrlbtn(OpDevctrlbtn opDevctrlbtn)
    {
        return opDevctrlbtnMapper.updateOpDevctrlbtn(opDevctrlbtn);
    }

    /**
     * 删除【请填写功能名称】对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    @Override
    public int deleteOpDevctrlbtnByIds(String ids)
    {
        return opDevctrlbtnMapper.deleteOpDevctrlbtnByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除【请填写功能名称】信息
     * 
     * @param dectbtnId 【请填写功能名称】ID
     * @return 结果
     */
    @Override
    public int deleteOpDevctrlbtnById(String dectbtnId)
    {
        return opDevctrlbtnMapper.deleteOpDevctrlbtnById(dectbtnId);
    }
}
