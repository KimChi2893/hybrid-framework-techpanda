package pageObjects.user;

import org.openqa.selenium.WebDriver;

public class PageGeneratorManager {
	public static HomePageObject getHomePage(WebDriver driver)
	{
		return new HomePageObject(driver);
	}
	
	public static RegisterPageObject getRegisterPage(WebDriver driver)
	{
		return new RegisterPageObject(driver);
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
	
	public static MyApplicationPageObject getMyApplicationPageObject(WebDriver driver)
	{
		return new MyApplicationPageObject(driver);
	}
	
	public static MyOrderPageObject getMyOrderPageObject(WebDriver driver)
	{
		return new MyOrderPageObject(driver);
	}
	
	public static MyProductReviewPageObject getMyProductReviewPageObject(WebDriver driver)
	{
		return new MyProductReviewPageObject(driver);
	}
	
}
