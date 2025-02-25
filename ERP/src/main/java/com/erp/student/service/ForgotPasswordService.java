package com.erp.student.service;

import java.util.Optional;
import java.util.Random;
import java.util.concurrent.ConcurrentHashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import com.erp.admin.entity.Admission;
import com.erp.repo.AdmissionRepo;

import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;

@Service
public class ForgotPasswordService {
	
	@Autowired
    private JavaMailSender mailSender;

    @Autowired
    private AdmissionRepo admissionRepository;

    // Store OTPs temporarily (should use Redis or a DB in production)
    private final ConcurrentHashMap<String, String> otpStore = new ConcurrentHashMap<>();

    public String generateOTP(String email) {
        Optional<Admission> admission = admissionRepository.findByEmail(email);

        if (admission.isPresent()) {
            String otp = String.format("%06d", new Random().nextInt(999999)); // Generate 6-digit OTP
            otpStore.put(email, otp);

            Admission student=admission.get();
            // Simulate sending OTP via email (Replace with actual email logic)
//            System.out.println("OTP for " + email + ": " + otp);
            
         // Send an email to the user
            try {
                sendOtpEmail(student.getEmail(),student.getFirstName(),otp);
            } catch (Exception e) {
//            	e.printStackTrace();
            	return "Internal Server Error";
            }

            return "OTP sent to your registered email.";
        } else {
            return "Email not found!";
        }
    }
    
    public void sendOtpEmail(String to, String firstName, String otp) throws MessagingException {
        MimeMessage message = mailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(message, true);

        String subject = "Your OTP for Password Reset";

        String body = "<html><body>" +
                "<h3>Dear " + firstName + ",</h3>" +
                "<p>You have requested to reset your password. Please use the OTP below to proceed:</p>" +
                "<h2 style='color: red;'>" + otp + "</h2>" +
                "<p>This OTP is valid for the next 10 minutes. Do not share it with anyone.</p>" +
                "<p>If you did not request this, please ignore this email.</p>" +
                "<br><p>Best regards,<br><b>Admissions Team</b></p>" +
                "</body></html>";

        helper.setTo(to);
        helper.setSubject(subject);
        helper.setText(body, true); // Enable HTML

        mailSender.send(message);
    }
    public boolean validateOTP(String email, String otp) {
        return otpStore.containsKey(email) && otpStore.get(email).equals(otp);
    }

    public String changePassword(String email, String newPassword) {
        Optional<Admission> admission = admissionRepository.findByEmail(email);

        if (admission.isPresent()) {
            Admission student = admission.get();
            student.setPassword(newPassword); // Update password (consider hashing)
            admissionRepository.save(student);

            otpStore.remove(email); // Clear OTP after successful reset
            return "Password updated successfully!";
        } else {
            return "Email not found!";
        }
    }
}
