package utils;

import org.openqa.selenium.WebDriver;
import org.testng.ISuiteListener;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import pages.BasePage;

public class CustomListener extends BasePage implements ITestListener, ISuiteListener {
	ExtentTest test;
	ExtentReports extent = ExtentReporterNG.getReportObject(); // get Extent object

	public void onTestStart(ITestResult result) {
		System.out.println("onTestStart method executed : " + result.getMethod().getMethodName());
		test = extent.createTest(result.getMethod().getMethodName());
	}

	public void onTestSuccess(ITestResult result) {
		System.out.println("*** onTestSuccess method executed : " + result.getName());
		test.log(Status.PASS, "Test Case Passed");
	}

	public void onTestFailure(ITestResult result) {
		System.out.println("###########  onTestFailure method executed " + result.getMethod());

		test.fail(result.getThrowable());
		// screenshot and attach to report
		try {
			driver = (WebDriver) result.getTestClass().getRealClass().getField("driver").get(result.getInstance());
		} catch (Exception e) {
			e.printStackTrace();
		}

		String filePath = getScreenshot(result.getMethod().getMethodName(), driver);
		test.addScreenCaptureFromPath(filePath, result.getMethod().getMethodName());
	}

	public void onTestSkipped(ITestResult result) {
		System.out.println("$$$$$$$$$$$$$$ onTestSkipped method executed " + result.getMethod());

	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
	}

	public void onTestFailedWithTimeout(ITestResult result) {
		onTestFailure(result);

	}

	public void onStart(ITestContext context) {
	}

	public void onFinish(ITestContext context) {
		System.out.println("inside OnFinish....");
		extent.flush();
	}

}
