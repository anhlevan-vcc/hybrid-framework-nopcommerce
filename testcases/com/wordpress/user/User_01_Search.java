package com.wordpress.user;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import commons.BaseTest;

public class User_01_Search extends BaseTest {
	private WebDriver driver;

	@Parameters("browser")
	@BeforeClass
	public void beforeClass(String browserName) {
		driver = getBrowserDriver(browserName);

	}

	@Test
	public void Post_01_Create_New_Post() {
	}

	@Test
	public void Post_02_Search_Post() {
	}

	@Test
	public void Post_03_View_Post() {
	}

	@Test
	public void Post_04_Edit_Post() {
	}

	@Test
	public void Post_04_Dellete_Post() {
	}

	@AfterClass(alwaysRun = true)
	public void afterClass() {
		closeBrowserAndDriver();
	}

}
