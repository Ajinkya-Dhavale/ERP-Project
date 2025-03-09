package com.erp.student.controller;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.multipart.MultipartFile;

import com.erp.student.entity.BonafideEntity;
import com.erp.student.repo.BonafideRepository;

@Controller
@RequestMapping("/student")
public class BonafideController {

    @Autowired
    private BonafideRepository bonafideRepository;

    private static final String UPLOAD_DIR = System.getProperty("user.dir") + "/src/main/resources/static/uploads/";

    @PostMapping("/save_bonafide")
    public String saveBonafide(@ModelAttribute BonafideEntity bonafide,
                               @RequestParam("identityProofFile") MultipartFile identityProof,
                               @RequestParam("latestMarksheetFile") MultipartFile birthProof,
                               @RequestParam("proofOfAdmissionFile") MultipartFile feeReceipt,
                               RedirectAttributes redirectAttributes) {
        try {
            // Save files and set file names in entity
            bonafide.setIdentityProofPath(saveFile(identityProof));
            bonafide.setBirthProofPath(saveFile(birthProof));
            bonafide.setFeeReceiptPath(saveFile(feeReceipt));

            System.out.println("Identity Proof Path: " + bonafide.getIdentityProofPath());
            System.out.println("Birth Proof Path: " + bonafide.getBirthProofPath());
            System.out.println("Fee Receipt Path: " + bonafide.getFeeReceiptPath());
            // Save Bonafide Application to DB
            bonafideRepository.save(bonafide);

            
            redirectAttributes.addFlashAttribute("successMessage", "Bonafide application submitted successfully!");
            return "redirect:/student/request_certificate";
        } catch (Exception e) {
            redirectAttributes.addFlashAttribute("errorMessage", "Error saving application: " + e.getMessage());
            return "redirect:/student/error";
        }
    }

    private String saveFile(MultipartFile file) throws IOException {
        if (file != null && !file.isEmpty()) {
            File directory = new File(UPLOAD_DIR);
            if (!directory.exists()) {
                directory.mkdirs();
            }
            String fileName = System.currentTimeMillis() + "_" + file.getOriginalFilename();
            Path filePath = Paths.get(UPLOAD_DIR, fileName);
            Files.write(filePath, file.getBytes());
            return fileName;
        } else {
            System.out.println("File is null or empty!");
        }
        return null;
    }


}
