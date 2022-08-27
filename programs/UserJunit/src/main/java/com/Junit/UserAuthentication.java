package com.Junit;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class UserAuthentication {

	public boolean emailFun(String email) {
		String regex="[a-z0-9]+@[a-z]+\\.[a-z]{2,3}";
		Pattern pattern=Pattern.compile(regex);
		Matcher match=pattern.matcher(email);
		if(match.matches()) {
			return true;
		}
		else {
		    return false;
		}
	}
	
	public String emailStr(String email) {
		if(email!=null) {
			return email;
		}
		else
		{
			return null;
		}
	}
	public boolean passFun(String pass) {
		String regex="^(?=.*[A-Z]).{8,}";
		Pattern pattern=Pattern.compile(regex);
		Matcher match=pattern.matcher(pass);
		if(match.matches()) {
			return true;
		}
		else {
		    return false;
		}
	}

	public String passStr(String pass) {
		if(pass!=null) {
			return pass;
		}
		else
		{
			return null;
		}
	}
	
}
