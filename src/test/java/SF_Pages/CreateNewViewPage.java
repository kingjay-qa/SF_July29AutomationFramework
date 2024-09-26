package SF_Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CreateNewViewPage extends BasePage{

	public CreateNewViewPage(WebDriver driver) {
		super(driver);
	}
	
	@FindBy(id="fname")
	public WebElement viewName;
	
	public void enterViewName(String name) {
		this.viewName.sendKeys(name);
	}
	
	@FindBy(id="devname")
	public WebElement viewUniqName;
	
	public void enterViewUniqName() {
		viewUniqName.sendKeys("EFGH");
	}
	
	@FindBy(name="save")
	public WebElement saveButton;
	
	public void clickSaveButton() {
		saveButton.click();
		logger.info("Save button clicked");
	}
	
	@FindBy(name="cancel")
	public WebElement cancelButton;
	
	public void clickCancelButton() {
		cancelButton.click();
		logger.info("Cancel button has been clicked");
	}
	
	public void tempViewInfo() {
		viewName.sendKeys("Mike");
		logger.info("View Name Entered");
		viewUniqName.sendKeys("Sucre");
		logger.info("View Unique Name Entered");
	}
	
	@FindBy(xpath="//div[@class='requiredInput']//div[@class='errorMsg']")
	public WebElement errorMessage;
	
	
}
