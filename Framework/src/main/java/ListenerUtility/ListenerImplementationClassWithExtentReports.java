package ListenerUtility;


import java.io.File;
import java.io.IOException;
 

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.io.FileHandler;
import org.testng.ISuite;
import org.testng.ISuiteListener;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.Reporter;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

import BaseClass.BaseClass;
import GenericUtility.JavaUtility;

public class ListenerImplementationClassWithExtentReports implements ISuiteListener, ITestListener {
	
	public ExtentReports report;
	public ExtentTest test;
	
	@Override
	public void onStart(ISuite suite) {
		Reporter.log("Report Configuration", true);
		JavaUtility jutil=new JavaUtility();
		String currentTiime = jutil.getSystemDateAndTimeForScreenshot();
		//==================EXTENT REPORTS==============
		ExtentSparkReporter spark=new ExtentSparkReporter("./AdvanceReport/Report_"+currentTiime+".html");
		spark.config().setDocumentTitle("Ninza CRM");
		spark.config().setReportName("NCRM Test Execution Report");
		spark.config().setTheme(Theme.STANDARD);
		//===============================================
		report=new ExtentReports();
		report.attachReporter(spark);
		report.setSystemInfo("OS", "Windows");
		report.setSystemInfo("Browser", "Firefox");
		report.setSystemInfo("Author", "Sita");
		
		
	}
	

	@Override
	public void onTestStart(ITestResult result) {
		String methodName=result.getMethod().getMethodName();
		Reporter.log("=========="+methodName+"====STARTED======",true);
		
		test=report.createTest(methodName);
		test.log(Status.INFO, "===="+methodName+"====STARTED====");
		
		
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		String methodName=result.getMethod().getMethodName();
		//Reporter.log("=========="+methodName+"====SUCCESS======",true);
		test.log(Status.INFO, "===="+methodName+"====SUCCESS====");
	
	}

	@Override
	public void onTestFailure(ITestResult result) {
		String methodName=result.getMethod().getMethodName();
		JavaUtility jutil=new JavaUtility();
		String dateTime=jutil.getSystemDateAndTimeForScreenshot();
		test=report.createTest(methodName);
				
		TakesScreenshot tks=(TakesScreenshot)BaseClass.sDriver;
		String temp = tks.getScreenshotAs(OutputType.BASE64);
		
		test.addScreenCaptureFromBase64String(temp,methodName+"_"+dateTime);
		test.log(Status.FAIL, "===="+methodName+"====Failed====");
		
		
		
		/*File temp=tks.getScreenshotAs(OutputType.FILE);
		File perm=new File("./ErrorScreens/"+methodName+dateTime+".png");
		try {
			FileHandler.copy(temp, perm);
			
		} catch(IOException e)
		{
			e.printStackTrace();
		}*/
		Reporter.log("=========="+methodName+"====FAILED======",true);
		
		 
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		String methodName=result.getMethod().getMethodName();
		Reporter.log("=========="+methodName+"====SKIPPED======",true);
	}

 
	@Override
	public void onFinish(ISuite suite) {
		report.flush();
		Reporter.log("==========REPORTBACKUP==========",true);
	}

}
