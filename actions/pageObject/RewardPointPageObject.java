package pageObject;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import pageUIs.RewardPointPageUI;

public class RewardPointPageObject extends BasePage {
	private WebDriver driver;

	public RewardPointPageObject(WebDriver driver) {
		this.driver = driver;
	}

}
