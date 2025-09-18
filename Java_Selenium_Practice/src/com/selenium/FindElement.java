package com.selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;

public class FindElement {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		
		WebDriver driver = new EdgeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.facebook.com/");
		Thread.sleep(2000);
		
		// identify the email element -- address
		WebElement emailTextField = driver.findElement(By.id("email"));
		emailTextField.sendKeys("xyz@gmail.com");
		Thread.sleep(2000);
		
		//identify the password element -- address
		WebElement passwordTextField = driver.findElement(By.id("pass"));
		passwordTextField.sendKeys("1123456789");
		Thread.sleep(2000);
		
		/*
		 * identity the login button -- address name can be duplicate but id will not
		 * duplicate and id will also be dynamic means id will be changed so many time
		 * when window will be refreshed
		 */
		WebElement loginButton = driver.findElement(By.name("login"));
		loginButton.click();
		Thread.sleep(2000);
		
		//post condition
		driver.manage().window().minimize();
		driver.quit();
	}

}
