package spring.hello.mapper;

import org.apache.ibatis.annotations.Param;
import spring.hello.domain.User;

import java.util.ArrayList;

public interface UserMapper {

    public User login (String username, String password);

    public User queryUserById(int id);

    public void insertUser(User user);

    public void updateUser(User user);

    public Integer deleteUserById(Integer id);

    public ArrayList<User> queryUserAll();

}
