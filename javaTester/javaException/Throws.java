package javaException;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Throws {
	WebDriver driver;
	String projectPath = System.getProperty("user.dir");

	@BeforeClass
	public void beforeClass() {
		System.setProperty("webdriver.gecko.driver", projectPath + "\\browserDrivers\\geckodriver.exe");
		driver = new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.manage().window().maximize();

	}

	// Throws - sử dụng trong khai báo phương thức để khai báo những ngoại lệ (exceptions) có thể xảy ra trong phương thức đó
	// Có thể khai báo một hoặc nhiều
	@Test
	public void TC_02_Frame() throws InterruptedException {
		driver.get("https://netbanking.hdfcbank.com/netbanking/");
		driver.switchTo().frame("login_page");

		driver.findElement(By.name("fldLoginUserId")).sendKeys("automationtest");
		driver.findElement(By.cssSelector("a.login-btn")).click();

		Thread.sleep(2000);

		Assert.assertTrue(driver.findElement(By.id("fldPasswordDispId")).isDisplayed());
	}

	@Test
	public void TC_06_Authentication_Alert_AutoIT_Windows() throws IOException {
		String username = "admin";
		String password = "admin";
		String authenFirefox = null;
		String[] autoITScript = { authenFirefox, username, password };

		// Inject/ Call executable file
		Runtime.getRuntime().exec(autoITScript);

		driver.get("http://the-internet.herokuapp.com/basic_auth");
		sleepInSecond(5);

		Assert.assertTrue(driver.findElement(By.xpath("//p[contains(text(),'Congratulations! You must have the proper credentials.')]")).isDisplayed());
	}

	@AfterClass
	public void afterClass() {
		driver.quit();
	}

	public void sleepInSecond(long timeInSecond) {
		try {
			Thread.sleep(timeInSecond * 1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

}
