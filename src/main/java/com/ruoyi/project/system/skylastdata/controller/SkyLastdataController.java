package com.ruoyi.project.system.skylastdata.controller;

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
import com.ruoyi.project.system.skylastdata.domain.SkyLastdata;
import com.ruoyi.project.system.skylastdata.service.ISkyLastdataService;
import com.ruoyi.framework.web.controller.BaseController;
import com.ruoyi.framework.web.domain.AjaxResult;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.framework.web.page.TableDataInfo;

/**
 * 速控云最新数据Controller
 * 
 * @author ruoyi
 * @date 2023-06-03
 */
@Controller
@RequestMapping("/system/skylastdata")
public class SkyLastdataController extends BaseController
{
    private String prefix = "system/skylastdata";

    @Autowired
    private ISkyLastdataService skyLastdataService;

    @RequiresPermissions("system:skylastdata:view")
    @GetMapping()
    public String skylastdata()
    {
        return prefix + "/skylastdata";
    }

    /**
     * 查询速控云最新数据列表
     */
    @RequiresPermissions("system:skylastdata:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(SkyLastdata skyLastdata)
    {
        startPage();
        List<SkyLastdata> list = skyLastdataService.selectSkyLastdataList(skyLastdata);
        return getDataTable(list);
    }

    /**
     * 导出速控云最新数据列表
     */
    @RequiresPermissions("system:skylastdata:export")
    @Log(title = "速控云最新数据", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(SkyLastdata skyLastdata)
    {
        List<SkyLastdata> list = skyLastdataService.selectSkyLastdataList(skyLastdata);
        ExcelUtil<SkyLastdata> util = new ExcelUtil<SkyLastdata>(SkyLastdata.class);
        return util.exportExcel(list, "skylastdata");
    }

    /**
     * 新增速控云最新数据
     */
    @GetMapping("/add")
    public String add()
    {
        return prefix + "/add";
    }

    /**
     * 新增保存速控云最新数据
     */
    @RequiresPermissions("system:skylastdata:add")
    @Log(title = "速控云最新数据", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(SkyLastdata skyLastdata)
    {
        return toAjax(skyLastdataService.insertSkyLastdata(skyLastdata));
    }

    /**
     * 修改速控云最新数据
     */
    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") Long id, ModelMap mmap)
    {
        SkyLastdata skyLastdata = skyLastdataService.selectSkyLastdataById(id);
        mmap.put("skyLastdata", skyLastdata);
        return prefix + "/edit";
    }

    /**
     * 修改保存速控云最新数据
     */
    @RequiresPermissions("system:skylastdata:edit")
    @Log(title = "速控云最新数据", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(SkyLastdata skyLastdata)
    {
        return toAjax(skyLastdataService.updateSkyLastdata(skyLastdata));
    }

    /**
     * 删除速控云最新数据
     */
    @RequiresPermissions("system:skylastdata:remove")
    @Log(title = "速控云最新数据", businessType = BusinessType.DELETE)
    @PostMapping( "/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        return toAjax(skyLastdataService.deleteSkyLastdataByIds(ids));
    }
}
