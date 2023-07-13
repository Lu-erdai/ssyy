package com.ruoyi.project.system.devctrloperate.controller;

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
import com.ruoyi.project.system.devctrloperate.domain.GmDevctrloperate;
import com.ruoyi.project.system.devctrloperate.service.IGmDevctrloperateService;
import com.ruoyi.framework.web.controller.BaseController;
import com.ruoyi.framework.web.domain.AjaxResult;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.framework.web.page.TableDataInfo;

/**
 * 【请填写功能名称】Controller
 * 
 * @author ruoyi
 * @date 2020-12-02
 */
@Controller
@RequestMapping("/system/devctrloperate")
public class GmDevctrloperateController extends BaseController
{
    private String prefix = "system/devctrloperate";

    @Autowired
    private IGmDevctrloperateService gmDevctrloperateService;

    @RequiresPermissions("system:devctrloperate:view")
    @GetMapping()
    public String devctrloperate()
    {
        return prefix + "/devctrloperate";
    }

    /**
     * 查询【请填写功能名称】列表
     */
    @RequiresPermissions("system:devctrloperate:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(GmDevctrloperate gmDevctrloperate)
    {
        startPage();
        List<GmDevctrloperate> list = gmDevctrloperateService.selectGmDevctrloperateList(gmDevctrloperate);
        return getDataTable(list);
    }

    /**
     * 导出【请填写功能名称】列表
     */
    @RequiresPermissions("system:devctrloperate:export")
    @Log(title = "【请填写功能名称】", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(GmDevctrloperate gmDevctrloperate)
    {
        List<GmDevctrloperate> list = gmDevctrloperateService.selectGmDevctrloperateList(gmDevctrloperate);
        ExcelUtil<GmDevctrloperate> util = new ExcelUtil<GmDevctrloperate>(GmDevctrloperate.class);
        return util.exportExcel(list, "devctrloperate");
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
    @RequiresPermissions("system:devctrloperate:add")
    @Log(title = "【请填写功能名称】", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(GmDevctrloperate gmDevctrloperate)
    {
        return toAjax(gmDevctrloperateService.insertGmDevctrloperate(gmDevctrloperate));
    }

    /**
     * 修改【请填写功能名称】
     */
    @GetMapping("/edit/{decoId}")
    public String edit(@PathVariable("decoId") String decoId, ModelMap mmap)
    {
        GmDevctrloperate gmDevctrloperate = gmDevctrloperateService.selectGmDevctrloperateById(decoId);
        mmap.put("gmDevctrloperate", gmDevctrloperate);
        return prefix + "/edit";
    }

    /**
     * 修改保存【请填写功能名称】
     */
    @RequiresPermissions("system:devctrloperate:edit")
    @Log(title = "【请填写功能名称】", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(GmDevctrloperate gmDevctrloperate)
    {
        return toAjax(gmDevctrloperateService.updateGmDevctrloperate(gmDevctrloperate));
    }

    /**
     * 删除【请填写功能名称】
     */
    @RequiresPermissions("system:devctrloperate:remove")
    @Log(title = "【请填写功能名称】", businessType = BusinessType.DELETE)
    @PostMapping( "/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        return toAjax(gmDevctrloperateService.deleteGmDevctrloperateByIds(ids));
    }
}
