package pageFactory.user;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPageObject extends BasePageFactory{
	WebDriver driver;
	
	public LoginPageObject(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(id = "email")
	WebElement emailAddressTextbox;
	
	@FindBy(id = "pass")
	WebElement passwordTextbox;
	
	@FindBy(id = "send2")
	WebElement loginButton;
	
	@FindBy(css = "div[id='advice-required-entry-email']")
	WebElement emailAddressEmptyErrorMessage;
	
	@FindBy(css = "div[id='advice-validate-email-email']")
	WebElement emailAddressInvalidErrorMessage;
	
	@FindBy(css = "div[id='advice-required-entry-pass']")
	WebElement passwordEmptyErrorMessage;
	
	@FindBy(css = "div[id='advice-validate-password-pass']")
	WebElement passwordInvalidErrorMessage;
	
	@FindBy(xpath = "//li[@class='error-msg']//span")
	WebElement emailAddressPasswordIncorrectErrorMessage;
	
	public void inputToEmailAddressTextbox(String emailAddress) {
		waitForElementVisible(driver, emailAddressTextbox);
		sendkeyToElement(driver, emailAddressTextbox, emailAddress);
		
	}

	public void inputToPasswordTextbox(String password) {
		waitForElementVisible(driver, passwordTextbox);
		sendkeyToElement(driver, passwordTextbox, password);		
	}

	public void clickToLoginButton() {
		waitForElementClickable(driver, loginButton);
		clickToElement(driver, loginButton);
		
	}

	public String getEmailAddressEmptyErrorMessage() {
		waitForElementVisible(driver, emailAddressEmptyErrorMessage);
		return getElementText(driver, emailAddressEmptyErrorMessage);
	}

	public String getPasswordEmptyErrorMessage() {
		waitForElementVisible(driver, passwordEmptyErrorMessage);
		return getElementText(driver, passwordEmptyErrorMessage);
	}

	public String getEmailAddressInvalidErrorMessage() {
		waitForElementVisible(driver, emailAddressInvalidErrorMessage);
		return getElementText(driver, emailAddressInvalidErrorMessage);
	}

	public String getEmailAddressOrPasswordIncorrectErrorMessage() {
		waitForElementVisible(driver, emailAddressPasswordIncorrectErrorMessage);
		return getElementText(driver, emailAddressPasswordIncorrectErrorMessage);
	}

	public String getPasswordInvalidErrorMessage() {
		waitForElementVisible(driver, passwordInvalidErrorMessage);
		return getElementText(driver, passwordInvalidErrorMessage);
	}



}

