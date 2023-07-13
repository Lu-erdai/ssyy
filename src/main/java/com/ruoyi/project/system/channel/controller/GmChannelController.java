package com.ruoyi.project.system.channel.controller;

import com.alibaba.fastjson.JSONObject;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.framework.aspectj.lang.annotation.Log;
import com.ruoyi.framework.aspectj.lang.enums.BusinessType;
import com.ruoyi.framework.web.controller.BaseController;
import com.ruoyi.framework.web.domain.AjaxResult;
import com.ruoyi.framework.web.page.TableDataInfo;
import com.ruoyi.project.system.channel.domain.GmChannel;
import com.ruoyi.project.system.channel.service.IGmChannelService;
import com.ruoyi.project.system.vo.ChannelAvgVO;
import com.ruoyi.project.system.vo.HistoryChannelVo;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

/**
 * 【请填写功能名称】Controller
 * 
 * @author ruoyi
 * @date 2020-11-27
 */
@Controller
@RequestMapping("/system/channel")
public class GmChannelController extends BaseController
{
    private String prefix = "system/channel";

    @Autowired
    private IGmChannelService gmChannelService;

    @RequiresPermissions("system:channel:view")
    @GetMapping()
    public String channel()
    {
        return prefix + "/channel";
    }

    /**
     * 查询【请填写功能名称】列表
     */
//    @RequiresPermissions("system:channel:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(GmChannel gmChannel)
    {
        if(gmChannel.getSceneId()==null||gmChannel.getSceneId().equals("")){
            return getDataTable(new ArrayList<>());
        }else{
            startPage();
            List<ChannelAvgVO> list =  gmChannelService.selectChanneVoList(gmChannel.getSceneId());
            return getDataTable(list);

//            startPage();
//            List<GmChannel> list = gmChannelService.selectGmChannelList(gmChannel);
//            return getDataTable(list);
        }

    }
    /**
     * 查询【请填写功能名称】列表
     */
    @GetMapping("/getChannelList")
    @ResponseBody
    public String getChannelList(GmChannel gmChannel,ModelMap mmap)
    {
        List<ChannelAvgVO> list =  gmChannelService.selectChanneVoList(gmChannel.getSceneId());
        mmap.put("channelList",list);
        return JSONObject.toJSONString(list);

    }
    /**
     * 查询【请填写功能名称】列表
     */
//    @RequiresPermissions("system:channel:list")
    @PostMapping("/getChannelHis")
    @ResponseBody
    public TableDataInfo getChannelHis(String channels, String startTime, String endTime)
    {
//        if(gmChannel.getSceneId()==null||gmChannel.getSceneId().equals("")){
//            return getDataTable(new ArrayList<>());
//        }else{
//            startPage();
//            List<ChannelAvgVO> list =  gmChannelService.selectChanneVoList(gmChannel.getSceneId());
//            return getDataTable(list);
//        }
//

        startTime += " 00:00:00";
        endTime += " 23:59:59";

        String[] channelArr = channels.split(",");
        startPage();
        List<HistoryChannelVo> list = gmChannelService.selectHistoryChannelVoList(channelArr,startTime,endTime);
        return getDataTable(list);
    }

    /**
     * 导出【请填写功能名称】列表
     */
    @RequiresPermissions("system:channel:export")
    @Log(title = "【请填写功能名称】", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(GmChannel gmChannel)
    {
        List<GmChannel> list = gmChannelService.selectGmChannelList(gmChannel);
        ExcelUtil<GmChannel> util = new ExcelUtil<GmChannel>(GmChannel.class);
        return util.exportExcel(list, "channel");
    }

    /**
     * 新增【请填写功能名称】
     */
    @GetMapping("/add")
    public String add()
    {
        return prefix + "/add";
    }

    /**
     * 新增保存【请填写功能名称】
     */
    @RequiresPermissions("system:channel:add")
    @Log(title = "【请填写功能名称】", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(GmChannel gmChannel)
    {
        return toAjax(gmChannelService.insertGmChannel(gmChannel));
    }

    /**
     * 修改【请填写功能名称】
     */
    @GetMapping("/edit/{chId}")
    public String edit(@PathVariable("chId") String chId, ModelMap mmap)
    {
        GmChannel gmChannel = gmChannelService.selectGmChannelById(chId);
        mmap.put("gmChannel", gmChannel);
        return prefix + "/edit";
    }

    /**
     * 修改保存【请填写功能名称】
     */
    @RequiresPermissions("system:channel:edit")
    @Log(title = "【请填写功能名称】", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(GmChannel gmChannel)
    {
        return toAjax(gmChannelService.updateGmChannel(gmChannel));
    }

    /**
     * 删除【请填写功能名称】
     */
    @RequiresPermissions("system:channel:remove")
    @Log(title = "【请填写功能名称】", businessType = BusinessType.DELETE)
    @PostMapping( "/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        return toAjax(gmChannelService.deleteGmChannelByIds(ids));
    }
}
