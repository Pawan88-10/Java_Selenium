package com.selenium;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;
import java.util.List;

public class TargetLocator {
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

            // 1. defaultContent()
            driver.switchTo().defaultContent();
            System.out.println("Switched to default content.");

            // Check for iframes on Flipkart
            List<WebElement> iframes = driver.findElements(By.tagName("iframe"));
            System.out.println("Total iframes found: " + iframes.size());

            // 2. frame(int index)
            if (iframes.size() > 0) {
                driver.switchTo().frame(0);
                System.out.println("Switched to frame by index 0.");
                driver.switchTo().defaultContent();
            } else {
                System.out.println("No iframes found on Flipkart. Switching to Selenium demo page for frame testing.");
                driver.get("https://www.selenium.dev/selenium/web/iframes.html");
                driver.switchTo().frame(0);
                System.out.println("Switched to frame by index 0 on Selenium demo page.");
                driver.switchTo().defaultContent();
            }

            // 3. frame(String nameOrId)
            try {
                driver.switchTo().frame("iframe1"); // Try Flipkart or Selenium demo iframe
                System.out.println("Switched to frame by ID 'iframe1'.");
                driver.switchTo().defaultContent();
            } catch (Exception e) {
                System.out.println("Frame 'iframe1' not found: " + e.getMessage());
                // Fallback to Selenium demo page if not already there
                if (!driver.getCurrentUrl().contains("selenium.dev")) {
                    driver.get("https://www.selenium.dev/selenium/web/iframes.html");
                    driver.switchTo().frame("iframe1");
                    System.out.println("Switched to frame 'iframe1' on Selenium demo page.");
                    driver.switchTo().defaultContent();
                }
            }

            // 4. frame(WebElement frameElement)
            try {
                WebElement frameElement = driver.findElement(By.xpath("//iframe[@id='iframe1']"));
                driver.switchTo().frame(frameElement);
                System.out.println("Switched to frame by WebElement.");
                driver.switchTo().defaultContent();
            } catch (Exception e) {
                System.out.println("Frame by WebElement not found: " + e.getMessage());
                // Already on Selenium page, so try again
                if (driver.getCurrentUrl().contains("selenium.dev")) {
                    WebElement frameElement = driver.findElement(By.xpath("//iframe[@id='iframe1']"));
                    driver.switchTo().frame(frameElement);
                    System.out.println("Switched to frame by WebElement on Selenium demo page.");
                    driver.switchTo().defaultContent();
                }
            }

            // 5. parentFrame()
            if (driver.getCurrentUrl().contains("selenium.dev")) {
                driver.switchTo().frame(0);
                // Selenium page has no nested frames, so parentFrame() returns to default
                driver.switchTo().parentFrame();
                System.out.println("Switched to parent frame (same as default on Selenium page).");
                driver.switchTo().defaultContent();
            } else {
                System.out.println("Skipping parentFrame test: No nested frames on Flipkart.");
            }

            // Navigate back to Flipkart for remaining tests
            if (!driver.getCurrentUrl().contains("flipkart.com")) {
                driver.get("https://www.flipkart.com/");
                try {
                    WebElement closeButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[contains(text(), '✕')]")));
                    closeButton.click();
                } catch (Exception e) {
                    System.out.println("No login popup found.");
                }
            }

            // 6. window(String windowHandle)
            String originalWindow = driver.getWindowHandle();
            driver.switchTo().newWindow(WindowType.WINDOW);
            driver.get("https://www.flipkart.com/mobiles");
            System.out.println("Opened and switched to new window (Mobiles page).");
            driver.switchTo().window(originalWindow);
            System.out.println("Switched back to original window.");

            // 7. newWindow(WindowType typeHint)
            driver.switchTo().newWindow(WindowType.TAB);
            driver.get("https://www.flipkart.com/offers-store");
            System.out.println("Opened and switched to new tab (Offers page).");
            driver.switchTo().window(originalWindow);

            // 8. alert()
            ((JavascriptExecutor) driver).executeScript("alert('This is a test alert!');");
            Alert alert = wait.until(ExpectedConditions.alertIsPresent());
            System.out.println("Alert text: " + alert.getText());
            alert.accept();
            System.out.println("Accepted the alert.");

            // 9. activeElement()
            WebElement searchBar = wait.until(ExpectedConditions.elementToBeClickable(By.name("q")));
            searchBar.click();
            searchBar.sendKeys("laptop");
            WebElement active = driver.switchTo().activeElement();
            System.out.println("Active element tag: " + active.getTagName());

        } catch (Exception e) {
            System.err.println("Error: " + e.getClass().getSimpleName() + " - " + e.getMessage());
        } finally {
            driver.quit();
        }
    }
}