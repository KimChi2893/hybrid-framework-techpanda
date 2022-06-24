package pageObjects.user;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import pageUIs.user.LoginPageUI;
import pageUIs.user.MyDashboardPageUI;

public class MyDashboardPageObject extends BasePage {
	WebDriver driver;

	public MyDashboardPageObject(WebDriver driver) {
		this.driver = driver;
	}

	public boolean isContactInfoDisplayed(String contactInfor) {
		waitForElementVisible(driver, MyDashboardPageUI.CONTACT_INFOR_TEXT);
		return getElementText(driver, MyDashboardPageUI.CONTACT_INFOR_TEXT).contains(contactInfor);
	}

	public boolean isAccountInformationMessageSavedDisplayed() {
		waitForElementVisible(driver, MyDashboardPageUI.ACCOUNT_INFO_SAVED_MESSAGE);
		return isElementDisplayed(driver, MyDashboardPageUI.ACCOUNT_INFO_SAVED_MESSAGE);
	}

	public boolean isMessageRegisteredDisplayed() {
		waitForElementVisible(driver, MyDashboardPageUI.ACCOUNT_REGISTERED_MESSAGE);
		return isElementDisplayed(driver, MyDashboardPageUI.ACCOUNT_REGISTERED_MESSAGE);
	}

	public void clickToAccountLink() {
		waitForElementClickable(driver, MyDashboardPageUI.ACCOUNT_LINK);
		clickToElement(driver, MyDashboardPageUI.ACCOUNT_LINK);
	}
	
	public HomePageObject clickToLogoutLink() {
		waitForElementClickable(driver, MyDashboardPageUI.LOGOUT_LINK);
		clickToElement(driver, MyDashboardPageUI.LOGOUT_LINK);
		return PageGeneratorManager.getHomePage(driver);
	}
}
