package com.erp.controller;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class GlobalErrorController implements ErrorController {

    @RequestMapping("/error")
    public String handleError(HttpServletRequest request, Model model) {
        // Get error details
        Object statusCode = request.getAttribute("javax.servlet.error.status_code");
        Object errorMessage = request.getAttribute("javax.servlet.error.message");

        // Pass error details to the model
        model.addAttribute("status", statusCode);
        model.addAttribute("error", errorMessage);

        // Return the custom error page
        return "error";
    }
}