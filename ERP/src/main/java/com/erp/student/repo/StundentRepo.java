package com.erp.student.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.erp.admin.entity.Admission;

import java.util.List;

@Repository
public interface StundentRepo extends JpaRepository<Admission, Long> {
    Admission findByAdmissionIdAndPassword(String admissionId, String password);
}
