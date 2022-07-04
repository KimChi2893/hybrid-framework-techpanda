package com.facebook.register;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import commons.BaseTest;
import pageObjects.facebook.LoginPageObject;
import pageObjects.facebook.PageGeneratorManager;

public class Level_15_Element_Undisplayed extends BaseTest {

	@Parameters({ "browser", "url" })
	@BeforeClass
	public void beforeClass(String browserName, String appUrl) {
		driver = getBrowserDriver(browserName, appUrl);
		loginPage = PageGeneratorManager.getLoginPage(driver);
	}

	@Test
	public void TC_01_Verify_Element_Displayed() {
		loginPage.clickToCreateNewAccountButton();

		// If the function having expectation is to verify element displayed -> combine wait & is Displayed
		// waitForElementVisible
		// isElementDisplayed
		
		// Verify True - Confirm Email is expected to display
		loginPage.enterToEmailAddressTextbox("automation@gmail.com");
		loginPage.sleepInSecond(3);
		verifyTrue(loginPage.isConfirmEmailAddressTextboxDisplayed());

	}

	@Test
	public void TC_02_Verify_Element_Undisplayed_In_DOM() {
		// If the function having expectation is to verify element displayed/ undisplayed -> DON'T combine wait
		// waitForElementVisible
		// isElementDisplayed

		// Verify False - Confirm Email is expected to undisplay
		loginPage.enterToEmailAddressTextbox("");
		loginPage.sleepInSecond(3);
		//verifyFalse(loginPage.isConfirmEmailAddressTextboxDisplayed());
		verifyTrue(loginPage.isConfirmEmailAddressTextboxUndisplayed());
	}

	@Test
	public void TC_03_Verify_Element_Undisplayed_Not_In_DOM() {
		loginPage.clickCloseIconAtSignUpForm();
		loginPage.sleepInSecond(3);

		// isDisplayed(): don't apply for the element not in DOM
		//verifyFalse(loginPage.isConfirmEmailAddressTextboxDisplayed());
		verifyTrue(loginPage.isConfirmEmailAddressTextboxUndisplayed());
	}

	@AfterClass
	public void afterClass() {
		driver.quit();
	}

	WebDriver driver;
	private LoginPageObject loginPage;
}
