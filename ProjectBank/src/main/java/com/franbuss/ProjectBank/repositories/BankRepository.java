package com.franbuss.ProjectBank.repositories;

import com.franbuss.ProjectBank.models.Bank;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface BankRepository extends JpaRepository<Bank, Long> {

    Optional<Bank> findByBankName(String bankName);

}
