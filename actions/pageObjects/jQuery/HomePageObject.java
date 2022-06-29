package pageObjects.jQuery;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

import commons.BasePage;
import pageUIs.jQuery.HomePageUI;

public class HomePageObject extends BasePage{
	WebDriver driver;
	
	public HomePageObject(WebDriver driver) {
		this.driver = driver;
	}

	public void enterToTextboxByHeaderName(String headerName, String value) {
		waitForElementVisible(driver, HomePageUI.HEADER_TEXTBOX_BY_HEADER_NAME, headerName);
		sendkeyToElement(driver, HomePageUI.HEADER_TEXTBOX_BY_HEADER_NAME, value, headerName);
		pressKeyToElement(driver, HomePageUI.HEADER_TEXTBOX_BY_HEADER_NAME, Keys.ENTER, headerName);
	}

	public boolean isRowValueDisplayed(String femaleValue, String countryName, String maleValue, String totalValue) {
		waitForElementVisible(driver, HomePageUI.ROW_VALUES, femaleValue, countryName, maleValue, totalValue);		
		return isElementDisplayed(driver, HomePageUI.ROW_VALUES, femaleValue, countryName, maleValue, totalValue);
	}

	public void clickToActionIconByCountryName(String countryName, String actionName) {
		waitForElementClickable(driver, HomePageUI.ACTION_ICON_BY_COUNTRY_NAME, countryName, actionName);
		clickToElement(driver, HomePageUI.ACTION_ICON_BY_COUNTRY_NAME, countryName, actionName);
		
	}

	public void clickToPageByNumber(String pageNumber) {
		waitForElementClickable(driver, HomePageUI.PAGING_BY_PAGE_NUMBER, pageNumber);
		clickToElement(driver, HomePageUI.PAGING_BY_PAGE_NUMBER, pageNumber);
		
	}

	public boolean isPageNumberActivated(String pageNumber) {
		waitForElementVisible(driver, HomePageUI.PAGING_ACTIVATED_BY_PAGE_NUMBER, pageNumber);		
		return isElementDisplayed(driver, HomePageUI.PAGING_ACTIVATED_BY_PAGE_NUMBER, pageNumber);
	}

	
	
	
	public void enterToTextboxByHeaderNameAndRowNumber(String headerName, String rowNumber, String valueToInput) {
		// Get the column order based on the column name
		int headerIndex = getListElementSize(driver, HomePageUI.HEADER_INDEX_BY_NAME, headerName);
		
		System.out.println("The column number: " + headerIndex);
		waitForElementVisible(driver, HomePageUI.CELL_TEXTBOX_BY_HEADER_INDEX_ROW_INDEX, rowNumber, String.valueOf(headerIndex));
		sendkeyToElement(driver, HomePageUI.CELL_TEXTBOX_BY_HEADER_INDEX_ROW_INDEX, valueToInput, rowNumber, String.valueOf(headerIndex));
	}

	public void clickToLoadDataButton() {
		waitForElementClickable(driver, HomePageUI.LOAD_DATA_BUTTON);
		clickToElement(driver, HomePageUI.LOAD_DATA_BUTTON);
		
	}
}
