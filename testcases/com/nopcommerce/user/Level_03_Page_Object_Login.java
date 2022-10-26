package com.nopcommerce.user;

import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import pageObject.nopCommerce.user.UserHomePageObject;
import pageObject.nopCommerce.user.UserLoginPageObject;
import pageObject.nopCommerce.user.UserRegisterPageObject;

public class Level_03_Page_Object_Login {
	private WebDriver driver;
	private UserHomePageObject homePage;
	private UserLoginPageObject loginPage;
	private UserRegisterPageObject registerPage;
	private String validEmail, invalidEmail, notFoundEmail, firstName, lastName, password;
	private String projectPath = System.getProperty("user.dir");

	@Parameters("browser")
	@BeforeClass
	public void beforeClass(String browserName) {
		if (browserName.equals("firefox")) {
			System.setProperty("webdriver.gecko.driver", projectPath + "\\browserDrivers\\geckodriver.exe");
			driver = new FirefoxDriver();
		} else if (browserName.equals("chrome")) {
			System.setProperty("webdriver.chrome.driver", projectPath + "\\browserDrivers\\chromedriver.exe");
			driver = new ChromeDriver();
		} else if (browserName.equals("edge")) {
			System.setProperty("webdriver.edge.driver", projectPath + "\\browserDrivers\\msedgedriver.exe");
			driver = new EdgeDriver();
		} else {
			throw new RuntimeException("Browser name invalid");
		}

		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.get("https://demo.nopcommerce.com/");
		homePage = new UserHomePageObject(driver);

		firstName = "Automation";
		lastName = "FC";
		validEmail = "Automation" + generateRandomNumber() + "@gmail.com";
		invalidEmail = "anh@123@123";
		notFoundEmail = "Automation" + generateRandomNumber() + "@gmail.net";
		password = "123456";

		System.out.println("Pre-Condition - Step 01: Click to Register link");
		homePage.openRegisterPage();

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
		homePage = new UserHomePageObject(driver);
	}

	@Test
	public void Login_01_Empty_Data() {

		homePage.openLoginPage();
		loginPage = new UserLoginPageObject(driver);

		loginPage.clickToLoginButton();
		Assert.assertEquals(loginPage.getErrorMassageEmailTextbox(), "Please enter your email");

	}

	@Test
	public void Login_02_Invalid_Email() {
		homePage.openLoginPage();
		loginPage = new UserLoginPageObject(driver);

		loginPage.inputToEmailTextbox(invalidEmail);
		loginPage.clickToLoginButton();

		Assert.assertEquals(loginPage.getErrorMassageEmailTextbox(), "Wrong email");

	}

	@Test
	public void Login_03_Not_Found_Email() {
		homePage.openLoginPage();
		loginPage = new UserLoginPageObject(driver);

		loginPage.inputToEmailTextbox(notFoundEmail);
		loginPage.inputToPasswordTextbox(password);
		loginPage.clickToLoginButton();

		Assert.assertEquals(loginPage.getErrorMassageExistingEmail(), "Login was unsuccessful. Please correct the errors and try again.\nNo customer account found");

	}

	@Test
	public void Login_04_Empty_Password() {
		homePage.openLoginPage();
		loginPage = new UserLoginPageObject(driver);

		loginPage.inputToEmailTextbox(validEmail);
		loginPage.clickToLoginButton();

		Assert.assertEquals(loginPage.getErrorMassageEmplyPassword(), "Login was unsuccessful. Please correct the errors and try again.\nThe credentials provided are incorrect");

	}

	@Test
	public void Login_05_Invalid_Password() {
		homePage.openLoginPage();
		loginPage = new UserLoginPageObject(driver);

		loginPage.inputToEmailTextbox(validEmail);
		loginPage.inputToPasswordTextbox("101010");

		loginPage.clickToLoginButton();

		Assert.assertEquals(loginPage.getErrorMassageEmplyPassword(), "Login was unsuccessful. Please correct the errors and try again.\nThe credentials provided are incorrect");

	}

	@Test
	public void Login_06_Success() {
		homePage.openLoginPage();
		loginPage = new UserLoginPageObject(driver);

		loginPage.inputToEmailTextbox(validEmail);
		loginPage.inputToPasswordTextbox(password);

		loginPage.clickToLoginButton();

		Assert.assertEquals(homePage.getMessageSuccess(), "Welcome to our store");

	}

	@AfterClass
	public void afterClass() {
		driver.quit();
	}

	public int generateRandomNumber() {
		Random rand = new Random();
		return rand.nextInt(9999);
	}
}
