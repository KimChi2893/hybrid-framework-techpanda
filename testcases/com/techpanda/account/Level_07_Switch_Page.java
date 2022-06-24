package com.techpanda.account;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import commons.BaseTest;
import pageObjects.user.AccountInformationPageObject;
import pageObjects.user.HomePageObject;
import pageObjects.user.LoginPageObject;
import pageObjects.user.MyApplicationPageObject;
import pageObjects.user.MyDashboardPageObject;
import pageObjects.user.MyOrderPageObject;
import pageObjects.user.MyProductReviewPageObject;
import pageObjects.user.PageGeneratorManager;
import pageObjects.user.RegisterPageObject;

public class Level_07_Switch_Page extends BaseTest {

	@Parameters("browser")
	@BeforeClass
	public void beforeClass(String browserName) {
		driver = getBrowserDriver(browserName);
		homePage = PageGeneratorManager.getHomePage(driver);
	}

	@Test
	public void TC_01_Register_Account() {
		homePage.clickToAccountLink();
		registerPage = homePage.clickToRegisterLink();
		registerPage.inputToFirstNameTextbox(firstName);
		registerPage.inputToLastNameTextbox(lastName);
		
		registerPage.inputToEmailAddressTextbox(emailAddress);
		registerPage.inputToPasswordTextbox(password);
		registerPage.inputToConfirmPasswordTextbox(password);		
		myDashboardPage = registerPage.clickToRegisterButton();
		Assert.assertTrue(myDashboardPage.isMessageRegisteredDisplayed());
		Assert.assertTrue(myDashboardPage.isContactInfoDisplayed(firstName + " " + lastName));
		Assert.assertTrue(myDashboardPage.isContactInfoDisplayed(emailAddress));
		
		myDashboardPage.clickToAccountLink();
		homePage = myDashboardPage.clickToLogoutLink();	
	}
	@Test
	public void TC_02_Login_Valid_Email_And_Password() {
		loginPage = homePage.clickToMyAccountLink();
		loginPage.inputToEmailAddressTextbox(emailAddress);
		loginPage.inputToPasswordTextbox(password);

		myDashboardPage = loginPage.clickToLoginButton();
		Assert.assertTrue(myDashboardPage.isContactInfoDisplayed(firstName + " " + lastName));
		Assert.assertTrue(myDashboardPage.isContactInfoDisplayed(emailAddress));
	}

	@Test
	public void TC_03_Update_Navigate_Page() {
		// My Dashboard -> Account Information
		accountInformationPageObject = myDashboardPage.openAccountInformationPage(driver);

		// Account Information -> My Dashboard
		myDashboardPage = accountInformationPageObject.openMyDashboardPage(driver);

		// My Dashboard -> My Orders
		myOrderPage = myDashboardPage.openMyOrderPage(driver);

		// My Orders -> My Applications
		myApplicationPage = myOrderPage.openMyApplicationPage(driver);

		// My Applications -> My Product Review
		myProductReviewPage = myApplicationPage.openMyProductReviewPage(driver);

		// My Product Review -> My Order
		myOrderPage = myProductReviewPage.openMyOrderPage(driver);

		// My Order -> My Product Review
		myProductReviewPage = myOrderPage.openMyProductReviewPage(driver);

		// My Product Review -> My Applications
		myApplicationPage = myProductReviewPage.openMyApplicationPage(driver);
	}

	@AfterClass
	public void afterClass() {
		driver.quit();
	}
	
	String firstName = "Cindy";
	String lastName = "test";
	String emailAddress = "auto_test" + getRandomNumber() + "@live.com";
	String password = "246810";
	WebDriver driver;
	HomePageObject homePage;
	RegisterPageObject registerPage;
	LoginPageObject loginPage;
	MyDashboardPageObject myDashboardPage;
	AccountInformationPageObject accountInformationPageObject;
	MyOrderPageObject myOrderPage;
	MyProductReviewPageObject myProductReviewPage;
	MyApplicationPageObject myApplicationPage;

}