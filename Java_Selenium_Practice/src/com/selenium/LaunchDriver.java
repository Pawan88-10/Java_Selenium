package com.selenium;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriver.Options;
import org.openqa.selenium.edge.EdgeDriver;

public class LaunchDriver {

	public static void main(String[] args) {
		//Webdriver -> (get, getTitle, getCurrentUrl, getPageSource, getWindowHandle, manage)
		
		//driver launch
		WebDriver driver = new EdgeDriver();
		
		//pre-condition (Maximize the window)
		driver.manage().window().maximize();
		
		//trigger the main url
		driver.get("https://www.facebook.com/");
		
		//get the title of webpage
		String webPageName = driver.getTitle();
		System.out.println("Title Of WebPage : "+webPageName);
		
		//get the current page url of webpage
		String webCurrentUrl = driver.getCurrentUrl();
		System.out.println("Current Url of WebPage : "+webCurrentUrl);
		
		//the getPageSource() method is used to retrieve the entire HTML source code of the current web page.
		String pageSource = driver.getPageSource();
		System.out.println(pageSource);
		
		//get the single window id
		String windowId = driver.getWindowHandle();
		System.out.println("Window Id : "+windowId);
		
		//manage 
		Options manage = driver.manage();
		System.out.println("Manage method : "+manage);
		
	}

}
