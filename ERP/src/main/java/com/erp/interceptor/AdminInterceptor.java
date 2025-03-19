package com.erp.interceptor;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

@Component
public class AdminInterceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        // Allow access to the login URL
        String requestURI = request.getRequestURI();
        if (requestURI.equals("/admin/login")) {
            return true;
        }

        // Check if the "admin" attribute exists in the session
        Object adminSession = request.getSession().getAttribute("admin");

        if (adminSession == null) {
            // Redirect to the login page if the admin is not logged in
            response.sendRedirect("/");
            return false;
        }

        // Allow the request to proceed if the admin is logged in
        return true;
    }
}