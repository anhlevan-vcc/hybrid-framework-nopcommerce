package com.nopcommerce.common;

import java.util.Set;

import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

import commons.BaseTest;
import commons.PageGeneratorManager;
import pageObject.nopCommerce.user.UserHomePageObject;
import pageObject.nopCommerce.user.UserLoginPageObject;
import pageObject.nopCommerce.user.UserRegisterPageObject;

public class Common_01_Cookie extends BaseTest {
	private WebDriver driver;
	private UserHomePageObject homePage;
	private UserRegisterPageObject registerPage;
	private UserLoginPageObject loginPage;

	public static String emailAddress, password;
	private String firstName, lastName;

	public static Set<Cookie> loggedCookie;

	@Parameters("browser")
	@BeforeTest(description = "Create new Account for all Classes Test")
	public void Register(String browserName) {
		driver = getBrowserDriver(browserName);
		homePage = PageGeneratorManager.getUserHomePage(driver);

		firstName = "Automation";
		lastName = "FC";
		emailAddress = "Automation" + generateRandomNumber() + "@gmail.com";
		password = "123456";

		log.info("Pre-Condition - Step 01: Navigate to 'Register' page");
		registerPage = homePage.openRegisterPage();

		log.info("Pre-Condition - Step 02: Enter to Firstname textbox with value is '" + firstName + "'");
		registerPage.inputToFirstnameTextbox(firstName);

		log.info("Pre-Condition - Step 03: Enter to Lastname textbox with value is '" + lastName + "'");
		registerPage.inputToLastnameTextbox(lastName);

		log.info("Pre-Condition - Step 04: Enter to Email textbox with value is '" + emailAddress + "'");
		registerPage.inputToEmailTextbox(emailAddress);

		log.info("Pre-Condition - Step 05: Enter to Password textbox with value is '" + password + "'");
		registerPage.inputToPasswordTextbox(password);

		log.info("Pre-Condition - Step 06: Enter to ConfirmPassword textbox with value is '" + password + "'");
		registerPage.inputToConfirmPasswordTextbox(password);

		log.info("Pre-Condition - Step 07: Click To Register Button ");
		registerPage.clickToRegisterButton();

		log.info("Pre-Condition - Step 08: Verify register success massage is displayed ");
		verifyEquals(registerPage.getMessageSuccess(), "Your registration completed");

		log.info("Pre-Condition - Step 09: Click To Logout link ");
		homePage = registerPage.clickToLogoutLink();

		log.info("Pre-Condition - Step 10: Navigate to 'login' page");
		loginPage = homePage.openLoginPage();

		log.info("Pre-Condition - Step 11: Enter to Firstname textbox with value is '" + emailAddress + "'");
		loginPage.inputToEmailTextbox(emailAddress);

		log.info("Pre-Condition - Step 12: Enter to Firstname textbox with value is '" + password + "'");
		loginPage.inputToPasswordTextbox(password);

		log.info("Pre-Condition - Step 13: Click To Login Button ");
		homePage = loginPage.clickToLoginButton();

		loggedCookie = homePage.getAllCookies(driver);
		for (Cookie cookie : loggedCookie) {
			System.out.println("Cookie at Common Class = " + cookie);
		}

		log.info("Pre-Condition - Step 14: Click To Logout link ");
		homePage.clickToLogoutLinkAtUserPage(driver);

		driver.quit();
	}

	@AfterTest
	public void afterTest() {
	}

}
