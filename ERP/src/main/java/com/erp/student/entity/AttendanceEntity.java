package com.erp.student.entity;

import java.time.LocalDate;
import java.util.Date;

import org.springframework.web.multipart.MultipartFile;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Transient;

@Entity
@Table(name = "attendance")
public class AttendanceEntity {
	 	@Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private Long id;
	 
	 	@Column(name = "student_id")
	    private String studentId;

	    @Column(name = "certificate_type")
	    private String certificateType;

	    @Column(name = "certificate_reason")
	    private String certificateReason;
	    
	    @Column(name = "full_name")
	    private String fullName;

	    @Column(name = "gender")
	    private String gender;

	    
	    @Column(name = "year")
	    private String year;

	    @Column(name = "division")
	    private String division;
	    
	    @Column(name = "department")
	    private String department;

	    @Column(name = "course")
	    private String course;
	    
	    @Column(name = "application_date")
	    private Date applicationDate=new Date();
	    
	    @Column(name = "from_date")
	    private String fromDate;
	    
	    @Column(name = "to_date")
	    private String toDate;
	    
	    @Column(name="teacher_name")
	    private String teacherName;

	    @Column(name="teacher_verified_date")
	    private String teacherVerifiedDate;

	    @Column(name = "issue_date")
	    private Date issueDate;
	    
	    @Column(name = "identity_proof_path")
	    private String identityProofPath;
	    
	    @Transient
	    private MultipartFile identityProofFile;
	    
	    @Column(name = "fee_reciept_path")
	    private String feeReciptPath;
	    
	    @Transient
	    private MultipartFile feeReciptFile;
	    
	    @Column(name = "verification_letter_path")
	    private String verificationLetterPath;
	    
	    @Transient
	    private MultipartFile verificationLetterFile;
	    
	    // Approval Status (0 = Pending, 1 = Approved, -1 = Rejected)
	    @Column(name = "admin_approval")
	    private Integer adminApproval = 0;

		public Long getId() {
			return id;
		}

		public void setId(Long id) {
			this.id = id;
		}

		public String getStudentId() {
			return studentId;
		}

		public void setStudentId(String studentId) {
			this.studentId = studentId;
		}

		public String getCertificateType() {
			return certificateType;
		}

		public void setCertificateType(String certificateType) {
			this.certificateType = certificateType;
		}

		public String getCertificateReason() {
			return certificateReason;
		}

		public void setCertificateReason(String certificateReason) {
			this.certificateReason = certificateReason;
		}

		public String getFullName() {
			return fullName;
		}

		public void setFullName(String fullName) {
			this.fullName = fullName;
		}

		public String getGender() {
			return gender;
		}

		public void setGender(String gender) {
			this.gender = gender;
		}
		public String getYear() {
			return year;
		}

		public void setYear(String year) {
			this.year = year;
		}

		public String getDivision() {
			return division;
		}

		public void setDivision(String division) {
			this.division = division;
		}

		public String getDepartment() {
			return department;
		}

		public void setDepartment(String department) {
			this.department = department;
		}

		public String getCourse() {
			return course;
		}

		public void setCourse(String course) {
			this.course = course;
		}

		public Date getApplicationDate() {
			return applicationDate;
		}

		public void setApplicationDate(Date applicationDate) {
			this.applicationDate = applicationDate;
		}

		public String getFromDate() {
			return fromDate;
		}

		public void setFromDate(String fromDate) {
			this.fromDate = fromDate;
		}

		public String getToDate() {
			return toDate;
		}

		public void setToDate(String toDate) {
			this.toDate = toDate;
		}

		public String getTeacherName() {
			return teacherName;
		}

		public void setTeacherName(String teacherName) {
			this.teacherName = teacherName;
		}

		public String getTeacherVerifiedDate() {
			return teacherVerifiedDate;
		}

		public void setTeacherVerifiedDate(String teacherVerifiedDate) {
			this.teacherVerifiedDate = teacherVerifiedDate;
		}

		public Date getIssueDate() {
			return issueDate;
		}

		public void setIssueDate(Date issueDate) {
			this.issueDate = issueDate;
		}

		public String getIdentityProofPath() {
			return identityProofPath;
		}

		public void setIdentityProofPath(String identityProofPath) {
			this.identityProofPath = identityProofPath;
		}

		public MultipartFile getIdentityProofFile() {
			return identityProofFile;
		}

		public void setIdentityProofFile(MultipartFile identityProofFile) {
			this.identityProofFile = identityProofFile;
		}

		public String getFeeReciptPath() {
			return feeReciptPath;
		}

		public void setFeeReciptPath(String feeReciptPath) {
			this.feeReciptPath = feeReciptPath;
		}

		public MultipartFile getFeeReciptFile() {
			return feeReciptFile;
		}

		public void setFeeReciptFile(MultipartFile feeReciptFile) {
			this.feeReciptFile = feeReciptFile;
		}

		public String getVerificationLetterPath() {
			return verificationLetterPath;
		}

		public void setVerificationLetterPath(String verificationLetterPath) {
			this.verificationLetterPath = verificationLetterPath;
		}

		public MultipartFile getVerificationLetterFile() {
			return verificationLetterFile;
		}

		public void setVerificationLetterFile(MultipartFile verificationLetterFile) {
			this.verificationLetterFile = verificationLetterFile;
		}

		public Integer getAdminApproval() {
			return adminApproval;
		}

		public void setAdminApproval(Integer adminApproval) {
			this.adminApproval = adminApproval;
		}

		@Override
		public String toString() {
			return "AttendanceEntity [id=" + id + ", studentId=" + studentId + ", certificateType=" + certificateType
					+ ", certificateReason=" + certificateReason + ", fullName=" + fullName + ", gender=" + gender
					+ ", year=" + year + ", division=" + division + ", department=" + department
					+ ", course=" + course + ", applicationDate=" + applicationDate + ", fromDate=" + fromDate
					+ ", toDate=" + toDate + ", teacherName=" + teacherName + ", teacherVerifiedDate="
					+ teacherVerifiedDate + ", issueDate=" + issueDate + ", identityProofPath=" + identityProofPath
					+ ", identityProofFile=" + identityProofFile + ", feeReciptPath=" + feeReciptPath
					+ ", feeReciptFile=" + feeReciptFile + ", verificationLetterPath=" + verificationLetterPath
					+ ", verificationLetterFile=" + verificationLetterFile + ", adminApproval=" + adminApproval + "]";
		}	    
	    
}
