package com.api.test.controller;

import com.alibaba.fastjson.JSONObject;
import com.api.test.service.impl.ProjectServiceImpl;
import com.api.test.util.CommonUtil;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.web.bind.annotation.*;
import javax.servlet.http.HttpServletRequest;

/**
 * @Author gjx
 **/

@RestController
@RequestMapping("/project")
public class ProjectController {

    private ProjectServiceImpl projectServiceImpl;
    public ProjectController(ProjectServiceImpl projectServiceImpl) {this.projectServiceImpl = projectServiceImpl;}

    //新增项目-新增master分支内容
    @RequiresPermissions("project:add")
    @PostMapping("/addProject")
    public JSONObject addProject(@RequestBody JSONObject requestJson) {
        CommonUtil.hasAllRequired(requestJson,"project_name");
        return projectServiceImpl.addProject(requestJson);
    }

    //修改项目
    @RequiresPermissions("project:delete")
    @DeleteMapping("/deleteProjectById")
    public JSONObject deleteProjectById(@RequestBody JSONObject requestJson){
        CommonUtil.hasAllRequired(requestJson,"id");
        return projectServiceImpl.deleteProjectById(requestJson);
    }

    //更新项目
    @RequiresPermissions("project:update")
    @PutMapping("/updateProject")
    public JSONObject updateProject(@RequestBody JSONObject requestJson)
    {   CommonUtil.hasAllRequired(requestJson,"id,project_name");
        return projectServiceImpl.updateProject(requestJson);
    }

    //获取项目列表
    @RequiresPermissions("project:list")
    @PostMapping("/findAllProject")
    public JSONObject findAllProject(HttpServletRequest request){
        return projectServiceImpl.findAllProject(CommonUtil.request2Json(request));
    }
}
