package com.ubsdemo.baseclass;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.DataProvider;

import com.ubsdemo.util.Constants;
import com.ubsdemo.util.ReadExcel;

public class TestBase {
	public static WebDriver driver;
	public Properties prop;

	public TestBase() {
		prop = new Properties();
		File file = new File(Constants.filePath + Constants.configFileName);
		try {
			FileInputStream fis = new FileInputStream(file);
			try {
				prop.load(fis);
			} catch (IOException e) {
				e.printStackTrace();
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}

	}

	public void initializeDriver(String browser) {
		if (browser.equalsIgnoreCase(prop.getProperty("chromebrowser"))) {
			System.setProperty("webdriver.chrome.driver",
					System.getProperty("user.dir") + "//Driver//chromedriver.exe");
			driver = new ChromeDriver();
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			driver.get(prop.getProperty("urlUBS"));
		} else if (browser.equalsIgnoreCase(prop.getProperty("firefoxbrowser"))) {
			System.setProperty("webdriver.gecko.driver",
					System.getProperty("user.dir") + "//Driver//geckodriver32.exe");
			driver = new FirefoxDriver();
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			driver.get(prop.getProperty("url"));

		} else {
			throw new IllegalArgumentException("Invalid Browser");
		}

	}

	@DataProvider(name = "excelData")
	protected Object[][] passExcelDataToDataProvider() throws IOException {
		Object[][] data = ReadExcel.ReadExcelData(Constants.excelFilePath, Constants.excelFileName, "Sheet1");
		return data;
	}

}
