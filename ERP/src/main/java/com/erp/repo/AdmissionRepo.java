package com.erp.repo;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.erp.admin.entity.Admission;

@Repository
public interface AdmissionRepo extends JpaRepository<Admission, Long> {

    boolean existsByAadharNo(String aadharNo);

    @Query("SELECT COALESCE(MAX(a.id), 0) FROM Admission a")
    Long findLastAdmissionId();
    
    Optional<Admission> findByEmail(String email);    
    
    Optional<Admission> findByAdmissionId(String admissionId);
    
    @Query("select count(*) from Admission")
    int totalStudent();
}
