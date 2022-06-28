package pageObjects.navigation;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import pageObjects.user.AccountInformationPageObject;
import pageObjects.user.MyApplicationPageObject;
import pageObjects.user.MyDashboardPageObject;
import pageObjects.user.MyOrderPageObject;
import pageObjects.user.MyProductReviewPageObject;
import pageUIs.navigation.SideBarMyAccountPageUI;

public class SideBarMyAccountPageObject extends BasePage {
	WebDriver driver;

	public SideBarMyAccountPageObject(WebDriver driver) {
		this.driver = driver;
	}

	public MyDashboardPageObject openMyDashboardPage() {
		waitForElementClickable(driver, SideBarMyAccountPageUI.ACCOUNT_DASHBOARD_LINK);
		clickToElement(driver, SideBarMyAccountPageUI.ACCOUNT_DASHBOARD_LINK);
		return PageGeneratorManager.getMyDashboardPage(driver);
	}

	public MyProductReviewPageObject openMyProductReviewPage() {
		waitForElementClickable(driver, SideBarMyAccountPageUI.MY_PRODUCT_REVIEW_LINK);
		clickToElement(driver, SideBarMyAccountPageUI.MY_PRODUCT_REVIEW_LINK);
		return PageGeneratorManager.getMyProductReviewPage(driver);
	}

	public MyApplicationPageObject openMyApplicationPage() {
		waitForElementClickable(driver, SideBarMyAccountPageUI.MY_APPLICATION_LINK);
		clickToElement(driver, SideBarMyAccountPageUI.MY_APPLICATION_LINK);
		return PageGeneratorManager.getMyApplicationPage(driver);
	}

	public MyOrderPageObject openMyOrderPage() {
		waitForElementClickable(driver, SideBarMyAccountPageUI.MY_ORDER_LINK);
		clickToElement(driver, SideBarMyAccountPageUI.MY_ORDER_LINK);
		return PageGeneratorManager.getMyOrderPage(driver);
	}

	public AccountInformationPageObject openAccountInformationPage() {
		waitForElementClickable(driver, SideBarMyAccountPageUI.ACCOUNT_INFORMATION_LINK);
		clickToElement(driver, SideBarMyAccountPageUI.ACCOUNT_INFORMATION_LINK);
		return PageGeneratorManager.getAccountInformationPage(driver);
	}
	
	// Don't return any page. User for the case having a few pages
	public void openSideBarLinkByPageName(String pageName) {
		waitForElementClickable(driver, SideBarMyAccountPageUI.DYNAMIC_SIDE_BAR_LINK, pageName);
		clickToElement(driver, SideBarMyAccountPageUI.DYNAMIC_SIDE_BAR_LINK, pageName);
	}
	
	public SideBarMyAccountPageObject openSideBarLinkByPageNames(String pageName) {
		waitForElementClickable(driver, SideBarMyAccountPageUI.DYNAMIC_SIDE_BAR_LINK, pageName);
		clickToElement(driver, SideBarMyAccountPageUI.DYNAMIC_SIDE_BAR_LINK, pageName);
		
		if (pageName.equals("My Applications")) {
			return PageGeneratorManager.getMyApplicationPage(driver);
		} else if(pageName.equals("My Orders")) {
			return PageGeneratorManager.getMyOrderPage(driver);
		} else if(pageName.equals("My Product Reviews")) {
			return PageGeneratorManager.getMyProductReviewPage(driver);
		} else if(pageName.equals("Account Information")) {
			return PageGeneratorManager.getAccountInformationPage(driver);
		} else if(pageName.equals("Account Dashboard")) {
			return PageGeneratorManager.getMyDashboardPage(driver);
		} else {
			return null;
		}
	}
}
