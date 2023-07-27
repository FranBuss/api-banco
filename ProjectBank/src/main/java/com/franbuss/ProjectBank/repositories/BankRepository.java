package com.franbuss.ProjectBank.repositories;

import com.franbuss.ProjectBank.models.Bank;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BankRepository extends JpaRepository<Bank, Long> {
}
