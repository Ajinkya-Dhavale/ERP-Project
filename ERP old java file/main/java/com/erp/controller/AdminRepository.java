package com.erp.controller;

import org.springframework.data.jpa.repository.JpaRepository;

import com.erp.entity.AdminEntity;

public interface AdminRepository extends JpaRepository<AdminEntity, Long> {
	AdminEntity findByUsername(String username);
}
