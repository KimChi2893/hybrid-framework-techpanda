package pageObjects.user;

import org.openqa.selenium.WebDriver;

import pageObjects.navigation.PageGeneratorManager;
import pageObjects.navigation.SideBarMyAccountPageObject;
import pageUIs.user.MyDashboardPageUI;

public class MyDashboardPageObject extends SideBarMyAccountPageObject {
	WebDriver driver;

	public MyDashboardPageObject(WebDriver driver) {
		super(driver);
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
}
