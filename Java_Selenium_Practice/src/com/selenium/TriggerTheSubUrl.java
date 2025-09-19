package com.selenium;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;

public class TriggerTheSubUrl {

	public static void main(String[] args) throws InterruptedException, MalformedURLException {
		
		WebDriver driver = new EdgeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.dassault-aviation.com/en/");
		Thread.sleep(2000);
		
		//Store the main url as an object
		URL mainUrl = new URL("https://www.dassault-aviation.com/en/");
		
		//create the object
		URL passionPage = new URL(mainUrl,"passion/");
		
		//navigate
		driver.navigate().to(passionPage);
		

	}

}
