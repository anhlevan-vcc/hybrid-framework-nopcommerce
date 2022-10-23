package pageObject;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import pageUIs.AddressPageUI;

public class DownloadableProductsPageObject extends BasePage {
	private WebDriver driver;

	public DownloadableProductsPageObject(WebDriver driver) {
		this.driver = driver;
	}

}
