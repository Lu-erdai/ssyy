package com.ruoyi.project.system.htzklastdata.controller;

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
import com.ruoyi.project.system.htzklastdata.domain.GmHtzkLastdata;
import com.ruoyi.project.system.htzklastdata.service.IGmHtzkLastdataService;
import com.ruoyi.framework.web.controller.BaseController;
import com.ruoyi.framework.web.domain.AjaxResult;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.framework.web.page.TableDataInfo;

/**
 * aaController
 * 
 * @author ruoyi
 * @date 2021-01-04
 */
@Controller
@RequestMapping("/system/htzklastdata")
public class GmHtzkLastdataController extends BaseController
{
    private String prefix = "system/htzklastdata";

    @Autowired
    private IGmHtzkLastdataService gmHtzkLastdataService;

    @RequiresPermissions("system:htzklastdata:view")
    @GetMapping()
    public String htzklastdata()
    {
        return prefix + "/htzklastdata";
    }

    /**
     * 查询aa列表
     */
    @RequiresPermissions("system:htzklastdata:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(GmHtzkLastdata gmHtzkLastdata)
    {
        startPage();
        List<GmHtzkLastdata> list = gmHtzkLastdataService.selectGmHtzkLastdataList(gmHtzkLastdata);
        return getDataTable(list);
    }

    /**
     * 导出aa列表
     */
    @RequiresPermissions("system:htzklastdata:export")
    @Log(title = "aa", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(GmHtzkLastdata gmHtzkLastdata)
    {
        List<GmHtzkLastdata> list = gmHtzkLastdataService.selectGmHtzkLastdataList(gmHtzkLastdata);
        ExcelUtil<GmHtzkLastdata> util = new ExcelUtil<GmHtzkLastdata>(GmHtzkLastdata.class);
        return util.exportExcel(list, "htzklastdata");
    }

    /**
     * 新增aa
     */
    @GetMapping("/add")
    public String add()
    {
        return prefix + "/add";
    }

    /**
     * 新增保存aa
     */
    @RequiresPermissions("system:htzklastdata:add")
    @Log(title = "aa", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(GmHtzkLastdata gmHtzkLastdata)
    {
        return toAjax(gmHtzkLastdataService.insertGmHtzkLastdata(gmHtzkLastdata));
    }

    /**
     * 修改aa
     */
    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") Long id, ModelMap mmap)
    {
        GmHtzkLastdata gmHtzkLastdata = gmHtzkLastdataService.selectGmHtzkLastdataById(id);
        mmap.put("gmHtzkLastdata", gmHtzkLastdata);
        return prefix + "/edit";
    }

    /**
     * 修改保存aa
     */
    @RequiresPermissions("system:htzklastdata:edit")
    @Log(title = "aa", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(GmHtzkLastdata gmHtzkLastdata)
    {
        return toAjax(gmHtzkLastdataService.updateGmHtzkLastdata(gmHtzkLastdata));
    }

    /**
     * 删除aa
     */
    @RequiresPermissions("system:htzklastdata:remove")
    @Log(title = "aa", businessType = BusinessType.DELETE)
    @PostMapping( "/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        return toAjax(gmHtzkLastdataService.deleteGmHtzkLastdataByIds(ids));
    }
}
