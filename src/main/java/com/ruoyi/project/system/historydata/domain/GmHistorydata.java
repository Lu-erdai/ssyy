package com.ruoyi.project.system.historydata.domain;

import com.ruoyi.framework.aspectj.lang.annotation.Excel;
import com.ruoyi.framework.web.domain.BaseEntity;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import java.util.Date;

/**
 * 【请填写功能名称】对象 gm_historydata
 * 
 * @author ruoyi
 * @date 2020-11-30
 */
public class GmHistorydata extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** $column.columnComment */
    private String hidaId;

    /** $column.columnComment */
    @Excel(name = "${comment}", readConverterExp = "$column.readConverterExp()")
    private Double hidaCorrvalue;

    /** $column.columnComment */
    @Excel(name = "${comment}", readConverterExp = "$column.readConverterExp()")
    private Long hidaDatequality;

    /** $column.columnComment */
    @Excel(name = "${comment}", readConverterExp = "$column.readConverterExp()")
    private Double hidaOrigvalue;

    /** $column.columnComment */
    @Excel(name = "${comment}", readConverterExp = "$column.readConverterExp()")
    private Date hidaRecordTime;

    /** $column.columnComment */
    @Excel(name = "${comment}", readConverterExp = "$column.readConverterExp()")
    private Date hidaReporttime;

    /** $column.columnComment */
    @Excel(name = "${comment}", readConverterExp = "$column.readConverterExp()")
    private String chId;

    public String getHidaId() {
        return hidaId;
    }

    public void setHidaId(String hidaId) {
        this.hidaId = hidaId;
    }

    public Double getHidaCorrvalue() {
        return hidaCorrvalue;
    }

    public void setHidaCorrvalue(Double hidaCorrvalue) {
        this.hidaCorrvalue = hidaCorrvalue;
    }

    public Long getHidaDatequality() {
        return hidaDatequality;
    }

    public void setHidaDatequality(Long hidaDatequality) {
        this.hidaDatequality = hidaDatequality;
    }

    public Double getHidaOrigvalue() {
        return hidaOrigvalue;
    }

    public void setHidaOrigvalue(Double hidaOrigvalue) {
        this.hidaOrigvalue = hidaOrigvalue;
    }

    public Date getHidaRecordTime() {
        return hidaRecordTime;
    }

    public void setHidaRecordTime(Date hidaRecordTime) {
        this.hidaRecordTime = hidaRecordTime;
    }

    public Date getHidaReporttime() {
        return hidaReporttime;
    }

    public void setHidaReporttime(Date hidaReporttime) {
        this.hidaReporttime = hidaReporttime;
    }

    public String getChId() {
        return chId;
    }

    public void setChId(String chId) {
        this.chId = chId;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("hidaId", getHidaId())
            .append("hidaCorrvalue", getHidaCorrvalue())
            .append("hidaDatequality", getHidaDatequality())
            .append("hidaOrigvalue", getHidaOrigvalue())
            .append("hidaRecordTime", getHidaRecordTime())
            .append("hidaReporttime", getHidaReporttime())
            .append("chId", getChId())
            .toString();
    }
}
