package com.ruoyi.project.system.historydata.controller;

import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.framework.aspectj.lang.annotation.Log;
import com.ruoyi.framework.aspectj.lang.enums.BusinessType;
import com.ruoyi.framework.web.controller.BaseController;
import com.ruoyi.framework.web.domain.AjaxResult;
import com.ruoyi.framework.web.page.TableDataInfo;
import com.ruoyi.project.system.historydata.domain.GmHistorydata;
import com.ruoyi.project.system.historydata.service.IGmHistorydataService;
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
 * @date 2020-11-30
 */
@Controller
@RequestMapping("/system/historydata")
public class GmHistorydataController extends BaseController
{
    private String prefix = "system/historydata";

    @Autowired
    private IGmHistorydataService gmHistorydataService;

    @RequiresPermissions("system:historydata:view")
    @GetMapping()
    public String historydata()
    {
        return prefix + "/historydata";
    }

    /**
     * 查询【请填写功能名称】列表
     */
    @RequiresPermissions("system:historydata:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(GmHistorydata gmHistorydata)
    {
        startPage();
        List<GmHistorydata> list = gmHistorydataService.selectGmHistorydataList(gmHistorydata);
        return getDataTable(list);
    }

    /**
     * 导出【请填写功能名称】列表
     */
//    @RequiresPermissions("system:historydata:export")
    @Log(title = "【请填写功能名称】", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(GmHistorydata gmHistorydata)
    {
        List<GmHistorydata> list = gmHistorydataService.selectGmHistorydataList(gmHistorydata);
        ExcelUtil<GmHistorydata> util = new ExcelUtil<GmHistorydata>(GmHistorydata.class);
        return util.exportExcel(list, "historydata");
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
    @RequiresPermissions("system:historydata:add")
    @Log(title = "【请填写功能名称】", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(GmHistorydata gmHistorydata)
    {
        return toAjax(gmHistorydataService.insertGmHistorydata(gmHistorydata));
    }

    /**
     * 修改【请填写功能名称】
     */
    @GetMapping("/edit/{hidaId}")
    public String edit(@PathVariable("hidaId") String hidaId, ModelMap mmap)
    {
        GmHistorydata gmHistorydata = gmHistorydataService.selectGmHistorydataById(hidaId);
        mmap.put("gmHistorydata", gmHistorydata);
        return prefix + "/edit";
    }

    /**
     * 修改保存【请填写功能名称】
     */
    @RequiresPermissions("system:historydata:edit")
    @Log(title = "【请填写功能名称】", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(GmHistorydata gmHistorydata)
    {
        return toAjax(gmHistorydataService.updateGmHistorydata(gmHistorydata));
    }

    /**
     * 删除【请填写功能名称】
     */
    @RequiresPermissions("system:historydata:remove")
    @Log(title = "【请填写功能名称】", businessType = BusinessType.DELETE)
    @PostMapping( "/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        return toAjax(gmHistorydataService.deleteGmHistorydataByIds(ids));
    }
}
