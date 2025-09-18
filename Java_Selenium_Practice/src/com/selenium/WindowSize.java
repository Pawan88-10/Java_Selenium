package com.selenium;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;

public class WindowSize {

	public static void main(String[] args) throws InterruptedException {
		
		WebDriver driver = new EdgeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.facebook.com/");
		
		//get window size, height, width
		Dimension dimension = driver.manage().window().getSize();
		System.out.println("Dimension Of Window : "+dimension);
		
		int height = driver.manage().window().getSize().height;
		System.out.println("Window Height : "+height);
		
		int Width = driver.manage().window().getSize().width;
		System.out.println("Window Height : "+Width);
		
		Thread.sleep(2000);
		//set window height and width
		Dimension size = new Dimension(200, 300);
		driver.manage().window().setSize(size);
		System.out.println("Mannual Size : "+size);
		
		driver.close();

	}

}
