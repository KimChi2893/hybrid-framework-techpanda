package pageObjects.user;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import pageUIs.user.HomePageUI;

public class HomePageObject extends BasePage{

	// Initialized function - Constructor
	// Call first when initializing a class
	// Same name with the class
	// Don't have the returned data type
	// Have params or not
	// 1 class has 1 initialized function or more
	// If don't write clearly the initialized function, calling this function while running
	// => Default function of the class (the initialized empty function: function name/ not having the body) 
	
	private WebDriver driver;
	
	// Map driver between 2 classes
	// this: Access to the variable belonging the class (global) in the case being same the variable name belonging the function (local)
	public HomePageObject(WebDriver driver) {
		this.driver = driver;
	}
	
	public void clickToMyAccountLink() {
		waitForElementClickable(driver, HomePageUI.MY_ACCOUNT_LINK);
		clickToElement(driver, HomePageUI.MY_ACCOUNT_LINK);
	}

}
