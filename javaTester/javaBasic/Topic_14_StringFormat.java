package javaBasic;

public class Topic_14_StringFormat {

	public static String CUSTOMERINFO_LINK = "//div[@class='side-2']//a[text()= 'Customer info']";
	public static String ADDRESS_LINK = "//div[@class='side-2']//a[text()= 'Addresses']";
	public static String REWARDPOINT_LINK = "//div[@class='side-2']//a[text()= 'Reward points']";
	public static String MYPRODUCTREVIEW_LINK = "//div[@class='side-2']//a[text()= 'My product reviews']";
	public static String ORDERS_LINK = "//div[@class='side-2']//a[text()= 'Orders']";

	public static String DYNAMIC_LINK_BY_PAGE_NAME = "//div[@class='side-2']//a[text()= '%s']";

	// Dùng 1 locator đại điện cho tất cả các link ở footer/sidebar/ header
	public static String DYNAMIC_LINK = "//div[contains(@class,'%s')]//a[text()= '%s']";

	public static void main(String[] args) {
		clickToLink(MYPRODUCTREVIEW_LINK);
		clickToLink(ORDERS_LINK);

		clickToLink(DYNAMIC_LINK_BY_PAGE_NAME, "Customer info");
		clickToLink(DYNAMIC_LINK_BY_PAGE_NAME, "Addresses");
		clickToLink(DYNAMIC_LINK_BY_PAGE_NAME, "Reward points");

		clickToLink(DYNAMIC_LINK, "footer", "Search");
		clickToLink(DYNAMIC_LINK, "master-wrapper-content", "Customer info");

	}

	// public static void clickToLink(String locator) {
	// System.out.println("Click to " + locator);
	// }

	// 1 tham số động
	// public static void clickToLink(String dynamicLocator, String pageName) {
	// // dynamicLocator = "//div[@class='side-2']//a[text()= '%s']"
	// // pageName = Customer info ....
	// // thế cái pageName vào %s
	// String locator = String.format(dynamicLocator, pageName);
	// System.out.println("Click to " + locator);
	// }

	// 2 tham số động
	// public static void clickToLink(String dynamicLocator, String areaName, String pageName) {
	// String locator = String.format(dynamicLocator, areaName, pageName);
	// System.out.println("Click to " + locator);
	// }

	// 1-> n tham số động
	public static void clickToLink(String dynamicLocator, String... params) {
		String locator = String.format(dynamicLocator, (Object[]) params);
		System.out.println("Click to " + locator);
	}
}
