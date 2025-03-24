package com.valtech.training.leave.enities;

import com.valtech.training.leave.commons.LeaveType;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
@Entity
public class LeaveMaster {
	@Id@GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "lm_seq")
	@SequenceGenerator(name = "lm_seq",allocationSize = 1,sequenceName = "lm_seq")
	private long id;
	
	private int casualLeaves;
	private int sickLeaves;
	private int otherLeaves;
	private long employeeId;
	
	public LeaveMaster() {
	}
	public LeaveMaster(int casualLeaves, int sickLeaves, int otherLeaves,long empId) {
		super();
		this.casualLeaves = casualLeaves;
		this.sickLeaves = sickLeaves;
		this.otherLeaves = otherLeaves;
		this.employeeId=empId;
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public int getCasualLeaves() {
		return casualLeaves;
	}
	public void setCasualLeaves(int casualLeaves) {
		this.casualLeaves = casualLeaves;
	}
	public int getSickLeaves() {
		return sickLeaves;
	}
	public void setSickLeaves(int sickLeaves) {
		this.sickLeaves = sickLeaves;
	}
	public int getOtherLeaves() {
		return otherLeaves;
	}
	public void setOtherLeaves(int otherLeaves) {
		this.otherLeaves = otherLeaves;
	}
	public long getEmployeeId() {
		return employeeId;
	}
	public void setEmployeeId(long employeeId) {
		this.employeeId = employeeId;
	}
	public void takeLeaves(Leave leave) {
		if(leave.getLeaveType()==LeaveType.CASUAL) {
			casualLeaves+=leave.leavesInDays();
		}else if(leave.getLeaveType()==LeaveType.SICK) {
			sickLeaves+=leave.leavesInDays();
		}else if(leave.getLeaveType()==LeaveType.OTHERS) {
			otherLeaves+=leave.leavesInDays();
		}
		
	}
	
	
	

}
