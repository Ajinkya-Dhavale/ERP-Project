package com.erp.student.controller;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.erp.student.entity.TCEntity;
import com.erp.student.service.TCService;

@Controller
@RequestMapping("/student")
public class TCController {

	private static final String UPLOAD_DIR = System.getProperty("user.dir") + "/src/main/resources/static/uploads/";


    @Autowired
    private TCService tcService;

    @PostMapping("/save_tc")
    public String saveTC(@ModelAttribute TCEntity tcEntity, RedirectAttributes redirectAttributes) {
        try {
            // Save files and set file names in entity
            tcEntity.setLatestMarksheet(saveFile(tcEntity.getLatestMarksheetFile()));
            tcEntity.setPassingCertificate(saveFile(tcEntity.getPassingCertificateFile()));
            tcEntity.setProofOfAdmission(saveFile(tcEntity.getProofOfAdmissionFile()));
            tcEntity.setBirthDateProof(saveFile(tcEntity.getBirthDateProofFile()));
            tcEntity.setIdentityProof(saveFile(tcEntity.getIdentityProofFile()));

            // Save entity in the database
            tcService.save(tcEntity);

            redirectAttributes.addFlashAttribute("successMessage", "Documents uploaded successfully!");
            return "redirect:/student/request_certificate";// Redirect to success page
        } catch (Exception e) {
            redirectAttributes.addFlashAttribute("errorMessage", "Error uploading documents.");
            return "redirect:/error"; // Redirect to error page
        }
    }

    private String saveFile(MultipartFile file) throws IOException {
        if (file != null && !file.isEmpty()) {
            // Ensure upload directory exists
            File directory = new File(UPLOAD_DIR);
            if (!directory.exists()) {
                directory.mkdirs(); // Create directories if they do not exist
            }

            // Generate a unique file name
            String fileName = System.currentTimeMillis() + "_" + file.getOriginalFilename();
            Path filePath = Paths.get(UPLOAD_DIR, fileName);

            // Save the file
            Files.write(filePath, file.getBytes());

            return fileName; // Return saved file name
        }
        return null;
    }
    
    
}
