package com.ruoyi.project.system.skyboxval.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.framework.aspectj.lang.annotation.Excel;
import com.ruoyi.framework.web.domain.BaseEntity;

/**
 * 速客云变量参数对象 sky_boxval
 * 
 * @author ruoyi
 * @date 2023-06-03
 */
public class SkyBoxval extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 主键 */
    private Long id;

    /**  */
    @Excel(name = "")
    private String boxId;

    /**  */
    @Excel(name = "")
    private String boxName;

    /**  */
    @Excel(name = "")
    private String plcId;

    /** 变量ID */
    @Excel(name = "变量ID")
    private Long variantId;

    /** 变量名称 */
    @Excel(name = "变量名称")
    private String name;

    /** 变量地址 */
    @Excel(name = "变量地址")
    private String addr;

    /** 变量类型 */
    @Excel(name = "变量类型")
    private String type;

    public void setId(Long id)
    {
        this.id = id;
    }

    public Long getId()
    {
        return id;
    }
    public void setBoxId(String boxId)
    {
        this.boxId = boxId;
    }

    public String getBoxId()
    {
        return boxId;
    }
    public void setBoxName(String boxName)
    {
        this.boxName = boxName;
    }

    public String getBoxName()
    {
        return boxName;
    }
    public void setPlcId(String plcId)
    {
        this.plcId = plcId;
    }

    public String getPlcId()
    {
        return plcId;
    }
    public void setVariantId(Long variantId)
    {
        this.variantId = variantId;
    }

    public Long getVariantId()
    {
        return variantId;
    }
    public void setName(String name)
    {
        this.name = name;
    }

    public String getName()
    {
        return name;
    }
    public void setAddr(String addr)
    {
        this.addr = addr;
    }

    public String getAddr()
    {
        return addr;
    }
    public void setType(String type)
    {
        this.type = type;
    }

    public String getType()
    {
        return type;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("boxId", getBoxId())
            .append("boxName", getBoxName())
            .append("plcId", getPlcId())
            .append("variantId", getVariantId())
            .append("name", getName())
            .append("addr", getAddr())
            .append("type", getType())
            .append("updateTime", getUpdateTime())
            .toString();
    }
}
