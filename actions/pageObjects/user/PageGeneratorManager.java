package pageObjects.user;

import org.openqa.selenium.WebDriver;

public class PageGeneratorManager {
	public static HomePageObject getHomePage(WebDriver driver)
	{
		return new HomePageObject(driver);
	}
	
	public static LoginPageObject getLoginPage(WebDriver driver)
	{
		return new LoginPageObject(driver);
	}
	
	public static MyDashboardPageObject getMyDashboardPageObject(WebDriver driver)
	{
		return new MyDashboardPageObject(driver);
	}
	
	public static AccountInformationPageObject getAccountInformationPageObject(WebDriver driver)
	{
		return new AccountInformationPageObject(driver);
	}
	
}
