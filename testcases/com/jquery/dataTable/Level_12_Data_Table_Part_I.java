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

public class Level_12_Data_Table_Part_I extends BaseTest {
	@Parameters({ "browser", "url" })
	@BeforeClass
	public void beforeClass(String browserName, String url) {
		driver = getBrowserDriver(browserName, url);
		homePage = PageGeneratorManager.getHomePage(driver);
	}

	
	public void TC_01_Header_Textbox() {
		// 1 - How to input the data into the textbox in the Header
		// Parameter: Header Name - Which column to enter
		// Parameter: The value to enter into the textbox
		homePage.enterToTextboxByHeaderName("Country", "Aruba");
		homePage.sleepInSecond(3);

		// 2 - How to verify the data of any country
		// Parameters: Females/ Country/ Males/ Total
		Assert.assertTrue(homePage.isRowValueDisplayed("750", "Aruba", "756", "1504"));
		homePage.refreshCurrentPage(driver);

		homePage.enterToTextboxByHeaderName("Females", "15999");
		homePage.sleepInSecond(3);
		Assert.assertTrue(homePage.isRowValueDisplayed("15999", "Armenia", "16456", "32487"));
		homePage.refreshCurrentPage(driver);

		homePage.enterToTextboxByHeaderName("Total", "687522");
		homePage.sleepInSecond(3);
		Assert.assertTrue(homePage.isRowValueDisplayed("338282", "Argentina", "349238", "687522"));
		homePage.refreshCurrentPage(driver);
	}

	//@Test
	public void TC_02_Action_Icon() {
		// 3 - How to click Edit/Delete icon of any country
		homePage.clickToActionIconByCountryName("Algeria", "remove");
		homePage.sleepInSecond(3);
		
		homePage.clickToActionIconByCountryName("Arab Rep of Egypt", "remove");
		homePage.sleepInSecond(3);
		
		homePage.refreshCurrentPage(driver);

		homePage.clickToActionIconByCountryName("Armenia", "edit");
		homePage.sleepInSecond(3);
		
		homePage.refreshCurrentPage(driver);
		homePage.clickToActionIconByCountryName("AFRICA", "edit");
		homePage.sleepInSecond(3);
	}

	@Test
	public void TC_03_Paging() {
		// 4 - How to navigate to any page (page number)
		homePage.clickToPageByNumber("7");
		Assert.assertTrue(homePage.isPageNumberActivated("7"));
		homePage.sleepInSecond(3);
		
		homePage.clickToPageByNumber("24");
		Assert.assertTrue(homePage.isPageNumberActivated("24"));
		homePage.sleepInSecond(3);
		
		homePage.clickToPageByNumber("11");
		Assert.assertTrue(homePage.isPageNumberActivated("11"));
		homePage.sleepInSecond(3);
		
		
		homePage.clickToPageByNumber("1");
		Assert.assertTrue(homePage.isPageNumberActivated("1"));
		homePage.sleepInSecond(3);
	}

	@AfterClass
	public void afterClass() {
		driver.quit();
	}

	WebDriver driver;
	HomePageObject homePage;
}