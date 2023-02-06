package factoryBrowser;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import commons.GlobalConstants;
import io.github.bonigarcia.wdm.WebDriverManager;

public class BraveDriverManager implements BrowserFactory {

	@Override
	public WebDriver getBrowserDriver() {
		WebDriverManager.chromedriver().driverVersion("105.0.5195.52").setup();
		ChromeOptions options = new ChromeOptions();
		if (GlobalConstants.OS_NAME.startsWith("Windows")) {
			options.setBinary("C:\\Program Files\\BraveSoftware\\Brave-Browser\\Application\\brave.exe");
		} else {
			options.setBinary("...");
		}
		return new ChromeDriver(options);
	}
}
