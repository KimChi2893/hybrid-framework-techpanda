package com.techpanda.account;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import commons.BaseTest;
import pageObjects.navigation.PageGeneratorManager;
import pageObjects.user.AboutUsPageObject;
import pageObjects.user.AccountInformationPageObject;
import pageObjects.user.UserHomePageObject;
import pageObjects.user.UserLoginPageObject;
import pageObjects.user.MyAccountPageObject;
import pageObjects.user.MyApplicationPageObject;
import pageObjects.user.MyDashboardPageObject;
import pageObjects.user.MyOrderPageObject;
import pageObjects.user.MyProductReviewPageObject;
import pageObjects.user.RegisterPageObject;
import pageObjects.user.SearchTermPageObject;

public class Level_10_Dynamic_Locator_II extends BaseTest {

	@Parameters("browser")
	@BeforeClass
	public void beforeClass(String browserName) {
		driver = getBrowserDriver(browserName);
		homePage = PageGeneratorManager.getUserHomePage(driver);
	}

	@Test
	public void TC_01_Login() {
		loginPage = homePage.clickToMyAccountLink();
		loginPage.inputToEmailAddressTextbox(emailAddress);
		loginPage.inputToPasswordTextbox(password);

		myDashboardPage = loginPage.clickToLoginButton();
		Assert.assertTrue(myDashboardPage.isContactInfoDisplayed(firstName + " " + lastName));
		Assert.assertTrue(myDashboardPage.isContactInfoDisplayed(emailAddress));
	}

	@Test
	public void TC_02_SideBar_Page() {
		// My Dashboard -> Account Information
		accountInformationPageObject = (AccountInformationPageObject) myDashboardPage.openSideBarLinkByPageNames("Account Information");
		
		// Account Information -> My Dashboard
		myDashboardPage = (MyDashboardPageObject) accountInformationPageObject.openSideBarLinkByPageNames("Account Dashboard");

		// My Dashboard -> My Orders		
		myOrderPage = (MyOrderPageObject) myDashboardPage.openSideBarLinkByPageNames("My Orders");

		// My Orders -> My Applications
		myApplicationPage = (MyApplicationPageObject) myOrderPage.openSideBarLinkByPageNames("My Applications");

		
		//...
	}

	@AfterClass
	public void afterClass() {
		driver.quit();
	}

	WebDriver driver;
	String lastName = "test";
	String firstName = "cindy";
	String password = "123456";
	String emailAddress = "abc123456@gmail.com";

	UserHomePageObject homePage;
	UserLoginPageObject loginPage;
	AboutUsPageObject aboutUsPage;
	MyOrderPageObject myOrderPage;
	RegisterPageObject registerPage;
	MyAccountPageObject myAccountPage;
	SearchTermPageObject searchTermPage;
	MyDashboardPageObject myDashboardPage;
	MyApplicationPageObject myApplicationPage;
	MyProductReviewPageObject myProductReviewPage;
	AccountInformationPageObject accountInformationPageObject;

}