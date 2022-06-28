package com.techpanda.account;

import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pageObjects.user.UserHomePageObject;
import pageObjects.user.UserLoginPageObject;
import pageObjects.user.MyDashboardPageObject;

public class Level_03_Page_Object_Pattern_Part_I {
	WebDriver driver;
	String projectPath = System.getProperty("user.dir");
	UserHomePageObject homePage;
	UserLoginPageObject loginPage;
	MyDashboardPageObject myDashboardPage;

	@BeforeClass
	public void beforeClass() {
		System.setProperty("webdriver.gecko.driver", projectPath + "/browserDrivers/geckodriver");
		driver = new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		
		// 1 - Opening the Url => new HomePage
		driver.get("http://live.techpanda.org/");
		homePage = new UserHomePageObject(driver);
	}

	@Test
	public void TC_01_Login_Empty_Email_And_Password() {
		// 2 - HomePage -> new LoginPage
		homePage.clickToMyAccountLink();
		loginPage = new UserLoginPageObject(driver);

		loginPage.inputToEmailAddressTextbox("");
		loginPage.inputToPasswordTextbox("");
		loginPage.clickToLoginButton();

		Assert.assertEquals(loginPage.getEmailAddressEmptyErrorMessage(), "This is a required field.");
		Assert.assertEquals(loginPage.getPasswordEmptyErrorMessage(), "This is a required field.");
	}

	@Test
	public void TC_02_Login_Invalid_Email() {
		// 3 - HomePage -> new LoginPage
		homePage.clickToMyAccountLink();
		loginPage = new UserLoginPageObject(driver);

		loginPage.inputToEmailAddressTextbox("123@456.789");
		loginPage.inputToPasswordTextbox("123456");
		loginPage.clickToLoginButton();
		Assert.assertEquals(loginPage.getEmailAddressInvalidErrorMessage(), "Please enter a valid email address. For example johndoe@domain.com.");
	}

	@Test
	public void TC_03_Login_Incorrect_Email() {
		// 4 - HomePage -> new LoginPage
		homePage.clickToMyAccountLink();
		loginPage = new UserLoginPageObject(driver);

		loginPage.inputToEmailAddressTextbox("auto_test" + randomNumber() + "@live.com");
		loginPage.inputToPasswordTextbox("123456");
		loginPage.clickToLoginButton();

		Assert.assertEquals(loginPage.getEmailAddressOrPasswordIncorrectErrorMessage(), "Invalid login or password.");
	}

	@Test
	public void TC_04_Login_Invalid_Password() {
		// 5 - HomePage -> new LoginPage
		homePage.clickToMyAccountLink();
		loginPage = new UserLoginPageObject(driver);

		loginPage.inputToEmailAddressTextbox("auto_test" + randomNumber() + "@live.com");
		loginPage.inputToPasswordTextbox("123");
		loginPage.clickToLoginButton();

		Assert.assertEquals(loginPage.getPasswordInvalidErrorMessage(), "Please enter 6 or more characters without leading or trailing spaces.");
	}

	@Test
	public void TC_05_Login_Incorrect_Password() {
		// 6 - HomePage -> new LoginPage
		homePage.clickToMyAccountLink();
		loginPage = new UserLoginPageObject(driver);

		loginPage.inputToEmailAddressTextbox("automationfc.vn@gmail.com");
		loginPage.inputToPasswordTextbox(String.valueOf(randomNumber()));
		loginPage.clickToLoginButton();

		Assert.assertEquals(loginPage.getEmailAddressOrPasswordIncorrectErrorMessage(), "Invalid login or password.");
	}

	@Test
	public void TC_06_Login_Valid_Email_And_Password() {
		// 7 - HomePage -> new LoginPage
		homePage.clickToMyAccountLink();	
		loginPage = new UserLoginPageObject(driver);
		
		loginPage.inputToEmailAddressTextbox("automationfc.vn@gmail.com");
		loginPage.inputToPasswordTextbox("123123");
		loginPage.clickToLoginButton();
		
		// 8 - LoginPage -> new MyDashboardPage
		myDashboardPage = new MyDashboardPageObject(driver);
		Assert.assertTrue(myDashboardPage.isContactInfoDisplayed("Automation FC"));
		Assert.assertTrue(myDashboardPage.isContactInfoDisplayed("automationfc.vn@gmail.com"));
	}

	@AfterClass
	public void afterClass() {
		driver.quit();
	}

	private int randomNumber() {
		Random rand = new Random();
		return rand.nextInt(999999);
	}

}