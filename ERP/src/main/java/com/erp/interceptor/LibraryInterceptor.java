package com.erp.interceptor;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

@Component
public class LibraryInterceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        // Check if the "library" attribute exists in the session
        Object librarySession = request.getSession().getAttribute("library");

        if (librarySession == null) {
            // Redirect to the login page if the library user is not logged in
            response.sendRedirect("/");
            return false;
        }

        // Allow the request to proceed if the library user is logged in
        return true;
    }
}