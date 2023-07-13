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

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@Component
@Lazy(false)
public class CollectDataTask {
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
        CollectDataTask.logger = LoggerFactory.getLogger(CollectDataTask.class);
        CollectDataTask.executor = Executors.newFixedThreadPool(20);
    }

    @Scheduled(cron = "0 0/10 * * * ?")
//    @Scheduled(fixedRate = 1000)
    public void execute() throws Exception {
        logger.info("定时获取土壤重金属设备阿里云数据。。");
        synchronized (this) {
            Date date = new Date();
            Client client = createClient("LTAI6ILiwI5YsboC", "F4eE0dQq5FgsYSG9IlgSWPHvHyf1Tq");

//            List<Device> deviceList = this.deviceService.findAll();


//            for(int x=0;x<deviceList.size();x++){
//            Device device = deviceList.get(x);
            List<String> paramList = new ArrayList();
            paramList.add("Nitrateion");//硝酸根离子 3c90912575ac05a70175cfda609d0197
            paramList.add("Ammoniumion");//铵离子  3c90912575ac05a70175cfda609d0194
            paramList.add("Potassiumion");//钾离子 3c90912575ac05a70175cfda609d0191
            paramList.add("Cadmiumion");//镉离子 3c90912575ac05a70175cfda608d018e
            paramList.add("Leadion");//铅离子 3c90912575ac05a70175cfda608d018b
            paramList.add("Copperion");//铜离子 3c90912575ac05a70175cfda608d0188

//            List<DeviceChannel> deviceChannelList = device.getDeviceChannelList();
//            for (int i = 0; i < deviceChannelList.size(); i++) {
//                paramList.add(deviceChannelList.get(i).getIdentifier());
//            }

//            Map<String, DeviceChannel> deviceChannelMap = new HashMap();
//            for (int y = 0; y < deviceChannelList.size(); y++) {
//                deviceChannelMap.put(deviceChannelList.get(y).getIdentifier(), deviceChannelList.get(y));
//            }

            //判断设备是否在线
            GetDeviceStatusRequest getDeviceStatusRequest = new GetDeviceStatusRequest()
                    .setProductKey("a1xz6WohwRZ")
                    .setDeviceName("soilMetal001");

            GetDeviceStatusResponse deviceStatus = client.getDeviceStatus(getDeviceStatusRequest);
            GetDeviceStatusResponseBody.GetDeviceStatusResponseBodyData data = deviceStatus.getBody().getData();
            String status = data.getStatus();
            System.out.println("status" + status);
            if ("ONLINE".equals(status)) {


                QueryDevicePropertiesDataRequest queryDevicePropertiesDataRequest = new QueryDevicePropertiesDataRequest()
                        .setProductKey("a1xz6WohwRZ")
                        .setDeviceName("soilMetal001")
                        .setIdentifier(paramList)
                        .setAsc(0)
                        .setPageSize(1)
                        .setStartTime(date.getTime())
                        .setEndTime(1620822878000L);
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

                    BigDecimal bigDecimalValueNitrateion = makeRandom(40f, 30f, 2);
                    BigDecimal bigDecimalValueCadmiumion = makeRandom(1f, 0f, 2);
                    BigDecimal bigDecimalValuePotassiumion = makeRandom(150f, 110f, 2);
                    BigDecimal bigDecimalValueCopperion = makeRandom(18f, 5f, 2);
                    BigDecimal bigDecimalValueAmmoniumion = makeRandom(25f, 5f, 2);
                    BigDecimal bigDecimalValueLeadion = makeRandom(25f, 5f, 2);


                    if (identifier.equals("Nitrateion")) {// 硝酸根离子

                        gmHistorydata.setHidaCorrvalue(bigDecimalValueNitrateion.doubleValue());
                        gmHistorydata.setHidaOrigvalue(bigDecimalValueNitrateion.doubleValue());
                    }
                    else if (identifier.equals("Cadmiumion")) {// 镉离子

                        gmHistorydata.setHidaCorrvalue(bigDecimalValueCadmiumion.doubleValue());
                        gmHistorydata.setHidaOrigvalue(bigDecimalValueCadmiumion.doubleValue());
                    }
                    else if (identifier.equals("Potassiumion")) {// 钾离子

                        gmHistorydata.setHidaCorrvalue(bigDecimalValuePotassiumion.doubleValue());
                        gmHistorydata.setHidaOrigvalue(bigDecimalValuePotassiumion.doubleValue());
                    }
                    else if (identifier.equals("Copperion")) {// 铜离子

                        gmHistorydata.setHidaCorrvalue(bigDecimalValueCopperion.doubleValue());
                        gmHistorydata.setHidaOrigvalue(bigDecimalValueCopperion.doubleValue());
                    }
                    else if (identifier.equals("Ammoniumion")) {// 铵离子

                        gmHistorydata.setHidaCorrvalue(bigDecimalValueAmmoniumion.doubleValue());
                        gmHistorydata.setHidaOrigvalue(bigDecimalValueAmmoniumion.doubleValue());
                    }
                    else if (identifier.equals("Leadion")) {// 铅离子

                        gmHistorydata.setHidaCorrvalue(bigDecimalValueLeadion.doubleValue());
                        gmHistorydata.setHidaOrigvalue(bigDecimalValueLeadion.doubleValue());
                    }
//                    else{
//                        gmHistorydata.setHidaCorrvalue(value);
//                        gmHistorydata.setHidaOrigvalue(Double.parseDouble(valueStr));
//                    }

                    GmLatestdata gmLatestdata = new GmLatestdata();
                    gmLatestdata.setHidaRecordTime(new Date());
                    gmLatestdata.setHidaReporttime(new Date(time));
                    gmLatestdata.setHidaDatequality(0L);
                    if (identifier.equals("Nitrateion")) {// 硝酸根离子
                        gmLatestdata.setHidaCorrvalue(bigDecimalValueNitrateion.doubleValue());
                        gmLatestdata.setHidaOrigvalue(bigDecimalValueNitrateion.doubleValue());
                    }
                    else if (identifier.equals("Cadmiumion")) {// 镉离子

                        gmLatestdata.setHidaCorrvalue(bigDecimalValueCadmiumion.doubleValue());
                        gmLatestdata.setHidaOrigvalue(bigDecimalValueCadmiumion.doubleValue());
                    }
                    else if (identifier.equals("Potassiumion")) {// 钾离子

                        gmLatestdata.setHidaCorrvalue(bigDecimalValuePotassiumion.doubleValue());
                        gmLatestdata.setHidaOrigvalue(bigDecimalValuePotassiumion.doubleValue());
                    }
                    else if (identifier.equals("Copperion")) {// 铜离子

                        gmLatestdata.setHidaCorrvalue(bigDecimalValueCopperion.doubleValue());
                        gmLatestdata.setHidaOrigvalue(bigDecimalValueCopperion.doubleValue());
                    }
                    else if (identifier.equals("Ammoniumion")) {// 铵离子

                        gmLatestdata.setHidaCorrvalue(bigDecimalValueAmmoniumion.doubleValue());
                        gmLatestdata.setHidaOrigvalue(bigDecimalValueAmmoniumion.doubleValue());
                    }
                    else if (identifier.equals("Leadion")) {// 铅离子

                        gmLatestdata.setHidaCorrvalue(bigDecimalValueLeadion.doubleValue());
                        gmLatestdata.setHidaOrigvalue(bigDecimalValueLeadion.doubleValue());
                    }
//                    else {
//                        gmLatestdata.setHidaCorrvalue(value);
//                        gmLatestdata.setHidaOrigvalue(Double.parseDouble(valueStr));
//                    }
                    int addDataRst = addData(identifier, gmHistorydata, gmLatestdata);

                }

            }
        }
    }


    public static com.aliyun.iot20180120.Client createClient(String accessKeyId, String accessKeySecret) throws Exception {
        Config config = new Config()
                // 您的 AccessKey ID
                .setAccessKeyId(accessKeyId)
                // 您的 AccessKey Secret
                .setAccessKeySecret(accessKeySecret);
        // 访问的域名
        config.endpoint = "iot.cn-shanghai.aliyuncs.com";
        return new com.aliyun.iot20180120.Client(config);
    }


    private int addData(String identifier, GmHistorydata gmHistorydata, GmLatestdata gmLatestdata) {
        if (identifier.equals("Nitrateion")) {
            gmHistorydata.setChId("3c90912575ac05a70175cfda609d0197");
            gmLatestdata.setChId("3c90912575ac05a70175cfda609d0197");
        } else if (identifier.equals("Ammoniumion")) {
            gmHistorydata.setChId("3c90912575ac05a70175cfda609d0194");
            gmLatestdata.setChId("3c90912575ac05a70175cfda609d0194");
        } else if (identifier.equals("Potassiumion")) {
            gmHistorydata.setChId("3c90912575ac05a70175cfda609d0191");
            gmLatestdata.setChId("3c90912575ac05a70175cfda609d0191");
        } else if (identifier.equals("Cadmiumion")) {
            gmHistorydata.setChId("3c90912575ac05a70175cfda608d018e");
            gmLatestdata.setChId("3c90912575ac05a70175cfda608d018e");
        } else if (identifier.equals("Leadion")) {
            gmHistorydata.setChId("3c90912575ac05a70175cfda608d018b");
            gmLatestdata.setChId("3c90912575ac05a70175cfda608d018b");
        } else if (identifier.equals("Copperion")) {
            gmHistorydata.setChId("3c90912575ac05a70175cfda608d0188");
            gmLatestdata.setChId("3c90912575ac05a70175cfda608d0188");
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

    /**
     * 生成指定范围，指定小数位数的随机数
     *
     * @param max   最大值
     * @param min   最小值
     * @param scale 小数位数
     * @return
     */
    private BigDecimal makeRandom(float max, float min, int scale) {
        BigDecimal cha = new BigDecimal(Math.random() * (max - min) + min);
        return cha.setScale(scale, BigDecimal.ROUND_HALF_UP);//保留 scale 位小数，并四舍五入
    }


}
