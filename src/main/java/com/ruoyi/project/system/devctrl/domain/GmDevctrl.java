package com.ruoyi.project.system.devctrl.domain;

import com.ruoyi.framework.aspectj.lang.annotation.Excel;
import com.ruoyi.framework.web.domain.BaseEntity;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import java.util.Date;

/**
 * 【请填写功能名称】对象 gm_devctrl
 * 
 * @author ruoyi
 * @date 2020-12-01
 */
public class GmDevctrl extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** $column.columnComment */
    private String dectId;

    /** $column.columnComment */
    @Excel(name = "${comment}", readConverterExp = "$column.readConverterExp()")
    private Long chOfferser;

    /** $column.columnComment */
    @Excel(name = "${comment}", readConverterExp = "$column.readConverterExp()")
    private Date dectBuydate;

    /** $column.columnComment */
    @Excel(name = "${comment}", readConverterExp = "$column.readConverterExp()")
    private String dectDecsription;

    /** $column.columnComment */
    @Excel(name = "${comment}", readConverterExp = "$column.readConverterExp()")
    private Date dectEffecttime;

    /** $column.columnComment */
    @Excel(name = "${comment}", readConverterExp = "$column.readConverterExp()")
    private String dectName;

    /** $column.columnComment */
    @Excel(name = "${comment}", readConverterExp = "$column.readConverterExp()")
    private String dectNo;

    /** $column.columnComment */
    @Excel(name = "${comment}", readConverterExp = "$column.readConverterExp()")
    private Date dectOverdate;

    /** $column.columnComment */
    @Excel(name = "${comment}", readConverterExp = "$column.readConverterExp()")
    private String dectSerial;

    /** $column.columnComment */
    @Excel(name = "${comment}", readConverterExp = "$column.readConverterExp()")
    private Long dectState;

    /** $column.columnComment */
    @Excel(name = "${comment}", readConverterExp = "$column.readConverterExp()")
    private Long decttypeBtnnum;

    /** $column.columnComment */
    @Excel(name = "${comment}", readConverterExp = "$column.readConverterExp()")
    private String decttypeId;

    /** $column.columnComment */
    @Excel(name = "${comment}", readConverterExp = "$column.readConverterExp()")
    private String devId;

    /** $column.columnComment */
    @Excel(name = "${comment}", readConverterExp = "$column.readConverterExp()")
    private String sceneId;

    public void setDectId(String dectId)
    {
        this.dectId = dectId;
    }

    public String getDectId()
    {
        return dectId;
    }
    public void setChOfferser(Long chOfferser)
    {
        this.chOfferser = chOfferser;
    }

    public Long getChOfferser()
    {
        return chOfferser;
    }
    public void setDectBuydate(Date dectBuydate)
    {
        this.dectBuydate = dectBuydate;
    }

    public Date getDectBuydate()
    {
        return dectBuydate;
    }
    public void setDectDecsription(String dectDecsription)
    {
        this.dectDecsription = dectDecsription;
    }

    public String getDectDecsription()
    {
        return dectDecsription;
    }
    public void setDectEffecttime(Date dectEffecttime)
    {
        this.dectEffecttime = dectEffecttime;
    }

    public Date getDectEffecttime()
    {
        return dectEffecttime;
    }
    public void setDectName(String dectName)
    {
        this.dectName = dectName;
    }

    public String getDectName()
    {
        return dectName;
    }
    public void setDectNo(String dectNo)
    {
        this.dectNo = dectNo;
    }

    public String getDectNo()
    {
        return dectNo;
    }
    public void setDectOverdate(Date dectOverdate)
    {
        this.dectOverdate = dectOverdate;
    }

    public Date getDectOverdate()
    {
        return dectOverdate;
    }
    public void setDectSerial(String dectSerial)
    {
        this.dectSerial = dectSerial;
    }

    public String getDectSerial()
    {
        return dectSerial;
    }
    public void setDectState(Long dectState)
    {
        this.dectState = dectState;
    }

    public Long getDectState()
    {
        return dectState;
    }
    public void setDecttypeBtnnum(Long decttypeBtnnum)
    {
        this.decttypeBtnnum = decttypeBtnnum;
    }

    public Long getDecttypeBtnnum()
    {
        return decttypeBtnnum;
    }
    public void setDecttypeId(String decttypeId)
    {
        this.decttypeId = decttypeId;
    }

    public String getDecttypeId()
    {
        return decttypeId;
    }
    public void setDevId(String devId)
    {
        this.devId = devId;
    }

    public String getDevId()
    {
        return devId;
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
            .append("dectId", getDectId())
            .append("chOfferser", getChOfferser())
            .append("dectBuydate", getDectBuydate())
            .append("dectDecsription", getDectDecsription())
            .append("dectEffecttime", getDectEffecttime())
            .append("dectName", getDectName())
            .append("dectNo", getDectNo())
            .append("dectOverdate", getDectOverdate())
            .append("dectSerial", getDectSerial())
            .append("dectState", getDectState())
            .append("decttypeBtnnum", getDecttypeBtnnum())
            .append("decttypeId", getDecttypeId())
            .append("devId", getDevId())
            .append("sceneId", getSceneId())
            .toString();
    }
}
