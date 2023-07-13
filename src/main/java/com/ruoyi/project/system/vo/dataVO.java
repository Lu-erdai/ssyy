package com.ruoyi.project.system.vo;

import com.ruoyi.project.system.historydata.domain.GmHistorydata;

import java.util.List;

public class dataVO {
    private  String chName;

    private String chNo;

    private String chUnit;

    private List<GmHistorydata> datas;


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

    public String getChUnit() {
        return chUnit;
    }

    public void setChUnit(String chUnit) {
        this.chUnit = chUnit;
    }

    public List<GmHistorydata> getDatas() {
        return datas;
    }

    public void setDatas(List<GmHistorydata> datas) {
        this.datas = datas;
    }
}
