package com.selenium;

import java.util.Set;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.edge.EdgeDriver;

public class Task_2 {

	public static void main(String[] args) {
		
		//launch 5 new window and set size and position of window

		// Launch the browser
		WebDriver driver = new EdgeDriver();
		//
		driver.get("https://www.facebook.com/");
		driver.switchTo().newWindow(WindowType.WINDOW);
		// pre-condition after launching the browser
		driver.manage().window().maximize();

		// launching 5 browser
		String[] arr = { "https://www.myntra.com/", "https://www.flipkart.com/", "https://www.amazon.com/",
				"https://open.spotify.com/", "https://www.meesho.com/" };

		for (int i = 0; i < arr.length; i++) {
			driver.get(arr[i]);
			driver.switchTo().newWindow(WindowType.WINDOW);
		}

		Set<String> captureWin = driver.getWindowHandles();

		for (String wid : captureWin) {
			String winUrl = driver.switchTo().window(wid).getCurrentUrl();

			if (winUrl.equals("https://www.facebook.com/")) {
				String title = driver.getTitle();
				System.out.println("Title of Facebook Window = "+title);
			} else if (winUrl.equals("https://www.myntra.com/")) {
				System.out.println("Myntra website is opened...");
				int winHeight = driver.manage().window().getSize().getHeight();
				int winWidth = driver.manage().window().getSize().getWidth();
				System.out.println("Height of Myntra = "+winHeight);
				System.out.println("Width of Myntra = "+winWidth);	
				
			} else if (winUrl.equals("https://www.flipkart.com/")) {
				System.out.println("Flipkart is Opened ...");
				Point pos = new Point(200, 300);
				int getX = driver.manage().window().getPosition().getX();
				int getY = driver.manage().window().getPosition().getY();
				System.out.println("X-Axis of Flipkart = "+getX);
				System.out.println("Y-Axis of Flipkart = "+getY);
			} else if (winUrl.equals("https://www.amazon.com/")) {
				System.out.println("Amazon is Opened ...");
				Dimension size = new Dimension(130, 350);
				driver.manage().window().setSize(size);
			} else if (winUrl.equals("https://open.spotify.com/")) {
				System.out.println("Spotify is opened ...");
				String currentUrl = driver.getCurrentUrl();
				System.out.println("Spotify is having url = "+currentUrl);
			} else if (winUrl.equals("https://www.meesho.com/")) {
				System.out.println("Meesho is opened ...");
				Point pos = new Point(500, 500);
				driver.manage().window().setPosition(pos);
			} else {
				System.out.println("No window is captured ...");
			}
		}

	}

}
