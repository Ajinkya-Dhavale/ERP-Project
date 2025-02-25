package com.erp.student.entity;

import com.erp.admin.entity.Admission;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "personal_details")
public class PersonalDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "student_id")
    private String studentId;

    @Column(name = "mobile")
    private String mobile;
    
    @Column(name = "parent_mobile")
    private String parentMobile;
    
    private String gender;
    
    private String dob;
    

    @Column(name = "place_of_birth")
    private String placeOfBirth;
    
    @Column(name = "blood_group")
    private String bloodGroup;
    
    @Column(name = "maritalStatus")
    private String maritalStatus;

    @Column(name = "mother_tongue")
    private String motherTongue;

    private String occupation;

    @Column(name = "father_name")
    private String fatherName;

    @Column(name = "mother_name")
    private String motherName;

    @Column(name = "mother_occupation")
    private String motherOccupation;

    @Column(name = "father_occupation")
    private String fatherOccupation;
    
    private String caste;

    @Column(name = "sub_caste")
    private String subCaste;
    
    private String nationality;
    
    private String religion;
    
    private String handicap;

    @Column(name = "handicap_percentage")
    private String handicapPercentage;

    @Column(name = "pan_number")
    private String panNumber;

    @Column(name = "family_income")
    private String familyIncome;

    @Column(name = "abc_number")
    private String abcNumber;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getStudentId() {
		return studentId;
	}

	public void setStudentId(String student_id) {
		this.studentId = student_id;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public String getParentMobile() {
		return parentMobile;
	}

	public void setParentMobile(String parentMobile) {
		this.parentMobile = parentMobile;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getDob() {
		return dob;
	}

	public void setDob(String dob) {
		this.dob = dob;
	}

	public String getPlaceOfBirth() {
		return placeOfBirth;
	}

	public void setPlaceOfBirth(String placeOfBirth) {
		this.placeOfBirth = placeOfBirth;
	}

	public String getBloodGroup() {
		return bloodGroup;
	}

	public void setBloodGroup(String bloodGroup) {
		this.bloodGroup = bloodGroup;
	}

	public String getMaritalStatus() {
		return maritalStatus;
	}

	public void setMaritalStatus(String maritalStatus) {
		this.maritalStatus = maritalStatus;
	}

	public String getMotherTongue() {
		return motherTongue;
	}

	public void setMotherTongue(String motherTongue) {
		this.motherTongue = motherTongue;
	}

	public String getOccupation() {
		return occupation;
	}

	public void setOccupation(String occupation) {
		this.occupation = occupation;
	}

	public String getFatherName() {
		return fatherName;
	}

	public void setFatherName(String fatherName) {
		this.fatherName = fatherName;
	}

	public String getMotherName() {
		return motherName;
	}

	public void setMotherName(String motherName) {
		this.motherName = motherName;
	}

	public String getMotherOccupation() {
		return motherOccupation;
	}

	public void setMotherOccupation(String motherOccupation) {
		this.motherOccupation = motherOccupation;
	}

	public String getFatherOccupation() {
		return fatherOccupation;
	}

	public void setFatherOccupation(String fatherOccupation) {
		this.fatherOccupation = fatherOccupation;
	}

	public String getCaste() {
		return caste;
	}

	public void setCaste(String caste) {
		this.caste = caste;
	}

	public String getSubCaste() {
		return subCaste;
	}

	public void setSubCaste(String subCaste) {
		this.subCaste = subCaste;
	}

	public String getNationality() {
		return nationality;
	}

	public void setNationality(String nationality) {
		this.nationality = nationality;
	}

	public String getReligion() {
		return religion;
	}

	public void setReligion(String religion) {
		this.religion = religion;
	}

	public String getHandicap() {
		return handicap;
	}

	public void setHandicap(String handicap) {
		this.handicap = handicap;
	}

	public String getHandicapPercentage() {
		return handicapPercentage;
	}

	public void setHandicapPercentage(String handicapPercentage) {
		this.handicapPercentage = handicapPercentage;
	}

	public String getPanNumber() {
		return panNumber;
	}

	public void setPanNumber(String panNumber) {
		this.panNumber = panNumber;
	}

	public String getFamilyIncome() {
		return familyIncome;
	}

	public void setFamilyIncome(String familyIncome) {
		this.familyIncome = familyIncome;
	}

	public String getAbcNumber() {
		return abcNumber;
	}

	public void setAbcNumber(String abcNumber) {
		this.abcNumber = abcNumber;
	}

	@Override
	public String toString() {
		return "PersonalDetails [id=" + id + ", student id =" + studentId + ", mobile=" + mobile + ", parentMobile="
				+ parentMobile + ", gender=" + gender + ", dob=" + dob + ", placeOfBirth=" + placeOfBirth
				+ ", bloodGroup=" + bloodGroup + ", maritalStatus=" + maritalStatus + ", motherTongue=" + motherTongue
				+ ", occupation=" + occupation + ", fatherName=" + fatherName + ", motherName=" + motherName
				+ ", motherOccupation=" + motherOccupation + ", fatherOccupation=" + fatherOccupation + ", caste="
				+ caste + ", subCaste=" + subCaste + ", nationality=" + nationality + ", religion=" + religion
				+ ", handicap=" + handicap + ", handicapPercentage=" + handicapPercentage + ", panNumber=" + panNumber
				+ ", familyIncome=" + familyIncome + ", abcNumber=" + abcNumber + "]";
	}
    
    
}
