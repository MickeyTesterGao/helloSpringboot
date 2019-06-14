package spring.hello.mapper;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import spring.hello.helloSpringboot.HelloSpringbootApplication;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = HelloSpringbootApplication.class)
public class UserMapperTest {
    @Autowired
    UserMapper userMapper;

    @Test
    public void testQueryUserById() {
        System.out.println(this.userMapper.queryUserById(Integer.valueOf(1)));
    }

}