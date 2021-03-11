package com.adinfi.admaster.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.adinfi.admaster.domain.User;

public interface UserRepository extends JpaRepository<User, Long> {
    User findByUsername(String username);
}
