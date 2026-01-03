package ynu.edu.interceptor;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import ynu.edu.common.TokenStore;

import java.io.IOException;

@Component
public class AuthInterceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request,
                             HttpServletResponse response,
                             Object handler) throws IOException {

        if ("OPTIONS".equalsIgnoreCase(request.getMethod())) {
            return true;
        }

        // 排除登录、注册等不需要认证的接口
        String requestURI = request.getRequestURI();
        if (requestURI.contains("/UserController/getUserByIdByPass") ||
                requestURI.contains("/UserController/getUserById") ||
                requestURI.contains("/UserController/saveUser") ||
                requestURI.contains("/doc.html") ||
                requestURI.contains("/swagger-resources") ||
                requestURI.contains("/v3/api-docs") ||
                requestURI.contains("/webjars")) {
            return true;
        }

        String authHeader = request.getHeader("Authorization");

        if (authHeader == null || !authHeader.startsWith("Bearer ")) {
            setUnauthorizedResponse(response, "未提供Token或Token格式错误");
            return false;
        }

        String token = authHeader.substring(7);

        if (!TokenStore.contains(token)) {
            setUnauthorizedResponse(response, "Token无效或已过期");
            return false;
        }

        return true;
    }

    private void setUnauthorizedResponse(HttpServletResponse response, String message) throws IOException {
        response.setStatus(401);
        response.setContentType("application/json;charset=UTF-8");
        response.getWriter().write(
                String.format("{\"code\":401,\"message\":\"%s\",\"data\":null}", message)
        );
        response.getWriter().flush();
    }
}