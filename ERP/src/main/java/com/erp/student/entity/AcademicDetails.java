package com.erp.student.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "academic_details")
public class AcademicDetails {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY) 
	private Long id;
	
	@Column(name = "full_name")
	private String fullName;
	
	private String session;
	
	@Column(name = "admission_year")
	private String admissionYear;
	
	private String department;
	
	private String course;
	
	@Column(name = "student_id")
	private String studentId;
	
	private String medium;
	
	private String section;
	
	@Column(name = "previous_passing_year")
	private String prePassingYear;
	
	@Column(name = "previous_year_percentage")
	private String preYearPercentage;
	
	@Column(name = "previous_college_name")
	private String preCollegeName;

	@Column(name = "previous_course_name")
	private String preCourseName;
	
	
	
	public String getPreCollegeName() {
		return preCollegeName;
	}
	
	public void setPreCollegeName(String preCollegeName) {
		this.preCollegeName = preCollegeName;
	}

	public String getPreCourseName() {
		return preCourseName;
	}

	public void setPreCourseName(String preCourseName) {
		this.preCourseName = preCourseName;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public String getSession() {
		return session;
	}

	public void setSession(String session) {
		this.session = session;
	}

	

	public String getAdmissionYear() {
		return admissionYear;
	}

	public void setAdmissionYear(String admissionYear) {
		this.admissionYear = admissionYear;
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

	public String getStudentId() {
		return studentId;
	}

	public void setStudentId(String studentId) {
		this.studentId = studentId;
	}

	public String getMedium() {
		return medium;
	}

	public void setMedium(String medium) {
		this.medium = medium;
	}

	public String getSection() {
		return section;
	}

	public void setSection(String section) {
		this.section = section;
	}

	public String getPrePassingYear() {
		return prePassingYear;
	}

	public void setPrePassingYear(String prePassingYear) {
		this.prePassingYear = prePassingYear;
	}

	public String getPreYearPercentage() {
		return preYearPercentage;
	}

	public void setPreYearPercentage(String preYearPercentage) {
		this.preYearPercentage = preYearPercentage;
	}

	@Override
	public String toString() {
		return "AcademicDetails [id=" + id + ", fullName=" + fullName + ", session=" + session + ", admissionYear="
				+ admissionYear + ", department=" + department + ", course=" + course + ", studentId=" + studentId
				+ ", medium=" + medium + ", section=" + section + ", prePassingYear=" + prePassingYear
				+ ", preYearPercentage=" + preYearPercentage + ", preCollegeName=" + preCollegeName + ", preCourseName="
				+ preCourseName + "]";
	}

	
}
