package com.nopcommerce.user;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

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

public class Level_20_Pattern_Object extends BaseTest {
	private WebDriver driver;
	private UserHomePageObject homePage;
	private UserLoginPageObject loginPage;
	private UserRegisterPageObject registerPage;
	private UserCustomerInfoPageObject customerinfoPage;

	private String validEmail, firstName, lastName, password;
	private String day, month, year;

	@Parameters("browser")
	@BeforeClass
	public void beforeClass(String browserName) {
		driver = getBrowserDriver(browserName);

		homePage = PageGeneratorManager.getUserHomePage(driver);

		firstName = "Automation";
		lastName = "FC";
		validEmail = "Automation" + generateRandomNumber() + "@gmail.com";
		password = "123456";
		day = "16";
		month = "January";
		year = "1993";

	}

	@Test
	public void User_01_Register() {
		log.info("Register - Step 01: Navigate to 'Register' page");
		registerPage = homePage.openRegisterPage();

		registerPage.clickToRadioButtonByLabel(driver, "Male");

		log.info("Register - Step 02: Enter to Firstname textbox with value is '" + firstName + "'");
		registerPage.inputToTextboxByID(driver, "FirstName", firstName);

		log.info("Register - Step 03: Enter to Lastname textbox with value is '" + lastName + "'");
		registerPage.inputToTextboxByID(driver, "LastName", lastName);

		registerPage.selectDropdownByName(driver, "DateOfBirthDay", day);
		registerPage.selectDropdownByName(driver, "DateOfBirthMonth", month);
		registerPage.selectDropdownByName(driver, "DateOfBirthYear", year);

		log.info("Register - Step 04: Enter to Email textbox with value is '" + validEmail + "'");
		registerPage.inputToTextboxByID(driver, "Email", validEmail);

		registerPage.clickToCheckboxByLabel(driver, "Newsletter:");

		log.info("Register - Step 05: Enter to Password textbox with value is '" + password + "'");
		registerPage.inputToTextboxByID(driver, "Password", password);

		log.info("Register - Step 06: Enter to ConfirmPassword textbox with value is '" + password + "'");
		registerPage.inputToTextboxByID(driver, "ConfirmPassword", password);

		log.info("Register - Step 07: Click To Register Button ");
		registerPage.clickToButtonByText(driver, "Register");

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
		loginPage.inputToTextboxByID(driver, "Email", validEmail);

		log.info("Login - Step 03: Enter to Firstname textbox with value is '" + password + "'");
		loginPage.inputToTextboxByID(driver, "Password", password);

		log.info("Login - Step 04: Click To Login Button ");
		loginPage.clickToButtonByText(driver, "Log in");
		homePage = PageGeneratorManager.getUserHomePage(driver);

		log.info("Login - Step 05: Verify 'My Account' link is displayed ");
		verifyEquals(homePage.getMessageSuccess(), "Welcome to our store");
		assertTrue(homePage.isMyAccountLinkDisPlayed());

		log.info("Login - Step 06:  Navigate to 'My Account' page");
		customerinfoPage = homePage.openMyAccountCustomerInfoPage();

		log.info("Login - Step 07: Verify 'Customer Infor' page is displayed ");
		assertTrue(customerinfoPage.isCustomerinfoPageDisplayed());
	}

	@Test
	public void User_03_My_Account() {
		log.info("My Account - Step 01: Navigate to 'My Account' page");
		customerinfoPage = homePage.openMyAccountCustomerInfoPage();

		log.info("My Account - Step 02: Verify 'Customer Infor' page is displayed ");
		assertTrue(customerinfoPage.isCustomerinfoPageDisplayed());

		log.info("My Account - Step 02: Verify 'First Name' value is corectly ");
		assertEquals(customerinfoPage.getTextboxValueByID(driver, "FirstName", "value"), firstName);

		log.info("My Account - Step 02: Verify 'Last Name' value is corectly ");
		assertEquals(customerinfoPage.getTextboxValueByID(driver, "LastName", "value"), lastName);

		log.info("My Account - Step 02: Verify 'Email Name' value is corectly ");
		assertEquals(customerinfoPage.getTextboxValueByID(driver, "Email", "value"), validEmail);
	}

	@AfterClass(alwaysRun = true)
	public void afterClass() {
		closeBrowserAndDriver();
	}

}
