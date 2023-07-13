package com.ruoyi.project.system.channel.service;

import com.ruoyi.project.system.channel.domain.GmChannel;
import com.ruoyi.project.system.vo.ChannelAvgVO;
import com.ruoyi.project.system.vo.HistoryChannelVo;

import java.util.List;

/**
 * 【请填写功能名称】Service接口
 * 
 * @author ruoyi
 * @date 2020-11-27
 */
public interface IGmChannelService 
{
    /**
     * 查询【请填写功能名称】
     * 
     * @param chId 【请填写功能名称】ID
     * @return 【请填写功能名称】
     */
    public GmChannel selectGmChannelById(String chId);

    /**
     * 查询【请填写功能名称】列表
     * 
     * @param gmChannel 【请填写功能名称】
     * @return 【请填写功能名称】集合
     */
    public List<GmChannel> selectGmChannelList(GmChannel gmChannel);

    /**
     * 新增【请填写功能名称】
     * 
     * @param gmChannel 【请填写功能名称】
     * @return 结果
     */
    public int insertGmChannel(GmChannel gmChannel);

    /**
     * 修改【请填写功能名称】
     * 
     * @param gmChannel 【请填写功能名称】
     * @return 结果
     */
    public int updateGmChannel(GmChannel gmChannel);

    /**
     * 批量删除【请填写功能名称】
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deleteGmChannelByIds(String ids);

    /**
     * 删除【请填写功能名称】信息
     * 
     * @param chId 【请填写功能名称】ID
     * @return 结果
     */
    public int deleteGmChannelById(String chId);

    List<ChannelAvgVO> selectChanneVoList(String sceneId);

    ChannelAvgVO selectChanneVoListByChannelId(String channelId);

    String getAllChannel(String sceneId);

    List<HistoryChannelVo> selectHistoryChannelVoList(String[] channelArr, String startTime, String endTime);
}
