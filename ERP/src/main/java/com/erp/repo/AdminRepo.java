package com.erp.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.erp.admin.entity.AdminEntity;
import java.util.List;


@Repository  
public interface AdminRepo extends JpaRepository<AdminEntity, Long> {
    AdminEntity findByUsernameAndPasswordAndRole(String username, String password, String role);

}