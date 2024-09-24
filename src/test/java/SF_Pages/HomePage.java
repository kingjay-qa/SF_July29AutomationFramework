package SF_Pages;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import SF_Utilities.SF_FileUtilities;

public class HomePage extends BasePage{
	
	public HomePage (WebDriver driver) {
		super(driver);
	}
	@FindBy(xpath = "//h2[text()='Community']")
	public WebElement communityPanel;

	@FindBy(id = "userNavButton")
	public WebElement userMenu;

	@FindBy(xpath = "//*[@id='userNav-menuItems']/a")
	public List<WebElement> userMenuOptions;
	
	@FindBy(xpath = "//*[@id='userNav-menuItems']/a[1]")
	public WebElement myProfile;
	
	@FindBy(xpath = "//*[@id='userNav-menuItems']/a[2]")
	public WebElement mySettings;
	
	@FindBy(xpath = "//*[@id='userNav-menuItems']/a[3]")
	public WebElement developerConsole;
	
	@FindBy(xpath = "//*[@id='userNav-menuItems']/a[4]")
	public WebElement switchToLightningExperience;
	
	@FindBy(xpath = "//*[@id='userNav-menuItems']/a[5]")
	public WebElement logOut;

	public boolean isHomePage() {
		logger.debug("Home Page should be displayed");
		return this.communityPanel.isDisplayed();
	}

	public void clickUserMenu() {
		this.userMenu.click();
		logger.debug("User Menu clicked");
	}

	public MyProfilePage selectMyProfilePage(WebDriver driver) {
		this.myProfile.click();
		logger.debug("My profile should be displayed");
		return new MyProfilePage(driver);
	}
	
	public MySettingsPage selectMySettingsPage(WebDriver driver) {
		this.mySettings.click();
		logger.debug("My settings should be displayed");
		return new MySettingsPage(driver);
	}
	
	public void DevConsole(WebDriver driver) {
		String origWindow = driver.getWindowHandle();
		System.out.println("\nTest ID: TC08 Running...\n");
		this.developerConsole.click();
		logger.debug("Developer Console should be displayed");
Set <String> allWindows = driver.getWindowHandles();
		
		for(String windowHand : allWindows) {
			if(!windowHand.equals(origWindow)) {
				driver.switchTo().window(windowHand);
				break;
			}
		} 
		System.out.println(driver.getTitle());
		driver.close();
		driver.switchTo().window(origWindow);
		logger.debug("Original window should be displayed");
		System.out.println("New WindowClose Complete. \n");

	}
	
	public void Logout() {
		this.logOut.click();
		logger.debug("Logout haas been clicked");
	}
	
	public boolean verifyUserMenuOptions() throws FileNotFoundException, IOException {
		boolean isUserMenuOptionsVerified = true;
		String[] expectedUserMenuOptions = SF_FileUtilities.readLoginPropertiesFile("usermenu.options").split(",");
		for (int i = 0; i < expectedUserMenuOptions.length; i++) {
			if (expectedUserMenuOptions[i].equals(userMenuOptions.get(i).getText())) {
				System.out.println(
						"Expected: " + expectedUserMenuOptions[i] + " Actual: " + userMenuOptions.get(i).getText());
				logger.debug("Expected User Menu options have been verified");
			} else {
				isUserMenuOptionsVerified = false;
				logger.debug("Expected User Menu options not correct");
			}
		}
		return isUserMenuOptionsVerified;
	}
	
	@FindBy(id="Account_Tab")
	public WebElement accountsTab;
	
	@FindBy(name="new")
	public WebElement newButton;
	
	public void AccountClick() {
		accountsTab.click();
	}
	
	@FindBy(linkText = "Opportunities")
	public WebElement Opportunities;
	
	@FindBy(linkText = "Contact")
	public WebElement Contact;
	
	@FindBy(name="fcf")
	public WebElement oppDropD;
	
	
//	Leads 
	@FindBy(css = "#Lead_Tab")
	public WebElement leadsTab;
	
	public void clickLeads() {
		leadsTab.click();
	}
	
	public void loggingOut() {
		userMenu.click();
		logger.info("User Menu Selected");
		logOut.click();
		logger.info("Logout has been clicked");
	}

}
