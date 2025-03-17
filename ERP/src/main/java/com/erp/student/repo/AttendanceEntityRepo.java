package com.erp.student.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.erp.student.entity.AttendanceEntity;
import java.util.List;
import java.util.Optional;


@Repository
public interface AttendanceEntityRepo extends JpaRepository<AttendanceEntity, Long>{
	
	List<AttendanceEntity> findByStudentId(String studentId);
	
	List<AttendanceEntity> findByAdminApproval(Integer adminApproval);
	
	@Query("SELECT COUNT(t.studentId) FROM AttendanceEntity t WHERE t.adminApproval = 1 AND t.studentId = :studentId")
	int countAdminApproval(@Param("studentId") String studentId);
	
	@Query("SELECT COUNT(t.studentId) FROM AttendanceEntity t WHERE t.adminApproval = 0 AND t.studentId = :studentId")
	int countAdminPending(@Param("studentId") String studentId);
	
	@Query("SELECT COUNT(t.studentId) FROM AttendanceEntity t WHERE t.adminApproval = 2 AND t.studentId = :studentId")
	int countAdminRejected(@Param("studentId") String studentId);
	
	@Query("SELECT COUNT(t.studentId) FROM AttendanceEntity t WHERE t.studentId = :studentId")
	int count(@Param("studentId") String studentId);
	
	long countByAdminApproval(Integer adminApproval);
	long count();
	
}
