package javaOOP;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;

public class Topic_08_Super extends Topic_08_BaseOOP {
	private WebDriver driver;
	private long longTimeout = 40;

	// Trong class cha vào con có biến cùng tên thì
	// Dùng super thì gọi tới biến của thằng cha
	// Không dùng super thì gọi tới biến của thằng con
	public void setImplicitWait() {
		long longTimeout = 40;
		driver.manage().timeouts().implicitlyWait(super.longTimeout, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(this.longTimeout, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(longTimeout, TimeUnit.SECONDS);
	}

	public void clickToElement() {
		// Không dùng super thì nó sẽ gọi tới hàm ở class con(hiện tại)
		setImplicitWait();

		// Dùng super thì gọi tới hàm của class cha (class kế thừa)
		super.setImplicitWait();
	}

	public static void main(String[] args) {

	}
}
