package com.ruoyi.project.system.skyinfo.controller;

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
import com.ruoyi.project.system.skyinfo.domain.SkyInfo;
import com.ruoyi.project.system.skyinfo.service.ISkyInfoService;
import com.ruoyi.framework.web.controller.BaseController;
import com.ruoyi.framework.web.domain.AjaxResult;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.framework.web.page.TableDataInfo;

/**
 * 速客云api请求参数信息Controller
 * 
 * @author ruoyi
 * @date 2023-06-03
 */
@Controller
@RequestMapping("/system/skyinfo")
public class SkyInfoController extends BaseController
{
    private String prefix = "system/skyinfo";

    @Autowired
    private ISkyInfoService skyInfoService;

    @RequiresPermissions("system:skyinfo:view")
    @GetMapping()
    public String skyinfo()
    {
        return prefix + "/skyinfo";
    }

    /**
     * 查询速客云api请求参数信息列表
     */
    @RequiresPermissions("system:skyinfo:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(SkyInfo skyInfo)
    {
        startPage();
        List<SkyInfo> list = skyInfoService.selectSkyInfoList(skyInfo);
        return getDataTable(list);
    }

    /**
     * 导出速客云api请求参数信息列表
     */
    @RequiresPermissions("system:skyinfo:export")
    @Log(title = "速客云api请求参数信息", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(SkyInfo skyInfo)
    {
        List<SkyInfo> list = skyInfoService.selectSkyInfoList(skyInfo);
        ExcelUtil<SkyInfo> util = new ExcelUtil<SkyInfo>(SkyInfo.class);
        return util.exportExcel(list, "skyinfo");
    }

    /**
     * 新增速客云api请求参数信息
     */
    @GetMapping("/add")
    public String add()
    {
        return prefix + "/add";
    }

    /**
     * 新增保存速客云api请求参数信息
     */
    @RequiresPermissions("system:skyinfo:add")
    @Log(title = "速客云api请求参数信息", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(SkyInfo skyInfo)
    {
        return toAjax(skyInfoService.insertSkyInfo(skyInfo));
    }

    /**
     * 修改速客云api请求参数信息
     */
    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") Long id, ModelMap mmap)
    {
        SkyInfo skyInfo = skyInfoService.selectSkyInfoById(id);
        mmap.put("skyInfo", skyInfo);
        return prefix + "/edit";
    }

    /**
     * 修改保存速客云api请求参数信息
     */
    @RequiresPermissions("system:skyinfo:edit")
    @Log(title = "速客云api请求参数信息", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(SkyInfo skyInfo)
    {
        return toAjax(skyInfoService.updateSkyInfo(skyInfo));
    }

    /**
     * 删除速客云api请求参数信息
     */
    @RequiresPermissions("system:skyinfo:remove")
    @Log(title = "速客云api请求参数信息", businessType = BusinessType.DELETE)
    @PostMapping( "/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        return toAjax(skyInfoService.deleteSkyInfoByIds(ids));
    }
}
