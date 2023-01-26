package pageObject.wordpress;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import pageUIs.wordpress.AdminDashboardPageUI;

public class AdminDashboardPO extends BasePage {
	private WebDriver driver;

	public AdminDashboardPO(WebDriver driver) {
		this.driver = driver;
	}

	public AdminPostSearchPO clickToPostsMenuLink() {
		waitForElementClickable(driver, AdminDashboardPageUI.POST_MENU_LINK);
		clickToElement(driver, AdminDashboardPageUI.POST_MENU_LINK);
		return PageGeneratorManager.getAdminPostSearchPage(driver);
	}

	public AdminUsersPO clickToUsersMenuLink() {
		waitForElementClickable(driver, AdminDashboardPageUI.USERS_MENU_LINK);
		clickToElement(driver, AdminDashboardPageUI.USERS_MENU_LINK);
		return PageGeneratorManager.getAdminUsersPage(driver);
	}

}
