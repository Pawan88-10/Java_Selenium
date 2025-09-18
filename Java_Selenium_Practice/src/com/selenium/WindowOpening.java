package com.selenium;

import java.io.BufferedOutputStream;
import java.util.Set;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.edge.EdgeDriver;

public class WindowOpening {

	public static void main(String[] args) throws InterruptedException {
		//Webdriver -> (manage, getWindowHandles, switchTo, window, Tab, close, quit)
		
		WebDriver driver = new EdgeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.flipkart.com/");
		
		//open new window :- Window or Tab and trigger the main url in opened new window 
		driver.switchTo().newWindow(WindowType.WINDOW);
		driver.get("https://www.amazon.in/b?node=1968024031");
		Thread.sleep(2000); //return InterruptedException ---> compile time exception ---> unchecked exception
		
		//open new window (3)+2(above new window)
		driver.switchTo().newWindow(WindowType.WINDOW);
		driver.get("https://www.myntra.com/");
		Thread.sleep(2000);
		
		driver.switchTo().newWindow(WindowType.WINDOW);
		driver.get("https://www.meesho.com/");
		Thread.sleep(2000);
		
		driver.switchTo().newWindow(WindowType.WINDOW);
		driver.get("https://www.croma.com/");
		Thread.sleep(2000);
		
		//close chrome window and close() will close only single window
		driver.close();
		
		//to catch or get window id of all opened window(5)
		Set<String> wid = driver.getWindowHandles();
		for (String id : wid) {
			driver.switchTo().window(id);
			System.out.println("Window ID : "+id);
		}
		
		//open new tab
		Thread.sleep(2000);
		driver.switchTo().newWindow(WindowType.TAB);
		driver.get("https://www.facebook.com/");
		
		driver.quit();

	}

}
