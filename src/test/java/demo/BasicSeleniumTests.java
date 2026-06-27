package demo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.Test;

import java.time.Duration;

public class BasicSeleniumTests {
    @Test
    public void testExample() {
        // Test implementation
        // TestNG >> Test Suite >> Test >> Test Class >> Test Method
        WebDriver driver;
//        RemoteWebDriver driver;
        driver = new ChromeDriver(getOptimizedOptions());
        driver.navigate().to("http://www.google.com");
        String currentUrl = driver.getCurrentUrl();
        System.out.println("Current URL: " + currentUrl);

        String currentPageTitle = driver.getTitle();
        System.out.println("Current Page Title: " + currentPageTitle);
//        driver.manage().window().maximize();

        // new browser session > browser action > element identification > element action > get element info / get browser info > checkpoint

        driver.quit();
    }

    public static ChromeOptions getOptimizedOptions() {
        ChromeOptions options = new ChromeOptions();

        // Essential execution mode
        options.addArguments("--headless");

        // CI/CD-specific stability
        options.addArguments("--no-sandbox");
        options.addArguments("--disable-dev-shm-usage");

        // Performance & consistency
        options.addArguments("--disable-extensions");
        options.addArguments("--window-size=1920,1080");

        return options;
    }
}
