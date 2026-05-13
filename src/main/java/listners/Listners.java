package listners;

import java.io.File;
import java.io.IOException;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ISuite;
import org.testng.ISuiteListener;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.Reporter;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

import Baseclass_utility.Baseclass;


public class Listners implements ISuiteListener, ITestListener {
	
	public ExtentReports report;
	public static ExtentTest test;

	public void onTestStart(ITestResult result) {
		String testname = result.getMethod().getMethodName();
		String time = new Date().toString().replace(" ", "_").replace(":", "_");

		//create test
		 test = report.createTest(testname+time);
		 UtilityObjectclass.setTest(test);
		test.log(Status.INFO, testname + " : Test execution started");
		//Reporter.log(testname + " : Test execution started",true);
		
		
	}

	public void onTestSuccess(ITestResult result) {
		String testname = result.getMethod().getMethodName();
		test.log(Status.PASS, testname + " : Test execution success");

		//Reporter.log(testname + " : Test execution sucess",true);
		
	}

	public void onTestFailure(ITestResult result) {
		String testname = result.getMethod().getMethodName();
		String time = new Date().toString().replace(" ","_").replace(":","_");
		test.log(Status.FAIL, testname + " : Test execution fail- screenshot");

		//Reporter.log(testname + " : Test execution failure - screenshot",true);
		
		
		TakesScreenshot ts = (TakesScreenshot) Baseclass.sdriver;
		
		
//				File src = ts.getScreenshotAs(OutputType.FILE);
//		File dest = new File("./Screenshot/vtiger.png");
//		try {
//			FileUtils.copyFile(src, dest);
//			
//		}catch(IOException e) {
//			Reporter.log(testname + " : screenshot not captured",true);
//		}
//		
		String src = ts.getScreenshotAs(OutputType.BASE64);
		test.addScreenCaptureFromBase64String(src, testname + "_" + time);
		
		
	}

	

	public void onTestSkipped(ITestResult result) {
		// TODO Auto-generated method stub
		String testname = result.getMethod().getMethodName();
		//Reporter.log(testname + " : test execution skipped",true);
		test.log(Status.WARNING, testname + " : Test execution skipped");

		
		
		
	}

	public void onStart(ISuite suite) {
		Reporter.log("suite execution started -adv report configuration", true);
	
		
		//configure the report
		String time = new Date().toString().replace(" ", "_").replace(":", "_");

		ExtentSparkReporter spark = new ExtentSparkReporter("./AdvancedReports/Vtiger"+time+".html");
		spark.config().setDocumentTitle("Reports of CRM Vtiger");
		spark.config().setReportName("Vtiger contact_org reports");
		spark.config().setTheme(Theme.DARK);
		
		 report = new ExtentReports();
		report.attachReporter(spark);
		report.setSystemInfo("Browser", "chrome-148.0.7778.96");
		report.setSystemInfo("os", "windows - 11th Gen");
	
	
	}


	
	
	
	
	
	public void onFinish(ISuite suite) {
		//Reporter.log("suite execution finish - report backup",true);
		test.log(Status.INFO, "suite execution finished-report backup");
		report.flush();
	}

	
	
	
	
}
