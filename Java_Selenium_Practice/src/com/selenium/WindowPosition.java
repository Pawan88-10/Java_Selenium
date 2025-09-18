package com.selenium;


import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;

public class WindowPosition {

	public static void main(String[] args) {
		
		WebDriver driver = new EdgeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.facebook.com/");
		
		//get the position of window

		int getX = driver.manage().window().getPosition().getX();
		int getY = driver.manage().window().getPosition().getY();
		
		System.out.println("Window Position Towards X-Axis : "+getX);
		System.out.println("Window Position Towards Y-Axis : "+getY);
		
		//Set the position of window
		Point pos = new Point(100, 300);
		driver.manage().window().setPosition(pos);
		System.out.println("Position Of Window : "+pos);
		
		driver.close();
	}

}
