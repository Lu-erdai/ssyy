package com.ruoyi.project.system.vo;

import java.util.Date;

public class AllScenesChansVO  {

    private String name;

    private String paramName;

    private Double paramData;

    private String paramUnit;

    private Date recordTime;

    private String channelId;


    public String getChannelId() {
        return channelId;
    }

    public void setChannelId(String channelId) {
        this.channelId = channelId;
    }

    public Date getRecordTime() {
        return recordTime;
    }

    public void setRecordTime(Date recordTime) {
        this.recordTime = recordTime;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getParamName() {
        return paramName;
    }

    public void setParamName(String paramName) {
        this.paramName = paramName;
    }

    public Double getParamData() {
        return paramData;
    }

    public void setParamData(Double paramData) {
        this.paramData = paramData;
    }

    public String getParamUnit() {
        return paramUnit;
    }

    public void setParamUnit(String paramUnit) {
        this.paramUnit = paramUnit;
    }
}
