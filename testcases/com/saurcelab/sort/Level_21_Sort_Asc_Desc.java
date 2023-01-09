package com.saurcelab.sort;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import commons.BaseTest;
import pageObject.saucelab.LoginPageObject;
import pageObject.saucelab.PageGeneratorManager;
import pageObject.saucelab.ProductPageObject;

public class Level_21_Sort_Asc_Desc extends BaseTest {
	private WebDriver driver;
	LoginPageObject loginPage;
	ProductPageObject productPage;

	@Parameters({ "browser", "appUrl" })
	@BeforeClass
	public void beforeClass(String browserName, String saurcelabUrl) {
		driver = getBrowserDriver(browserName, saurcelabUrl);
		loginPage = PageGeneratorManager.getLoginPage(driver);

		loginPage.enterToUserNameTextbox("standard_user");
		loginPage.enterToPasswordTextbox("secret_sauce");
		productPage = loginPage.clickToButtonLogin();

	}

	@Test
	public void Sort_01_Name() {
		// Ascending
		productPage.selectItemInProductSortDropdown("Name (A to Z)");

		// Descending
		productPage.selectItemInProductSortDropdown("Name (Z to A)");
	}

	@Test
	public void Sort_01_Price() {
		// Ascending
		productPage.selectItemInProductSortDropdown("Price (low to high)");

		// Descending
		productPage.selectItemInProductSortDropdown("Price (high to low)");
	}

	@AfterClass(alwaysRun = true)
	public void afterClass() {
		closeBrowserAndDriver();
	}

}
