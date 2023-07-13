package com.ruoyi.project.system.htzkhistorydata.controller;

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
import com.ruoyi.project.system.htzkhistorydata.domain.GmHtzkHistorydata;
import com.ruoyi.project.system.htzkhistorydata.service.IGmHtzkHistorydataService;
import com.ruoyi.framework.web.controller.BaseController;
import com.ruoyi.framework.web.domain.AjaxResult;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.framework.web.page.TableDataInfo;

/**
 * wuController
 * 
 * @author ruoyi
 * @date 2020-12-31
 */
@Controller
@RequestMapping("/system/htzkhistorydata")
public class GmHtzkHistorydataController extends BaseController
{
    private String prefix = "system/htzkhistorydata";

    @Autowired
    private IGmHtzkHistorydataService gmHtzkHistorydataService;

    @RequiresPermissions("system:htzkhistorydata:view")
    @GetMapping()
    public String htzkhistorydata()
    {
        return prefix + "/htzkhistorydata";
    }

    /**
     * 查询wu列表
     */
    @RequiresPermissions("system:htzkhistorydata:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(GmHtzkHistorydata gmHtzkHistorydata)
    {
        startPage();
        List<GmHtzkHistorydata> list = gmHtzkHistorydataService.selectGmHtzkHistorydataList(gmHtzkHistorydata);
        return getDataTable(list);
    }

    /**
     * 导出wu列表
     */
    @RequiresPermissions("system:htzkhistorydata:export")
    @Log(title = "wu", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(GmHtzkHistorydata gmHtzkHistorydata)
    {
        List<GmHtzkHistorydata> list = gmHtzkHistorydataService.selectGmHtzkHistorydataList(gmHtzkHistorydata);
        ExcelUtil<GmHtzkHistorydata> util = new ExcelUtil<GmHtzkHistorydata>(GmHtzkHistorydata.class);
        return util.exportExcel(list, "htzkhistorydata");
    }

    /**
     * 新增wu
     */
    @GetMapping("/add")
    public String add()
    {
        return prefix + "/add";
    }

    /**
     * 新增保存wu
     */
    @RequiresPermissions("system:htzkhistorydata:add")
    @Log(title = "wu", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(GmHtzkHistorydata gmHtzkHistorydata)
    {
        return toAjax(gmHtzkHistorydataService.insertGmHtzkHistorydata(gmHtzkHistorydata));
    }

    /**
     * 修改wu
     */
    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") Long id, ModelMap mmap)
    {
        GmHtzkHistorydata gmHtzkHistorydata = gmHtzkHistorydataService.selectGmHtzkHistorydataById(id);
        mmap.put("gmHtzkHistorydata", gmHtzkHistorydata);
        return prefix + "/edit";
    }

    /**
     * 修改保存wu
     */
    @RequiresPermissions("system:htzkhistorydata:edit")
    @Log(title = "wu", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(GmHtzkHistorydata gmHtzkHistorydata)
    {
        return toAjax(gmHtzkHistorydataService.updateGmHtzkHistorydata(gmHtzkHistorydata));
    }

    /**
     * 删除wu
     */
    @RequiresPermissions("system:htzkhistorydata:remove")
    @Log(title = "wu", businessType = BusinessType.DELETE)
    @PostMapping( "/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        return toAjax(gmHtzkHistorydataService.deleteGmHtzkHistorydataByIds(ids));
    }
}
