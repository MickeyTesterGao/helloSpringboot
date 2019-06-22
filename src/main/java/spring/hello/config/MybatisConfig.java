package spring.hello.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;

/**
 * @author xinufo
 *
 */
@Configuration
@MapperScan("spring.hello.mapper")
public class MybatisConfig {

}
