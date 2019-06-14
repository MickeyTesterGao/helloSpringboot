package spring.hello.helloSpringboot;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindException;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;
import sun.rmi.runtime.Log;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;


/**
 * 全局异常处理器
 *
 * @author xinufo
 */
@RestControllerAdvice
public class CommonException extends ResponseEntityExceptionHandler {
    protected static final Logger LOG = LoggerFactory.getLogger(CommonException.class);

    /**
     * 处理未知异常
     *
     * @param ex 异常信息
     * @return 响应信息
     */
    @ExceptionHandler(Exception.class)
    public String handle(Exception ex) {
        LOG.error("error", ex);
        return "unknown error: " + ex.getMessage();
    }

    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex,
                                                                  HttpHeaders headers, HttpStatus status, WebRequest request) {
        BindingResult result = ex.getBindingResult();
        Map<String, Object> infos = new HashMap<>(16);
        if (result.hasGlobalErrors()) {
            List<String> globals = new LinkedList<>();
            infos.put("global", globals);
            for (ObjectError err : result.getGlobalErrors()) {
                globals.add(err.getDefaultMessage());
            }
        }
        for (FieldError err : result.getFieldErrors()) {
            infos.put(err.getField(), err.getDefaultMessage());
        }
        return ResponseEntity.badRequest().body(infos);
    }

    @Override
    protected ResponseEntity<Object> handleBindException(BindException ex,
                                       HttpHeaders headers, HttpStatus status, WebRequest request) {
        LOG.info("===========================");
        BindingResult result = ex.getBindingResult();
        Map<String, Object> infos = new HashMap<>(16);
        if (result.hasGlobalErrors()) {
            List<String> globals = new LinkedList<>();
            infos.put("global", globals);
            for (ObjectError err : result.getGlobalErrors()) {
                globals.add(err.getDefaultMessage());
            }
        }
        for (FieldError err : result.getFieldErrors()) {
            LOG.info(err.getField());
            infos.put(err.getField(), err.getDefaultMessage());
        }
        return ResponseEntity.badRequest().body(infos);
    }

}
