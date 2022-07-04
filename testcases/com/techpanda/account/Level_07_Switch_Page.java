package com.techpanda.account;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import commons.BaseTest;
import pageObjects.navigation.PageGeneratorManager;
import pageObjects.user.AccountInformationPageObject;
import pageObjects.user.UserHomePageObject;
import pageObjects.user.UserLoginPageObject;
import pageObjects.user.MyApplicationPageObject;
import pageObjects.user.MyDashboardPageObject;
import pageObjects.user.MyOrderPageObject;
import pageObjects.user.MyProductReviewPageObject;
import pageObjects.user.RegisterPageObject;

public class Level_07_Switch_Page extends BaseTest {

	@Parameters("browser")
	@BeforeClass
	public void beforeClass(String browserName) {
		driver = getBrowserDriver(browserName);
		homePage = PageGeneratorManager.getUserHomePage(driver);
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
		Assert.assertEquals(myDashboardPage.getRegisterSuccessMessage(), "Thank you for registering with Main Website Store.");
		Assert.assertTrue(myDashboardPage.isContactInfoDisplayed(firstName + " " + lastName));
		Assert.assertTrue(myDashboardPage.isContactInfoDisplayed(emailAddress));
		
		homePage = myDashboardPage.clickToUserLogoutLink(driver);
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
		accountInformationPageObject = myDashboardPage.openAccountInformationPage();

		// Account Information -> My Dashboard
		myDashboardPage = accountInformationPageObject.openMyDashboardPage();

		// My Dashboard -> My Orders
		myOrderPage = myDashboardPage.openMyOrderPage();

		// My Orders -> My Applications
		myApplicationPage = myOrderPage.openMyApplicationPage();

		// My Applications -> My Product Review
		myProductReviewPage = myApplicationPage.openMyProductReviewPage();

		// My Product Review -> My Order
		myOrderPage = myProductReviewPage.openMyOrderPage();

		// My Order -> My Product Review
		myProductReviewPage = myOrderPage.openMyProductReviewPage();

		// My Product Review -> My Applications
		myApplicationPage = myProductReviewPage.openMyApplicationPage();
	}

	@AfterClass
	public void afterClass() {
		driver.quit();
	}
	
	WebDriver driver;
	String lastName = "test";
	String firstName = "Cindy";
	String password = "246810";
	String emailAddress = "auto_test" + getRandomNumber() + "@live.com";
	
	UserHomePageObject homePage;
	UserLoginPageObject loginPage;
	MyOrderPageObject myOrderPage;
	RegisterPageObject registerPage;
	MyDashboardPageObject myDashboardPage;
	MyApplicationPageObject myApplicationPage;
	MyProductReviewPageObject myProductReviewPage;
	AccountInformationPageObject accountInformationPageObject;
	
	

}