package SF_Pages;

import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

public class CustomizeMyTabsPage extends BasePage {
	
	public CustomizeMyTabsPage(WebDriver driver) {
		super(driver);
	}
	
	
	@FindBy(id="p4")
	public WebElement CustomApp;
	
	@FindBy(css = "option[value='report']")
	public WebElement ReportsBtm;
	
	@FindBy(css = "img[title='Add']")
	public WebElement aaddButton;
	
	@FindBy(css = "duel_select_1")
	public WebElement selectedTabsVeri;
	
	@FindBy(name = "save")
	public WebElement saveButton;
	
	public void customAppDropD(WebDriver driver) {
		Select select = new Select(CustomApp);
		select.selectByVisibleText("Salesforce Chatter");
		logger.debug("Salesforce chatter has been selected");
		
		ReportsBtm.click();
		logger.debug("Reports has been clicked");
		aaddButton.click();
		logger.debug("Add button clicked");
	//	System.out.println(selectedTabsVeri.getText());
		System.out.println(driver.findElement(By.id("duel_select_1")).getText());
		saveButton.click();
		logger.debug("Saved button clicked");
	}
	
	@FindBy(id="EmailSetup_font")
	public WebElement emailBtn;
	
	@FindBy(id="EmailSettings_font")
	public WebElement emailSettings;
	
	@FindBy (id="sender_name")
	public WebElement emailName;
	
	@FindBy (id="sender_email")
	public WebElement emailAddress;
	
	@FindBy (id="auto_bcc1")
	public WebElement autoBccBtn;
	
	public void emailNameUpdate() {
		emailBtn.click();
		logger.debug("Email button has been clicked");
		emailSettings.click();
		logger.debug("Email settings selected");
		
		if(emailName.isDisplayed()) {
			emailName.clear();
			logger.debug("Email name has been cleared");
			emailName.sendKeys("King Jay");
			logger.debug("String 'Dean Jay' has been sent by sendkeys");
			emailAddress.clear();
			logger.debug("Email address field cleared");
			emailAddress.sendKeys("zhanjejay@gmail.com");
			logger.debug("Email address updated to 'zhanjejay@gmail.com'");
			
			autoBccBtn.click();
			logger.debug("Auto BCC has been selected");
			System.out.println("Email Name and Address populated accordingly");
		}
	}
	
	@FindBy (id="CalendarAndReminders_font")
	public WebElement calendarRemindersBtn;
	
	@FindBy (id="Reminders_font")
	public WebElement activityRemindersBtn;
	
	@FindBy (id="testbtn")
	public WebElement testRemindBtn;
	
	public void calendarReminder(WebDriver driver) {
		calendarRemindersBtn.click();
		activityRemindersBtn.click();
		testRemindBtn.click();
	
		String origWindow = driver.getWindowHandle();		
Set <String> allWindows = driver.getWindowHandles();
		
		for(String windowHand : allWindows) {
			if(!windowHand.equals(origWindow)) {
				driver.switchTo().window(windowHand);
				break;
			}
		} 
		System.out.println(driver.getTitle());
		driver.close();
	}
}
