package javaOOP;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;

public class Topic_08_BaseOOP {
	private WebDriver driver;
	public long shortTimeout = 10;
	protected long longTimeout = 20;

	protected Topic_08_BaseOOP() {
		System.out.println("Constructor của class cha 1");

	}

	protected Topic_08_BaseOOP(String name) {
		System.out.println("Constructor của class cha 2");

	}

	protected Topic_08_BaseOOP(int number) {
		System.out.println("Constructor của class cha 3");

	}

	public void setImplicitWait() {
		long longTimeout = 40;
		driver.manage().timeouts().implicitlyWait(longTimeout, TimeUnit.SECONDS);
	}
}
