package com.ruoyi.project.system.scene.domain;

import com.ruoyi.framework.aspectj.lang.annotation.Excel;
import com.ruoyi.framework.web.domain.BaseEntity;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import java.util.Date;

/**
 * 场景对象 op_scene
 * 
 * @author ruoyi
 * @date 2020-11-25
 */
public class OpScene extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 主键，唯一 */
    private String sceneId;


    /** 排序号 */
    @Excel(name = "排序号")
    private Long sceneOrder;

    /** 场景所在地 */
    @Excel(name = "场景所在地")
    private String sceneAddr;

    /** 场景添加时间 */
    @Excel(name = "场景添加时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date sceneCreatedate;

    /** 创建者 */
    @Excel(name = "创建者")
    private String sceneCreater;

    /** 场景类型子类 */
    @Excel(name = "场景类型子类")
    private Long sceneCtype;

    /** 场景的说明 */
    @Excel(name = "场景的说明")
    private String sceneDesc;

    /** 场景的图片 */
    @Excel(name = "场景的图片")
    private String sceneImage;

    /** $column.columnComment */
    @Excel(name = "场景的图片")
    private String sceneKeyword;

    /** $column.columnComment */
    @Excel(name = "场景的图片")
    private String sceneName;

    /** $column.columnComment */
    @Excel(name = "场景的图片")
    private String sceneNo;

    /** $column.columnComment */
    @Excel(name = "场景的图片")
    private String scenePid;

    /** $column.columnComment */
    @Excel(name = "场景的图片")
    private Long sceneRank;

    /** $column.columnComment */
    @Excel(name = "场景的图片")
    private Long sceneState;

    /** $column.columnComment */
    @Excel(name = "场景的图片")
    private Long sceneType;

    /** 定制路径 */
    @Excel(name = "定制路径")
    private String sceneUrl;

    /** 纬度 */
    @Excel(name = "纬度")
    private String sceneLatitude;

    /** 经度 */
    @Excel(name = "经度")
    private String sceneLongitude;

    /** 视频点URL */
    @Excel(name = "视频点URL")
    private String sceneVideourl;

    @Excel(name = "地区id")
    private  String areaId;

    @Excel(name = "场景类型")
    private Long sceneGtype;

    public String getAreaId() {
        return areaId;
    }

    public void setAreaId(String areaId) {
        this.areaId = areaId;
    }

    public Long getSceneGtype() {
        return sceneGtype;
    }

    public void setSceneGtype(Long sceneGtype) {
        this.sceneGtype = sceneGtype;
    }

    public void setSceneId(String sceneId)
    {
        this.sceneId = sceneId;
    }

    public String getSceneId()
    {
        return sceneId;
    }
    public void setSceneOrder(Long sceneOrder)
    {
        this.sceneOrder = sceneOrder;
    }

    public Long getSceneOrder()
    {
        return sceneOrder;
    }
    public void setSceneAddr(String sceneAddr)
    {
        this.sceneAddr = sceneAddr;
    }

    public String getSceneAddr()
    {
        return sceneAddr;
    }
    public void setSceneCreatedate(Date sceneCreatedate)
    {
        this.sceneCreatedate = sceneCreatedate;
    }

    public Date getSceneCreatedate()
    {
        return sceneCreatedate;
    }
    public void setSceneCreater(String sceneCreater)
    {
        this.sceneCreater = sceneCreater;
    }

    public String getSceneCreater()
    {
        return sceneCreater;
    }
    public void setSceneCtype(Long sceneCtype)
    {
        this.sceneCtype = sceneCtype;
    }

    public Long getSceneCtype()
    {
        return sceneCtype;
    }
    public void setSceneDesc(String sceneDesc)
    {
        this.sceneDesc = sceneDesc;
    }

    public String getSceneDesc()
    {
        return sceneDesc;
    }
    public void setSceneImage(String sceneImage)
    {
        this.sceneImage = sceneImage;
    }

    public String getSceneImage()
    {
        return sceneImage;
    }
    public void setSceneKeyword(String sceneKeyword)
    {
        this.sceneKeyword = sceneKeyword;
    }

    public String getSceneKeyword()
    {
        return sceneKeyword;
    }
    public void setSceneName(String sceneName)
    {
        this.sceneName = sceneName;
    }

    public String getSceneName()
    {
        return sceneName;
    }
    public void setSceneNo(String sceneNo)
    {
        this.sceneNo = sceneNo;
    }

    public String getSceneNo()
    {
        return sceneNo;
    }
    public void setScenePid(String scenePid)
    {
        this.scenePid = scenePid;
    }

    public String getScenePid()
    {
        return scenePid;
    }
    public void setSceneRank(Long sceneRank)
    {
        this.sceneRank = sceneRank;
    }

    public Long getSceneRank()
    {
        return sceneRank;
    }
    public void setSceneState(Long sceneState)
    {
        this.sceneState = sceneState;
    }

    public Long getSceneState()
    {
        return sceneState;
    }
    public void setSceneType(Long sceneType)
    {
        this.sceneType = sceneType;
    }

    public Long getSceneType()
    {
        return sceneType;
    }
    public void setSceneUrl(String sceneUrl)
    {
        this.sceneUrl = sceneUrl;
    }

    public String getSceneUrl()
    {
        return sceneUrl;
    }
    public void setSceneLatitude(String sceneLatitude)
    {
        this.sceneLatitude = sceneLatitude;
    }

    public String getSceneLatitude()
    {
        return sceneLatitude;
    }
    public void setSceneLongitude(String sceneLongitude)
    {
        this.sceneLongitude = sceneLongitude;
    }

    public String getSceneLongitude()
    {
        return sceneLongitude;
    }
    public void setSceneVideourl(String sceneVideourl)
    {
        this.sceneVideourl = sceneVideourl;
    }

    public String getSceneVideourl()
    {
        return sceneVideourl;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("sceneId", getSceneId())
            .append("sceneOrder", getSceneOrder())
            .append("sceneAddr", getSceneAddr())
            .append("sceneCreatedate", getSceneCreatedate())
            .append("sceneCreater", getSceneCreater())
            .append("sceneCtype", getSceneCtype())
            .append("sceneDesc", getSceneDesc())
            .append("sceneImage", getSceneImage())
            .append("sceneKeyword", getSceneKeyword())
            .append("sceneName", getSceneName())
            .append("sceneNo", getSceneNo())
            .append("scenePid", getScenePid())
            .append("sceneRank", getSceneRank())
            .append("sceneState", getSceneState())
            .append("sceneType", getSceneType())
            .append("sceneUrl", getSceneUrl())
            .append("sceneLatitude", getSceneLatitude())
            .append("sceneLongitude", getSceneLongitude())
            .append("sceneVideourl", getSceneVideourl())
            .toString();
    }
}
