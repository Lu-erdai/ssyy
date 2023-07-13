package com.ruoyi.project.system.vo;

import java.util.Date;

public class AutoConfigVO {


    /** 主键 */
    private Long accId;

    /** 场景ID */
    private String sceneId;

    /** 控制设备ID */
    private String dectId;

    /** 操作类型 */
    private Long decoType;

    /** 条件关系 */
    private Long accCond;

    /** 添加人 */
    private String accUser;

    /** 添加时间 */
    private Date accAddtime;

    /** 是否开启 */
    private Long accEnable;


    /** 主键 */
    private Long acfId;


    /** 通道ID */
    private String chId;

    /** 数据处理方式 */
    private Long accHandle;

    /** 控制条件 */
    private Long accCondition;

    /** 触发值 */
    private Long accTrigger;


    private String sceneName;

    private String dectName;

    private String chName;

    private String  chNo;


    public Long getAccId() {
        return accId;
    }

    public void setAccId(Long accId) {
        this.accId = accId;
    }

    public String getSceneId() {
        return sceneId;
    }

    public void setSceneId(String sceneId) {
        this.sceneId = sceneId;
    }

    public String getDectId() {
        return dectId;
    }

    public void setDectId(String dectId) {
        this.dectId = dectId;
    }

    public Long getDecoType() {
        return decoType;
    }

    public void setDecoType(Long decoType) {
        this.decoType = decoType;
    }

    public Long getAccCond() {
        return accCond;
    }

    public void setAccCond(Long accCond) {
        this.accCond = accCond;
    }

    public String getAccUser() {
        return accUser;
    }

    public void setAccUser(String accUser) {
        this.accUser = accUser;
    }

    public Date getAccAddtime() {
        return accAddtime;
    }

    public void setAccAddtime(Date accAddtime) {
        this.accAddtime = accAddtime;
    }

    public Long getAccEnable() {
        return accEnable;
    }

    public void setAccEnable(Long accEnable) {
        this.accEnable = accEnable;
    }

    public Long getAcfId() {
        return acfId;
    }

    public void setAcfId(Long acfId) {
        this.acfId = acfId;
    }

    public String getChId() {
        return chId;
    }

    public void setChId(String chId) {
        this.chId = chId;
    }

    public Long getAccHandle() {
        return accHandle;
    }

    public void setAccHandle(Long accHandle) {
        this.accHandle = accHandle;
    }

    public Long getAccCondition() {
        return accCondition;
    }

    public void setAccCondition(Long accCondition) {
        this.accCondition = accCondition;
    }

    public Long getAccTrigger() {
        return accTrigger;
    }

    public void setAccTrigger(Long accTrigger) {
        this.accTrigger = accTrigger;
    }

    public String getSceneName() {
        return sceneName;
    }

    public void setSceneName(String sceneName) {
        this.sceneName = sceneName;
    }

    public String getDectName() {
        return dectName;
    }

    public void setDectName(String dectName) {
        this.dectName = dectName;
    }

    public String getChName() {
        return chName;
    }

    public void setChName(String chName) {
        this.chName = chName;
    }

    public String getChNo() {
        return chNo;
    }

    public void setChNo(String chNo) {
        this.chNo = chNo;
    }
}
