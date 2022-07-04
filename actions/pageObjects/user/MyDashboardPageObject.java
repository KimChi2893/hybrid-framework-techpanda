package pageObjects.user;

import org.openqa.selenium.WebDriver;
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

	public String getSaveSuccessAccountInformationMessage() {
		waitForElementVisible(driver, MyDashboardPageUI.ACCOUNT_INFO_SAVED_MESSAGE);
		return getElementText(driver, MyDashboardPageUI.ACCOUNT_INFO_SAVED_MESSAGE);
	}

	public String getRegisterSuccessMessage() {
		waitForElementVisible(driver, MyDashboardPageUI.ACCOUNT_REGISTERED_MESSAGE);
		return getElementText(driver, MyDashboardPageUI.ACCOUNT_REGISTERED_MESSAGE);
	}
}
