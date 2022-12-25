package pageObject.wordpress.admin;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import pageUIs.wordpress.admin.AdminDashboardPageUI;

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
}
