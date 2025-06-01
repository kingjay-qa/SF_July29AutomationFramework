package SF_TestsCase;

import java.time.Duration;
import java.net.MalformedURLException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.*;

import com.aventstack.extentreports.ExtentTest;

import SF_Pages.HomePage;
import SF_Utilities.SF_ReportManager;

public class SF_BaseTest {
	private static WebDriver driver;
	HomePage hp = null;
	public static ThreadLocal<ExtentTest> test = new ThreadLocal<>();

	@BeforeClass
	public void setupTest() {
		test.set(SF_ReportManager.getInstance().createTest("Test Name"));
	}

	public static Logger logger = LogManager.getLogger("BaseTest");

	@BeforeSuite
	public void setupReport() {
		SF_ReportManager.getInstance();
	}

	@Parameters("bName")
	@BeforeClass
	public void setupDriver(@Optional("chrome") String browserName) throws MalformedURLException {
		if (driver == null) {
			driver = attachToExistingChrome();
		}
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
	}

	public static WebDriver getBrowser() {
		return driver;
	}

	private WebDriver attachToExistingChrome() throws MalformedURLException {
		ChromeOptions options = new ChromeOptions();
		options.setExperimentalOption("debuggerAddress", "127.0.0.1:9222"); // Standardized debug address

		try {
			driver = new ChromeDriver(options);
			logger.info("Successfully attached to existing Chrome session.");
		} catch (Exception e) {
			logger.error(
					"Failed to attach to existing Chrome session. Ensure Chrome is running with remote debugging.");
			throw e;
		}

		return driver;
	}

	@AfterClass
	public void tearDown() {
		if (driver != null) {
			try {
				driver.quit();
				logger.info("WebDriver session closed successfully.");
			} catch (Exception e) {
				logger.warn("Driver quit failed: " + e.getMessage());
			}
		}
	}
}
