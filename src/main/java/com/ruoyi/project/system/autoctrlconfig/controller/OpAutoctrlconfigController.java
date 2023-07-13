package com.ruoyi.project.system.autoctrlconfig.controller;

import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.framework.aspectj.lang.annotation.Log;
import com.ruoyi.framework.aspectj.lang.enums.BusinessType;
import com.ruoyi.framework.web.controller.BaseController;
import com.ruoyi.framework.web.domain.AjaxResult;
import com.ruoyi.framework.web.page.TableDataInfo;
import com.ruoyi.project.system.autoctrlconfig.domain.OpAutoctrlconfig;
import com.ruoyi.project.system.autoctrlconfig.service.IOpAutoctrlconfigService;
import com.ruoyi.project.system.channel.domain.GmChannel;
import com.ruoyi.project.system.channel.service.IGmChannelService;
import com.ruoyi.project.system.devctrl.domain.GmDevctrl;
import com.ruoyi.project.system.devctrl.service.IGmDevctrlService;
import com.ruoyi.project.system.vo.AutoConfigVO;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 自动控制配置Controller
 * 
 * @author ruoyi
 * @date 2020-12-08
 */
@Controller
@RequestMapping("/system/autoctrlconfig")
public class OpAutoctrlconfigController extends BaseController
{
    private String prefix = "system/autoctrlconfig";

    @Autowired
    private IOpAutoctrlconfigService opAutoctrlconfigService;
    @Autowired
    private IGmChannelService gmChannelService;
    @Autowired
    private IGmDevctrlService gmDevctrlService;





    @RequiresPermissions("system:autoctrlconfig:view")
    @GetMapping()
    public String autoctrlconfig()
    {
        return prefix + "/autoctrlconfig";
    }

    /**
     * 查询自动控制配置列表
     */
//    @RequiresPermissions("system:autoctrlconfig:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(OpAutoctrlconfig opAutoctrlconfig)
    {
        startPage();
//        List<OpAutoctrlconfig> list = opAutoctrlconfigService.selectOpAutoctrlconfigList(opAutoctrlconfig);
//        return getDataTable(list);
        List<AutoConfigVO> list = opAutoctrlconfigService.selectAutoConfigVOList(opAutoctrlconfig.getSceneId());
        return getDataTable(list);
    }

    /**
     * 查询自动控制配置列表
     */
//    @RequiresPermissions("system:autoctrlconfig:list")
    @GetMapping("/addConfig")
    public String addConfig(String sceneId, ModelMap mmap)
    {

        GmChannel channel = new GmChannel();
        channel.setSceneId(sceneId);
        List<GmChannel> channelList = gmChannelService.selectGmChannelList(channel);
        GmDevctrl gmDevctrl = new GmDevctrl();
        gmDevctrl.setSceneId(sceneId);
        List<GmDevctrl> gmDevctrls = gmDevctrlService.selectGmDevctrlList(gmDevctrl);

        mmap.put("channelList",channelList);
        mmap.put("gmDevctrls",gmDevctrls);
        mmap.put("sceneId",sceneId);


        return prefix + "/addconfig";
    }





    /**
     * 导出自动控制配置列表
     */
    @RequiresPermissions("system:autoctrlconfig:export")
    @Log(title = "自动控制配置", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(OpAutoctrlconfig opAutoctrlconfig)
    {
        List<OpAutoctrlconfig> list = opAutoctrlconfigService.selectOpAutoctrlconfigList(opAutoctrlconfig);
        ExcelUtil<OpAutoctrlconfig> util = new ExcelUtil<OpAutoctrlconfig>(OpAutoctrlconfig.class);
        return util.exportExcel(list, "autoctrlconfig");
    }

    /**
     * 新增自动控制配置
     */
    @GetMapping("/add")
    public String add()
    {
        return prefix + "/add";
    }

    /**
     * 新增保存自动控制配置
     */
    @RequiresPermissions("system:autoctrlconfig:add")
    @Log(title = "自动控制配置", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(OpAutoctrlconfig opAutoctrlconfig)
    {
        return toAjax(opAutoctrlconfigService.insertOpAutoctrlconfig(opAutoctrlconfig));
    }

    /**
     * 新增保存自动控制配置
     */
    @Log(title = "自动控制配置", businessType = BusinessType.INSERT)
    @PostMapping("/addConfigAndFactor")
    @ResponseBody
    public AjaxResult addConfigAndFactor(AutoConfigVO autoConfigVO)
    {

        return toAjax(opAutoctrlconfigService.insertConfigAndFactor(autoConfigVO));


    }

    /**
     * 修改自动控制配置
     */
    @GetMapping("/edit/{accId}")
    public String edit(@PathVariable("accId") Long accId, ModelMap mmap)
    {
        OpAutoctrlconfig opAutoctrlconfig = opAutoctrlconfigService.selectOpAutoctrlconfigById(accId);
        mmap.put("opAutoctrlconfig", opAutoctrlconfig);
        return prefix + "/edit";
    }

    /**
     * 修改保存自动控制配置
     */
    @RequiresPermissions("system:autoctrlconfig:edit")
    @Log(title = "自动控制配置", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(OpAutoctrlconfig opAutoctrlconfig)
    {
        return toAjax(opAutoctrlconfigService.updateOpAutoctrlconfig(opAutoctrlconfig));
    }

    /**
     * 删除自动控制配置
     */
    @Log(title = "自动控制配置", businessType = BusinessType.DELETE)
    @PostMapping( "/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        return toAjax(opAutoctrlconfigService.deleteOpAutoctrlconfigByIds(ids));
    }

    /**
     * 删除自动控制配置
     */
    @Log(title = "自动控制配置", businessType = BusinessType.DELETE)
    @PostMapping( "/deletfactorAndconfig")
    @ResponseBody
    public AjaxResult deletfactorAndconfig(String accId,String acfId)
    {
        return toAjax(opAutoctrlconfigService.deletfactorAndconfig(accId,acfId));
    }



}
