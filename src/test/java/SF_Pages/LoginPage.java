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
}
public void LoggedError() {
	loginError.getText();
}

public void enterPassword(String passWord) {
	this.password.sendKeys(passWord);
}

public String getErrorMessage() {
	return this.loginError.getText();
}

public void clickLogin() {
	this.loginBtn.click();
}

public void clickContinue() {
	this.forgotPassWordSubmitButton.click();
}

public String getValueAttribute(WebElement element) {
	return element.getAttribute("value");
}
public void forgotPassUserName(String forgotten) {
	this.forgotPassUsername.sendKeys(forgotten);
}

public HomePage loginToApp(WebDriver driver) throws FileNotFoundException, IOException {
	driver.navigate().to(SF_FileUtilities.readLoginPropertiesFile("production.url"));
	logger.debug("Navigated to the login page");
	this.enterUsername(SF_FileUtilities.readLoginPropertiesFile("valid.username"));
	this.enterPassword(SF_FileUtilities.readLoginPropertiesFile("valid.password"));
	this.clickLogin();
	return new HomePage(driver);
}
}
