package SF_Utilities;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

import SF_Cona.SF_ConstantFiles;

public class SF_ReportManager {
	private SF_ReportManager() {

	}

	private static ExtentReports extent;

	public static ExtentReports getInstance() {
		if (extent == null) {
			createInstance(SF_ConstantFiles.REPORTS_FILE_PATH);
		}
		return extent;
	}

	private static ExtentReports createInstance(String fileName) {
		ExtentSparkReporter sparkReport = new ExtentSparkReporter(fileName);
		sparkReport.config().setTheme(Theme.DARK);
		sparkReport.config().setDocumentTitle("SFDC Automation Report");
		sparkReport.config().setEncoding("utf-8");
		extent = new ExtentReports();
		extent.attachReporter(sparkReport);
		return extent;
	}

}
