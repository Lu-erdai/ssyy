package com.ruoyi.project.system.devctrl.controller;

import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.framework.aspectj.lang.annotation.Log;
import com.ruoyi.framework.aspectj.lang.enums.BusinessType;
import com.ruoyi.framework.web.controller.BaseController;
import com.ruoyi.framework.web.domain.AjaxResult;
import com.ruoyi.framework.web.page.TableDataInfo;
import com.ruoyi.project.system.devctrl.domain.GmDevctrl;
import com.ruoyi.project.system.devctrl.service.IGmDevctrlService;
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
 * @date 2020-12-01
 */
@Controller
@RequestMapping("/system/devctrl")
public class GmDevctrlController extends BaseController {
    private String prefix = "system/devctrl";

    @Autowired
    private IGmDevctrlService gmDevctrlService;

    @RequiresPermissions("system:devctrl:view")
    @GetMapping()
    public String devctrl() {
        return prefix + "/devctrl";
    }

    /**
     * 查询【请填写功能名称】列表
     */
    @RequiresPermissions("system:devctrl:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(GmDevctrl gmDevctrl) {
        startPage();
        List<GmDevctrl> list = gmDevctrlService.selectGmDevctrlList(gmDevctrl);
        return getDataTable(list);
    }


    /**
     * 导出【请填写功能名称】列表
     */
    @RequiresPermissions("system:devctrl:export")
    @Log(title = "【请填写功能名称】", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(GmDevctrl gmDevctrl) {
        List<GmDevctrl> list = gmDevctrlService.selectGmDevctrlList(gmDevctrl);
        ExcelUtil<GmDevctrl> util = new ExcelUtil<GmDevctrl>(GmDevctrl.class);
        return util.exportExcel(list, "devctrl");
    }

    /**
     * 新增【请填写功能名称】
     */
    @GetMapping("/add")
    public String add() {
        return prefix + "/add";
    }

    /**
     * 新增保存【请填写功能名称】
     */
    @RequiresPermissions("system:devctrl:add")
    @Log(title = "【请填写功能名称】", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(GmDevctrl gmDevctrl) {
        return toAjax(gmDevctrlService.insertGmDevctrl(gmDevctrl));
    }

    /**
     * 修改【请填写功能名称】
     */
    @GetMapping("/edit/{dectId}")
    public String edit(@PathVariable("dectId") String dectId, ModelMap mmap) {
        GmDevctrl gmDevctrl = gmDevctrlService.selectGmDevctrlById(dectId);
        mmap.put("gmDevctrl", gmDevctrl);
        return prefix + "/edit";
    }

    /**
     * 修改保存【请填写功能名称】
     */
    @RequiresPermissions("system:devctrl:edit")
    @Log(title = "【请填写功能名称】", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(GmDevctrl gmDevctrl) {
        return toAjax(gmDevctrlService.updateGmDevctrl(gmDevctrl));
    }

    /**
     * 删除【请填写功能名称】
     */
    @RequiresPermissions("system:devctrl:remove")
    @Log(title = "【请填写功能名称】", businessType = BusinessType.DELETE)
    @PostMapping("/remove")
    @ResponseBody
    public AjaxResult remove(String ids) {
        return toAjax(gmDevctrlService.deleteGmDevctrlByIds(ids));
    }


    //    /**
//     * 修改保存【请填写功能名称】
//     */
    @GetMapping("/getAllDevBut")
    @ResponseBody
    public String getAllDevBut(String sceneId) {
        String result = gmDevctrlService.getAllDevBut(sceneId);

        return result;

    }


    //    /**
//     * 给操作表
//     */
    @GetMapping("/operate")
    @ResponseBody
    public String operate(String dectId, String decoType) {
        String result = gmDevctrlService.operate(dectId, decoType);
        return result;
    }


    //    /**
//     * 定时查询操作表按钮回馈
//     */
    @GetMapping("/operateMsg")
    @ResponseBody
    public String operateMsg(String dectId) {
        String result = gmDevctrlService.operateMsg(dectId);
        return result;
    }


}
