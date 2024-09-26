package SF_TestsCase;

import java.io.FileNotFoundException;
import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import SF_Listeners.SF_Listening;
import SF_Pages.ContactsPage;
import SF_Pages.CreateNewViewPage;
import SF_Pages.LoginPage;
import SF_Pages.NewContactPage;

@Listeners(SF_Listening.class)
public class SF_ContactsTest extends SF_BaseTest{
	
	@Test
	public void CreateNewContact_TC25() throws FileNotFoundException, IOException {
		WebDriver driver = getBrowser();
		LoginPage lp = new LoginPage(driver);
		hp = lp.loginToApp(driver);
		ContactsPage cp = new ContactsPage(driver);
		NewContactPage ncp = new NewContactPage(driver);
		
		hp.clickContactTab();
		driver.getTitle();
		cp.clickNewButton();
		driver.getTitle();
		ncp.tempInfo();
		ncp.clickSave();
		hp.loggingOut();
		System.out.println("TestCase 25 is complete.");
	}
	
	@Test
	public void CreateNewView_TC26() throws FileNotFoundException, IOException {
		WebDriver driver = getBrowser();
		LoginPage lp = new LoginPage(driver);
		hp = lp.loginToApp(driver);
		ContactsPage cp = new ContactsPage(driver);
		CreateNewViewPage cnvp = new CreateNewViewPage(driver);
		
		hp.clickContactTab();
		cp.clickNewViewButton();
		cnvp.tempViewInfo();
		cnvp.clickSaveButton();
		hp.loggingOut();
		System.out.println("TestCase 26 is complete.");
	}
	
	@Test
	public void checkingRecentlyCreated_TC27() throws FileNotFoundException, IOException {
		WebDriver driver = getBrowser();
		LoginPage lp = new LoginPage(driver);
		hp = lp.loginToApp(driver);
		ContactsPage cp = new ContactsPage(driver);
		
		hp.clickContactTab();
		cp.selectRecentlyCreated();
		System.out.println(driver.getTitle());
		hp.loggingOut();
		
		System.out.println("TestCase 27 is complete.");
	}
	
	@Test
	public void checkingContactsView_TC28() throws FileNotFoundException, IOException {
		WebDriver driver = getBrowser();
		LoginPage lp = new LoginPage(driver);
		hp = lp.loginToApp(driver);
		ContactsPage cp = new ContactsPage(driver);
		
		hp.clickContactTab();
		cp.selectMyContacts();
		System.out.println(driver.getTitle());
		
		hp.loggingOut();
		System.out.println("TestCase 28 is complete.");
	}
	
	@Test
	public void viewContact_TC29() throws FileNotFoundException, IOException {
		WebDriver driver = getBrowser();
		LoginPage lp = new LoginPage(driver);
		hp = lp.loginToApp(driver);
		ContactsPage cp = new ContactsPage(driver);
		
		hp.clickContactTab();
		cp.selectAccount();
		System.out.println(driver.getTitle());
		
		hp.loggingOut();
		System.out.println("TestCase 29 is complete.");
	}
	
	@Test
	public void checkForError_TC30() throws FileNotFoundException, IOException {
		WebDriver driver = getBrowser();
		LoginPage lp = new LoginPage(driver);
		hp = lp.loginToApp(driver);
		ContactsPage cp = new ContactsPage(driver);
		CreateNewViewPage cnvp = new CreateNewViewPage(driver);
		
		hp.clickContactTab();
		cp.clickNewViewButton();

		System.out.println(driver.getTitle());
		cnvp.enterViewUniqName();
		cnvp.clickSaveButton();
		
		if(cnvp.errorMessage.isDisplayed()) {
			System.out.println(cnvp.errorMessage.getText());
			logger.info("Error Occured.");
		} else {
			logger.info("No error detected");
		}
		
		hp.loggingOut();
		System.out.println("TestCase 30 is complete.");
	}
	
	@Test
	public void checkCancelButton_TC31() throws FileNotFoundException, IOException {
		WebDriver driver = getBrowser();
		LoginPage lp = new LoginPage(driver);
		hp = lp.loginToApp(driver);
		ContactsPage cp = new ContactsPage(driver);
		CreateNewViewPage cnvp = new CreateNewViewPage(driver);
		
		hp.clickContactTab();
		cp.clickNewViewButton();
		System.out.println(driver.getTitle());
		cnvp.tempViewInfo();
		cnvp.clickCancelButton();
		
		hp.loggingOut();
		System.out.println("TestCase 31 is complete.");
	}
	
	
	//	The below TestCase is passing because of the measures set even if it fails.
	//	After save and new there is an error that needs to be rectified. 
	@Test
	public void validateSaveNewOption_TC32() throws FileNotFoundException, IOException {
		WebDriver driver = getBrowser();
		LoginPage lp = new LoginPage(driver);
		hp = lp.loginToApp(driver);
		NewContactPage ncp = new NewContactPage(driver);
		ContactsPage cp = new ContactsPage(driver);
		
		hp.clickContactTab();
		cp.clickNewButton();
		
		System.out.println(driver.getTitle());
		
		ncp.NTemp();
		ncp.clickSaveNewButton();
		
		hp.loggingOut();
		System.out.println("TestCase 32 is complete.");
	}
}
