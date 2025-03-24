package com.valtech.training.loanserviceserver.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
	public LoanVO  applyLoan(ApplyLoanVO vo)
	{
		LoanVO loanVO=new LoanVO(0,LoanType.HOME , vo.getIncome()*5, vo.getIncome()*15, LoanStatus.APPLIED);

				this.save(loanVO);
				return  loanVO;
	}
	private void save(LoanVO loanVO) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public LoanVO getlLoanVO(long id) {
		return LoanVO.from(loanRepo.getReferenceById(id));
	}
	
	public LoanVO processLoan(ApplyLoanVO vo) {
		LoanVO loanVO= null;
		if(vo.getCibil()>0&&vo.getCibil()<600) {
			loanVO=new LoanVO(0,LoanType.HOME , vo.getIncome()*5, vo.getIncome()*15, LoanStatus.REJECTED);
		return loanVO;	
		}
		else if(vo.getCibil()>700&&vo.getCibil()<900) {
			
			loanVO=new LoanVO(0,LoanType.HOME , vo.getIncome()*5, vo.getIncome()*15, LoanStatus.APPLIED);
			return loanVO;
		}
		return loanVO;
		
	}

}
