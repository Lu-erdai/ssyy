package com.ruoyi.project.system.latestdata.controller;

import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.framework.aspectj.lang.annotation.Log;
import com.ruoyi.framework.aspectj.lang.enums.BusinessType;
import com.ruoyi.framework.web.controller.BaseController;
import com.ruoyi.framework.web.domain.AjaxResult;
import com.ruoyi.framework.web.page.TableDataInfo;
import com.ruoyi.project.system.latestdata.domain.GmLatestdata;
import com.ruoyi.project.system.latestdata.service.IGmLatestdataService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 【请填写功能名称】Controller
 * 
 * @author ruoyi
 * @date 2020-11-27
 */
@Controller
@RequestMapping("/system/latestdata")
public class GmLatestdataController extends BaseController
{
    private String prefix = "system/latestdata";

    @Autowired
    private IGmLatestdataService gmLatestdataService;

    @RequiresPermissions("system:latestdata:view")
    @GetMapping()
    public String latestdata()
    {
        return prefix + "/latestdata";
    }

    /**
     * 查询【请填写功能名称】列表
     */
    @RequiresPermissions("system:latestdata:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(GmLatestdata gmLatestdata)
    {
        startPage();
        List<GmLatestdata> list = gmLatestdataService.selectGmLatestdataList(gmLatestdata);
        return getDataTable(list);
    }

    /**
     * 导出【请填写功能名称】列表
     */
    @RequiresPermissions("system:latestdata:export")
    @Log(title = "【请填写功能名称】", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(GmLatestdata gmLatestdata)
    {
        List<GmLatestdata> list = gmLatestdataService.selectGmLatestdataList(gmLatestdata);
        ExcelUtil<GmLatestdata> util = new ExcelUtil<GmLatestdata>(GmLatestdata.class);
        return util.exportExcel(list, "latestdata");
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
    @RequiresPermissions("system:latestdata:add")
    @Log(title = "【请填写功能名称】", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(GmLatestdata gmLatestdata)
    {
        return toAjax(gmLatestdataService.insertGmLatestdata(gmLatestdata));
    }

    /**
     * 修改【请填写功能名称】
     */
    @GetMapping("/edit/{hidaId}")
    public String edit(@PathVariable("hidaId") String hidaId, ModelMap mmap)
    {
        GmLatestdata gmLatestdata = gmLatestdataService.selectGmLatestdataById(hidaId);
        mmap.put("gmLatestdata", gmLatestdata);
        return prefix + "/edit";
    }

    /**
     * 修改保存【请填写功能名称】
     */
    @RequiresPermissions("system:latestdata:edit")
    @Log(title = "【请填写功能名称】", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(GmLatestdata gmLatestdata)
    {
        return toAjax(gmLatestdataService.updateGmLatestdata(gmLatestdata));
    }

    /**
     * 删除【请填写功能名称】
     */
    @RequiresPermissions("system:latestdata:remove")
    @Log(title = "【请填写功能名称】", businessType = BusinessType.DELETE)
    @PostMapping( "/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        return toAjax(gmLatestdataService.deleteGmLatestdataByIds(ids));
    }
}
