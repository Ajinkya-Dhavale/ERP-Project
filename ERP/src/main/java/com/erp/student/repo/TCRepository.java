package com.erp.student.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.erp.student.entity.TCEntity;
import java.util.List;
import java.util.Optional;


public interface TCRepository extends JpaRepository<TCEntity, Long> {
	Optional<TCEntity> findByStudentIdAndTcTypeAndCertificateType(String studentId,String tcType,String certificateType);

	List<TCEntity> findByStudentId(String studentId);
	
	Optional<TCEntity> findById(Long id);


	List<TCEntity> findByAccountApproval(Integer accountApproval);
	
	List<TCEntity> findByLibraryApproval(Integer libraryApproval);
	
	List<TCEntity> findByScholarshipApproval(Integer scholarshipApproval);
	
	List<TCEntity> findByAdminApproval(Integer adminApproval);
}

