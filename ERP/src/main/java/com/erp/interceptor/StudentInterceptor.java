package com.erp.interceptor;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

@Component
public class StudentInterceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        // Get the requested URL
        String requestURI = request.getRequestURI();
        String method=request.getMethod();

        // Allow access to the login URL
        if (requestURI.equals("/student/login") && method.equals("POST")) {
            return true;
        }

        // Check if the "student" attribute exists in the session
        Object studentSession = request.getSession().getAttribute("student");

        if (studentSession == null) {
            // Redirect to the login page if the student is not logged in
            response.sendRedirect("/");
            return false;
        }

        // Allow the request to proceed if the student is logged in
        return true;
    }
}