package pageObject;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import pageUIs.AddressPageUI;

public class ChangePasswordPageObject extends BasePage {
	private WebDriver driver;

	public ChangePasswordPageObject(WebDriver driver) {
		this.driver = driver;
	}

}
