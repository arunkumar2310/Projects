package com.training.project.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.training.project.entity.User;


public interface UserRepository extends JpaRepository<User, Long>,UserRepositoryCustom {
	
}
