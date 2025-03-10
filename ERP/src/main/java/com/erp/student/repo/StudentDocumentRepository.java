package com.erp.student.repo;

import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import com.erp.student.entity.StudentDocument;

public interface StudentDocumentRepository extends JpaRepository<StudentDocument, Long> {
    Optional<StudentDocument> findByStudentId(String studentId);
}
