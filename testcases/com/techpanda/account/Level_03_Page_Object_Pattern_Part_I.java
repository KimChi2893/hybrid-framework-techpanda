package com.techpanda.account;

import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import commons.BasePage;
import pageObjects.user.HomePageObject;
import pageObjects.user.LoginPageObject;
import pageObjects.user.MyDashboardPageObject;

public class Level_03_Page_Object_Pattern_Part_I {
	WebDriver driver;
	String projectPath = System.getProperty("user.dir");
	HomePageObject homePage;
	LoginPageObject loginPage;
	MyDashboardPageObject myDashboardPage;

	@BeforeClass
	public void beforeClass() {
		System.setProperty("webdriver.gecko.driver", projectPath + "/browserDrivers/geckodriver");
		driver = new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.get("http://live.techpanda.org/");

		// 1 - Opening the Url will go to the HomePage
		// 2 - Wanting use the HomePageObject must initialize it

		homePage = new HomePageObject(driver);
	}

	@Test
	public void TC_01_LoginWithEmptyEmailAndPassword() {
		// HomePage -> Click on the My Account link -> Go to the LoginPage
		homePage.clickToMyAccountLink();
		loginPage = new LoginPageObject(driver);

		loginPage.inputToEmailAddressTextbox("");
		loginPage.inputToPasswordTextbox("");
		loginPage.clickToLoginButton();

		Assert.assertEquals(loginPage.getEmailAddressEmptyErrorMessage(), "This is a required field.");
		Assert.assertEquals(loginPage.getPasswordEmptyErrorMessage(), "This is a required field.");
	}

	@Test
	public void TC_02_LoginWithInvalidEmail() {
		// HomePage -> Click on the My Account link -> Go to the LoginPage
		homePage.clickToMyAccountLink();
		loginPage = new LoginPageObject(driver);

		loginPage.inputToEmailAddressTextbox("123@456.789");
		loginPage.inputToPasswordTextbox("123456");
		loginPage.clickToLoginButton();
		Assert.assertEquals(loginPage.getEmailAddressInvalidErrorMessage(), "Please enter a valid email address. For example johndoe@domain.com.");
	}

	@Test
	public void TC_03_LoginWithIncorrectEmail() {
		// HomePage -> Click on the My Account link -> Go to the LoginPage
		homePage.clickToMyAccountLink();
		loginPage = new LoginPageObject(driver);

		loginPage.inputToEmailAddressTextbox("auto_test" + randomNumber() + "@live.com");
		loginPage.inputToPasswordTextbox("123456");
		loginPage.clickToLoginButton();

		Assert.assertEquals(loginPage.getEmailAddressIncorrectErrorMessage(), "Invalid login or password.");
	}

	@Test
	public void TC_04_LoginWithInvalidPassword() {
		// HomePage -> Click on the My Account link -> Go to the LoginPage
		homePage.clickToMyAccountLink();
		loginPage = new LoginPageObject(driver);

		loginPage.inputToEmailAddressTextbox("auto_test" + randomNumber() + "@live.com");
		loginPage.inputToPasswordTextbox("123");
		loginPage.clickToLoginButton();

		Assert.assertEquals(loginPage.getPasswordInvalidErrorMessage(), "Please enter 6 or more characters without leading or trailing spaces.");
	}

	@Test
	public void TC_05_LoginWithIncorrectPassword() {
		// HomePage -> Click on the My Account link -> Go to the LoginPage
		homePage.clickToMyAccountLink();
		loginPage = new LoginPageObject(driver);

		loginPage.inputToEmailAddressTextbox("auto_test" + randomNumber() + "@live.com");
		loginPage.inputToPasswordTextbox(randomNumber() + "");
		loginPage.clickToLoginButton();

		Assert.assertEquals(loginPage.getPasswordIncorrectErrorMessage(), "Invalid login or password.");
	}

	@Test
	public void TC_06_LoginWithValidEmailAndPassword() {
		// HomePage -> Click on the My Account link -> Go to the LoginPage
		homePage.clickToMyAccountLink();
		loginPage = new LoginPageObject(driver);

		loginPage.inputToEmailAddressTextbox("automationfc.vn@gmail.com");
		loginPage.inputToPasswordTextbox("123123");
		loginPage.clickToLoginButton();
		
		myDashboardPage = new MyDashboardPageObject(driver);
		Assert.assertTrue(myDashboardPage.isDisplayedUsername("Automation FC"));
		Assert.assertTrue(myDashboardPage.isDisplayedEmailAddress("automationfc.vn@gmail.com"));
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