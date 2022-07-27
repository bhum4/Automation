package utility;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class Reports {
	
	public static ExtentReports GenerateReports () {
		
		ExtentSparkReporter htmlReports = new ExtentSparkReporter("extentreport.html");
		ExtentReports extent = new ExtentReports();
		extent.attachReporter(htmlReports);
		extent.setSystemInfo("Test","Zerodha");
		return extent;
		
	}

}
