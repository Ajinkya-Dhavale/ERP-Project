package com.erp.student.repo;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.erp.student.entity.TCEntity;

@Repository
public interface TCRepository extends JpaRepository<TCEntity, Long> {
	Optional<TCEntity> findByStudentIdAndTcTypeAndCertificateType(String studentId,String tcType,String certificateType);

	List<TCEntity> findByStudentId(String studentId);
	
	Optional<TCEntity> findById(Long id);


	List<TCEntity> findByAccountApproval(Integer accountApproval);
	
	List<TCEntity> findByLibraryApproval(Integer libraryApproval);
	
	List<TCEntity> findByScholarshipApproval(Integer scholarshipApproval);
	
	List<TCEntity> findByAdminApproval(Integer adminApproval);
	
	@Query("SELECT COUNT(t.studentId) FROM TCEntity t WHERE t.adminApproval = 1 AND t.studentId = :studentId")
	int countAdminApproval(@Param("studentId") String studentId);
	
	@Query("SELECT COUNT(t.studentId) FROM TCEntity t WHERE t.adminApproval = 0 AND t.studentId = :studentId")
	int countAdminPending(@Param("studentId") String studentId);
	
	@Query("SELECT COUNT(t.studentId) FROM TCEntity t WHERE t.adminApproval = 2 AND t.studentId = :studentId")
	int countAdminRejected(@Param("studentId") String studentId);
	
	@Query("SELECT COUNT(t.studentId) FROM TCEntity t WHERE t.studentId = :studentId")
	int count(@Param("studentId") String studentId);
	
	
	//admin index dashboard

	@Query("SELECT COUNT(*) FROM TCEntity t WHERE t.tcType=:tcType and t.certificateType=:certificateType")
	int countTCType(@Param("tcType") String tcType,@Param("certificateType") String certificateType);

	@Query("SELECT COUNT(*) FROM TCEntity t WHERE t.adminApproval = :adminApproval and t.certificateType=:certificateType")
	int countTCApproval(@Param("adminApproval") Integer adminApproval,@Param("certificateType") String certificateType);

	
	//other admin dashboard
	long countByAccountApproval(Integer accountApproval);
	long countByScholarshipApproval(Integer scholarshipApproval);
	long countByLibraryApproval(Integer libraryApproval);
}

