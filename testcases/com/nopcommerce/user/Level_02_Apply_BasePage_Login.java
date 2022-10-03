package com.nopcommerce.user;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import commons.BasePage;

public class Level_02_Apply_BasePage_Login extends BasePage {
	WebDriver driver;
	String emailValid;
	String projectPath = System.getProperty("user.dir");

	@BeforeClass
	public void beforeClass() {
		System.setProperty("webdriver.gecko.driver", projectPath + "\\browserDrivers\\geckodriver.exe");
		driver = new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		driver.manage().window().maximize();

		emailValid = "Automation" + generateRandomNumber() + "@gmail.com";
		openPageUrl(driver, "https://demo.nopcommerce.com/");
	}

	@Test
	public void TC_01_Login_Empty_Data() {

		waitForElementClickable(driver, "//a[@class='ico-login']");
		clickToElement(driver, "//a[@class='ico-login']");
		waitForElementClickable(driver, "//button[text()= 'Log in']");
		clickToElement(driver, "//button[text()= 'Log in']");

		Assert.assertEquals(getElementText(driver, "//span[@id='Email-error']"), "Please enter your email");

	}

	@Test
	public void TC_02_Login_Invalid_Email() {
		waitForElementClickable(driver, "//a[@class='ico-login']");
		clickToElement(driver, "//a[@class='ico-login']");

		sendkeyToElement(driver, "//input[@id='Email']", "123@123@123");

		waitForElementClickable(driver, "//button[text()= 'Log in']");
		clickToElement(driver, "//button[text()= 'Log in']");

		Assert.assertEquals(getElementText(driver, "//span[@id='Email-error']"), "Wrong email");

	}

	@Test
	public void TC_03_Login_Existing_Email() {
		waitForElementClickable(driver, "//a[@class='ico-login']");
		clickToElement(driver, "//a[@class='ico-login']");

		sendkeyToElement(driver, "//input[@id='Email']", "Anhanh@hotmail.com");
		sendkeyToElement(driver, "//input[@id='Password']", "123456");

		waitForElementClickable(driver, "//button[text()= 'Log in']");
		clickToElement(driver, "//button[text()= 'Log in']");

		Assert.assertEquals(getElementText(driver, "//div[contains(@class,'message-error')]"), "Login was unsuccessful. Please correct the errors and try again.\nNo customer account found");

	}

	@Test
	public void TC_04_Login_Empty_Password() {
		waitForElementClickable(driver, "//a[text()='Register']");
		clickToElement(driver, "//a[text()= 'Register']");

		sendkeyToElement(driver, "//input[@id='FirstName']", "Automation");
		sendkeyToElement(driver, "//input[@id='LastName']", "FC");
		sendkeyToElement(driver, "//input[@id='Email']", "leanh12345@gmail.com");
		sendkeyToElement(driver, "//input[@id='Password']", "123456");
		sendkeyToElement(driver, "//input[@id='ConfirmPassword']", "123456");

		waitForElementClickable(driver, "//button[@id= 'register-button']");
		clickToElement(driver, "//button[@id= 'register-button']");

		Assert.assertEquals(getElementText(driver, "//div[@class='result']"), "Your registration completed");

		waitForElementClickable(driver, "//a[@class= 'ico-logout']");
		clickToElement(driver, "//a[@class= 'ico-logout']");

		waitForElementClickable(driver, "//a[@class='ico-login']");
		clickToElement(driver, "//a[@class='ico-login']");

		sendkeyToElement(driver, "//input[@id='Email']", "leanh12345@gmail.com");

		waitForElementClickable(driver, "//button[text()= 'Log in']");
		clickToElement(driver, "//button[text()= 'Log in']");

		Assert.assertEquals(getElementText(driver, "//div[contains(@class,'message-error')]"), "Login was unsuccessful. Please correct the errors and try again.\nThe credentials provided are incorrect");

	}

	@Test
	public void TC_05_Login_Invalid_Comfirm_Password() {
		waitForElementClickable(driver, "//a[@class='ico-login']");
		clickToElement(driver, "//a[@class='ico-login']");

		sendkeyToElement(driver, "//input[@id='Email']", "leanh12345@gmail.com");
		sendkeyToElement(driver, "//input[@id='Password']", "654321");

		waitForElementClickable(driver, "//button[text()= 'Log in']");
		clickToElement(driver, "//button[text()= 'Log in']");

		Assert.assertEquals(getElementText(driver, "//div[contains(@class,'message-error')]"), "Login was unsuccessful. Please correct the errors and try again.\nThe credentials provided are incorrect");

	}

	@Test
	public void TC_06_Login_Success() {

		waitForElementClickable(driver, "//a[@class='ico-login']");
		clickToElement(driver, "//a[@class='ico-login']");

		sendkeyToElement(driver, "//input[@id='Email']", "leanh12345@gmail.com");
		sendkeyToElement(driver, "//input[@id='Password']", "123456");

		waitForElementClickable(driver, "//button[text()= 'Log in']");
		clickToElement(driver, "//button[text()= 'Log in']");

		Assert.assertEquals(getElementText(driver, "//h2[text()='Welcome to our store']"), "Welcome to our store");

	}

	@AfterClass
	public void afterClass() {
		driver.quit();
	}

}
