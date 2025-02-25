package com.erp.student.repo;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.erp.student.entity.AcademicDetails;

@Repository
public interface AcademicDetailsRepo extends JpaRepository<AcademicDetails, Long>{
	Optional<AcademicDetails> findByStudentId(String studentId);
}
