package demo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.Test;

public class BasicSeleniumTests {
    @Test
    public void testExample() {
        // Test implementation
        // TestNG >> Test Suite >> Test >> Test Class >> Test Method
        WebDriver driver;
        driver = new ChromeDriver(getOptimizedOptions());
        driver.navigate().to("http://www.google.com");
        driver.quit();
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
