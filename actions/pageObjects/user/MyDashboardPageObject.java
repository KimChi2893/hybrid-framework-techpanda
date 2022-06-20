package pageObjects.user;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import commons.BasePage;
import pageUIs.user.MyDashboardPageUI;

public class MyDashboardPageObject extends BasePage {
	WebDriver driver;

	public MyDashboardPageObject(WebDriver driver) {
		this.driver = driver;
	}

	public boolean isDisplayedUsername(String username) {
		waitForElementVisible(driver, MyDashboardPageUI.CONTACT_INFOR_TEXT);
		return getElementText(driver, MyDashboardPageUI.CONTACT_INFOR_TEXT).contains(username);
	}

	public boolean isDisplayedEmailAddress(String emaiAddress) {
		waitForElementVisible(driver, MyDashboardPageUI.CONTACT_INFOR_TEXT);
		return getElementText(driver, MyDashboardPageUI.CONTACT_INFOR_TEXT).contains(emaiAddress);
	}
}
