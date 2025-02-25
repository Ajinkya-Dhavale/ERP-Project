package com.erp.admin.entity;

import jakarta.persistence.*;
import java.text.SimpleDateFormat;
import java.util.Date;

@Entity
@Table(name = "admission")
public class Admission {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "admission_id")
    private Long id;  // Auto-increment ID

	@Column(name = "admission_generated_id")
    private String admissionId;  // Final admission ID (YYYYXXXX format)

    @Column(name = "first_name", nullable = false)
    private String firstName;

    @Column(name = "middle_name")
    private String middleName;

    @Column(name = "last_name", nullable = false)
    private String lastName;

    @Column(name = "aadhar_no", unique = true, nullable = false)
    private String aadharNo;

    @Column(name = "email", unique = true, nullable = false)
    private String email;

    @Column(name = "password", nullable = false)
    private String password = "student"; // Default password

    @Column(name = "flag", nullable = false)
    private int flag = 0;  // Default flag

    @Column(name = "start_date", nullable = false, updatable = false)
    private String startDate=new SimpleDateFormat("yyyy").format(new Date());;  // Current date in "dd-MM-yyyy" format

    // ✅ Default Constructor
    public Admission() {
        this.startDate = new SimpleDateFormat("dd-MM-yyyy").format(new Date()); // Set current date
    }

    // ✅ Parameterized Constructor
    public Admission(String firstName, String middleName, String lastName, String aadharNo, String email) {
        this();
        this.firstName = firstName;
        this.middleName = middleName;
        this.lastName = lastName;
        this.aadharNo = aadharNo;
        this.email = email;
    }

    // ✅ Getters & Setters
    public Long getId() {
        return id;
    }

    public String getAdmissionId() {
        return admissionId;
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

    public String getAadharNo() {
        return aadharNo;
    }

    public void setAadharNo(String aadharNo) {
        this.aadharNo = aadharNo;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getFlag() {
        return flag;
    }

    public void setFlag(int flag) {
        this.flag = flag;
    }

    public String getStartDate() {
        return startDate;
    }
    
    public void setId(Long id) {
		this.id = id;
	}

	public void setAdmissionId(String admissionId) {
		this.admissionId = admissionId;
	}

	public void setStartDate(String startDate) {
		this.startDate = new SimpleDateFormat("yyyy").format(new Date());;
	}

    // ✅ toString Method
    @Override
    public String toString() {
        return "Admission{" +
                "id=" + id +
                ", admissionId='" + admissionId + '\'' +
                ", firstName='" + firstName + '\'' +
                ", middleName='" + middleName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", aadharNo='" + aadharNo + '\'' +
                ", email='" + email + '\'' +
                ", password='******'" +  // Mask password for security
                ", flag=" + flag +
                ", startDate='" + startDate + '\'' +
                '}';
    }
}
