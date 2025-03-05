package com.erp.student.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Column;
import java.util.Date;

@Entity
@Table(name = "tc")
public class TCEntity {

    public TCEntity() {
        this.paymentDate = new Date();
        this.applicationDate=new Date();
        this.tcType="original";
    }
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @Column(name = "student_id")
    private String studentId;

    @Column(name = "certificate_type")
    private String certificateType="original";

    @Column(name = "tc_type")
    private String tcType;

    @Column(name = "certificate_reason")
    private String certificateReason;

    // Personal Section
    @Column(name = "first_name")
    private String firstName;

    @Column(name = "middle_name")
    private String middleName;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "contact_no")
    private String contactNo;

    @Column(name = "alternate_no")
    private String alternateNo;

    @Column(name = "dob")
    private String dob;

    @Column(name = "dob_in_words")
    private String dobInWords;

    @Column(name = "email_id")
    private String emailId;

    @Column(name = "gender")
    private String gender;

    @Column(name = "caste_category")
    private String casteCategory;

    @Column(name = "address")
    private String address;

    // Academic Section
    @Column(name = "department")
    private String department;

    @Column(name = "course")
    private String course;

    @Column(name = "last_sem")
    private String lastSem;

    @Column(name = "last_class")
    private String lastClass;
    
    // Examination Details
    @Column(name = "last_exam_name")
    private String lastExamName;

    @Column(name = "last_exam_month")
    private String lastExamMonth;

    @Column(name = "last_exam_year")
    private String lastExamYear;

    @Column(name = "last_seat_no")
    private String lastSeatNo;

    @Column(name = "last_result")
    private String lastResult;

    @Column(name = "last_cgpa")
    private String lastCgpa;

    @Column(name = "last_grade")
    private String lastGrade;

    @Column(name = "new_course")
    private String newCourse;

    @Column(name = "college_name")
    private String collegeName;

    @Column(name = "university_name")
    private String universityName;

    @Column(name = "new_admission_type")
    private String admissionType;

    // Document Section
    @Column(name = "latest_marksheet")
    private String latestMarksheet;

    @Column(name = "passing_certificate")
    private String passingCertificate;

    @Column(name = "proof_of_admission")
    private String proofOfAdmission;

    @Column(name = "birth_date_proof")
    private String birthDateProof;

    @Column(name = "identity_proof")
    private String identityProof;


    // Approval Section
    @Column(name = "account_approval")
    private Integer accountApproval=0;

    @Column(name = "library_approval")
    private Integer libraryApproval=0;

    @Column(name = "scholarship_approval")
    private Integer scholarshipApproval=0;

    @Column(name = "admin_approval")
    private Integer adminApproval=0;

    //payment section
    @Column(name = "payment_date")
    private Date paymentDate = new Date();

    @Column(name = "payment_id")
    private String paymentId;

    @Column(name = "payment_status")
    private String paymentStatus;

    @Column(name = "application_fee")
    private Double applicationFee;

    @Column(name = "processing_fee")
    private Double processingFee;

    @Column(name = "total_fee")
    private Double totalFee;

    @Column(name = "application_date")
    private Date applicationDate;

    
    
    
    public String getStudentId() {
		return studentId;
	}



	public void setStudentId(String studentId) {
		this.studentId = studentId;
	}



	public Date getApplicationDate() {
        return applicationDate;
    }


    
    public String getLastClass() {
		return lastClass;
	}



	public void setLastClass(String lastClass) {
		this.lastClass = lastClass;
	}



	public void setApplicationDate(Date applicationDate) {
		this.applicationDate = applicationDate;
	}



		// Getters and Setters
        public Long getId() {
            return id;
        }

        public void setId(Long id) {
            this.id = id;
        }

        public String getCertificateType() {
            return certificateType;
        }

        public void setCertificateType(String certificateType) {
            this.certificateType = certificateType;
        }

        public String getTcType() {
            return tcType;
        }

        public void setTcType(String tcType) {
            this.tcType = tcType;
        }

        public String getCertificateReason() {
            return certificateReason;
        }

        public void setCertificateReason(String certificateReason) {
            this.certificateReason = certificateReason;
        }

        public String getFirstName() {
            return firstName;
        }

        public void setFirstName(String firstName) {
            this.firstName = firstName;
        }

        public String getMiddleName() {
            return middleName;
        }

        public void setMiddleName(String middleName) {
            this.middleName = middleName;
        }

        public String getLastName() {
            return lastName;
        }

        public void setLastName(String lastName) {
            this.lastName = lastName;
        }

        public String getContactNo() {
            return contactNo;
        }

        public void setContactNo(String contactNo) {
            this.contactNo = contactNo;
        }

        public String getAlternateNo() {
            return alternateNo;
        }

        public void setAlternateNo(String alternateNo) {
            this.alternateNo = alternateNo;
        }

        public String getDob() {
            return dob;
        }

        public void setDob(String dob) {
            this.dob = dob;
        }

        public String getDobInWords() {
            return dobInWords;
        }

        public void setDobInWords(String dobInWords) {
            this.dobInWords = dobInWords;
        }

        public String getEmailId() {
            return emailId;
        }

        public void setEmailId(String emailId) {
            this.emailId = emailId;
        }

        public String getGender() {
            return gender;
        }

        public void setGender(String gender) {
            this.gender = gender;
        }

        public String getCasteCategory() {
            return casteCategory;
        }

        public void setCasteCategory(String casteCategory) {
            this.casteCategory = casteCategory;
        }

        public String getAddress() {
            return address;
        }

        public void setAddress(String address) {
            this.address = address;
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

        public String getLastSem() {
            return lastSem;
        }

        public void setLastSem(String lastSem) {
            this.lastSem = lastSem;
        }

        public String getLastExamName() {
            return lastExamName;
        }

        public void setLastExamName(String lastExamName) {
            this.lastExamName = lastExamName;
        }

        public String getLastExamMonth() {
            return lastExamMonth;
        }

        public void setLastExamMonth(String lastExamMonth) {
            this.lastExamMonth = lastExamMonth;
        }

        public String getLastExamYear() {
            return lastExamYear;
        }

        public void setLastExamYear(String lastExamYear) {
            this.lastExamYear = lastExamYear;
        }

        public String getLastSeatNo() {
            return lastSeatNo;
        }

        public void setLastSeatNo(String lastSeatNo) {
            this.lastSeatNo = lastSeatNo;
        }

        public String getLastResult() {
            return lastResult;
        }

        public void setLastResult(String lastResult) {
            this.lastResult = lastResult;
        }

        public String getLastCgpa() {
            return lastCgpa;
        }

        public void setLastCgpa(String lastCgpa) {
            this.lastCgpa = lastCgpa;
        }

        public String getLastGrade() {
            return lastGrade;
        }

        public void setLastGrade(String lastGrade) {
            this.lastGrade = lastGrade;
        }

        public String getNewCourse() {
            return newCourse;
        }

        public void setNewCourse(String newCourse) {
            this.newCourse = newCourse;
        }

        public String getCollegeName() {
            return collegeName;
        }

        public void setCollegeName(String collegeName) {
            this.collegeName = collegeName;
        }

        public String getUniversityName() {
            return universityName;
        }

        public void setUniversityName(String universityName) {
            this.universityName = universityName;
        }

        public String getAdmissionType() {
            return admissionType;
        }

        public void setAdmissionType(String admissionType) {
            this.admissionType = admissionType;
        }

        public String getLatestMarksheet() {
            return latestMarksheet;
        }

        public void setLatestMarksheet(String latestMarksheet) {
            this.latestMarksheet = latestMarksheet;
        }

        public String getPassingCertificate() {
            return passingCertificate;
        }

        public void setPassingCertificate(String passingCertificate) {
            this.passingCertificate = passingCertificate;
        }

        public String getProofOfAdmission() {
            return proofOfAdmission;
        }

        public void setProofOfAdmission(String proofOfAdmission) {
            this.proofOfAdmission = proofOfAdmission;
        }

        public String getBirthDateProof() {
            return birthDateProof;
        }

        public void setBirthDateProof(String birthDateProof) {
            this.birthDateProof = birthDateProof;
        }

        public String getIdentityProof() {
            return identityProof;
        }

        public void setIdentityProof(String identityProof) {
            this.identityProof = identityProof;
        }

        public Integer getAccountApproval() {
            return accountApproval;
        }

        public void setAccountApproval(Integer accountApproval) {
            this.accountApproval = accountApproval;
        }

        public Integer getLibraryApproval() {
            return libraryApproval;
        }

        public void setLibraryApproval(Integer libraryApproval) {
            this.libraryApproval = libraryApproval;
        }

        public Integer getScholarshipApproval() {
            return scholarshipApproval;
        }

        public void setScholarshipApproval(Integer scholarshipApproval) {
            this.scholarshipApproval = scholarshipApproval;
        }

        public Integer getAdminApproval() {
            return adminApproval;
        }

        public void setAdminApproval(Integer adminApproval) {
            this.adminApproval = adminApproval;
        }

        public Date getPaymentDate() {
            return paymentDate;
        }

        public void setPaymentDate(Date paymentDate) {
            this.paymentDate = paymentDate;
        }

        public String getPaymentId() {
            return paymentId;
        }

        public void setPaymentId(String paymentId) {
            this.paymentId = paymentId;
        }

        public String getPaymentStatus() {
            return paymentStatus;
        }

        public void setPaymentStatus(String paymentStatus) {
            this.paymentStatus = paymentStatus;
        }

        public Double getApplicationFee() {
            return applicationFee;
        }

        public void setApplicationFee(Double applicationFee) {
            this.applicationFee = applicationFee;
        }

        public Double getProcessingFee() {
            return processingFee;
        }

        public void setProcessingFee(Double processingFee) {
            this.processingFee = processingFee;
        }

        public Double getTotalFee() {
            return totalFee;
        }

        public void setTotalFee(Double totalFee) {
            this.totalFee = totalFee;
        }



		@Override
		public String toString() {
			return "TCEntity [id=" + id + ", studentId=" + studentId + ", certificateType=" + certificateType
					+ ", tcType=" + tcType + ", certificateReason=" + certificateReason + ", firstName=" + firstName
					+ ", middleName=" + middleName + ", lastName=" + lastName + ", contactNo=" + contactNo
					+ ", alternateNo=" + alternateNo + ", dob=" + dob + ", dobInWords=" + dobInWords + ", emailId="
					+ emailId + ", gender=" + gender + ", casteCategory=" + casteCategory + ", address=" + address
					+ ", department=" + department + ", course=" + course + ", lastSem=" + lastSem + ", lastClass="
					+ lastClass + ", lastExamName=" + lastExamName + ", lastExamMonth=" + lastExamMonth
					+ ", lastExamYear=" + lastExamYear + ", lastSeatNo=" + lastSeatNo + ", lastResult=" + lastResult
					+ ", lastCgpa=" + lastCgpa + ", lastGrade=" + lastGrade + ", newCourse=" + newCourse
					+ ", collegeName=" + collegeName + ", universityName=" + universityName + ", admissionType="
					+ admissionType + ", latestMarksheet=" + latestMarksheet + ", passingCertificate="
					+ passingCertificate + ", proofOfAdmission=" + proofOfAdmission + ", birthDateProof="
					+ birthDateProof + ", identityProof=" + identityProof + ", accountApproval=" + accountApproval
					+ ", libraryApproval=" + libraryApproval + ", scholarshipApproval=" + scholarshipApproval
					+ ", adminApproval=" + adminApproval + ", paymentDate=" + paymentDate + ", paymentId=" + paymentId
					+ ", paymentStatus=" + paymentStatus + ", applicationFee=" + applicationFee + ", processingFee="
					+ processingFee + ", totalFee=" + totalFee + ", applicationDate=" + applicationDate + "]";
		}
        
        



        





}