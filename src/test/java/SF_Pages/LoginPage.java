package SF_Pages;

import java.io.FileNotFoundException;
import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import SF_Utilities.SF_FileUtilities;


public class LoginPage extends BasePage {
	
	public LoginPage(WebDriver driver) {
		super(driver);
	}
	
	@FindBy(id="error")
	public WebElement loginError;
	
	@FindBy(id = "username")
	public WebElement userName;
	
	@FindBy(id = "password")
	public WebElement password;
	
	@FindBy(id = "rememberUn")
	public WebElement rememberMe;
	
	@FindBy(id="forgot_password_link")
	public WebElement forgotPassword;
	
	@FindBy(id = "Login")
	public WebElement loginBtn;
	
	@FindBy(id="continue")
	public WebElement forgotPassWordSubmitButton;
	
	@FindBy(id="un")
	public WebElement forgotPassUsername;

public void enterUsername(String username) {
	this.userName.sendKeys(username);
	logger.debug("User name has been entered");
}
public void LoggedError() {
	loginError.getText();
	logger.debug("Login error text available");
}

public void enterPassword(String passWord) {
	this.password.sendKeys(passWord);
	logger.debug("Password entered");
}

public String getErrorMessage() {
	return this.loginError.getText();
}

public void clickLogin() {
	this.loginBtn.click();
	logger.debug("Login button clicked");
}

public void clickContinue() {
	this.forgotPassWordSubmitButton.click();
	logger.debug("Forgot Password button has been clicked");
}

public String getValueAttribute(WebElement element) {
	return element.getAttribute("value");
}
public void forgotPassUserName(String forgotten) {
	this.forgotPassUsername.sendKeys(forgotten);
	logger.debug("Forgot password username pass has been entered");
}

public HomePage loginToApp(WebDriver driver) throws FileNotFoundException, IOException {
	driver.navigate().to(SF_FileUtilities.readLoginPropertiesFile("production.url"));
	logger.debug("Login page deployed");
	this.enterUsername(SF_FileUtilities.readLoginPropertiesFile("valid.username"));
	logger.debug("Username entered");
	this.enterPassword(SF_FileUtilities.readLoginPropertiesFile("valid.password"));
	logger.debug("Password entered");
	this.clickLogin();
	logger.debug("Login buttin clicked");
	return new HomePage(driver);
}
}
