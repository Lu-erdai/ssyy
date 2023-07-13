package com.ruoyi.project.system.latestdata.domain;

import com.ruoyi.framework.aspectj.lang.annotation.Excel;
import com.ruoyi.framework.web.domain.BaseEntity;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import java.util.Date;

/**
 * 【请填写功能名称】对象 gm_latestdata
 * 
 * @author ruoyi
 * @date 2020-11-27
 */
public class GmLatestdata extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** $column.columnComment */
    private String hidaId;

    /** $column.columnComment */
    @Excel(name = "${comment}", readConverterExp = "$column.readConverterExp()")
    private String chId;

    /** $column.columnComment */
    @Excel(name = "${comment}", readConverterExp = "$column.readConverterExp()")
    private Double hidaOrigvalue;

    /** $column.columnComment */
    @Excel(name = "${comment}", readConverterExp = "$column.readConverterExp()")
    private Double hidaCorrvalue;

    /** $column.columnComment */
    @Excel(name = "${comment}", readConverterExp = "$column.readConverterExp()")
    private Date hidaReporttime;

    /** $column.columnComment */
    @Excel(name = "${comment}", readConverterExp = "$column.readConverterExp()")
    private Date hidaRecordTime;

    /** $column.columnComment */
    @Excel(name = "${comment}", readConverterExp = "$column.readConverterExp()")
    private Long hidaDatequality;

    public void setHidaId(String hidaId)
    {
        this.hidaId = hidaId;
    }

    public String getHidaId()
    {
        return hidaId;
    }
    public void setChId(String chId)
    {
        this.chId = chId;
    }

    public String getChId()
    {
        return chId;
    }
    public void setHidaOrigvalue(Double hidaOrigvalue)
    {
        this.hidaOrigvalue = hidaOrigvalue;
    }

    public Double getHidaOrigvalue()
    {
        return hidaOrigvalue;
    }
    public void setHidaCorrvalue(Double hidaCorrvalue)
    {
        this.hidaCorrvalue = hidaCorrvalue;
    }

    public Double getHidaCorrvalue()
    {
        return hidaCorrvalue;
    }
    public void setHidaReporttime(Date hidaReporttime)
    {
        this.hidaReporttime = hidaReporttime;
    }

    public Date getHidaReporttime()
    {
        return hidaReporttime;
    }
    public void setHidaRecordTime(Date hidaRecordTime)
    {
        this.hidaRecordTime = hidaRecordTime;
    }

    public Date getHidaRecordTime()
    {
        return hidaRecordTime;
    }
    public void setHidaDatequality(Long hidaDatequality)
    {
        this.hidaDatequality = hidaDatequality;
    }

    public Long getHidaDatequality()
    {
        return hidaDatequality;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("hidaId", getHidaId())
            .append("chId", getChId())
            .append("hidaOrigvalue", getHidaOrigvalue())
            .append("hidaCorrvalue", getHidaCorrvalue())
            .append("hidaReporttime", getHidaReporttime())
            .append("hidaRecordTime", getHidaRecordTime())
            .append("hidaDatequality", getHidaDatequality())
            .toString();
    }
}
