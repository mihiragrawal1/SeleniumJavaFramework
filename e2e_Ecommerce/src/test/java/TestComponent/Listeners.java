package TestComponent;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;

import pract.reusable.ExtentReport;

public class Listeners implements ITestListener{
	
	ExtentReport reportObj=new ExtentReport();
	ExtentReports extent=reportObj.reportConfig();
	
	ExtentTest test;
	
	
	@Override
	public void onTestStart(ITestResult result)
	{
		
		test=extent.createTest(result.getMethod().getMethodName());
	}
	
	
	@Override
	public void onFinish(ITestContext context)
	{
		extent.flush();
	}
	
	@Override
	public void onTestFailure(ITestResult result) {
		
		test.fail(result.getThrowable());
	}
	
	
	

}
