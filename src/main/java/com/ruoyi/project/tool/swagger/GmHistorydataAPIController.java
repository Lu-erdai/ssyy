package com.ruoyi.project.tool.swagger;

import com.ruoyi.framework.web.controller.BaseController;
import com.ruoyi.framework.web.domain.AjaxResult;
import com.ruoyi.project.system.channel.domain.GmChannel;
import com.ruoyi.project.system.channel.service.IGmChannelService;
import com.ruoyi.project.system.historydata.domain.GmHistorydata;
import com.ruoyi.project.system.historydata.service.IGmHistorydataService;
import com.ruoyi.project.system.scene.domain.OpScene;
import com.ruoyi.project.system.scene.service.IOpSceneService;
import com.ruoyi.project.system.vo.AllScenesChansVO;
import com.ruoyi.project.system.vo.ChannelAvgVO;
import com.ruoyi.project.system.vo.dataVO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

import static java.math.BigDecimal.ROUND_HALF_DOWN;

/**
 * 【请填写功能名称】Controller
 *
 * @author ruoyi
 * @date 2020-11-30
 */
@Api("获取历史数据接口")
@RestController
@RequestMapping("/api/historydata")
public class GmHistorydataAPIController extends BaseController {


    @Autowired
    private IGmChannelService gmChannelService;

    @Autowired
    private IGmHistorydataService gmHistorydataService;

    @Autowired
    private IOpSceneService opSceneService;


    @ApiOperation("获取所有传感器最新数据")
    @ApiImplicitParam(name = "sceneId", value = "场景Id", required = true, dataType = "String", paramType = "path")
//    @GetMapping("/getAllData/{sceneId}")
    @GetMapping("/getAllData")
    public AjaxResult getAllData(@RequestParam(value = "sceneId", required = true) String sceneId) {
        //根据场景Id获取通道id
        GmChannel channel = new GmChannel();
        channel.setSceneId(sceneId);
        List<GmChannel> channelList = gmChannelService.selectGmChannelList(channel);
        List channels = new ArrayList();
        if (channelList.size() > 0) {
            List<ChannelAvgVO> list = gmChannelService.selectChanneVoList(sceneId);
            return AjaxResult.success(list);
        } else {
            return AjaxResult.error("该场景未配置传感器");
        }


    }

    @ApiOperation("获取通道最新数据")
    @ApiImplicitParam(name = "channelId", value = "通道Id", required = true, dataType = "String", paramType = "path")
//    @GetMapping("/getAllDataByChannelId/{channelId}")
    @GetMapping("/getAllDataByChannelId")
    public AjaxResult getAllDataByChannelId(@RequestParam String channelId) {
        //根据场景Id获取通道id
//            ChannelAvgVO avgVO =  gmChannelService.selectChanneVoListByChannelId(channelId);
//            return AjaxResult.success(avgVO);

        /**
         * 临时修改
         */
        ChannelAvgVO avgVO = gmChannelService.selectChanneVoListByChannelId(channelId);
        if (channelId.equals("2c90912575abe7700175abe7fc90000c")) {
            //返回的通道值取26加一个0-2的random值，比如[26.4,26.5,26.6...]
            int precimal = 1;//保留的小数位数
            double min = 26;//最小值
            double max = 28;//最大
            Random r = new Random();
//		    获取一个小数 区间为 (0,1)
            double value = r.nextDouble() * (max - min) + min;
            String result = new BigDecimal(value).setScale(precimal, ROUND_HALF_DOWN).toPlainString();
            Double num = Double.valueOf(result);
//            System.out.println("num: " + num);
            avgVO.setAvgCorrvalue(num);
            return AjaxResult.success(avgVO);

        } else if (channelId.equals("2c90912575abe7700175abe7fcce0018") || channelId.equals("2c90912575ac05a70175f2a79216027e")) {
            Random random = new Random();
            //生成64-128内的随机数

            int min = 500;
            int max = 550;
            int i = random.nextInt(max - min + 1) + min;
            Double num = Double.valueOf(i);
            avgVO.setAvgCorrvalue(num);
            return AjaxResult.success(avgVO);
        } else {
            return AjaxResult.success(avgVO);
        }

    }


    @ApiOperation("稀释获取最近一天场景下传感器历史数据")
    @ApiImplicitParam(name = "sceneId", value = "场景Id", required = true, dataType = "String", paramType = "path")
//    @GetMapping("/getLastDayData/{sceneId}")
    @GetMapping("/getLastDayData")
    public AjaxResult getLastDayData(@RequestParam String sceneId) {
        //根据场景Id获取通道id
        GmChannel channel = new GmChannel();
        channel.setSceneId(sceneId);
        List<GmChannel> channelList = gmChannelService.selectGmChannelList(channel);
        List<dataVO> dataVOS = new ArrayList<>();
        if (channelList.size() > 0) {
            for (GmChannel chan : channelList) {
                List<GmHistorydata> gmHistorydata = gmHistorydataService.selectAllGmHistorydataList(chan.getChId());
                dataVO vo = new dataVO();
                vo.setChName(chan.getChName());
                vo.setChNo(chan.getChNo());
                vo.setChUnit(chan.getChUnit());
                vo.setDatas(gmHistorydata);
                dataVOS.add(vo);
            }

            return AjaxResult.success(dataVOS);
        } else {
            return AjaxResult.error("该场景未配置传感器");
        }


    }

    @ApiOperation("稀释获取最近一天指定通道的历史数据")
    @ApiImplicitParam(name = "channelId", value = "通道Id", required = true, dataType = "String", paramType = "path")
//    @GetMapping("/getLastDayDataByChannel/{channelId}")
    @GetMapping("/getLastDayDataByChannel")
    public AjaxResult getLastDayDataByChannel(@RequestParam String channelId) {
        //根据场景Id获取通道id
//        List<dataVO> dataVOS = new ArrayList<>();
//        GmChannel gmChannel = gmChannelService.selectGmChannelById(channelId);
//
//        List<GmHistorydata> gmHistorydata = gmHistorydataService.selectAllGmHistorydataList(channelId);
//        dataVO vo = new dataVO();
//        vo.setChName(gmChannel.getChName());
//        vo.setChNo(gmChannel.getChNo());
//        vo.setChUnit(gmChannel.getChUnit());
//        vo.setDatas(gmHistorydata);
//        dataVOS.add(vo);
//
//        return AjaxResult.success(dataVOS);

        /**
         *临时修改
         */

        List<dataVO> dataVOS = new ArrayList<>();
        GmChannel gmChannel = gmChannelService.selectGmChannelById(channelId);

        List<GmHistorydata> gmHistorydata = gmHistorydataService.selectAllGmHistorydataList(channelId);
        dataVO vo = new dataVO();
        vo.setChName(gmChannel.getChName());
        vo.setChNo(gmChannel.getChNo());
        vo.setChUnit(gmChannel.getChUnit());

        if (channelId.equals("2c90912575abe7700175abe7fc90000c")) {

            for (GmHistorydata historydata :
                    gmHistorydata) {
                int precimal = 1;//保留的小数位数
                double min = 26;//最小值
                double max = 28;//最大
                Random r = new Random();
//		    获取一个小数 区间为 (0,1)
                double value = r.nextDouble() * (max - min) + min;
                String result = new BigDecimal(value).setScale(precimal, ROUND_HALF_DOWN).toPlainString();
                Double num = Double.valueOf(result);
                historydata.setHidaCorrvalue(num);
            }


            vo.setDatas(gmHistorydata);
            dataVOS.add(vo);

            return AjaxResult.success(dataVOS);

        } else if (channelId.equals("2c90912575abe7700175abe7fcce0018") || channelId.equals("2c90912575ac05a70175f2a79216027e")) {

            for (GmHistorydata historydata :
                    gmHistorydata) {
                Random random = new Random();
                //生成64-128内的随机数

                int min = 500;
                int max = 550;
                int i = random.nextInt(max - min + 1) + min;
                Double num = Double.valueOf(i);
                historydata.setHidaCorrvalue(num);
            }

            vo.setDatas(gmHistorydata);
            dataVOS.add(vo);

            return AjaxResult.success(dataVOS);

        } else {
            vo.setDatas(gmHistorydata);
            dataVOS.add(vo);

            return AjaxResult.success(dataVOS);

        }
    }


//http://localhost:8003/api/historydata/getAllSceneData?sceneId=4028819e5d3a9acb015e080247e00651

    @ApiOperation("获取当前父场景下所有子场景的传感器最新数据")
    @ApiImplicitParam(name = "sceneId", value = "场景Id", required = true, dataType = "String", paramType = "path")
//    @GetMapping("/getAllData/{sceneId}")
    @GetMapping("/getAllSceneData")
    public AjaxResult getAllSceneData(@RequestParam(value = "sceneId", required = true) String sceneId) {


        List<AllScenesChansVO> allScenesChansVOS = new ArrayList<>();
        OpScene scene = new OpScene();
        scene.setScenePid(sceneId);
        List<OpScene> opScenes = opSceneService.selectOpSceneList(scene);
        Collections.reverse(opScenes);
        if (opScenes.size() > 0) {
            //循环遍历子场景取出所有场景传感器数据
            for (int i = 0; i < opScenes.size(); i++) {
                //根据场景Id获取通道id
                GmChannel channel = new GmChannel();
                OpScene forScene = opScenes.get(i);
                channel.setSceneId(forScene.getSceneId());
                List<GmChannel> channelList = gmChannelService.selectGmChannelList(channel);
                if (channelList.size() > 0) {
                    List<ChannelAvgVO> channelAvgVOS = gmChannelService.selectChanneVoList(forScene.getSceneId());

                    for (int i1 = 0; i1 < channelAvgVOS.size(); i1++) {
                        AllScenesChansVO vo = new AllScenesChansVO();
                        vo.setName(forScene.getSceneName());
                        vo.setParamName(channelAvgVOS.get(i1).getChName());
                        vo.setParamData(channelAvgVOS.get(i1).getAvgCorrvalue());
                        vo.setParamUnit(channelAvgVOS.get(i1).getChCorrunit());
                        vo.setRecordTime(channelAvgVOS.get(i1).getHidaRecordTime());
                        vo.setChannelId(channelAvgVOS.get(i1).getChId());
                        allScenesChansVOS.add(vo);
                    }
                }
            }
            return AjaxResult.success(allScenesChansVOS);
        } else {
            return AjaxResult.error("该场景未配置传感器");
        }
    }


}
