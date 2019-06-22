package spring.hello.interceptr;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;

import spring.hello.Constants;

/**
 * @author xinufo
 *
 */
public class LoginInterceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
            throws Exception {
        // 放行白名单
        if (handler instanceof HandlerMethod) {
            HandlerMethod hm = (HandlerMethod) handler;
            boolean errorHandling = ErrorController.class.isAssignableFrom(hm.getBeanType()); // 是否为Spring错误处理器
            if (errorHandling || hm.getMethodAnnotation(PublicEndPoint.class) != null) {
                return true;
            }
        }
        HttpSession session = request.getSession();
        // 登录时会设置Session属性，此处根据此属性判断是否已经登录
        if (session.getAttribute(Constants.SESSION_KEY) == null) {
            // 未登录，返回401状态码
            response.sendError(HttpServletResponse.SC_UNAUTHORIZED);
            return false;
        }
        // 放行
        return true;
    }

}
