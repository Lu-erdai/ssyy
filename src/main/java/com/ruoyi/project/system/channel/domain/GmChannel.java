package com.ruoyi.project.system.channel.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.framework.aspectj.lang.annotation.Excel;
import com.ruoyi.framework.web.domain.BaseEntity;

/**
 * 【请填写功能名称】对象 gm_channel
 * 
 * @author ruoyi
 * @date 2020-11-27
 */
public class GmChannel extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** $column.columnComment */
    private String chId;

    /** $column.columnComment */
    @Excel(name = "${comment}", readConverterExp = "$column.readConverterExp()")
    private Long chChlno;

    /** $column.columnComment */
    @Excel(name = "${comment}", readConverterExp = "$column.readConverterExp()")
    private Long chCorrcyc;

    /** $column.columnComment */
    @Excel(name = "${comment}", readConverterExp = "$column.readConverterExp()")
    private String chCorrformula;

    /** $column.columnComment */
    @Excel(name = "${comment}", readConverterExp = "$column.readConverterExp()")
    private String chCorrunit;

    /** $column.columnComment */
    @Excel(name = "${comment}", readConverterExp = "$column.readConverterExp()")
    private Long chCratemax;

    /** $column.columnComment */
    @Excel(name = "${comment}", readConverterExp = "$column.readConverterExp()")
    private Long chDectdig;

    /** $column.columnComment */
    @Excel(name = "${comment}", readConverterExp = "$column.readConverterExp()")
    private Long chMax;

    /** $column.columnComment */
    @Excel(name = "${comment}", readConverterExp = "$column.readConverterExp()")
    private Long chMemoryperiod;

    /** $column.columnComment */
    @Excel(name = "${comment}", readConverterExp = "$column.readConverterExp()")
    private Long chMin;

    /** $column.columnComment */
    @Excel(name = "${comment}", readConverterExp = "$column.readConverterExp()")
    private String chName;

    /** $column.columnComment */
    @Excel(name = "${comment}", readConverterExp = "$column.readConverterExp()")
    private String chNo;

    /** $column.columnComment */
    @Excel(name = "${comment}", readConverterExp = "$column.readConverterExp()")
    private Long chOfferser;

    /** $column.columnComment */
    @Excel(name = "${comment}", readConverterExp = "$column.readConverterExp()")
    private Long chProcesstyle;

    /** $column.columnComment */
    @Excel(name = "${comment}", readConverterExp = "$column.readConverterExp()")
    private Long chState;

    /** $column.columnComment */
    @Excel(name = "${comment}", readConverterExp = "$column.readConverterExp()")
    private String chUnit;

    /** $column.columnComment */
    @Excel(name = "${comment}", readConverterExp = "$column.readConverterExp()")
    private String chtypeId;

    /** $column.columnComment */
    @Excel(name = "${comment}", readConverterExp = "$column.readConverterExp()")
    private String devCollectid;

    /** $column.columnComment */
    @Excel(name = "${comment}", readConverterExp = "$column.readConverterExp()")
    private String devSensorid;

    /** $column.columnComment */
    @Excel(name = "${comment}", readConverterExp = "$column.readConverterExp()")
    private String sceneId;

    /** $column.columnComment */
    @Excel(name = "${comment}", readConverterExp = "$column.readConverterExp()")
    private String chSeatNo;

    /** $column.columnComment */
    @Excel(name = "${comment}", readConverterExp = "$column.readConverterExp()")
    private String chDepth;

    /** $column.columnComment */
    @Excel(name = "${comment}", readConverterExp = "$column.readConverterExp()")
    private Long chDatetype;

    /** $column.columnComment */
    @Excel(name = "${comment}", readConverterExp = "$column.readConverterExp()")
    private Long chCratemin;

    public void setChId(String chId)
    {
        this.chId = chId;
    }

    public String getChId()
    {
        return chId;
    }
    public void setChChlno(Long chChlno)
    {
        this.chChlno = chChlno;
    }

    public Long getChChlno()
    {
        return chChlno;
    }
    public void setChCorrcyc(Long chCorrcyc)
    {
        this.chCorrcyc = chCorrcyc;
    }

    public Long getChCorrcyc()
    {
        return chCorrcyc;
    }
    public void setChCorrformula(String chCorrformula)
    {
        this.chCorrformula = chCorrformula;
    }

    public String getChCorrformula()
    {
        return chCorrformula;
    }
    public void setChCorrunit(String chCorrunit)
    {
        this.chCorrunit = chCorrunit;
    }

    public String getChCorrunit()
    {
        return chCorrunit;
    }
    public void setChCratemax(Long chCratemax)
    {
        this.chCratemax = chCratemax;
    }

    public Long getChCratemax()
    {
        return chCratemax;
    }
    public void setChDectdig(Long chDectdig)
    {
        this.chDectdig = chDectdig;
    }

    public Long getChDectdig()
    {
        return chDectdig;
    }
    public void setChMax(Long chMax)
    {
        this.chMax = chMax;
    }

    public Long getChMax()
    {
        return chMax;
    }
    public void setChMemoryperiod(Long chMemoryperiod)
    {
        this.chMemoryperiod = chMemoryperiod;
    }

    public Long getChMemoryperiod()
    {
        return chMemoryperiod;
    }
    public void setChMin(Long chMin)
    {
        this.chMin = chMin;
    }

    public Long getChMin()
    {
        return chMin;
    }
    public void setChName(String chName)
    {
        this.chName = chName;
    }

    public String getChName()
    {
        return chName;
    }
    public void setChNo(String chNo)
    {
        this.chNo = chNo;
    }

    public String getChNo()
    {
        return chNo;
    }
    public void setChOfferser(Long chOfferser)
    {
        this.chOfferser = chOfferser;
    }

    public Long getChOfferser()
    {
        return chOfferser;
    }
    public void setChProcesstyle(Long chProcesstyle)
    {
        this.chProcesstyle = chProcesstyle;
    }

    public Long getChProcesstyle()
    {
        return chProcesstyle;
    }
    public void setChState(Long chState)
    {
        this.chState = chState;
    }

    public Long getChState()
    {
        return chState;
    }
    public void setChUnit(String chUnit)
    {
        this.chUnit = chUnit;
    }

    public String getChUnit()
    {
        return chUnit;
    }
    public void setChtypeId(String chtypeId)
    {
        this.chtypeId = chtypeId;
    }

    public String getChtypeId()
    {
        return chtypeId;
    }
    public void setDevCollectid(String devCollectid)
    {
        this.devCollectid = devCollectid;
    }

    public String getDevCollectid()
    {
        return devCollectid;
    }
    public void setDevSensorid(String devSensorid)
    {
        this.devSensorid = devSensorid;
    }

    public String getDevSensorid()
    {
        return devSensorid;
    }
    public void setSceneId(String sceneId)
    {
        this.sceneId = sceneId;
    }

    public String getSceneId()
    {
        return sceneId;
    }
    public void setChSeatNo(String chSeatNo)
    {
        this.chSeatNo = chSeatNo;
    }

    public String getChSeatNo()
    {
        return chSeatNo;
    }
    public void setChDepth(String chDepth)
    {
        this.chDepth = chDepth;
    }

    public String getChDepth()
    {
        return chDepth;
    }
    public void setChDatetype(Long chDatetype)
    {
        this.chDatetype = chDatetype;
    }

    public Long getChDatetype()
    {
        return chDatetype;
    }
    public void setChCratemin(Long chCratemin)
    {
        this.chCratemin = chCratemin;
    }

    public Long getChCratemin()
    {
        return chCratemin;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("chId", getChId())
            .append("chChlno", getChChlno())
            .append("chCorrcyc", getChCorrcyc())
            .append("chCorrformula", getChCorrformula())
            .append("chCorrunit", getChCorrunit())
            .append("chCratemax", getChCratemax())
            .append("chDectdig", getChDectdig())
            .append("chMax", getChMax())
            .append("chMemoryperiod", getChMemoryperiod())
            .append("chMin", getChMin())
            .append("chName", getChName())
            .append("chNo", getChNo())
            .append("chOfferser", getChOfferser())
            .append("chProcesstyle", getChProcesstyle())
            .append("chState", getChState())
            .append("chUnit", getChUnit())
            .append("chtypeId", getChtypeId())
            .append("devCollectid", getDevCollectid())
            .append("devSensorid", getDevSensorid())
            .append("sceneId", getSceneId())
            .append("chSeatNo", getChSeatNo())
            .append("chDepth", getChDepth())
            .append("chDatetype", getChDatetype())
            .append("chCratemin", getChCratemin())
            .toString();
    }
}
