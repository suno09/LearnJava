package dz.sundev.interceptors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Interceptor in Spring Boot to perform operations under the following situations :
 * Before sending the request to the controller
 * Before sending the response to the client
 */

@Component
public class ProductServiceInterceptor implements HandlerInterceptor {
    Logger log = LoggerFactory.getLogger(ProductServiceInterceptor.class);

    // before sending the request to the controller
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        System.out.println("Pre Handle method is Calling");

        System.out.println("URL is {} " + request.getRequestURL());

        return true;
    }

    // before sending the response to the client.
    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        System.out.println("Post Handle method is Calling");
    }

    // after completing the request and response.
    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        System.out.println("Request and Response is completed");
    }
}
