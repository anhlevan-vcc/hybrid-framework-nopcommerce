package pageObject.wordpress.admin;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import pageUIs.wordpress.admin.AdminPostAddNewPageUI;

public class AdminPostAddNewPO extends BasePage {
	private WebDriver driver;

	public AdminPostAddNewPO(WebDriver driver) {
		this.driver = driver;
	}

	public void enterToAddNewPostTitle(String valuePostTitle) {
		waitForElementVisible(driver, AdminPostAddNewPageUI.TITLE_TEXTBOX);
		sendkeyToElement(driver, AdminPostAddNewPageUI.TITLE_TEXTBOX, valuePostTitle);

	}

	public void enterToAddNewPostBody(String valuePostBody) {
		waitForElementClickable(driver, AdminPostAddNewPageUI.BODY_TEXTBOX_BEFORE_CLICK);
		clickToElement(driver, AdminPostAddNewPageUI.BODY_TEXTBOX_BEFORE_CLICK);
		waitForElementVisible(driver, AdminPostAddNewPageUI.BODY_TEXTBOX_AFTER_CLICK);
		sendkeyToElement(driver, AdminPostAddNewPageUI.BODY_TEXTBOX_AFTER_CLICK, valuePostBody);

	}

	public void clickPublishButton() {
		waitForElementClickable(driver, AdminPostAddNewPageUI.PUBLISH_BUTTON);
		clickToElement(driver, AdminPostAddNewPageUI.PUBLISH_BUTTON);

	}

	public void clickPrePublishButton() {
		waitForElementClickable(driver, AdminPostAddNewPageUI.PRE_PUBLISH_BUTTON);
		clickToElement(driver, AdminPostAddNewPageUI.PRE_PUBLISH_BUTTON);

	}

	public boolean isPostPublishMessageDisplayed(String postPublishedMessage) {
		waitForElementVisible(driver, AdminPostAddNewPageUI.PUBLISHED_MESSAGE, postPublishedMessage);
		return isElementDisplayed(driver, AdminPostAddNewPageUI.PUBLISHED_MESSAGE, postPublishedMessage);

	}

	public AdminPostSearchPO openSearchPostPageUrl(String searchPostUrl) {
		openPageUrl(driver, searchPostUrl);
		return PageGeneratorManager.getAdminPostSearchPage(driver);

	}
}
