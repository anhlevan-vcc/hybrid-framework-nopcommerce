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
import pageObject.wordpress.AdminUsersPO;
import pageObject.wordpress.PageGeneratorManager;
import pageObject.wordpress.UserHomePO;
import pageObject.wordpress.UserPostDetailPO;
import pageObject.wordpress.UserSearchPostPO;

public class User_01_View_User_Environment_DB_Testing extends BaseTest {
	private WebDriver driver;
	AdminLoginPO adminLoginpage;
	AdminDashboardPO adminDashboardPage;
	AdminPostSearchPO adminPostSearchPage;
	AdminPostAddNewPO adminPostAddNewPage;
	AdminUsersPO adminUsersPage;
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
	String adminUrl, endUserUrl, environmentName;
	String currentDate = getCurentDate();

	@Parameters({ "browser", "environment" })
	@BeforeClass
	public void beforeClass(String browserName, String environmentName) {
		this.environmentName = environmentName;
		log.info("Pre-Condition - Step 01: Open browser Admin site");
		driver = getBrowserDriver(browserName, this.environmentName);

		adminLoginpage = PageGeneratorManager.getAdminLoginPage(driver);

		log.info("Pre-Condition - Step 02: Enter to Username textbox :" + adminUserName);
		adminLoginpage.enterToUsernameTextbox(adminUserName);

		log.info("Pre-Condition - Step 03: Enter to Password textbox :" + adminPassword);
		adminLoginpage.enterToPasswordTextbox(adminPassword);

		log.info("Pre-Condition - Step 04: Click to login button");
		adminDashboardPage = adminLoginpage.clickToLoginButton();

	}

	@Test
	public void User_01_ViewUser() {
		log.info("View - users - Step 01: Click to 'Users' menu link");
		adminUsersPage = adminDashboardPage.clickToUsersMenuLink();

		log.info("View - users - Step 02: Get all User from UI");
		int totalNumberUserAtUI = adminUsersPage.getUsersNumberUI();

		log.info("View - users - Step 03: Get all User from DB");
		int totalNumberUserAtDB = adminUsersPage.getUsersNumberDB();

		log.info("View - users - Step 04: Verify user UI and DB");
		verifyEquals(totalNumberUserAtUI, totalNumberUserAtDB);
	}

	@AfterClass(alwaysRun = true)
	public void afterClass() {
		closeBrowserAndDriver();
	}

}
