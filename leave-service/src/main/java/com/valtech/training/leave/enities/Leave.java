package com.valtech.training.leave.enities;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

import com.valtech.training.leave.common.LeaveStatus;
import com.valtech.training.leave.commons.LeaveType;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
@Entity
public class Leave {
	
	
	
	@Id@GeneratedValue(strategy=GenerationType.SEQUENCE,generator = "leave_sq")
	@SequenceGenerator(allocationSize = 1,name = "leave_seq",sequenceName = "leave_seq")
	private long id;
	private LocalDate fromDate;
	private LocalDate toDate;
	@Enumerated(EnumType.STRING)
	private LeaveType leaveType;
	@Enumerated(EnumType.STRING)
	private LeaveStatus leaveStatus;
	private String reason;
	private String comments;
	private long employeeId;
	
	public Leave() {
		
	}

	public Leave(long id, LocalDate fromDate, LocalDate toDate, LeaveType leaveType, LeaveStatus leaveStatus,
			String reason, String comments, long employyeId) {
		super();
		this.id = id;
		this.fromDate = fromDate;
		this.toDate = toDate;
		this.leaveType = leaveType;
		this.leaveStatus = leaveStatus;
		this.reason = reason;
		this.comments = comments;
		this.employeeId = employyeId;
	}
	
	public long leavesInDays() {
		return ChronoUnit.DAYS.between(fromDate, toDate);
	}
	
	public void checkLeaveApplicationAndUpdateStatus(LeaveMaster lm) {
		if(leaveType==LeaveType.CASUAL) {
			if(lm.getCasualLeaves()==0) {
				rejectLeave("Casual leaves Exhausted");
			}else {
				long days=ChronoUnit.DAYS.between(fromDate, toDate);
				if(days>lm.getCasualLeaves()) {
					comments="Available leave is "+lm.getCasualLeaves()+" Applied is "+days+".";
					
				}else {
					comments="Good to go.";
					//check if from date is more than today
				}
				
			}
				
		}else if(leaveType==LeaveType.OTHERS) {
			if(lm.getOtherLeaves()==0) {
				rejectLeave("Casual leaves Exhausted");
			}else {
				long days=this.leavesInDays();
				if(days>lm.getOtherLeaves()) {
					comments="Available leave is "+lm.getOtherLeaves()+" Applied is "+days+".";
					
				}else {
					
					LocalDate today=LocalDate.now();
					if(fromDate.isBefore(today)&&toDate.isBefore(today))
					 {
						
					
					comments="Good to go.";}else {
						
					}
					//check if from date is more than today
					
				}
				
			}
				
		}else if(leaveType==LeaveType.SICK) {
			if(lm.getSickLeaves()==0) {
				rejectLeave("Casual leaves Exhausted");
			}else {
				long days=ChronoUnit.DAYS.between(fromDate, toDate);
				if(days>lm.getSickLeaves()) {
					comments="Available leave is "+lm.getSickLeaves()+" Applied is "+days+".";
					
				}else {
					comments="Good to go.";
					//check if from date is more than today
				}
				
			}
				
		}
		
	}
	
	

	private void rejectLeave(String comment) {
		leaveStatus=LeaveStatus.REJECTED;
		
		
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public LocalDate getFromDate() {
		return fromDate;
	}

	public void setFromDate(LocalDate fromDate) {
		this.fromDate = fromDate;
	}

	public LocalDate getToDate() {
		return toDate;
	}

	public void setToDate(LocalDate toDate) {
		this.toDate = toDate;
	}

	public LeaveType getLeaveType() {
		return leaveType;
	}

	public void setLeaveType(LeaveType leaveType) {
		this.leaveType = leaveType;
	}

	public LeaveStatus getLeaveStatus() {
		return leaveStatus;
	}

	public void setLeaveStatus(LeaveStatus leaveStatus) {
		this.leaveStatus = leaveStatus;
	}

	public String getReason() {
		return reason;
	}

	public void setReason(String reason) {
		this.reason = reason;
	}

	public String getComments() {
		return comments;
	}

	public void setComments(String comments) {
		this.comments = comments;
	}



	public long getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(long employeeId) {
		this.employeeId = employeeId;
	}

	public void approveLeave(LeaveMaster lm, long manager) {
		
		leaveStatus=LeaveStatus.APPROVED;
		if(comments==null) comments="";
			
			comments+="Your leave has been approved";
		
	}

	public void updateLeave(String comment) {
	
		comments+=comment;
		
	}

	
	
	

}
