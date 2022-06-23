package pageFactory.user;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class MyDashboardPageObject extends BasePageFactory{
	
	WebDriver driver;
	
	public MyDashboardPageObject(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath = "//h3[text()='Contact Information']/parent::div/following-sibling::div[@class='box-content']")
	WebElement contactInfoText;
	public boolean isContactInfoDisplayed(String contactInfor) {
		waitForElementVisible(driver, contactInfoText);
		return getElementText(driver, contactInfoText).contains(contactInfor);
	}
	
}
