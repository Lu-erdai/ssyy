package com.ruoyi.project.tool.swagger;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.ruoyi.framework.web.controller.BaseController;
import com.ruoyi.framework.web.domain.AjaxResult;
import com.ruoyi.project.system.htzkhistorydata.domain.GmHtzkHistorydata;
import com.ruoyi.project.system.htzkhistorydata.service.IGmHtzkHistorydataService;
import com.ruoyi.project.system.htzklastdata.domain.GmHtzkLastdata;
import com.ruoyi.project.system.htzklastdata.service.IGmHtzkLastdataService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

/**
 * 【请填写功能名称】Controller
 *
 * @author ruoyi
 * @date 2020-11-30
 */
@Api("获取皓天智控接口数据")
@RestController
@RequestMapping("/htzk/api")
public class HtAPIController extends BaseController {

    @Autowired
    IGmHtzkHistorydataService gmHtzkHistorydataService;

    @Autowired
    IGmHtzkLastdataService gmHtzkLastdataService;


    public static final String appKey = "ZYvXbEDx";
    public static final String appSecret = "faf18929985e349a3d74f1fcc959e6dcdb23f392";

    public static final String getTokenUrl = "http://rrnyy.cn/htzk/pub/data/getAccessToken";
    public static final String appType = "HTZK";



    @ApiOperation("根据令牌获取传感器数据")
    @ApiImplicitParam()
    @GetMapping("/getGatewayInfo")
    public String getAllData() {
        String tokenUrl = getTokenUrl+"?appKey="+appKey+"&appSecret="+appSecret;
        TestRrnyy restUtil = new TestRrnyy();
        try {
            String tokenJson = restUtil.load(tokenUrl);
            ObjectMapper mapper = new ObjectMapper();
            HtzkVO htzkVO = mapper.readValue(tokenJson,HtzkVO.class);
            String token = htzkVO.getBody();

            List<String> sNs = new ArrayList<>();
            //姜开农场一号菇房
            sNs.add("G12201114008");
            sNs.add("G12201114003");
            sNs.add("G12201114001");

            //姜开农场二号菇房
            sNs.add("G12201114005");
            sNs.add("G12201114004");
            sNs.add("G12201114002");

            //姜开农场三号菇房
            sNs.add("G12201114006");
            sNs.add("G12201114010");
            sNs.add("G12201114011");

            //姜开农场三号菇房
            sNs.add("G12201114007");
            sNs.add("G12201114009");
            String resultList = HttpBrokerController.httpURLConectionGET(token, appType, sNs);
            return resultList;

        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }




    @ApiOperation("根据令牌获取指定传感器数据")
    @ApiImplicitParam(name = "gatewaySN", value = "通道Id", required = true, dataType = "String", paramType = "path")
    @GetMapping("/getGatewayInfoBySN")
    public String getGatewayInfoBySN(@RequestParam String gatewaySN) {
        //根据场景Id获取通道id
        String tokenUrl = getTokenUrl+"?appKey="+appKey+"&appSecret="+appSecret;
        TestRrnyy restUtil = new TestRrnyy();
        try {
            String tokenJson = restUtil.load(tokenUrl);
            ObjectMapper mapper = new ObjectMapper();
            HtzkVO htzkVO = mapper.readValue(tokenJson,HtzkVO.class);
            String token = htzkVO.getBody();

            List<String> sNs = new ArrayList<>();
            //姜开农场一号菇房
            sNs.add(gatewaySN);
            String resultList = HttpBrokerController.httpURLConectionGET(token, appType, sNs);
            return resultList;

        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;


    }




    @ApiOperation("根据gatewaySN和code获取最近50条数据")
    @GetMapping("/getHisDataBySNCode")
    public AjaxResult getHisDataBySNCode(@RequestParam String gatewaySN,@RequestParam String code) {


        List<GmHtzkHistorydata> gmHtzkHistorydata = gmHtzkHistorydataService.selectHtzkHisDateBySNCodeLimit50(gatewaySN, code);

        return AjaxResult.success(gmHtzkHistorydata);


    }


    @ApiOperation("获取所有最新数据")
    @GetMapping("/getAllLastData")
    public AjaxResult getAllLastData() {

        List<GmHtzkLastdata> gmHtzkLastdata = gmHtzkLastdataService.selectAllLastData();

        return AjaxResult.success(gmHtzkLastdata);


    }

    @ApiOperation("根据gatewaySN和code获取最新")
    @GetMapping("/getLastDataBySNCode")
    public AjaxResult getLastDataBySNCode(@RequestParam String gatewaySN,@RequestParam String code) {

        List<GmHtzkLastdata> gmHtzkLastdata = gmHtzkLastdataService.selectAllLastDataBySNCode(gatewaySN, code);

        return AjaxResult.success(gmHtzkLastdata);


    }





}
