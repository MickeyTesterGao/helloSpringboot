package spring.hello.exception;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

/**
 * @author xinufo
 *
 */
@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler
    public String handlerUnAuth(UnAuthException ex) {
        String msg = ex.getMessage();
        return msg == null ? "未登录" : msg;
    }

    @ExceptionHandler
    public String handlerUnAuth(Exception ex) {
        String msg = ex.getMessage();
        return msg == null ? "未知异常" : msg;
    }

}
