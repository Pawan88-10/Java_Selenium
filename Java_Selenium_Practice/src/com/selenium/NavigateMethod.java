package com.selenium;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import java.net.URL;

public class NavigateMethod{
    public static void main(String[] args) {
     
        // Initialize WebDriver
        WebDriver driver = new EdgeDriver();

        try {
            // Get the Navigation interface
            WebDriver.Navigation navigation = driver.navigate();

            // 1. to(String url) - Navigate to a specific URL
            System.out.println("Navigating to Google...");
            navigation.to("https://www.flipkart.com/");
            System.out.println("Current URL: " + driver.getCurrentUrl());
            Thread.sleep(2000); // Wait to observe

            // 2. to(URL url) - Navigate to a specific URL using URL object
            System.out.println("Navigating to Example.com...");
            URL exampleUrl = new URL("https://www.flipkart.com/");
            navigation.to(exampleUrl);
            System.out.println("Current URL: " + driver.getCurrentUrl());
            Thread.sleep(2000);

            // 3. back() - Go back to the previous page
            System.out.println("Navigating back...");
            navigation.back();
            System.out.println("Current URL after back: " + driver.getCurrentUrl());
            Thread.sleep(2000);

            // 4. forward() - Go forward to the next page
            System.out.println("Navigating forward...");
            navigation.forward();
            System.out.println("Current URL after forward: " + driver.getCurrentUrl());
            Thread.sleep(2000);

            // 5. refresh() - Refresh the current page
            System.out.println("Refreshing the page...");
            navigation.refresh();
            System.out.println("Current URL after refresh: " + driver.getCurrentUrl());
            Thread.sleep(2000);

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            // Close the browser
            driver.quit();
        }
    }
}