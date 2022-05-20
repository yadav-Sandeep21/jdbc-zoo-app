package com.ty.zoo.controller;

import com.ty.zoo.dao.UserDao;
import com.ty.zoo.dto.User;

public class TestUser {

	public static void main(String[] args) {
		User user=new User();
		user.setId(1);
		user.setName("Sandeep");
		user.setEmail("san@gmail.com");
		user.setPassword("sandeep");
		user.setRole("Software Engineer");
		user.setPhone("1234567");
		
		UserDao userd=new UserDao();
		userd.saveUser(user);
	}

}
