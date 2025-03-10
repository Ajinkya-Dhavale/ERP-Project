package com.erp.student.entity;

import org.springframework.web.multipart.MultipartFile;
import jakarta.persistence.*;

@Entity
@Table(name="student_document")
public class StudentDocument {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String studentId;  

    private String photo;  // Stores file name
    private String sign;   // Stores file name
    
    @Transient
    private MultipartFile studentPhoto;
    
    @Transient
    private MultipartFile studentSign;

    // Getters and Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getStudentId() { return studentId; }
    public void setStudentId(String studentId) { this.studentId = studentId; }

    public String getPhoto() { return photo; }
    public void setPhoto(String photo) { this.photo = photo; }

    public String getSign() { return sign; }
    public void setSign(String sign) { this.sign = sign; }

    public MultipartFile getStudentPhoto() { return studentPhoto; }
    public void setStudentPhoto(MultipartFile studentPhoto) { this.studentPhoto = studentPhoto; }

    public MultipartFile getStudentSign() { return studentSign; }
    public void setStudentSign(MultipartFile studentSign) { this.studentSign = studentSign; }
}
