package pageObject.wordpress.admin;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import pageUIs.wordpress.admin.AdminLoginPageUI;

public class AdminLoginPO extends BasePage {
	private WebDriver driver;

	public AdminLoginPO(WebDriver driver) {
		this.driver = driver;
	}

	public void enterToUsernameTextbox(String adminUserName) {
		waitForElementVisible(driver, AdminLoginPageUI.USERNAME_TEXTBOX);
		sendkeyToElement(driver, AdminLoginPageUI.USERNAME_TEXTBOX, adminUserName);

	}

	public void enterToPasswordTextbox(String adminPassword) {
		waitForElementVisible(driver, AdminLoginPageUI.PASSWORD_TEXTBOX);
		sendkeyToElement(driver, AdminLoginPageUI.PASSWORD_TEXTBOX, adminPassword);

	}

	public AdminDashboardPO clickToLoginButton() {
		waitForElementClickable(driver, AdminLoginPageUI.LOGIN_BUTTON);
		clickToElement(driver, AdminLoginPageUI.LOGIN_BUTTON);
		return PageGeneratorManager.getAdminDashboardPage(driver);
	}

}
