package com.valtech.training.leave.vos;

import com.valtech.training.leave.enities.LeaveMaster;

public record LeaveMasterVO(long id,int casualLeaves, int sickLeaves, int otherLeaves,long employeeId) {

	public static LeaveMasterVO from(LeaveMaster lm) {
		
		return new LeaveMasterVO(lm.getId(),lm.getCasualLeaves(), lm.getSickLeaves(), lm.getOtherLeaves(),lm.getEmployeeId());
		

	}
	public LeaveMaster to() {
		
		
		return new LeaveMaster(casualLeaves,sickLeaves,otherLeaves,employeeId);
		
	}
	
	
}
