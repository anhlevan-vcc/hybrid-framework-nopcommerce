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

public class Post_01_Create_Read_Update_Del_Search extends BaseTest {
	private WebDriver driver;
	AdminLoginPO adminLoginpage;
	AdminDashboardPO adminDashboardPage;
	AdminPostSearchPO adminPostSearchPage;
	AdminPostAddNewPO adminPostAddNewPage;
	UserHomePO userHomePage;
	UserPostDetailPO userPostDetailPage;

	String adminUserName = "leanh_192";
	String adminPassword = "Doncoi@16193";
	String searchPostUrl;
	int generateRandomNumber = generateRandomNumber();
	String postTitle = "Title hôm nay học LiveCoding " + generateRandomNumber;
	String postBody = "Body hôm nay học LiveCoding " + generateRandomNumber;
	String authorName = "Lê Anh";
	String adminUrl, endUserUrl;
	String currentDate = getCurentDate();

	@Parameters({ "browser", "urlAdmin", "urlUser" })
	@BeforeClass
	public void beforeClass(String browserName, String adminUrl, String endUserUrl) {
		this.adminUrl = adminUrl;
		this.endUserUrl = endUserUrl;
		log.info("Pre-Condition - Step 01: Open browser Admin site");
		driver = getBrowserDriver(browserName, this.adminUrl);

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
		adminPostAddNewPage.clickPublishButton();

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
	}

	@Test
	public void Post_04_Delete_Post() {
	}

	@AfterClass(alwaysRun = true)
	public void afterClass() {
		closeBrowserAndDriver();
	}

}
