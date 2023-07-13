package com.ruoyi.project.system.autoctrlfactor.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.framework.aspectj.lang.annotation.Excel;
import com.ruoyi.framework.web.domain.BaseEntity;

/**
 * 自动控制配置条件对象 op_autoctrlfactor
 * 
 * @author ruoyi
 * @date 2020-12-08
 */
public class OpAutoctrlfactor extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 主键 */
    private Long acfId;

    /** 所属自动控制 */
    @Excel(name = "所属自动控制")
    private String accId;

    /** 通道ID */
    @Excel(name = "通道ID")
    private String chId;

    /** 数据处理方式 */
    @Excel(name = "数据处理方式")
    private Long accHandle;

    /** 控制条件 */
    @Excel(name = "控制条件")
    private Long accCondition;

    /** 触发值 */
    @Excel(name = "触发值")
    private Long accTrigger;

    public void setAcfId(Long acfId)
    {
        this.acfId = acfId;
    }

    public Long getAcfId()
    {
        return acfId;
    }
    public void setAccId(String accId)
    {
        this.accId = accId;
    }

    public String getAccId()
    {
        return accId;
    }
    public void setChId(String chId)
    {
        this.chId = chId;
    }

    public String getChId()
    {
        return chId;
    }
    public void setAccHandle(Long accHandle)
    {
        this.accHandle = accHandle;
    }

    public Long getAccHandle()
    {
        return accHandle;
    }
    public void setAccCondition(Long accCondition)
    {
        this.accCondition = accCondition;
    }

    public Long getAccCondition()
    {
        return accCondition;
    }
    public void setAccTrigger(Long accTrigger)
    {
        this.accTrigger = accTrigger;
    }

    public Long getAccTrigger()
    {
        return accTrigger;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("acfId", getAcfId())
            .append("accId", getAccId())
            .append("chId", getChId())
            .append("accHandle", getAccHandle())
            .append("accCondition", getAccCondition())
            .append("accTrigger", getAccTrigger())
            .toString();
    }
}
