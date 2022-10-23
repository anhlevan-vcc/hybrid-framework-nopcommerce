package pageObject;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import pageUIs.MyProductReviewPageUI;

public class MyProductReviewPageObject extends BasePage {
	private WebDriver driver;

	public MyProductReviewPageObject(WebDriver driver) {
		this.driver = driver;
	}
}
