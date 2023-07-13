package com.ruoyi.project.system.alarmconfig.controller;

import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.framework.aspectj.lang.annotation.Log;
import com.ruoyi.framework.aspectj.lang.enums.BusinessType;
import com.ruoyi.framework.web.controller.BaseController;
import com.ruoyi.framework.web.domain.AjaxResult;
import com.ruoyi.framework.web.page.TableDataInfo;
import com.ruoyi.project.system.alarmconfig.domain.OpAlarmconfig;
import com.ruoyi.project.system.alarmconfig.service.IOpAlarmconfigService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 报警配置信息Controller
 * 
 * @author ruoyi
 * @date 2020-12-08
 */
@Controller
@RequestMapping("/system/alarmconfig")
public class OpAlarmconfigController extends BaseController
{
    private String prefix = "system/alarmconfig";

    @Autowired
    private IOpAlarmconfigService opAlarmconfigService;

    @RequiresPermissions("system:alarmconfig:view")
    @GetMapping()
    public String alarmconfig()
    {
        return prefix + "/alarmconfig";
    }

    /**
     * 查询报警配置信息列表
     */
//    @RequiresPermissions("system:alarmconfig:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(OpAlarmconfig opAlarmconfig)
    {
        startPage();
        List<OpAlarmconfig> list = opAlarmconfigService.selectOpAlarmconfigList(opAlarmconfig);
        return getDataTable(list);
    }

    /**
     * 导出报警配置信息列表
     */
    @RequiresPermissions("system:alarmconfig:export")
    @Log(title = "报警配置信息", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(OpAlarmconfig opAlarmconfig)
    {
        List<OpAlarmconfig> list = opAlarmconfigService.selectOpAlarmconfigList(opAlarmconfig);
        ExcelUtil<OpAlarmconfig> util = new ExcelUtil<OpAlarmconfig>(OpAlarmconfig.class);
        return util.exportExcel(list, "alarmconfig");
    }

    /**
     * 新增报警配置信息
     */
    @GetMapping("/add")
    public String add()
    {
        return prefix + "/add";
    }

    /**
     * 新增保存报警配置信息
     */
    @RequiresPermissions("system:alarmconfig:add")
    @Log(title = "报警配置信息", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(OpAlarmconfig opAlarmconfig)
    {
        return toAjax(opAlarmconfigService.insertOpAlarmconfig(opAlarmconfig));
    }

    /**
     * 修改报警配置信息
     */
    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") String id, ModelMap mmap)
    {
        OpAlarmconfig opAlarmconfig = opAlarmconfigService.selectOpAlarmconfigById(id);
        mmap.put("opAlarmconfig", opAlarmconfig);
        return prefix + "/edit";
    }

    /**
     * 修改保存报警配置信息
     */
    @RequiresPermissions("system:alarmconfig:edit")
    @Log(title = "报警配置信息", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(OpAlarmconfig opAlarmconfig)
    {
        return toAjax(opAlarmconfigService.updateOpAlarmconfig(opAlarmconfig));
    }

    /**
     * 删除报警配置信息
     */
    @RequiresPermissions("system:alarmconfig:remove")
    @Log(title = "报警配置信息", businessType = BusinessType.DELETE)
    @PostMapping( "/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        return toAjax(opAlarmconfigService.deleteOpAlarmconfigByIds(ids));
    }
}
