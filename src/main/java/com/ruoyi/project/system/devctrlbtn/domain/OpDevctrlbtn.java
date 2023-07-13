package com.ruoyi.project.system.devctrlbtn.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.framework.aspectj.lang.annotation.Excel;
import com.ruoyi.framework.web.domain.BaseEntity;

/**
 * 【请填写功能名称】对象 op_devctrlbtn
 * 
 * @author ruoyi
 * @date 2020-12-01
 */
public class OpDevctrlbtn extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** $column.columnComment */
    private String dectbtnId;

    /** $column.columnComment */
    @Excel(name = "${comment}", readConverterExp = "$column.readConverterExp()")
    private Long decoType;

    /** $column.columnComment */
    @Excel(name = "${comment}", readConverterExp = "$column.readConverterExp()")
    private Long dectChlno;

    /** $column.columnComment */
    @Excel(name = "${comment}", readConverterExp = "$column.readConverterExp()")
    private Long dectCtldelay;

    /** $column.columnComment */
    @Excel(name = "${comment}", readConverterExp = "$column.readConverterExp()")
    private Long dectCtltype;

    /** $column.columnComment */
    @Excel(name = "${comment}", readConverterExp = "$column.readConverterExp()")
    private String dectId;

    /** $column.columnComment */
    @Excel(name = "${comment}", readConverterExp = "$column.readConverterExp()")
    private String dectbtnName;

    /** $column.columnComment */
    @Excel(name = "${comment}", readConverterExp = "$column.readConverterExp()")
    private String devId;

    public void setDectbtnId(String dectbtnId)
    {
        this.dectbtnId = dectbtnId;
    }

    public String getDectbtnId()
    {
        return dectbtnId;
    }
    public void setDecoType(Long decoType)
    {
        this.decoType = decoType;
    }

    public Long getDecoType()
    {
        return decoType;
    }
    public void setDectChlno(Long dectChlno)
    {
        this.dectChlno = dectChlno;
    }

    public Long getDectChlno()
    {
        return dectChlno;
    }
    public void setDectCtldelay(Long dectCtldelay)
    {
        this.dectCtldelay = dectCtldelay;
    }

    public Long getDectCtldelay()
    {
        return dectCtldelay;
    }
    public void setDectCtltype(Long dectCtltype)
    {
        this.dectCtltype = dectCtltype;
    }

    public Long getDectCtltype()
    {
        return dectCtltype;
    }
    public void setDectId(String dectId)
    {
        this.dectId = dectId;
    }

    public String getDectId()
    {
        return dectId;
    }
    public void setDectbtnName(String dectbtnName)
    {
        this.dectbtnName = dectbtnName;
    }

    public String getDectbtnName()
    {
        return dectbtnName;
    }
    public void setDevId(String devId)
    {
        this.devId = devId;
    }

    public String getDevId()
    {
        return devId;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("dectbtnId", getDectbtnId())
            .append("decoType", getDecoType())
            .append("dectChlno", getDectChlno())
            .append("dectCtldelay", getDectCtldelay())
            .append("dectCtltype", getDectCtltype())
            .append("dectId", getDectId())
            .append("dectbtnName", getDectbtnName())
            .append("devId", getDevId())
            .toString();
    }
}
