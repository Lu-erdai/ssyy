package com.ruoyi.project.system.skyboxval.controller;

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
import com.ruoyi.project.system.skyboxval.domain.SkyBoxval;
import com.ruoyi.project.system.skyboxval.service.ISkyBoxvalService;
import com.ruoyi.framework.web.controller.BaseController;
import com.ruoyi.framework.web.domain.AjaxResult;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.framework.web.page.TableDataInfo;

/**
 * 速客云变量参数Controller
 * 
 * @author ruoyi
 * @date 2023-06-03
 */
@Controller
@RequestMapping("/system/skyboxval")
public class SkyBoxvalController extends BaseController
{
    private String prefix = "system/skyboxval";

    @Autowired
    private ISkyBoxvalService skyBoxvalService;

    @RequiresPermissions("system:skyboxval:view")
    @GetMapping()
    public String skyboxval()
    {
        return prefix + "/skyboxval";
    }

    /**
     * 查询速客云变量参数列表
     */
    @RequiresPermissions("system:skyboxval:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(SkyBoxval skyBoxval)
    {
        startPage();
        List<SkyBoxval> list = skyBoxvalService.selectSkyBoxvalList(skyBoxval);
        return getDataTable(list);
    }

    /**
     * 导出速客云变量参数列表
     */
    @RequiresPermissions("system:skyboxval:export")
    @Log(title = "速客云变量参数", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(SkyBoxval skyBoxval)
    {
        List<SkyBoxval> list = skyBoxvalService.selectSkyBoxvalList(skyBoxval);
        ExcelUtil<SkyBoxval> util = new ExcelUtil<SkyBoxval>(SkyBoxval.class);
        return util.exportExcel(list, "skyboxval");
    }

    /**
     * 新增速客云变量参数
     */
    @GetMapping("/add")
    public String add()
    {
        return prefix + "/add";
    }

    /**
     * 新增保存速客云变量参数
     */
    @RequiresPermissions("system:skyboxval:add")
    @Log(title = "速客云变量参数", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(SkyBoxval skyBoxval)
    {
        return toAjax(skyBoxvalService.insertSkyBoxval(skyBoxval));
    }

    /**
     * 修改速客云变量参数
     */
    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") Long id, ModelMap mmap)
    {
        SkyBoxval skyBoxval = skyBoxvalService.selectSkyBoxvalById(id);
        mmap.put("skyBoxval", skyBoxval);
        return prefix + "/edit";
    }

    /**
     * 修改保存速客云变量参数
     */
    @RequiresPermissions("system:skyboxval:edit")
    @Log(title = "速客云变量参数", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(SkyBoxval skyBoxval)
    {
        return toAjax(skyBoxvalService.updateSkyBoxval(skyBoxval));
    }

    /**
     * 删除速客云变量参数
     */
    @RequiresPermissions("system:skyboxval:remove")
    @Log(title = "速客云变量参数", businessType = BusinessType.DELETE)
    @PostMapping( "/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        return toAjax(skyBoxvalService.deleteSkyBoxvalByIds(ids));
    }
}
