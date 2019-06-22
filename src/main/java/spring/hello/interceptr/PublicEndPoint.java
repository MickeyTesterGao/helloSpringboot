package spring.hello.interceptr;

import static java.lang.annotation.ElementType.METHOD;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

/**
 * 白名单（无需登录）
 * 
 * @author xinufo
 *
 */
@Documented
@Retention(RUNTIME)
@Target(METHOD)
public @interface PublicEndPoint {

}
