package pageObject;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import pageUIs.AddressPageUI;

public class OrdersPageObject extends BasePage {
	private WebDriver driver;

	public OrdersPageObject(WebDriver driver) {
		this.driver = driver;
	}

}
