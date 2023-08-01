package com.franbuss.ProjectBank.repositories;

import com.franbuss.ProjectBank.models.Offices;
import com.franbuss.ProjectBank.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface OfficesRepository extends JpaRepository<Offices, Long> {

    Optional<Offices> findByAddress(String address);


}
