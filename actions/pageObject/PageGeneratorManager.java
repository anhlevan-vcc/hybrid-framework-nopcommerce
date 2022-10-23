package pageObject;

import org.openqa.selenium.WebDriver;

public class PageGeneratorManager {

	public static HomePageObject getHomePage(WebDriver driver) {
		return new HomePageObject(driver);
	}

	public static RegisterPageObject getRegisterPage(WebDriver driver) {
		return new RegisterPageObject(driver);
	}

	public static LoginPageObject getLoginPage(WebDriver driver) {
		return new LoginPageObject(driver);
	}

	public static CustomerInfoPageObject getCustomerInfoPage(WebDriver driver) {
		return new CustomerInfoPageObject(driver);
	}

	public static AddressPageObject getAddressPage(WebDriver driver) {
		return new AddressPageObject(driver);
	}

	public static RewardPointPageObject getRewardPointPage(WebDriver driver) {
		return new RewardPointPageObject(driver);
	}

	public static MyProductReviewPageObject getMyProductReviewPage(WebDriver driver) {
		return new MyProductReviewPageObject(driver);
	}

	public static OrdersPageObject getOrdersPage(WebDriver driver) {
		return new OrdersPageObject(driver);
	}

	public static DownloadableProductsPageObject getDownloadableProductsPage(WebDriver driver) {
		return new DownloadableProductsPageObject(driver);
	}

	public static BackInStockSubscriptionsPageObject getBackInStockSubscriptionsPage(WebDriver driver) {
		return new BackInStockSubscriptionsPageObject(driver);
	}

	public static ChangePasswordPageObject getChangePasswordPage(WebDriver driver) {
		return new ChangePasswordPageObject(driver);
	}
}
