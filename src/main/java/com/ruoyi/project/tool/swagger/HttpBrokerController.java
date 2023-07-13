package com.ruoyi.project.tool.swagger;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.InetAddress;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

/**
 * 皓天智控获取参数信息接口
 */
public class HttpBrokerController {

    //    public static final String GET_URL = "http://rrnyy.cn/htzk/pub/gateway/getGatewayInfo?appType=T06190925001&gatewaySN=T06190925001";
    public static final String GET_URL = "http://rrnyy.cn/htzk/pub/gateway/getGatewayInfo";


    // 测试接口
    public static final String POST_URL = "http://116.11.122.12:8180/mdserver/service/installLock";

    /**
     * 接口调用 GET
     */
    public static String httpURLConectionGET(String token, String appType,List<String> sNs) throws Exception {

        AuthorizationVO authorizationVO = new AuthorizationVO();
        authorizationVO.setDeviceType("PUB");
        String newToken = "Basic  " + token;
        authorizationVO.setToken(newToken);
        ObjectMapper mapper = new ObjectMapper();

        String Authorization = mapper.writeValueAsString(authorizationVO);//Authorization header处理

        //循环获取所有终端编号中的数据
        String urlReturn = getUrlReturn(appType, Authorization, sNs);
        return urlReturn;

    }

    /**
     * 接口调用  POST
     */
    public static void httpURLConnectionPOST() {
        try {
            //传递参数
            String Parma = "?cardType={}&cardID={}";

            URL url = new URL(POST_URL);
            // 将url 以 open方法返回的urlConnection  连接强转为HttpURLConnection连接  (标识一个url所引用的远程对象连接)
            // 此时cnnection只是为一个连接对象,待连接中
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            // 设置连接输出流为true,默认false (post 请求是以流的方式隐式的传递参数)
            connection.setDoOutput(true);
            // 设置连接输入流为true
            connection.setDoInput(true);
            // 设置请求方式为post
            connection.setRequestMethod("POST");
            // post请求缓存设为false
            connection.setUseCaches(false);
            // 设置该HttpURLConnection实例是否自动执行重定向
            connection.setInstanceFollowRedirects(true);
            // 设置请求头里面的各个属性 (以下为设置内容的类型,设置为经过urlEncoded编码过的from参数)
            // application/x-javascript text/xml->xml数据 application/x-javascript->json对象 application/x-www-form-urlencoded->表单数据
            // ;charset=utf-8 必须要，不然妙兜那边会出现乱码【★★★★★】
            //addRequestProperty添加相同的key不会覆盖，如果相同，内容会以{name1,name2}
            connection.addRequestProperty("from", "sfzh");  //来源哪个系统
            //setRequestProperty添加相同的key会覆盖value信息
            //setRequestProperty方法，如果key存在，则覆盖；不存在，直接添加。
            //addRequestProperty方法，不管key存在不存在，直接添加。
            connection.setRequestProperty("user", "user");  //访问申请用户
            InetAddress address = InetAddress.getLocalHost();
            String ip = address.getHostAddress();//获得本机IP
            connection.setRequestProperty("ip", ip);  //请求来源IP
            connection.setRequestProperty("encry", "123456");
            connection.setRequestProperty("Content-Type", "application/x-www-form-urlencoded;charset=utf-8");
            // 建立连接 (请求未开始,直到connection.getInputStream()方法调用时才发起,以上各个参数设置需在此方法之前进行)
            connection.connect();
            // 创建输入输出流,用于往连接里面输出携带的参数,(输出内容为?后面的内容)
            DataOutputStream dataout = new DataOutputStream(connection.getOutputStream());
            // 格式 parm = aaa=111&bbb=222&ccc=333&ddd=444
            String parm = "username=zhagnsan&password=0000";
            System.out.println("传递参数：" + parm);
            // 将参数输出到连接
            dataout.writeBytes(parm);
            // 输出完成后刷新并关闭流
            dataout.flush();
            dataout.close(); // 重要且易忽略步骤 (关闭流,切记!)
            //System.out.println(connection.getResponseCode());
            // 连接发起请求,处理服务器响应  (从连接获取到输入流并包装为bufferedReader)
            BufferedReader bf = new BufferedReader(new InputStreamReader(connection.getInputStream(), "UTF-8"));
            String line;
            StringBuilder sb = new StringBuilder(); // 用来存储响应数据

            // 循环读取流,若不到结尾处
            while ((line = bf.readLine()) != null) {
                //sb.append(bf.readLine());
                sb.append(line).append(System.getProperty("line.separator"));
            }
            bf.close();    // 重要且易忽略步骤 (关闭流,切记!)
            connection.disconnect(); // 销毁连接
            System.out.println(sb.toString());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

//    public static void main(String[] args) throws Exception {
//        String token = "eyJhbGciOiJIUzI1NiJ9.eyJqdGkiOiJVc2VySWQtMzI1IiwiaWF0IjoxNjA5MzEzNjg2LCJzdWIiOiIxMzMxNzkyMTE3NyIsImlzcyI6IlVzZXJJZC0zMjUifQ.Y38KpLPZCv7fctwJ7kWKgyFTKxgPIvvT9-jl2CyGWSM";
//        httpURLConectionGET(token, "htzk");
//        //httpURLConnectionPOST();
//    }


    public static String getUrlReturn(String appType, String Authorization, List<String> sNs) throws Exception {

        String getUrl = "";
        List result = new ArrayList();
        String res = "[";
        for(String gatewaySN:sNs){
            getUrl = GET_URL+"?appType="+appType+"&gatewaySN="+gatewaySN;

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
            System.out.println(sb.toString());
            res+=sb+",";
            result.add(sb);
        }
        res = res.substring(0, res.length() -1);
        res = res+"]";
        return res;



    }


}
