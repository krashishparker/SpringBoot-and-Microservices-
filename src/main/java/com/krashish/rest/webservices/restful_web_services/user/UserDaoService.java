package com.krashish.rest.webservices.restful_web_services.user;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

@Component
public class UserDaoService {

	//public List<User> findAll()
	public static List<User> users= new ArrayList<>();
	
	public static int userCount=0;
	
	static{
		users.add(new User(++userCount,"Ashish",LocalDate.now().minusYears(27)));
		users.add(new User(++userCount,"Manish",LocalDate.now().minusYears(28)));
		users.add(new User(++userCount,"Rajnish",LocalDate.now().minusYears(24)));
	}
	
	public List<User> findAll(){
		return users;
	}
	
	public User findUser(int id) {
		/*
		 * for(User i : users) { if(i.getId()==id) return i; } return null;
		 */
		
		return users.stream().filter(user->user.getId()==id).findFirst().orElse(null);
	}
	
	//public User save (User user)
	public User saveUser(User user) {
		/*
		 * for(User i : users) { if(i.getId()==id) return i; } return null;
		 */
		 user.setId(++userCount);
		 users.add(user);	
		 return user;
	}

	public void deleteUser(int id) {
		// TODO Auto-generated method stub
		users.removeIf(user->user.getId()==id);
	}
	
	//public User findOne (int id)
}
