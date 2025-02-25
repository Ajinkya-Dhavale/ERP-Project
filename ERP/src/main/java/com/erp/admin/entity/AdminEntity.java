package com.erp.admin.entity;

import jakarta.persistence.*;

@Entity
@Table(name="admins")
public class AdminEntity {
	 	@Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY) 
	    private Long adminId;

	    @Column(nullable = false, unique = true)  
	    private String username;

	    @Column(nullable = false)
	    private String password;

	    @Column(nullable = false)
	    private String role;

		public Long getAdminId() {
			return adminId;
		}

		public void setAdminId(Long adminId) {
			this.adminId = adminId;
		}

		public String getUsername() {
			return username;
		}

		public void setUsername(String username) {
			this.username = username;
		}

		public String getPassword() {
			return password;
		}

		public void setPassword(String password) {
			this.password = password;
		}

		public String getRole() {
			return role;
		}

		public void setRole(String role) {
			this.role = role;
		}

		@Override
		public String toString() {
			return "AdminEntity [adminId=" + adminId + ", username=" + username + ", password=" + password + ", role="
					+ role + ", getAdminId()=" + getAdminId() + ", getUsername()=" + getUsername() + ", getPassword()="
					+ getPassword() + ", getRole()=" + getRole() + ", getClass()=" + getClass() + ", hashCode()="
					+ hashCode() + ", toString()=" + super.toString() + "]";
		}
	    
	    
}
