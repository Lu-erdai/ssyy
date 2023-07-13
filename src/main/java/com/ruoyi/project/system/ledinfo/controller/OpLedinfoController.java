package com.ruoyi.project.system.ledinfo.controller;

import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.framework.aspectj.lang.annotation.Log;
import com.ruoyi.framework.aspectj.lang.enums.BusinessType;
import com.ruoyi.framework.web.controller.BaseController;
import com.ruoyi.framework.web.domain.AjaxResult;
import com.ruoyi.framework.web.page.TableDataInfo;
import com.ruoyi.project.system.ledinfo.domain.OpLedinfo;
import com.ruoyi.project.system.ledinfo.service.IOpLedinfoService;
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
 * @date 2020-12-07
 */
@Controller
@RequestMapping("/system/ledinfo")
public class OpLedinfoController extends BaseController
{
    private String prefix = "system/ledinfo";

    @Autowired
    private IOpLedinfoService opLedinfoService;

//    @RequiresPermissions("system:ledinfo:view")
    @GetMapping()
    public String ledinfo()
    {
        return prefix + "/ledinfo";
    }

    /**
     * 查询【请填写功能名称】列表
     */
//    @RequiresPermissions("system:ledinfo:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(OpLedinfo opLedinfo)
    {
        startPage();
        List<OpLedinfo> list = opLedinfoService.selectOpLedinfoList(opLedinfo);
        return getDataTable(list);
    }

    /**
     * 导出【请填写功能名称】列表
     */
    @RequiresPermissions("system:ledinfo:export")
    @Log(title = "【请填写功能名称】", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(OpLedinfo opLedinfo)
    {
        List<OpLedinfo> list = opLedinfoService.selectOpLedinfoList(opLedinfo);
        ExcelUtil<OpLedinfo> util = new ExcelUtil<OpLedinfo>(OpLedinfo.class);
        return util.exportExcel(list, "ledinfo");
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
    @RequiresPermissions("system:ledinfo:add")
    @Log(title = "【请填写功能名称】", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(OpLedinfo opLedinfo)
    {
        return toAjax(opLedinfoService.insertOpLedinfo(opLedinfo));
    }

    /**
     * 修改【请填写功能名称】
     */
    @GetMapping("/edit/{ledId}")
    public String edit(@PathVariable("ledId") String ledId, ModelMap mmap)
    {
        OpLedinfo opLedinfo = opLedinfoService.selectOpLedinfoById(ledId);
        mmap.put("opLedinfo", opLedinfo);
        return prefix + "/edit";
    }

    /**
     * 修改保存【请填写功能名称】
     */
    @RequiresPermissions("system:ledinfo:edit")
    @Log(title = "【请填写功能名称】", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(OpLedinfo opLedinfo)
    {
        return toAjax(opLedinfoService.updateOpLedinfo(opLedinfo));
    }

    /**
     * 删除【请填写功能名称】
     */
    @RequiresPermissions("system:ledinfo:remove")
    @Log(title = "【请填写功能名称】", businessType = BusinessType.DELETE)
    @PostMapping( "/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        return toAjax(opLedinfoService.deleteOpLedinfoByIds(ids));
    }
}
