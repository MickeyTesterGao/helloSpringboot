package spring.hello.web;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import spring.hello.domain.User;
import spring.hello.mapper.UserMapper;
import spring.hello.service.UserService;
import javax.validation.Valid;
import java.util.ArrayList;
import java.util.Map;

@RestController
    public class UserController {

        @Autowired
        private UserService userService;
        @Autowired
        private User user;

        @RequestMapping("/")
        @ResponseBody
        public String index(){

            userService.selectIDdata();

            return "hello spring boot";
        }

        @PostMapping("/login")
        public Object login(@Valid @RequestBody User user){
            return userService.login(user.getUsername(),user.getPassword());
        }


        @PostMapping("/register")
        @ResponseBody
        public Object register(@Valid @RequestBody User user){
            return userService.register(user);
        }
        @PostMapping("/updateUser")
        @ResponseBody
        public Object updateUser(@Valid @RequestBody User user){
            return userService.updateUser(user);
        }
        @PostMapping("/deleteUser")
        @ResponseBody
        public Object deleteUser(@Validated(UserMapper.class) @RequestBody User user){
            return userService.deleteUser(user);
        }
        @PostMapping("/queryUserAll")
        @ResponseBody
        public ArrayList queryUserAll(){
            ArrayList  data= userService.queryUserAll();
            return data;

        }

    }
