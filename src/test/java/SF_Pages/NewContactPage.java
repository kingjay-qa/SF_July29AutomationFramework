package SF_Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class NewContactPage extends BasePage{

	public NewContactPage(WebDriver driver) {
		super(driver);
	}
	
	//	Contact Information 
	
	@FindBy(id="name_firstcon2")
	public WebElement name;
	
	@FindBy(id="name_lastcon2")
	public WebElement lastName;
	
	public void enterLastName(String lastname) {
		this.lastName.sendKeys(lastname);
		logger.info("User lastName entered");
	}
	
	@FindBy(id="con4")
	public WebElement accountName;
	
	public void enterAccountName(String alastname) {
		this.lastName.sendKeys(alastname);
		logger.info("Account Name entered");
	}
	
	public void NTemp() {
		lastName.sendKeys("Indian");
		logger.info("Last name entered");
		accountName.sendKeys("Global Media");
		logger.info("Account Name entered");
	}

	@FindBy(id="con5")
	public WebElement title;
	
	@FindBy(id="con6")
	public WebElement department;
	
	@FindBy(name="save")
	public WebElement saveButton;
	
	public void clickSave() {
		saveButton.click();
		logger.info("Save Button has been clicked");
	} 
	
	//	Required Information 
	
	@FindBy(id="con10")
	public WebElement phone;
	
	@FindBy(id="con13")
	public WebElement homePhone;
	
	@FindBy(name="save_new")
	public WebElement saveNewButton;
	
	public void clickSaveNewButton() {
		saveNewButton.click();
		logger.info("Save & New Button clicked");
		
		if(errorMessage.isDisplayed()) {
			System.out.println(errorMessage.getText());
			logger.info("Creation of Account FAILED");
		}else {
			System.out.println("Creation was successful.");
			logger.info("Account creation was successful");
		}
	}
	
	@FindBy(id="errorDiv_ep")
	public WebElement errorMessage;
	
	public void tempInfo() {
		lastName.sendKeys("Forbes");
		logger.info("Lastname Entered");
		accountName.sendKeys("Edge Communications");
		logger.info("Account Name Entered");
	}
}
