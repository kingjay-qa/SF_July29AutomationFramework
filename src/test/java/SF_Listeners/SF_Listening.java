package SF_Listeners;

import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.Status;

import SF_TestsCase.SF_BaseTest;
import SF_Utilities.SF_CommonUtilities;

public class SF_Listening implements ITestListener{
public void onTestStart(ITestResult result) {
		
	}

	public void onTestFailure(ITestResult result) {
		SF_BaseTest.test.get().addScreenCaptureFromPath(SF_CommonUtilities.captureScreenshot(SF_BaseTest.getBrowser()));
		SF_BaseTest.test.get().log(Status.FAIL, result.getName()+" FAILED");
	}

	public void onTestSuccess(ITestResult result) {
		SF_BaseTest.test.get().log(Status.PASS, result.getName()+" PASSED");
		
	}
}
