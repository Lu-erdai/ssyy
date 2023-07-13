package com.ruoyi.project.system.skyzt.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.project.system.skyzt.mapper.SkyZtMapper;
import com.ruoyi.project.system.skyzt.domain.SkyZt;
import com.ruoyi.project.system.skyzt.service.ISkyZtService;
import com.ruoyi.common.utils.text.Convert;

/**
 * 速控云组态链接Service业务层处理
 * 
 * @author ruoyi
 * @date 2023-06-28
 */
@Service
public class SkyZtServiceImpl implements ISkyZtService 
{
    @Autowired
    private SkyZtMapper skyZtMapper;

    /**
     * 查询速控云组态链接
     * 
     * @param id 速控云组态链接ID
     * @return 速控云组态链接
     */
    @Override
    public SkyZt selectSkyZtById(Long id)
    {
        return skyZtMapper.selectSkyZtById(id);
    }

    /**
     * 查询速控云组态链接列表
     * 
     * @param skyZt 速控云组态链接
     * @return 速控云组态链接
     */
    @Override
    public List<SkyZt> selectSkyZtList(SkyZt skyZt)
    {
        return skyZtMapper.selectSkyZtList(skyZt);
    }

    /**
     * 新增速控云组态链接
     * 
     * @param skyZt 速控云组态链接
     * @return 结果
     */
    @Override
    public int insertSkyZt(SkyZt skyZt)
    {
        return skyZtMapper.insertSkyZt(skyZt);
    }

    /**
     * 修改速控云组态链接
     * 
     * @param skyZt 速控云组态链接
     * @return 结果
     */
    @Override
    public int updateSkyZt(SkyZt skyZt)
    {
        return skyZtMapper.updateSkyZt(skyZt);
    }

    /**
     * 删除速控云组态链接对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    @Override
    public int deleteSkyZtByIds(String ids)
    {
        return skyZtMapper.deleteSkyZtByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除速控云组态链接信息
     * 
     * @param id 速控云组态链接ID
     * @return 结果
     */
    @Override
    public int deleteSkyZtById(Long id)
    {
        return skyZtMapper.deleteSkyZtById(id);
    }
}
