package com.jquery.dataTable;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import commons.BaseTest;
import commons.GlobalConstants;
import pageObjects.admin.AdminManageCustomerPageObject;
import pageObjects.navigation.PageGeneratorManager;
import pageObjects.admin.AdminLoginPageObject;
import pageObjects.user.AccountInformationPageObject;
import pageObjects.user.UserHomePageObject;
import pageObjects.user.UserLoginPageObject;
import pageObjects.user.MyApplicationPageObject;
import pageObjects.user.MyDashboardPageObject;
import pageObjects.user.MyOrderPageObject;
import pageObjects.user.MyProductReviewPageObject;
import pageObjects.user.RegisterPageObject;

public class Level_12_DataTable extends BaseTest {
	@Parameters({ "browser", "url"})
	@BeforeClass
	public void beforeClass(String browserName, String url) {
		driver = getBrowserDriver(browserName, url);
	}

	@Test
	public void TC_01() {
			
	}

	@Test
	public void TC_02() {
			
	}
	
	@Test
	public void TC_03() {
			
	}
	
	@AfterClass
	public void afterClass() {
		driver.quit();
	}

	WebDriver driver;
}