package com.valtech.training.leave.repos;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.valtech.training.leave.enities.Leave;
import com.valtech.training.leave.vos.LeaveVO;



public interface LeaveRepo extends JpaRepository<Leave, Long>{

	List<Leave> findAllByEmployeeId(long id);

}
