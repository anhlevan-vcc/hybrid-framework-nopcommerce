package com.jquery.datatable;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import commons.BaseTest;
import pageObject.jQuery.HomePageObject;
import pageObject.jQuery.PageGeneratorManager;

public class Level_10_Datatable_DataGrid extends BaseTest {
	private WebDriver driver;
	private HomePageObject homePage;

	@Parameters({ "browser", "url" })
	@BeforeClass
	public void beforeClass(String browserName, String appUrl) {
		driver = getBrowserDriver(browserName, appUrl);
		homePage = PageGeneratorManager.getHomePage(driver);

	}

	@Test
	public void Table_01_Paging() {
		homePage.openPagingByPageNumber("10");
		homePage.sleepInSecond(1);

		homePage.openPagingByPageNumber("12");
		homePage.sleepInSecond(1);

		homePage.openPagingByPageNumber("14");
		homePage.sleepInSecond(1);

		homePage.openPagingByPageNumber("16");
		homePage.sleepInSecond(1);

		homePage.openPagingByPageNumber("18");
		homePage.sleepInSecond(1);
	}

	@Test
	public void User_02_Login() {

	}

	@AfterClass
	public void afterClass() {
		driver.quit();
	}

}
