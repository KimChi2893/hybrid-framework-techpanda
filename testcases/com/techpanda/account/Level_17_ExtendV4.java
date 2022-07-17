package com.techpanda.account;

import java.lang.reflect.Method;

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

public class Level_17_ExtendV4 extends BaseTest {

	@Parameters("browser")
	@BeforeClass
	public void beforeClass(String browserName) {
		driver = getBrowserDriver(browserName);
		homePage = PageGeneratorManager.getUserHomePage(driver);
	}

	@Test
	public void TC_01_Register_Account(Method method) {
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
	public void TC_02_Login_Valid(Method method) {
		loginPage = homePage.clickToMyAccountLink();
		
		loginPage.inputToEmailAddressTextbox(emailAddress);
		
		loginPage.inputToPasswordTextbox(password);
		
		myDashboardPage = loginPage.clickToLoginButton();
		
		Assert.assertFalse(myDashboardPage.isContactInfoDisplayed(firstName + " " + lastName));
		
		Assert.assertTrue(myDashboardPage.isContactInfoDisplayed(emailAddress));
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