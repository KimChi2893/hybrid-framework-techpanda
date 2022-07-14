package com.techpanda.account;

import org.openqa.selenium.WebDriver;
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

public class Level_16_Log_ReportNG extends BaseTest {

	@Parameters("browser")
	@BeforeClass
	public void beforeClass(String browserName) {
		driver = getBrowserDriver(browserName);
		homePage = PageGeneratorManager.getUserHomePage(driver);
	}

	@Test
	public void TC_01_Register_Account() {
		log.info("Register - Step 01: Click the Account link");
		homePage.clickToAccountLink();
		
		log.info("Register - Step 02: Click the Register link");
		registerPage = homePage.clickToRegisterLink();
		
		log.info("Register - Step 03: Enter the data for Firstname textbox with value is '" + firstName + "'");
		registerPage.inputToFirstNameTextbox(firstName);
		
		log.info("Register - Step 04: Enter the data for Lastname textbox with value is '" + lastName + "'");
		registerPage.inputToLastNameTextbox(lastName);

		log.info("Register - Step 05: Enter the data for Email Address textbox with value is '" + emailAddress + "'");
		registerPage.inputToEmailAddressTextbox(emailAddress);
		
		log.info("Register - Step 06: Enter the data for Password textbox with value is '" + password + "'");
		registerPage.inputToPasswordTextbox(password);
		
		log.info("Register - Step 07: Enter the data for Confirm password textbox with value is '" + password + "'");
		registerPage.inputToConfirmPasswordTextbox(password);
		
		log.info("Register - Step 08: Click the Register button");		
		myDashboardPage = registerPage.clickToRegisterButton();
		
		log.info("Register - Step 09: Verify the register success message is displayed");
		verifyEquals(myDashboardPage.getRegisterSuccessMessage(), "Thank you for registering with Main Website Store.");
		
		log.info("Register - Step 10: Verify the first name '" + firstName + "' and the lastname '" + lastName + "' are displayed");
		verifyTrue(myDashboardPage.isContactInfoDisplayed(firstName + " " + lastName));
		
		log.info("Register - Step 11: Verify the email address '" + emailAddress + "' is displayed");
		verifyTrue(myDashboardPage.isContactInfoDisplayed(emailAddress));

		log.info("Register - Step 12: Click Logout link");
		homePage = myDashboardPage.clickToUserLogoutLink(driver);
	}

	@Test
	public void TC_02_Login_Valid() {
		log.info("Login - Step 01: Click 'My Account' link");
		loginPage = homePage.clickToMyAccountLink();
		
		log.info("Login - Step 02: Enter the data for Email Address textbox with value is '" + emailAddress + "'");
		loginPage.inputToEmailAddressTextbox(emailAddress);
		
		log.info("Login - Step 03: Enter the data for Password textbox with value is '" + password + "'");
		loginPage.inputToPasswordTextbox(password);
		
		log.info("Login - Step 04: Click Login button");
		myDashboardPage = loginPage.clickToLoginButton();
		
		log.info("Login - Step 05: Verify the first name '" + firstName + "' and the lastname '" + lastName + "' are displayed");
		verifyTrue(myDashboardPage.isContactInfoDisplayed(firstName + " " + lastName));
		
		log.info("Login - Step 06: Verify the email address '" + emailAddress + "' is displayed");
		verifyTrue(myDashboardPage.isContactInfoDisplayed(emailAddress));
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