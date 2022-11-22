package com.jquery.uploadfile;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import commons.BaseTest;
import pageObject.jQuery.UploadFile.HomePageObject;
import pageObject.jQuery.UploadFile.PageGeneratorManager;

public class Level_11_Upload_File extends BaseTest {
	private WebDriver driver;
	private HomePageObject homePage;

	String hoaDaoFileName = "hoadao.jpg";
	String hoaHongFileName = "hoahong.jpg";
	String hoaMaiFileName = "hoamai.jpg";
	String hoaSenFileName = "hoasen.jpg";
	String hoaTuylipFileName = "hoatuylip.jpg";
	String[] multipleFileNames = { hoaDaoFileName, hoaHongFileName, hoaMaiFileName, hoaSenFileName, hoaTuylipFileName };

	@Parameters({ "browser", "url" })
	@BeforeClass
	public void beforeClass(String browserName, String appUrl) {
		driver = getBrowserDriver(browserName, appUrl);
		homePage = PageGeneratorManager.getHomePage(driver);

	}

	@Test
	public void Upload_01_One_File() {
		homePage.uploadMultipleFiles(driver, hoaDaoFileName);

		Assert.assertTrue(homePage.isFileLoadedFileName(hoaDaoFileName));

		homePage.clickStartButton();
		Assert.assertTrue(homePage.isFileLinkUpLoadedFileName(hoaDaoFileName));
		Assert.assertTrue(homePage.isFileImageUpLoadedFileName(hoaDaoFileName));

	}

	@Test
	public void Upload_02_Multuper_File() {
		homePage.refreshCurrentPage(driver);
		homePage.uploadMultipleFiles(driver, multipleFileNames);

		Assert.assertTrue(homePage.isFileLoadedFileName(hoaDaoFileName));
		Assert.assertTrue(homePage.isFileLoadedFileName(hoaHongFileName));
		Assert.assertTrue(homePage.isFileLoadedFileName(hoaMaiFileName));
		Assert.assertTrue(homePage.isFileLoadedFileName(hoaSenFileName));
		Assert.assertTrue(homePage.isFileLoadedFileName(hoaTuylipFileName));

		homePage.clickStartButton();
		Assert.assertTrue(homePage.isFileLinkUpLoadedFileName(hoaDaoFileName));
		Assert.assertTrue(homePage.isFileLinkUpLoadedFileName(hoaHongFileName));
		Assert.assertTrue(homePage.isFileLinkUpLoadedFileName(hoaMaiFileName));
		Assert.assertTrue(homePage.isFileLinkUpLoadedFileName(hoaSenFileName));
		Assert.assertTrue(homePage.isFileLinkUpLoadedFileName(hoaTuylipFileName));

		Assert.assertTrue(homePage.isFileImageUpLoadedFileName(hoaDaoFileName));
		Assert.assertTrue(homePage.isFileImageUpLoadedFileName(hoaHongFileName));
		Assert.assertTrue(homePage.isFileImageUpLoadedFileName(hoaMaiFileName));
		Assert.assertTrue(homePage.isFileImageUpLoadedFileName(hoaSenFileName));
		Assert.assertTrue(homePage.isFileImageUpLoadedFileName(hoaTuylipFileName));
	}

	@AfterClass
	public void afterClass() {
		driver.quit();
	}

}
