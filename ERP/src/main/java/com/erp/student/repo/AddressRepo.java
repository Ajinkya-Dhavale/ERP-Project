package com.erp.student.repo;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.erp.student.entity.StudentAddress;
import java.util.List;

@Repository
public interface AddressRepo extends JpaRepository<StudentAddress, Long>{
	Optional<StudentAddress> findByStudentId(String studentId);
}
