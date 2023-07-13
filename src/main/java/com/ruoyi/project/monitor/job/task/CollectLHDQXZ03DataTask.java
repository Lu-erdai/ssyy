package com.ruoyi.project.monitor.job.task;

import cn.hutool.core.util.IdUtil;
import com.aliyun.iot20180120.Client;
import com.aliyun.iot20180120.models.*;
import com.aliyun.teaopenapi.models.Config;
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

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@Component
@Lazy(false)
public class CollectLHDQXZ03DataTask {
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


    static {
        CollectLHDQXZ03DataTask.logger = LoggerFactory.getLogger(CollectLHDQXZ03DataTask.class);
        CollectLHDQXZ03DataTask.executor = Executors.newFixedThreadPool(20);
    }

    @Scheduled(cron = "0 0/10 * * * ?")
//        @Scheduled(fixedRate = 1000)
    public void execute() throws Exception {
        logger.info("定时获取莲花荡气象站03阿里云数据。。。。。。。。。。。。。。。。。。。。");
        synchronized (this) {
            Date date = new Date();
            Client client = createClient("LTAI6ILiwI5YsboC", "F4eE0dQq5FgsYSG9IlgSWPHvHyf1Tq");

//            List<Device> deviceList = this.deviceService.findAll();


//            for(int x=0;x<deviceList.size();x++){
//            Device device = deviceList.get(x);
            List<String> paramList = new ArrayList();
            paramList.add("SunRadiation");//STR总辐射      3aa0912575ac05a70175cfc022121601
            paramList.add("Rainfall");//降雨量             3aa0912575ac05a70175cfc022121602
            paramList.add("Atmosphere");//大气压           3aa0912575ac05a70175cfc022121603
            paramList.add("WindDirection");//风向          3aa0912575ac05a70175cfc022121604
            paramList.add("WindSpeed");//风速              3aa0912575ac05a70175cfc022121605
            paramList.add("Humidity");//湿度               3aa0912575ac05a70175cfc022121606
            paramList.add("temperature");//温度            3aa0912575ac05a70175cfc022121607


            //判断设备是否在线
            GetDeviceStatusRequest getDeviceStatusRequest = new GetDeviceStatusRequest()
                    .setProductKey("a1PzVObEzEA")
                    .setDeviceName("MetroOSA2212003");

            GetDeviceStatusResponse deviceStatus = client.getDeviceStatus(getDeviceStatusRequest);
            GetDeviceStatusResponseBody.GetDeviceStatusResponseBodyData data = deviceStatus.getBody().getData();
            String status = data.getStatus();
            System.out.println("status" + status);
            if ("ONLINE".equals(status)) {


                QueryDevicePropertiesDataRequest queryDevicePropertiesDataRequest = new QueryDevicePropertiesDataRequest()
                        .setProductKey("a1PzVObEzEA")
                        .setDeviceName("MetroOSA2212003")
                        .setIdentifier(paramList)
                        .setAsc(0)
                        .setPageSize(1)
                        .setStartTime(date.getTime())
                        .setEndTime(1220822878000L);
                // 复制代码运行请自行打印 API 的返回值
                QueryDevicePropertiesDataResponse p = client.queryDevicePropertiesData(queryDevicePropertiesDataRequest);
                System.out.println(p);
                QueryDevicePropertiesDataResponseBody.QueryDevicePropertiesDataResponseBodyPropertyDataInfos qq = p.body.propertyDataInfos;
                for (int i = 0; i < qq.getPropertyDataInfo().size(); i++) {
                    String identifier = qq.getPropertyDataInfo().get(i).identifier;
                    Long time = qq.getPropertyDataInfo().get(i).list.propertyInfo.get(0).time;
                    Date d = new Date(time);
                    SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                    String collectTime = sf.format(d);
                    String tt = qq.getPropertyDataInfo().get(i).list.propertyInfo.get(0).value;
                    if (tt.length() >= 6) {
                        tt = tt.substring(0, 6);
                    }
                    Double value = Double.valueOf(tt);
                    String valueStr = String.format("%.2f", value);

//                DeviceChannel deviceChannel = deviceChannelMap.get(identifier);
//                deviceChannel.setCollectTime(collectTime);
//                deviceChannel.setValue(valueStr);
                    System.out.println("identifier = " + identifier);
                    System.out.println("collectTime = " + collectTime);
                    System.out.println("valueStr = " + valueStr);

                    GmHistorydata gmHistorydata = new GmHistorydata();
                    gmHistorydata.setHidaDatequality(0L);
                    gmHistorydata.setHidaRecordTime(new Date());
                    gmHistorydata.setHidaReporttime(new Date(time));


                    gmHistorydata.setHidaCorrvalue(value);
                    gmHistorydata.setHidaOrigvalue(Double.parseDouble(valueStr));

                    GmLatestdata gmLatestdata = new GmLatestdata();
                    gmLatestdata.setHidaRecordTime(new Date());
                    gmLatestdata.setHidaReporttime(new Date(time));
                    gmLatestdata.setHidaDatequality(0L);
                    gmLatestdata.setHidaCorrvalue(value);
                    gmLatestdata.setHidaOrigvalue(Double.parseDouble(valueStr));
                    int addDataRst = addData(identifier, gmHistorydata, gmLatestdata);

                }

            }
        }
    }


    public static Client createClient(String accessKeyId, String accessKeySecret) throws Exception {
        Config config = new Config()
                // 您的 AccessKey ID
                .setAccessKeyId(accessKeyId)
                // 您的 AccessKey Secret
                .setAccessKeySecret(accessKeySecret);
        // 访问的域名
        config.endpoint = "iot.cn-shanghai.aliyuncs.com";
        return new Client(config);
    }


    private int addData(String identifier, GmHistorydata gmHistorydata, GmLatestdata gmLatestdata) {
        if (identifier.equals("SunRadiation")) {
            gmHistorydata.setChId("3aa0912575ac05a70175cfc022121608");
            gmLatestdata.setChId("3aa0912575ac05a70175cfc022121608");
        } else if (identifier.equals("Rainfall")) {
            gmHistorydata.setChId("3aa0912575ac05a70175cfc022121609");
            gmLatestdata.setChId("3aa0912575ac05a70175cfc022121609");
        } else if (identifier.equals("Atmosphere")) {
            gmHistorydata.setChId("3aa0912575ac05a70175cfc022121610");
            gmLatestdata.setChId("3aa0912575ac05a70175cfc022121610");
        } else if (identifier.equals("WindDirection")) {
            gmHistorydata.setChId("3aa0912575ac05a70175cfc022121611");
            gmLatestdata.setChId("3aa0912575ac05a70175cfc022121611");
        } else if (identifier.equals("WindSpeed")) {
            gmHistorydata.setChId("3aa0912575ac05a70175cfc022121612");
            gmLatestdata.setChId("3aa0912575ac05a70175cfc022121612");
        } else if (identifier.equals("Humidity")) {
            gmHistorydata.setChId("3aa0912575ac05a70175cfc022121613");
            gmLatestdata.setChId("3aa0912575ac05a70175cfc022121613");
        }else if (identifier.equals("temperature")) {
            gmHistorydata.setChId("3aa0912575ac05a70175cfc022121614");
            gmLatestdata.setChId("3aa0912575ac05a70175cfc022121614");
        }


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
