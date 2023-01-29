package com.wordpress.admin;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import commons.BaseTest;
import pageObject.wordpress.AdminDashboardPO;
import pageObject.wordpress.AdminLoginPO;
import pageObject.wordpress.AdminPostAddNewPO;
import pageObject.wordpress.AdminPostSearchPO;
import pageObject.wordpress.PageGeneratorManager;
import pageObject.wordpress.UserHomePO;
import pageObject.wordpress.UserPostDetailPO;
import pageObject.wordpress.UserSearchPostPO;

public class RunBrowserstackCloud_Create_Read_Update_Del_Search extends BaseTest {
	private WebDriver driver;
	AdminLoginPO adminLoginpage;
	AdminDashboardPO adminDashboardPage;
	AdminPostSearchPO adminPostSearchPage;
	AdminPostAddNewPO adminPostAddNewPage;
	UserHomePO userHomePage;
	UserPostDetailPO userPostDetailPage;
	UserSearchPostPO userSearchPostPage;

	String adminUserName = "leanh_192";
	String adminPassword = "Doncoi@16193";
	String searchPostUrl;
	String generateRandomNumber = String.valueOf(generateRandomNumber());
	String postTitle = "Title hôm nay học Live Coding " + generateRandomNumber;
	String postBody = "Body hôm nay học Live Coding " + generateRandomNumber;
	String editPostTitle = "Edit title hôm nay học Live Coding " + generateRandomNumber;
	String editPostBody = "Edit body hôm nay học Live Coding " + generateRandomNumber;
	String authorName = "Lê Anh";
	String adminUrl, endUserUrl;
	String currentDate = getCurentDate();

	@Parameters({ "browser", "urlAdmin", "urlUser", "osName", "osVersion", "browserVersion" })
	@BeforeClass
	public void beforeClass(String browserName, String adminUrl, String endUserUrl, String osName, String osVersion, String browserVersion) {
		this.adminUrl = adminUrl;
		this.endUserUrl = endUserUrl;
		log.info("Pre-Condition - Step 01: Open browser Admin site");
		driver = getBrowserDriverBrowserstack(browserName, this.adminUrl, osName, osVersion, browserVersion);

		adminLoginpage = PageGeneratorManager.getAdminLoginPage(driver);

		log.info("Pre-Condition - Step 02: Enter to Username textbox :" + adminUserName);
		adminLoginpage.enterToUsernameTextbox(adminUserName);

		log.info("Pre-Condition - Step 03: Enter to Password textbox :" + adminPassword);
		adminLoginpage.enterToPasswordTextbox(adminPassword);

		log.info("Pre-Condition - Step 04: Click to login button");
		adminDashboardPage = adminLoginpage.clickToLoginButton();

	}

	@Test
	public void Post_01_Create_New_Post() {
		log.info("Create Post - Step 01: Click to 'Posts' menu link");
		adminPostSearchPage = adminDashboardPage.clickToPostsMenuLink();

		log.info("Create Post - Step 02: Get 'Search Post' Url");
		searchPostUrl = adminPostSearchPage.getPageUrl(driver);

		log.info("Create Post - Step 03: Click to 'Add New' button");
		adminPostAddNewPage = adminPostSearchPage.clickToAddNewButton();

		log.info("Create Post - Step 04: Enter to Post title:" + postTitle);
		adminPostAddNewPage.enterToAddNewPostTitle(postTitle);

		log.info("Create Post - Step 05: Enter to Post body :" + postBody);
		adminPostAddNewPage.enterToAddNewPostBody(postBody);

		log.info("Create Post - Step 06: Click to 'Publish' button");
		adminPostAddNewPage.clickPublishOrUpdateButton();

		log.info("Create Post - Step 07: Click to 'Pre Publish' button");
		adminPostAddNewPage.clickPrePublishButton();

		log.info("Create Post - Step 08: Verify 'Post published.' message is displayed");
		verifyTrue(adminPostAddNewPage.isPostPublishMessageDisplayed("Post published."));

	}

	@Test
	public void Post_02_Search_View_Post() {
		log.info("Search Post - Step 01: Open 'Search post' page");
		adminPostSearchPage = adminPostAddNewPage.openSearchPostPageUrl(searchPostUrl);

		log.info("Search Post - Step 02: Enter to Search textbox");
		adminPostSearchPage.enterToSearchTextbox(postTitle);

		log.info("Search Post - Step 03: Click to 'Search Posts' button");
		adminPostSearchPage.clickToSearchPostButton();

		log.info("Search Post - Step 04: Verify Search table contains '" + postTitle + "'");
		verifyTrue(adminPostSearchPage.isPostSearchTableDisplayed("title", postTitle));

		log.info("Search Post - Step 05: Verify Search table contains '" + authorName + "'");
		verifyTrue(adminPostSearchPage.isPostSearchTableDisplayed("author", authorName));

		log.info("Search Post - Step 06: Open End User site");
		userHomePage = adminPostSearchPage.openEndUserSite(driver, this.endUserUrl);

		log.info("Search Post - Step 07: Verify Post infor displayed at Home page");
		verifyTrue(userHomePage.isPostInforDisplayedByTitle(postTitle));
		verifyTrue(userHomePage.isPostInforDisplayedByBody(postTitle, postBody));
		verifyTrue(userHomePage.isPostInforDisplayedByAuthor(postTitle, authorName));
		verifyTrue(userHomePage.isPostInforDisplayedByDate(postTitle, currentDate));

		log.info("Search Post - Step 08: Click to Post title");
		userPostDetailPage = userHomePage.clickPostTitle(postTitle);

		log.info("Search Post - Step 09: Verify Post infor displayed at Post detail page");
		verifyTrue(userPostDetailPage.isPostInforDisplayedByTitle(postTitle));
		verifyTrue(userPostDetailPage.isPostInforDisplayedByBody(postTitle, postBody));
		verifyTrue(userPostDetailPage.isPostInforDisplayedByAuthor(postTitle, authorName));
		verifyTrue(userPostDetailPage.isPostInforDisplayedByDate(postTitle, currentDate));

	}

	@Test
	public void Post_03_Edit_Post() {
		log.info("Edit Post - Step 01: Open Admin site");
		adminDashboardPage = userPostDetailPage.openAdminSite(driver, this.adminUrl);
		adminLoginpage.enterToUsernameTextbox(adminUserName);
		adminLoginpage.enterToPasswordTextbox(adminPassword);
		adminDashboardPage = adminLoginpage.clickToLoginButton();

		log.info("Edit Post - Step 02: Click to 'Posts' menu link");
		adminPostSearchPage = adminDashboardPage.clickToPostsMenuLink();

		log.info("Edit Post - Step 03: Enter to Search textbox");
		adminPostSearchPage.enterToSearchTextbox(postTitle);

		log.info("Edit Post - Step 04: Click to 'Search Posts' button");
		adminPostSearchPage.clickToSearchPostButton();

		log.info("Edit Post - Step 05: Click to Post title link and navigate to Edit Post page ");
		adminPostAddNewPage = adminPostSearchPage.clickToPostTitleLink(postTitle);

		log.info("Edit Post - Step 06: Enter to Post title:" + editPostTitle);
		adminPostAddNewPage.enterToAddNewPostTitle(editPostTitle);

		log.info("Edit Post - Step 07: Enter to Post body :" + editPostBody);
		adminPostAddNewPage.enterToEditPostBody(editPostBody);

		log.info("Edit Post - Step 08: Click to 'Update' button");
		adminPostAddNewPage.clickPublishOrUpdateButton();

		log.info("Edit Post - Step 09: Verify 'Post updated.' message is displayed");
		verifyTrue(adminPostAddNewPage.isPostPublishMessageDisplayed("Post updated."));

		log.info("Edit Post - Step 10: Open 'Search post' page");
		adminPostSearchPage = adminPostAddNewPage.openSearchPostPageUrl(searchPostUrl);

		log.info("Edit Post - Step 11: Enter to Search textbox");
		adminPostSearchPage.enterToSearchTextbox(editPostTitle);

		log.info("Edit Post - Step 12: Click to 'Search Posts' button");
		adminPostSearchPage.clickToSearchPostButton();

		log.info("Edit Post - Step 13: Verify Search table contains '" + editPostTitle + "'");
		verifyTrue(adminPostSearchPage.isPostSearchTableDisplayed("title", editPostTitle));

		log.info("Edit Post - Step 14: Verify Search table contains '" + authorName + "'");
		verifyTrue(adminPostSearchPage.isPostSearchTableDisplayed("author", authorName));

		log.info("Edit Post - Step 15: Open End User site");
		userHomePage = adminPostSearchPage.openEndUserSite(driver, this.endUserUrl);

		log.info("Edit Post - Step 16: Verify Post infor displayed at Home page");
		verifyTrue(userHomePage.isPostInforDisplayedByTitle(editPostTitle));
		verifyTrue(userHomePage.isPostInforDisplayedByBody(editPostTitle, editPostBody));
		verifyTrue(userHomePage.isPostInforDisplayedByAuthor(editPostTitle, authorName));
		verifyTrue(userHomePage.isPostInforDisplayedByDate(editPostTitle, currentDate));

		log.info("Edit Post - Step 17: Click to Post title");
		userPostDetailPage = userHomePage.clickPostTitle(editPostTitle);

		log.info("Edit Post - Step 18: Verify Post infor displayed at Post detail page");
		verifyTrue(userPostDetailPage.isPostInforDisplayedByTitle(editPostTitle));
		verifyTrue(userPostDetailPage.isPostInforDisplayedByBody(editPostTitle, editPostBody));
		verifyTrue(userPostDetailPage.isPostInforDisplayedByAuthor(editPostTitle, authorName));
		verifyTrue(userPostDetailPage.isPostInforDisplayedByDate(editPostTitle, currentDate));

	}

	@Test
	public void Post_04_Delete_Post() {
		log.info("Delete Post - Step 01: Open Admin site");
		adminDashboardPage = userPostDetailPage.openAdminSite(driver, this.adminUrl);
		adminLoginpage.enterToUsernameTextbox(adminUserName);
		adminLoginpage.enterToPasswordTextbox(adminPassword);
		adminDashboardPage = adminLoginpage.clickToLoginButton();

		log.info("Delete Post - Step 02: Click to 'Posts' menu link");
		adminPostSearchPage = adminDashboardPage.clickToPostsMenuLink();

		log.info("Delete Post - Step 03: Enter to Search textbox");
		adminPostSearchPage.enterToSearchTextbox(editPostTitle);

		log.info("Delete Post - Step 04: Click to 'Search Posts' button");
		adminPostSearchPage.clickToSearchPostButton();

		log.info("Delete Post - Step 05: Select Post detail checkbox");
		adminPostSearchPage.selectPostCheckboxByTitle(editPostTitle);

		log.info("Delete Post - Step 05: Select 'Move to Trash' item in dropdown");
		adminPostSearchPage.selectTextItemInActionDropdow("Move to Trash");

		log.info("Delete Post - Step 05: Click to 'Apply' button");
		adminPostSearchPage.clickApplyButton();

		log.info("Delete Post - Step 05: Verify '1 post moved to the Trash' message is displayed");
		verifyTrue(adminPostSearchPage.isMoveToTrashMessageDisplayed("1 post moved to the Trash"));

		log.info("Delete Post - Step 03: Enter to Search textbox");
		adminPostSearchPage.enterToSearchTextbox(editPostTitle);

		log.info("Delete Post - Step 04: Click to 'Search Posts' button");
		adminPostSearchPage.clickToSearchPostButton();

		log.info("Delete Post - Step 05: Verify 'No posts found' message is displayed");
		verifyTrue(adminPostSearchPage.isNoPostsFoundMessageDisplayed("No posts found."));

		log.info("Delete Post - Step 15: Open End User site");
		userHomePage = adminPostSearchPage.openEndUserSite(driver, this.endUserUrl);

		log.info("Delete Post - Step 05: Verify Post title undisplayed at Home page");
		verifyTrue(userHomePage.isPostInforUnDisplayedByTitle(editPostTitle));

		log.info("Delete Post - Step 03: Enter to Search textbox");
		userHomePage.enterToSearchTextbox(editPostTitle);

		log.info("Delete Post - Step 04: Click to 'Search Posts' button");
		userSearchPostPage = userHomePage.clickSearchPostsButton();

		log.info("Delete Post - Step 05: Verify 'Nothing Found' message is displayed");
		verifyTrue(userSearchPostPage.isNothingFoundMessageDisplayed("Nothing Found"));
	}

	@AfterClass(alwaysRun = true)
	public void afterClass() {
		closeBrowserAndDriver();
	}

}
