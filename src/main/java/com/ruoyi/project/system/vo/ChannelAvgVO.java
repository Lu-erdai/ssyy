package com.ruoyi.project.system.vo;

import com.ruoyi.framework.web.domain.BaseEntity;

import java.util.Date;

public class ChannelAvgVO extends BaseEntity {

    private String chId;

    private String chName;

    private String chtypeNo;

    private Double avgCorrvalue;

    private Date hidaRecordTime;

    private String chCorrunit;

    public String getChName() {
        return chName;
    }

    public void setChName(String chName) {
        this.chName = chName;
    }

    public String getChtypeNo() {
        return chtypeNo;
    }

    public void setChtypeNo(String chtypeNo) {
        this.chtypeNo = chtypeNo;
    }

    public Double getAvgCorrvalue() {
        return avgCorrvalue;
    }

    public void setAvgCorrvalue(Double avgCorrvalue) {
        this.avgCorrvalue = avgCorrvalue;
    }

    public Date getHidaRecordTime() {
        return hidaRecordTime;
    }

    public void setHidaRecordTime(Date hidaRecordTime) {
        this.hidaRecordTime = hidaRecordTime;
    }

    public String getChCorrunit() {
        return chCorrunit;
    }

    public void setChCorrunit(String chCorrunit) {
        this.chCorrunit = chCorrunit;
    }

    public String getChId() {
        return chId;
    }

    public void setChId(String chId) {
        this.chId = chId;
    }
}
