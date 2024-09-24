package SF_Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class OpportunitiesPage extends BasePage{

	public OpportunitiesPage(WebDriver driver) {
		super(driver);
	}
	
	@FindBy(name="fcf")
	public WebElement optDrop;
	
	@FindBy(name="new")
	public WebElement newOpty;
	
	@FindBy(id="opp3")
	public WebElement opName;
	
	@FindBy(id="opp4")
	public WebElement accName;
	
	@FindBy(id="opp9")
	public WebElement closeDate;

	
	
	public void OpporDropDown() {
		if(optDrop.isDisplayed()) {
			System.out.println("The dropdown is displayed.");
		} else {
			System.out.println("The dropdown is not available.");
		}
	}
	public void newOpt() {
		newOpty.click();
	}
	
	// Under Reports Locations
	
	@FindBy(linkText="Opportunity Pipeline")
	public WebElement opportunityPiplineLink;
	
	@FindBy(linkText="Stuck Opportunities")
	public WebElement stuckOpportunitiesLink;
	
	@FindBy(linkText="Closed Opportunities")
	public WebElement closedOpportunitiesLink;
	
	@FindBy(linkText="Opportunity Field History Report")
	public WebElement opportunityFieldHistoryReportLink;
	
	
	//	Under Reports Locations Complete
	
	//	Calling above locations 
	
	public void opportunityPipeLink() {
		opportunityPiplineLink.clear();
	}
	
	public void stuckOpportunities() {
		stuckOpportunitiesLink.click();
	}
	
	public void closedOpportunities() {
		closedOpportunitiesLink.click();
	}
	
	public void fieldOppHistory() {
		opportunityFieldHistoryReportLink.click();
	}
	
	//	 Calling complete 

}
