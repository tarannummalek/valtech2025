package com.valtech.training.leave.services;

import java.util.List;

import com.valtech.training.leave.vos.ApproveLeaveVO;
import com.valtech.training.leave.vos.EmployeeVO;
import com.valtech.training.leave.vos.LeaveMasterVO;
import com.valtech.training.leave.vos.LeaveVO;

public interface LeaveService {

	LeaveMasterVO saveOrUpdateLeaveMaster(LeaveMasterVO leaveMasterVO);

	LeaveMasterVO getLeaveMaster(long id);

	List<LeaveMasterVO> getAllLeaveMasters();

	List<LeaveVO> getLeavesByEmp(long id);

	LeaveVO saveOrUpdate(LeaveVO l);

	LeaveVO getLeave(long id);

	List<LeaveVO> getAllLeaves();	

	LeaveVO update(LeaveVO vo, long id);

	LeaveVO applyLeave(LeaveVO vo);

	LeaveVO approveLeave(ApproveLeaveVO appleaveVO);

	EmployeeVO getManager(long empId);

}