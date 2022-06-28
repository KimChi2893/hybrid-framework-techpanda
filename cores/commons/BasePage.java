package commons;

import java.util.List;
import java.util.Set;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import pageObjects.admin.AdminLoginPageObject;
import pageObjects.navigation.FooterContainerPageObject;
import pageObjects.navigation.PageGeneratorManager;
import pageObjects.user.UserHomePageObject;
import pageUIs.admin.AdminBasePageUI;
import pageUIs.user.UserBasePageUI;

public class BasePage {
	// This function can initialize 1 object of the BasePage class
	// And then return this object on another class
	public static BasePage getBasePageInstance() {
		return new BasePage();
	}

	public void openPageUrl(WebDriver driver, String pageUrl) {
		driver.get(pageUrl);
	}

	public String getPageUrl(WebDriver driver) {
		return driver.getCurrentUrl();
	}

	public String getPageTitle(WebDriver driver) {
		return driver.getTitle();
	}

	public String getPageSourceCode(WebDriver driver) {
		return driver.getPageSource();
	}

	public void backToPage(WebDriver driver) {
		driver.navigate().back();
	}

	public void forwardToPage(WebDriver driver) {
		driver.navigate().forward();
	}

	public void refreshCurrentPage(WebDriver driver) {
		driver.navigate().refresh();
	}

	public Alert waitForAlertPresence(WebDriver driver) {
		return new WebDriverWait(driver, longTimeout).until(ExpectedConditions.alertIsPresent());
	}

	public void acceptAlert(WebDriver driver) {
		waitForAlertPresence(driver).accept();
	}

	public void cancelAlert(WebDriver driver) {
		waitForAlertPresence(driver).dismiss();
	}

	public void sendkeyToAlert(WebDriver driver, String valueToSendkey) {
		waitForAlertPresence(driver).sendKeys(valueToSendkey);
	}

	public String getAlertText(WebDriver driver) {
		return waitForAlertPresence(driver).getText();
	}

	public void switchToWindowByID(WebDriver driver, String expectedID) {
		Set<String> allWindowIDs = driver.getWindowHandles();

		for (String id : allWindowIDs) {
			if (id.equals(expectedID)) {
				driver.switchTo().window(id);
				break;
			}
		}
	}

	public void switchToWindowByTitle(WebDriver driver, String expectedTitle) {
		Set<String> allWindowIDs = driver.getWindowHandles();

		for (String id : allWindowIDs) {
			driver.switchTo().window(id);
			String actualTitle = driver.getTitle();
			if (actualTitle.equals(expectedTitle)) {
				break;
			}
		}
	}

	public boolean closeAllWindowsWithoutParent(WebDriver driver, String parentID) {
		Set<String> allWindows = driver.getWindowHandles();
		for (String currentWindow : allWindows) {
			if (!currentWindow.equals(parentID)) {
				driver.switchTo().window(currentWindow);
				driver.close();
			}
		}

		driver.switchTo().window(parentID);
		if (driver.getWindowHandles().size() == 1)
			return true;
		else
			return false;
	}

	public String castRestParameter(String locator, String... values) {
		locator = String.format(locator, (Object[])values);
		return locator;	
	}
	// This locator receiving the inputted params is id/ class/ name/ xpath/ css
	// The convention of by locator is id=/ class=/ xpath=/ css=
	// id=/ Id=/ ID=/ iD=
	// This function only uses for this class so can setting its access modifier is private
	private By getByLocator(String locator) {
		By by = null;
		
		if (locator.startsWith("id=") || locator.startsWith("ID=") || locator.startsWith("Id=")) {
			by = By.id(locator.substring(3));
		} else if(locator.startsWith("class=") || locator.startsWith("Class=") || locator.startsWith("CLASS=")) {
			by = By.className(locator.substring(6));
			
		}else if(locator.startsWith("name=") || locator.startsWith("Name=") || locator.startsWith("NAME=")) {
			by = By.name(locator.substring(5));
			
		}else if(locator.startsWith("CSS=") || locator.startsWith("Css=") || locator.startsWith("CSS=")) {
			by = By.cssSelector(locator.substring(4));
			
		}else if(locator.startsWith("xpath=") || locator.startsWith("Xpath=") || locator.startsWith("XPATH=") || locator.startsWith("Xpath=")) {
			by = By.xpath(locator.substring(6));
			
		}else {
			throw new RuntimeException("The locator is not valid");
		}
		
		return by;
	}

	public WebElement getWebElement(WebDriver driver, String locator) {
		return driver.findElement(getByLocator(locator));
	}

	public List<WebElement> getListElement(WebDriver driver, String locator) {
		return driver.findElements(getByLocator(locator));
	}

	public void clickToElement(WebDriver driver, String locator) {
		getWebElement(driver, locator).click();
	}
	
	public void clickToElement(WebDriver driver, String locator, String... values) {
		getWebElement(driver, castRestParameter(locator, values)).click();
	}

	public void sendkeyToElement(WebDriver driver, String locator, String valueToInput) {
		WebElement element = getWebElement(driver, locator);
		element.clear();
		element.sendKeys(valueToInput);
	}
	
	public void sendkeyToElement(WebDriver driver, String locator, String valueToInput, String... values) {
		WebElement element = getWebElement(driver, castRestParameter(locator, values));
		element.clear();
		element.sendKeys(valueToInput);
	}

	public void selectItemInDefaultDropdown(WebDriver driver, String locator, String itemText) {
		Select select = new Select(getWebElement(driver, locator));
		select.deselectByVisibleText(itemText);
	}
	
	public void selectItemInDefaultDropdown(WebDriver driver, String locator, String itemText, String... values) {
		Select select = new Select(getWebElement(driver, castRestParameter(locator, values)));
		select.deselectByVisibleText(itemText);
	}

	public String getFirstSelectedTextItem(WebDriver driver, String locator) {
		Select select = new Select(getWebElement(driver, locator));
		return select.getFirstSelectedOption().getText();
	}
	
	public String getFirstSelectedTextItem(WebDriver driver, String locator, String... values) {
		Select select = new Select(getWebElement(driver, castRestParameter(locator, values)));
		return select.getFirstSelectedOption().getText();
	}

	public boolean isDropdownMultiple(WebDriver driver, String locator) {
		Select select = new Select(getWebElement(driver, locator));
		return select.isMultiple();
	}

	public boolean isDropdownMultiple(WebDriver driver, String locator, String... values) {
		Select select = new Select(getWebElement(driver, castRestParameter(locator, values)));
		return select.isMultiple();
	}
	
	public void selectItemInCustomDropdown(WebDriver driver, String parentLocator, String childLocator, String expectedTextItem) {
		clickToElement(driver, parentLocator);
		sleepInSecond(2);

		List<WebElement> childItems = new WebDriverWait(driver, 30).until(ExpectedConditions.presenceOfAllElementsLocatedBy(getByLocator(childLocator)));
		for (WebElement tempElement : childItems) {
			if (tempElement.getText().trim().equals(expectedTextItem)) {
				((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(false);", tempElement);
				sleepInSecond(1);
				// jsExecutor.executeScript("arguments[0].click;", tempElement);
				tempElement.click();
				sleepInSecond(1);
				break;
			}
		}
	}

	public String getElementText(WebDriver driver, String locator) {
		return getWebElement(driver, locator).getText();
	}

	public String getElementText(WebDriver driver, String locator, String... values) {
		return getWebElement(driver, castRestParameter(locator, values)).getText();
	}
	
	public String getElementAttribute(WebDriver driver, String locator, String attributeName) {
		return getWebElement(driver, locator).getAttribute(attributeName);
	}
	
	public String getElementAttribute(WebDriver driver, String locator, String attributeName, String... values) {
		return getWebElement(driver, castRestParameter(locator, values)).getAttribute(attributeName);
	}

	public String getElementCssValue(WebDriver driver, String locator, String propertyName) {
		return getWebElement(driver, locator).getCssValue(propertyName);
	}
	
	public String getElementCssValue(WebDriver driver, String locator, String propertyName, String... values) {
		return getWebElement(driver, castRestParameter(locator, values)).getCssValue(propertyName);
	}

	public int getListElementSize(WebDriver driver, String locator) {
		return getListElement(driver, locator).size();

	}

	public int getListElementSize(WebDriver driver, String locator, String... values) {
		return getListElement(driver, castRestParameter(locator, values)).size();

	}
	
	public void checkToCheckboxOrRadio(WebDriver driver, String locator) {
		WebElement element = getWebElement(driver, locator);
		if (!element.isSelected()) {
			element.click();
		}
	}
	
	public void checkToCheckboxOrRadio(WebDriver driver, String locator, String... values) {
		WebElement element = getWebElement(driver, castRestParameter(locator, values));
		if (!element.isSelected()) {
			element.click();
		}
	}

	public void uncheckToCheckbox(WebDriver driver, String locator) {
		WebElement element = getWebElement(driver, locator);
		if (element.isSelected()) {
			element.click();
		}
	}
	
	public void uncheckToCheckbox(WebDriver driver, String locator, String... values) {
		WebElement element = getWebElement(driver, castRestParameter(locator, values));
		if (element.isSelected()) {
			element.click();
		}
	}

	public boolean isElementDisplayed(WebDriver driver, String locator) {
		return getWebElement(driver, locator).isDisplayed();
	}
	
	public boolean isElementDisplayed(WebDriver driver, String locator, String... values) {
		return getWebElement(driver, castRestParameter(locator, values)).isDisplayed();
	}

	public boolean isElementEnabled(WebDriver driver, String locator) {
		return getWebElement(driver, locator).isEnabled();
	}

	public boolean isElementEnabled(WebDriver driver, String locator, String... values) {
		return getWebElement(driver, castRestParameter(locator, values)).isEnabled();
	}
	
	public boolean isElementSelected(WebDriver driver, String locator) {
		return getWebElement(driver, locator).isSelected();
	}

	public boolean isElementSelected(WebDriver driver, String locator, String... values) {
		return getWebElement(driver, castRestParameter(locator, values)).isSelected();
	}
	public void switchToIframe(WebDriver driver, String locator) {
		driver.switchTo().frame(getWebElement(driver, locator));
	}

	public void switchToDefaultContent(WebDriver driver) {
		driver.switchTo().defaultContent();
	}

	public void hoverMouseToElement(WebDriver driver, String locator) {
		Actions action = new Actions(driver);
		action.moveToElement(getWebElement(driver, locator)).perform();
	}

	public void rightClickToElement(WebDriver driver, String locator) {
		Actions action = new Actions(driver);
		action.contextClick(getWebElement(driver, locator)).perform();
	}

	public void doubleClickToElement(WebDriver driver, String locator) {
		Actions action = new Actions(driver);
		action.doubleClick(getWebElement(driver, locator)).perform();
	}

	public void dragAndDropElement(WebDriver driver, String sourceLocator, String targetLocator) {
		Actions action = new Actions(driver);
		action.dragAndDrop(getWebElement(driver, sourceLocator), getWebElement(driver, targetLocator)).perform();
		;
	}

	public void pressKeyToElement(WebDriver driver, String locator, Keys key) {
		Actions action = new Actions(driver);
		action.sendKeys(getWebElement(driver, locator), key).perform();
	}

	public void hightlightElement(WebDriver driver, String locator) {
		WebElement element = getWebElement(driver, locator);
		String originalStyle = element.getAttribute("style");
		JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
		jsExecutor.executeScript("arguments[0].setAttribute('style', arguments[1])", element, "border: 2px solid red; border-style: dashed;");
		sleepInSecond(1);
		jsExecutor.executeScript("arguments[0].setAttribute('style', arguments[1])", element, originalStyle);
	}

	public void clickToElementByJS(WebDriver driver, String locator) {
		((JavascriptExecutor) driver).executeScript("arguments[0].click();", getWebElement(driver, locator));
	}

	public void scrollToElementOnTop(WebDriver driver, String locator) {
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", getWebElement(driver, locator));
	}

	public void scrollToElementOnDown(WebDriver driver, String locator) {
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(false);", getWebElement(driver, locator));
	}

	public void sendkeyToElementByJS(WebDriver driver, String locator, String value) {
		((JavascriptExecutor) driver).executeScript("arguments[0].setAttribute('value', '" + value + "')", getWebElement(driver, locator));
	}

	public void removeAttributeInDOM(WebDriver driver, String locator, String attributeRemove) {
		((JavascriptExecutor) driver).executeScript("arguments[0].removeAttribute('" + attributeRemove + "');", getWebElement(driver, locator));
	}

	public String getElementValidationMessage(WebDriver driver, By byLocator) {
		return (String) ((JavascriptExecutor) driver).executeScript("return arguments[0].validationMessage;", driver.findElement(byLocator));
	}

	public boolean isImageLoaded(WebDriver driver, String locator) {
		boolean status = (boolean) ((JavascriptExecutor) driver).executeScript("return arguments[0].complete && typeof arguments[0].naturalWidth != 'undefined' && arguments[0].naturalWidth > 0", getWebElement(driver, locator));
		if (status) {
			return true;
		}
		return false;
	}

	public void waitForElementVisible(WebDriver driver, String locator) {
		new WebDriverWait(driver, longTimeout).until(ExpectedConditions.visibilityOfElementLocated(getByLocator(locator)));

	}
	
	public void waitForElementVisible(WebDriver driver, String locator, String... values) {
		new WebDriverWait(driver, longTimeout).until(ExpectedConditions.visibilityOfElementLocated(getByLocator(castRestParameter(locator, values))));

	}

	public void waitForElementInvisible(WebDriver driver, String locator) {
		new WebDriverWait(driver, longTimeout).until(ExpectedConditions.invisibilityOfElementLocated(getByLocator(locator)));
	}
	
	public void waitForElementInvisible(WebDriver driver, String locator, String... values) {
		new WebDriverWait(driver, longTimeout).until(ExpectedConditions.invisibilityOfElementLocated(getByLocator(castRestParameter(locator, values))));
	}

	public void waitForElementClickable(WebDriver driver, String locator) {
		new WebDriverWait(driver, longTimeout).until(ExpectedConditions.elementToBeClickable(getByLocator(locator)));
	}
	
	public void waitForElementClickable(WebDriver driver, String locator, String... values) {
		new WebDriverWait(driver, longTimeout).until(ExpectedConditions.elementToBeClickable(getByLocator(castRestParameter(locator, values))));
	}

	public FooterContainerPageObject getFooterContainerPage(WebDriver driver) {
		return new FooterContainerPageObject(driver);
	}

	public AdminLoginPageObject openAdminLoginPage(WebDriver driver, String adminUrl) {
		openPageUrl(driver, adminUrl);
		return PageGeneratorManager.getAdminLoginPage(driver);
	}

	public UserHomePageObject openUserHomePage(WebDriver driver, String userUrl) {
		openPageUrl(driver, userUrl);
		return PageGeneratorManager.getUserHomePage(driver);
	}

	private void sleepInSecond(long second) {
		try {
			Thread.sleep(second);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public UserHomePageObject clickToUserLogoutLink(WebDriver driver) {
		waitForElementClickable(driver, UserBasePageUI.HEADER_ACCOUNT_LINK);
		clickToElement(driver, UserBasePageUI.HEADER_ACCOUNT_LINK);

		waitForElementClickable(driver, UserBasePageUI.HEADER_LOGOUT_LINK);
		clickToElement(driver, UserBasePageUI.HEADER_LOGOUT_LINK);
		return PageGeneratorManager.getUserHomePage(driver);
	}

	public AdminLoginPageObject clickToAdminLogoutLink(WebDriver driver) {
		waitForElementClickable(driver, AdminBasePageUI.LOGOUT_LINK);
		clickToElement(driver, AdminBasePageUI.LOGOUT_LINK);
		return PageGeneratorManager.getAdminLoginPage(driver);
	}

	private long longTimeout = GlobalConstants.LONG_TIMEOUT;
}
