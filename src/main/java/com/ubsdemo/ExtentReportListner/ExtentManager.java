package com.ubsdemo.ExtentReportListner;

import java.io.File;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

public class ExtentManager {
	public static ExtentReports extent;
	public static ExtentTest logger;

	public static ExtentReports createInstance() {
		ExtentHtmlReporter htmlReporter = new ExtentHtmlReporter(
				new File(System.getProperty("user.dir") + "/Reports/Extentreport.html"));
		extent = new ExtentReports();
		extent.attachReporter(htmlReporter);
		extent.setSystemInfo("Machine", "Ranjan Kumar-Dell");
		extent.setSystemInfo("Env", "DevOps");
		extent.setSystemInfo("Build", "Integration");
		extent.setSystemInfo("Browser", "Chrome");
		return extent;
	}

}
