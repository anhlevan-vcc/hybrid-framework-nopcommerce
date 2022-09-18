package javaBasic;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.beust.jcommander.Parameter;

public class Topic_06_Condition_Statement {
	WebDriver driver;
	String projectPath = System.getProperty("user.dir");

	// @Test
	public void TC_01_If() {
		boolean status = 5 > 3;
		System.out.println(status);
		// hàm if sẽ nhận vào 1 điều kiện đúng
		// Kiểm tra duy nhất 1 điều kiện
		// nếu điều kiện này đúng thì sẽ action trong phần thân if
		if (status) {
			// đúng thì vào phần thân chạy Sai thì bỏ qua
			System.out.println("in ra tôi");
		}

		// gán(assign)
		int studentNumber = 20;

		// == dùng để so sánh
		status = (studentNumber != 20);
		// đúng thì in ra true/ sai in ra fail
		System.out.println(status);

		WebDriver driver = new FirefoxDriver();

		// Element luôn có trong Dom dù popup có hiển thị hay không
		WebElement salePopup = driver.findElement(By.cssSelector(""));
		if (!salePopup.isDisplayed()) {
			System.out.println("Element có trong Dom");
		}

		// Element không có trong DOM khi popup không hiển thị
		List<WebElement> salePopups = driver.findElements(By.cssSelector(""));
		// check element có hiển thị hay không
		if (salePopups.size() > 0 && salePopups.get(0).isDisplayed()) {
		}

		WebElement checkBox = driver.findElement(By.cssSelector(""));
		// uncheck
		if (checkBox.isSelected()) {
			checkBox.click();
		}

		// check thì ta phủ định lại
		if (!checkBox.isSelected()) {
			checkBox.click();
		}
	}

	// @Test
	public void TC_02_If_Else() {

		// if-else: đúng thì vào if sai thì vào else
		// Nêu trình duyệt khác ie thì dùng click của selenium
		// Nếu là IE thì dùng click cuả Java
//		System.setProperty("webdriver.ie.driver", projectPath + "\\browserDrivers\\IEDriverServer.exe");
//		driver = new InternetExplorerDriver();

		System.setProperty("webdriver.gecko.driver", projectPath + "\\browserDrivers\\geckodriver.exe");
		driver = new FirefoxDriver();

		System.out.println(driver.toString());

		if (driver.toString().contains("internet explorer")) {
			System.out.println("Click by Javascript Executor");
		} else {
			System.out.println("Click by Selenium WebElement");
		}
	}

	// @Parameters("browser")
	// @Test
	public void TC_03_If_Else_If_Else(String browserName) {
		// if-else: đúng thì vào if sai thì vào else
		// Nêu trình duyệt khác IE thì dùng click của selenium
		// Nếu là IE thì dùng click cuả Java

		if (browserName.equals("firefox")) {
			System.setProperty("webdriver.gecko.driver", projectPath + "\\browserDrivers\\geckodriver.exe");
			driver = new FirefoxDriver();
		} else if (browserName.equals("chrome")) {
			System.setProperty("webdriver.chrome.driver", projectPath + "\\browserDrivers\\chromedriver.exe");
			driver = new ChromeDriver();
		} else if (browserName.equals("edge")) {
			System.setProperty("webdriver.edge.driver", projectPath + "\\browserDrivers\\msedgedriver.exe");
			driver = new EdgeDriver();
		} else if (browserName.equals("ie")) {
			System.setProperty("webdriver.ie.driver", projectPath + "\\browserDrivers\\IEDriverServer.exe");
			driver = new InternetExplorerDriver();
		} else {
			throw new RuntimeException("Vui lòng nhập tên trình duyệt hợp lệ");
		}
		System.out.println(browserName);
		System.out.println(driver.toString());
		driver.quit();
	}

	// @Test
	public void TC_04_If_else_If_else() {
		// Page Object
		// Dynamic page

		String pageName = "Login";

		if (pageName.equals("Login")) {
			//LoginPage loginPage = new LogginPage();
			//return loginPage;
		} else if (pageName.equals("Register")) {
			//RegisterPage registerPage = new RegisterPage();
			//return registerPage;
		} else if (pageName.equals("Customer")) {
			//CustomerPage customerPage = new CustomerPage();
			//return customerPage;
		} else {
			//HomePage homePage = new HomePage();
			//return homePage;
		}

	}

	public static void main(String[] args) {
		// Tam nguyên cũng đc dùng để thay thế if-else
		int age = 20;
		String access = (age < 18) ? "Đúng age nhỏ hơn 18 hiện tôi" : "Nếu tuổi ko nhỏ hơn 18 thì hiện tôi";
		// nó tương đưng với if-else như này
		if (age < 18) {
			access = "Đúng age nhỏ hơn 18 hiện tôi";
		} else {
			access = "Nếu tuổi ko nhỏ hơn 18 thì hiện tôi";
		}
		System.out.println(access);
	}

}
