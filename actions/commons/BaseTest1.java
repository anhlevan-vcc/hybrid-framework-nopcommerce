package commons;

import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.opera.OperaDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseTest {
	private WebDriver driver;

	protected WebDriver getBrowserDriver(String browserName) {
		if (browserName.equals("firefox")) {
			// System.setProperty("webdriver.gecko.driver", projectPath + "\\browserDrivers\\geckodriver.exe");
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();

		} else if (browserName.equals("h_firefox")) {
			WebDriverManager.firefoxdriver().setup();
			FirefoxOptions options = new FirefoxOptions();
			options.addArguments("--headless");
			options.addArguments("window-size=1920x1080");
			driver = new FirefoxDriver(options);

		} else if (browserName.equals("chrome")) {
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();

		} else if (browserName.equals("h_chrome")) {
			WebDriverManager.chromedriver().setup();
			ChromeOptions options = new ChromeOptions();
			options.addArguments("--headless");
			options.addArguments("window-size=1920x1080");
			driver = new ChromeDriver(options);

		} else if (browserName.equals("edge")) {
			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();

		} else if (browserName.equals("opera")) {
			WebDriverManager.operadriver().setup();
			driver = new OperaDriver();

		} else if (browserName.equals("ie")) {
			WebDriverManager.iedriver().arch32().setup();
			driver = new InternetExplorerDriver();

		} else if (browserName.equals("coccoc")) {
			WebDriverManager.chromedriver().driverVersion("105.0.5195.52").setup();
			ChromeOptions options = new ChromeOptions();
			options.setBinary("C:\\Program Files (x86)\\CocCoc\\Browser\\Application\\browser.exe");
			driver = new ChromeDriver(options);

		} else if (browserName.equals("brave")) {
			WebDriverManager.chromedriver().driverVersion("105.0.5195.52").setup();
			ChromeOptions options = new ChromeOptions();
			options.setBinary("C:\\Program Files\\BraveSoftware\\Brave-Browser\\Application\\brave.exe");
			driver = new ChromeDriver(options);

		} else {
			throw new RuntimeException("Browser name invalid");
		}
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.get("https://demo.nopcommerce.com/");
		return driver;
	}

	protected int generateRandomNumber() {
		Random rand = new Random();
		return rand.nextInt(9999);
	}
}
