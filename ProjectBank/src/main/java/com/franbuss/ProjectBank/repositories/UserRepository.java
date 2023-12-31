package com.franbuss.ProjectBank.repositories;

import com.franbuss.ProjectBank.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    Optional<User> findByEmail(String email);

    Optional<User> findByDni(String dni);


    @Query("SELECT u FROM User u WHERE u.offices.id = :officeId")
    List<User> findUsersByOfficeId(@Param("officeId") Long id);

}
