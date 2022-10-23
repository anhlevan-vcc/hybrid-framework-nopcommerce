package pageObject;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import pageUIs.AddressPageUI;

public class AddressPageObject extends BasePage {
	private WebDriver driver;

	public AddressPageObject(WebDriver driver) {
		this.driver = driver;
	}

}
