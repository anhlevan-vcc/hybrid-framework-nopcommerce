package pageObject;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import pageUIs.CustomerInfoPageUI;

public class CustomerInfoPageObject extends BasePage {
	private WebDriver driver;

	public CustomerInfoPageObject(WebDriver driver) {
		this.driver = driver;
	}

	public void clickToNewsletterCheckbox() {
		waitForElementClickable(driver, CustomerInfoPageUI.NEWSLETTER_LINK);
		checkToDefaultCheckboxRadio(driver, CustomerInfoPageUI.NEWSLETTER_LINK);
	}

}
