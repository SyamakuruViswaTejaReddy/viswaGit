package com.sp.restfulCurd;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
@Service
public class UserService {
    @Autowired
	private UserRepo repo;
	
	public User addUser(User u) {
		return repo.save(u);
	}

	public List<User> getAllUser() {
		// TODO Auto-generated method stub
		return repo.findAll();
	}

	public User getUserById(int id) {
		// TODO Auto-generated method stub
		if(repo.findById(id).isPresent()) {
			return repo.findById(id).get();
		}
		else
		return null;
	}

	public User updateUser(User user, int id) {
		// TODO Auto-generated method stub
		if(repo.findById(id).isPresent()) {
			User old=repo.findById(id).get();
			old.setName("vis");
			old.setEmail("vis@gmail.com");
			old.setCountry("india");
			
			return repo.save(old);
		}
		return null;
	}

	public boolean deleteUser(int id) {
		// TODO Auto-generated method stub
		if(repo.findById(id).isPresent()) {
			repo.deleteById(id);
			return true;
		}
		return false;
	}
	
}
