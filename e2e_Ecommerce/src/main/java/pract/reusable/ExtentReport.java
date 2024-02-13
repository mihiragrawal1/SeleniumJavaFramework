package pract.reusable;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentReport {
	
	ExtentReports report;
	public ExtentReports reportConfig()
	{
		
	
	String path = System.getProperty("user.dir") + "//reports//index.html";
	ExtentSparkReporter reporter=new ExtentSparkReporter(path);
	reporter.config().setReportName("Test-Automation Report");
	reporter.config().setDocumentTitle("Pact-proj Test Report");
	
	
	
	report=new ExtentReports();
	report.attachReporter(reporter);
	report.setSystemInfo("Tester", "Mihir");
	
	return report;
	
	
	
			
	}
	
}
