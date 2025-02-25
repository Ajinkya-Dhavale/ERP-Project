package com.erp.student.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.erp.student.service.ForgotPasswordService;

@RestController
@RequestMapping("/forgot-password")
public class ForgotPasswordController {

    @Autowired
    private ForgotPasswordService forgotPasswordService;

    @PostMapping("/generate-otp")
    public ResponseEntity<String> generateOTP(@RequestBody Map<String, String> request) {
        String email = request.get("email");
        String message = forgotPasswordService.generateOTP(email);
        return ResponseEntity.ok(message);
    }

    @PostMapping("/validate-otp")
    public ResponseEntity<String> validateOTP(@RequestBody Map<String, String> request) {
        String email = request.get("email");
        String otp = request.get("otp");

        if (forgotPasswordService.validateOTP(email, otp)) {
            return ResponseEntity.ok("OTP Verified");
        } else {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Invalid OTP");
        }
    }

    @PostMapping("/change-password")
    public ResponseEntity<String> changePassword(@RequestBody Map<String, String> request) {
        String email = request.get("email");
        String newPassword = request.get("newPassword");

        String message = forgotPasswordService.changePassword(email, newPassword);
        return ResponseEntity.ok(message);
    }
}

