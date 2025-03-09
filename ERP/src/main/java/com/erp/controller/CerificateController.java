package com.erp.controller;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.erp.student.entity.TCEntity;
import com.erp.student.repo.TCRepository;

import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;

@Controller
@RequestMapping("/admin")
public class CerificateController {
	
	@Autowired
	private JavaMailSender mailSender;
	
	@Autowired
	public TCRepository repository;
	
	@GetMapping("/view_pending_tc")
	public String openTCPage(Model model)
	{
		List<TCEntity> tcEntities = repository.findByAdminApproval(0);
        model.addAttribute("tcEntities", tcEntities);

		return "Admin/view_tc_certificate";
	}
	
	@GetMapping("/view_approved_tc")
	public String openTCPage1(Model model)
	{
		List<TCEntity> tcEntities = repository.findByAdminApproval(1);
        model.addAttribute("tcEntities", tcEntities);

		return "Admin/view_approved_tc";
	}
	
	@GetMapping("/view_rejected_tc")
	public String openTCPage2(Model model)
	{
		List<TCEntity> tcEntities = repository.findByAdminApproval(2);
        model.addAttribute("tcEntities", tcEntities);

		return "Admin/view_rejected_tc";
	}
	
	@GetMapping("/view_tc_application/{id}")
	public String viewApplication(@PathVariable Long id, Model model) {
	    Optional<TCEntity> application = repository.findById(id);
	    
	    if (application.isPresent()) {
	        model.addAttribute("tc", application.get()); 
	        // Add entity to model
	        //System.out.println(application.get());
	        return "admin/view_tc_application";
	    } else {
	        return "redirect:/admin/view_tc_certificate";
	    }
	}
	
	
	@GetMapping("/verify_tc_certificate/{id}")
	public String approveCertificate(@PathVariable Long id) {
	   
		repository.findById(id).ifPresent(tc -> {
            tc.setAdminApproval(1); // Set approval to 1 (Approved)
            repository.save(tc); // Save changes
            
            // ✅ Send email after approval
            try {
            	sendTCCreationEmail(tc.getEmailId(), tc.getFirstName(),tc.getLastName(), tc.getId());
            } catch (MessagingException e) {
                e.printStackTrace(); // Log error if email fails
            }
        });

	     return "redirect:/admin/open_tc/"+id; // ✅ Redirect to view page
	}
	
	private void sendTCCreationEmail(String to, String firstName, String lastName, Long id) throws MessagingException {
	    MimeMessage message = mailSender.createMimeMessage();
	    MimeMessageHelper helper = new MimeMessageHelper(message, true);

	    String subject = "Notification: Transference Certificate Created Successfully";
	    String body = "<html><body>"
	            + "<h3>Dear " + firstName + " " + lastName + ",</h3>"
	            + "<p>We are pleased to inform you that your Transfer Certificate (TC) has been created successfully.</p>"
	            + "<p><b>Application ID (TC ID):</b> 2025" + id + "</p>" // ✅ Added Application ID
	            + "<p>Please visit <b>Office No. 3</b> at <b>Fergusson College (Autonomous), Pune</b> at your earliest convenience to collect it.</p>"
	            + "<p>For a smooth collection process, kindly ensure you bring either your ID card or your admission receipt as proof of identity.</p>"
	            + "<p>If you have any questions or need further assistance, please do not hesitate to contact our administrative office.</p>"
	            + "<p>Thank you for your cooperation.</p>"
	            + "<br>"
	            + "<p><b>Best regards,</b><br>"
	            + "Fergusson College (Autonomous), Pune<br>"
	            + "<i>office.fc@gmail.com</i></p>"
	            + "</body></html>";

	    helper.setTo(to);
	    helper.setSubject(subject);
	    helper.setText(body, true); // ✅ Enable HTML format

	    mailSender.send(message); // ✅ Send email
	}

	
	@GetMapping("/reject_tc_certificate/{id}")
	public String rejectCertificate(@PathVariable Long id) {
	   
		repository.findById(id).ifPresent(tc -> {
            tc.setAdminApproval(2); // Set approval to 1 (Approved)
            repository.save(tc); // Save changes
        });

	     return "redirect:/admin/view_pending_tc"; // ✅ Redirect to view page
	    
	}
	
	
	@GetMapping("/open_tc/{id}")
	public String openTC(Model model,@PathVariable Long id)
	{
		TCEntity tcEntity=null;
		Optional<TCEntity> tcEntities=repository.findById(id);
		if(tcEntities.isPresent())
		{
			tcEntity=tcEntities.get();
		}
		
        model.addAttribute("tc", tcEntity);

		return "Admin/open_tc";
	}
	
	@GetMapping("/deleteTC/{id}")
    public String deleteTC(@PathVariable Long id, RedirectAttributes redirectAttributes) {
        try {
            repository.deleteById(id);
            redirectAttributes.addFlashAttribute("success", "TC deleted successfully!");
        } catch (Exception e) {
            redirectAttributes.addFlashAttribute("error", "Error deleting TC!");
        }
        return "redirect:/admin/view_rejected_tc"; // Redirect back to TC list
    }
	
	@GetMapping("/issue_tc/{id}")
    public String issueTC(@PathVariable Long id) {
        repository.findById(id).ifPresent(tc -> {
            tc.setIssueDate(new Date()); // Set current date using Date object
            repository.save(tc); // Save updated TC directly
        });
        return "redirect:/admin/view_approved_tc"; // Redirect back to TC list
    }



}
