package SF_Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import SF_Cona.SF_ConstantFiles;
import SF_Utilities.SF_ActionUtilities;
import SF_Utilities.SF_WaitUtilities;

public class MyProfilePage extends BasePage {

	public MyProfilePage(WebDriver driver) {
		super(driver);
	}

	@FindBy(xpath = "//a[@class='contactInfoLaunch editLink']")
	public WebElement editContactButton;

	@FindBy(xpath = "//div/h2[@id='contactInfoTitle']")
	public WebElement editProfilePopupwindow;

	@FindBy(id = "aboutTab")
	public WebElement aboutTab;

	@FindBy(xpath = "//input[@id='lastName']")
	public WebElement aboutTabLastName;

	@FindBy(xpath = "//*[@value='Save All']")
	public WebElement saveAllButton;

	@FindBy(xpath = "//*[@id='tailBreadcrumbNode']")
	public WebElement userProfilePageNameDisplay;

	// Postlink
	@FindBy(css = "#publishereditablearea")
	public WebElement postLink;

	@FindBy(xpath = "/html/body")
	public WebElement postTextArea;

	@FindBy(xpath = "//input[@id='publishersharebutton']")
	public WebElement shareButton;

	@FindBy(css = "[class=\"view highlight\"]")
	public WebElement newPostHighlight;

	// filelink

	@FindBy(xpath = "//*[@id='publisherAttachContentPost']")
	public WebElement filelink;

	@FindBy(xpath = "//a[@id='publisherAttachContentPost']/span[1]")
	public WebElement contentpost;

	@FindBy(css = "#chatterUploadFileAction")
	public WebElement uploadFile;

	@FindBy(css = "#chatterFile")
	public WebElement fileOpen;

	@FindBy(css = "#publishersharebutton")
	public WebElement publish;

	@FindBy(xpath = "//input[@value='Cancel Upload']")
	public WebElement cancelUpload;

	@FindBy(id = "uploadLink")
	public WebElement updateButton;
	
	// My Settings
	// personallink

	@FindBy(xpath = "//*[@id=\'PersonalInfo_font\']")
	public WebElement personallink;

	@FindBy(xpath = "//*[@id=\"LoginHistory_font\"]")
	public WebElement loginHistorylink;

	@FindBy(xpath = "//*[@id=\"RelatedUserLoginHistoryList_body\"]/div/a")
	public WebElement logindisplay;

	@FindBy(id = "contactInfoContentId")
	public WebElement iframeAboutTab;
	// Display&layoutlink

	@FindBy(xpath = "//*[@id=\"DisplayAndLayout_font\"]")
	public WebElement DisplayLayoutlink;

	@FindBy(id = "CustomizeTabs_font")
	public WebElement CustomizedTab;

	@FindBy(xpath = "//*[@id=\"p4\"]/option[9]")
	public WebElement customApp;

	@FindBy(xpath = "//*[@id=\"duel_select_0\"]/option[73]")
	public WebElement Availabletab;

	@FindBy(xpath = "//*[@id=\"duel_select_0_right\"]/img")
	public WebElement Add;

	@FindBy(xpath = "//*[@id=\"bottomButtonRow\"]/input[1]")
	public WebElement save;

	@FindBy(id = "tabBar")
	public WebElement tabList;

	// Emaillink

	@FindBy(xpath = "//*[@id=\"EmailSetup_font\"]")
	public WebElement Emaillink;

	@FindBy(id = "EmailSettings_font")
	public WebElement MyEmailSettings;

	@FindBy(id = "sender_name")
	public WebElement Emailname;

	@FindBy(xpath = "//*[@id=\"sender_email\"]")
	public WebElement Emailaddress;

	@FindBy(xpath = "//*[@id=\"useremailSection\"]/table/tbody/tr[7]/td[2]/div")
	public WebElement BCCradiobutton;

	@FindBy(xpath = "//*[@id=\"bottomButtonRow\"]/input[1]")
	public WebElement Saveonemail;

	// Calendar and Remainders
	@FindBy(id = "CalendarAndReminders_font")
	public WebElement CalendarAndReminders;

	@FindBy(xpath = "//*[@id=\"Reminders_font\"]")
	public WebElement ActivityRemainder;

	@FindBy(id = "testbtn")
	public WebElement OpenaTestRemainder;

	@FindBy(xpath = "//*[@id=\"summary\"]")
	public WebElement SampleEventPopup;

	@FindBy(css = "#displayBadge")
	public WebElement moderatorButton;

	@FindBy(id = "profileTab_sfdc.ProfilePlatformFeed")
	public WebElement profilePage;

	@FindBy(id = "contactTab")
	public WebElement contactTab;

	@FindBy(xpath = "//div[@class='cxfeeditem feeditem'][1]//p")
	public WebElement firstPostText;

	@FindBy(xpath = "(//*[@class='contentFileTitle'])[1]")
	public WebElement verifyFilePostElement;

	@FindBy(name = "j_id0:waitingForm")
	public WebElement spinnerIcon;

	@FindBy(id = "cropWaitingPage:croppingForm")
	public WebElement spinnerWhileCropping;

	@FindBy(id = "progressIcon")
	public WebElement fileUploadSpinner;

	/**
	 * @param driver
	 */
	public void clickEditProfile(WebDriver driver) {
		SF_WaitUtilities.explicitlyWaitForClickableElement(driver, this.editContactButton);
		this.editContactButton.click();
		logger.debug("Edit profile clicked");
	}

	/**
	 * @param driver
	 * @return
	 */
	public boolean verifyContactIframeAvailability(WebDriver driver) {
		boolean isIframeLoaded = false;
		if (SF_WaitUtilities.explicitlyWaitForClickableElement(driver, iframeAboutTab)) {
			driver.switchTo().frame(iframeAboutTab);
			if (aboutTab.isDisplayed() && contactTab.isDisplayed()) {
				isIframeLoaded = true;
				logger.debug("AboutTab and ContactTab are displayed");
			} else {
				System.out.println("Iframe Not loaded");
				logger.debug("Iframe did not load");
			}
		}
		return isIframeLoaded;
	}

	/**
	 * @param driver
	 * @return
	 */
	public boolean verifyAboutTab(WebDriver driver) {
		boolean isAboutTabVerified = true;
		String lastName = "King";
		this.aboutTab.click();
		logger.debug("MyProfilePage : verifyAboutTab : Error message is fetched");
		if (this.aboutTabLastName.isDisplayed()) {
			logger.debug("AboutTab last name visible");
			this.aboutTabLastName.clear();
			logger.debug("About last name cleared");
			this.aboutTabLastName.sendKeys(lastName);
			logger.debug("Last name has been sent");
		} else {
			isAboutTabVerified = false;
			logger.debug("About tab not showing");
		}
		this.saveAllButton.click();
		driver.switchTo().defaultContent();
		logger.debug("Returning to about tab");
		return isAboutTabVerified;
	}


	public boolean verifyLastNameChange() {
		String lastName = "King";
		boolean isLastNameChanged = true;
		if (!this.userProfilePageNameDisplay.getText().contains(lastName)) {
			isLastNameChanged = false;
		}
		logger.debug("Last name updated");
		return isLastNameChanged;
	}

	public boolean verifyCreatePost(WebDriver driver, String message) {
		boolean isPostCreated = false;
		if (postLink.isDisplayed()) {
			logger.debug("Post link displayed");
			postLink.click();
			logger.debug("Post  link clicked");
			driver.switchTo().frame(0);
			logger.debug("Switching frames");
			postTextArea.sendKeys(message);
			logger.debug("Post text has been sent");
			driver.switchTo().defaultContent();
			logger.debug("Switched to default page");
			if (shareButton.isDisplayed()) {
				logger.debug("Share button is visible");
				shareButton.click();
				logger.debug("Share button clicked");
			}
			if (SF_WaitUtilities.explicitlyWaitForVisibility(driver, this.newPostHighlight)) {
				isPostCreated = true;
				logger.debug("Post is visible");
			}
		}
		logger.debug("Post has been created");
		return isPostCreated;
	}

	public boolean verifyFileUpload(WebDriver driver) {
		boolean isFileUploaded = false;
		if (this.filelink.isDisplayed()) {
			this.filelink.click();
			logger.debug("File link has been clicked");
			this.uploadFile.click();
			logger.debug("Upload button has been clicked");
			this.fileOpen.sendKeys(SF_ConstantFiles.TEST_FILE_UPLOAD_PATH);
			logger.debug("Upload file has been selected");
			this.publish.click();
			logger.debug("File has been deployed");
			if (SF_WaitUtilities.explicitlyWaitForInVisibility(driver, this.cancelUpload)) {
				if (this.newPostHighlight.isDisplayed()) {
					logger.debug("File uploaded");
					isFileUploaded = true;
				}
			}
		}
		return isFileUploaded;
	}
	
	// Photo link

		@FindBy(xpath = "//*[@id=\"publisherAttachLinkPost\"]/span[1]")
		public WebElement photolink;

		@FindBy(id = "j_id0:uploadFileForm:uploadInputFile")
		public WebElement uploadphoto;

		@FindBy(name = "j_id0:uploadFileForm:uploadBtn")
		public WebElement uploadbutton;

		@FindBy(id = "publishersharebutton")
		public WebElement photosharebutton;

		@FindBy(id = "uploadPhotoContentId")
		public WebElement photoUploadIframe;

		@FindBy(xpath = "//input[@id='j_id0:uploadFileForm:uploadBtn']")
		public WebElement photoSaveButton;

		@FindBy(xpath = "//input[@id='j_id0:j_id7:save']")
		public WebElement photoSaveButton2;
	
		
		public void clickOnAddPhoto(WebDriver driver) {
			SF_ActionUtilities.mouseHover(driver, this.moderatorButton);
			this.updateButton.click();
			logger.debug("Update photo has been clicked");
		}
		
	public boolean verifyAddPhoto(WebDriver driver) {
		boolean isPhotoUploaded = false;
		driver.switchTo().frame(photoUploadIframe);
		logger.debug("Frame has been switched");
		
		if(SF_WaitUtilities.explicitlyWaitForClickableElement(driver, this.uploadphoto)) {
//			this.photolink.click();
			this.uploadphoto.sendKeys(SF_ConstantFiles.TEST_PHOTO_UPLOAD_PATH);
			logger.debug("Photo has been selected");
			this.photoSaveButton.click();
			logger.debug("Photo has been uploaded");
			if(SF_WaitUtilities.explicitlyWaitForInVisibility(driver, this.spinnerIcon)) {
				this.photoSaveButton2.click();
				logger.debug("Send okay button for photo buttin has be clicked");
			}
			if(SF_WaitUtilities.explicitlyWaitForInVisibility(driver, this.spinnerWhileCropping)) {
				isPhotoUploaded = true;
				logger.debug("Photo upload complete");
			}
		}
		driver.switchTo().defaultContent();
		return isPhotoUploaded;
		
	}
}
