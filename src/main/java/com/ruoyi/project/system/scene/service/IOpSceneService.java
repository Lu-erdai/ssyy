package com.ruoyi.project.system.scene.service;

import com.ruoyi.framework.web.domain.ZtreeString;
import com.ruoyi.project.system.scene.domain.OpScene;

import java.util.List;

/**
 * 场景Service接口
 * 
 * @author ruoyi
 * @date 2020-11-25
 */
public interface IOpSceneService 
{
    /**
     * 查询场景
     * 
     * @param sceneId 场景ID
     * @return 场景
     */
    public OpScene selectOpSceneById(Long sceneId);

    /**
     * 查询场景列表
     * 
     * @param opScene 场景
     * @return 场景集合
     */
    public List<OpScene> selectOpSceneList(OpScene opScene);

    /**
     * 新增场景
     * 
     * @param opScene 场景
     * @return 结果
     */
    public int insertOpScene(OpScene opScene);

    /**
     * 修改场景
     * 
     * @param opScene 场景
     * @return 结果
     */
    public int updateOpScene(OpScene opScene);

    /**
     * 批量删除场景
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deleteOpSceneByIds(String ids);

    /**
     * 删除场景信息
     * 
     * @param sceneId 场景ID
     * @return 结果
     */
    public int deleteOpSceneById(Long sceneId);

    List<ZtreeString> selectSceneTree(Long userId);

    List<OpScene> selectNoParentList(Long userId);

    String selectScene(Long userId);
}
