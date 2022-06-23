package pageObjects.user;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import pageUIs.user.AccountInformationPageUI;

public class AccountInformationPageObject extends BasePage{

	WebDriver driver;
	
	public AccountInformationPageObject(WebDriver driver) {
		this.driver = driver;
	}

	public void enterToFirstNameTextbox(String firstName) {
		waitForElementVisible(driver, AccountInformationPageUI.FIRSTNAME_TEXTBOX);
		sendkeyToElement(driver, AccountInformationPageUI.FIRSTNAME_TEXTBOX, firstName);
	}

	public void enterToLastNameTextbox(String lastName) {
		waitForElementVisible(driver, AccountInformationPageUI.LASTNAME_TEXTBOX);
		sendkeyToElement(driver, AccountInformationPageUI.LASTNAME_TEXTBOX, lastName);
		
	}

	public void enterToEmailAddressTextbox(String emailAddress) {
		waitForElementVisible(driver, AccountInformationPageUI.EMAIL_ADDRESS_TEXTBOX);
		sendkeyToElement(driver, AccountInformationPageUI.EMAIL_ADDRESS_TEXTBOX, emailAddress);
		
	}

	public void enterToCurrentPasswordTextbox(String currentPassword) {
		waitForElementVisible(driver, AccountInformationPageUI.CURRENT_PASSWORD_TEXTBOX);
		sendkeyToElement(driver, AccountInformationPageUI.CURRENT_PASSWORD_TEXTBOX, currentPassword);
		
	}

	public MyDashboardPageObject clickToSaveButton() {
		waitForElementClickable(driver, AccountInformationPageUI.SAVE_BUTTON);
		clickToElement(driver, AccountInformationPageUI.SAVE_BUTTON);
		return PageGeneratorManager.getMyDashboardPageObject(driver);
	}	
}
