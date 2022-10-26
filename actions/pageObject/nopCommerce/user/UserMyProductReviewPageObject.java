package pageObject.nopCommerce.user;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import pageUIs.nopCommerce.user.MyProductReviewPageUI;

public class UserMyProductReviewPageObject extends BasePage {
	private WebDriver driver;

	public UserMyProductReviewPageObject(WebDriver driver) {
		this.driver = driver;
	}
}
