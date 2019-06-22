package spring.hello.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import spring.hello.domain.entity.UserDO;
import spring.hello.domain.form.UserForm;
import spring.hello.interceptr.PublicEndPoint;
import spring.hello.service.UserService;

/**
 * RESTful 风格API 创建：POST 删除：DELETE 修改：PUT 查询：GET
 * 
 * @author xinufo
 *
 */
@RestController
public class UserController {
    private UserService userSrv;

    // 推荐使用构造方法自动装配
    // 此处的 Autowired 可以省略
    // @Autowired
    public UserController(UserService userSrv) {
        this.userSrv = userSrv;
    }

    @PublicEndPoint
    @PostMapping("/login")
    public void login(@RequestParam("username") String username, @RequestParam("password") String password,
            HttpSession session) {
        userSrv.login(username, password, session);
    }

    @PublicEndPoint
    @PostMapping("/register")
    public Integer register(@Validated @RequestBody UserForm form) {
        return userSrv.register(form);
    }

    @PutMapping("/{id}")
    public void updateUser(@PathVariable("id") Integer id, @Validated @RequestBody UserForm form) {
        userSrv.update(id, form);
    }

    @DeleteMapping("/{id}")
    public void deleteUser(@PathVariable("id") Integer id) {
        userSrv.delete(id);
    }

    @PostMapping("/queryUserAll")
    public List<UserDO> queryUserAll() {
        return userSrv.findAll();

    }

    @GetMapping("/{id}")
    public UserDO queryUserById(@PathVariable("id") Integer id) {
        return userSrv.findById(id);
    }

    @GetMapping("/1")
    public String a() {
        return "1";
    }

    @PublicEndPoint
    @GetMapping("/2")
    public String b() {
        return "b";
    }

}
