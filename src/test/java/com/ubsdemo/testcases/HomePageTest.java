package com.ubsdemo.testcases;

import java.io.IOException;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.ubsdemo.baseclass.TestBase;
import com.ubsdemo.pages.HomePage;
import com.ubsdemo.util.Constants;
import com.ubsdemo.util.DynamicWebTableParticularElement;

public class HomePageTest extends TestBase {
	HomePage homepage;

	HomePageTest() {
		super();
	}

	@BeforeMethod
	@Parameters({ "browser" })
	public void initialSetup(String browser) {
		initializeDriver(browser);

	}

	@Test(enabled = false, groups = { "smoke", "integration" })
	public void homeButtonTest() throws InterruptedException {
		homepage = new HomePage(driver);
		homepage.homeButtonClick();

	}

	@Test(enabled = false, groups = { "integration" })
	public void tutorialsButtonTest() throws InterruptedException, IOException {
		homepage = new HomePage(driver);
		homepage.tutorialButtonClick();
		Assert.assertTrue(false);

	}

	@Test(dataProvider = "excelData", enabled = false)
	public void readExcelData(String name, String email) throws InterruptedException {
		homepage = new HomePage(driver);
		homepage.enterName(name);
		homepage.enterEmail(email);
		homepage.clickonClearLink();
	}

	@Test(enabled = false)
	public void browserWindowTest() throws InterruptedException {
		homepage = new HomePage(driver);
		homepage.clickonBrowserWindow();
		Thread.sleep(10000);
		String parentWindow = driver.getWindowHandle();
		Set<String> allWindow = driver.getWindowHandles();
		Iterator<String> itr = allWindow.iterator();
		while (itr.hasNext()) {
			String childWindow = itr.next();
			if (!parentWindow.equalsIgnoreCase(childWindow)) {
				driver.switchTo().window(childWindow);
				driver.close();
			}
			driver.switchTo().window(parentWindow);
		}
	}

	@Test(enabled = false)
	public void messageWindowTest() throws InterruptedException {
		homepage = new HomePage(driver);
		homepage.clickonMessageWindow();
		Thread.sleep(10000);
		String parentWindow = driver.getWindowHandle();
		Set<String> allWindow = driver.getWindowHandles();
		Iterator<String> itr = allWindow.iterator();
		while (itr.hasNext()) {
			String childWindow = itr.next();
			if (!parentWindow.equalsIgnoreCase(childWindow)) {
				driver.switchTo().window(childWindow);
				driver.close();
			}
			driver.switchTo().window(parentWindow);
		}
	}

	@Test(enabled = false)
	public void browserTabTest() throws InterruptedException {
		homepage = new HomePage(driver);
		homepage.clickonBrowserTab();
		Thread.sleep(10000);
		String parentWindow = driver.getWindowHandle();
		Set<String> allWindow = driver.getWindowHandles();
		Iterator<String> itr = allWindow.iterator();
		while (itr.hasNext()) {
			String childWindow = itr.next();
			if (!parentWindow.equalsIgnoreCase(childWindow)) {
				driver.switchTo().window(childWindow);
				driver.close();
			}
			driver.switchTo().window(parentWindow);
		}
	}

	@Test(enabled = false)
	public void alertTest() throws InterruptedException {
		homepage = new HomePage(driver);
		homepage.clickonAlert();
		Thread.sleep(10000);
		driver.switchTo().alert().dismiss();
	}

	@Test(enabled = false)
	public void dragAndDropTest() throws InterruptedException {
		homepage = new HomePage(driver);
		homepage.draAndDrop();
		Thread.sleep(10000);
	}

	@Test(enabled = false)
	public void dragAndDropTestWithHoldTest() throws InterruptedException {
		homepage = new HomePage(driver);
		homepage.dragAndDropWithHold();
		Thread.sleep(10000);
	}

	@Test(enabled = false)
	public void getAllLinks() {
		homepage = new HomePage(driver);
		List<WebElement> linkList = driver.findElements(By.tagName("a"));
		System.out.println(linkList.size());
		for (WebElement link : linkList) {
			System.out.println(link.getAttribute("href"));
			System.out.println(link.getText());
		}

	}

	@Test(enabled = false)
	public void getAllFrame() {
		List<WebElement> linkList = driver.findElements(By.tagName("iframe"));
		System.out.println(linkList.size());
		for (int i = 0; i < linkList.size(); i++) {
			driver.switchTo().frame(i);
			System.out.println(linkList.get(i));
			driver.switchTo().defaultContent();
		}

	}

	@Test(enabled = false)
	public void getWebTable() {
		// DynamicWebTableParticularElement.dynamicWebTableParticularElement(2, 0,
		// "//table[@class='dataTable']");
		WebElement mytable = driver.findElement(By.xpath("//table[@class='dataTable']"));
		List<WebElement> rowOfTable = mytable.findElements(By.tagName("tr"));
		int rowSize = rowOfTable.size();
		System.out.println(rowSize);
		for (int i = 1; i < rowSize; i++) {
			List<WebElement> colOfRow = rowOfTable.get(i).findElements(By.tagName("td"));
			int colSize = colOfRow.size();
			System.out.println(colSize);
			for (int j = 0; j < colSize; j++) {
				String cellValue = colOfRow.get(j).getText();
				System.out.println(cellValue);
			}
		}

	}

	@Test(enabled = true)
	public void ubsSearch() throws InterruptedException {
		homepage = new HomePage(driver);
		homepage.clickOnSearchIcon();
		homepage.searchInField(Constants.searchText);
		homepage.clickOnCucumberHooks();
		List<WebElement> cucumberLink = driver.findElements(By.tagName("a"));
		Iterator<WebElement> itr = cucumberLink.iterator();
		while (itr.hasNext()) {
			String cucumberText = itr.next().getText();
			if (cucumberText.equalsIgnoreCase("Cucumber Hooks")) {
				itr.next().click();
				break;
			}
		}
		Thread.sleep(10000);
		List<WebElement> header = driver.findElements(By.tagName("h2"));
		int size = header.size();
		System.out.println(size);
		Assert.assertEquals(7, size);

	}

	@Test(enabled = false)
	public void ubsSearch1() throws InterruptedException {
		List<WebElement> header = driver.findElements(By.tagName("h2"));
		int size = header.size();
		System.out.println(size);
		Assert.assertEquals(7, size);

	}

	@AfterMethod
	public void tearDown() {
		driver.close();
	}

}
