package com.ruoyi.project.system.alarmconfig.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.framework.aspectj.lang.annotation.Excel;
import com.ruoyi.framework.web.domain.BaseEntity;

/**
 * 报警配置信息对象 op_alarmconfig
 * 
 * @author ruoyi
 * @date 2020-12-08
 */
public class OpAlarmconfig extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 主键 */
    private String id;

    /** 邮箱 */
    @Excel(name = "邮箱")
    private String alEmail;

    /** 是否开启 */
    @Excel(name = "是否开启")
    private Long alEnable;

    /** 通知间隔 */
    @Excel(name = "通知间隔")
    private Long alInterval;

    /** 通知方式 */
    @Excel(name = "通知方式")
    private Long alNoticetype;

    /** 手机号 */
    @Excel(name = "手机号")
    private String alPhone;

    /** 场景名称 */
    @Excel(name = "场景名称")
    private String sceneName;

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
    public void setAlEmail(String alEmail)
    {
        this.alEmail = alEmail;
    }

    public String getAlEmail()
    {
        return alEmail;
    }
    public void setAlEnable(Long alEnable)
    {
        this.alEnable = alEnable;
    }

    public Long getAlEnable()
    {
        return alEnable;
    }
    public void setAlInterval(Long alInterval)
    {
        this.alInterval = alInterval;
    }

    public Long getAlInterval()
    {
        return alInterval;
    }
    public void setAlNoticetype(Long alNoticetype)
    {
        this.alNoticetype = alNoticetype;
    }

    public Long getAlNoticetype()
    {
        return alNoticetype;
    }
    public void setAlPhone(String alPhone)
    {
        this.alPhone = alPhone;
    }

    public String getAlPhone()
    {
        return alPhone;
    }
    public void setSceneName(String sceneName)
    {
        this.sceneName = sceneName;
    }

    public String getSceneName()
    {
        return sceneName;
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
            .append("alEmail", getAlEmail())
            .append("alEnable", getAlEnable())
            .append("alInterval", getAlInterval())
            .append("alNoticetype", getAlNoticetype())
            .append("alPhone", getAlPhone())
            .append("sceneName", getSceneName())
            .append("sceneId", getSceneId())
            .toString();
    }
}
