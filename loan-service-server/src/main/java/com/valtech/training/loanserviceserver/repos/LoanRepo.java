package com.valtech.training.loanserviceserver.repos;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.valtech.training.loanserviceserver.entities.Loan;

@Repository
public interface LoanRepo extends JpaRepository<Loan, Long>{

}
