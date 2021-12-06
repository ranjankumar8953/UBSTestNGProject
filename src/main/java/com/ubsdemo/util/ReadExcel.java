package com.ubsdemo.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ReadExcel {
	public static Object[][] ReadExcelData(String filePath, String fileName, String sheetName) throws IOException {
		Workbook workbook = null;
		Object[][] excelData = null;
		File fileExcel = new File(filePath + fileName);
		try {
			FileInputStream fisExcel = new FileInputStream(fileExcel);
			String fileExtension = fileName.substring(fileName.indexOf("."));
			if (fileExtension.equalsIgnoreCase(".xls")) {
				workbook = new HSSFWorkbook(fisExcel);

			} else if (fileExtension.equalsIgnoreCase(".xlsx")) {
				workbook = new XSSFWorkbook(fisExcel);
			} else {
				System.out.println("Invalid Excel file format");
			}
			int tempCellCount = 0;
			Sheet sheet = workbook.getSheet(sheetName);
			int rowCount = sheet.getLastRowNum() - sheet.getFirstRowNum();
			for (int a = 1; a < rowCount; a++) {
				tempCellCount = sheet.getRow(a).getLastCellNum();
			}
			excelData = new String[rowCount][tempCellCount];
			for (int i = 1; i <= rowCount; i++) {
				int cellCount = sheet.getRow(i).getLastCellNum();
				for (int j = 0; j < cellCount; j++) {
					excelData[i - 1][j] = sheet.getRow(i).getCell(j).getStringCellValue();
					System.out.println(excelData[i - 1][j]);
				}
			}

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		return excelData;

	}

}
