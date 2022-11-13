package javaException;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class StaleElementReferenceException {
	WebDriver driver;
	String projectPath = System.getProperty("user.dir");

	@BeforeClass
	public void beforeClass() {
		System.setProperty("webdriver.gecko.driver", projectPath + "\\browserDrivers\\geckodriver.exe");
		driver = new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.manage().window().maximize();

	}

	@Test
	public void TC_01_() {
		// StaleElementReferenceException: Element vẫn còn xuất hiện trong DOM nhưng bị change state (DOM bị render lại)
		WebDriverWait explicitWait = new WebDriverWait(driver, 10);

		driver.get("http://demos.telerik.com/aspnet-ajax/ajaxloadingpanel/functionality/explicit-show-hide/defaultcs.aspx");

		explicitWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='ctl00_ContentPlaceholder1_Panel1']")));

		WebElement dataNotSelected = driver.findElement(By.xpath("//*[@id='ctl00_ContentPlaceholder1_Label1']"));

		Assert.assertEquals("No Selected Dates to display.", dataNotSelected.getText().trim());

		WebElement today = driver.findElement(By.xpath("//a[text()='2']"));

		today.click();

		explicitWait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[@class='raDiv']")));

		explicitWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//td[@class='rcSelected']//a[text()='2']")));

		// After page RENDER again

		Assert.assertEquals("Sunday, January 2, 2022", dataNotSelected.getText().trim());

	}

	@Test
	public void TC_02_() {

	}

	@AfterClass
	public void afterClass() {
		driver.quit();
	}
}
