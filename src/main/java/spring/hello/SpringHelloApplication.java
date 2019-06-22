package spring.hello;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * 启动类，一般放于最根一级的包下
 * 
 * @author xinufo
 *
 */
@SpringBootApplication
public class SpringHelloApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringHelloApplication.class, args);
    }

}
