package spring.hello.service;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.dao.DuplicateKeyException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import spring.hello.Constants;
import spring.hello.domain.entity.UserDO;
import spring.hello.domain.form.UserForm;
import spring.hello.exception.UnAuthException;
import spring.hello.mapper.IUserMapper;

/**
 * @author xinufo
 *
 */
@Service
public class UserService {
    private IUserMapper userMapper;
    private PasswordEncoder encoder;

    public UserService(IUserMapper userMapper, PasswordEncoder encoder) {
        this.userMapper = userMapper;
        this.encoder = encoder;
    }

    public void login(String username, String password, HttpSession session) {
        UserDO user = userMapper.findByUsername(username);
        if (user == null) {
            throw new UnAuthException("用户名或密码错误");
        }
        if (!encoder.matches(password, user.getPassword())) {
            throw new UnAuthException("用户名或密码错误");

        }
        session.setAttribute(Constants.SESSION_KEY, user.getId());
    }

    public Integer register(UserForm form) {
        UserDO entity = translate(form);
        // 加密密码
        entity.setPassword(encoder.encode(entity.getPassword()));
        try {
            userMapper.add(entity);
            return entity.getId();
        } catch (DuplicateKeyException e) {
            // 通过数据库唯一索引保证用户名不重复
            throw new RuntimeException("用户名已经被使用");
        }
    }

    public void update(Integer id, UserForm form) {
        UserDO entity = translate(form);
        // 加密密码
        entity.setPassword(encoder.encode(entity.getPassword()));
        try {
            if (userMapper.update(entity) == 0) {
                throw new RuntimeException("用户不存在");
            }
        } catch (DuplicateKeyException e) {
            throw new RuntimeException("用户名已经被使用");
        }
    }

    public void delete(Integer id) {
        if (userMapper.deleteById(id) == 0) {
            throw new RuntimeException("用户不存在");
        }
    }

    public List<UserDO> findAll() {
        return userMapper.findAll();
    }

    public UserDO findById(Integer id) {
        return userMapper.findById(id);
    }

    private UserDO translate(UserForm form) {
        UserDO entity = new UserDO();
        entity.setUsername(form.getUsername());
        entity.setPassword(form.getPassword());
        entity.setName(form.getName());
        entity.setAge(form.getAge());
        entity.setSex(form.getSex());
        entity.setBirthday(form.getBirthday());
        return entity;
    }

}
