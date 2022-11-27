package com.facebook.register;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import commons.BaseTest;
import pageObject.facebook.LoginPageObject;
import pageObject.facebook.PageGeneratorManager;

public class Level_13_Element_Undisplayed extends BaseTest {
	private WebDriver driver;
	private LoginPageObject loginPage;

	@Parameters({ "browser", "url" })
	@BeforeClass
	public void beforeClass(String browserName, String appUrl) {
		driver = getBrowserDriver(browserName, appUrl);
		loginPage = PageGeneratorManager.getLoginPage(driver);

	}

	@Test
	public void TC_1_Verify_Element_Displayed() {
		loginPage.clickToCreateNewAccountButton();
		// verify true - mong đợi confirm email hiển thị (true của true là đúng)

		loginPage.enterToEmailAddressTextbox("anh@gmail.com");
		verifyTrue(loginPage.isConfirmEmailAddressTextboxDisplayed());

	}

	@Test
	public void TC_2_Verify_Element_UnDisplayed_In_DOM() {

		// veryfy false - mong đợi confirm email không hiển thị(false của false là đúng)
		loginPage.enterToEmailAddressTextbox("");
		loginPage.sleepInSecond(2);
		verifyTrue(loginPage.isConfirmEmailAddressTextboxUnDisplayed());
	}

	@Test
	public void TC_3_Verify_Element_UnDisplayed_Not_In_DOM() {
		loginPage.clickCloseIconAtRegisterForm();
		loginPage.sleepInSecond(2);
		// verifyFalse(loginPage.isConfirmEmailAddressTextboxDisplayed());

		verifyTrue(loginPage.isConfirmEmailAddressTextboxUnDisplayed());

	}

	@AfterClass
	public void afterClass() {
		driver.quit();
	}

}
