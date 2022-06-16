package com.crm.qa.util;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.commons.compress.archivers.dump.InvalidFormatException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.interactions.Actions;

import com.crm.qa.base.TestBase;

public class TestUtil extends TestBase {
	
     public static long page_Load_Time_Out=30;
     public static long implicit_Time_Out=30;
     
     public static String TESTDATA_SHEET_PATH = "C:\\Users\\HP\\eclipse-workspace\\FreeCRMTest\\src\\main\\java\\com\\crm\\qa\\testdata\\CRMTestData.xlsx";

 	static Workbook book;
 	static Sheet sheet;
 	static JavascriptExecutor js;
     
     Actions action;
     
     public void homePageNavigation(String pageName) {
    	 try{
    		 action = new Actions(driver);
 		action.moveToElement(driver.findElement(By.xpath("//div[@id='main-nav']"))).build().perform();
 		action.click(driver.findElement(By.xpath("//span[contains(text(),'"+pageName+"')]"))).build().perform();
 		Thread.sleep(2000);
 		}
    	 catch(Exception e) {
    		 e.printStackTrace();
    	 }
 		
     }

     


 	public void switchToFrame() {
 		driver.switchTo().frame("mainpanel");
 	}

 	public static Object[][] getTestData(String sheetName) {
 		FileInputStream file = null;
 		try {
 			file = new FileInputStream(TESTDATA_SHEET_PATH);
 		} catch (FileNotFoundException e) {
 			e.printStackTrace();
 		}
 		try {
 			book = WorkbookFactory.create(file);
 		} catch (InvalidFormatException e) {
 			e.printStackTrace();
 		} catch (IOException e) {
 			e.printStackTrace();
 		}
 		sheet = book.getSheet(sheetName);
 		Object[][] data = new Object[sheet.getLastRowNum()][sheet.getRow(0).getLastCellNum()];
 		// System.out.println(sheet.getLastRowNum() + "--------" +
 		// sheet.getRow(0).getLastCellNum());
 		for (int i = 0; i < sheet.getLastRowNum(); i++) {
 			for (int k = 0; k < sheet.getRow(0).getLastCellNum(); k++) {
 				data[i][k] = sheet.getRow(i + 1).getCell(k).toString();
 				// System.out.println(data[i][k]);
 			}
 		}
 		return data;
 	}
	
}
