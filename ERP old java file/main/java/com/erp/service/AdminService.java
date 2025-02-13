package com.erp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.erp.controller.AdminRepository;
import com.erp.entity.AdminEntity;

@Service
public class AdminService {

    @Autowired
    private AdminRepository adminRepository;
    
    public AdminEntity validateAdmin(String username, String password) {
    	
        AdminEntity admin = adminRepository.findByUsername(username);

        if (admin != null && admin.getPassword().equals(password)) {
            return admin; 
        }

        return null;
    }
}
