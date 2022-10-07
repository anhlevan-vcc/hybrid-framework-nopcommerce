package pageFactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import commons.BasePageFactory;

public class LoginPageFactory extends BasePageFactory {
	private WebDriver driver;

	public LoginPageFactory(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(id = "Email")
	private WebElement emailTextbox;

	@FindBy(id = "Password")
	private WebElement passwordTextbox;

	@FindBy(xpath = "//button[text()= 'Log in']")
	private WebElement loginButton;

	@FindBy(id = "Email-error")
	private WebElement emailErrorMessage;

	@FindBy(xpath = "//div[contains(@class,'message-error')]")
	private WebElement existingEmailErrorMassage;

	public void clickToLoginButton() {
		waitForElementClickable(driver, loginButton);
		clickToElement(driver, loginButton);

	}

	public String getErrorMassageEmailTextbox() {
		waitForElementVisible(driver, emailErrorMessage);
		return getElementText(driver, emailErrorMessage);
	}

	public void inputToEmailTextbox(String invalidEmail) {
		waitForElementVisible(driver, emailTextbox);
		sendkeyToElement(driver, emailTextbox, invalidEmail);

	}

	public void inputToPasswordTextbox(String passwword) {
		waitForElementVisible(driver, passwordTextbox);
		sendkeyToElement(driver, passwordTextbox, passwword);

	}

	public String getErrorMassageExistingEmail() {
		waitForElementVisible(driver, existingEmailErrorMassage);
		return getElementText(driver, existingEmailErrorMassage);
	}

	public String getErrorMassageEmplyPassword() {
		waitForElementVisible(driver, existingEmailErrorMassage);
		return getElementText(driver, existingEmailErrorMassage);
	}

}
