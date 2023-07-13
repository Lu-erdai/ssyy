package com.ruoyi.project.system.skylastdata.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.framework.aspectj.lang.annotation.Excel;
import com.ruoyi.framework.web.domain.BaseEntity;

/**
 * 速控云最新数据对象 sky_lastdata
 * 
 * @author ruoyi
 * @date 2023-06-03
 */
public class SkyLastdata extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /**  */
    private Long id;

    /**  */
    @Excel(name = "")
    private String boxId;

    /**  */
    @Excel(name = "")
    private String boxName;

    /**  */
    @Excel(name = "")
    private Long variantId;

    /**  */
    @Excel(name = "")
    private String variantName;

    /**  */
    @Excel(name = "")
    private Long value;

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
    public void setVariantId(Long variantId)
    {
        this.variantId = variantId;
    }

    public Long getVariantId()
    {
        return variantId;
    }
    public void setVariantName(String variantName)
    {
        this.variantName = variantName;
    }

    public String getVariantName()
    {
        return variantName;
    }
    public void setValue(Long value)
    {
        this.value = value;
    }

    public Long getValue()
    {
        return value;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("boxId", getBoxId())
            .append("boxName", getBoxName())
            .append("variantId", getVariantId())
            .append("variantName", getVariantName())
            .append("value", getValue())
            .append("updateTime", getUpdateTime())
            .toString();
    }
}
