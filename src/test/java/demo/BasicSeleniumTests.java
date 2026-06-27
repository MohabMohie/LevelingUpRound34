package demo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class BasicSeleniumTests {
    // TestNG / JUnit > Test Workflow Management + Checkpoints / Assertions + ...etc
    // TestNG >> Test Suite >> Test >> Test Class >> Test Method
    // new browser session > browser action > element identification > element action > get element info / get browser info > checkpoint
    // Assertion (Hard Assertion) X Verification (Soft Assertion)
    WebDriver driver;

    @BeforeMethod
    public void setUp() {
        driver = new ChromeDriver(getOptimizedOptions());
        driver.navigate().to("https://www.google.com/");
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }

    @Test
    public void checkGooglePageUrl() {
        String currentUrl = driver.getCurrentUrl();
        System.out.println("Current URL: " + currentUrl);
        Assert.assertEquals(currentUrl, "https://www.google.com/");
    }

    @Test
    public void checkGooglePageTitle() {
        String currentPageTitle = driver.getTitle();
        System.out.println("Current Page Title: " + currentPageTitle);
        Assert.assertEquals(currentPageTitle, "Google");
    }

    public static ChromeOptions getOptimizedOptions() {
        ChromeOptions options = new ChromeOptions();

        // Essential execution mode
//        options.addArguments("--headless");

        // CI/CD-specific stability
        options.addArguments("--no-sandbox");
        options.addArguments("--disable-dev-shm-usage");

        // Performance & consistency
        options.addArguments("--disable-extensions");
        options.addArguments("--window-size=1920,1080");

        return options;
    }
}
