package com.ubsdemo.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.ubsdemo.baseclass.TestBase;

public class HomePage extends TestBase {
	Actions action;
	@FindBy(xpath = "//*[text()='HOME']")
	WebElement homeButton;
	@FindBy(xpath = "//*[text()='TUTORIALS']")
	WebElement tutorialButton;
	@FindBy(xpath = "//input[@name='name']")
	WebElement nameTextBox;
	@FindBy(xpath = "//input[@name='email' and @class='validate[required,custom[email]]']")
	WebElement emailTextBox;
	@FindBy(xpath = "//a[@class='clear-form']")
	WebElement clearLink;
	@FindBy(xpath = "//*[contains(text(),'New Browser Window')]")
	WebElement browserWindow;
	@FindBy(xpath = "//*[contains(text(),'New Message Window')]")
	WebElement messageWindow;
	@FindBy(xpath = "//*[contains(text(),'New Browser Tab')]")
	WebElement browserTab;
	@FindBy(xpath = "//*[(@id='alert')]")
	WebElement alert;
	@FindBy(xpath = "//*[@id='draga']")
	WebElement dragFrom;
	@FindBy(xpath = "//*[@id='dragb']")
	WebElement dragTo;
	@FindBy(xpath = "//a[@class='nav--menu_item_anchor' and @id='menu-item-40489']")
	WebElement searchIcon;
	@FindBy(xpath = "//input[@class='form-control' and @id='search']")
	WebElement searchField;
	@FindBy(xpath = "//button[@class='btn btn-default btn-search' and @type='submit']")
	WebElement cucumberHooks;

	public HomePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public void homeButtonClick() throws InterruptedException {
		WebDriverWait wait = new WebDriverWait(driver, 20);
		WebElement element = wait.until(ExpectedConditions.elementToBeClickable(homeButton));
		element.click();
	}

	public void tutorialButtonClick() throws InterruptedException {
		tutorialButton.click();
	}

	public void enterName(String name) {
		nameTextBox.sendKeys(name);
	}

	public void enterEmail(String email) {
		emailTextBox.sendKeys(email);
	}

	public void clickonClearLink() {
		clearLink.click();
	}

	public void clickonBrowserWindow() {
		browserWindow.click();
	}

	public void clickonMessageWindow() {
		messageWindow.click();
	}

	public void clickonBrowserTab() {
		browserTab.click();
	}

	public void clickonAlert() {
		alert.click();
	}

	public void draAndDrop() {
		action = new Actions(driver);
		action.dragAndDrop(dragFrom, dragTo).build().perform();
	}

	public void dragAndDropWithHold() {
		action = new Actions(driver);
		action.clickAndHold(dragFrom).moveToElement(dragTo).release().build().perform();
	}

	public void clickOnSearchIcon() {
		searchIcon.click();
	}

	public void searchInField(String searchKeyword) {
		searchField.sendKeys(searchKeyword);
	}

	public void clickOnCucumberHooks() {
		cucumberHooks.click();
	}
}
