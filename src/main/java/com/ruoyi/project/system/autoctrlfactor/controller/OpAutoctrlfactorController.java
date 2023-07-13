package com.ruoyi.project.system.autoctrlfactor.controller;

import java.util.List;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import com.ruoyi.framework.aspectj.lang.annotation.Log;
import com.ruoyi.framework.aspectj.lang.enums.BusinessType;
import com.ruoyi.project.system.autoctrlfactor.domain.OpAutoctrlfactor;
import com.ruoyi.project.system.autoctrlfactor.service.IOpAutoctrlfactorService;
import com.ruoyi.framework.web.controller.BaseController;
import com.ruoyi.framework.web.domain.AjaxResult;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.framework.web.page.TableDataInfo;

/**
 * 自动控制配置条件Controller
 * 
 * @author ruoyi
 * @date 2020-12-08
 */
@Controller
@RequestMapping("/system/autoctrlfactor")
public class OpAutoctrlfactorController extends BaseController
{
    private String prefix = "system/autoctrlfactor";

    @Autowired
    private IOpAutoctrlfactorService opAutoctrlfactorService;

    @RequiresPermissions("system:autoctrlfactor:view")
    @GetMapping()
    public String autoctrlfactor()
    {
        return prefix + "/autoctrlfactor";
    }

    /**
     * 查询自动控制配置条件列表
     */
    @RequiresPermissions("system:autoctrlfactor:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(OpAutoctrlfactor opAutoctrlfactor)
    {
        startPage();
        List<OpAutoctrlfactor> list = opAutoctrlfactorService.selectOpAutoctrlfactorList(opAutoctrlfactor);
        return getDataTable(list);
    }

    /**
     * 导出自动控制配置条件列表
     */
    @RequiresPermissions("system:autoctrlfactor:export")
    @Log(title = "自动控制配置条件", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(OpAutoctrlfactor opAutoctrlfactor)
    {
        List<OpAutoctrlfactor> list = opAutoctrlfactorService.selectOpAutoctrlfactorList(opAutoctrlfactor);
        ExcelUtil<OpAutoctrlfactor> util = new ExcelUtil<OpAutoctrlfactor>(OpAutoctrlfactor.class);
        return util.exportExcel(list, "autoctrlfactor");
    }

    /**
     * 新增自动控制配置条件
     */
    @GetMapping("/add")
    public String add()
    {
        return prefix + "/add";
    }

    /**
     * 新增保存自动控制配置条件
     */
    @RequiresPermissions("system:autoctrlfactor:add")
    @Log(title = "自动控制配置条件", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(OpAutoctrlfactor opAutoctrlfactor)
    {
        return toAjax(opAutoctrlfactorService.insertOpAutoctrlfactor(opAutoctrlfactor));
    }

    /**
     * 修改自动控制配置条件
     */
    @GetMapping("/edit/{acfId}")
    public String edit(@PathVariable("acfId") Long acfId, ModelMap mmap)
    {
        OpAutoctrlfactor opAutoctrlfactor = opAutoctrlfactorService.selectOpAutoctrlfactorById(acfId);
        mmap.put("opAutoctrlfactor", opAutoctrlfactor);
        return prefix + "/edit";
    }

    /**
     * 修改保存自动控制配置条件
     */
    @RequiresPermissions("system:autoctrlfactor:edit")
    @Log(title = "自动控制配置条件", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(OpAutoctrlfactor opAutoctrlfactor)
    {
        return toAjax(opAutoctrlfactorService.updateOpAutoctrlfactor(opAutoctrlfactor));
    }

    /**
     * 删除自动控制配置条件
     */
    @RequiresPermissions("system:autoctrlfactor:remove")
    @Log(title = "自动控制配置条件", businessType = BusinessType.DELETE)
    @PostMapping( "/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        return toAjax(opAutoctrlfactorService.deleteOpAutoctrlfactorByIds(ids));
    }
}
