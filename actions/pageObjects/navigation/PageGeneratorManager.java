package pageObjects.navigation;

import org.openqa.selenium.WebDriver;

import pageObjects.admin.AdminManageCustomerPageObject;
import pageObjects.user.AboutUsPageObject;
import pageObjects.user.AccountInformationPageObject;
import pageObjects.user.MyAccountPageObject;
import pageObjects.user.MyApplicationPageObject;
import pageObjects.user.MyDashboardPageObject;
import pageObjects.user.MyOrderPageObject;
import pageObjects.user.MyProductReviewPageObject;
import pageObjects.user.RegisterPageObject;
import pageObjects.user.SearchTermPageObject;
import pageObjects.user.UserHomePageObject;
import pageObjects.user.UserLoginPageObject;
import pageObjects.admin.AdminLoginPageObject;

public class PageGeneratorManager {
	public static UserHomePageObject getUserHomePage(WebDriver driver)
	{
		return new UserHomePageObject(driver);
	}
	
	public static RegisterPageObject getRegisterPage(WebDriver driver)
	{
		return new RegisterPageObject(driver);
	}
	
	
	public static UserLoginPageObject getUserLoginPage(WebDriver driver)
	{
		return new UserLoginPageObject(driver);
	}
	
	public static MyDashboardPageObject getMyDashboardPage(WebDriver driver)
	{
		return new MyDashboardPageObject(driver);
	}
	
	public static AccountInformationPageObject getAccountInformationPage(WebDriver driver)
	{
		return new AccountInformationPageObject(driver);
	}
	
	public static MyApplicationPageObject getMyApplicationPage(WebDriver driver)
	{
		return new MyApplicationPageObject(driver);
	}
	
	public static MyOrderPageObject getMyOrderPage(WebDriver driver)
	{
		return new MyOrderPageObject(driver);
	}
	
	public static MyProductReviewPageObject getMyProductReviewPage(WebDriver driver)
	{
		return new MyProductReviewPageObject(driver);
	}

	public static AboutUsPageObject getAboutUsPage(WebDriver driver) {
		return new AboutUsPageObject(driver);
	}
	
	public static SearchTermPageObject getSearchTermPage(WebDriver driver) {
		return new SearchTermPageObject(driver);
	}
	
	public static MyAccountPageObject getMyAccountPage(WebDriver driver) {
		return new MyAccountPageObject(driver);
	}
	
	public static AdminManageCustomerPageObject getAdminManageCustomerPage(WebDriver driver)
	{
		return new AdminManageCustomerPageObject(driver);
	}
	
	public static AdminLoginPageObject getAdminLoginPage(WebDriver driver)
	{
		return new AdminLoginPageObject(driver);
	}
	
}
