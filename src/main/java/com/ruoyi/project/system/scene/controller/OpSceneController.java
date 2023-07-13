package com.ruoyi.project.system.scene.controller;

import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.framework.aspectj.lang.annotation.Log;
import com.ruoyi.framework.aspectj.lang.enums.BusinessType;
import com.ruoyi.framework.web.controller.BaseController;
import com.ruoyi.framework.web.domain.AjaxResult;
import com.ruoyi.framework.web.domain.ZtreeString;
import com.ruoyi.framework.web.page.TableDataInfo;
import com.ruoyi.project.system.channel.domain.GmChannel;
import com.ruoyi.project.system.channel.service.IGmChannelService;
import com.ruoyi.project.system.historydata.service.IGmHistorydataService;
import com.ruoyi.project.system.scene.domain.OpScene;
import com.ruoyi.project.system.scene.service.IOpSceneService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 场景Controller
 * 
 * @author ruoyi
 * @date 2020-11-25
 */
@Controller
@RequestMapping("/system/scene")
public class OpSceneController extends BaseController
{
    private String prefix = "system/scene";

    @Autowired
    private IOpSceneService opSceneService;

    @Autowired
    private IGmChannelService gmChannelService;

    @Autowired
    private IGmHistorydataService gmHistorydataService;

    @RequiresPermissions("system:scene:view")
    @GetMapping()
    public String scene()
    {
        return prefix + "/scene";
    }

    /**
     * 查询场景列表
     */
//    @RequiresPermissions("system:scene:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(OpScene opScene)
    {
        startPage();
        List<OpScene> list = opSceneService.selectOpSceneList(opScene);
        return getDataTable(list);
    }
    /**
     * 查询场景列表
     */
//    @RequiresPermissions("system:scene:list")
    @PostMapping("/noParentList")
    @ResponseBody
    public TableDataInfo noParentList()
    {
        startPage();
        List<OpScene> list = opSceneService.selectNoParentList(getUserId());
        return getDataTable(list);
    }

    /**
     * 导出场景列表
     */
    @RequiresPermissions("system:scene:export")
    @Log(title = "场景", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(OpScene opScene)
    {
        List<OpScene> list = opSceneService.selectOpSceneList(opScene);
        ExcelUtil<OpScene> util = new ExcelUtil<OpScene>(OpScene.class);
        return util.exportExcel(list, "scene");
    }

    /**
     * 新增场景
     */
    @GetMapping("/add")
    public String add()
    {
        return prefix + "/add";
    }

    /**
     * 新增保存场景
     */
    @RequiresPermissions("system:scene:add")
    @Log(title = "场景", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(OpScene opScene)
    {
        return toAjax(opSceneService.insertOpScene(opScene));
    }

    /**
     * 修改场景
     */
    @GetMapping("/edit/{sceneId}")
    public String edit(@PathVariable("sceneId") Long sceneId, ModelMap mmap)
    {
        OpScene opScene = opSceneService.selectOpSceneById(sceneId);
        mmap.put("opScene", opScene);
        return prefix + "/edit";
    }

    /**
     * 修改保存场景
     */
    @RequiresPermissions("system:scene:edit")
    @Log(title = "场景", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(OpScene opScene)
    {
        return toAjax(opSceneService.updateOpScene(opScene));
    }

    /**
     * 删除场景
     */
    @RequiresPermissions("system:scene:remove")
    @Log(title = "场景", businessType = BusinessType.DELETE)
    @PostMapping( "/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        return toAjax(opSceneService.deleteOpSceneByIds(ids));
    }




    /**
     * 选择场景树
     *
     */
    @GetMapping(value = { "/selectSceneTree"})
    public String selectSceneTree( ModelMap mmap)
    {
        Long userId = this.getUserId();
        mmap.put("userId", userId);
        return prefix + "/tree";
    }
    /**
     * 选择场景树
     *
     */
    @GetMapping(value = { "/initScene"})
    @ResponseBody
    public String initScene()
    {
        Long userId = this.getUserId();
        String scene = opSceneService.selectScene(userId);
        return scene;
    }






    /**
     * 加载场景列表树
     */
    @GetMapping("/treeData")
    @ResponseBody
    public List<ZtreeString> treeData()
    {
        Long userId = this.getUserId();
//        List<Ztree> ztrees = opSceneService.selectSceneTree(userId);
        List<ZtreeString> ztrees = opSceneService.selectSceneTree(userId);

        return ztrees;
    }


    /**
     * 加载echarts图所需数据
     */
    @GetMapping("/getChartsDatas")
    public String   getChartsDatas(GmChannel channel,ModelMap mmap)
    {
        //查询该sceneID下对应的chtype_no所有通道
//        List<GmChannel> channelList =gmChannelService.selectGmChannelList(channel);
//        if(channelList.size()>0){
//            for(GmChannel gmChannel:channelList){
//                gmHistorydataService.selectLimit144ByCh_id(gmChannel.getChId());
//
//
//            }
//
//
//        }
        //查询该chId下的history数据绘制echarts
//        GmHistorydata gmHistorydata = new GmHistorydata();
//        gmHistorydata.setChId(channel.getChId());
        String historyJson = gmHistorydataService.getEchartsData(channel);
        mmap.put("historyJson",historyJson);
        return prefix + "/charts";
    }

    /**
     * 加载echarts图所需数据
     */
    @GetMapping("/getChartsDatasWithTime")
    public String  getChartsDatasWithTime(GmChannel channel,String startTime,String endTime, ModelMap mmap)
    {
        String historyJson = gmHistorydataService.getEchartsDataWithTime(channel,startTime,endTime);
        mmap.put("historyJson",historyJson);
        return prefix + "/charts";
    }

    /**
     * 加载echarts图所需数据
     */
    @GetMapping("/findAllChannelBySceneId")
    @ResponseBody
    public String  findAllChannelBySceneId(String sceneId)
    {
        String allChannelJson = gmChannelService.getAllChannel(sceneId);
        return allChannelJson;
    }
}
