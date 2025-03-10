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

import com.erp.admin.entity.Admission;
import com.erp.repo.AdmissionRepo;
import com.erp.student.entity.BonafideEntity;
import com.erp.student.entity.StudentDocument;
import com.erp.student.entity.TCEntity;
import com.erp.student.repo.BonafideRepository;
import com.erp.student.repo.StudentDocumentRepository;

import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;

@Controller
@RequestMapping("/admin")
public class BonafideController1 {

    @Autowired
    private JavaMailSender mailSender;

    @Autowired
    private BonafideRepository bonafideRepository;
    
    @Autowired
    private AdmissionRepo admissionRepo;

    @Autowired
    private StudentDocumentRepository studentDocumentRepository;
    
    @GetMapping("/view_pedding_bonafide")
    public String viewPendingBonafide(Model model) {
        List<BonafideEntity> bonafideEntities = bonafideRepository.findByAdminApproval(0);
        System.out.println("iudu");
        model.addAttribute("bonafides", bonafideEntities);
        return "Admin/view_pending_bonafide";
    }

    @GetMapping("/view_approved_bonafide")
    public String viewApprovedBonafide(Model model) {
        List<BonafideEntity> bonafideEntities = bonafideRepository.findByAdminApproval(1);
        model.addAttribute("bonafides", bonafideEntities);
        return "Admin/view_approved_bonafide";
    }

    @GetMapping("/view_rejected_bonafide")
    public String viewRejectedBonafide(Model model) {
        List<BonafideEntity> bonafideEntities = bonafideRepository.findByAdminApproval(2);
        model.addAttribute("bonafides", bonafideEntities);
        return "Admin/view_rejected_bonafide";
    }
    
    
    @GetMapping("/view_bonafide_application/{id}")
	public String viewApplication(@PathVariable Long id, Model model) {
	    Optional<BonafideEntity> application = bonafideRepository.findById(id);
	    
	    if (application.isPresent()) {
	        model.addAttribute("tc", application.get()); 
	        // Add entity to model
	        //System.out.println(application.get());
	        return "admin/view_bonafide_application";
	    } else {
	        return "redirect:/admin/view_pedding_bonafide";
	    }
	}
    
    @GetMapping("/verify_bonafide_certificate/{id}")
    public String approveBonafideCertificate(@PathVariable Long id) {
       
        bonafideRepository.findById(id).ifPresent(bonafide -> {
            bonafide.setAdminApproval(1); // Set approval to 1 (Approved)
            bonafideRepository.save(bonafide); // Save changes
            
            Optional<Admission> admission=admissionRepo.findByAdmissionId(bonafide.getStudentId());
            
            if(admission.isPresent())
            {
            	Admission student=admission.get();
            	 try {
                     sendBonafideApprovalEmail(student.getEmail(), bonafide.getFullName(), bonafide.getId());
                 } catch (MessagingException e) {
                     e.printStackTrace(); // Log error if email fails
                 }
            }
            
            // ✅ Send email after approval
           
        });

        return "redirect:/admin/open_bonafide/" + id; // ✅ Redirect to view page
    }

    
    private void sendBonafideApprovalEmail(String to, String fullName, Long id) throws MessagingException {
        MimeMessage message = mailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(message, true);

        String subject = "Notification: Bonafide Certificate Approved";
        String body = "<html><body>"
                + "<h3>Dear " + fullName + ",</h3>"
                + "<p>We are pleased to inform you that your Bonafide Certificate request has been approved.</p>"
                + "<p><b>Application ID (Bonafide ID):</b> 2025" + id + "</p>" // ✅ Added Application ID
                + "<p>Please visit <b>Office No. 3</b> at <b>Fergusson College (Autonomous), Pune</b> at your earliest convenience to collect it.</p>"
                + "<p>For a smooth collection process, kindly ensure you bring your Student ID card as proof of identity.</p>"
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
    
    @GetMapping("/open_bonafide/{id}")
    public String openBonafide(Model model, @PathVariable Long id) {
        Optional<BonafideEntity> entityOptional = bonafideRepository.findById(id);
        
        if (entityOptional.isPresent()) {
            BonafideEntity bonafideEntity = entityOptional.get();
            StudentDocument document = studentDocumentRepository.findByStudentId(bonafideEntity.getStudentId())
                                                                .orElse(null); // Avoids null issues
            
            model.addAttribute("document", document);
            model.addAttribute("bonafide", bonafideEntity);
        } else {
            model.addAttribute("error", "Bonafide record not found!");
            return "redirect:/admin/bonafide_list"; // Redirect to listing page if not found
        }

        return "Admin/open_bonafide";
    }

    
    @GetMapping("/reject_bonafide_certificate/{id}")
	public String rejectCertificate(@PathVariable Long id) {
	   
		bonafideRepository.findById(id).ifPresent(tc -> {
            tc.setAdminApproval(2); // Set approval to 1 (Approved)
            bonafideRepository.save(tc); // Save changes
        });

	     return "redirect:/admin/view_pending_bonafide"; // ✅ Redirect to view page
	    
	}
	
    @GetMapping("/issue_bonafide/{id}")
    public String issueTC(@PathVariable Long id) {
        bonafideRepository.findById(id).ifPresent(tc -> {
            tc.setIssueDate(new Date()); // Set current date using Date object
            bonafideRepository.save(tc); // Save updated TC directly
        });
        return "redirect:/admin/view_approved_bonafide"; // Redirect back to TC list
    }
    
    @GetMapping("/delete_bonafide/{id}")
    public String deleteTC(@PathVariable Long id, RedirectAttributes redirectAttributes) {
        try {
            bonafideRepository.deleteById(id);
            redirectAttributes.addFlashAttribute("success", "TC deleted successfully!");
        } catch (Exception e) {
            redirectAttributes.addFlashAttribute("error", "Error deleting TC!");
        }
        return "redirect:/admin/view_rejected_bonafide"; // Redirect back to TC list
    }
	
    

}
