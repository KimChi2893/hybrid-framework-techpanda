package pageFactory.user;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import commons.BasePage;
import pageUIs.user.HomePageUI;

public class HomePageObject extends BasePageFactory{

	WebDriver driver;
	
	public HomePageObject(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	// Method 1: Definition 1 element
	@FindBy(xpath = "//div[@class='footer']//a[text()='My Account']")
	WebElement myAccountLink;
	//public static final String MY_ACCOUNT_LINK = "//div[@class='footer']//a[text()='My Account']";
	
	// Method 2: Definition 1 element
	@FindBy(how = How.XPATH, using = "//div[@class='footer']//a[text()='My Account']")
	List<WebElement> footerLinks;
	
	// @FindBy: It only receives 1 locator parameter
	// @FindBys: It receives 2 locator parameters (AND)
	// @FindAll: It receives 2 locator parameters (OR)
	
	// Action
	public void clickToMyAccountLink() {
		waitForElementClickable(driver, myAccountLink);
		clickToElement(driver, myAccountLink);
	}

}
