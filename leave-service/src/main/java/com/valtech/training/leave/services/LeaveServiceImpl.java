package com.valtech.training.leave.services;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.valtech.training.leave.common.LeaveStatus;
import com.valtech.training.leave.enities.Leave;
import com.valtech.training.leave.enities.LeaveMaster;
import com.valtech.training.leave.repos.LeaveMasterRepo;
import com.valtech.training.leave.repos.LeaveRepo;
import com.valtech.training.leave.vos.ApproveLeaveVO;
import com.valtech.training.leave.vos.EmployeeVO;
import com.valtech.training.leave.vos.LeaveMasterVO;
import com.valtech.training.leave.vos.LeaveVO;




@Service
@Transactional(propagation = Propagation.REQUIRED)
public class LeaveServiceImpl implements LeaveService {

	@Autowired
	private LeaveMasterRepo leaveMasterRepo;
	@Autowired
	private LeaveRepo leaveRepo;

	@Autowired
	EmployeeClient employeeClient;

	@Override
	public LeaveVO approveLeave(ApproveLeaveVO appleaveVO) {
		
		Leave  leave=leaveRepo.getReferenceById(appleaveVO.leaveId());
		

		long managerId = employeeClient.getEmployeeAsManager(leave.getEmployeeId()).managerId();
		if (appleaveVO.manager() == managerId) {
			LeaveMaster lm = leaveMasterRepo.findByEmployeeId(leave.getEmployeeId());
			lm.takeLeaves(leave);
			leaveMasterRepo.save(lm);
			leave.approveLeave(lm, managerId);
			leave.updateLeave(appleaveVO.comments());
			

		} else {
			leave.updateLeave("You are not the manager to approve");
		}

		leave = leaveRepo.save(leave);
		return LeaveVO.from(leave);

	}

	@Override
	public LeaveVO applyLeave(LeaveVO vo) {
		Leave l = vo.to();
		l.setLeaveStatus(LeaveStatus.APPLIED);
		l.checkLeaveApplicationAndUpdateStatus(leaveMasterRepo.findByEmployeeId(vo.empId()));
		l = leaveRepo.save(l);
		return LeaveVO.from(l);

	}

	@Override
	public List<LeaveVO> getAllLeaves() {
		return LeaveVO.to(leaveRepo.findAll());
		// stream().map(e->LeaveVO.from(e)).collect(Collectors.toList());

	}

	@Override
	public LeaveVO getLeave(long id) {
		return LeaveVO.from(leaveRepo.getReferenceById(id));

	}

	@Override
	public LeaveVO saveOrUpdate(LeaveVO l) {
		return LeaveVO.from(leaveRepo.save(l.to()));

	}

	@Override
	public List<LeaveVO> getLeavesByEmp(long id) {
		return LeaveVO.to(leaveRepo.findAllByEmployeeId(id));
	}

	@Override
	public LeaveMasterVO saveOrUpdateLeaveMaster(LeaveMasterVO leaveMasterVO) {

		LeaveMaster lm = leaveMasterVO.to();
		lm = leaveMasterRepo.save(lm);
		return LeaveMasterVO.from(lm);

	}

	@Override
	public LeaveMasterVO getLeaveMaster(long id) {
		LeaveMaster lm = leaveMasterRepo.findByEmployeeId(id);
		return LeaveMasterVO.from(lm);
	}

	@Override
	public List<LeaveMasterVO> getAllLeaveMasters() {
		return leaveMasterRepo.findAll().stream().map(lm -> LeaveMasterVO.from(lm)).collect(Collectors.toList());
	}

	@Override
	public LeaveVO update(LeaveVO vo, long id) {

		Leave leave = leaveRepo.getReferenceById(id);
		vo.updateTo(leave);
		leave = leaveRepo.save(leave);
		return LeaveVO.from(leave);

	}



	@Override
	public EmployeeVO getManager(long empId) {
		// TODO Auto-generated method stub
		return employeeClient.getEmployeeAsManager(empId);
	}

}
