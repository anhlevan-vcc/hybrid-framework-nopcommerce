package pageObject.nopCommerce.user;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import pageUIs.nopCommerce.user.CustomerInfoPageUI;

public class UserCustomerInfoPageObject extends BasePage {
	private WebDriver driver;

	public UserCustomerInfoPageObject(WebDriver driver) {
		this.driver = driver;
	}

	public void clickToNewsletterCheckbox() {
		waitForElementClickable(driver, CustomerInfoPageUI.NEWSLETTER_LINK);
		checkToDefaultCheckboxRadio(driver, CustomerInfoPageUI.NEWSLETTER_LINK);
	}

}
