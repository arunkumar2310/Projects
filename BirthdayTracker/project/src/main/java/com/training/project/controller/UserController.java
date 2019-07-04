package com.training.project.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.training.project.Application;
import com.training.project.entity.User;
import com.training.project.entity.Wish;
import com.training.project.service.UserService;

@Controller
public class UserController {

	public static Logger logger=LoggerFactory.getLogger(Application.class);

	@Autowired
	private UserService userService;


	@RequestMapping(value="/login")
	public String userLogin(){
		logger.info("redirected to first page");
		return "firstPage.html";
	}

	@RequestMapping(value="/login2")
	public String userLogin2(){
		logger.info("redirected to second page");
		return "secondPage.html";
	}

	@RequestMapping(value ="/save", method=RequestMethod.POST)
	public @ResponseBody User userDetails(@RequestBody User user) {
		userService.save(user);
		logger.info("user datas are saved successfully");
		return user;
	}

	@RequestMapping(value="/retriveByNameAndPassword/{name}/{password}",method =RequestMethod.POST)
	@ResponseBody
	public User retriveUsingNameAndPassword(@PathVariable("name") String name,@PathVariable("password") String password){
		logger.info("checks the username and password with the database");
		User user=userService.retriveUsingNameAndPassword(name,password);
		return user;
	}

	@RequestMapping(value="/retriveWish/{Id}", method = RequestMethod.GET)
	@ResponseBody
	public List<Wish> retriveUserDetails(@PathVariable("Id") String Id){
		logger.info("wishes are retrieved from the database");
		List<Wish> wish= userService.retrive(Id);
		return wish;
	}

	@RequestMapping(value="/dateOfBirth",method =RequestMethod.GET)
	@ResponseBody
	public List<User> getDateOfBirth(){
		logger.info("upcoming birthdays are fetched form database");
		List<User> user=userService.getDateOfBirth();
		return user;
	}

	@RequestMapping(value="/updateWish",method= RequestMethod.POST)
	@ResponseBody
	public String updateWish(@RequestBody Wish wish){
		logger.info("wish updated successfully");
		System.out.println(wish);
		userService.saveWish(wish);
		String response="Wish sent successfully!!!";
		return response;
	}
	@RequestMapping(value="/retriveById/{Id}",method =RequestMethod.POST)
	@ResponseBody
	public User retriveById(@PathVariable("Id") Long Id){
		logger.info("user datas are retrived by id successfully");
		User user=userService.retriveByUserId(Id);
		return user;
	}

}
