package spring.hello.domain.form;

import java.util.Date;

import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Length;

import lombok.Data;

/**
 * @author xinufo
 *
 */
@Data
public class UserForm {
    @NotNull(message = "用户名不能为空")
    @Length(min = 3, max = 10, message = "用户名长度必须在{min}~{max}位")
    private String username;

    @NotNull(message = "密码不能为空")
    @Length(min = 6, max = 12, message = "密码长度必须在{min}~{max}位")
    private String password;

    private String name;

    private Integer age;

    private Integer sex;

    private Date birthday;
}
