package com.ruoyi.project.system.devctrlbtn.controller;

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
import com.ruoyi.project.system.devctrlbtn.domain.OpDevctrlbtn;
import com.ruoyi.project.system.devctrlbtn.service.IOpDevctrlbtnService;
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
@RequestMapping("/system/devctrlbtn")
public class OpDevctrlbtnController extends BaseController
{
    private String prefix = "system/devctrlbtn";

    @Autowired
    private IOpDevctrlbtnService opDevctrlbtnService;

    @RequiresPermissions("system:devctrlbtn:view")
    @GetMapping()
    public String devctrlbtn()
    {
        return prefix + "/devctrlbtn";
    }

    /**
     * 查询【请填写功能名称】列表
     */
    @RequiresPermissions("system:devctrlbtn:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(OpDevctrlbtn opDevctrlbtn)
    {
        startPage();
        List<OpDevctrlbtn> list = opDevctrlbtnService.selectOpDevctrlbtnList(opDevctrlbtn);
        return getDataTable(list);
    }

    /**
     * 导出【请填写功能名称】列表
     */
    @RequiresPermissions("system:devctrlbtn:export")
    @Log(title = "【请填写功能名称】", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(OpDevctrlbtn opDevctrlbtn)
    {
        List<OpDevctrlbtn> list = opDevctrlbtnService.selectOpDevctrlbtnList(opDevctrlbtn);
        ExcelUtil<OpDevctrlbtn> util = new ExcelUtil<OpDevctrlbtn>(OpDevctrlbtn.class);
        return util.exportExcel(list, "devctrlbtn");
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
    @RequiresPermissions("system:devctrlbtn:add")
    @Log(title = "【请填写功能名称】", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(OpDevctrlbtn opDevctrlbtn)
    {
        return toAjax(opDevctrlbtnService.insertOpDevctrlbtn(opDevctrlbtn));
    }

    /**
     * 修改【请填写功能名称】
     */
    @GetMapping("/edit/{dectbtnId}")
    public String edit(@PathVariable("dectbtnId") String dectbtnId, ModelMap mmap)
    {
        OpDevctrlbtn opDevctrlbtn = opDevctrlbtnService.selectOpDevctrlbtnById(dectbtnId);
        mmap.put("opDevctrlbtn", opDevctrlbtn);
        return prefix + "/edit";
    }

    /**
     * 修改保存【请填写功能名称】
     */
    @RequiresPermissions("system:devctrlbtn:edit")
    @Log(title = "【请填写功能名称】", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(OpDevctrlbtn opDevctrlbtn)
    {
        return toAjax(opDevctrlbtnService.updateOpDevctrlbtn(opDevctrlbtn));
    }

    /**
     * 删除【请填写功能名称】
     */
    @RequiresPermissions("system:devctrlbtn:remove")
    @Log(title = "【请填写功能名称】", businessType = BusinessType.DELETE)
    @PostMapping( "/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        return toAjax(opDevctrlbtnService.deleteOpDevctrlbtnByIds(ids));
    }
}
