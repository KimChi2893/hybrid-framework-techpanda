package com.techpanda.account;

import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import commons.BasePage;
import commons.BaseTest;
import pageObjects.user.HomePageObject;
import pageObjects.user.LoginPageObject;
import pageObjects.user.MyDashboardPageObject;

public class Level_06_Page_Generator_II extends BaseTest{
	WebDriver driver;
	HomePageObject homePage;
	LoginPageObject loginPage;
	MyDashboardPageObject myDashboardPage;

	@Parameters("browser")
	@BeforeClass
	public void beforeClass(String browserName) {
		driver = getBrowserDriver(browserName);	
		homePage = new HomePageObject(driver);
	}

	@Test
	public void TC_01_Login_Empty_Email_And_Password() {
		loginPage = homePage.clickToMyAccountLink();
		
		loginPage.inputToEmailAddressTextbox("");
		loginPage.inputToPasswordTextbox("");
		loginPage.clickToLoginButton();

		Assert.assertEquals(loginPage.getEmailAddressEmptyErrorMessage(), "This is a required field.");
		Assert.assertEquals(loginPage.getPasswordEmptyErrorMessage(), "This is a required field.");
	}

	@Test
	public void TC_02_Login_Invalid_Email() {
		loginPage = homePage.clickToMyAccountLink();

		loginPage.inputToEmailAddressTextbox("123@456.789");
		loginPage.inputToPasswordTextbox("123456");
		loginPage.clickToLoginButton();
		Assert.assertEquals(loginPage.getEmailAddressInvalidErrorMessage(), "Please enter a valid email address. For example johndoe@domain.com.");
	}

	@Test
	public void TC_03_Login_Incorrect_Email() {
		loginPage = homePage.clickToMyAccountLink();

		loginPage.inputToEmailAddressTextbox("auto_test" + getRandomNumber() + "@live.com");
		loginPage.inputToPasswordTextbox("123456");
		loginPage.clickToLoginButton();

		Assert.assertEquals(loginPage.getEmailAddressOrPasswordIncorrectErrorMessage(), "Invalid login or password.");
	}

	@Test
	public void TC_04_Login_Invalid_Password() {
		loginPage = homePage.clickToMyAccountLink();

		loginPage.inputToEmailAddressTextbox("auto_test" + getRandomNumber() + "@live.com");
		loginPage.inputToPasswordTextbox("123");
		loginPage.clickToLoginButton();

		Assert.assertEquals(loginPage.getPasswordInvalidErrorMessage(), "Please enter 6 or more characters without leading or trailing spaces.");
	}

	@Test
	public void TC_05_Login_Incorrect_Password() {
		loginPage = homePage.clickToMyAccountLink();

		loginPage.inputToEmailAddressTextbox("automationfc.vn@gmail.com");
		loginPage.inputToPasswordTextbox(String.valueOf(getRandomNumber()));
		loginPage.clickToLoginButton();

		Assert.assertEquals(loginPage.getEmailAddressOrPasswordIncorrectErrorMessage(), "Invalid login or password.");
	}

	@Test
	public void TC_06_Login_Valid_Email_And_Password() {
		loginPage = homePage.clickToMyAccountLink();
		
		loginPage.inputToEmailAddressTextbox("automationfc.vn@gmail.com");
		loginPage.inputToPasswordTextbox("123123");
				
		myDashboardPage = loginPage.clickToLoginButton();
		Assert.assertTrue(myDashboardPage.isContactInfoDisplayed("Automation FC"));
		Assert.assertTrue(myDashboardPage.isContactInfoDisplayed("automationfc.vn@gmail.com"));
	}

	@AfterClass
	public void afterClass() {
		driver.quit();
	}
}