package com.ruoyi.project.tool.swagger;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * 皓天智控获取5小时有效密钥
 */
public class TestRrnyy {



    public String load(String url) throws Exception
    {
        URL restURL = new URL(url);
        /*
         * 此处的urlConnection对象实际上是根据URL的请求协议(此处是http)生成的URLConnection类 的子类HttpURLConnection
         */
        HttpURLConnection conn = (HttpURLConnection) restURL.openConnection();
        //请求方式
        conn.setRequestMethod("GET");
        //设置是否从httpUrlConnection读入，默认情况下是true; httpUrlConnection.setDoInput(true);
        conn.setDoOutput(true);
        //allowUserInteraction 如果为 true，则在允许用户交互（例如弹出一个验证对话框）的上下文中对此 URL 进行检查。
        conn.setAllowUserInteraction(false);

        BufferedReader bReader = new BufferedReader(new InputStreamReader(conn.getInputStream()));

        String line,resultStr="";

        while(null != (line=bReader.readLine()))
        {
            resultStr +=line;
        }
        System.out.println("3412412---"+resultStr);
        bReader.close();
        return resultStr;

    }
    public static void main(String []args) {try {

        TestRrnyy restUtil = new TestRrnyy();

        String resultString = restUtil.load(
                "http://rrnyy.cn/htzk/pub/data/getAccessToken?appKey=ZYvXbEDx&appSecret=faf18929985e349a3d74f1fcc959e6dcdb23f392");

    } catch (Exception e) {

        // TODO: handle exception

        System.out.print(e.getMessage());

    }

    }





}
