package pageObject.wordpress;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import pageUIs.wordpress.AdminPostAddNewPageUI;

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

	public void enterToEditPostBody(String valuePostBody) {
		waitForElementClickable(driver, AdminPostAddNewPageUI.BODY_EDIT_TEXTBOX_BEFORE_CLICK);
		clickToElement(driver, AdminPostAddNewPageUI.BODY_EDIT_TEXTBOX_BEFORE_CLICK);
		waitForElementVisible(driver, AdminPostAddNewPageUI.BODY_TEXTBOX_AFTER_CLICK);
		cleanValueInElementByDeleteKey(driver, AdminPostAddNewPageUI.BODY_TEXTBOX_AFTER_CLICK);
		sendkeyToElement(driver, AdminPostAddNewPageUI.BODY_TEXTBOX_AFTER_CLICK, valuePostBody);

	}

	public void clickPublishOrUpdateButton() {
		waitForElementClickable(driver, AdminPostAddNewPageUI.PUBLISH_OR_UPDATE_BUTTON);
		clickToElement(driver, AdminPostAddNewPageUI.PUBLISH_OR_UPDATE_BUTTON);

	}

	public void clickPrePublishButton() {
		waitForElementClickable(driver, AdminPostAddNewPageUI.PRE_PUBLISH_BUTTON);
		clickToElement(driver, AdminPostAddNewPageUI.PRE_PUBLISH_BUTTON);

	}

	public boolean isPostPublishMessageDisplayed(String postPublishedMessage) {
		waitForElementVisible(driver, AdminPostAddNewPageUI.PUBLISHED_OR_UPDATE_MESSAGE, postPublishedMessage);
		return isElementDisplayed(driver, AdminPostAddNewPageUI.PUBLISHED_OR_UPDATE_MESSAGE, postPublishedMessage);

	}

	public AdminPostSearchPO openSearchPostPageUrl(String searchPostUrl) {
		openPageUrl(driver, searchPostUrl);
		return PageGeneratorManager.getAdminPostSearchPage(driver);

	}
}
