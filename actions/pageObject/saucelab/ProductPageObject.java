package pageObject.saucelab;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import pageUIs.sancelab.ProductPageUI;

public class ProductPageObject extends BasePage {

	private WebDriver driver;

	public ProductPageObject(WebDriver driver) {
		this.driver = driver;
	}

	public void selectItemInProductSortDropdown(String textItem) {
		waitForElementClickable(driver, ProductPageUI.PRODUCT_CONTAINER_DROPDOWN);
		selectItemInDefaulfDropdown(driver, ProductPageUI.PRODUCT_CONTAINER_DROPDOWN, textItem);
	}

}
