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

	public boolean isContactInfoDisplayed(String contactInfor) {
		waitForElementVisible(driver, MyDashboardPageUI.CONTACT_INFOR_TEXT);
		return getElementText(driver, MyDashboardPageUI.CONTACT_INFOR_TEXT).contains(contactInfor);
	}

	public AccountInformationPageObject clickToAccountInformationLink() {
		waitForElementClickable(driver, MyDashboardPageUI.ACCOUNT_INFORMATION_LINK);
		clickToElement(driver, MyDashboardPageUI.ACCOUNT_INFORMATION_LINK);
		return PageGeneratorManager.getAccountInformationPageObject(driver);
	}

	public boolean isAccountInformationMessageSavedDisplayed() {
		waitForElementVisible(driver, MyDashboardPageUI.ACCOUNT_INFO_SAVED_MESSAGE);
		return isElementDisplayed(driver, MyDashboardPageUI.ACCOUNT_INFO_SAVED_MESSAGE);
	}
}
