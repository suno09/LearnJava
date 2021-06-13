package dz.sundev.interceptors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.HandlerMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Map;

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
        System.out.println("URL is {} " + request.getRequestURI());

        /*String parameter = request.getParameter("parameter");
        if (parameter == "somevalue") {
            request.setAttribute("customAttribute", "value");
        }*/

        final Map<String, String> pathVariables = (Map<String, String>) request
                .getAttribute(HandlerMapping.URI_TEMPLATE_VARIABLES_ATTRIBUTE);

        System.out.println("Method ====> " + request.getMethod());

        pathVariables.forEach((s, s2) -> System.out.println(s + " ==> " + s2));
        request.setAttribute("id", 7);

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
