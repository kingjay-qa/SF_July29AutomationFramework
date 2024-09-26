package SF_TestsCase;

import java.io.FileNotFoundException;
import java.io.IOException;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import SF_Listeners.SF_Listening;
import SF_Pages.HomePage;
import SF_Pages.LoginPage;
import SF_Pages.NewAccountPage;

@Listeners(SF_Listening.class)
public class SF_CreateAccountTest extends SF_BaseTest{
	
	@Test() 
	public void createAnAccountw_TC10() throws FileNotFoundException, IOException {
		WebDriver driver = getBrowser();
		LoginPage lp = new LoginPage(driver);
		hp = lp.loginToApp(driver);
		hp.AccountClick();
		hp.newButton.click();
	
		NewAccountPage ap = new NewAccountPage(driver);
		ap.newAccountCreation();
		System.out.println("New Account Created.");
	}
	
	@Test() 
	public void createNewView_TC11() throws FileNotFoundException, IOException {
		WebDriver driver = getBrowser();
		LoginPage lp = new LoginPage(driver);
		hp = lp.loginToApp(driver);
		hp.AccountClick();
		
		NewAccountPage ap = new NewAccountPage(driver);
		ap.CNVEntries();
		System.out.println("Create New View has been created.");
	}
	
	@Test() 
	public void editView_TC12() throws FileNotFoundException, IOException {
		WebDriver driver = getBrowser();
		LoginPage lp = new LoginPage(driver);
		hp = lp.loginToApp(driver);
		hp.AccountClick();
		NewAccountPage ap = new NewAccountPage(driver);
		ap.editViewF();
		System.out.println("Test Case Complete");
	}
	
	@Test() 
	public void MergingAccounts_TC13() throws FileNotFoundException, IOException {
		WebDriver driver = getBrowser();
		LoginPage lp = new LoginPage(driver);
		hp = lp.loginToApp(driver);
		hp.AccountClick();
		NewAccountPage ap = new NewAccountPage(driver);
		
		ap.toBeMerged();
		Alert alert = driver.switchTo().alert();
		System.out.println(alert.getText());
		alert.accept();
		
		System.out.println(driver.getTitle());
		System.out.println("Test Case Complete");
	}
	
	@Test() 
	public void createAccountReport_TC14() throws FileNotFoundException, IOException {
		WebDriver driver = getBrowser();
		LoginPage lp = new LoginPage(driver);
		hp = lp.loginToApp(driver);
		hp.AccountClick();
		NewAccountPage ap = new NewAccountPage(driver);
		ap.accountReport();
		System.out.println("Test Case Complete");
	}
	
	@Test() 
	public void createAccountReport_TC15() throws FileNotFoundException, IOException {
		WebDriver driver = getBrowser();
		LoginPage lp = new LoginPage(driver);
		hp = lp.loginToApp(driver);
		hp.AccountClick();
		NewAccountPage ap = new NewAccountPage(driver);
		ap.accountReport();
		System.out.println("Test Case Complete");
	}
}


//	CNVEntries