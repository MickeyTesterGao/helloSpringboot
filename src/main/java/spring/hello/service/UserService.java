package spring.hello.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import spring.hello.domain.User;
import spring.hello.mapper.UserMapper;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

@Service
@Transactional
public class UserService {
    @Autowired
    UserMapper userMapper;
    @Autowired
    User user;

    public Object selectIDdata(Integer id){
       Object  data = userMapper.queryUserById(id);
       return data;
    }
    //登录(查询用户功能)
    public Object login(String username,String password){
        try {
            Object users = userMapper.login(username,password);
            if(username.equals(((User) users).getUsername()) && password.equals(((User) users).getPassword())){
                Map<String, String> map = new HashMap<String, String>();
                map.put("msg","登录成功");
                return map;
            }else {
                Map<String, String> map = new HashMap<String, String>();
                map.put("msg","用户名或密码不正确！");
                return map;
            }
        }catch (NullPointerException e){
            Map<String, String> map = new HashMap<String, String>();
            map.put("msg","用户名或密码不正确！");
            return map;
        }
    }

    //注册用户(新增用户)
    public Object register(User user){
        try {
            this.userMapper.insertUser(user);
            Map<String, String> map = new HashMap<String, String>();
            map.put("msg","注册成功");
            return map;
        }catch (Exception e){
            Map<String, String> map = new HashMap<String, String>();
            map.put("msg","注册失败");
            return map;
        }
    }
    //修改用户信息
    public Object updateUser(User user){
        try {
            System.out.println(user);
            userMapper.updateUser(user);
            Map<String, String> map = new HashMap<String, String>();
            map.put("msg","修改用户信息成功");
            return map;
        }catch (Exception e){
            Map<String, String> map = new HashMap<String, String>();
            map.put("msg","修改用户信息失败");
            return map;
        }

    }
    //删除用户
    public  Object deleteUser(User user){
        try {
            Object users=userMapper.queryUserById(user.getId());

            int i = userMapper.deleteUserById(user.getId());
            if(i==0){
                throw new RuntimeException("no user");
            }
            Map<String, String> map = new HashMap<String, String>();
            map.put("msg","删除用户成功");
            return map;
        }catch (Exception e){
            Map<String, String> map = new HashMap<String, String>();
            map.put("msg","删除用户失败,需确认该用户是否存在");
            return map;
        }
    }
    //查询所有用户
    public ArrayList queryUserAll(){

        ArrayList<User> data = userMapper.queryUserAll();
        return data;

    }

}
