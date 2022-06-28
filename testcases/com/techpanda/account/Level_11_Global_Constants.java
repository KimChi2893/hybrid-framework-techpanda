package com.techpanda.account;

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

public class Level_11_Global_Constants extends BaseTest {
	String userUrl, adminUrl;

	@Parameters({ "browser"})
	@BeforeClass
	public void beforeClass(String browserName) {
		this.userUrl = GlobalConstants.LIVE_USER_URL;
		this.adminUrl = GlobalConstants.LIVE_ADMIN_URL;
		driver = getBrowserDriver(browserName, userUrl);
		userHomePage = PageGeneratorManager.getUserHomePage(driver);
	}

	@Test
	public void TC_01_Switch_Role() {
		userLoginPage = userHomePage.clickToMyAccountLink();
		userLoginPage.inputToEmailAddressTextbox(emailAddress);
		userLoginPage.inputToPasswordTextbox(password);

		myDashboardPage = userLoginPage.clickToLoginButton();
		Assert.assertTrue(myDashboardPage.isContactInfoDisplayed("cindy test"));
		Assert.assertTrue(myDashboardPage.isContactInfoDisplayed(emailAddress));
		
		// Logout
		userHomePage = myDashboardPage.clickToUserLogoutLink(driver);

		// User -> Admin -> Login Admin
		adminLoginPage = userHomePage.openAdminLoginPage(driver, adminUrl);
		adminLoginPage.enterToUsernameTextbox("user01");
		adminLoginPage.enterToPasswordTextbox("guru99com");
		adminManageCustomerPage = adminLoginPage.clickToLoginButton();
		
		adminManageCustomerPage.closeIncomingMessagePopup();
		
		adminLoginPage = adminManageCustomerPage.clickToAdminLogoutLink(driver);

		// Admin -> User
		userHomePage = adminLoginPage.openUserHomePage(driver, userUrl);
		
		userLoginPage = userHomePage.clickToMyAccountLink();
		userLoginPage.inputToEmailAddressTextbox(emailAddress);
		userLoginPage.inputToPasswordTextbox(password);

		myDashboardPage = userLoginPage.clickToLoginButton();
		Assert.assertTrue(myDashboardPage.isContactInfoDisplayed("cindy test"));
		Assert.assertTrue(myDashboardPage.isContactInfoDisplayed(emailAddress));
		
		
	}

	@AfterClass
	public void afterClass() {
		driver.quit();
	}

	WebDriver driver;
	String password = "123456";
	String emailAddress = "abc123456@gmail.com";

	UserHomePageObject userHomePage;
	UserLoginPageObject userLoginPage;
	AdminManageCustomerPageObject adminManageCustomerPage;
	AdminLoginPageObject adminLoginPage;
	MyOrderPageObject myOrderPage;
	RegisterPageObject registerPage;
	MyDashboardPageObject myDashboardPage;
	MyApplicationPageObject myApplicationPage;
	MyProductReviewPageObject myProductReviewPage;
	AccountInformationPageObject accountInformationPageObject;

}