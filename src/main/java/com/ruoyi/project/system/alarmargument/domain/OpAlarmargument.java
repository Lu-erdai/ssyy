package com.ruoyi.project.system.alarmargument.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.framework.aspectj.lang.annotation.Excel;
import com.ruoyi.framework.web.domain.BaseEntity;

/**
 * 报警配置参数对象 op_alarmargument
 * 
 * @author ruoyi
 * @date 2020-12-08
 */
public class OpAlarmargument extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 主键 */
    private String id;

    /** 通道名称 */
    @Excel(name = "通道名称")
    private String chName;

    /** 是否开启 */
    @Excel(name = "是否开启")
    private Long alEnable;

    /** 最大值 */
    @Excel(name = "最大值")
    private Long alMax;

    /** 最小值 */
    @Excel(name = "最小值")
    private Long alMin;

    /** 通道id */
    @Excel(name = "通道id")
    private String chId;

    /** 场景id */
    @Excel(name = "场景id")
    private String sceneId;

    public void setId(String id)
    {
        this.id = id;
    }

    public String getId()
    {
        return id;
    }
    public void setChName(String chName)
    {
        this.chName = chName;
    }

    public String getChName()
    {
        return chName;
    }
    public void setAlEnable(Long alEnable)
    {
        this.alEnable = alEnable;
    }

    public Long getAlEnable()
    {
        return alEnable;
    }
    public void setAlMax(Long alMax)
    {
        this.alMax = alMax;
    }

    public Long getAlMax()
    {
        return alMax;
    }
    public void setAlMin(Long alMin)
    {
        this.alMin = alMin;
    }

    public Long getAlMin()
    {
        return alMin;
    }
    public void setChId(String chId)
    {
        this.chId = chId;
    }

    public String getChId()
    {
        return chId;
    }
    public void setSceneId(String sceneId)
    {
        this.sceneId = sceneId;
    }

    public String getSceneId()
    {
        return sceneId;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("chName", getChName())
            .append("alEnable", getAlEnable())
            .append("alMax", getAlMax())
            .append("alMin", getAlMin())
            .append("chId", getChId())
            .append("sceneId", getSceneId())
            .toString();
    }
}
