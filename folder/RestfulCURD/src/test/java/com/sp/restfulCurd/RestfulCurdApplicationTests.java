package com.sp.restfulCurd;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class RestfulCurdApplicationTests {

	@Autowired
	private UserService service;
	@Disabled
	@Test
	public void addData() {
		Assertions.assertNotNull(service.addUser(new User("earth","earth@gmail.com","universe")));
	}
	@Disabled
	@Test
	public void getAll() {
		Assertions.assertEquals(2,service.getAllUser().size());
	}
	@Disabled
	@Test
	public void getById() {
		Assertions.assertEquals("earth",service.getUserById(8).getName());
	}
	@Disabled
	@Test
	public void update() {
		Assertions.assertNotNull(service.updateUser(new User("viswa","vis@gmail.com","America"), 6));
	}
	
	@Test
	public void delete() {
		Assertions.assertNotNull(service.deleteUser(8));
	}
	
}