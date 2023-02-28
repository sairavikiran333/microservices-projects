package com.brv.demo;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Component;

@Component
public class UserDaoService {

	public UserDaoService() {
	}

	
	private static List<User> userList = new ArrayList<>();
	
	static {
		userList.add(new User(1,"srk",new Date()));
		userList.add(new User(2,"e4s",new Date()));
		userList.add(new User(3,"vvio",new Date()));
	}
	

	public List<User> findAll(){
		return userList;
	}
}
