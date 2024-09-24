package SF_Pages;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

import SF_Utilities.SF_FileUtilities;


public class LeadsPage extends BasePage{
	
	public LeadsPage (WebDriver driver) {
		super(driver);
	}
	
	@FindBy(id="fcf")
	public List<WebElement> leadsView;
	
	@FindBy(id = "fcf")
	public WebElement viewDrop;
	
	
	public boolean verifyLeadsViewOptions() throws FileNotFoundException, IOException {
		boolean isLeadsViewVerified = true;
		String[] expectedOptions = SF_FileUtilities.readLoginPropertiesFile("leadsview.options").split(",");
		for (int i = 0; i < expectedOptions.length; i++) {
			if (expectedOptions[i].equals(leadsView.get(i).getText())) {
				System.out.println(
						"Expected: " + expectedOptions[i] + " Actual: " + leadsView.get(i).getText());
				logger.debug("Expected User Menu options have been verified");
			} else {
				isLeadsViewVerified = false;
				logger.debug("Expected User Menu options not correct");
			}
		}
		return isLeadsViewVerified;
	}
	
	public void selectTodaysLeads() {
		Select sel = new Select(viewDrop);
		sel.selectByValue("00Bbm00000AbtaQ");
	}
	
}
