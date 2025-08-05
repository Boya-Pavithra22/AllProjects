package com.wipro.springboot.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.wipro.springboot.model.RegistrationUser;

@Repository
public interface RegistrationUserRepository extends JpaRepository<RegistrationUser, Long> {
}
