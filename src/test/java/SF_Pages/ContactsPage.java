package SF_Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

public class ContactsPage extends BasePage{

	public ContactsPage(WebDriver driver) {
		super(driver);
	}
	
	@FindBy(name="new")
	public WebElement newButton;
	
	public void clickNewButton() {
		newButton.click();
		logger.info("New Button Clicked");
	}
	
	@FindBy(linkText = "Create New View")
	public WebElement newViewButton;
	
	public void clickNewViewButton() {
		newViewButton.click();
		logger.info("New View has been clicked.");
	}
	
	@FindBy(id="hotlist_mode")
	public WebElement optionsDropD;
	
	public void selectRecentlyCreated() {
		optionsDropD.click();
		
		Select sel = new Select(optionsDropD);
		sel.selectByValue("2");
		logger.info("Recently Created selected");
	}
	
	@FindBy(id="fcf")
	public WebElement viewDrop;
	
	public void selectMyContacts() {
		Select sel1 = new Select(viewDrop);
		sel1.selectByValue("00Bbm00000AbthZ");
		logger.info("My contacts selected");
	}
	
	@FindBy(xpath="//a[normalize-space()='Gonzalez, Rose']")
	public WebElement fAccount;
	
	public void selectAccount() {
		fAccount.click();
		logger.info("Account selected");
	}

}
