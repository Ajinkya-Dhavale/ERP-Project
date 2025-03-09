package com.erp.student.entity;

import jakarta.persistence.*;

import java.util.Date;

import org.springframework.web.multipart.MultipartFile;

@Entity
@Table(name = "bonafide")
public class BonafideEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "student_id")
    private String studentId;

    @Column(name = "certificate_type")
    private String certificateType;

    @Column(name = "certificate_reason")
    private String certificateReason;

    // Personal details
    @Column(name = "full_name")
    private String fullName;

    @Column(name = "gender")
    private String gender;

    @Column(name = "dob")
    private String dob;

    @Column(name = "dob_in_words")
    private String dobInWords;

    @Column(name = "division")
    private String division;

    @Column(name = "year")
    private String year;

    @Column(name = "department")
    private String department;

    @Column(name = "course")
    private String course;

    @Column(name = "local_address")
    private String localAddress;

    @Column(name = "permanent_address")
    private String permanentAddress;

    // Document Paths stored in DB
    @Column(name = "identity_proof_path")
    private String identityProofPath;

    @Column(name = "birth_proof_path")
    private String birthProofPath;

    @Column(name = "fee_receipt_path")
    private String feeReceiptPath;

    @Column(name = "total_fees")
    private Double totalFees;

    // Approval Status (0 = Pending, 1 = Approved, -1 = Rejected)
    @Column(name = "admin_approval")
    private Integer adminApproval = 0;
    
    
    @Column(name = "payment_id")
    private String paymentId;
    
    @Column(name = "application_date")
    private Date applicationDate=new Date();
    
    @Column(name = "payment_status")
    private String paymentStatus;
    
    @Column(name = "issue_date")
    private Date issueDate;
    
    

    public Date getIssueDate() {
		return issueDate;
	}

	public void setIssueDate(Date issueDate) {
		this.issueDate = issueDate;
	}

	// Transient Fields for File Uploads
    @Transient
    private MultipartFile identityProofFile;

    @Transient
    private MultipartFile birthProofFile;

    @Transient
    private MultipartFile feeReceiptFile;

    // Constructors
    public BonafideEntity() {}

    // Getters and Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getStudentId() { return studentId; }
    public void setStudentId(String studentId) { this.studentId = studentId; }

    public String getCertificateType() { return certificateType; }
    public void setCertificateType(String certificateType) { this.certificateType = certificateType; }

    public String getCertificateReason() { return certificateReason; }
    public void setCertificateReason(String certificateReason) { this.certificateReason = certificateReason; }

    public String getFullName() { return fullName; }
    public void setFullName(String fullName) { this.fullName = fullName; }

    public String getGender() { return gender; }
    public void setGender(String gender) { this.gender = gender; }

    public String getDob() { return dob; }
    public void setDob(String dob) { this.dob = dob; }

    public String getDobInWords() { return dobInWords; }
    public void setDobInWords(String dobInWords) { this.dobInWords = dobInWords; }

    public String getDivision() { return division; }
    public void setDivision(String division) { this.division = division; }

    public String getYear() { return year; }
    public void setYear(String year) { this.year = year; }

    public String getDepartment() { return department; }
    public void setDepartment(String department) { this.department = department; }

    public String getCourse() { return course; }
    public void setCourse(String course) { this.course = course; }

    public String getLocalAddress() { return localAddress; }
    public void setLocalAddress(String localAddress) { this.localAddress = localAddress; }

    public String getPermanentAddress() { return permanentAddress; }
    public void setPermanentAddress(String permanentAddress) { this.permanentAddress = permanentAddress; }

    public String getIdentityProofPath() { return identityProofPath; }
    public void setIdentityProofPath(String identityProofPath) { this.identityProofPath = identityProofPath; }

    public String getBirthProofPath() { return birthProofPath; }
    public void setBirthProofPath(String birthProofPath) { this.birthProofPath = birthProofPath; }

    public String getFeeReceiptPath() { return feeReceiptPath; }
    public void setFeeReceiptPath(String feeReceiptPath) { this.feeReceiptPath = feeReceiptPath; }

    public Double getTotalFees() { return totalFees; }
    public void setTotalFees(Double totalFees) { this.totalFees = totalFees; }

    public Integer getAdminApproval() { return adminApproval; }
    public void setAdminApproval(Integer adminApproval) { this.adminApproval = adminApproval; }

    
    
    public String getPaymentId() {
		return paymentId;
	}

	public void setPaymentId(String paymentId) {
		this.paymentId = paymentId;
	}

	public Date getApplicationDate() {
		return applicationDate;
	}

	public void setApplicationDate(Date applicationDate) {
		this.applicationDate = applicationDate;
	}

	public String getPaymentStatus() {
		return paymentStatus;
	}

	public void setPaymentStatus(String paymentStatus) {
		this.paymentStatus = paymentStatus;
	}

	// Getters and Setters for Transient Fields
    public MultipartFile getIdentityProofFile() { return identityProofFile; }
    public void setIdentityProofFile(MultipartFile identityProofFile) { this.identityProofFile = identityProofFile; }

    public MultipartFile getBirthProofFile() { return birthProofFile; }
    public void setBirthProofFile(MultipartFile birthProofFile) { this.birthProofFile = birthProofFile; }

    public MultipartFile getFeeReceiptFile() { return feeReceiptFile; }
    public void setFeeReceiptFile(MultipartFile feeReceiptFile) { this.feeReceiptFile = feeReceiptFile; }

	@Override
	public String toString() {
		return "BonafideEntity [id=" + id + ", studentId=" + studentId + ", certificateType=" + certificateType
				+ ", certificateReason=" + certificateReason + ", fullName=" + fullName + ", gender=" + gender
				+ ", dob=" + dob + ", dobInWords=" + dobInWords + ", division=" + division + ", year=" + year
				+ ", department=" + department + ", course=" + course + ", localAddress=" + localAddress
				+ ", permanentAddress=" + permanentAddress + ", identityProofPath=" + identityProofPath
				+ ", birthProofPath=" + birthProofPath + ", feeReceiptPath=" + feeReceiptPath + ", totalFees="
				+ totalFees + ", adminApproval=" + adminApproval + ", paymentId=" + paymentId + ", applicationDate="
				+ applicationDate + ", paymentStatus=" + paymentStatus + ", identityProofFile=" + identityProofFile
				+ ", birthProofFile=" + birthProofFile + ", feeReceiptFile=" + feeReceiptFile + ", getId()=" + getId()
				+ ", getStudentId()=" + getStudentId() + ", getCertificateType()=" + getCertificateType()
				+ ", getCertificateReason()=" + getCertificateReason() + ", getFullName()=" + getFullName()
				+ ", getGender()=" + getGender() + ", getDob()=" + getDob() + ", getDobInWords()=" + getDobInWords()
				+ ", getDivision()=" + getDivision() + ", getYear()=" + getYear() + ", getDepartment()="
				+ getDepartment() + ", getCourse()=" + getCourse() + ", getLocalAddress()=" + getLocalAddress()
				+ ", getPermanentAddress()=" + getPermanentAddress() + ", getIdentityProofPath()="
				+ getIdentityProofPath() + ", getBirthProofPath()=" + getBirthProofPath() + ", getFeeReceiptPath()="
				+ getFeeReceiptPath() + ", getTotalFees()=" + getTotalFees() + ", getAdminApproval()="
				+ getAdminApproval() + ", getPaymentId()=" + getPaymentId() + ", getApplicationDate()="
				+ getApplicationDate() + ", getPaymentStatus()=" + getPaymentStatus() + ", getIdentityProofFile()="
				+ getIdentityProofFile() + ", getBirthProofFile()=" + getBirthProofFile() + ", getFeeReceiptFile()="
				+ getFeeReceiptFile() + ", getClass()=" + getClass() + ", hashCode()=" + hashCode() + ", toString()="
				+ super.toString() + "]";
	}

	
}
