package com.ruoyi.project.system.channel.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.ruoyi.common.utils.text.Convert;
import com.ruoyi.project.system.channel.domain.GmChannel;
import com.ruoyi.project.system.channel.mapper.GmChannelMapper;
import com.ruoyi.project.system.channel.service.IGmChannelService;
import com.ruoyi.project.system.vo.ChannelAvgVO;
import com.ruoyi.project.system.vo.HistoryChannelVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 【请填写功能名称】Service业务层处理
 * 
 * @author ruoyi
 * @date 2020-11-27
 */
@Service
public class GmChannelServiceImpl implements IGmChannelService 
{
    @Autowired
    private GmChannelMapper gmChannelMapper;

    /**
     * 查询【请填写功能名称】
     * 
     * @param chId 【请填写功能名称】ID
     * @return 【请填写功能名称】
     */
    @Override
    public GmChannel selectGmChannelById(String chId)
    {
        return gmChannelMapper.selectGmChannelById(chId);
    }

    /**
     * 查询【请填写功能名称】列表
     * 
     * @param gmChannel 【请填写功能名称】
     * @return 【请填写功能名称】
     */
    @Override
    public List<GmChannel> selectGmChannelList(GmChannel gmChannel)
    {
        return gmChannelMapper.selectGmChannelList(gmChannel);
    }

    /**
     * 新增【请填写功能名称】
     * 
     * @param gmChannel 【请填写功能名称】
     * @return 结果
     */
    @Override
    public int insertGmChannel(GmChannel gmChannel)
    {
        return gmChannelMapper.insertGmChannel(gmChannel);
    }

    /**
     * 修改【请填写功能名称】
     * 
     * @param gmChannel 【请填写功能名称】
     * @return 结果
     */
    @Override
    public int updateGmChannel(GmChannel gmChannel)
    {
        return gmChannelMapper.updateGmChannel(gmChannel);
    }

    /**
     * 删除【请填写功能名称】对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    @Override
    public int deleteGmChannelByIds(String ids)
    {
        return gmChannelMapper.deleteGmChannelByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除【请填写功能名称】信息
     * 
     * @param chId 【请填写功能名称】ID
     * @return 结果
     */
    @Override
    public int deleteGmChannelById(String chId)
    {
        return gmChannelMapper.deleteGmChannelById(chId);
    }

    @Override
    public List<ChannelAvgVO> selectChanneVoList(String sceneId) {
        return gmChannelMapper.selectChanneVoList(sceneId);
    }

    @Override
    public ChannelAvgVO selectChanneVoListByChannelId(String channelId) {
        return gmChannelMapper.selectChanneVoListByChannelId(channelId);
    }

    @Override
    public String getAllChannel(String sceneId) {

        GmChannel gmChannel = new GmChannel();
        gmChannel.setSceneId(sceneId);
        gmChannel.setChState((long) 1);
        gmChannel.setChOfferser((long) 1);
        List<GmChannel> channelList = gmChannelMapper.selectGmChannelList(gmChannel);
        String jsonObj = JSONObject.toJSONString(channelList);
        return jsonObj;
    }

    @Override
    public List<HistoryChannelVo> selectHistoryChannelVoList(String[] channelArr, String startTime, String endTime) {

        return gmChannelMapper.selectHistoryChannelVoList(channelArr,startTime,endTime);
    }
}
