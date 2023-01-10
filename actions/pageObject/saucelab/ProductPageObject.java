package pageObject.saucelab;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

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

	public boolean isProductNameSortByAscending() {
		// List<String> productUIList = new ArrayList<String>();
		// Khai báo ra 1 ArrayList để chứ các productname trên UI
		ArrayList<String> productUIList = new ArrayList<String>();

		// Lấy ra hết tất cả các text product name
		List<WebElement> productNameText = getListWebElement(driver, ProductPageUI.PRODUCT_NAME_TEXTBOX);

		// Dùng vòng lặp để add tất cả các text vào ArrayList trên
		for (WebElement productName : productNameText) {
			productUIList.add(productName.getText());
		}

		// Tạo ta 1 ArrayList mới để Sort dữ liệu trong ArrayList cũ xem đúng ko
		ArrayList<String> productSortList = new ArrayList<String>();
		for (String product : productUIList) {
			productSortList.add(product);
		}

		// Sort cái productSortList
		Collections.sort(productSortList);

		// So sánh 2 List bằng nhau
		return productSortList.equals(productUIList);
	}

	public boolean isProductNameSortByDescending() {
		// List<String> productUIList = new ArrayList<String>();
		// Khai báo ra 1 ArrayList để chứ các productname trên UI
		ArrayList<String> productUIList = new ArrayList<String>();

		// Lấy ra hết tất cả các text product name
		List<WebElement> productNameText = getListWebElement(driver, ProductPageUI.PRODUCT_NAME_TEXTBOX);

		// Dùng vòng lặp để add tất cả các text vào ArrayList trên
		for (WebElement productName : productNameText) {
			productUIList.add(productName.getText());
		}

		// Tạo ta 1 ArrayList mới để Sort dữ liệu trong ArrayList cũ xem đúng ko
		ArrayList<String> productSortList = new ArrayList<String>();
		for (String product : productUIList) {
			productSortList.add(product);
		}

		// Sort cái productSortList
		Collections.sort(productSortList);

		// Reverse lại cái productSortList đc Descending
		Collections.reverse(productSortList);

		// So sánh 2 List bằng nhau
		return productSortList.equals(productUIList);
	}

	public boolean isProductPriceSortByAscending() {
		// Sort theo giá tiền dùng kiểu dữ liệu Float
		ArrayList<Float> productUIList = new ArrayList<Float>();
		List<WebElement> productPriceText = getListWebElement(driver, ProductPageUI.PRODUCT_PRICE_TEXTBOX);
		for (WebElement productPrice : productPriceText) {
			// Get text giá tiền(đc kiểu String)->xóa ký tự $ ->Ép kiểu qua Float->rồi mới add vào list
			productUIList.add(Float.parseFloat(productPrice.getText().replace("$", "")));
		}

		ArrayList<Float> productSortList = new ArrayList<Float>();
		for (Float product : productUIList) {
			productSortList.add(product);
		}

		Collections.sort(productSortList);
		return productSortList.equals(productUIList);
	}

	public boolean isProductPriceSortByDescending() {
		ArrayList<Float> productUIList = new ArrayList<Float>();
		List<WebElement> productPriceText = getListWebElement(driver, ProductPageUI.PRODUCT_PRICE_TEXTBOX);
		for (WebElement productPrice : productPriceText) {
			// Get text giá tiền(đc kiểu String)->xóa ký tự $ ->Ép kiểu qua Float->rồi mới add vào list
			productUIList.add(Float.parseFloat(productPrice.getText().replace("$", "")));
		}

		ArrayList<Float> productSortList = new ArrayList<Float>();
		for (Float product : productUIList) {
			productSortList.add(product);
		}

		Collections.sort(productSortList);
		// Reverse lại cái productSortList đc Descending
		Collections.reverse(productSortList);
		return productSortList.equals(productUIList);
	}

}
