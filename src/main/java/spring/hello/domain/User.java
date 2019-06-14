package spring.hello.domain;

import lombok.Data;
import org.hibernate.validator.constraints.Length;
import org.springframework.stereotype.Service;
import spring.hello.mapper.UserMapper;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.Date;
@Service
@Data
public class User {
    @NotNull(message = "id can't be null",groups = {UserMapper.class})
    private Integer id;
    @NotEmpty(message = "user can't be null")
    @Length(min=3,message = "用户名不能小于3位")
    private String username;
    @NotEmpty(message = "password can't be null")
    @Length(min = 6,message = "密码不能小于6位")
    private String password;
    private String name;
    private Integer age;
    private Integer sex;
    private Date birthday;
    private String created;
    private String updated;
}
