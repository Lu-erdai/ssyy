package com.ruoyi.project.monitor.job.task;

import cn.hutool.core.util.IdUtil;
import cn.hutool.http.HttpRequest;
import cn.hutool.http.HttpUtil;
import cn.hutool.json.JSONObject;
import cn.hutool.json.JSONUtil;
import com.ruoyi.project.monitor.job.domain.Fangshan;
import com.ruoyi.project.monitor.job.domain.FangshanData;
import com.ruoyi.project.system.historydata.domain.GmHistorydata;
import com.ruoyi.project.system.historydata.service.IGmHistorydataService;
import com.ruoyi.project.system.latestdata.domain.GmLatestdata;
import com.ruoyi.project.system.latestdata.service.IGmLatestdataService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@Component
@Lazy(false)
public class CollectFangshanDataTask {
//    @Autowired
//    private DeviceService deviceService;
//
//    @Autowired
//    private DeviceChannelHisDataService deviceChannelHisDataService;

    @Autowired
    private IGmHistorydataService gmHistorydataService;

    @Autowired
    private IGmLatestdataService gmLatestdataService;


    private static Logger logger;
    public static ExecutorService executor;

    public static final String tokenUrl = "https://wulink.tech/iot/oauth/token";

    public static final String A5Url = "https://iot.wulink.tech/api/v1/gateways/6252/metrics/last";
    public static final String B5Url = "https://iot.wulink.tech/api/v1/gateways/6251/metrics/last";


    static {
        CollectFangshanDataTask.logger = LoggerFactory.getLogger(CollectFangshanDataTask.class);
        CollectFangshanDataTask.executor = Executors.newFixedThreadPool(20);
    }


        @Scheduled(cron = "0 0/10 * * * ?")
//    @Scheduled(fixedRate = 10000)
    public void execute() throws Exception {
        logger.info("定时获取房山数据============================");
        synchronized (this) {

            HashMap<String, Object> paramMap = new HashMap<>();
            paramMap.put("grant_type", "client_credentials");
            paramMap.put("client_id", "18352489756");
            paramMap.put("client_secret", "12345678");

            String result = HttpUtil.post(tokenUrl, paramMap);

            JSONObject resultObject = JSONUtil.parseObj(result);
            String access_token = resultObject.getStr("access_token");

            System.out.println("access_token" + access_token);

            String headerStr = "Bearer " + access_token;
            String a5Rst = HttpRequest.get(A5Url).header("Authorization", headerStr).execute().body();
            String b5Rst = HttpRequest.get(B5Url).header("Authorization", headerStr).execute().body();

//          解析温室A5数据
            JSONObject a5RstObject = JSONUtil.parseObj(a5Rst);
            String metricsObjA5 = a5RstObject.getStr("data");


            Fangshan fangshanA5 = com.alibaba.fastjson.JSONObject.parseObject(metricsObjA5, Fangshan.class);

            List<FangshanData> metricsA5 = fangshanA5.getMetrics();
            for (int i = 0; i < metricsA5.size(); i++) {
                if (metricsA5.get(i).getName().equals("1-1-C1")) {          //1号节点温度（℃）3c90912575ac05a70175cf22121301

                    GmHistorydata hisData = getHisData(metricsA5.get(i), "3c90912575ac05a70175cf22121301");
                    GmLatestdata latestdata = getLastData(metricsA5.get(i), "3c90912575ac05a70175cf22121301");
                    int i1 = addData(hisData, latestdata);
                    if (i1 == 1) {
                        logger.info(metricsA5.get(i).getName() + "插入成功=============================================");
                    }
                } else if (metricsA5.get(i).getName().equals("1-2-C2")) {   //1号节点湿度（%）3c90912575ac05a70175cf22121302

                    GmHistorydata hisData = getHisData(metricsA5.get(i), "3c90912575ac05a70175cf22121302");
                    GmLatestdata latestdata = getLastData(metricsA5.get(i), "3c90912575ac05a70175cf22121302");
                    int i1 = addData(hisData, latestdata);
                    if (i1 == 1) {
                        logger.info(metricsA5.get(i).getName() + "插入成功=============================================");
                    }
                } else if (metricsA5.get(i).getName().equals("1-3-C3")) {   //1号节点照度（Lux）3c90912575ac05a70175cf22121303

                    GmHistorydata hisData = getHisData(metricsA5.get(i), "3c90912575ac05a70175cf22121303");
                    GmLatestdata latestdata = getLastData(metricsA5.get(i), "3c90912575ac05a70175cf22121303");
                    int i1 = addData(hisData, latestdata);
                    if (i1 == 1) {
                        logger.info(metricsA5.get(i).getName() + "插入成功=============================================");
                    }
                } else if (metricsA5.get(i).getName().equals("1-4-C242")) { //1号节点电池电压（V）3c90912575ac05a70175cf22121304

                    GmHistorydata hisData = getHisData(metricsA5.get(i), "3c90912575ac05a70175cf22121304");
                    GmLatestdata latestdata = getLastData(metricsA5.get(i), "3c90912575ac05a70175cf22121304");
                    int i1 = addData(hisData, latestdata);
                    if (i1 == 1) {
                        logger.info(metricsA5.get(i).getName() + "插入成功=============================================");
                    }
                } else if (metricsA5.get(i).getName().equals("2-1-C1")) {   //2号节点温度（℃）3c90912575ac05a70175cf22121305

                    GmHistorydata hisData = getHisData(metricsA5.get(i), "3c90912575ac05a70175cf22121305");
                    GmLatestdata latestdata = getLastData(metricsA5.get(i), "3c90912575ac05a70175cf22121305");
                    int i1 = addData(hisData, latestdata);
                    if (i1 == 1) {
                        logger.info(metricsA5.get(i).getName() + "插入成功=============================================");
                    }
                } else if (metricsA5.get(i).getName().equals("2-2-C2")) {   //2号节点湿度（%）3c90912575ac05a70175cf22121306

                    GmHistorydata hisData = getHisData(metricsA5.get(i), "3c90912575ac05a70175cf22121306");
                    GmLatestdata latestdata = getLastData(metricsA5.get(i), "3c90912575ac05a70175cf22121306");
                    int i1 = addData(hisData, latestdata);
                    if (i1 == 1) {
                        logger.info(metricsA5.get(i).getName() + "插入成功=============================================");
                    }
                } else if (metricsA5.get(i).getName().equals("2-3-C3")) {   //2号节点照度（Lux）3c90912575ac05a70175cf22121307

                    GmHistorydata hisData = getHisData(metricsA5.get(i), "3c90912575ac05a70175cf22121307");
                    GmLatestdata latestdata = getLastData(metricsA5.get(i), "3c90912575ac05a70175cf22121307");
                    int i1 = addData(hisData, latestdata);
                    if (i1 == 1) {
                        logger.info(metricsA5.get(i).getName() + "插入成功=============================================");
                    }
                } else if (metricsA5.get(i).getName().equals("2-4-C242")) { //2号节点电池电压（V）3c90912575ac05a70175cf22121308

                    GmHistorydata hisData = getHisData(metricsA5.get(i), "3c90912575ac05a70175cf22121308");
                    GmLatestdata latestdata = getLastData(metricsA5.get(i), "3c90912575ac05a70175cf22121308");
                    int i1 = addData(hisData, latestdata);
                    if (i1 == 1) {
                        logger.info(metricsA5.get(i).getName() + "插入成功=============================================");
                    }
                } else if (metricsA5.get(i).getName().equals("3-1-C1")) {   //3号节点温度（℃）3c90912575ac05a70175cf22121309

                    GmHistorydata hisData = getHisData(metricsA5.get(i), "3c90912575ac05a70175cf22121309");
                    GmLatestdata latestdata = getLastData(metricsA5.get(i), "3c90912575ac05a70175cf22121309");
                    int i1 = addData(hisData, latestdata);
                    if (i1 == 1) {
                        logger.info(metricsA5.get(i).getName() + "插入成功=============================================");
                    }
                } else if (metricsA5.get(i).getName().equals("3-2-C2")) {   //3号节点湿度（%）3c90912575ac05a70175cf22121310

                    GmHistorydata hisData = getHisData(metricsA5.get(i), "3c90912575ac05a70175cf22121310");
                    GmLatestdata latestdata = getLastData(metricsA5.get(i), "3c90912575ac05a70175cf22121310");
                    int i1 = addData(hisData, latestdata);
                    if (i1 == 1) {
                        logger.info(metricsA5.get(i).getName() + "插入成功=============================================");
                    }
                } else if (metricsA5.get(i).getName().equals("3-3-C3")) {   //3号节点照度（Lux）3c90912575ac05a70175cf22121311

                    GmHistorydata hisData = getHisData(metricsA5.get(i), "3c90912575ac05a70175cf22121311");
                    GmLatestdata latestdata = getLastData(metricsA5.get(i), "3c90912575ac05a70175cf22121311");
                    int i1 = addData(hisData, latestdata);
                    if (i1 == 1) {
                        logger.info(metricsA5.get(i).getName() + "插入成功=============================================");
                    }
                } else if (metricsA5.get(i).getName().equals("3-4-C242")) { //3号节点电池电压（V）3c90912575ac05a70175cf22121312

                    GmHistorydata hisData = getHisData(metricsA5.get(i), "3c90912575ac05a70175cf22121312");
                    GmLatestdata latestdata = getLastData(metricsA5.get(i), "3c90912575ac05a70175cf22121312");
                    int i1 = addData(hisData, latestdata);
                    if (i1 == 1) {
                        logger.info(metricsA5.get(i).getName() + "插入成功=============================================");
                    }
                }


            }

//          解析温室B5数据
            JSONObject b5RstObject = JSONUtil.parseObj(b5Rst);
            String metricsObjB5 = b5RstObject.getStr("data");


            Fangshan fangshanB5 = com.alibaba.fastjson.JSONObject.parseObject(metricsObjB5, Fangshan.class);

            List<FangshanData> metricsB5 = fangshanB5.getMetrics();
            for (int i = 0; i < metricsB5.size(); i++) {
                if (metricsB5.get(i).getName().equals("1-1-C1")) {          //1号节点温度（℃）3c90912575ac05a70175cf22121313

                    GmHistorydata hisData = getHisData(metricsB5.get(i), "3c90912575ac05a70175cf22121313");
                    GmLatestdata latestdata = getLastData(metricsB5.get(i), "3c90912575ac05a70175cf22121313");
                    int i1 = addData(hisData, latestdata);
                    if (i1 == 1) {
                        logger.info(metricsB5.get(i).getName() + "插入成功=============================================");
                    }
                } else if (metricsB5.get(i).getName().equals("1-2-C2")) {   //1号节点湿度（%）3c90912575ac05a70175cf22121314

                    GmHistorydata hisData = getHisData(metricsB5.get(i), "3c90912575ac05a70175cf22121314");
                    GmLatestdata latestdata = getLastData(metricsB5.get(i), "3c90912575ac05a70175cf22121314");
                    int i1 = addData(hisData, latestdata);
                    if (i1 == 1) {
                        logger.info(metricsB5.get(i).getName() + "插入成功=============================================");
                    }
                } else if (metricsB5.get(i).getName().equals("1-3-C3")) {   //1号节点照度（Lux）3c90912575ac05a70175cf22121315

                    GmHistorydata hisData = getHisData(metricsB5.get(i), "3c90912575ac05a70175cf22121315");
                    GmLatestdata latestdata = getLastData(metricsB5.get(i), "3c90912575ac05a70175cf22121315");
                    int i1 = addData(hisData, latestdata);
                    if (i1 == 1) {
                        logger.info(metricsB5.get(i).getName() + "插入成功=============================================");
                    }
                } else if (metricsB5.get(i).getName().equals("1-4-C242")) { //1号节点电池电压（V）3c90912575ac05a70175cf22121316

                    GmHistorydata hisData = getHisData(metricsB5.get(i), "3c90912575ac05a70175cf22121316");
                    GmLatestdata latestdata = getLastData(metricsB5.get(i), "3c90912575ac05a70175cf22121316");
                    int i1 = addData(hisData, latestdata);
                    if (i1 == 1) {
                        logger.info(metricsB5.get(i).getName() + "插入成功=============================================");
                    }
                } else if (metricsB5.get(i).getName().equals("2-1-C1")) {   //2号节点温度（℃）3c90912575ac05a70175cf22121317

                    GmHistorydata hisData = getHisData(metricsB5.get(i), "3c90912575ac05a70175cf22121317");
                    GmLatestdata latestdata = getLastData(metricsB5.get(i), "3c90912575ac05a70175cf22121317");
                    int i1 = addData(hisData, latestdata);
                    if (i1 == 1) {
                        logger.info(metricsB5.get(i).getName() + "插入成功=============================================");
                    }
                } else if (metricsB5.get(i).getName().equals("2-2-C2")) {   //2号节点湿度（%）3c90912575ac05a70175cf22121318

                    GmHistorydata hisData = getHisData(metricsB5.get(i), "3c90912575ac05a70175cf22121318");
                    GmLatestdata latestdata = getLastData(metricsB5.get(i), "3c90912575ac05a70175cf22121318");
                    int i1 = addData(hisData, latestdata);
                    if (i1 == 1) {
                        logger.info(metricsB5.get(i).getName() + "插入成功=============================================");
                    }
                } else if (metricsB5.get(i).getName().equals("2-3-C3")) {   //2号节点照度（Lux）3c90912575ac05a70175cf22121319

                    GmHistorydata hisData = getHisData(metricsB5.get(i), "3c90912575ac05a70175cf22121319");
                    GmLatestdata latestdata = getLastData(metricsB5.get(i), "3c90912575ac05a70175cf22121319");
                    int i1 = addData(hisData, latestdata);
                    if (i1 == 1) {
                        logger.info(metricsB5.get(i).getName() + "插入成功=============================================");
                    }
                } else if (metricsB5.get(i).getName().equals("2-4-C242")) { //2号节点电池电压（V）3c90912575ac05a70175cf22121320

                    GmHistorydata hisData = getHisData(metricsB5.get(i), "3c90912575ac05a70175cf22121320");
                    GmLatestdata latestdata = getLastData(metricsB5.get(i), "3c90912575ac05a70175cf22121320");
                    int i1 = addData(hisData, latestdata);
                    if (i1 == 1) {
                        logger.info(metricsB5.get(i).getName() + "插入成功=============================================");
                    }
                } else if (metricsB5.get(i).getName().equals("3-1-C1")) {   //3号节点温度（℃）3c90912575ac05a70175cf22121321

                    GmHistorydata hisData = getHisData(metricsB5.get(i), "3c90912575ac05a70175cf22121321");
                    GmLatestdata latestdata = getLastData(metricsB5.get(i), "3c90912575ac05a70175cf22121321");
                    int i1 = addData(hisData, latestdata);
                    if (i1 == 1) {
                        logger.info(metricsB5.get(i).getName() + "插入成功=============================================");
                    }
                } else if (metricsB5.get(i).getName().equals("3-2-C2")) {   //3号节点湿度（%）3c90912575ac05a70175cf22121322

                    GmHistorydata hisData = getHisData(metricsB5.get(i), "3c90912575ac05a70175cf22121322");
                    GmLatestdata latestdata = getLastData(metricsB5.get(i), "3c90912575ac05a70175cf22121322");
                    int i1 = addData(hisData, latestdata);
                    if (i1 == 1) {
                        logger.info(metricsB5.get(i).getName() + "插入成功=============================================");
                    }
                } else if (metricsB5.get(i).getName().equals("3-3-C3")) {   //3号节点照度（Lux）3c90912575ac05a70175cf22121323

                    GmHistorydata hisData = getHisData(metricsB5.get(i), "3c90912575ac05a70175cf22121323");
                    GmLatestdata latestdata = getLastData(metricsB5.get(i), "3c90912575ac05a70175cf22121323");
                    int i1 = addData(hisData, latestdata);
                    if (i1 == 1) {
                        logger.info(metricsB5.get(i).getName() + "插入成功=============================================");
                    }
                } else if (metricsB5.get(i).getName().equals("3-4-C242")) { //3号节点电池电压（V）3c90912575ac05a70175cf22121324

                    GmHistorydata hisData = getHisData(metricsB5.get(i), "3c90912575ac05a70175cf22121324");
                    GmLatestdata latestdata = getLastData(metricsB5.get(i), "3c90912575ac05a70175cf22121324");
                    int i1 = addData(hisData, latestdata);
                    if (i1 == 1) {
                        logger.info(metricsB5.get(i).getName() + "插入成功=============================================");
                    }
                }


            }

        }
    }

    public static GmHistorydata getHisData(FangshanData fangshanData, String chid) {
        GmHistorydata gmHistorydata = new GmHistorydata();
        gmHistorydata.setHidaDatequality(0L);
        gmHistorydata.setHidaRecordTime(new Date());
        gmHistorydata.setHidaReporttime(new Date(fangshanData.getTime()));
        gmHistorydata.setHidaCorrvalue(fangshanData.getValue());
        gmHistorydata.setHidaOrigvalue(fangshanData.getValue());
        gmHistorydata.setChId(chid);
        return gmHistorydata;
    }

    public static GmLatestdata getLastData(FangshanData fangshanData, String chid) {
        GmLatestdata gmLatestdata = new GmLatestdata();

        gmLatestdata.setHidaRecordTime(new Date());

        gmLatestdata.setHidaReporttime(new Date(fangshanData.getTime()));
        gmLatestdata.setHidaDatequality(0L);
        gmLatestdata.setHidaCorrvalue(fangshanData.getValue());
        gmLatestdata.setHidaOrigvalue(fangshanData.getValue());
        gmLatestdata.setChId(chid);
        return gmLatestdata;
    }


    private int addData(GmHistorydata gmHistorydata, GmLatestdata gmLatestdata) {

        gmHistorydata.setHidaId(IdUtil.simpleUUID());
        int i1 = gmHistorydataService.insertGmHistorydata(gmHistorydata);

        GmLatestdata gmLatestdataQuery = new GmLatestdata();
        gmLatestdataQuery.setChId(gmLatestdata.getChId());


        List<GmLatestdata> gmLatestdata1 = gmLatestdataService.selectGmLatestdataList(gmLatestdataQuery);
        int i = 0;
        if (gmLatestdata1.size() > 0) {
            gmLatestdata.setHidaId(gmLatestdata1.get(0).getHidaId());
            i = gmLatestdataService.updateGmLatestdata(gmLatestdata);
        } else {
            gmLatestdata.setHidaId(IdUtil.simpleUUID());
            i = gmLatestdataService.insertGmLatestdata(gmLatestdata);
        }
        return i;
    }


}
