package com.nopcommerce.user;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import commons.BaseTest;
import pageObject.HomePageObject;
import pageObject.LoginPageObject;
import pageObject.CustomerInfoPageObject;
import pageObject.PageGeneratorManager;
import pageObject.RegisterPageObject;

public class Level_07_Swich_Page_UI extends BaseTest {
	private WebDriver driver;
	private HomePageObject homePage;
	private LoginPageObject loginPage;
	private RegisterPageObject registerPage;
	private CustomerInfoPageObject customerinfoPage;
	private String validEmail, firstName, lastName, password;

	@Parameters("browser")
	@BeforeClass
	public void beforeClass(String browserName) {
		driver = getBrowserDriver(browserName);

		homePage = PageGeneratorManager.getHomePage(driver);

		firstName = "Automation";
		lastName = "FC";
		validEmail = "Automation" + generateRandomNumber() + "@gmail.com";
		password = "123456";

	}

	@Test
	public void User_01_Register() {
		registerPage = homePage.clickToRegisterLink();
		registerPage.inputToFirstnameTextbox(firstName);
		registerPage.inputToLastnameTextbox(lastName);
		registerPage.inputToEmailTextbox(validEmail);
		registerPage.inputToPasswordTextbox(password);
		registerPage.inputToConfirmPasswordTextbox(password);
		registerPage.clickToRegisterButton();

		Assert.assertEquals(registerPage.getMessageSuccess(), "Your registration completed");
		homePage = registerPage.clickToLogoutLink();
	}

	@Test
	public void User_02_Login() {
		loginPage = homePage.clickToLoginLink();
		loginPage.inputToEmailTextbox(validEmail);
		loginPage.inputToPasswordTextbox(password);

		homePage = loginPage.clickToLoginButton();
		Assert.assertEquals(homePage.getMessageSuccess(), "Welcome to our store");
	}

	@Test
	public void User_03_MyAccount() {
		customerinfoPage = homePage.clickToMyAccountLink();
		customerinfoPage.clickToNewsletterCheckbox();
	}

	@Test
	public void User_04_Swich_Page() {

	}

	@Test
	public void User_04_Swich_Role() {
		// Role User => Role Admin

		// Role Admin => Role User
	}

	@AfterClass
	public void afterClass() {
		driver.quit();
	}

}
