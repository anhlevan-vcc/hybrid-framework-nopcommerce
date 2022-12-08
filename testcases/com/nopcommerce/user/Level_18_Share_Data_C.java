package com.nopcommerce.user;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.nopcommerce.common.Common_01_Cookie;

import commons.BaseTest;
import commons.PageGeneratorManager;
import pageObject.nopCommerce.user.UserHomePageObject;
import pageObject.nopCommerce.user.UserLoginPageObject;

public class Level_18_Share_Data_C extends BaseTest {
	private WebDriver driver;
	private UserHomePageObject homePage;
	private UserLoginPageObject loginPage;

	@Parameters("browser")
	@BeforeClass
	public void beforeClass(String browserName) {
		driver = getBrowserDriver(browserName);
		homePage = PageGeneratorManager.getUserHomePage(driver);

		log.info("Pre-Condition - Step 01: Navigate to 'login' page");
		loginPage = homePage.openLoginPage();

		log.info("Pre-Condition - Step 02: Set cookie and reload page");
		loginPage.setCookies(driver, Common_01_Cookie.loggedCookie);
		loginPage.refreshCurrentPage(driver);

		log.info("Pre-Condition - Step 03: Verify 'My Account' link is displayed ");
		verifyTrue(homePage.isMyAccountLinkDisPlayed());
	}

	@Test
	public void Search_01_Empty_Data() {

	}

	@Test
	public void Search_02_Empty_Data() {

	}

	@Test
	public void Search_03_Empty_Data() {

	}

	@Test
	public void Search_04_Empty_Data() {

	}

	@Test
	public void Search_05_Empty_Data() {

	}

	@AfterClass
	public void afterClass() {
		// driver.quit();
	}

}