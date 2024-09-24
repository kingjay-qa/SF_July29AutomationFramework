package SF_Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MySettingsPage extends BasePage{
	public MySettingsPage(WebDriver driver) {
		super(driver);
	}
	
	@FindBy(id="PersonalInfo_font")
	public WebElement personalLink;
	
	@FindBy(id="LoginHistory_font")
	public WebElement loginHistoryButton;
	
	@FindBy (xpath = "//a[contains(text(),'Download login history for last six months, includ')]")
	public WebElement loginHistoryLink;
	
	@FindBy(id="DisplayAndLayout_font")
	public WebElement displayNlayoutButton;
	
	@FindBy(id="CustomizeTabs_font")
	public WebElement customizeTabsButton;
	
	public void settingsSteps() {
		//	Personal Link 
		personalLink.click();
		logger.debug("Personal link clicked");
		loginHistoryButton.click();
		logger.debug("Login history has been clicked");
		loginHistoryLink.click();
		logger.debug("History has been downloaded");
		
		// 	displayNlayout 
		displayNlayoutButton.click();
		logger.debug("Display and Layout has bee clicked");
		customizeTabsButton.click();
		logger.debug("Customize button has been clicked");
		
	}
	
}
