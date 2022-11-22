package pageObject.jQuery.DataTable;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import commons.BasePage;
import pageUIs.jQuery.DataTable.HomePageUI;

public class HomePageObject extends BasePage {
	WebDriver driver;

	public HomePageObject(WebDriver driver) {
		this.driver = driver;
	}

	public void openPagingByPageNumber(String pageNumber) {
		waitForElementClickable(driver, HomePageUI.PAGINATION_PAGE_BY_NUMBER, pageNumber);
		clickToElement(driver, HomePageUI.PAGINATION_PAGE_BY_NUMBER, pageNumber);
	}

	public void inputToHeaderTextboxByLabel(String headerLabel, String value) {
		waitForElementVisible(driver, HomePageUI.HEADER_TEXTBOX_BY_LABEL_NAME, headerLabel);
		sendkeyToElement(driver, HomePageUI.HEADER_TEXTBOX_BY_LABEL_NAME, value, headerLabel);
		pressKeyToElement(driver, HomePageUI.HEADER_TEXTBOX_BY_LABEL_NAME, Keys.ENTER, headerLabel);
	}

	public boolean isPageNumberActived(String pageNumber) {
		waitForElementVisible(driver, HomePageUI.PAGINATION_PAGE_ACTIVED_BY_NUMBER, pageNumber);
		return isElementDisplayed(driver, HomePageUI.PAGINATION_PAGE_ACTIVED_BY_NUMBER, pageNumber);
	}

	public List<String> getAllValueEachRowAtAllPage() {
		int totalPage = getElementSize(driver, HomePageUI.TOTAL_PAGINAION);
		System.out.println("Total size = " + totalPage);

		// thay list bằng set thì nó sẽ lấy ra 1 giá trị duy nhất nếu trùng
		List<String> allRowValueAllPage = new ArrayList<String>();

		// Duyệt qua tất cả các page number
		for (int index = 1; index <= totalPage; index++) {
			clickToElement(driver, HomePageUI.PAGINATION_PAGE_ALL_INDEX, String.valueOf(index));
			sleepInSecond(1);
			// Get text tất cả các row mỗi page đưa vào ArrayList
			List<WebElement> allRowValueEachPage = getListWebElement(driver, HomePageUI.ALL_ROW_EACH_PAGE);
			for (WebElement eachRow : allRowValueEachPage) {
				allRowValueAllPage.add(eachRow.getText());

			}
		}
		// in ra tất cả giá trị - của tất cả các page
		for (String value : allRowValueAllPage) {
			System.out.println("------------");
			System.out.println(value);
		}

		return allRowValueAllPage;
	}

	public List<String> getCustomColumAllPage(String headerLabel) {
		int totalPage = getElementSize(driver, HomePageUI.TOTAL_PAGINAION);
		System.out.println("Total size = " + totalPage);

		// thay list bằng set thì nó sẽ lấy ra 1 giá trị duy nhất nếu trùng
		List<String> customColumAllPage = new ArrayList<String>();

		// Duyệt qua tất cả các page number
		for (int index = 1; index <= totalPage; index++) {
			clickToElement(driver, HomePageUI.PAGINATION_PAGE_ALL_INDEX, String.valueOf(index));
			// sleepInSecond(1);
			// Get text tất cả các row mỗi page đưa vào ArrayList
			List<WebElement> customRowValueEachPage = getListWebElement(driver, HomePageUI.CUSTOM_ROW_ALL_PAGE, headerLabel);
			for (WebElement eachRow : customRowValueEachPage) {
				customColumAllPage.add(eachRow.getText());

			}
		}
		// in ra tất cả giá trị - của tất cả các page
		for (String value : customColumAllPage) {
			System.out.println("------------");
			System.out.println(value);
		}

		return customColumAllPage;
	}

	public Set<String> getCustomColumAllPageNotDuplicate(String headerLabel) {
		int totalPage = getElementSize(driver, HomePageUI.TOTAL_PAGINAION);
		System.out.println("Total size = " + totalPage);

		// thay list bằng set thì nó sẽ lấy ra 1 giá trị duy nhất nếu trùng
		// List<String> customColumAllPage = new ArrayList<String>();

		Set<String> customColumAllPage = new HashSet<String>();

		// Duyệt qua tất cả các page number
		for (int index = 1; index <= totalPage; index++) {
			clickToElement(driver, HomePageUI.PAGINATION_PAGE_ALL_INDEX, String.valueOf(index));
			// sleepInSecond(1);
			// Get text tất cả các row mỗi page đưa vào ArrayList
			List<WebElement> customRowValueEachPage = getListWebElement(driver, HomePageUI.CUSTOM_ROW_ALL_PAGE, headerLabel);
			for (WebElement eachRow : customRowValueEachPage) {
				customColumAllPage.add(eachRow.getText());

			}
		}
		// in ra tất cả giá trị - của tất cả các page
		for (String value : customColumAllPage) {
			System.out.println("------------");
			System.out.println(value);
		}

		return customColumAllPage;
	}

	public void enterToTextboxByColumnNameAtRowNumber(String columnName, String rowNumber, String valueToSenkey) {
		int columnIndex = getElementSize(driver, HomePageUI.COLUMN_INDEX_BY_NAME, columnName) + 1;

		waitForElementVisible(driver, HomePageUI.TEXTBOX_BY_COLUMN_INDEX_AND_ROW_INDEX, rowNumber, String.valueOf(columnIndex));
		sendkeyToElement(driver, HomePageUI.TEXTBOX_BY_COLUMN_INDEX_AND_ROW_INDEX, valueToSenkey, rowNumber, String.valueOf(columnIndex));

	}

	public void selectDropdownByColumnNameAtRowNumber(String columnName, String rowNumber, String valueToSelect) {
		int columnIndex = getElementSize(driver, HomePageUI.COLUMN_INDEX_BY_NAME, columnName) + 1;

		waitForElementClickable(driver, HomePageUI.DROPDOWN_BY_COLUMN_INDEX_AND_ROW_INDEX, rowNumber, String.valueOf(columnIndex));
		selectItemInDefaulfDropdown(driver, HomePageUI.DROPDOWN_BY_COLUMN_INDEX_AND_ROW_INDEX, valueToSelect, rowNumber, String.valueOf(columnIndex));

	}

	public void clickToLoadButton() {
		waitForElementClickable(driver, HomePageUI.LOAD_BUTTON);
		clickToElement(driver, HomePageUI.LOAD_BUTTON);

	}

	public void checkToCheckBoxByColumnNameAtRowNumber(String columnName, String rowNumber) {
		int columnIndex = getElementSize(driver, HomePageUI.COLUMN_INDEX_BY_NAME, columnName) + 1;
		waitForElementClickable(driver, HomePageUI.CHECKBOX_BY_COLUMN_INDEX_AND_ROW_INDEX, rowNumber, String.valueOf(columnIndex));
		checkToDefaultCheckboxRadio(driver, HomePageUI.CHECKBOX_BY_COLUMN_INDEX_AND_ROW_INDEX, rowNumber, String.valueOf(columnIndex));
	}

	public void unCheckToCheckBoxByColumnNameAtRowNumber(String columnName, String rowNumber) {
		int columnIndex = getElementSize(driver, HomePageUI.COLUMN_INDEX_BY_NAME, columnName) + 1;
		waitForElementClickable(driver, HomePageUI.CHECKBOX_BY_COLUMN_INDEX_AND_ROW_INDEX, rowNumber, String.valueOf(columnIndex));
		unCheckToDefaultCheckbox(driver, HomePageUI.CHECKBOX_BY_COLUMN_INDEX_AND_ROW_INDEX, rowNumber, String.valueOf(columnIndex));
	}

	public void clickToIconByRowNumber(String columnName, String iconNumber) {
		waitForElementClickable(driver, HomePageUI.ICONNAME_BY_ROW_NUMBER, columnName, iconNumber);
		clickToElement(driver, HomePageUI.ICONNAME_BY_ROW_NUMBER, columnName, iconNumber);
	}

}
