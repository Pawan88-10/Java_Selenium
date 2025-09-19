package com.selenium;

import java.util.Set;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.edge.EdgeDriver;

public class Task_1 {

    public static void main(String[] args) throws InterruptedException {

		/*
		 * Task :-> Open 5 window along with main url after it capture all window id and
		 * close current opened window and after all of these launch new tab and close
		 * all opened window and tab
		 */
    	
        WebDriver driver = new EdgeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.flipkart.com/");
        
        // Open Amazon
        driver.switchTo().newWindow(WindowType.WINDOW);
        driver.get("https://www.amazon.in/b?node=1968024031");
        Thread.sleep(2000);
        
        // Open Myntra
        driver.switchTo().newWindow(WindowType.WINDOW);
        driver.get("https://www.myntra.com/");
        Thread.sleep(2000);
        
        // Open Meesho
        driver.switchTo().newWindow(WindowType.WINDOW);
        driver.get("https://www.meesho.com/");
        Thread.sleep(2000);
        
        // Open Croma
        driver.switchTo().newWindow(WindowType.WINDOW);
        driver.get("https://www.croma.com/");
        Thread.sleep(2000);
        
        // Close current window (Croma)
        driver.close();

        // ✅ Switch to one of the remaining windows
        Set<String> wid = driver.getWindowHandles();
        
        //check size of all finding wid
        System.out.println("Size/Length of Window Id : "+wid.size());
        
        for (String id : wid) {
            try {
                driver.switchTo().window(id); // Try to switch
                System.out.println("Switched to window: " + id);
                break; // Stop after switching to one valid window
            } catch (Exception e) {
                // Skip invalid windows
            }
        }

        // Print remaining window IDs
        wid = driver.getWindowHandles(); // refresh after switch
        for (String id : wid) {
            System.out.println("Window ID: " + id);
        }

        // Open a new tab
        Thread.sleep(2000);
        driver.switchTo().newWindow(WindowType.TAB);
        driver.get("https://www.facebook.com/");

        // Quit all windows
        driver.quit();
    }

}
