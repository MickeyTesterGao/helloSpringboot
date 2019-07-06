package com.api.test.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.api.test.dao.ProjectDao;
import com.api.test.util.CommonUtil;
import com.api.test.util.constants.ErrorEnum;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;

/**
 * @Author gjx
 **/

@Service
public class ProjectServiceImpl {
    //引入dao层
    private ProjectDao projectDao;
    public ProjectServiceImpl(ProjectDao iProjectMapper){this.projectDao = iProjectMapper;}

    //新增项目,数据库回滚
    @Transactional(rollbackFor = Exception.class)
    public JSONObject addProject(JSONObject jsonObject){
        try{
            projectDao.addProject(jsonObject);
            return CommonUtil.successJson();

        }catch (DuplicateKeyException e){
            //防止项目名称重复
            return CommonUtil.errorJson(ErrorEnum.E_80001);
        }
    }

    //删除项目,数据库回滚
    @Transactional(rollbackFor = Exception.class)
    public JSONObject deleteProjectById(JSONObject jsonObject){
        projectDao.deleteProjectById(jsonObject);
        return CommonUtil.successJson();
        }

    //修改项目,数据库回滚
    @Transactional(rollbackFor = Exception.class)
    public JSONObject updateProject(JSONObject jsonObject){
        try{
            projectDao.updateProject(jsonObject);
            return CommonUtil.successJson();
        }catch(DuplicateKeyException e){
            //防止项目名称重复
            return CommonUtil.errorJson(ErrorEnum.E_80001);
        }
    }

    //获取项目列表
    public JSONObject findAllProject(JSONObject jsonObject){
        CommonUtil.fillPageParam(jsonObject);
        int count = projectDao.countProject(jsonObject);
        List<JSONObject> list = projectDao.findAllProject(jsonObject);
        System.out.println(jsonObject);
        return CommonUtil.successPage(jsonObject, list, count);
    }

}
