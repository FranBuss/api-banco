package com.franbuss.ProjectBank.repositories;

import com.franbuss.ProjectBank.models.SavingsAccount;
import com.franbuss.ProjectBank.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface SavingAccountRepository extends JpaRepository<SavingsAccount, Long> {
    Optional<SavingsAccount> findByCbu(String cbu);
    Optional<SavingsAccount> findByUser(User user);
}
