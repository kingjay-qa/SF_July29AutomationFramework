package stepdefinitions;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import SF_Pages.HomePage;
import SF_Pages.LoginPage;
import SF_TestsCase.SF_BaseTest;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.*;

public class LoginSteps extends SF_BaseTest {
	WebDriver driver;
	LoginPage lp;
	
	@Before
	public void setup() {
		
	}
	
	@After
	public void tearDown() {
		driver.close();
	}

@Given("I landed on login page")
public void i_landed_on_login_page() {
	WebDriver driver = getDriver("chrome", false);
    lp = new LoginPage(driver);
    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    driver.get("https://login.salesforce.com");
	
}

@When("I entered valid username")
public void i_entered_valid_username() {
    lp.enterUsername("KingSodi");
}

@When("I entered valid password")
public void i_entered_valid_password() {
    lp.enterPassword("12345");
}

@When("clicked on login button")
public void clicked_on_login_button() {
    lp.clickLogin();
}

@Then("I shoulld be taken to homepage")
public void i_shoulld_be_taken_to_homepage() {
	HomePage hp = new HomePage(driver);
    Assert.assertTrue(hp.isHomePage());
}

@When("I entered invalid username")
public void i_entered_invalid_username() {
    lp.enterUsername("KingJay.com");
}

@When("I entered invalid password")
public void i_entered_invalid_password() {
    lp.enterPassword("12345@pretty");
}
   
@Then("I should be seeing an error message")
public void I_should_be_seeing_an_error_message() {
	String actualError = lp.getErrorMessage();
	String expectedError = "";
	Assert.assertTrue(actualError.equals(expectedError));
}

@Given("I want to go to {string}")
public void i_want_to_go_to_https_login_salesforce_com(String url) {
	System.out.println(url);
}

@When("I enter {string} and {string}")
public void i_enter_deanjay_and_passwording(String username, String pass) {
	System.out.println(username + ": password is: " + pass);
}

@Then("I click on the login button")
public void i_click_on_the_login_button() {
}

}
