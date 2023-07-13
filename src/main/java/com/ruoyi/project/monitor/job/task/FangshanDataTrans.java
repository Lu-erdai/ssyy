package com.ruoyi.project.monitor.job.task;

import cn.hutool.core.date.DateUtil;
import cn.hutool.core.util.IdUtil;
import cn.hutool.http.HttpRequest;
import cn.hutool.json.JSONObject;
import cn.hutool.json.JSONUtil;
import com.ruoyi.project.system.historydata.domain.GmHistorydata;
import com.ruoyi.project.system.historydata.service.IGmHistorydataService;
import org.springframework.beans.factory.annotation.Autowired;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;


//@Component
//@Order(1)
//public class FangshanDataTrans implements CommandLineRunner {
public class FangshanDataTrans {

    @Autowired
    private IGmHistorydataService gmHistorydataService;


//    @Override
    public void run(String... args) throws Exception {



        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

        String start = "2022-11-10 00:00:00";
        Date startDate = DateUtil.parse(start);
        long startTimes = startDate.getTime();//开始时间戳


        String end = "2022-12-13 15:50:00";
        Date endDate = DateUtil.parse(end);
        long endTimes = endDate.getTime();//结束时间戳

//循环插入开始
        while (true) {

            String A5Url = "https://iot.wulink.tech/api/v1/gateways/6252/metrics/last_value";

            String B5Url = "https://iot.wulink.tech/api/v1/gateways/6251/metrics/last_value";

            String access_token = "eyJhbGciOiJSUzI1NiIsInR5cCI6IkpXVCJ9.eyJjb2RlIjoyMDAwMCwic2NvcGUiOlsiYWxsIl0sImF2YXRhciI6Imh0dHBzOi8vZ2tjbG91ZC1kZXYub3NzLWNuLWJlaWppbmcuYWxpeXVuY3MuY29tLzljMDZlMDNmZWM4MjQyODM4MDQ3NTZlZTdjNmQxY2E1LnBuZyIsImV4cCI6MTY3MTA3Nzg1NSwiZ3JhbnRUeXBlIjoiY2xpZW50X2NyZWRlbnRpYWxzIiwidXNlcklkIjozNTAsImp0aSI6IlhOMk5lQkpDaGllbFlZdU5MdVhyNktVU2FMZyIsImNsaWVudF9pZCI6IjE4MzUyNDg5NzU2IiwidXNlcm5hbWUiOiIxODM1MjQ4OTc1NiIsInJlYWxuYW1lIjoi5oi_5bGxIiwidGVybWluYWxUeXBlIjpudWxsfQ.TdE63ZNjNi80K8fdWnvUvL7pKyzGtFVDUZT8XEukG-Oql8NMPEuq79tEcqlolUGoP1xK2cbD2INoNYfvo8Yt-BWJNIVqhCQVn0xSqzXavQX-sIuPeWnlQPTDczdX1baICeAmjvt5Dy4MjlwPfSpsqKCObh7yxsRA3RjSh5q573f2Uzo0MMuaxJM4ToeSW96wlpRI3B7Y0i2L5Sho9lBKDrdMFdBw0u13NcSEbgAGoGd0Q0q2gCNd8rVjFlsbd2IO2O_xk38X_EW1vJuHky36_ERWq73af85lAZFfrgmw8NfbLM8hqFYN-XvOdCg_W0ErpXdkI2MW6EPr0ksQkeo69g";

            String metrics = "%5B%221-1-C1%22%2C%221-2-C2%22%2C%221-3-C3%22%2C%221-4-C242%22%2C%222-1-C1%22%2C%222-2-C2%22%2C%222-3-C3%22%2C%222-4-C242%22%2C%223-1-C1%22%2C%223-2-C2%22%2C%223-3-C3%22%2C%223-4-C242%22%5D";

            String headerStr = "Bearer " + access_token;


            System.out.println(sdf.format(new Date(startTimes)));
            String timeStr = String.valueOf(startTimes);

            HashMap<String, Object> paramMap = new HashMap<>();
            paramMap.put("time", timeStr);
            paramMap.put("metrics", metrics);

//            System.out.println("headerStr" + headerStr);
            //请求A5数据
            System.out.println("timeStr------------------------------------"+timeStr);
            A5Url = A5Url + "?time=" + timeStr + "&metrics=" + metrics;
//            System.out.println("A5Url" + A5Url);
//            System.out.println("headerStr" + headerStr);
            String a5Rst = HttpRequest.get(A5Url).header("Authorization", headerStr).execute().body();

            //解析A5数据
            JSONObject a5RstObject = JSONUtil.parseObj(a5Rst);

            String code = a5RstObject.getStr("code");
            //若接口返回成功则处理数据
            if (code.equals("20000")) {

                String dataObjA5 = a5RstObject.getStr("data");
                JSONObject metricsObject = JSONUtil.parseObj(dataObjA5);
                String metricsObjA5 = metricsObject.getStr("metrics");
                JSONObject dataObject = JSONUtil.parseObj(metricsObjA5);

                //开始插入--------------------------------------------
                String a = dataObject.getStr("1-1-C1");
                GmHistorydata hisa = getHisData("3c90912575ac05a70175cf22121301", a, new Date(startTimes));
                addData(hisa);
                String b = dataObject.getStr("1-2-C2");
                GmHistorydata hisb = getHisData("3c90912575ac05a70175cf22121302", b, new Date(startTimes));
                addData(hisb);
                String c = dataObject.getStr("1-3-C3");
                GmHistorydata hisc = getHisData("3c90912575ac05a70175cf22121303", c, new Date(startTimes));
                addData(hisc);
                String d = dataObject.getStr("1-4-C242");
                GmHistorydata hisd = getHisData("3c90912575ac05a70175cf22121304", d, new Date(startTimes));
                addData(hisd);
                String e = dataObject.getStr("2-1-C1");
                GmHistorydata hise = getHisData("3c90912575ac05a70175cf22121305", e, new Date(startTimes));
                addData(hise);
                String f = dataObject.getStr("2-2-C2");
                GmHistorydata hisf = getHisData("3c90912575ac05a70175cf22121306", f, new Date(startTimes));
                addData(hisf);
                String g = dataObject.getStr("2-3-C3");
                GmHistorydata hisg = getHisData("3c90912575ac05a70175cf22121307", g, new Date(startTimes));
                addData(hisg);
                String h = dataObject.getStr("2-4-C242");
                GmHistorydata hish = getHisData("3c90912575ac05a70175cf22121308", h, new Date(startTimes));
                addData(hish);
                String i = dataObject.getStr("3-1-C1");
                GmHistorydata hisi = getHisData("3c90912575ac05a70175cf22121309", i, new Date(startTimes));
                addData(hisi);
                String j = dataObject.getStr("3-2-C2");
                GmHistorydata hisj = getHisData("3c90912575ac05a70175cf22121310", j, new Date(startTimes));
                addData(hisj);
                String k = dataObject.getStr("3-3-C3");
                GmHistorydata hisk = getHisData("3c90912575ac05a70175cf22121311", k, new Date(startTimes));
                addData(hisk);
                String l = dataObject.getStr("3-4-C242");
                GmHistorydata hisl = getHisData("3c90912575ac05a70175cf22121312", l, new Date(startTimes));
                addData(hisl);
                System.out.println("metricsObjA5============" + metricsObjA5);


            }




            //请求B5数据
            B5Url = B5Url + "?time=" + timeStr + "&metrics=" + metrics;
//            System.out.println("A5Url" + A5Url);
//            System.out.println("headerStr" + headerStr);
            String b5Rst = HttpRequest.get(B5Url).header("Authorization", headerStr).execute().body();

            //解析A5数据
            JSONObject b5RstObject = JSONUtil.parseObj(b5Rst);

            String codeb = b5RstObject.getStr("code");
            //若接口返回成功则处理数据
            if (codeb.equals("20000")) {

                String dataObjB5 = b5RstObject.getStr("data");
                JSONObject metricsObjectB = JSONUtil.parseObj(dataObjB5);
                String metricsObjB5 = metricsObjectB.getStr("metrics");
                JSONObject dataObjectb = JSONUtil.parseObj(metricsObjB5);
                System.out.println("metricsObjB5============" + metricsObjB5);
                //开始插入--------------------------------------------
                String a = dataObjectb.getStr("1-1-C1");
                GmHistorydata hisa = getHisData("3c90912575ac05a70175cf22121313", a, new Date(startTimes));
                addData(hisa);
                String b = dataObjectb.getStr("1-2-C2");
                GmHistorydata hisb = getHisData("3c90912575ac05a70175cf22121314", b, new Date(startTimes));
                addData(hisb);
                String c = dataObjectb.getStr("1-3-C3");
                GmHistorydata hisc = getHisData("3c90912575ac05a70175cf22121315", c, new Date(startTimes));
                addData(hisc);
                String d = dataObjectb.getStr("1-4-C242");
                GmHistorydata hisd = getHisData("3c90912575ac05a70175cf22121316", d, new Date(startTimes));
                addData(hisd);
                String e = dataObjectb.getStr("2-1-C1");
                GmHistorydata hise = getHisData("3c90912575ac05a70175cf22121317", e, new Date(startTimes));
                addData(hise);
                String f = dataObjectb.getStr("2-2-C2");
                GmHistorydata hisf = getHisData("3c90912575ac05a70175cf22121318", f, new Date(startTimes));
                addData(hisf);
                String g = dataObjectb.getStr("2-3-C3");
                GmHistorydata hisg = getHisData("3c90912575ac05a70175cf22121319", g, new Date(startTimes));
                addData(hisg);
                String h = dataObjectb.getStr("2-4-C242");
                GmHistorydata hish = getHisData("3c90912575ac05a70175cf22121320", h, new Date(startTimes));
                addData(hish);
                String i = dataObjectb.getStr("3-1-C1");
                GmHistorydata hisi = getHisData("3c90912575ac05a70175cf22121321", i, new Date(startTimes));
                addData(hisi);
                String j = dataObjectb.getStr("3-2-C2");
                GmHistorydata hisj = getHisData("3c90912575ac05a70175cf22121322", j, new Date(startTimes));
                addData(hisj);
                String k = dataObjectb.getStr("3-3-C3");
                GmHistorydata hisk = getHisData("3c90912575ac05a70175cf22121323", k, new Date(startTimes));
                addData(hisk);
                String l = dataObjectb.getStr("3-4-C242");
                GmHistorydata hisl = getHisData("3c90912575ac05a70175cf22121324", l, new Date(startTimes));
                addData(hisl);



            }






















            System.out.println(sdf.format(startTimes ));
            startTimes = startTimes + 600000;//增加10分钟

            if (startTimes == endTimes+600000) {
                System.out.println("到日子了===========================");
                return;
            }



        }


    }


    public static GmHistorydata getHisData(String chid, String value, Date date) {
        GmHistorydata gmHistorydata = new GmHistorydata();
        gmHistorydata.setHidaDatequality(0L);
        gmHistorydata.setHidaRecordTime(date);
        gmHistorydata.setHidaReporttime(new Date());
        gmHistorydata.setHidaCorrvalue(Double.parseDouble(value));
        gmHistorydata.setHidaOrigvalue(Double.parseDouble(value));
        gmHistorydata.setChId(chid);
        return gmHistorydata;
    }


    //插入历史数据表公用方法
    private int addData(GmHistorydata gmHistorydata) {
        gmHistorydata.setHidaId(IdUtil.simpleUUID());
//        int i1 = gmHistorydataService.insertGmHistorydata(gmHistorydata);
//        System.out.println("插入=======================================");
        return 1;
    }


}
