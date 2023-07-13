package com.ruoyi.project.system.vo;

import com.ruoyi.framework.web.domain.BaseEntity;
import com.ruoyi.project.system.devctrl.domain.GmDevctrl;
import com.ruoyi.project.system.devctrlbtn.domain.OpDevctrlbtn;
import com.ruoyi.project.system.devctrlsts.domain.GmDevctrlsts;

import java.util.ArrayList;

public class DevctrlVO extends BaseEntity {

    private GmDevctrl gmDevctrl;


    private GmDevctrlsts gmDevctrlsts;


    private ArrayList<OpDevctrlbtn> opDevctrlbtns;


    private String decoSort ;


    public GmDevctrl getGmDevctrl() {
        return gmDevctrl;
    }

    public void setGmDevctrl(GmDevctrl gmDevctrl) {
        this.gmDevctrl = gmDevctrl;
    }

    public GmDevctrlsts getGmDevctrlsts() {
        return gmDevctrlsts;
    }

    public void setGmDevctrlsts(GmDevctrlsts gmDevctrlsts) {
        this.gmDevctrlsts = gmDevctrlsts;
    }

    public ArrayList<OpDevctrlbtn> getOpDevctrlbtns() {
        return opDevctrlbtns;
    }

    public void setOpDevctrlbtns(ArrayList<OpDevctrlbtn> opDevctrlbtns) {
        this.opDevctrlbtns = opDevctrlbtns;
    }

    public String getDecoSort() {
        return decoSort;
    }

    public void setDecoSort(String decoSort) {
        this.decoSort = decoSort;
    }
}
