package com.ruoyi.project.system.greenhouse.controller;

import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.framework.aspectj.lang.annotation.Log;
import com.ruoyi.framework.aspectj.lang.enums.BusinessType;
import com.ruoyi.framework.web.controller.BaseController;
import com.ruoyi.framework.web.domain.AjaxResult;
import com.ruoyi.framework.web.page.TableDataInfo;
import com.ruoyi.project.system.devctrl.domain.GmDevctrl;
import com.ruoyi.project.system.devctrl.service.IGmDevctrlService;
import com.ruoyi.project.system.greenhouse.domain.ProGreenhouse;
import com.ruoyi.project.system.greenhouse.service.IProGreenhouseService;
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
 * @date 2020-12-04
 */
@Controller
@RequestMapping("/system/greenhouse")
public class ProGreenhouseController extends BaseController
{
    private String prefix = "system/greenhouse";

    @Autowired
    private IProGreenhouseService proGreenhouseService;
    @Autowired
    private IGmDevctrlService gmDevctrlService;



    @RequiresPermissions("system:greenhouse:view")
    @GetMapping()
    public String greenhouse()
    {
        return prefix + "/greenhouse";
    }

    /**
     * 查询【请填写功能名称】列表
     */
    @RequiresPermissions("system:greenhouse:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(ProGreenhouse proGreenhouse)
    {
        startPage();
        List<ProGreenhouse> list = proGreenhouseService.selectProGreenhouseList(proGreenhouse);
        return getDataTable(list);
    }

    /**
     * 导出【请填写功能名称】列表
     */
    @RequiresPermissions("system:greenhouse:export")
    @Log(title = "【请填写功能名称】", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(ProGreenhouse proGreenhouse)
    {
        List<ProGreenhouse> list = proGreenhouseService.selectProGreenhouseList(proGreenhouse);
        ExcelUtil<ProGreenhouse> util = new ExcelUtil<ProGreenhouse>(ProGreenhouse.class);
        return util.exportExcel(list, "greenhouse");
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
    @RequiresPermissions("system:greenhouse:add")
    @Log(title = "【请填写功能名称】", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(ProGreenhouse proGreenhouse)
    {
        return toAjax(proGreenhouseService.insertProGreenhouse(proGreenhouse));
    }
    /**
     * 保存对象【请填写功能名称】
     */
    @Log(title = "【请填写功能名称】", businessType = BusinessType.INSERT)
    @PostMapping("/addGH")
    @ResponseBody
    public AjaxResult addGH(ProGreenhouse proGreenhouse)
    {

        String sceneId = proGreenhouse.getSceneId();
        GmDevctrl gmDevctrl = new GmDevctrl();
        gmDevctrl.setSceneId(sceneId);
        List<GmDevctrl> gmDevctrls = gmDevctrlService.selectGmDevctrlList(gmDevctrl);
        if(gmDevctrls.size()>0){
            proGreenhouse.setDectId(gmDevctrls.get(0).getDectId());
        }
        return toAjax(proGreenhouseService.insertProGreenhouse(proGreenhouse));
    }

    /**
     * 修改【请填写功能名称】
     */
    @GetMapping("/edit/{greId}")
    public String edit(@PathVariable("greId") String greId, ModelMap mmap)
    {
        ProGreenhouse proGreenhouse = proGreenhouseService.selectProGreenhouseById(greId);
        mmap.put("proGreenhouse", proGreenhouse);
        return prefix + "/edit";
    }

    /**
     * 修改保存【请填写功能名称】
     */
    @RequiresPermissions("system:greenhouse:edit")
    @Log(title = "【请填写功能名称】", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(ProGreenhouse proGreenhouse)
    {
        return toAjax(proGreenhouseService.updateProGreenhouse(proGreenhouse));
    }

    /**
     * 删除【请填写功能名称】
     */
    @RequiresPermissions("system:greenhouse:remove")
    @Log(title = "【请填写功能名称】", businessType = BusinessType.DELETE)
    @PostMapping( "/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        return toAjax(proGreenhouseService.deleteProGreenhouseByIds(ids));
    }






    /**
     * 修改【请填写功能名称】
     */
    @GetMapping("/editGreenhouse")
    public String editGreenhouse(ProGreenhouse proGreenhouse, ModelMap mmap)
    {
        List<ProGreenhouse> proGreenhouses = proGreenhouseService.selectProGreenhouseList(proGreenhouse);
        if(proGreenhouses.size()>0){
            mmap.put("proGreenhouse", proGreenhouses.get(0));
            return prefix + "/edit";
        }else{

            return prefix + "/add";
        }
    }



}
