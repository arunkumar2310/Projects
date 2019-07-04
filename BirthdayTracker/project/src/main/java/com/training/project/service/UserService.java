package com.training.project.service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import com.training.project.Application;
import com.training.project.entity.User;
import com.training.project.entity.Wish;
import com.training.project.repository.UserRepository;
import com.training.project.repository.WishRepository;

@Service
public class UserService {
	
	public static Logger logger=LoggerFactory.getLogger(Application.class);

	@Autowired(required = true)
	private UserRepository userRepository;

	@Autowired(required = true)
	private WishRepository wishRepository;
    
	public void save(User user) {
		logger.info("user details saved in DB");
		userRepository.save(user);
	}
	
	@Cacheable(value="allWishCache")
	public List<Wish> retrive(String Id) {
		logger.info("Hits DB to retrieve wish");
		List<Wish> wish=new ArrayList<Wish>();
		wish=wishRepository.findAllByWishedToUserId(Id);
		return wish;
	}

	@Cacheable(value="userByNameAndPassword" ,key="#password")
	public User retriveUsingNameAndPassword(String name,String password){
		logger.info("Hits DB to check name and password");
		User user=userRepository.findByNameAndPassword(name,password);
		return user;
	}
    
	@Cacheable(value="user", key="#Id")
	public User retriveByUserId(Long Id){
		logger.info("Hits DB to retrieve user details");
		User user1= userRepository.findByUserId(Id);
		return user1;
	}
	
	@Cacheable(value="allUser", unless="#result.size() == 0")
	public List<User> getDateOfBirth() {
		logger.info("Hits DB to get all users");
		List<User> user=userRepository.findAll();
		user.forEach( user1 -> {
			String splittedDateArray[]=user1.getDateOfBirth().split("-");
			String resultDate=splittedDateArray[2]+"-"+splittedDateArray[1]+"-"+splittedDateArray[0];
			user1.setDateOfBirth(resultDate);
		});
		List<User> user2=sort(user);
		return user2;
	}
	private List<User> sort(List<User> user) {
		Collections.sort(user, new Comparator<User>() {
			@Override
			public int compare(User u1, User u2) {
				return u1.getMonth().compareTo(u2.getMonth());
			}
		});
		return user;
	}
	public void saveWish(Wish wish) {
		logger.info("Hits DB to save wish");
		wishRepository.save(wish);
	}
}
