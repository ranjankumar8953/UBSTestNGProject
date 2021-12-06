package com.ubsdemo.ExtentReportListner;

import java.io.IOException;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;

import com.ubsdemo.baseclass.TestBase;
import com.ubsdemo.util.TakeScreenShot;

public class Listners extends TestBase implements ITestListener {
	public static ExtentReports extent = ExtentManager.createInstance();
	ExtentTest logger;

	public void onTestStart(ITestResult result) {
		logger = extent.createTest(result.getTestClass().getName() + "::" + result.getMethod().getMethodName());

	}

	public void onTestSuccess(ITestResult result) {

		logger.pass("Test '" + result.getName() + "' PASSED");
	}

	public void onTestFailure(ITestResult result) {
		logger.fail("Test '" + result.getName() + "' FAILED");
		try {
			String ssPath = TakeScreenShot.takeScreenShot();
			logger.fail(result.getThrowable().getMessage(),
					MediaEntityBuilder.createScreenCaptureFromPath(ssPath).build());
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void onTestSkipped(ITestResult result) {
		System.out.println("TestCase is Skipped");
		logger.skip("Test '" + result.getName() + "' SKIPPED");
	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {

	}

	public void onTestFailedWithTimeout(ITestResult result) {

	}

	public void onStart(ITestContext context) {

	}

	public void onFinish(ITestContext context) {
		if (extent != null) {
			extent.flush();
		}
	}

}
