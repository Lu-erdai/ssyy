package com.ruoyi.project.system.alarmargument.controller;

import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.framework.aspectj.lang.annotation.Log;
import com.ruoyi.framework.aspectj.lang.enums.BusinessType;
import com.ruoyi.framework.web.controller.BaseController;
import com.ruoyi.framework.web.domain.AjaxResult;
import com.ruoyi.framework.web.page.TableDataInfo;
import com.ruoyi.project.system.alarmargument.domain.OpAlarmargument;
import com.ruoyi.project.system.alarmargument.service.IOpAlarmargumentService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 报警配置参数Controller
 * 
 * @author ruoyi
 * @date 2020-12-08
 */
@Controller
@RequestMapping("/system/alarmargument")
public class OpAlarmargumentController extends BaseController
{
    private String prefix = "system/alarmargument";

    @Autowired
    private IOpAlarmargumentService opAlarmargumentService;

    @RequiresPermissions("system:alarmargument:view")
    @GetMapping()
    public String alarmargument()
    {
        return prefix + "/alarmargument";
    }

    /**
     * 查询报警配置参数列表
     */
//    @RequiresPermissions("system:alarmargument:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(OpAlarmargument opAlarmargument)
    {
        startPage();
        List<OpAlarmargument> list = opAlarmargumentService.selectOpAlarmargumentList(opAlarmargument);
        return getDataTable(list);
    }

    /**
     * 导出报警配置参数列表
     */
    @RequiresPermissions("system:alarmargument:export")
    @Log(title = "报警配置参数", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(OpAlarmargument opAlarmargument)
    {
        List<OpAlarmargument> list = opAlarmargumentService.selectOpAlarmargumentList(opAlarmargument);
        ExcelUtil<OpAlarmargument> util = new ExcelUtil<OpAlarmargument>(OpAlarmargument.class);
        return util.exportExcel(list, "alarmargument");
    }

    /**
     * 新增报警配置参数
     */
    @GetMapping("/add")
    public String add()
    {
        return prefix + "/add";
    }

    /**
     * 新增保存报警配置参数
     */
    @RequiresPermissions("system:alarmargument:add")
    @Log(title = "报警配置参数", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(OpAlarmargument opAlarmargument)
    {
        return toAjax(opAlarmargumentService.insertOpAlarmargument(opAlarmargument));
    }

    /**
     * 修改报警配置参数
     */
    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") String id, ModelMap mmap)
    {
        OpAlarmargument opAlarmargument = opAlarmargumentService.selectOpAlarmargumentById(id);
        mmap.put("opAlarmargument", opAlarmargument);
        return prefix + "/edit";
    }

    /**
     * 修改保存报警配置参数
     */
    @RequiresPermissions("system:alarmargument:edit")
    @Log(title = "报警配置参数", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(OpAlarmargument opAlarmargument)
    {
        return toAjax(opAlarmargumentService.updateOpAlarmargument(opAlarmargument));
    }

    /**
     * 删除报警配置参数
     */
    @RequiresPermissions("system:alarmargument:remove")
    @Log(title = "报警配置参数", businessType = BusinessType.DELETE)
    @PostMapping( "/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        return toAjax(opAlarmargumentService.deleteOpAlarmargumentByIds(ids));
    }
}
