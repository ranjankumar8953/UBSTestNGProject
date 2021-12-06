package com.ubsdemo.util;

import java.io.File;
import java.io.IOException;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;

import com.ubsdemo.baseclass.TestBase;

public class TakeScreenShot extends TestBase {

	public static String takeScreenShot() throws IOException {
		TakesScreenshot ts = ((TakesScreenshot) driver);
		File srcFile = ts.getScreenshotAs(OutputType.FILE);
		String ssPath = System.getProperty("user.dir") + "/ScreenShot/" + System.currentTimeMillis() + ".png";
		File desFile = new File(ssPath);
		FileHandler.copy(srcFile, desFile);
		return ssPath;
	}

}
