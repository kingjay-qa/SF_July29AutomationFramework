package SF_TestsCase;

import java.io.FileNotFoundException;
import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import SF_Listeners.SF_Listening;
import SF_Pages.CustomizeMyTabsPage;
import SF_Pages.HomePage;
import SF_Pages.LoginPage;
import SF_Pages.MyProfilePage;
import SF_Pages.MySettingsPage;

@Listeners(SF_Listening.class)
public class SF_HomeTest extends SF_BaseTest{
	
	HomePage hp;
	WebDriver driver;

	@Test 
	public void userMenuOptionTC05 () throws FileNotFoundException, IOException {
			WebDriver driver = getBrowser();
			logger.info("Browser Launched");
			LoginPage lp = new LoginPage(driver);
			hp = lp.loginToApp(driver);
		hp.clickUserMenu();
		Assert.assertTrue(hp.verifyUserMenuOptions(), "User Menu options should be verified");
		System.out.println("Test Case 5 complete!");
	}

		@Test
		public void verifyMyProfileOption_TC6() throws FileNotFoundException, IOException, InterruptedException {
		WebDriver driver = getBrowser();
		LoginPage lp = new LoginPage(driver);
		hp = lp.loginToApp(driver);
		hp.clickUserMenu();
		MyProfilePage profilePage = new MyProfilePage(driver);
		hp.selectMyProfilePage(driver);
		System.out.println("Profile has been selected");
			if(profilePage.editContactButton.isDisplayed()) {
				profilePage.clickEditProfile(driver);
				System.out.println("Button clicked.");
			}
			 Assert.assertTrue(profilePage.verifyContactIframeAvailability(driver), "");
			    Assert.assertTrue(profilePage.verifyAboutTab(driver), "");
			    Assert.assertTrue(profilePage.verifyLastNameChange(),"");
			    Assert.assertTrue(profilePage.verifyCreatePost(driver, "ET is an alien ahah"));
			    Assert.assertTrue(profilePage.verifyFileUpload(driver));
			    profilePage.clickOnAddPhoto(driver);
			    Assert.assertTrue(profilePage.verifyAddPhoto(driver));
			    System.out.println("TC Complete");
			    
		}
		
		@Test
		public void MySettings_TC7() throws FileNotFoundException, IOException, InterruptedException {
		WebDriver driver = getBrowser();
		LoginPage lp = new LoginPage(driver);
		MySettingsPage sp = new MySettingsPage(driver);
		CustomizeMyTabsPage ctp = new CustomizeMyTabsPage(driver);
		
		hp = lp.loginToApp(driver);
		hp.clickUserMenu();
		hp.selectMySettingsPage(driver);
		
		sp.settingsSteps();
		
		ctp.customAppDropD(driver);
		ctp.emailNameUpdate();
		ctp.calendarReminder(driver);
		
		System.out.println("TestCase 7 Complete");
		}
		
		@Test
		public void DeveloperConsole_TC8() throws FileNotFoundException, IOException, InterruptedException {
		WebDriver driver = getBrowser();
		LoginPage lp = new LoginPage(driver);

		
		hp = lp.loginToApp(driver);
		hp.clickUserMenu();
		
		hp.DevConsole(driver);
		
		}
		
		@Test
		public void LoggingOut_TC9() throws FileNotFoundException, IOException, InterruptedException {
		WebDriver driver = getBrowser();
		LoginPage lp = new LoginPage(driver);

		
		hp = lp.loginToApp(driver);
		hp.clickUserMenu();
		
		hp.loggingOut();
		System.out.println("Logout complete");
		
		}



}
