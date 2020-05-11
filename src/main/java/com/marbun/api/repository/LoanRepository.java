package com.marbun.api.repository;

import com.marbun.api.entitiy.Loan;
import org.springframework.data.repository.CrudRepository;

public interface LoanRepository extends CrudRepository<Loan,Long> {
}
