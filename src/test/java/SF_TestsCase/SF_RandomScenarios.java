ls
package SF_TestsCase;

import java.io.FileNotFoundException;
import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import SF_Listeners.SF_Listening;
import SF_Pages.LoginPage;
import SF_Pages.MyProfilePage;

@Listeners(SF_Listening.class)
public class SF_RandomScenarios extends SF_BaseTest{
	
	@Test
	public void verifyFirstLastName_TC33() throws FileNotFoundException, IOException {
		WebDriver driver = getBrowser();
		LoginPage lp = new LoginPage(driver);
		hp = lp.loginToApp(driver);
		
		hp.clickHomeTab();
		hp.verifyAccountName();
		hp.loggingOut();
		System.out.println("Testcase 33 is Complete");
	}
	
	@Test
	public void verifyEditFirstLastName_TC34() throws FileNotFoundException, IOException {
		WebDriver driver = getBrowser();
		LoginPage lp = new LoginPage(driver);
		MyProfilePage pp = new MyProfilePage(driver);
		hp = lp.loginToApp(driver);
		
		hp.clickHomeTab();	
		hp.clickAccountHolder(); //	Update WebElement for future successful scenarios | Proper Webelemnt required
		
		System.out.println("Profile has been selected");
		if(pp.editContactButton.isDisplayed()) {
			pp.clickEditProfile(driver);
			System.out.println("Button clicked.");
		}
		 Assert.assertTrue(pp.verifyContactIframeAvailability(driver), "");
		    Assert.assertTrue(pp.verifyAboutTab(driver), "");
		
		hp.loggingOut();
		System.out.println("Testcase 34 is Complete");
	}
}
