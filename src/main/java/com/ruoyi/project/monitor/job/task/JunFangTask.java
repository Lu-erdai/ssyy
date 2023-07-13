package com.ruoyi.project.monitor.job.task;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.ruoyi.project.system.htzkhistorydata.domain.GmHtzkHistorydata;
import com.ruoyi.project.system.htzkhistorydata.service.IGmHtzkHistorydataService;
import com.ruoyi.project.system.htzklastdata.domain.GmHtzkLastdata;
import com.ruoyi.project.system.htzklastdata.service.IGmHtzkLastdataService;
import com.ruoyi.project.tool.swagger.*;
import net.sf.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.InetAddress;
import java.net.URL;
import java.util.*;


@Component
public class JunFangTask {

    public static final String appKey = "ZYvXbEDx";
    public static final String appSecret = "faf18929985e349a3d74f1fcc959e6dcdb23f392";

    public static final String getTokenUrl = "http://rrnyy.cn/htzk/pub/data/getAccessToken";
    public static final String appType = "HTZK";

    public static final String GET_URL = "http://rrnyy.cn/htzk/pub/gateway/getGatewayInfo";

    @Autowired
    IGmHtzkHistorydataService gmHtzkHistorydataService;

    @Autowired
    IGmHtzkLastdataService gmHtzkLastdataService;


//    @Scheduled(cron = "0 */20 * * * ?")
    public void test() {

        //获取5小时密钥

        System.out.println("获取5小时密钥");
        String tokenUrl = getTokenUrl + "?appKey=" + appKey + "&appSecret=" + appSecret;
        TestRrnyy restUtil = new TestRrnyy();
        Date date = new Date();
        try {
            String tokenJson = restUtil.load(tokenUrl);
            ObjectMapper mapper = new ObjectMapper();
            HtzkVO htzkVO = mapper.readValue(tokenJson, HtzkVO.class);
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



            for (String gatewaySN : sNs) {
                String res = httpURLConectionGET(token, appType, gatewaySN);


                Map<String,Class<?>> classMap = new HashMap<String,Class<?>>();
                classMap.put("sensorValues", SensorValueVO.class);


                JSONObject jsonBean = JSONObject.fromObject(res);
                HtzkApiPOJO pojo = (HtzkApiPOJO) JSONObject.toBean(jsonBean, HtzkApiPOJO.class,classMap);
                List<SensorValueVO> sensorValues = pojo.getBody().getSensorValues();//指定通道所有传感器数值
                for(SensorValueVO sensor :sensorValues){
                    GmHtzkHistorydata historydata = new GmHtzkHistorydata();
                    GmHtzkLastdata lastdata = new GmHtzkLastdata();

                    historydata.setUnit(sensor.getUnit());
                    lastdata.setUnit(sensor.getUnit());

                    historydata.setName(sensor.getName());
                    lastdata.setName(sensor.getName());

                    historydata.setCode(sensor.getCode());
                    lastdata.setCode(sensor.getCode());

                    historydata.setUnit(sensor.getUnit());
                    lastdata.setUnit(sensor.getUnit());

                    historydata.setValue(sensor.getValue());
                    lastdata.setValue(sensor.getValue());

                    historydata.setGatewaySN(pojo.getBody().getGatewaySN());
                    lastdata.setGatewaySN(pojo.getBody().getGatewaySN());

                    historydata.setGatewayName(pojo.getBody().getGatewayName());
                    lastdata.setGatewayName(pojo.getBody().getGatewayName());

                    historydata.setGatewayTypeName(pojo.getBody().getGatewayTypeName());
                    lastdata.setGatewayTypeName(pojo.getBody().getGatewayTypeName());

                    historydata.setRecordTime(date);
                    lastdata.setRecordTime(date);

                    gmHtzkHistorydataService.insertGmHtzkHistorydata(historydata);
                    gmHtzkLastdataService.updateGmHtzkLastdata(lastdata);

                }
                System.out.println(pojo.getBody());
            }


        } catch (Exception e) {
            e.printStackTrace();
        }


    }


    private String httpURLConectionGET(String token, String appType, String gatewaySN) throws Exception {

        AuthorizationVO authorizationVO = new AuthorizationVO();
        authorizationVO.setDeviceType("PUB");
        String newToken = "Basic  " + token;
        authorizationVO.setToken(newToken);
        ObjectMapper mapper = new ObjectMapper();

        String Authorization = mapper.writeValueAsString(authorizationVO);//Authorization header处理

        //循环获取所有终端编号中的数据
        String urlReturn = getUrlReturn(appType, Authorization, gatewaySN);
        return urlReturn;

    }


    //获取采集器json字符串
    private String getUrlReturn(String appType, String Authorization, String gatewaySN) throws Exception {

        String getUrl = "";
        List result = new ArrayList();
        String res = "[";
        getUrl = GET_URL + "?appType=" + appType + "&gatewaySN=" + gatewaySN;

        URL url = new URL(getUrl);    //把字符串转换为URL请求地址
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();// 打开连接
        //addRequestProperty添加相同的key不会覆盖，如果相同，内容会以{name1,name2}
        connection.addRequestProperty("from", "sfzh");  //来源哪个系统
        connection.setRequestProperty("user", "user");  //访问申请用户
        InetAddress address = InetAddress.getLocalHost();
        String ip = address.getHostAddress();//获得本机IP
        connection.setRequestProperty("ip", ip);  //请求来源IP
        connection.setRequestProperty("encry", "00000");
        connection.setRequestProperty("Authorization", Authorization);
        //connection.setRequestProperty("设置请求头key", "请求头value");

        connection.connect();// 连接会话
        // 获取输入流
        BufferedReader br = new BufferedReader(new InputStreamReader(connection.getInputStream(), "UTF-8"));
        String line;
        String sb = "";
        while ((line = br.readLine()) != null) {// 循环读取流
            sb = line;
        }
        br.close();// 关闭流
        connection.disconnect();// 断开连接
        System.out.println(sb);
        return sb;


    }

}


