package com.ruoyi.project.system.skyinfo.domain;

import com.ruoyi.framework.aspectj.lang.annotation.Excel;
import com.ruoyi.framework.web.domain.BaseEntity;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import java.util.Date;

/**
 * 速客云api请求参数信息对象 sky_info
 * 
 * @author ruoyi
 * @date 2023-06-03
 */
public class SkyInfo extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 逐渐 */
    private Long id;

    /** 令牌 */
    @Excel(name = "令牌")
    private String token;

    /** 项目id */
    @Excel(name = "项目id")
    private String projectId;

    /** 项目名称 */
    @Excel(name = "项目名称")
    private String projectName;

    /** 盒子id */
    @Excel(name = "盒子id")
    private String boxId;

    /** box名称 */
    @Excel(name = "box名称")
    private String boxName;

    /** plc */
    @Excel(name = "plc")
    private String plcId;

    /** 记录时间 */
    @Excel(name = "记录时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date recordTime;

    /** 令牌有效时间 */
    @Excel(name = "令牌有效时间")
    private String expire;

    public void setId(Long id)
    {
        this.id = id;
    }

    public Long getId()
    {
        return id;
    }
    public void setToken(String token)
    {
        this.token = token;
    }

    public String getToken()
    {
        return token;
    }
    public void setProjectId(String projectId)
    {
        this.projectId = projectId;
    }

    public String getProjectId()
    {
        return projectId;
    }
    public void setProjectName(String projectName)
    {
        this.projectName = projectName;
    }

    public String getProjectName()
    {
        return projectName;
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
    public void setRecordTime(Date recordTime)
    {
        this.recordTime = recordTime;
    }

    public Date getRecordTime()
    {
        return recordTime;
    }
    public void setExpire(String expire)
    {
        this.expire = expire;
    }

    public String getExpire()
    {
        return expire;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("token", getToken())
            .append("projectId", getProjectId())
            .append("projectName", getProjectName())
            .append("boxId", getBoxId())
            .append("boxName", getBoxName())
            .append("plcId", getPlcId())
            .append("recordTime", getRecordTime())
            .append("expire", getExpire())
            .toString();
    }
}
