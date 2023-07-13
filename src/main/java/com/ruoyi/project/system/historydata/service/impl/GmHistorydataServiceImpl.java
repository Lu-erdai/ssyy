package com.ruoyi.project.system.historydata.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.ruoyi.common.utils.text.Convert;
import com.ruoyi.project.system.channel.domain.GmChannel;
import com.ruoyi.project.system.channel.mapper.GmChannelMapper;
import com.ruoyi.project.system.historydata.domain.GmHistorydata;
import com.ruoyi.project.system.historydata.mapper.GmHistorydataMapper;
import com.ruoyi.project.system.historydata.service.IGmHistorydataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.*;

/**
 * 【请填写功能名称】Service业务层处理
 *
 * @author ruoyi
 * @date 2020-11-30
 */
@Service
public class GmHistorydataServiceImpl implements IGmHistorydataService {
    @Autowired
    private GmHistorydataMapper gmHistorydataMapper;

    @Autowired
    private GmChannelMapper gmChannelMapper;


    /**
     * 查询【请填写功能名称】
     *
     * @param hidaId 【请填写功能名称】ID
     * @return 【请填写功能名称】
     */
    @Override
    public GmHistorydata selectGmHistorydataById(String hidaId) {
        return gmHistorydataMapper.selectGmHistorydataById(hidaId);
    }

    /**
     * 查询【请填写功能名称】列表
     *
     * @param gmHistorydata 【请填写功能名称】
     * @return 【请填写功能名称】
     */
    @Override
    public List<GmHistorydata> selectGmHistorydataList(GmHistorydata gmHistorydata) {
        return gmHistorydataMapper.selectGmHistorydataList(gmHistorydata);
    }

    /**
     * 新增【请填写功能名称】
     *
     * @param gmHistorydata 【请填写功能名称】
     * @return 结果
     */
    @Override
    public int insertGmHistorydata(GmHistorydata gmHistorydata) {
        return gmHistorydataMapper.insertGmHistorydata(gmHistorydata);
    }

    /**
     * 修改【请填写功能名称】
     *
     * @param gmHistorydata 【请填写功能名称】
     * @return 结果
     */
    @Override
    public int updateGmHistorydata(GmHistorydata gmHistorydata) {
        return gmHistorydataMapper.updateGmHistorydata(gmHistorydata);
    }

    /**
     * 删除【请填写功能名称】对象
     *
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    @Override
    public int deleteGmHistorydataByIds(String ids) {
        return gmHistorydataMapper.deleteGmHistorydataByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除【请填写功能名称】信息
     *
     * @param hidaId 【请填写功能名称】ID
     * @return 结果
     */
    @Override
    public int deleteGmHistorydataById(String hidaId) {
        return gmHistorydataMapper.deleteGmHistorydataById(hidaId);
    }

    @Override
    public void selectLimit144ByCh_id(String chId) {

    }

    @Override
    public String getEchartsData(GmChannel channel) {
        Date d = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        String dateNowStr = sdf.format(d);

        String startTime = dateNowStr +" 00:00:00";
        String endTime = dateNowStr + " 23:59:59";


        GmChannel gmChannel = gmChannelMapper.selectGmChannelById(channel.getChId());
        List<GmHistorydata> gmHistorydatas = gmHistorydataMapper.selectGmHistorydataListLimit144(channel.getChId(),startTime,endTime);
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Map map = new HashMap();
        ArrayList timeList = new ArrayList<String>();
        ArrayList recordList = new ArrayList<String>();


        for (GmHistorydata gmHistorydata : gmHistorydatas) {
            timeList.add(format.format(gmHistorydata.getHidaReporttime()));
            recordList.add(gmHistorydata.getHidaCorrvalue());
        }
        map.put("timeList", timeList);
        map.put("recordList", recordList);
        map.put("chName", channel.getChName());
        map.put("chUnit", gmChannel.getChUnit());
        String jsonObj = JSONObject.toJSONString(map);
        return jsonObj;
    }

    @Override
    public List<GmHistorydata> selectAllGmHistorydataList(String channelId) {
        Date d = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        String dateNowStr = sdf.format(d);

        String startTime = dateNowStr +" 00:00:00";
        String endTime = dateNowStr + " 23:59:59";
        List<GmHistorydata> gmHistorydatas = new ArrayList<>();


        gmHistorydatas = gmHistorydataMapper.selectAllGmHistorydataList(channelId,startTime,endTime);

        if(gmHistorydatas.size()<50){
            gmHistorydatas = gmHistorydataMapper.selectGmHistorydataListLimit50(channelId);
        }


        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        ArrayList timeList = new ArrayList<String>();
        ArrayList recordList = new ArrayList<String>();
        for (GmHistorydata gmHistorydata : gmHistorydatas) {
            timeList.add(format.format(gmHistorydata.getHidaReporttime()));
            recordList.add(gmHistorydata.getHidaCorrvalue());
        }
        int listSize=gmHistorydatas.size();
        //如果gmHistorydatas有数据
        if(listSize>0){
            int j =listSize/50;
            List newList = new ArrayList();

            //如果大于50条
            if(j>0){
                for(int i = 0;i<gmHistorydatas.size();i+=j) {
                    if (i + j > listSize||i + j == listSize) {
                        i = listSize-1;
                    }
                    if(newList.size()<50){
                        newList.add(gmHistorydatas.get(i));
                    }

                }
                gmHistorydatas = newList;
            }
        //如果gmHistorydatas没有数据，时间倒序取50条
        }

        return gmHistorydatas;
    }

    @Override
    public String getEchartsDataWithTime(GmChannel channel, String startTime, String endTime) {
        startTime += " 00:00:00";
        endTime += " 23:59:59";
        GmChannel gmChannel = gmChannelMapper.selectGmChannelById(channel.getChId());
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Map map = new HashMap();
        ArrayList timeList = new ArrayList<String>();
        ArrayList recordList = new ArrayList<String>();


        List<GmHistorydata> gmHistoryWithTimedatas = gmHistorydataMapper.getEchartsDataWithTime(channel.getChId(), startTime, endTime);


        for (GmHistorydata gmHistorydata : gmHistoryWithTimedatas) {
            timeList.add(format.format(gmHistorydata.getHidaReporttime()));
            recordList.add(gmHistorydata.getHidaCorrvalue());
        }
        map.put("timeList", timeList);
        map.put("recordList", recordList);
        map.put("chName", channel.getChName());
        map.put("chUnit", gmChannel.getChUnit());
        String jsonObj = JSONObject.toJSONString(map);
        return jsonObj;

    }
}
