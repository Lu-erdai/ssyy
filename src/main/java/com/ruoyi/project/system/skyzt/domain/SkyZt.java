package com.ruoyi.project.system.skyzt.domain;

import com.ruoyi.framework.aspectj.lang.annotation.Excel;
import com.ruoyi.framework.web.domain.BaseEntity;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import java.util.Date;

/**
 * 速控云组态链接对象 sky_zt
 * 
 * @author ruoyi
 * @date 2023-06-28
 */
public class SkyZt extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /**  */
    private Long id;

    /**  */
    @Excel(name = "")
    private String ztUrl;

    /**  */
    @Excel(name = "", width = 30, dateFormat = "yyyy-MM-dd")
    private Date recordTime;

    public void setId(Long id)
    {
        this.id = id;
    }

    public Long getId()
    {
        return id;
    }
    public void setZtUrl(String ztUrl)
    {
        this.ztUrl = ztUrl;
    }

    public String getZtUrl()
    {
        return ztUrl;
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
            .append("ztUrl", getZtUrl())
            .append("recordTime", getRecordTime())
            .toString();
    }
}
