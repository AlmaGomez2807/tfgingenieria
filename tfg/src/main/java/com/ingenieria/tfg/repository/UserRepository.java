package com.ingenieria.tfg.repository;

import org.springframework.stereotype.Repository;

import com.ingenieria.tfg.entity.User;

import org.springframework.data.jpa.repository.JpaRepository;

@Repository
public interface UserRepository extends JpaRepository<User, String>{
    User findByUsername(String username);
}


