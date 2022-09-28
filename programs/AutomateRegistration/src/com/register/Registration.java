package com.register;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Registration {

	public static void main(String[] args) {
		
		System.setProperty("webdriver.chrome.driver", "C:\\\\\\\\Users\\\\\\\\syama\\\\\\\\Downloads\\\\\\\\chromedriver_win32\\\\\\\\chromedriver.exe");
		WebDriver driver= new ChromeDriver();
		driver.get("https://profile.oracle.com/myprofile/account/create-account.jspx");
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		WebElement name=driver.findElement(By.id("sView1:r1:0:email::content"));
		name.sendKeys("viswa@gmail.com");
		
		WebElement pass=driver.findElement(By.id("sView1:r1:0:password::content"));
		pass.sendKeys("Kohli@345");
		
		WebElement repass=driver.findElement(By.id("sView1:r1:0:retypePassword::content"));
		repass.sendKeys("Kohli@345");
		
		WebElement country=driver.findElement(By.id("sView1:r1:0:country::content"));
		country.sendKeys("India");
		
		WebElement firstName=driver.findElement(By.id("sView1:r1:0:firstName::content"));
		firstName.sendKeys("Syamakuru");
		
		WebElement lastName=driver.findElement(By.id("sView1:r1:0:lastName::content"));
		lastName.sendKeys("Viswa Teja Reddy");
		
		WebElement jobTitle=driver.findElement(By.id("sView1:r1:0:jobTitle::content"));
		jobTitle.sendKeys("Associate Software");
		
		WebElement workPhone=driver.findElement(By.id("sView1:r1:0:workPhone::content"));
		workPhone.sendKeys("00111111");
		
		WebElement companyName=driver.findElement(By.id("sView1:r1:0:companyName::content"));
		companyName.sendKeys("xxxxxx");
		
	    WebElement address1=driver.findElement(By.id("sView1:r1:0:address1::content"));
	    address1.sendKeys("Andhra Pradesh,India");
		
		WebElement city=driver.findElement(By.id("sView1:r1:0:city::content"));
		city.sendKeys("Vijayawada");
		
		WebElement state=driver.findElement(By.id("sView1:r1:0:state::content"));
		state.sendKeys("Andhra Pradesh");
		
		WebElement postalCode=driver.findElement(By.id("sView1:r1:0:postalCode::content"));
		postalCode.sendKeys("500121");
		//WebElement register=driver.findElement(By.id("registerButton"));
		//register.click();
        
	}

}
