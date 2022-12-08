package com.nopcommerce.user;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import commons.BaseTest;
import commons.PageGeneratorManager;
import pageObject.nopCommerce.user.UserCustomerInfoPageObject;
import pageObject.nopCommerce.user.UserHomePageObject;
import pageObject.nopCommerce.user.UserLoginPageObject;
import pageObject.nopCommerce.user.UserRegisterPageObject;

public class Level_19_Close_BrowserAndDriver extends BaseTest {
	private WebDriver driver;
	private UserHomePageObject homePage;
	private UserLoginPageObject loginPage;
	private UserRegisterPageObject registerPage;
	private UserCustomerInfoPageObject customerinfoPage;

	private String validEmail, firstName, lastName, password;

	@Parameters("browser")
	@BeforeClass
	public void beforeClass(String browserName) {
		driver = getBrowserDriver(browserName);

		homePage = PageGeneratorManager.getUserHomePage(driver);

		firstName = "Automation";
		lastName = "FC";
		validEmail = "Automation" + generateRandomNumber() + "@gmail.com";
		password = "123456";

	}

	@Test
	public void User_01_Register() {
		log.info("Register - Step 01: Navigate to 'Register' page");
		registerPage = homePage.openRegisterPage();

		log.info("Register - Step 02: Enter to Firstname textbox with value is '" + firstName + "'");
		registerPage.inputToFirstnameTextbox(firstName);

		log.info("Register - Step 03: Enter to Lastname textbox with value is '" + lastName + "'");
		registerPage.inputToLastnameTextbox(lastName);

		log.info("Register - Step 04: Enter to Email textbox with value is '" + validEmail + "'");
		registerPage.inputToEmailTextbox(validEmail);

		log.info("Register - Step 05: Enter to Password textbox with value is '" + password + "'");
		registerPage.inputToPasswordTextbox(password);

		log.info("Register - Step 06: Enter to ConfirmPassword textbox with value is '" + password + "'");
		registerPage.inputToConfirmPasswordTextbox(password);

		log.info("Register - Step 07: Click To Register Button ");
		registerPage.clickToRegisterButton();

		log.info("Register - Step 08: Verify register success massage is displayed ");
		verifyEquals(registerPage.getMessageSuccess(), "Your registration completed");

		log.info("Register - Step 09: Click To Logout link ");
		homePage = registerPage.clickToLogoutLink();
	}

	@Test
	public void User_02_Login() {

		log.info("Login - Step 01: Navigate to 'login' page");
		loginPage = homePage.openLoginPage();

		log.info("Login - Step 02: Enter to Firstname textbox with value is '" + validEmail + "'");
		loginPage.inputToEmailTextbox(validEmail);

		log.info("Login - Step 03: Enter to Firstname textbox with value is '" + password + "'");
		loginPage.inputToPasswordTextbox(password);

		log.info("Login - Step 04: Click To Login Button ");
		homePage = loginPage.clickToLoginButton();

		log.info("Login - Step 05: Verify 'My Account' link is displayed ");
		verifyEquals(homePage.getMessageSuccess(), "Welcome to our store");
		verifyTrue(homePage.isMyAccountLinkDisPlayed());

		log.info("Login - Step 06:  Navigate to 'My Account' page");
		customerinfoPage = homePage.openMyAccountCustomerInfoPage();

		log.info("Login - Step 07: Verify 'Customer Infor' page is displayed ");
		verifyTrue(customerinfoPage.iscustomerinfoPageDisplayed());
	}

	@AfterClass(alwaysRun = true)
	public void afterClass() {
		closeBrowserAndDriver();
	}

}
