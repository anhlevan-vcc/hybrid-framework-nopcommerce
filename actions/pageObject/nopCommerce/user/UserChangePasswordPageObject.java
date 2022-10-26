package pageObject.nopCommerce.user;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import pageUIs.nopCommerce.user.AddressPageUI;

public class UserChangePasswordPageObject extends BasePage {
	private WebDriver driver;

	public UserChangePasswordPageObject(WebDriver driver) {
		this.driver = driver;
	}

}
