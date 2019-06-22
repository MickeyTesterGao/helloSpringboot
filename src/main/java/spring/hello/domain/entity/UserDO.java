package spring.hello.domain.entity;

import java.util.Date;

import lombok.Data;

/**
 * @author xinufo
 *
 */
@Data
public class UserDO {
    private Integer id;
    private String username;
    private String password;
    private String name;
    private Integer age;
    private Integer sex;
    private Date birthday;
    private String created;
    private String updated;
}
