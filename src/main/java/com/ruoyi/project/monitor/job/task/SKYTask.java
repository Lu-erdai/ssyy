package com.ruoyi.project.monitor.job.task;


import cn.hutool.http.HttpUtil;
import cn.hutool.json.JSONArray;
import cn.hutool.json.JSONObject;
import cn.hutool.json.JSONUtil;
import com.ruoyi.project.system.skyinfo.domain.SkyInfo;
import com.ruoyi.project.system.skyinfo.service.ISkyInfoService;
import com.ruoyi.project.system.skyzt.domain.SkyZt;
import com.ruoyi.project.system.skyzt.service.ISkyZtService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Date;
import java.util.HashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * 速控云获取token定时任务。
 */

@Component
@Lazy(false)
public class SKYTask {

    //速控云api公用头部
    private static String skyUrl = "http://sukon-cloud.com";

    //获取token api
    private static String initTokenUrl = "/api/v1/token/initToken";

    //获取项目Id api
    private static String projectsUrl = "/api/v1/base/projects";

    //获取Box api
    private static String boxesUrl = "/api/v1/base/projectBoxes";

    //获取plc api
    private static String plcsUrl = "/api/v1/base/boxPlcs";

    //获取组态连接
    private static String getMndrawParams = "/api/v1/mndraw/mndrawParams";

    private static String uid = "c6239a75907c4e2d9c42159cbff9053b";

    private static String sid = "dc83157f3cce477b8d20706c14c0cc26";

    private static String random = "123abc";

    private static Long timestamp = new Date().getTime();


    private static Logger logger;
    public static ExecutorService executor;

    @Autowired
    private ISkyInfoService skyInfoService;

    @Autowired
    private ISkyZtService skyZtService;

    static {
        SKYTask.logger = LoggerFactory.getLogger(SKYTask.class);
        SKYTask.executor = Executors.newFixedThreadPool(20);
    }


    @Scheduled(cron = "0 0/60 * * * ?")
//    @Scheduled(fixedRate = 1000)
    public void execute() throws Exception {

        String pjStr = uid + sid + random + timestamp;

        String signature = encryptPassword(pjStr);

        String tokenUrl = skyUrl + initTokenUrl;

        String token = "";


        //请求参数
        HashMap<String, Object> paramMap = new HashMap<>();
        paramMap.put("uid", uid);
        paramMap.put("sid", sid);
        paramMap.put("random", random);
        paramMap.put("timestamp", timestamp);
        paramMap.put("signature", signature);

        String result = HttpUtil.post(tokenUrl, paramMap);

//        System.out.println("result"+result);

        JSONObject jsonObject = JSONUtil.parseObj(result);
        Object code = jsonObject.get("code");
        Object success = jsonObject.get("success");

        //首先如果获取得到token
        if (code.equals(10000) && success.equals(true)) {

            Object data = jsonObject.get("data");

            JSONObject jsonData = JSONUtil.parseObj(data);

            token = (String) jsonData.get("token");
            String expire = jsonData.getStr("expire");

            logger.info(token);
            JSONArray projectDatas = getProjectId(token);
            if (null != projectDatas) {
                JSONObject projectData = projectDatas.getJSONObject(0);
                String projectId = projectData.getStr("id");
                String projectName = projectData.getStr("name");
                //目前有2个boxId需要保存2次
                JSONArray boxIds = getBoxId(token, projectId);


                if (null != boxIds) {

                    for (int i = 0; i < boxIds.size(); i++) {
                        JSONObject boxData = boxIds.getJSONObject(i);
                        String boxId = boxData.getStr("boxId");
                        String boxName = boxData.getStr("name");
                        Long id;
                        if (boxName.contains("小车")) {
                            id = 1L;
                        } else {
                            id = 2L;
                        }
                        String plcId = getPlcId(token, boxId);

                        SkyInfo skyinfo = new SkyInfo();
                        skyinfo.setToken(token);
                        skyinfo.setProjectId(projectId);
                        skyinfo.setProjectName(projectName);
                        skyinfo.setBoxId(boxId);
                        skyinfo.setBoxName(boxName);
                        skyinfo.setPlcId(plcId);
                        skyinfo.setRecordTime(new Date());
                        skyinfo.setExpire(expire);
                        skyinfo.setId(id);
                        skyInfoService.updateSkyInfo(skyinfo);
                    }


                }


            }


            //获取组态链接
            String url = skyUrl + getMndrawParams;

            SkyInfo skyinfo = skyInfoService.selectSkyInfoById(1L);
            String tokenzt = skyinfo.getToken();
            String projectId = skyinfo.getProjectId();
            //请求参数
            HashMap<String, Object> paramMapZT = new HashMap<>();
            paramMapZT.put("token", tokenzt);
            paramMapZT.put("projectId", projectId);
            paramMapZT.put("for_client", "p");
            String resultZT = HttpUtil.post(url, paramMapZT);

            JSONObject jsonObjectZT = JSONUtil.parseObj(resultZT);
            Object codeZT = jsonObjectZT.get("code");
            String ztlj = "";
            if (codeZT.equals(70000)) {
                Object dataZT = jsonObjectZT.get("data");
                JSONObject jsonDataZT = JSONUtil.parseObj(dataZT);
                String id = jsonDataZT.getStr("id");
                String type = jsonDataZT.getStr("type");
                String resourceId = jsonDataZT.getStr("resourceId");
                String tokenBack = jsonDataZT.getStr("token");
                String uid = jsonDataZT.getStr("uid");
                ztlj = "http://sukon-cloud.com/mndraw/client?id=" + id + "&type=" + type + "&resourceId=" + resourceId + "&token=" + tokenBack + "&uid=" + uid;
                SkyZt skyZt = new SkyZt();
                skyZt.setId(1L);
                skyZt.setRecordTime(new Date());
                skyZt.setZtUrl(ztlj);
                skyZtService.deleteSkyZtById(1L);
                skyZtService.insertSkyZt(skyZt);
            }


        }


    }


    /**
     * 获取projectId
     *
     * @param token
     * @return
     */
    private static JSONArray getProjectId(String token) {

        String url = skyUrl + projectsUrl;

        //请求参数
        HashMap<String, Object> paramMap = new HashMap<>();
        paramMap.put("token", token);

        String result = HttpUtil.post(url, paramMap);

        JSONObject jsonObject = JSONUtil.parseObj(result);
        Object code = jsonObject.get("code");
        JSONArray projectData = null;
        if (code.equals(20000)) {
            projectData = jsonObject.getJSONArray("data");
//            Object o = data.get(0);
//            JSONObject jsonObject1 = JSONUtil.parseObj(o);
//            projectId = jsonObject1.getStr("id");
        }

        return projectData;

    }


    /**
     * 获取boxId
     *
     * @param token
     * @return
     */
    private static JSONArray getBoxId(String token, String projectId) {

        String url = skyUrl + boxesUrl;

        //请求参数
        HashMap<String, Object> paramMap = new HashMap<>();
        paramMap.put("token", token);
        paramMap.put("projectId", projectId);

        String result = HttpUtil.post(url, paramMap);

        JSONObject jsonObject = JSONUtil.parseObj(result);
        Object code = jsonObject.get("code");
        JSONArray boxsData = null;
        if (code.equals(30000)) {
            boxsData = jsonObject.getJSONArray("data");
        }

        return boxsData;

    }


    /**
     * 获取plcId
     *
     * @param token
     * @return
     */
    private static String getPlcId(String token, String boxId) {

        String url = skyUrl + plcsUrl;

        //请求参数
        HashMap<String, Object> paramMap = new HashMap<>();
        paramMap.put("token", token);
        paramMap.put("boxId", boxId);

        String result = HttpUtil.post(url, paramMap);

        JSONObject jsonObject = JSONUtil.parseObj(result);
        Object code = jsonObject.get("code");

        String plcId = "";
        if (code.equals(40000)) {
            JSONArray data = jsonObject.getJSONArray("data");
            Object o = data.get(0);
            JSONObject jsonObject1 = JSONUtil.parseObj(o);
            plcId = jsonObject1.getStr("plcId");
        }
        return plcId;

    }


    /**
     * 对字符串进行MD5加密
     *
     * @param password 待加密的字符串
     * @return 加密后的字符串
     */

    private static String encryptPassword(String password) {
        String encryptedPassword = null;
        try {
            MessageDigest md = MessageDigest.getInstance("MD5");
            md.update(password.getBytes());
            byte[] bytes = md.digest();
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < bytes.length; i++) {
                sb.append(Integer.toHexString((bytes[i] & 0xFF) | 0x100).substring(1, 3));
            }
            encryptedPassword = sb.toString().toUpperCase();
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        return encryptedPassword;
    }


    public static void main(String[] args) {


        String jsonStr = "{\n" +
                "\t\"code\": 20000,\n" +
                "\t\"success\": true,\n" +
                "\t\"msg\": \"获取项目成功\",\n" +
                "\t\"data\": [\n" +
                "\t\t{\n" +
                "\t\t\t\"id\": \"kH8TnWsV1zQ\",\n" +
                "\t\t\t\"name\": \"宜兴蟹笼\",\n" +
                "\t\t\t\"status\": \"1\",\n" +
                "\t\t\t\"projectType\": \"0\"\n" +
                "\t\t}\n" +
                "\t]\n" +
                "}";


        JSONObject jsonObject = JSONUtil.parseObj(jsonStr);

        JSONArray datas = jsonObject.getJSONArray("data");
        Object o = datas.get(0);
        JSONObject jsonObject1 = JSONUtil.parseObj(o);

        Object id = jsonObject1.get("id");
        System.out.println("id" + id);
    }

}
