package com.ruoyi.project.system.msgmonitor.controller;

import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.framework.aspectj.lang.annotation.Log;
import com.ruoyi.framework.aspectj.lang.enums.BusinessType;
import com.ruoyi.framework.web.controller.BaseController;
import com.ruoyi.framework.web.domain.AjaxResult;
import com.ruoyi.framework.web.page.TableDataInfo;
import com.ruoyi.project.system.msgmonitor.domain.OpMsgmonitor;
import com.ruoyi.project.system.msgmonitor.service.IOpMsgmonitorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 短信监控配置信息Controller
 * 
 * @author ruoyi
 * @date 2020-12-07
 */
@Controller
@RequestMapping("/system/msgmonitor")
public class OpMsgmonitorController extends BaseController
{
    private String prefix = "system/msgmonitor";

    @Autowired
    private IOpMsgmonitorService opMsgmonitorService;

    @GetMapping()
    public String msgmonitor()
    {
        return prefix + "/msgmonitor";
    }

    /**
     * 查询短信监控配置信息列表
     */
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(OpMsgmonitor opMsgmonitor)
    {
        startPage();
        List<OpMsgmonitor> list = opMsgmonitorService.selectOpMsgmonitorList(opMsgmonitor);
        return getDataTable(list);
    }

    /**
     * 导出短信监控配置信息列表
     */
    @Log(title = "短信监控配置信息", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(OpMsgmonitor opMsgmonitor)
    {
        List<OpMsgmonitor> list = opMsgmonitorService.selectOpMsgmonitorList(opMsgmonitor);
        ExcelUtil<OpMsgmonitor> util = new ExcelUtil<OpMsgmonitor>(OpMsgmonitor.class);
        return util.exportExcel(list, "msgmonitor");
    }

    /**
     * 新增短信监控配置信息
     */
    @GetMapping("/add")
    public String add()
    {
        return prefix + "/add";
    }

    /**
     * 新增保存短信监控配置信息
     */
    @Log(title = "短信监控配置信息", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(OpMsgmonitor opMsgmonitor)
    {
        return toAjax(opMsgmonitorService.insertOpMsgmonitor(opMsgmonitor));
    }

    /**
     * 修改短信监控配置信息
     */
    @GetMapping("/edit/{mesId}")
    public String edit(@PathVariable("mesId") String mesId, ModelMap mmap)
    {
        OpMsgmonitor opMsgmonitor = opMsgmonitorService.selectOpMsgmonitorById(mesId);
        mmap.put("opMsgmonitor", opMsgmonitor);
        return prefix + "/edit";
    }

    /**
     * 修改保存短信监控配置信息
     */
    @Log(title = "短信监控配置信息", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(OpMsgmonitor opMsgmonitor)
    {
        return toAjax(opMsgmonitorService.updateOpMsgmonitor(opMsgmonitor));
    }

    /**
     * 删除短信监控配置信息
     */
    @Log(title = "短信监控配置信息", businessType = BusinessType.DELETE)
    @PostMapping( "/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        return toAjax(opMsgmonitorService.deleteOpMsgmonitorByIds(ids));
    }
}
