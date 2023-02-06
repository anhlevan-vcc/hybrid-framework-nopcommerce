package factoryBrowser;

import static org.apache.commons.lang3.SystemUtils.IS_OS_MAC;
import static org.apache.commons.lang3.SystemUtils.IS_OS_WINDOWS;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class EdgeDriverManager implements BrowserFactory {

	@Override
	public WebDriver getBrowserDriver() {
		if (!IS_OS_WINDOWS || !IS_OS_MAC) {
			throw new BrowserNotSupportedException("IE is not supported on " + System.getProperty("os.name"));
		}
		WebDriverManager.edgedriver().setup();
		EdgeOptions options = new EdgeOptions();
		return new EdgeDriver(options);
	}

}