package commons;

import java.io.File;

import lombok.Getter;

@Getter
public class GlobalConstants {
	private static GlobalConstants globalInstance;

	private GlobalConstants() {

	}

	public static synchronized GlobalConstants getGlobalConstants() {
		if (globalInstance == null) {
			globalInstance = new GlobalConstants();
		}
		return globalInstance;
	}

	private final String userPageUrl = "https://demo.nopcommerce.com/";
	private final String adminPageUrl = "https://admin-demo.nopcommerce.com/";

	private final String projectPath = System.getProperty("user.dir");
	private final String osName = System.getProperty("os.name");
	private final String javaVersion = System.getProperty("java.version");

	private final String uploadFile = projectPath + File.separator + "uploadFiles" + File.separator;
	private final String downloadFile = projectPath + File.separator + "downloadFile";
	private final String browserLog = projectPath + File.separator + "browserLogs" + File.separator;
	private final String dragDropHtml5 = projectPath + File.separator + "dragDropHTML5";
	private final String autoItScript = projectPath + File.separator + "autoIT";
	private final String reportNgScreenshot = projectPath + File.separator + "reportNGImage" + File.separator;

	// data base
	private final String dbDevUrl = "31.18.252.185:9860";
	private final String dbDevUser = "leanh";
	private final String dbDevPass = "Vcc@1234";

	private final String browserUserName = "lvnanh_VxkBQ6";
	private final String browserAutomateKey = "zpJqBHy9JmFQ7GATTgUm";
	private final String browserStackUrl = "https://" + browserUserName + ":" + browserAutomateKey + "@hub.browserstack.com/wd/hub";;

	private final long longTimeout = 30;
	private final long shortTimeout = 5;
	private final long retryTestFail = 3;

}
