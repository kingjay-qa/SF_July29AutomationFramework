package SF_Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

public class NewAccountPage extends BasePage {

	public NewAccountPage(WebDriver driver) {
		super(driver);
	}
	
	@FindBy(id="acc2")
	public WebElement accountName;
	
	@FindBy(name="save")
	public WebElement saveButton;
	
	public void newAccountCreation() {
		logger.debug("New Account Creation");
		accountName.sendKeys("Alexis");
		logger.debug("Account name sent through send keys 'Alexis' ");
		saveButton.click();
		logger.debug("Save button clicked");
	}
	
	@FindBy(linkText = "Create New View")
	public WebElement CreateNewView;
	
	@FindBy(id="fname")
	public WebElement viewName;
	
	@FindBy(id="devname")
	public WebElement viewUniqueName;
	
	public void CNVEntries() {
		CreateNewView.click();
		viewName.sendKeys("Bose");
		viewUniqueName.sendKeys("Sound");
		saveButton.click();
	}
	
	@FindBy(id="fcf")
	public WebElement viewDropDown;
	
	@FindBy(linkText = "Edit")
	public WebElement EditButton;
	
	@FindBy(linkText = "Merge Accounts")
	public WebElement MergeAccounts;
	
	@FindBy(id = "fcol1")
	public WebElement filterField;
	
	@FindBy(id = "fop1")
	public WebElement containsOpt;
	
	@FindBy(id = "fval1")
	public WebElement valueOpt;
	
	@FindBy(id="srch")
	public WebElement nameSearch;
	
	@FindBy(name="srchbutton")
	public WebElement searchButton;
	
	@FindBy(name="goNext")
	public WebElement nextButton;
	
	@FindBy(css = "a[id='colselector_select_0_right'] img[title='Add']")
	public WebElement mvRight;
	
	@FindBy(css = "select[id='colselector_select_0'] option[value='ACCOUNT.LAST_ACTIVITY']")
	public WebElement AVField;
	
	@FindBy(linkText="Accounts with last activity > 30 days")
	public WebElement lastActivity;
	
	@FindBy(id="ext-gen148")
	public WebElement dateDrop;
	
	@FindBy(css="div[id='ext-gen264'] div:nth-child(3)")
	public WebElement createdDateBtn;
	
	@FindBy(name="startDate")
	public WebElement startDate;
	
	@FindBy(name="endDate")
	public WebElement endDate;
	
	@FindBy(id="ext-gen49")
	public WebElement saveBt;
	
	@FindBy(id="saveReportDlg_reportNameField")
	public WebElement reportName;
	
	@FindBy(id="saveReportDlg_DeveloperName")
	public WebElement reportUniqName;
	
	@FindBy(id="ext-gen303")
	public WebElement saveNrun;
	
	public void editViewF() {
		Select s1 = new Select(viewDropDown);
		s1.selectByVisibleText("Panda");
		EditButton.click();
		viewName.clear();
		viewName.sendKeys("NewPanda");
		
		Select s2 = new Select(filterField);
		s2.selectByVisibleText("Account Name");
		
		Select s3 = new Select(containsOpt);
		s3.selectByVisibleText("contains");
		
		valueOpt.clear();
		valueOpt.sendKeys("a");
		
		AVField.click();
		mvRight.click();
		saveButton.click();
	}
	public void toBeMerged() {
		MergeAccounts.click();
		nameSearch.sendKeys("Mike");
		searchButton.click();
		nextButton.click();
		saveButton.click();
		
	}
	public void accountReport() {
		lastActivity.click();
		dateDrop.click();
		createdDateBtn.click();
		
		startDate.clear();
		startDate.sendKeys("09/15/2024");
		
		endDate.clear();
		endDate.sendKeys("09/15/2024");
		saveBt.click();
		
		reportName.sendKeys("Joey");
		reportUniqName.sendKeys("Friendly");
		saveNrun.click();
		
	}

}
