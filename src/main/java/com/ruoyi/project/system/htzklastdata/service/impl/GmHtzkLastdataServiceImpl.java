package com.ruoyi.project.system.htzklastdata.service.impl;

import com.ruoyi.common.utils.text.Convert;
import com.ruoyi.project.system.htzklastdata.domain.GmHtzkLastdata;
import com.ruoyi.project.system.htzklastdata.mapper.GmHtzkLastdataMapper;
import com.ruoyi.project.system.htzklastdata.service.IGmHtzkLastdataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * aaService业务层处理
 * 
 * @author ruoyi
 * @date 2021-01-04
 */
@Service
public class GmHtzkLastdataServiceImpl implements IGmHtzkLastdataService 
{
    @Autowired
    private GmHtzkLastdataMapper gmHtzkLastdataMapper;

    /**
     * 查询aa
     * 
     * @param id aaID
     * @return aa
     */
    @Override
    public GmHtzkLastdata selectGmHtzkLastdataById(Long id)
    {
        return gmHtzkLastdataMapper.selectGmHtzkLastdataById(id);
    }

    /**
     * 查询aa列表
     * 
     * @param gmHtzkLastdata aa
     * @return aa
     */
    @Override
    public List<GmHtzkLastdata> selectGmHtzkLastdataList(GmHtzkLastdata gmHtzkLastdata)
    {
        return gmHtzkLastdataMapper.selectGmHtzkLastdataList(gmHtzkLastdata);
    }

    @Override
    public List<GmHtzkLastdata> selectAllLastData() {
        return gmHtzkLastdataMapper.selectAllLastData();
    }

    @Override
    public List<GmHtzkLastdata> selectAllLastDataBySNCode(String gatewaySN, String code) {
        return gmHtzkLastdataMapper.selectAllLastDataBySNCode(gatewaySN,code);
    }

    /**
     * 新增aa
     * 
     * @param gmHtzkLastdata aa
     * @return 结果
     */
    @Override
    public int insertGmHtzkLastdata(GmHtzkLastdata gmHtzkLastdata)
    {
        return gmHtzkLastdataMapper.insertGmHtzkLastdata(gmHtzkLastdata);
    }

    /**
     * 修改aa
     * 
     * @param gmHtzkLastdata aa
     * @return 结果
     */
    @Override
    public int updateGmHtzkLastdata(GmHtzkLastdata gmHtzkLastdata)
    {
        return gmHtzkLastdataMapper.updateGmHtzkLastdata(gmHtzkLastdata);
    }

    /**
     * 删除aa对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    @Override
    public int deleteGmHtzkLastdataByIds(String ids)
    {
        return gmHtzkLastdataMapper.deleteGmHtzkLastdataByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除aa信息
     * 
     * @param id aaID
     * @return 结果
     */
    @Override
    public int deleteGmHtzkLastdataById(Long id)
    {
        return gmHtzkLastdataMapper.deleteGmHtzkLastdataById(id);
    }
}
