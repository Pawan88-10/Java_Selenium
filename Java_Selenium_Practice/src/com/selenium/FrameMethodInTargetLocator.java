package com.selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchFrameException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;

public class FrameMethodInTargetLocator {

	public static void main(String[] args) {
		
		WebDriver driver = new EdgeDriver();
		
		 driver.get("https://www.selenium.dev/selenium/web/iframes.html");
         System.out.println("Loaded page: " + driver.getTitle());

         // Switch to the iframe with ID "iframe1"
         try {
             driver.switchTo().frame("iframe1");
             System.out.println("Switched to iframe with ID 'iframe1'");

             // Interact with an element inside the iframe (e.g., email input)
             WebElement emailField = driver.findElement(By.id("email"));
             emailField.sendKeys("test@example.com");
             System.out.println("Entered text in iframe element");

             // Switch back to default content
             driver.switchTo().defaultContent();
             System.out.println("Switched back to default content");

         } catch (NoSuchFrameException e) {
             System.err.println("Frame not found: " + e.getMessage());
         }

	}

}
