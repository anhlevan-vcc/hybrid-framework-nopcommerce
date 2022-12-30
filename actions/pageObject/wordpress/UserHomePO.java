package pageObject.wordpress;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import pageUIs.wordpress.UserHomePageUI;

public class UserHomePO extends BasePage {
	private WebDriver driver;

	public UserHomePO(WebDriver driver) {
		this.driver = driver;
	}

	public boolean isPostInforDisplayedByTitle(String postTitle) {
		waitForElementVisible(driver, UserHomePageUI.POST_TITLE_TEXT, postTitle);
		return isElementDisplayed(driver, UserHomePageUI.POST_TITLE_TEXT, postTitle);
	}

	public boolean isPostInforDisplayedByBody(String postTitle, String postBody) {
		waitForElementVisible(driver, UserHomePageUI.POST_BODY_TEXT_BY_POST_TITLE, postTitle, postBody);
		return isElementDisplayed(driver, UserHomePageUI.POST_BODY_TEXT_BY_POST_TITLE, postTitle, postBody);
	}

	public boolean isPostInforDisplayedByAuthor(String postTitle, String authorName) {
		waitForElementVisible(driver, UserHomePageUI.POST_AUTHOR_TEXT_BY_POST_TITLE, postTitle, authorName);
		return isElementDisplayed(driver, UserHomePageUI.POST_AUTHOR_TEXT_BY_POST_TITLE, postTitle, authorName);
	}

	public boolean isPostInforDisplayedByDate(String postTitle, String currentDate) {
		waitForElementVisible(driver, UserHomePageUI.POST_CURRENT_DATE_TEXT_BY_POST_TITLE, postTitle, currentDate);
		return isElementDisplayed(driver, UserHomePageUI.POST_CURRENT_DATE_TEXT_BY_POST_TITLE, postTitle, currentDate);
	}

	public UserPostDetailPO clickPostTitle(String postTitle) {
		waitForElementClickable(driver, UserHomePageUI.POST_TITLE_TEXT, postTitle);
		clickToElement(driver, UserHomePageUI.POST_TITLE_TEXT, postTitle);
		return PageGeneratorManager.getUserPostDetailPage(driver);

	}

	public boolean isPostInforUnDisplayedByTitle(String editPostTitle) {
		// waitForElementInvisible(driver, UserHomePageUI.POST_TITLE_TEXT, editPostTitle);
		return isElementUndisplayed(driver, UserHomePageUI.POST_TITLE_TEXT, editPostTitle);
	}

	public void enterToSearchTextbox(String editPostTitle) {
		waitForElementVisible(driver, UserHomePageUI.SEARCH_TEXTBOX);
		sendkeyToElement(driver, UserHomePageUI.SEARCH_TEXTBOX, editPostTitle);
	}

	public UserSearchPostPO clickSearchPostsButton() {
		waitForElementClickable(driver, UserHomePageUI.SEARCH_BUTTON);
		clickToElement(driver, UserHomePageUI.SEARCH_BUTTON);
		return PageGeneratorManager.getUserSearchPostPage(driver);
	}
}
