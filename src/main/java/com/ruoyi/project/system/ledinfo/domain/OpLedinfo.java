package com.ruoyi.project.system.ledinfo.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.framework.aspectj.lang.annotation.Excel;
import com.ruoyi.framework.web.domain.BaseEntity;

/**
 * 【请填写功能名称】对象 op_ledinfo
 * 
 * @author ruoyi
 * @date 2020-12-07
 */
public class OpLedinfo extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** $column.columnComment */
    @Excel(name = "${comment}", readConverterExp = "$column.readConverterExp()")
    private String ledId;

    /** $column.columnComment */
    @Excel(name = "${comment}", readConverterExp = "$column.readConverterExp()")
    private String ledContent;

    /** $column.columnComment */
    @Excel(name = "${comment}", readConverterExp = "$column.readConverterExp()")
    private Long ledEnable;

    /** $column.columnComment */
    @Excel(name = "${comment}", readConverterExp = "$column.readConverterExp()")
    private Long ledInterval;

    /** $column.columnComment */
    @Excel(name = "${comment}", readConverterExp = "$column.readConverterExp()")
    private String ledName;

    /** $column.columnComment */
    @Excel(name = "${comment}", readConverterExp = "$column.readConverterExp()")
    private String ledNo;

    public void setLedId(String ledId)
    {
        this.ledId = ledId;
    }

    public String getLedId()
    {
        return ledId;
    }
    public void setLedContent(String ledContent)
    {
        this.ledContent = ledContent;
    }

    public String getLedContent()
    {
        return ledContent;
    }
    public void setLedEnable(Long ledEnable)
    {
        this.ledEnable = ledEnable;
    }

    public Long getLedEnable()
    {
        return ledEnable;
    }
    public void setLedInterval(Long ledInterval)
    {
        this.ledInterval = ledInterval;
    }

    public Long getLedInterval()
    {
        return ledInterval;
    }
    public void setLedName(String ledName)
    {
        this.ledName = ledName;
    }

    public String getLedName()
    {
        return ledName;
    }
    public void setLedNo(String ledNo)
    {
        this.ledNo = ledNo;
    }

    public String getLedNo()
    {
        return ledNo;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("ledId", getLedId())
            .append("ledContent", getLedContent())
            .append("ledEnable", getLedEnable())
            .append("ledInterval", getLedInterval())
            .append("ledName", getLedName())
            .append("ledNo", getLedNo())
            .toString();
    }
}
