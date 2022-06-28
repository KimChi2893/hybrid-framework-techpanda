package javaBasic;

public class Topic_02_Dynamic_Locator {
	public static final String ACCOUNT_DASHBOARD_LINK = "xpath=//a[text()='Account Dashboard']";
	public static final String MY_PRODUCT_REVIEW_LINK = "xpath=//a[text()='My Product Reviews']";
	public static final String ACCOUNT_INFORMATION_LINK = "xpath=//a[text()='Account Information']";

	// 1 dynamic parameter (page name)
	public static final String DYNAMIC_SIDEBAR_LINK = "xpath=//a[text()='%s']";

	// 2 dynamic parameters
	public static final String DYNAMIC_SIDEBAR_LINK_EX = "xpath=//a[text(%s)='%s']//input[text()='%s']";
	public static void main(String args[]) {
		clickToElement(DYNAMIC_SIDEBAR_LINK, "Account Dashboard");
		clickToElement(DYNAMIC_SIDEBAR_LINK, "My Product Reviews");
		clickToElement(DYNAMIC_SIDEBAR_LINK, "Account Information");
		clickToElement(DYNAMIC_SIDEBAR_LINK_EX, "ex0", "EX1", "Account Dashboard");
		clickToElement(DYNAMIC_SIDEBAR_LINK_EX,  "ex0", "EX2", "My Product Reviews");

	}

	public static void clickToElement(String locator) {
		System.out.println(locator);
	}
	
	//1-n dynamic params only need 1 function
	// Rest param: final/remaining params 
	public static void clickToElement(String locator, String... values) {
		locator = String.format(locator, (Object[]) values);
		System.out.println(locator);
	}
}
