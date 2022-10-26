package pageObject.nopCommerce.user;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import commons.PageGeneratorManager;
import pageUIs.nopCommerce.user.LoginPageUI;

public class UserLoginPageObject extends BasePage {
	private WebDriver driver;

	public UserLoginPageObject(WebDriver driver) {
		this.driver = driver;
	}

	public UserHomePageObject clickToLoginButton() {
		waitForElementClickable(driver, LoginPageUI.LOGIN_BUTTON);
		clickToElement(driver, LoginPageUI.LOGIN_BUTTON);
		return PageGeneratorManager.getUserHomePage(driver);
	}

	public String getErrorMassageEmailTextbox() {
		waitForElementVisible(driver, LoginPageUI.EMAIL_ERROR_MESSAGE);
		return getElementText(driver, LoginPageUI.EMAIL_ERROR_MESSAGE);
	}

	public void inputToEmailTextbox(String emailAddress) {
		waitForElementVisible(driver, LoginPageUI.EMAIL_TEXTBOX);
		sendkeyToElement(driver, LoginPageUI.EMAIL_TEXTBOX, emailAddress);

	}

	public void inputToPasswordTextbox(String passwword) {
		waitForElementVisible(driver, LoginPageUI.PASSWORD_TEXTBOX);
		sendkeyToElement(driver, LoginPageUI.PASSWORD_TEXTBOX, passwword);

	}

	public String getErrorMassageExistingEmail() {
		waitForElementVisible(driver, LoginPageUI.EXISTING_EMAIL_ERROR_MASSAGE);
		return getElementText(driver, LoginPageUI.EXISTING_EMAIL_ERROR_MASSAGE);
	}

	public String getErrorMassageEmplyPassword() {
		waitForElementVisible(driver, LoginPageUI.EXISTING_EMAIL_ERROR_MASSAGE);
		return getElementText(driver, LoginPageUI.EXISTING_EMAIL_ERROR_MASSAGE);
	}

	public UserHomePageObject loginAsUser(String emailAddress, String passwword) {
		inputToEmailTextbox(emailAddress);
		inputToPasswordTextbox(passwword);
		return clickToLoginButton();
	}

}
