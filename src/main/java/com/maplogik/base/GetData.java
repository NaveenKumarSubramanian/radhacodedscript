package com.maplogik.base;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.DataProvider;

public class GetData {

	@DataProvider
	public String[][] studentIdProvider() {
		String[][] data = getData();
		return data;
	}

	public String[][] getData() {
		XSSFWorkbook wb = null;
		try {
			wb = new XSSFWorkbook(
					new FileInputStream("H:\\Project\\ScreenShotComparison\\Computer Science Engineering.xlsx"));
		} catch (IOException e) {
			e.printStackTrace();
		}
		int lastRow = wb.getSheetAt(0).getLastRowNum() + 1;
		int lastColumn = wb.getSheetAt(0).getRow(lastRow - 1).getLastCellNum();
		String[][] data = new String[lastRow][lastColumn];
		for (int i = 0; i < lastRow; i++) {
			for (int j = 0; j < lastColumn; j++) {
				DataFormatter dataFormatter = new DataFormatter();
				String cellData = dataFormatter.formatCellValue(wb.getSheetAt(0).getRow(i).getCell(j));
				data[i][j] = cellData;
			}
		}
		return data;
	}
}
