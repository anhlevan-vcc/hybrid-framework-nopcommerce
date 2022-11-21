package com.jquery.datatable;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
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
	List<String> actualAllCountryValue;
	List<String> expectedAllCountryValue;

	@Parameters({ "browser", "url" })
	@BeforeClass
	public void beforeClass(String browserName, String appUrl) {
		driver = getBrowserDriver(browserName, appUrl);
		homePage = PageGeneratorManager.getHomePage(driver);

	}

	// @Test
	public void Table_01_Paging() {
		homePage.openPagingByPageNumber("10");
		homePage.sleepInSecond(1);
		Assert.assertTrue(homePage.isPageNumberActived("10"));

		homePage.openPagingByPageNumber("12");
		homePage.sleepInSecond(1);
		Assert.assertTrue(homePage.isPageNumberActived("12"));

		homePage.openPagingByPageNumber("14");
		homePage.sleepInSecond(1);
		Assert.assertTrue(homePage.isPageNumberActived("14"));

		homePage.openPagingByPageNumber("16");
		homePage.sleepInSecond(1);
		Assert.assertTrue(homePage.isPageNumberActived("16"));

		homePage.openPagingByPageNumber("18");
		homePage.sleepInSecond(1);
		Assert.assertTrue(homePage.isPageNumberActived("18"));
	}

	// @Test
	public void Table_02_Enter_To_Header() {
		homePage.refreshCurrentPage(driver);
		homePage.inputToHeaderTextboxByLabel("Females", "276880");
		homePage.inputToHeaderTextboxByLabel("Country", "Angola");
		homePage.inputToHeaderTextboxByLabel("Males", "276472");
		homePage.inputToHeaderTextboxByLabel("Total", "553353");

		homePage.inputToHeaderTextboxByLabel("Females", "338282");
		homePage.inputToHeaderTextboxByLabel("Country", "Argentina");
		homePage.inputToHeaderTextboxByLabel("Males", "349238");
		homePage.inputToHeaderTextboxByLabel("Total", "687522");
	}

	// @Test
	public void Table_03_Get_All_Value() {
		// có thể lưu tất cả dữ liệu lấy ra vào 1 List <String> để so sánh với dữ liệu của 1 file bên ngoài
		// Đọc dữ liệu của file country.txt ra lưu vào 1 List <String> = Expected value = expectedAllCountryValue
		// So sánh 2 list đó có bằng nhau ko
		homePage.getAllValueEachRowAtAllPage();

		actualAllCountryValue = homePage.getCustomColumAllPage("country");
		Assert.assertEquals(actualAllCountryValue, expectedAllCountryValue);

		homePage.getCustomColumAllPageNotDuplicate("country");

	}

	@Test
	public void Table_04_Action_At_Any_Row() {

		homePage.clickToLoadButton();

		homePage.enterToTextboxByColumnNameAtRowNumber("Album", "1", "LeAnh");
		homePage.enterToTextboxByColumnNameAtRowNumber("Artist", "2", "HaNoi");
		homePage.enterToTextboxByColumnNameAtRowNumber("Year", "3", "1999");
		homePage.enterToTextboxByColumnNameAtRowNumber("Price", "4", "150");

		homePage.selectDropdownByColumnNameAtRowNumber("Origin", "1", "Japan");
		homePage.selectDropdownByColumnNameAtRowNumber("Origin", "2", "Hong Kong");
		homePage.selectDropdownByColumnNameAtRowNumber("Origin", "3", "US");

		homePage.checkToCheckBoxByColumnNameAtRowNumber("With Poster?", "3");
		homePage.checkToCheckBoxByColumnNameAtRowNumber("With Poster?", "5");

		homePage.unCheckToCheckBoxByColumnNameAtRowNumber("With Poster?", "1");
		homePage.unCheckToCheckBoxByColumnNameAtRowNumber("With Poster?", "2");
		homePage.unCheckToCheckBoxByColumnNameAtRowNumber("With Poster?", "4");

		homePage.clickToIconByRowNumber("1", "Insert Row Above");
		homePage.clickToIconByRowNumber("2", "Move Up");
		homePage.clickToIconByRowNumber("3", "Move Down");
		homePage.clickToIconByRowNumber("5", "Remove Current Row");
		homePage.clickToIconByRowNumber("4", "Remove Current Row");
		homePage.clickToIconByRowNumber("3", "Remove Current Row");
		homePage.clickToIconByRowNumber("2", "Remove Current Row");
		homePage.clickToIconByRowNumber("1", "Remove Current Row");

	}

	@AfterClass
	public void afterClass() {
		// driver.quit();
	}

}
