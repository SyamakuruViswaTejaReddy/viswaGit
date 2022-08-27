package com.Junit;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class UserAuthenticationTest {
	
	private UserAuthentication user;
	

	@BeforeEach
	public void setup() {
		user= new  UserAuthentication();
		System.out.println("User Authentication Initiated");
	}
	
	@AfterEach
	public void tearDown() {
		user=null;
		System.out.println("User Authentication Closed");
	}
	@Test
	public void emailTest() {
		assertEquals(true, user.emailFun("workingexample@email.com"));
		assertNotEquals(true, user.emailFun("notanemail.com"));
		assertTrue(user.emailFun("workingexample@email.com"));
		assertFalse(user.emailFun("notanemail.com"));
		assertNotNull(user.emailStr("email"));
	}
	
	@Test
	public void passwordTest() {
		assertEquals(true, user.passFun("Viswa33.8"));
		assertNotEquals(true, user.passFun("35ijiuhu.226"));
		assertTrue(user.passFun("Viswa33.8"));
		assertFalse(user.passFun("35ijiuhu.226"));
		assertNotNull(user.emailStr("eViswa33.8"));
	}
	

}
