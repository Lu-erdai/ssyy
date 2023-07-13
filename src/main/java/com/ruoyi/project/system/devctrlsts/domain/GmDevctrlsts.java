package com.ruoyi.project.system.devctrlsts.domain;

import java.util.Date;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.framework.aspectj.lang.annotation.Excel;
import com.ruoyi.framework.web.domain.BaseEntity;

/**
 * 【请填写功能名称】对象 gm_devctrlsts
 * 
 * @author ruoyi
 * @date 2020-12-01
 */
public class GmDevctrlsts extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** $column.columnComment */
    private String decstId;

    /** $column.columnComment */
    @Excel(name = "${comment}", readConverterExp = "$column.readConverterExp()")
    private Date decstTime;

    /** $column.columnComment */
    @Excel(name = "${comment}", readConverterExp = "$column.readConverterExp()")
    private Long decstValid;

    /** $column.columnComment */
    @Excel(name = "${comment}", readConverterExp = "$column.readConverterExp()")
    private Long dectState;

    /** $column.columnComment */
    @Excel(name = "${comment}", readConverterExp = "$column.readConverterExp()")
    private String dectId;

    /** $column.columnComment */
    @Excel(name = "${comment}", readConverterExp = "$column.readConverterExp()")
    private Long decoSort;

    public void setDecstId(String decstId)
    {
        this.decstId = decstId;
    }

    public String getDecstId()
    {
        return decstId;
    }
    public void setDecstTime(Date decstTime)
    {
        this.decstTime = decstTime;
    }

    public Date getDecstTime()
    {
        return decstTime;
    }
    public void setDecstValid(Long decstValid)
    {
        this.decstValid = decstValid;
    }

    public Long getDecstValid()
    {
        return decstValid;
    }
    public void setDectState(Long dectState)
    {
        this.dectState = dectState;
    }

    public Long getDectState()
    {
        return dectState;
    }
    public void setDectId(String dectId)
    {
        this.dectId = dectId;
    }

    public String getDectId()
    {
        return dectId;
    }
    public void setDecoSort(Long decoSort)
    {
        this.decoSort = decoSort;
    }

    public Long getDecoSort()
    {
        return decoSort;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("decstId", getDecstId())
            .append("decstTime", getDecstTime())
            .append("decstValid", getDecstValid())
            .append("dectState", getDectState())
            .append("dectId", getDectId())
            .append("decoSort", getDecoSort())
            .toString();
    }
}
