package com.selenium;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import java.net.MalformedURLException;
import java.net.URL;

public class UrlClass {
    public static void main(String[] args) {
        
        WebDriver driver = new EdgeDriver();

        try {
            WebDriver.Navigation navigation = driver.navigate();

            // Using to(String url) with an invalid URL
            System.out.println("Attempting to navigate to invalid URL...");
            try {
                navigation.to("https://www.flipkart.com/");
            } catch (Exception e) {
                System.out.println("Failed to navigate with String URL: " + e.getMessage());
            }
            Thread.sleep(2000);

            // Using to(URL url) with a malformed URL
            System.out.println("Attempting to navigate with malformed URL object...");
            try {
                URL invalidUrl = new URL("https://www.flipkart.com/");
                navigation.to(invalidUrl);
            } catch (MalformedURLException e) {
                System.out.println("Malformed URL Exception: " + e.getMessage());
            }
            Thread.sleep(2000);

            // Navigate to a valid URL after error handling
            System.out.println("Navigating to a valid URL...");
            navigation.to("https://www.selenium.dev");
            System.out.println("Current URL: " + driver.getCurrentUrl());

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            driver.quit();
        }
    }
}