package spring.hello.mapper;

import java.util.List;

import spring.hello.domain.entity.UserDO;

/**
 * Mapper一般为接口，所以习惯以字母“I”开头
 * 
 * @author xinufo
 *
 */
public interface IUserMapper {

    public UserDO findByUsername(String username);

    public UserDO findById(Integer id);

    public void add(UserDO user);

    public Integer update(UserDO user);

    public Integer deleteById(Integer id);

    public List<UserDO> findAll(); // 集合类型一般用接口类型，不要用具体实现类型

}
