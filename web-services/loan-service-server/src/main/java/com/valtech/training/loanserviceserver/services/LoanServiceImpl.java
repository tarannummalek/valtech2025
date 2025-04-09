package com.valtech.training.loanserviceserver.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.valtech.training.loanserviceserver.entities.Loan;
import com.valtech.training.loanserviceserver.entities.LoanStatus;
import com.valtech.training.loanserviceserver.entities.LoanType;
import com.valtech.training.loanserviceserver.repos.LoanRepo;
import com.valtech.training.loanserviceserver.vos.ApplyLoanVO;
import com.valtech.training.loanserviceserver.vos.LoanVO;

@Service
public class LoanServiceImpl implements LoanService {
	
	@Autowired
	private LoanRepo loanRepo;
	@Override
	public LoanVO applyLoan(ApplyLoanVO vo) {
		LoanVO loanVO = processLoan(vo);  // Call processLoan to determine loan status
		if (loanVO != null && loanVO.getLeaveStatus() == LoanStatus.APPLIED) {
			save(loanVO); 
		}
		return loanVO;  
	}
	@Override
	public void save(LoanVO loanVO) {
		Loan loan = new Loan();
		loan.setType(loanVO.getType());
		loan.setValue(loanVO.getValue());
		loan.setAssetValue(loanVO.getAssetValue());
		loan.setStatus(loanVO.getLeaveStatus());

		loanRepo.save(loan);
	}

	@Override
	public LoanVO processLoan(ApplyLoanVO vo) {
		LoanVO loanVO = null;
		if (vo.getCibil() < 600) {
			loanVO = new LoanVO(0, LoanType.HOME, vo.getIncome() * 5, vo.getIncome() * 15, LoanStatus.REJECTED);
		} else if (vo.getCibil() >= 600 && vo.getCibil() < 700) {
			loanVO = new LoanVO(0, LoanType.HOME, vo.getIncome() * 5, vo.getIncome() * 15, LoanStatus.PENDING);
		} else if (vo.getCibil() >= 700) {
			loanVO = new LoanVO(0, LoanType.HOME, vo.getIncome() * 5, vo.getIncome() * 15, LoanStatus.APPLIED);
		}

		return loanVO;
	}

	@Override
	public LoanVO getLoanVO(long id) {
		Loan loan = loanRepo.getReferenceById(id); 
		return LoanVO.from(loan);  
	}
}
