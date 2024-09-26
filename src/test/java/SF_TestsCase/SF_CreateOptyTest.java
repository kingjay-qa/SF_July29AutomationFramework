package SF_TestsCase;

import java.io.FileNotFoundException;
import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import SF_Listeners.SF_Listening;
import SF_Pages.LoginPage;
import SF_Pages.OpportunitiesPage;

@Listeners(SF_Listening.class)
public class SF_CreateOptyTest extends SF_BaseTest{
	@Test()
	public void OpportunitiesDropDown_TC15() throws FileNotFoundException, IOException {
		WebDriver driver = getBrowser();
		LoginPage lp = new LoginPage(driver);
		hp = lp.loginToApp(driver);
		
		hp.Opportunities.click();
		OpportunitiesPage op = new OpportunitiesPage(driver);
		op.OpporDropDown();
		System.out.println("Test Case 15 Complete");
	}
	
	@Test()
	public void createNewOpty_TC16() throws FileNotFoundException, IOException {
		WebDriver driver = getBrowser();
		LoginPage lp = new LoginPage(driver);
		hp = lp.loginToApp(driver);
		
		hp.Opportunities.click();
		OpportunitiesPage op = new OpportunitiesPage(driver);
		op.newOpt();
		System.out.println("Test Case 16 Complete");
	}
	
	@Test()
	public void testOpportunityPipeLineReport_TC17() throws FileNotFoundException, IOException {
		WebDriver driver = getBrowser();
		LoginPage lp = new LoginPage(driver);
		hp = lp.loginToApp(driver);
		
		hp.Opportunities.click();
		OpportunitiesPage op = new OpportunitiesPage(driver);
		op.opportunityPipeLink();
		System.out.println(driver.getTitle());
		System.out.println("Test Case 17 Complete");
	}
	
	@Test()
	public void testStuckOpportunitiesReport_TC18() throws FileNotFoundException, IOException {
		WebDriver driver = getBrowser();
		LoginPage lp = new LoginPage(driver);
		hp = lp.loginToApp(driver);
		
		hp.Opportunities.click();
		OpportunitiesPage op = new OpportunitiesPage(driver);
		op.stuckOpportunities();
		System.out.println(driver.getTitle());
		System.out.println("Test Case 18 Complete");
	}
}
