package commons;

import java.io.File;

public class GlobalConstants {
	public static final String PORTAL_PAGE_URL = "https://demo.nopcommerce.com/";
	public static final String ADMIN_PAGE_URL = "https://admin-demo.nopcommerce.com/";

	public static final String PROJECT_PATH = System.getProperty("user.dir");
	public static final String OS_NAME = System.getProperty("os.name");

	public static final String UPLOAD_FILE = PROJECT_PATH + File.separator + "uploadFiles" + File.separator;
	public static final String DOWNLOAD_FILE = PROJECT_PATH + File.separator + "downloadFile";
	public static final String BROWSER_LOG = PROJECT_PATH + File.separator + "browserLogs";
	public static final String DRAG_DROP_HTML5 = PROJECT_PATH + File.separator + "dragDropHTML5";
	public static final String AUTO_IT_SCRIPT = PROJECT_PATH + File.separator + "autoIT";

	// data base
	public static final String DB_DEV_URL = "31.18.252.185:9860";
	public static final String DB_DEV_USER = "leanh";
	public static final String DB_DEV_PASS = "Vcc@1234";

	public static final String DB_TEST_URL = "31.18.195.22:9860";
	public static final String DB_TEST_USER = "leanh";
	public static final String DB_TEST_PASS = "Vcc@1234";

	public static final long LONG_TIMEOUT = 20;
	public static final long SHORT_TIMEOUT = 5;
	public static final long RETRY_TEST_FAIL = 3;
}
