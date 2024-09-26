package SF_TestsCase;

import java.io.FileNotFoundException;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import SF_Listeners.SF_Listening;
import SF_Pages.LoginPage;
import SF_Pages.MyProfilePage;
import SF_Utilities.SF_FileUtilities;

@Listeners(SF_Listening.class)
public class SF_LoginTest extends SF_BaseTest{
	
	@Test()
	public void loginTestErrorTC01 () throws FileNotFoundException, IOException {
		WebDriver driver = getBrowser();
		logger.info("Browser instance launched");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		LoginPage lp = new LoginPage(driver);
		driver.navigate().to(SF_FileUtilities.readLoginPropertiesFile("production.url"));
		test.get().info("App launched");
		String expectedUserName = SF_FileUtilities.readLoginPropertiesFile("valid.username");
		lp.enterUsername(expectedUserName);
		String actualUsername = lp.getValueAttribute(lp.userName);
		Assert.assertEquals(expectedUserName, actualUsername, "The actual and expected usernames should be same");
		lp.password.clear();
		String actualPassword = lp.getValueAttribute(lp.password);
		Assert.assertEquals("", actualPassword, "The actual and expected passwords should be same");
		lp.clickLogin();
		Assert.assertEquals(lp.getErrorMessage(), SF_FileUtilities.readLoginPropertiesFile("error.text"), "Error message should be same");
	
	}
	
	@Test
	public void loginInToSalessforceTC02() throws FileNotFoundException, IOException {
		SoftAssert soft = new SoftAssert();
		WebDriver driver = getBrowser();
		logger.info("Browser instance launched");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		LoginPage lp = new LoginPage(driver);
		driver.navigate().to(SF_FileUtilities.readLoginPropertiesFile("production.url"));
		String expectedUsername = SF_FileUtilities.readLoginPropertiesFile("valid.username");
		lp.enterUsername(expectedUsername);
		String actualUsername = lp.getValueAttribute(lp.userName);
		soft.assertEquals(expectedUsername, actualUsername, "The actual and expected usernames should be same");
		lp.enterPassword(SF_FileUtilities.readLoginPropertiesFile("valid.password"));
		lp.clickLogin();
		soft.assertEquals(driver.getTitle(),SF_FileUtilities.readLoginPropertiesFile("homepage.title"));
		System.out.println("The first testcase is complete");
	}
	
	
	@Test()
	public void checkRememberMe() throws InterruptedException, FileNotFoundException, IOException {
		WebDriver driver = getBrowser();
		logger.info("Browser instance launched");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		LoginPage lp = new LoginPage(driver);
		driver.navigate().to(SF_FileUtilities.readLoginPropertiesFile("production.url"));
		LoginPage log = new LoginPage(driver);
	
		if(log.rememberMe.isDisplayed()) {
			log.rememberMe.click();
			System.out.println("Remember me has been clicked.");
		} else {
			System.out.println("Remember me was not clicked.");
		}
		String expectedUsername = SF_FileUtilities.readLoginPropertiesFile("valid.username");
		lp.enterUsername(expectedUsername);
		String expectedPass = SF_FileUtilities.readLoginPropertiesFile("valid.username");
		lp.enterPassword(expectedPass);
		lp.clickLogin();
		hp.loggingOut();
	}
	
	@Test()
	public void forgotPassword () throws FileNotFoundException, IOException {
		WebDriver driver = getBrowser();
		logger.info("Browser instance launched");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		LoginPage lp = new LoginPage(driver);
		driver.navigate().to(SF_FileUtilities.readLoginPropertiesFile("production.url"));
		String expectedUsername = SF_FileUtilities.readLoginPropertiesFile("valid.username");
		lp.enterUsername(expectedUsername);
		
		if(lp.forgotPassword.isDisplayed()) {
			lp.forgotPassword.click();
			System.out.println(driver.getTitle());
			String forgotPassUser = SF_FileUtilities.readLoginPropertiesFile("forgotPass.username");
			lp.forgotPassUserName(forgotPassUser);
			lp.clickContinue();
			System.out.println(driver.getTitle());
		}
	}
	
	@Test
	public void IncorrectCredentials() throws FileNotFoundException, IOException {
		SoftAssert soft = new SoftAssert();
		WebDriver driver = getBrowser();
		logger.info("Browser instance launched");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		LoginPage lp = new LoginPage(driver);
		driver.navigate().to(SF_FileUtilities.readLoginPropertiesFile("production.url"));
		String expectedUsername = SF_FileUtilities.readLoginPropertiesFile("invalid.username");
		lp.enterUsername(expectedUsername);
		String actualUsername = lp.getValueAttribute(lp.userName);
		soft.assertEquals(expectedUsername, actualUsername, "The actual and expected usernames should be same");
		lp.enterPassword(SF_FileUtilities.readLoginPropertiesFile("invalid.password"));
		lp.clickLogin();
		System.out.println(lp.loginError.getText());
		
		System.out.println("The 4B testcase is complete");
		soft.assertAll();
		System.out.println("Test");
	} 
}
 