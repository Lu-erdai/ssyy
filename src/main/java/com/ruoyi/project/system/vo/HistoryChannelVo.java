package com.ruoyi.project.system.vo;

import java.util.Date;

public class HistoryChannelVo {

    private  String chName;

    private Date hidaRecordTime;

    private String chNo;

    private String chUnit;

    private Double hidaCorrValue;


    public String getChName() {
        return chName;
    }

    public void setChName(String chName) {
        this.chName = chName;
    }

    public Date getHidaRecordTime() {
        return hidaRecordTime;
    }

    public void setHidaRecordTime(Date hidaRecordTime) {
        this.hidaRecordTime = hidaRecordTime;
    }

    public String getChNo() {
        return chNo;
    }

    public void setChNo(String chNo) {
        this.chNo = chNo;
    }

    public String getChUnit() {
        return chUnit;
    }

    public void setChUnit(String chUnit) {
        this.chUnit = chUnit;
    }

    public Double getHidaCorrValue() {
        return hidaCorrValue;
    }

    public void setHidaCorrValue(Double hidaCorrValue) {
        this.hidaCorrValue = hidaCorrValue;
    }
}
