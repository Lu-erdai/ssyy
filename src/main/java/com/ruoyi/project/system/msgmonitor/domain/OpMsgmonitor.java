package com.ruoyi.project.system.msgmonitor.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.framework.aspectj.lang.annotation.Excel;
import com.ruoyi.framework.web.domain.BaseEntity;

/**
 * 短信监控配置信息对象 op_msgmonitor
 * 
 * @author ruoyi
 * @date 2020-12-07
 */
public class OpMsgmonitor extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** $column.columnComment */
    private String mesId;

    /** 手机号 */
    @Excel(name = "手机号")
    private String mesPhone;

    /** 场景名称 */
    @Excel(name = "场景名称")
    private String sceneName;

    /** 场景id */
    @Excel(name = "场景id")
    private String sceneId;

    public void setMesId(String mesId)
    {
        this.mesId = mesId;
    }

    public String getMesId()
    {
        return mesId;
    }
    public void setMesPhone(String mesPhone)
    {
        this.mesPhone = mesPhone;
    }

    public String getMesPhone()
    {
        return mesPhone;
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
            .append("mesId", getMesId())
            .append("mesPhone", getMesPhone())
            .append("sceneName", getSceneName())
            .append("sceneId", getSceneId())
            .toString();
    }
}
