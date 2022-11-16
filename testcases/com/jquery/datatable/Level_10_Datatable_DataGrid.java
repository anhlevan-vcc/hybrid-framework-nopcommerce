package com.jquery.datatable;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import commons.BaseTest;

public class Level_10_Datatable_DataGrid extends BaseTest {
	private WebDriver driver;

	@Parameters("browser")
	@BeforeClass
	public void beforeClass(String browserName) {
		driver = getBrowserDriver(browserName);

	}

	@Test
	public void User_01_Register() {

	}

	@Test
	public void User_02_Login() {

	}

	@AfterClass
	public void afterClass() {
		driver.quit();
	}

}
