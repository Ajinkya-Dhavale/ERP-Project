package com.erp.interceptor;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

@Component
public class AccountInterceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        // Check if the "account" attribute exists in the session
        Object accountSession = request.getSession().getAttribute("account");

        if (accountSession == null) {
            // Redirect to the login page if the account user is not logged in
            response.sendRedirect("/");
            return false;
        }

        // Allow the request to proceed if the account user is logged in
        return true;
    }
}