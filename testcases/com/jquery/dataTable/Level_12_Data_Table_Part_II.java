package com.jquery.dataTable;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import commons.BaseTest;
import pageObjects.jQuery.HomePageObject;
import pageObjects.jQuery.PageGeneratorManager;

public class Level_12_Data_Table_Part_II extends BaseTest {
	@Parameters({ "browser", "url" })
	@BeforeClass
	public void beforeClass(String browserName, String url) {
		driver = getBrowserDriver(browserName, url);
		homePage = PageGeneratorManager.getHomePage(driver);
	}

	@Test
	public void TC_01_Action() {
		// How to manipulate with any cell
		// Based on the column order
		// Based on the row order
		// The intersection between the column and the row is the target cell
		
		// Input the data into the cell (Artist column & 2nd row
		
		// 1 - How to get the column order when having the column name
		// 3
		
		// 2 - Input the data
		// tr[3]/td[3]
		
		homePage.clickToLoadDataButton();
		homePage.sleepInSecond(3);
		
		homePage.enterToTextboxByHeaderNameAndRowNumber("Artist", "1", "Automation FC");
		homePage.sleepInSecond(3);
		
		homePage.enterToTextboxByHeaderNameAndRowNumber("Price", "5", "200.9");
		homePage.sleepInSecond(3);
		
		homePage.enterToTextboxByHeaderNameAndRowNumber("Album", "2", "Hit songs");
		homePage.sleepInSecond(3);
	}

	@AfterClass
	public void afterClass() {
		driver.quit();
	}

	WebDriver driver;
	HomePageObject homePage;
}