package com.ruoyi.project.system.scene.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.ruoyi.common.utils.text.Convert;
import com.ruoyi.framework.web.domain.ZtreeString;
import com.ruoyi.project.system.scene.domain.OpScene;
import com.ruoyi.project.system.scene.mapper.OpSceneMapper;
import com.ruoyi.project.system.scene.service.IOpSceneService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * 场景Service业务层处理
 *
 * @author ruoyi
 * @date 2020-11-25
 */
@Service
public class OpSceneServiceImpl implements IOpSceneService {
    @Autowired
    private OpSceneMapper opSceneMapper;

    /**
     * 查询场景
     *
     * @param sceneId 场景ID
     * @return 场景
     */
    @Override
    public OpScene selectOpSceneById(Long sceneId) {
        return opSceneMapper.selectOpSceneById(sceneId);
    }

    /**
     * 查询场景列表
     *
     * @param opScene 场景
     * @return 场景
     */
    @Override
    public List<OpScene> selectOpSceneList(OpScene opScene) {
        return opSceneMapper.selectOpSceneList(opScene);
    }

    /**
     * 新增场景
     *
     * @param opScene 场景
     * @return 结果
     */
    @Override
    public int insertOpScene(OpScene opScene) {
        return opSceneMapper.insertOpScene(opScene);
    }

    /**
     * 修改场景
     *
     * @param opScene 场景
     * @return 结果
     */
    @Override
    public int updateOpScene(OpScene opScene) {
        return opSceneMapper.updateOpScene(opScene);
    }

    /**
     * 删除场景对象
     *
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    @Override
    public int deleteOpSceneByIds(String ids) {
        return opSceneMapper.deleteOpSceneByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除场景信息
     *
     * @param sceneId 场景ID
     * @return 结果
     */
    @Override
    public int deleteOpSceneById(Long sceneId) {
        return opSceneMapper.deleteOpSceneById(sceneId);
    }

    @Override
    public List<ZtreeString> selectSceneTree(Long userId) {
        List<OpScene> sceneList = opSceneMapper.selectSceneList(userId + "");
        List<ZtreeString> ztrees = initZtree(sceneList);
        return ztrees;
    }

    @Override
    public List<OpScene> selectNoParentList(Long userId) {
        return opSceneMapper.selectNoParentList(userId + "");
    }

    @Override
    public String selectScene(Long userId) {
        List<OpScene> opScenes = opSceneMapper.selectScene(userId + "");
        String result = "";
        if (opScenes.size() > 0) {
            result = JSONObject.toJSONString(opScenes.get(0));
        }
        return result;
    }

    /**
     * 对象转场景树
     *
     * @param sceneList 部门列表
     * @return 树结构列表
     */
    public List<ZtreeString> initZtree(List<OpScene> sceneList) {
        List<ZtreeString> ztrees = new ArrayList<ZtreeString>();
        for (OpScene opScene : sceneList) {
//            if (UserConstants.DEPT_NORMAL.equals(dept.getStatus()))
//            {
            ZtreeString ztree = new ZtreeString();
            ztree.setId(opScene.getSceneId());
            ztree.setpId(opScene.getScenePid());
            ztree.setName(opScene.getSceneName());
            ztree.setTitle(opScene.getSceneName());
//                if (isCheck)
//                {
//                    ztree.setChecked(roleDeptList.contains(dept.getDeptId() + dept.getDeptName()));
//                }
            ztrees.add(ztree);
//            }
        }
        return ztrees;
    }


}
