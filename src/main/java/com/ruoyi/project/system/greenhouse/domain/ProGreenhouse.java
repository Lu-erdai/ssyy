package com.ruoyi.project.system.greenhouse.domain;

import com.ruoyi.framework.aspectj.lang.annotation.Excel;
import com.ruoyi.framework.web.domain.BaseEntity;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import java.util.Date;

/**
 * 【请填写功能名称】对象 pro_greenhouse
 * 
 * @author ruoyi
 * @date 2020-12-04
 */
public class ProGreenhouse extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** $column.columnComment */
    private String greId;

    /** $column.columnComment */
    @Excel(name = "${comment}", readConverterExp = "$column.readConverterExp()")
    private Long greDo;

    /** $column.columnComment */
    @Excel(name = "${comment}", readConverterExp = "$column.readConverterExp()")
    private Long greDoyj;

    /** $column.columnComment */
    @Excel(name = "${comment}", readConverterExp = "$column.readConverterExp()")
    private String greGreenhousename;

    /** $column.columnComment */
    @Excel(name = "${comment}", readConverterExp = "$column.readConverterExp()")
    private String greGreenhouseno;

    /** $column.columnComment */
    @Excel(name = "${comment}", readConverterExp = "$column.readConverterExp()")
    private String grePhone;

    /** $column.columnComment */
    @Excel(name = "${comment}", readConverterExp = "$column.readConverterExp()")
    private String grePlantspecies;

    /** $column.columnComment */
    @Excel(name = "${comment}", readConverterExp = "$column.readConverterExp()")
    private Date grePlanttime;

    /** $column.columnComment */
    @Excel(name = "${comment}", readConverterExp = "$column.readConverterExp()")
    private String greProductionstage;

    /** $column.columnComment */
    @Excel(name = "${comment}", readConverterExp = "$column.readConverterExp()")
    private Long greState;

    /** $column.columnComment */
    @Excel(name = "${comment}", readConverterExp = "$column.readConverterExp()")
    private String greUsername;

    /** $column.columnComment */
    @Excel(name = "${comment}", readConverterExp = "$column.readConverterExp()")
    private String dectId;

    /** $column.columnComment */
    @Excel(name = "${comment}", readConverterExp = "$column.readConverterExp()")
    private String sceneId;

    public void setGreId(String greId)
    {
        this.greId = greId;
    }

    public String getGreId()
    {
        return greId;
    }
    public void setGreDo(Long greDo)
    {
        this.greDo = greDo;
    }

    public Long getGreDo()
    {
        return greDo;
    }
    public void setGreDoyj(Long greDoyj)
    {
        this.greDoyj = greDoyj;
    }

    public Long getGreDoyj()
    {
        return greDoyj;
    }
    public void setGreGreenhousename(String greGreenhousename)
    {
        this.greGreenhousename = greGreenhousename;
    }

    public String getGreGreenhousename()
    {
        return greGreenhousename;
    }
    public void setGreGreenhouseno(String greGreenhouseno)
    {
        this.greGreenhouseno = greGreenhouseno;
    }

    public String getGreGreenhouseno()
    {
        return greGreenhouseno;
    }
    public void setGrePhone(String grePhone)
    {
        this.grePhone = grePhone;
    }

    public String getGrePhone()
    {
        return grePhone;
    }
    public void setGrePlantspecies(String grePlantspecies)
    {
        this.grePlantspecies = grePlantspecies;
    }

    public String getGrePlantspecies()
    {
        return grePlantspecies;
    }
    public void setGrePlanttime(Date grePlanttime)
    {
        this.grePlanttime = grePlanttime;
    }

    public Date getGrePlanttime()
    {
        return grePlanttime;
    }
    public void setGreProductionstage(String greProductionstage)
    {
        this.greProductionstage = greProductionstage;
    }

    public String getGreProductionstage()
    {
        return greProductionstage;
    }
    public void setGreState(Long greState)
    {
        this.greState = greState;
    }

    public Long getGreState()
    {
        return greState;
    }
    public void setGreUsername(String greUsername)
    {
        this.greUsername = greUsername;
    }

    public String getGreUsername()
    {
        return greUsername;
    }
    public void setDectId(String dectId)
    {
        this.dectId = dectId;
    }

    public String getDectId()
    {
        return dectId;
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
            .append("greId", getGreId())
            .append("greDo", getGreDo())
            .append("greDoyj", getGreDoyj())
            .append("greGreenhousename", getGreGreenhousename())
            .append("greGreenhouseno", getGreGreenhouseno())
            .append("grePhone", getGrePhone())
            .append("grePlantspecies", getGrePlantspecies())
            .append("grePlanttime", getGrePlanttime())
            .append("greProductionstage", getGreProductionstage())
            .append("greState", getGreState())
            .append("greUsername", getGreUsername())
            .append("dectId", getDectId())
            .append("sceneId", getSceneId())
            .toString();
    }
}
