package com.erp.student.repo;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.erp.student.entity.PersonalDetails;


@Repository
public interface PersonalDetailRepository extends JpaRepository<PersonalDetails, Long> {
    Optional<PersonalDetails> findByStudentId(String studentId);
}