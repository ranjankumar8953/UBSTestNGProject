package com.ubsdemo.util;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.ubsdemo.baseclass.TestBase;

public class DynamicWebTableParticularElement extends TestBase {
	public static String dynamicWebTableParticularElement(int rowNo, int colNo, String tableXpath) {
		WebElement mytable = driver.findElement(By.xpath(tableXpath));
		List<WebElement> rowOfTable = mytable.findElements(By.tagName("tr"));
		List<WebElement> colOfRow = rowOfTable.get(rowNo).findElements(By.tagName("td"));
		String cellValue = colOfRow.get(colNo).getText();
		System.out.println("Particular Cell Value=" + cellValue);
		return cellValue;
	}
}
