package com.ruoyi.project.system.devctrlsts.controller;

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
import com.ruoyi.project.system.devctrlsts.domain.GmDevctrlsts;
import com.ruoyi.project.system.devctrlsts.service.IGmDevctrlstsService;
import com.ruoyi.framework.web.controller.BaseController;
import com.ruoyi.framework.web.domain.AjaxResult;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.framework.web.page.TableDataInfo;

/**
 * 【请填写功能名称】Controller
 * 
 * @author ruoyi
 * @date 2020-12-01
 */
@Controller
@RequestMapping("/system/devctrlsts")
public class GmDevctrlstsController extends BaseController
{
    private String prefix = "system/devctrlsts";

    @Autowired
    private IGmDevctrlstsService gmDevctrlstsService;

    @RequiresPermissions("system:devctrlsts:view")
    @GetMapping()
    public String devctrlsts()
    {
        return prefix + "/devctrlsts";
    }

    /**
     * 查询【请填写功能名称】列表
     */
    @RequiresPermissions("system:devctrlsts:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(GmDevctrlsts gmDevctrlsts)
    {
        startPage();
        List<GmDevctrlsts> list = gmDevctrlstsService.selectGmDevctrlstsList(gmDevctrlsts);
        return getDataTable(list);
    }

    /**
     * 导出【请填写功能名称】列表
     */
    @RequiresPermissions("system:devctrlsts:export")
    @Log(title = "【请填写功能名称】", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(GmDevctrlsts gmDevctrlsts)
    {
        List<GmDevctrlsts> list = gmDevctrlstsService.selectGmDevctrlstsList(gmDevctrlsts);
        ExcelUtil<GmDevctrlsts> util = new ExcelUtil<GmDevctrlsts>(GmDevctrlsts.class);
        return util.exportExcel(list, "devctrlsts");
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
    @RequiresPermissions("system:devctrlsts:add")
    @Log(title = "【请填写功能名称】", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(GmDevctrlsts gmDevctrlsts)
    {
        return toAjax(gmDevctrlstsService.insertGmDevctrlsts(gmDevctrlsts));
    }

    /**
     * 修改【请填写功能名称】
     */
    @GetMapping("/edit/{decstId}")
    public String edit(@PathVariable("decstId") String decstId, ModelMap mmap)
    {
        GmDevctrlsts gmDevctrlsts = gmDevctrlstsService.selectGmDevctrlstsById(decstId);
        mmap.put("gmDevctrlsts", gmDevctrlsts);
        return prefix + "/edit";
    }

    /**
     * 修改保存【请填写功能名称】
     */
    @RequiresPermissions("system:devctrlsts:edit")
    @Log(title = "【请填写功能名称】", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(GmDevctrlsts gmDevctrlsts)
    {
        return toAjax(gmDevctrlstsService.updateGmDevctrlsts(gmDevctrlsts));
    }

    /**
     * 删除【请填写功能名称】
     */
    @RequiresPermissions("system:devctrlsts:remove")
    @Log(title = "【请填写功能名称】", businessType = BusinessType.DELETE)
    @PostMapping( "/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        return toAjax(gmDevctrlstsService.deleteGmDevctrlstsByIds(ids));
    }
}
