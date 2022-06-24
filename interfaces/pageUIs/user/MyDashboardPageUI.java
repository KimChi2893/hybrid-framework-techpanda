package pageUIs.user;

public class MyDashboardPageUI {
	public static final String CONTACT_INFOR_TEXT = "//h3[text()='Contact Information']/parent::div/following-sibling::div[@class='box-content']";	
	public static final String ACCOUNT_INFO_SAVED_MESSAGE = "//li[@class='success-msg']//span[text()='The account information has been saved.']";
	public static final String ACCOUNT_REGISTERED_MESSAGE = "//li[@class='success-msg']//span[text()='Thank you for registering with Main Website Store.']";
	public static final String ACCOUNT_LINK = "//header[@id='header']//span[text()='Account']";
	public static final String LOGOUT_LINK = "//div[@id='header-account']//a[text()='Log Out']";
}
