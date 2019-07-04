package com.training.project.repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import com.training.project.entity.User;

@Repository
public class UserRepositoryImpl implements UserRepositoryCustom{

	@PersistenceContext
	EntityManager entityManager;

	@Override
	public User findByUserId(Long Id) {
		System.out.println("findByUserId");
		Query query = entityManager.createNativeQuery("select u.id,u.about,u.cakes,u.colour,u.mobile,u.date_of_birth,u.name,u.password,u.month,u.date from users u where u.id = :id",User.class);
		query.setParameter("id", Id);
		User user = (User) query.getSingleResult();
		return user;
	}

	@Override
	public User findByNameAndPassword(String name,String password) {
		System.out.println("findByNameAndPassword");
		Query query = entityManager.createNativeQuery("select u.id,u.about,u.cakes,u.colour,u.mobile,u.date_of_birth,u.name,u.password,u.month,u.date from users u where u.password = :password and u.name = :name",User.class);
		query.setParameter("name", name);
		query.setParameter("password", password);
		User user=null;
		try{
		user = (User) query.getSingleResult();
		}
		catch(Exception e){
			e.printStackTrace();
		}
		return user;
	}
}
