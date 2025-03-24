package com.valtech.training.leave.vos;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.stream.Collectors;

import com.valtech.training.leave.common.LeaveStatus;
import com.valtech.training.leave.commons.LeaveType;
import com.valtech.training.leave.enities.Leave;

public record LeaveVO (long id,String from_date,String to_date,
		String type, String status,String reason,String comments,long empId){
	
	public static DateTimeFormatter formatter=DateTimeFormatter.ofPattern("dd-MM-yyyy");
	
	public Leave to() {
		
		LocalDate from=LocalDate.parse(from_date,formatter);
		LocalDate to=LocalDate.parse(to_date,formatter);
		LeaveType ltype=LeaveType.valueOf(type);
		LeaveStatus lstatus=LeaveStatus.valueOf(status);
		return new Leave(id, from, to, ltype, lstatus, reason, comments, empId);
	}

	public static LeaveVO from(Leave leave) {
		String from=leave.getFromDate().format(formatter);
		String to=leave.getToDate().format(formatter);
		String ltype=leave.getLeaveType().name();
		String lstatus=leave.getLeaveStatus().name();
		return new LeaveVO(leave.getId(), from, to, ltype, lstatus,
				ltype, leave.getComments(), leave.getEmployeeId());
	}
	public static List<LeaveVO> to(List<Leave> leaves){
	return leaves.stream().map(e->LeaveVO.from(e)).collect(Collectors.toList());
	}
	
	public void updateTo(Leave leave) {
		LocalDate from =LocalDate.parse(from_date,formatter);
		LocalDate to =LocalDate.parse(to_date,formatter);
		LeaveType leaveType=LeaveType.valueOf(type);
		LeaveStatus leaveStatus=LeaveStatus.valueOf(status);
		leave.setFromDate(from);
		leave.setToDate(to);
		leave.setComments(comments);
		leave.setReason(reason);
		leave.setLeaveStatus(leaveStatus);
		leave.setLeaveType(leaveType);
	}
}
