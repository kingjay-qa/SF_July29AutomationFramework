package SF_TestsCase;

import java.io.FileNotFoundException;
import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import SF_Listeners.SF_Listening;
import SF_Pages.LeadsPage;
import SF_Pages.LoginPage;

@Listeners(SF_Listening.class)
public class SF_LeadsTest extends SF_BaseTest{

	
	@Test() 
	public void leadsTab_TC20() throws FileNotFoundException, IOException {
		WebDriver driver = getBrowser();
		LoginPage lp = new LoginPage(driver);
		hp = lp.loginToApp(driver);
		hp.clickLeads();
		
		System.out.println(driver.getTitle());
		
		hp.loggingOut();
		System.out.println("Test Case 20 Complete");
	}
	
	@Test() 
	public void leadsSelectView_TC21() throws FileNotFoundException, IOException {
		WebDriver driver = getBrowser();
		LoginPage lp = new LoginPage(driver);
		LeadsPage ld = new LeadsPage(driver);
		hp = lp.loginToApp(driver);
		hp.clickLeads();
		System.out.println(driver.getTitle());
		
		ld.viewDrop.click();
		Assert.assertTrue(ld.verifyLeadsViewOptions(), "Lead View options should be verified");

		hp.loggingOut();
		System.out.println("Test Case 21 Complete");
	}
	
	@Test() 
	public void leadsdefaultView_TC22() throws FileNotFoundException, IOException {
		WebDriver driver = getBrowser();
		LoginPage lp = new LoginPage(driver);
		LeadsPage ld = new LeadsPage(driver);
		hp = lp.loginToApp(driver);
		hp.clickLeads();
		System.out.println(driver.getTitle());
		
			ld.viewDrop.click();
			logger.info("Leads view drop selected");
			ld.selectTodaysLeads();
			logger.info("Today's Leads Selected");	

		
			hp.loggingOut();
		
		
		lp.loginToApp(driver);
		hp.clickLeads();
		ld.selectTodaysLeads();
		System.out.println(driver.getTitle());	
		
		hp.loggingOut();	
		System.out.println("Test Case 22 Complete");
	}
	
	@Test() 
	public void TodaysleadsTab_TC23() throws FileNotFoundException, IOException {
		WebDriver driver = getBrowser();
		LoginPage lp = new LoginPage(driver);
		LeadsPage ld = new LeadsPage(driver);
		hp = lp.loginToApp(driver);
		hp.clickLeads();
		ld.selectTodaysLeads();
		
		System.out.println(driver.getTitle());
		
		hp.loggingOut();
		System.out.println("Test Case 23 Complete");
	}
	
	@Test() 
	public void TodaysleadsTab_TC24() throws FileNotFoundException, IOException {
		WebDriver driver = getBrowser();
		LoginPage lp = new LoginPage(driver);
		LeadsPage ld = new LeadsPage(driver);
		hp = lp.loginToApp(driver);
		hp.clickLeads();
		ld.newLeadClick();
		
		System.out.println(driver.getTitle());
		
		hp.loggingOut();
		System.out.println("Test Case 23 Complete");
	}

}
