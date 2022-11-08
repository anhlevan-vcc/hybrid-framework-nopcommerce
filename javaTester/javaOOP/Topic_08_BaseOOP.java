package javaOOP;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;

public class Topic_08_BaseOOP {
	private WebDriver driver;
	public long shortTimeout = 10;
	protected long longTimeout = 20;

	public void setImplicitWait() {
		long longTimeout = 40;
		driver.manage().timeouts().implicitlyWait(longTimeout, TimeUnit.SECONDS);
	}
}
