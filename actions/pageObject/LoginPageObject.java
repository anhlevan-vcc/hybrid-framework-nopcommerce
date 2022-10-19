package pageObject;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import pageUIs.LoginPageUI;

public class LoginPageObject extends BasePage {
	private WebDriver driver;

	public LoginPageObject(WebDriver driver) {
		this.driver = driver;
	}

	public HomePageObject clickToLoginButton() {
		waitForElementClickable(driver, LoginPageUI.LOGIN_BUTTON);
		clickToElement(driver, LoginPageUI.LOGIN_BUTTON);
		return PageGeneratorManager.getHomePage(driver);
	}

	public String getErrorMassageEmailTextbox() {
		waitForElementVisible(driver, LoginPageUI.EMAIL_ERROR_MESSAGE);
		return getElementText(driver, LoginPageUI.EMAIL_ERROR_MESSAGE);
	}

	public void inputToEmailTextbox(String invalidEmail) {
		waitForElementVisible(driver, LoginPageUI.EMAIL_TEXTBOX);
		sendkeyToElement(driver, LoginPageUI.EMAIL_TEXTBOX, invalidEmail);

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

}
