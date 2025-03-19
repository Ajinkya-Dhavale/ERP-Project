package com.erp.interceptor;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

@Component
public class ScholarshipInterceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        // Check if the "account" attribute exists in the session
        Object scholarshipSession = request.getSession().getAttribute("scholarship");

        if (scholarshipSession == null) {
            // Redirect to the login page if the account user is not logged in
            response.sendRedirect("/");
            return false;
        }

        // Allow the request to proceed if the account user is logged in
        return true;
    }
}