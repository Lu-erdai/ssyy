package com.ruoyi.project.system.autoctrlconfig.domain;

import com.ruoyi.framework.aspectj.lang.annotation.Excel;
import com.ruoyi.framework.web.domain.BaseEntity;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import java.util.Date;

/**
 * 自动控制配置对象 op_autoctrlconfig
 * 
 * @author ruoyi
 * @date 2020-12-08
 */
public class OpAutoctrlconfig extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 主键 */
    private Long accId;

    /** 场景ID */
    @Excel(name = "场景ID")
    private String sceneId;

    /** 控制设备ID */
    @Excel(name = "控制设备ID")
    private String dectId;

    /** 操作类型 */
    @Excel(name = "操作类型")
    private Long decoType;

    /** 条件关系 */
    @Excel(name = "条件关系")
    private Long accCond;

    /** 添加人 */
    @Excel(name = "添加人")
    private String accUser;

    /** 添加时间 */
    @Excel(name = "添加时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date accAddtime;

    /** 是否开启 */
    @Excel(name = "是否开启")
    private Long accEnable;

    public void setAccId(Long accId)
    {
        this.accId = accId;
    }

    public Long getAccId()
    {
        return accId;
    }
    public void setSceneId(String sceneId)
    {
        this.sceneId = sceneId;
    }

    public String getSceneId()
    {
        return sceneId;
    }
    public void setDectId(String dectId)
    {
        this.dectId = dectId;
    }

    public String getDectId()
    {
        return dectId;
    }
    public void setDecoType(Long decoType)
    {
        this.decoType = decoType;
    }

    public Long getDecoType()
    {
        return decoType;
    }
    public void setAccCond(Long accCond)
    {
        this.accCond = accCond;
    }

    public Long getAccCond()
    {
        return accCond;
    }
    public void setAccUser(String accUser)
    {
        this.accUser = accUser;
    }

    public String getAccUser()
    {
        return accUser;
    }
    public void setAccAddtime(Date accAddtime)
    {
        this.accAddtime = accAddtime;
    }

    public Date getAccAddtime()
    {
        return accAddtime;
    }
    public void setAccEnable(Long accEnable)
    {
        this.accEnable = accEnable;
    }

    public Long getAccEnable()
    {
        return accEnable;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("accId", getAccId())
            .append("sceneId", getSceneId())
            .append("dectId", getDectId())
            .append("decoType", getDecoType())
            .append("accCond", getAccCond())
            .append("accUser", getAccUser())
            .append("accAddtime", getAccAddtime())
            .append("accEnable", getAccEnable())
            .toString();
    }
}
