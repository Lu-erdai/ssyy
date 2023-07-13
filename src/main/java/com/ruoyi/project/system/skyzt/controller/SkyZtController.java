package com.ruoyi.project.system.skyzt.controller;

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
import com.ruoyi.project.system.skyzt.domain.SkyZt;
import com.ruoyi.project.system.skyzt.service.ISkyZtService;
import com.ruoyi.framework.web.controller.BaseController;
import com.ruoyi.framework.web.domain.AjaxResult;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.framework.web.page.TableDataInfo;

/**
 * 速控云组态链接Controller
 * 
 * @author ruoyi
 * @date 2023-06-28
 */
@Controller
@RequestMapping("/system/skyzt")
public class SkyZtController extends BaseController
{
    private String prefix = "system/skyzt";

    @Autowired
    private ISkyZtService skyZtService;

    @RequiresPermissions("system:skyzt:view")
    @GetMapping()
    public String skyzt()
    {
        return prefix + "/skyzt";
    }

    /**
     * 查询速控云组态链接列表
     */
    @RequiresPermissions("system:skyzt:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(SkyZt skyZt)
    {
        startPage();
        List<SkyZt> list = skyZtService.selectSkyZtList(skyZt);
        return getDataTable(list);
    }

    /**
     * 导出速控云组态链接列表
     */
    @RequiresPermissions("system:skyzt:export")
    @Log(title = "速控云组态链接", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(SkyZt skyZt)
    {
        List<SkyZt> list = skyZtService.selectSkyZtList(skyZt);
        ExcelUtil<SkyZt> util = new ExcelUtil<SkyZt>(SkyZt.class);
        return util.exportExcel(list, "skyzt");
    }

    /**
     * 新增速控云组态链接
     */
    @GetMapping("/add")
    public String add()
    {
        return prefix + "/add";
    }

    /**
     * 新增保存速控云组态链接
     */
    @RequiresPermissions("system:skyzt:add")
    @Log(title = "速控云组态链接", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(SkyZt skyZt)
    {
        return toAjax(skyZtService.insertSkyZt(skyZt));
    }

    /**
     * 修改速控云组态链接
     */
    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") Long id, ModelMap mmap)
    {
        SkyZt skyZt = skyZtService.selectSkyZtById(id);
        mmap.put("skyZt", skyZt);
        return prefix + "/edit";
    }

    /**
     * 修改保存速控云组态链接
     */
    @RequiresPermissions("system:skyzt:edit")
    @Log(title = "速控云组态链接", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(SkyZt skyZt)
    {
        return toAjax(skyZtService.updateSkyZt(skyZt));
    }

    /**
     * 删除速控云组态链接
     */
    @RequiresPermissions("system:skyzt:remove")
    @Log(title = "速控云组态链接", businessType = BusinessType.DELETE)
    @PostMapping( "/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        return toAjax(skyZtService.deleteSkyZtByIds(ids));
    }
}
