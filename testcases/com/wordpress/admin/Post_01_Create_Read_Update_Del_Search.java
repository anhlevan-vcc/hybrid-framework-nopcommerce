package com.wordpress.admin;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import commons.BaseTest;
import pageObject.wordpress.admin.AdminDashboardPO;
import pageObject.wordpress.admin.AdminLoginPO;
import pageObject.wordpress.admin.AdminPostAddNewPO;
import pageObject.wordpress.admin.AdminPostSearchPO;
import pageObject.wordpress.admin.PageGeneratorManager;

public class Post_01_Create_Read_Update_Del_Search extends BaseTest {
	private WebDriver driver;
	AdminLoginPO adminLoginpage;
	AdminDashboardPO adminDashboardPage;
	AdminPostSearchPO adminPostSearchPage;
	AdminPostAddNewPO adminPostAddNewPage;

	String adminUserName = "leanh_192";
	String adminPassword = "Doncoi@16193";
	int generateRandomNumber = generateRandomNumber();
	String valuePostTitle = "Title hôm nay học LiveCoding " + generateRandomNumber;
	String valuePostBody = "Body hôm nay học LiveCoding " + generateRandomNumber;

	String searchPostUrl;

	@Parameters({ "browser", "urlAdmin" })
	@BeforeClass
	public void beforeClass(String browserName, String adminUrl) {
		log.info("Pre-Condition - Step 01: Open browser admin URL");
		driver = getBrowserDriver(browserName, adminUrl);

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

		log.info("Create Post - Step 04: Enter to Post title:" + valuePostTitle);
		adminPostAddNewPage.enterToAddNewPostTitle(valuePostTitle);

		log.info("Create Post - Step 05: Enter to Post body :" + valuePostBody);
		adminPostAddNewPage.enterToAddNewPostBody(valuePostBody);

		log.info("Create Post - Step 06: Click to 'Publish' button");
		adminPostAddNewPage.clickPublishButton();

		log.info("Create Post - Step 07: Click to 'Pre Publish' button");
		adminPostAddNewPage.clickPrePublishButton();

		log.info("Create Post - Step 08: Verify 'Post published.' message is displayed");
		verifyTrue(adminPostAddNewPage.isPostPublishMessageDisplayed("Post published.."));

	}

	@Test
	public void Post_02_Search_Post() {
		log.info("Search Post - Step 01: Open 'Search post' page");
		adminPostSearchPage = adminPostAddNewPage.openSearchPostPageUrl(searchPostUrl);

	}

	@Test
	public void Post_03_View_Post() {
	}

	@Test
	public void Post_04_Edit_Post() {
	}

	@Test
	public void Post_04_Delete_Post() {
	}

	@AfterClass(alwaysRun = true)
	public void afterClass() {
		closeBrowserAndDriver();
	}

}
