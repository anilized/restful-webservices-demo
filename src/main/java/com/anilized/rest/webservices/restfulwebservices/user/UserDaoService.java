package com.anilized.rest.webservices.restfulwebservices.user;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import org.springframework.stereotype.Component;


@Component
public class UserDaoService {

	private static List<User> users = new ArrayList<User>();

	private static int userIdCount = 3;

	static {
		users.add(new User(1, "Anıl", new Date()));
		users.add(new User(2, "Adam", new Date()));
		users.add(new User(3, "Eve", new Date()));
	}

	// return all users

	public List<User> findAll() {
		return users;
	}

	// find one user

	public User findOne(int userId) {
		for (User user : users) {
			if (user.getId() == userId) {
				return user;
			}
		}

		return null;
	}

	// save user

	public User saveUser(User user) {
		if (user.getId() == null) {
			user.setId(userIdCount++);
		}
		users.add(user);
		return user;

	}
	
	public User deleteById(int id) {
		Iterator<User> iterator = users.iterator();
		while(iterator.hasNext()) {
			User user = iterator.next();
			if(user.getId() == id) {
				iterator.remove();
				return user;
			}
		}
		return null;
	}

}
