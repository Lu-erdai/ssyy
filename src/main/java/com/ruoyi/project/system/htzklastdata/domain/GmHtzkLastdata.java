package com.ruoyi.project.system.htzklastdata.domain;

import com.ruoyi.framework.aspectj.lang.annotation.Excel;
import com.ruoyi.framework.web.domain.BaseEntity;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import java.util.Date;

/**
 * aa对象 gm_htzk_lastdata
 * 
 * @author ruoyi
 * @date 2021-01-04
 */
public class GmHtzkLastdata extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 主键 */
    private Long id;

    /** 终端编号 */
    @Excel(name = "终端编号")
    private String gatewaySN;

    /** 终端名称 */
    @Excel(name = "终端名称")
    private String gatewayName;

    /** 终端类型名称 */
    @Excel(name = "终端类型名称")
    private String gatewayTypeName;

    /** 单位 */
    @Excel(name = "单位")
    private String unit;

    /** 代码 */
    @Excel(name = "代码")
    private String code;

    /** 名字 */
    @Excel(name = "名字")
    private String name;

    /** 值 */
    @Excel(name = "值")
    private Double value;

    /** 记录时间 */
    @Excel(name = "记录时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date recordTime;

    public void setId(Long id)
    {
        this.id = id;
    }

    public Long getId()
    {
        return id;
    }
    public void setGatewaySN(String gatewaySN)
    {
        this.gatewaySN = gatewaySN;
    }

    public String getGatewaySN()
    {
        return gatewaySN;
    }
    public void setGatewayName(String gatewayName)
    {
        this.gatewayName = gatewayName;
    }

    public String getGatewayName()
    {
        return gatewayName;
    }
    public void setGatewayTypeName(String gatewayTypeName)
    {
        this.gatewayTypeName = gatewayTypeName;
    }

    public String getGatewayTypeName()
    {
        return gatewayTypeName;
    }
    public void setUnit(String unit)
    {
        this.unit = unit;
    }

    public String getUnit()
    {
        return unit;
    }
    public void setCode(String code)
    {
        this.code = code;
    }

    public String getCode()
    {
        return code;
    }
    public void setName(String name)
    {
        this.name = name;
    }

    public String getName()
    {
        return name;
    }
    public void setValue(Double value)
    {
        this.value = value;
    }

    public Double getValue()
    {
        return value;
    }
    public void setRecordTime(Date recordTime)
    {
        this.recordTime = recordTime;
    }

    public Date getRecordTime()
    {
        return recordTime;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("gatewaySN", getGatewaySN())
            .append("gatewayName", getGatewayName())
            .append("gatewayTypeName", getGatewayTypeName())
            .append("unit", getUnit())
            .append("code", getCode())
            .append("name", getName())
            .append("value", getValue())
            .append("recordTime", getRecordTime())
            .toString();
    }
}
