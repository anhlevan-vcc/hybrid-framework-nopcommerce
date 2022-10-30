package com.nopcommerce.user;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import commons.BaseTest;
import commons.PageGeneratorManager;
import pageObject.nopCommerce.user.UserAddressPageObject;
import pageObject.nopCommerce.user.UserBackInStockSubscriptionsPageObject;
import pageObject.nopCommerce.user.UserChangePasswordPageObject;
import pageObject.nopCommerce.user.UserCustomerInfoPageObject;
import pageObject.nopCommerce.user.UserDownloadableProductsPageObject;
import pageObject.nopCommerce.user.UserHomePageObject;
import pageObject.nopCommerce.user.UserLoginPageObject;
import pageObject.nopCommerce.user.UserMyProductReviewPageObject;
import pageObject.nopCommerce.user.UserOrdersPageObject;
import pageObject.nopCommerce.user.UserRegisterPageObject;
import pageObject.nopCommerce.user.UserRewardPointPageObject;

public class Level_09_Dynamic_Locator extends BaseTest {
	private WebDriver driver;
	private UserHomePageObject homePage;
	private UserLoginPageObject loginPage;
	private UserRegisterPageObject registerPage;
	private UserCustomerInfoPageObject customerinfoPage;
	private UserAddressPageObject addressPage;
	private UserMyProductReviewPageObject myProductReviewPage;
	private UserRewardPointPageObject rewardPointPage;
	private UserOrdersPageObject ordersPage;
	private UserDownloadableProductsPageObject downloadableProductsPage;
	private UserBackInStockSubscriptionsPageObject backInStockSubscriptionsPage;
	private UserChangePasswordPageObject changePasswordPage;

	private String validEmail, firstName, lastName, password;

	@Parameters("browser")
	@BeforeClass
	public void beforeClass(String browserName) {
		driver = getBrowserDriver(browserName);

		homePage = PageGeneratorManager.getUserHomePage(driver);

		firstName = "Automation";
		lastName = "FC";
		validEmail = "Automation" + generateRandomNumber() + "@gmail.com";
		password = "123456";

	}

	@Test
	public void User_01_Register() {
		registerPage = homePage.openRegisterPage();
		registerPage.inputToFirstnameTextbox(firstName);
		registerPage.inputToLastnameTextbox(lastName);
		registerPage.inputToEmailTextbox(validEmail);
		registerPage.inputToPasswordTextbox(password);
		registerPage.inputToConfirmPasswordTextbox(password);
		registerPage.clickToRegisterButton();

		Assert.assertEquals(registerPage.getMessageSuccess(), "Your registration completed");
		homePage = registerPage.clickToLogoutLink();
	}

	@Test
	public void User_02_Login() {
		loginPage = homePage.openLoginPage();
		loginPage.inputToEmailTextbox(validEmail);
		loginPage.inputToPasswordTextbox(password);

		homePage = loginPage.clickToLoginButton();
		Assert.assertEquals(homePage.getMessageSuccess(), "Welcome to our store");
	}

	@Test
	public void User_03_MyAccount() {
		customerinfoPage = homePage.openMyAccountCustomerInfoPage();
		customerinfoPage.clickToNewsletterCheckbox();
	}

	// @Test
	public void User_04_Swich_Page() {
		// Một page A muốn chuyển qua Page B thì phải viết 1 hàm
		// Action mở page B : open/click/ link, button, image...

		// Customer info =>Addresses
		addressPage = customerinfoPage.openAddressPage(driver);

		// Address => My product reviews
		myProductReviewPage = addressPage.openMyProductReviewPage(driver);

		// My product reviews => Reward points
		rewardPointPage = myProductReviewPage.openRewardPointPage(driver);

		// Reward points => Address
		addressPage = rewardPointPage.openAddressPage(driver);

		// Addresses => Reward points
		rewardPointPage = addressPage.openRewardPointPage(driver);

		// Reward points=> My product reviews
		myProductReviewPage = rewardPointPage.openMyProductReviewPage(driver);

		// My product reviews => Address
		addressPage = myProductReviewPage.openAddressPage(driver);

		ordersPage = addressPage.openOrdersPage(driver);

		downloadableProductsPage = ordersPage.openDownloadableProductsPage(driver);

		backInStockSubscriptionsPage = downloadableProductsPage.openBackInStockSubscriptionsPage(driver);

		rewardPointPage = backInStockSubscriptionsPage.openRewardPointPage(driver);

		changePasswordPage = rewardPointPage.openChangePasswordPage(driver);

		myProductReviewPage = changePasswordPage.openMyProductReviewPage(driver);
	}

	@Test
	public void User_05_Dynamic_Locator() {
		// Customer info =>Addresses
		addressPage = (UserAddressPageObject) customerinfoPage.openPageAtMyAccountByName(driver, "Addresses");

		// Address => My product reviews
		myProductReviewPage = (UserMyProductReviewPageObject) addressPage.openPageAtMyAccountByName(driver, "My product reviews");

		// My product reviews => Reward points
		rewardPointPage = (UserRewardPointPageObject) myProductReviewPage.openPageAtMyAccountByName(driver, "Reward points");

		// Reward points => Address
		addressPage = (UserAddressPageObject) rewardPointPage.openPageAtMyAccountByName(driver, "Addresses");

		// Addresses => Reward points
		rewardPointPage = (UserRewardPointPageObject) addressPage.openPageAtMyAccountByName(driver, "Reward points");

		// Reward points=> My product reviews
		myProductReviewPage = (UserMyProductReviewPageObject) rewardPointPage.openPageAtMyAccountByName(driver, "My product reviews");

		// My product reviews => Address
		addressPage = (UserAddressPageObject) myProductReviewPage.openPageAtMyAccountByName(driver, "Addresses");

		ordersPage = (UserOrdersPageObject) addressPage.openPageAtMyAccountByName(driver, "Orders");

		downloadableProductsPage = (UserDownloadableProductsPageObject) ordersPage.openPageAtMyAccountByName(driver, "Downloadable products");

		backInStockSubscriptionsPage = (UserBackInStockSubscriptionsPageObject) downloadableProductsPage.openPageAtMyAccountByName(driver, "Back in stock subscriptions");

		rewardPointPage = (UserRewardPointPageObject) backInStockSubscriptionsPage.openPageAtMyAccountByName(driver, "Reward points");

		changePasswordPage = (UserChangePasswordPageObject) rewardPointPage.openPageAtMyAccountByName(driver, "Change password");

		myProductReviewPage = (UserMyProductReviewPageObject) changePasswordPage.openPageAtMyAccountByName(driver, "My product reviews");
	}

	@AfterClass
	public void afterClass() {
		driver.quit();
	}

}
