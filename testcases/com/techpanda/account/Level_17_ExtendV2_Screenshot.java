package com.techpanda.account;

import java.lang.reflect.Method;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;

import commons.BaseTest;
import pageObjects.navigation.PageGeneratorManager;
import pageObjects.user.AboutUsPageObject;
import pageObjects.user.AccountInformationPageObject;
import pageObjects.user.UserHomePageObject;
import pageObjects.user.UserLoginPageObject;
import reportConfig.ExtentTestManager;
import pageObjects.user.MyAccountPageObject;
import pageObjects.user.MyApplicationPageObject;
import pageObjects.user.MyDashboardPageObject;
import pageObjects.user.MyOrderPageObject;
import pageObjects.user.MyProductReviewPageObject;
import pageObjects.user.RegisterPageObject;
import pageObjects.user.SearchTermPageObject;

public class Level_17_ExtendV2_Screenshot extends BaseTest {

	@Parameters("browser")
	@BeforeClass
	public void beforeClass(String browserName) {
		driver = getBrowserDriver(browserName);
		homePage = PageGeneratorManager.getUserHomePage(driver);
	}

	@Test
	public void TC_01_Register_Account(Method method) {
		ExtentTestManager.startTest(method.getName(), "TC_01_Register_Account");
		ExtentTestManager.getTest().log(LogStatus.INFO, "Register - Step 01: Click the Account link");
		homePage.clickToAccountLink();
		
		ExtentTestManager.getTest().log(LogStatus.INFO, "Register - Step 02: Click the Register link");
		registerPage = homePage.clickToRegisterLink();
		
		ExtentTestManager.getTest().log(LogStatus.INFO, "Register - Step 03: Enter the data for Firstname textbox with value is '" + firstName + "'");
		registerPage.inputToFirstNameTextbox(firstName);
		
		ExtentTestManager.getTest().log(LogStatus.INFO, "Register - Step 04: Enter the data for Lastname textbox with value is '" + lastName + "'");
		registerPage.inputToLastNameTextbox(lastName);

		ExtentTestManager.getTest().log(LogStatus.INFO, "Register - Step 05: Enter the data for Email Address textbox with value is '" + emailAddress + "'");
		registerPage.inputToEmailAddressTextbox(emailAddress);
		
		ExtentTestManager.getTest().log(LogStatus.INFO, "Register - Step 06: Enter the data for Password textbox with value is '" + password + "'");
		registerPage.inputToPasswordTextbox(password);
		
		ExtentTestManager.getTest().log(LogStatus.INFO, "Register - Step 07: Enter the data for Confirm password textbox with value is '" + password + "'");
		registerPage.inputToConfirmPasswordTextbox(password);
		
		ExtentTestManager.getTest().log(LogStatus.INFO, "Register - Step 08: Click the Register button");		
		myDashboardPage = registerPage.clickToRegisterButton();
		
		ExtentTestManager.getTest().log(LogStatus.INFO, "Register - Step 09: Verify the register success message is displayed");
		Assert.assertEquals(myDashboardPage.getRegisterSuccessMessage(), "Thank you for registering with Main Website Store..");
		ExtentTestManager.getTest().log(LogStatus.INFO, "***********Failed at Step 09***********");
		
		ExtentTestManager.getTest().log(LogStatus.INFO, "Register - Step 10: Verify the first name '" + firstName + "' and the lastname '" + lastName + "' are displayed");
		Assert.assertTrue(myDashboardPage.isContactInfoDisplayed(firstName + " " + lastName));
		
		ExtentTestManager.getTest().log(LogStatus.INFO, "Register - Step 11: Verify the email address '" + emailAddress + "' is displayed");
		Assert.assertFalse(myDashboardPage.isContactInfoDisplayed(emailAddress));

		ExtentTestManager.getTest().log(LogStatus.INFO, "Register - Step 12: Click Logout link");
		homePage = myDashboardPage.clickToUserLogoutLink(driver);
		ExtentTestManager.endTest();
	}

	@Test
	public void TC_02_Login_Valid(Method method) {
		ExtentTestManager.startTest(method.getName(), "TC_02_Login_Valid");
		ExtentTestManager.getTest().log(LogStatus.INFO, "Login - Step 01: Click 'My Account' link");
		loginPage = homePage.clickToMyAccountLink();
		
		ExtentTestManager.getTest().log(LogStatus.INFO, "Login - Step 02: Enter the data for Email Address textbox with value is '" + emailAddress + "'");
		loginPage.inputToEmailAddressTextbox(emailAddress);
		
		ExtentTestManager.getTest().log(LogStatus.INFO, "Login - Step 03: Enter the data for Password textbox with value is '" + password + "'");
		loginPage.inputToPasswordTextbox(password);
		
		ExtentTestManager.getTest().log(LogStatus.INFO, "Login - Step 04: Click Login button");
		myDashboardPage = loginPage.clickToLoginButton();
		
		ExtentTestManager.getTest().log(LogStatus.INFO, "Login - Step 05: Verify the first name '" + firstName + "' and the lastname '" + lastName + "' are displayed");
		Assert.assertFalse(myDashboardPage.isContactInfoDisplayed(firstName + " " + lastName));
		
		ExtentTestManager.getTest().log(LogStatus.INFO, "Login - Step 06: Verify the email address '" + emailAddress + "' is displayed");
		Assert.assertTrue(myDashboardPage.isContactInfoDisplayed(emailAddress));
		ExtentTestManager.endTest();
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