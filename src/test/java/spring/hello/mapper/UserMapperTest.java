package spring.hello.mapper;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UserMapperTest {
    @Autowired
    IUserMapper userMapper;

    @Test
    public void testQueryUserById() {
        System.out.println(this.userMapper.findById(Integer.valueOf(1)));
    }

}