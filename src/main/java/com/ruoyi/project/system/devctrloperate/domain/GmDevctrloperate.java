package com.ruoyi.project.system.devctrloperate.domain;

import java.util.Date;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.framework.aspectj.lang.annotation.Excel;
import com.ruoyi.framework.web.domain.BaseEntity;

/**
 * 【请填写功能名称】对象 gm_devctrloperate
 * 
 * @author ruoyi
 * @date 2020-12-02
 */
public class GmDevctrloperate extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** $column.columnComment */
    private String decoId;

    /** $column.columnComment */
    @Excel(name = "${comment}", readConverterExp = "$column.readConverterExp()")
    private Long decoErrorcode;

    /** $column.columnComment */
    @Excel(name = "${comment}", readConverterExp = "$column.readConverterExp()")
    private Long decoResult;

    /** $column.columnComment */
    @Excel(name = "${comment}", readConverterExp = "$column.readConverterExp()")
    private Long decoState;

    /** $column.columnComment */
    @Excel(name = "${comment}", readConverterExp = "$column.readConverterExp()")
    private Date decoTime;

    /** $column.columnComment */
    @Excel(name = "${comment}", readConverterExp = "$column.readConverterExp()")
    private Long decoType;

    /** $column.columnComment */
    @Excel(name = "${comment}", readConverterExp = "$column.readConverterExp()")
    private String decoUserid;

    /** $column.columnComment */
    @Excel(name = "${comment}", readConverterExp = "$column.readConverterExp()")
    private String decoUsername;

    /** $column.columnComment */
    @Excel(name = "${comment}", readConverterExp = "$column.readConverterExp()")
    private Long decoUsertype;

    /** $column.columnComment */
    @Excel(name = "${comment}", readConverterExp = "$column.readConverterExp()")
    private String dectId;

    /** $column.columnComment */
    @Excel(name = "${comment}", readConverterExp = "$column.readConverterExp()")
    private String plaId;

    /** $column.columnComment */
    @Excel(name = "${comment}", readConverterExp = "$column.readConverterExp()")
    private Long decoSort;

    /** $column.columnComment */
    @Excel(name = "${comment}", readConverterExp = "$column.readConverterExp()")
    private String decoUserip;

    /** $column.columnComment */
    @Excel(name = "${comment}", readConverterExp = "$column.readConverterExp()")
    private String decoReason;

    public void setDecoId(String decoId)
    {
        this.decoId = decoId;
    }

    public String getDecoId()
    {
        return decoId;
    }
    public void setDecoErrorcode(Long decoErrorcode)
    {
        this.decoErrorcode = decoErrorcode;
    }

    public Long getDecoErrorcode()
    {
        return decoErrorcode;
    }
    public void setDecoResult(Long decoResult)
    {
        this.decoResult = decoResult;
    }

    public Long getDecoResult()
    {
        return decoResult;
    }
    public void setDecoState(Long decoState)
    {
        this.decoState = decoState;
    }

    public Long getDecoState()
    {
        return decoState;
    }
    public void setDecoTime(Date decoTime)
    {
        this.decoTime = decoTime;
    }

    public Date getDecoTime()
    {
        return decoTime;
    }
    public void setDecoType(Long decoType)
    {
        this.decoType = decoType;
    }

    public Long getDecoType()
    {
        return decoType;
    }
    public void setDecoUserid(String decoUserid)
    {
        this.decoUserid = decoUserid;
    }

    public String getDecoUserid()
    {
        return decoUserid;
    }
    public void setDecoUsername(String decoUsername)
    {
        this.decoUsername = decoUsername;
    }

    public String getDecoUsername()
    {
        return decoUsername;
    }
    public void setDecoUsertype(Long decoUsertype)
    {
        this.decoUsertype = decoUsertype;
    }

    public Long getDecoUsertype()
    {
        return decoUsertype;
    }
    public void setDectId(String dectId)
    {
        this.dectId = dectId;
    }

    public String getDectId()
    {
        return dectId;
    }
    public void setPlaId(String plaId)
    {
        this.plaId = plaId;
    }

    public String getPlaId()
    {
        return plaId;
    }
    public void setDecoSort(Long decoSort)
    {
        this.decoSort = decoSort;
    }

    public Long getDecoSort()
    {
        return decoSort;
    }
    public void setDecoUserip(String decoUserip)
    {
        this.decoUserip = decoUserip;
    }

    public String getDecoUserip()
    {
        return decoUserip;
    }
    public void setDecoReason(String decoReason)
    {
        this.decoReason = decoReason;
    }

    public String getDecoReason()
    {
        return decoReason;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("decoId", getDecoId())
            .append("decoErrorcode", getDecoErrorcode())
            .append("decoResult", getDecoResult())
            .append("decoState", getDecoState())
            .append("decoTime", getDecoTime())
            .append("decoType", getDecoType())
            .append("decoUserid", getDecoUserid())
            .append("decoUsername", getDecoUsername())
            .append("decoUsertype", getDecoUsertype())
            .append("dectId", getDectId())
            .append("plaId", getPlaId())
            .append("decoSort", getDecoSort())
            .append("decoUserip", getDecoUserip())
            .append("decoReason", getDecoReason())
            .toString();
    }
}
