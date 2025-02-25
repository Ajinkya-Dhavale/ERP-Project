package com.erp.student.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "student_address")
public class StudentAddress {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "student_id")
    private String studentId;

    // Permanent Address Fields
    @Column(name = "permanent_country")
    private String permanentCountry;

    @Column(name = "permanent_state")
    private String permanentState;

    @Column(name = "permanent_district")
    private String permanentDistrict;

    @Column(name = "permanent_city")
    private String permanentCity;

    @Column(name = "permanent_taluka")
    private String permanentTaluka;

    @Column(name = "permanent_pincode")
    private String permanentPincode;

    @Column(name = "permanent_address")
    private String permanentAddress;

    // Temporary Address Fields
    @Column(name = "temporary_country")
    private String temporaryCountry;

    @Column(name = "temporary_state")
    private String temporaryState;

    @Column(name = "temporary_district")
    private String temporaryDistrict;

    @Column(name = "temporary_city")
    private String temporaryCity;

    @Column(name = "temporary_taluka")
    private String temporaryTaluka;

    @Column(name = "temporary_pincode")
    private String temporaryPincode;

    @Column(name = "temporary_address")
    private String temporaryAddress;

    @Column(name = "same_as_permanent")
    private Boolean sameAsPermanent;

    // Getters and Setters

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

    public String getPermanentCountry() {
        return permanentCountry;
    }

    public void setPermanentCountry(String permanentCountry) {
        this.permanentCountry = permanentCountry;
    }

    public String getPermanentState() {
        return permanentState;
    }

    public void setPermanentState(String permanentState) {
        this.permanentState = permanentState;
    }

    public String getPermanentDistrict() {
        return permanentDistrict;
    }

    public void setPermanentDistrict(String permanentDistrict) {
        this.permanentDistrict = permanentDistrict;
    }

    public String getPermanentCity() {
        return permanentCity;
    }

    public void setPermanentCity(String permanentCity) {
        this.permanentCity = permanentCity;
    }

    public String getPermanentTaluka() {
        return permanentTaluka;
    }

    public void setPermanentTaluka(String permanentTaluka) {
        this.permanentTaluka = permanentTaluka;
    }

    public String getPermanentPincode() {
        return permanentPincode;
    }

    public void setPermanentPincode(String permanentPincode) {
        this.permanentPincode = permanentPincode;
    }

    public String getPermanentAddress() {
        return permanentAddress;
    }

    public void setPermanentAddress(String permanentAddress) {
        this.permanentAddress = permanentAddress;
    }

    public String getTemporaryCountry() {
        return temporaryCountry;
    }

    public void setTemporaryCountry(String temporaryCountry) {
        this.temporaryCountry = temporaryCountry;
    }

    public String getTemporaryState() {
        return temporaryState;
    }

    public void setTemporaryState(String temporaryState) {
        this.temporaryState = temporaryState;
    }

    public String getTemporaryDistrict() {
        return temporaryDistrict;
    }

    public void setTemporaryDistrict(String temporaryDistrict) {
        this.temporaryDistrict = temporaryDistrict;
    }

    public String getTemporaryCity() {
        return temporaryCity;
    }

    public void setTemporaryCity(String temporaryCity) {
        this.temporaryCity = temporaryCity;
    }

    public String getTemporaryTaluka() {
        return temporaryTaluka;
    }

    public void setTemporaryTaluka(String temporaryTaluka) {
        this.temporaryTaluka = temporaryTaluka;
    }

    public String getTemporaryPincode() {
        return temporaryPincode;
    }

    public void setTemporaryPincode(String temporaryPincode) {
        this.temporaryPincode = temporaryPincode;
    }

    public String getTemporaryAddress() {
        return temporaryAddress;
    }

    public void setTemporaryAddress(String temporaryAddress) {
        this.temporaryAddress = temporaryAddress;
    }

    public Boolean getSameAsPermanent() {
        return sameAsPermanent;
    }

    public void setSameAsPermanent(Boolean sameAsPermanent) {
        this.sameAsPermanent = sameAsPermanent;
    }

	@Override
	public String toString() {
		return "StudentAddress [id=" + id + ", studentId=" + studentId + ", permanentCountry=" + permanentCountry
				+ ", permanentState=" + permanentState + ", permanentDistrict=" + permanentDistrict + ", permanentCity="
				+ permanentCity + ", permanentTaluka=" + permanentTaluka + ", permanentPincode=" + permanentPincode
				+ ", permanentAddress=" + permanentAddress + ", temporaryCountry=" + temporaryCountry
				+ ", temporaryState=" + temporaryState + ", temporaryDistrict=" + temporaryDistrict + ", temporaryCity="
				+ temporaryCity + ", temporaryTaluka=" + temporaryTaluka + ", temporaryPincode=" + temporaryPincode
				+ ", temporaryAddress=" + temporaryAddress + ", sameAsPermanent=" + sameAsPermanent + "]";
	}
    
    
}
