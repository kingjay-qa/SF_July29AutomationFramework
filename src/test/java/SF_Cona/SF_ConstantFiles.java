package SF_Cona;

import SF_Utilities.SF_CommonUtilities;

public class SF_ConstantFiles {
	
	public static String ROOT_PATH = System.getProperty("user.dir");
	public static final String LOGIN_TEST_DATA_FILE_PATH = ROOT_PATH + "/src/test/java\\SF_TestCredentials/logintestdata.properties";
	public static final String LEADS_LINK_DROPDOWN = ROOT_PATH + "/src/test/java\\SF_TestCredentials/logintestdata.properties";
	
	public static final String HOME_TEST_DATA_FILE_PATH = ROOT_PATH + "/src/test/java/testData/hometestdata.properties";
	public static final String TEST_FILE_UPLOAD_PATH = ROOT_PATH+"/src/test/resources/Code.docx";
	public static final String TEST_PHOTO_UPLOAD_PATH = ROOT_PATH+"/src/test/resources/FIFA-22.jpg";
	public static final String SCREENSHOTS_FOLDER_PATH = ROOT_PATH+"/src/test/resources/Reports/"+SF_CommonUtilities.getTimeStamp()+"_SFDC.PNG";
	public static final String REPORTS_FILE_PATH = ROOT_PATH+"/src/test/resources/Reports/"+SF_CommonUtilities.getTimeStamp()+"_SFDC.html";
	
} 	


