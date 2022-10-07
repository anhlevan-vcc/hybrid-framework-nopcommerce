package pageFactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import commons.BasePageFactory;

public class HomePageFactory extends BasePageFactory {
	private WebDriver driver;

	public HomePageFactory(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	// UI
	@FindBy(xpath = "//a[text()='Register']")
	private WebElement registerLink;

	@FindBy(xpath = "//a[@class='ico-login']")
	private WebElement loginLink;

	@FindBy(xpath = "//h2[text()='Welcome to our store']")
	private WebElement homeSuccessMassage;

	// Action
	public void clickToRegisterLink() {
		waitForElementVisible(driver, registerLink);
		clickToElement(driver, registerLink);
	}

	public void clickToLoginLink() {
		waitForElementVisible(driver, loginLink);
		clickToElement(driver, loginLink);
	}

	public String getMessageSuccess() {
		waitForElementVisible(driver, homeSuccessMassage);
		return getElementText(driver, homeSuccessMassage);
	}
}
