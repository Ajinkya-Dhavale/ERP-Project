package com.erp.service;

import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;

import com.erp.admin.entity.Admission;
import com.erp.repo.AdmissionRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;
import java.time.LocalDate;
import java.util.List;

@Service
public class AdmissionService {

    @Autowired
    private JavaMailSender mailSender;

    @Autowired
    private AdmissionRepo admissionRepository;

    public boolean checkAdmissionByAadhar(String aadharNumber) {
        return admissionRepository.existsByAadharNo(aadharNumber);
    }

    public Admission saveAdmission(Admission admission, RedirectAttributes redirectAttributes) {
        // Fetch the last admissionId
        Long lastAdmissionId = admissionRepository.findLastAdmissionId();
        Long newAdmissionId = (lastAdmissionId != null) ? lastAdmissionId + 1 : 1;

        // Generate admission_generated_id
        String generatedId = generateAdmissionId(newAdmissionId);
        admission.setAdmissionId(generatedId);

        // Generate a temporary password
        String tempPassword = admission.getPassword(); // Implement this method

        // Set the password (Consider encrypting it before saving)
        admission.setPassword(tempPassword);

        // Send an email to the user
        try {
            sendHtmlEmail(admission.getEmail(), generatedId, tempPassword, admission.getFirstName());
        } catch (Exception e) {
            redirectAttributes.addFlashAttribute("errorMessage", "Failed to send confirmation email.");
            e.printStackTrace();
        }

        // Save admission
        return admissionRepository.save(admission);
    }

    private String generateAdmissionId(Long admissionId) {
        int currentYear = LocalDate.now().getYear();
        return currentYear + String.format("%04d", admissionId); // Format: "202500001"
    }

    private void sendHtmlEmail(String to, String generatedId, String tempPassword, String firstName) throws MessagingException {
        MimeMessage message = mailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(message, true);

        String subject = "Admission Confirmation - Your Credentials";
        String body = "<html><body>" +
                "<h3>Dear " + firstName + ",</h3>" +
                "<p>Congratulations! Your admission has been successfully completed.</p>" +
                "<p>Here are your login details:</p>" +
                "<p><b>Admission ID: " + generatedId + "</b><br>" +
                "<b>Password: " + tempPassword + "</b></p>" +
                "<p>Please use the above credentials to log in and change your password upon first login.</p>" +
                "<p>If you have any questions, feel free to contact us.</p>" +
                "<p>Best regards,<br>The Admissions Team</p>" +
                "</body></html>";

        helper.setTo(to);
        helper.setSubject(subject);
        helper.setText(body, true); // true enables HTML

        mailSender.send(message);
    }

    public List<Admission> getAllStudents() {
        return admissionRepository.findAll();
    }
}
