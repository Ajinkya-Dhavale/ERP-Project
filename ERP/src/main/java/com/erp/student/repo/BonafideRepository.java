package com.erp.student.repo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.erp.student.entity.BonafideEntity;
import java.util.List;


@Repository
public interface BonafideRepository extends JpaRepository<BonafideEntity, Long> {
	List<BonafideEntity> findByStudentId(String studentId);
	
	List<BonafideEntity> findByAdminApproval(Integer adminApproval);
}
