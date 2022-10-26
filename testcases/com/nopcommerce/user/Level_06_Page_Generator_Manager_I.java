package com.nopcommerce.user;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import commons.BaseTest;
import pageObject.nopCommerce.user.UserHomePageObject;
import pageObject.nopCommerce.user.UserLoginPageObject;
import pageObject.nopCommerce.user.UserRegisterPageObject;

public class Level_06_Page_Generator_Manager_I extends BaseTest {
	private WebDriver driver;
	private UserHomePageObject homePage;
	private UserLoginPageObject loginPage;
	private UserRegisterPageObject registerPage;
	private String validEmail, invalidEmail, notFoundEmail, firstName, lastName, password;

	@Parameters("browser")
	@BeforeClass
	public void beforeClass(String browserName) {
		driver = getBrowserDriver(browserName);

		// 1
		homePage = new UserHomePageObject(driver);

		firstName = "Automation";
		lastName = "FC";
		validEmail = "Automation" + generateRandomNumber() + "@gmail.com";
		invalidEmail = "anh@123@123";
		notFoundEmail = "Automation" + generateRandomNumber() + "@gmail.net";
		password = "123456";

		System.out.println("Pre-Condition - Step 01: Click to Register link");
		homePage.openRegisterPage();

		// 2
		registerPage = new UserRegisterPageObject(driver);

		System.out.println("Pre-Condition - Step 02: Input to required fields");
		registerPage.inputToFirstnameTextbox(firstName);
		registerPage.inputToLastnameTextbox(lastName);
		registerPage.inputToEmailTextbox(validEmail);
		registerPage.inputToPasswordTextbox(password);
		registerPage.inputToConfirmPasswordTextbox(password);

		System.out.println("Pre-Condition - Step 03: Click to Register Button");
		registerPage.clickToRegisterButton();

		System.out.println("Pre-Condition - Step 04: Verify message Success displayed");
		Assert.assertEquals(registerPage.getMessageSuccess(), "Your registration completed");

		System.out.println("Pre-Condition - Step 05: Click to Logout link");
		registerPage.clickToLogoutLink();

		// Click logout thì về trang hôm
		// 3
		homePage = new UserHomePageObject(driver);
	}

	@Test
	public void Login_01_Empty_Data() {

		homePage.openLoginPage();

		// 4
		loginPage = new UserLoginPageObject(driver);

		loginPage.clickToLoginButton();
		Assert.assertEquals(loginPage.getErrorMassageEmailTextbox(), "Please enter your email");

	}

	@Test
	public void Login_02_Invalid_Email() {
		homePage.openLoginPage();

		// 5
		loginPage = new UserLoginPageObject(driver);

		loginPage.inputToEmailTextbox(invalidEmail);
		loginPage.clickToLoginButton();

		Assert.assertEquals(loginPage.getErrorMassageEmailTextbox(), "Wrong email");

	}

	@Test
	public void Login_03_Not_Found_Email() {
		homePage.openLoginPage();

		// 6
		loginPage = new UserLoginPageObject(driver);

		loginPage.inputToEmailTextbox(notFoundEmail);
		loginPage.inputToPasswordTextbox(password);
		loginPage.clickToLoginButton();

		Assert.assertEquals(loginPage.getErrorMassageExistingEmail(), "Login was unsuccessful. Please correct the errors and try again.\nNo customer account found");

	}

	@Test
	public void Login_04_Empty_Password() {
		homePage.openLoginPage();

		// 7
		loginPage = new UserLoginPageObject(driver);

		loginPage.inputToEmailTextbox(validEmail);
		loginPage.clickToLoginButton();

		Assert.assertEquals(loginPage.getErrorMassageEmplyPassword(), "Login was unsuccessful. Please correct the errors and try again.\nThe credentials provided are incorrect");

	}

	@Test
	public void Login_05_Invalid_Password() {
		homePage.openLoginPage();

		// 8
		loginPage = new UserLoginPageObject(driver);

		loginPage.inputToEmailTextbox(validEmail);
		loginPage.inputToPasswordTextbox("101010");

		loginPage.clickToLoginButton();

		Assert.assertEquals(loginPage.getErrorMassageEmplyPassword(), "Login was unsuccessful. Please correct the errors and try again.\nThe credentials provided are incorrect");

	}

	@Test
	public void Login_06_Success() {
		homePage.openLoginPage();

		// 9
		loginPage = new UserLoginPageObject(driver);

		loginPage.inputToEmailTextbox(validEmail);
		loginPage.inputToPasswordTextbox(password);

		loginPage.clickToLoginButton();

		// Login thanh cong ve trang Home
		// 10
		homePage = new UserHomePageObject(driver);

		Assert.assertEquals(homePage.getMessageSuccess(), "Welcome to our store");

	}

	@AfterClass
	public void afterClass() {
		driver.quit();
	}

}
