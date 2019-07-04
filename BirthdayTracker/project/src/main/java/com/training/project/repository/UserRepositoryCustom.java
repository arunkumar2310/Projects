package com.training.project.repository;

import com.training.project.entity.User;

public interface UserRepositoryCustom {
	
	User findByNameAndPassword(String name,String password);

	User findByUserId(Long Id);
}
