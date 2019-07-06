package com.api.test.dao;

import com.alibaba.fastjson.JSONObject;
import java.util.List;

/**
 * @Author gjx
 **/
public interface ProjectDao {

    public Integer addProject(JSONObject jsonObject);

    public Integer deleteProjectById(JSONObject jsonObject);

    public Integer updateProject(JSONObject jsonObject);

    public List<JSONObject> findAllProject(JSONObject jsonObject);

    int countProject(JSONObject jsonObject);
}
