package com.erp.student.service;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.erp.admin.entity.Admission;
import com.erp.student.entity.AcademicDetails;
import com.erp.student.entity.PersonalDetails;
import com.erp.student.entity.StudentAddress;
import com.erp.student.entity.StudentDocument;
import com.erp.student.repo.AcademicDetailsRepo;
import com.erp.student.repo.AddressRepo;
import com.erp.student.repo.PersonalDetailRepository;
import com.erp.student.repo.StudentDocumentRepository;
import com.erp.student.repo.StundentRepo;

import jakarta.persistence.criteria.Path;

@Service
public class StudentService {
    
    @Autowired
    private StundentRepo repo;
    
    @Autowired
    private PersonalDetailRepository personalDetailRepository;
    
    @Autowired
    private AcademicDetailsRepo academicDetailsRepo;
    
    @Autowired
    private AddressRepo addressRepo;
    
    @Autowired
    private StudentDocumentRepository studentDocumentRepository;
    
    private static final String UPLOAD_DIR = System.getProperty("user.dir") + "/src/main/resources/static/uploads/";

    public Admission findByUsernameAndPassword(String username, String password) {
        return repo.findByAdmissionIdAndPassword(username, password);
    }

//    personal details
	public void savePersonalDetail(PersonalDetails personalDetail) {
		Optional<PersonalDetails> existingRecord = personalDetailRepository.findByStudentId(personalDetail.getStudentId());

	    if (existingRecord.isPresent()) {
	        PersonalDetails existingDetails = existingRecord.get();
	        BeanUtils.copyProperties(personalDetail, existingDetails, "id"); // Copy all fields except "id"
	        personalDetailRepository.save(existingDetails);
	        
	    } else {
	        personalDetailRepository.save(personalDetail); // Insert new record
	    }
	}
	
	public PersonalDetails getPersonalDetailByStudentId(String studentId) {
        return personalDetailRepository.findByStudentId(studentId).orElse(new PersonalDetails());
    }
	
//	academic details
	 public AcademicDetails getAcademicDetailByStudentId(String studentId) {
	        return academicDetailsRepo.findByStudentId(studentId)
	                .orElse(new AcademicDetails());  // Return empty object if not found
	    }

    public void saveOrUpdateAcademicDetails(AcademicDetails academicDetails) {
        Optional<AcademicDetails> existingRecord = academicDetailsRepo.findByStudentId(academicDetails.getStudentId());

        if (existingRecord.isPresent()) {
            AcademicDetails existingDetails = existingRecord.get();
            BeanUtils.copyProperties(existingRecord, existingDetails, "id"); // Copy all fields except "id"
            academicDetailsRepo.save(existingDetails); // Update existing record
        } else {
            academicDetailsRepo.save(academicDetails); // Insert new record
        }
    }
    
//    saving and geting student address

    public StudentAddress getAddressByStudentId(String studentId)
    {
    	return addressRepo.findByStudentId(studentId).orElse(new StudentAddress());
    }

	public void saveOrUpdateStudentAddress(StudentAddress studentAddress) {
		Optional<StudentAddress> existingRecord = addressRepo.findByStudentId(studentAddress.getStudentId());

        if (existingRecord.isPresent()) {
            StudentAddress existingDetails = existingRecord.get();
            BeanUtils.copyProperties(existingRecord, existingDetails, "id"); // Copy all fields except "id"
            addressRepo.save(existingDetails); // Update existing record
        } else {
            addressRepo.save(studentAddress); // Insert new record
        }
		
	}
	
	
	
	
	
	
	
	
	
	 // Get Student Document by Student ID
    public StudentDocument getStudentDocumentByStudentId(String studentId) {
        return studentDocumentRepository.findByStudentId(studentId)
                .orElse(new StudentDocument()); // Return empty object if not found
    }

 // Save or Update Student Document
    public void saveOrUpdateStudentDocument(StudentDocument studentDocument) throws IOException {
        Optional<StudentDocument> existingRecord = studentDocumentRepository.findByStudentId(studentDocument.getStudentId());

        if (existingRecord.isPresent()) {
            StudentDocument existingDetails = existingRecord.get();
            BeanUtils.copyProperties(studentDocument, existingDetails, "id");

            if (studentDocument.getStudentPhoto() != null && !studentDocument.getStudentPhoto().isEmpty()) {
                existingDetails.setPhoto(saveFile(studentDocument.getStudentPhoto()));
            }
            if (studentDocument.getStudentSign() != null && !studentDocument.getStudentSign().isEmpty()) {
                existingDetails.setSign(saveFile(studentDocument.getStudentSign()));
            }

            studentDocumentRepository.save(existingDetails);
        } else {
            if (studentDocument.getStudentPhoto() != null && !studentDocument.getStudentPhoto().isEmpty()) {
                studentDocument.setPhoto(saveFile(studentDocument.getStudentPhoto()));
            }
            if (studentDocument.getStudentSign() != null && !studentDocument.getStudentSign().isEmpty()) {
                studentDocument.setSign(saveFile(studentDocument.getStudentSign()));
            }

            studentDocumentRepository.save(studentDocument);
        }
    }
    // File Saving Logic
    private String saveFile(MultipartFile file) throws IOException {
        if (file != null && !file.isEmpty()) {
            File directory = new File(UPLOAD_DIR);
            if (!directory.exists()) {
                directory.mkdirs();
            }

            String fileName = System.currentTimeMillis() + "_" + file.getOriginalFilename();
            File fileToSave = new File(UPLOAD_DIR + File.separator + fileName);

            Files.write(fileToSave.toPath(), file.getBytes());
            return fileName;
        }
        return null;
    }

	
	
	

}
