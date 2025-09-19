package com.selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class WebElementFeatures {
    public static void main(String[] args) {
        // Initialize WebDriver
        WebDriver driver = new EdgeDriver();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        try {
            // Navigate to Flipkart
            driver.get("https://www.flipkart.com/");
            driver.manage().window().maximize();
            System.out.println("Loaded Flipkart: " + driver.getTitle());

            // Close login popup if it appears
            try {
                WebElement closeButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[contains(text(), '✕')]")));
                closeButton.click();
                System.out.println("Closed login popup.");
            } catch (Exception e) {
                System.out.println("No login popup found.");
            }

            // 1. findElement with By.name (Search bar)
            try {
                WebElement searchBar = driver.findElement(By.name("q"));
                searchBar.sendKeys("laptop");
                System.out.println("Found search bar by name and entered 'laptop'.");
            } catch (Exception e) {
                System.err.println("Search bar not found: " + e.getMessage());
            }

            // 2. findElement with By.xpath (Search button)
            try {
                WebElement searchButton = driver.findElement(By.xpath("//button[@type='submit']"));
                searchButton.click();
                System.out.println("Found and clicked search button by XPath.");
                // Navigate back to homepage for further tests
                driver.navigate().back();
                wait.until(ExpectedConditions.elementToBeClickable(By.name("q")));
            } catch (Exception e) {
                System.err.println("Search button not found: " + e.getMessage());
            }

            // 3. findElement with By.linkText (Category link, e.g., "Mobiles")
            try {
                WebElement mobilesLink = driver.findElement(By.linkText("Mobiles"));
                mobilesLink.click();
                System.out.println("Found and clicked 'Mobiles' link by linkText.");
                driver.navigate().back();
                wait.until(ExpectedConditions.elementToBeClickable(By.name("q")));
            } catch (Exception e) {
                System.err.println("Mobiles link not found: " + e.getMessage());
            }

            // 4. findElement with By.cssSelector (A div containing a banner)
            try {
                WebElement bannerDiv = driver.findElement(By.cssSelector("div._1kidPb"));
                System.out.println("Found banner div by CSS selector: " + bannerDiv.getTagName());
            } catch (Exception e) {
                System.err.println("Banner div not found: " + e.getMessage());
            }

            // 5. findElement on WebElement (Nested element search)
            try {
                // Find a parent element (e.g., search form container)
                WebElement searchForm = driver.findElement(By.cssSelector("form._2rslOn"));
                // Find a nested element (e.g., search button inside the form)
                WebElement nestedSearchButton = searchForm.findElement(By.tagName("button"));
                nestedSearchButton.click();
                System.out.println("Found and clicked nested search button inside form.");
                driver.navigate().back();
            } catch (Exception e) {
                System.err.println("Nested search button not found: " + e.getMessage());
            }

        } catch (Exception e) {
            System.err.println("General error: " + e.getClass().getSimpleName() + " - " + e.getMessage());
        } finally {
            driver.quit();
        }
    }
}