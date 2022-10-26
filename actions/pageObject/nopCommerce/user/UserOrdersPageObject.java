package pageObject.nopCommerce.user;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import pageUIs.nopCommerce.user.AddressPageUI;

public class UserOrdersPageObject extends BasePage {
	private WebDriver driver;

	public UserOrdersPageObject(WebDriver driver) {
		this.driver = driver;
	}

}
