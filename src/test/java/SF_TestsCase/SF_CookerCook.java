package SF_TestsCase;

import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

public class SF_CookerCook extends SF_BaseTest {
    private WebDriver driver;

    @Test
    public void attachToExistingSession() throws InterruptedException {
        driver = getBrowser(); // Uses existing WebDriver from SF_BaseTest
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));

        System.out.println("Successfully attached to existing Chrome session.");
        driver.get("https://orgfarm-e2f8a5e28c-dev-ed.develop.my.salesforce.com");
        System.out.println(driver.getTitle());

        // Click on "Analytics" (ensure correct XPath)
        driver.findElement(By.id("Account_Tab")).click();
    }
}
