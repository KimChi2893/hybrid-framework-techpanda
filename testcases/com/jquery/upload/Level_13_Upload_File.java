package com.jquery.upload;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import commons.BaseTest;
import pageObjects.jQuery.HomePageObject;
import pageObjects.jQuery.PageGeneratorManager;

public class Level_13_Upload_File extends BaseTest {
	@Parameters({ "browser", "url" })
	@BeforeClass
	public void beforeClass(String browserName, String url) {
		driver = getBrowserDriver(browserName, url);
		homePage = PageGeneratorManager.getHomePage(driver);
	}

	@Test
	public void TC_01_One_File() {
		homePage.uploadMultitpleFiles(driver, singaporeImage);

		Assert.assertTrue(homePage.isFileNameLoadedSuccess(singaporeImage));

		homePage.clickToStartButton();

		Assert.assertTrue(homePage.isFileUploadedSuccess(singaporeImage));
	}

	@Test
	public void TC_02_Multiple_Files() {
		homePage.refreshCurrentPage(driver);
		
		homePage.uploadMultitpleFiles(driver, jejuImage, singaporeImage, baliImage);

		Assert.assertTrue(homePage.isFileNameLoadedSuccess(jejuImage));
		Assert.assertTrue(homePage.isFileNameLoadedSuccess(singaporeImage));
		Assert.assertTrue(homePage.isFileNameLoadedSuccess(baliImage));

		homePage.clickToStartButton();

		Assert.assertTrue(homePage.isFileUploadedSuccess(jejuImage));
		Assert.assertTrue(homePage.isFileUploadedSuccess(singaporeImage));
		Assert.assertTrue(homePage.isFileUploadedSuccess(baliImage));
	}

	@AfterClass
	public void afterClass() {
		driver.quit();
	}

	WebDriver driver;
	HomePageObject homePage;

	String baliImage = "bali.jpeg";
	String muCangChaiImage = "muCangChai.jpeg";
	String jejuImage = "jeju.jpeg";
	String singaporeImage = "singapore.jpeg";
}