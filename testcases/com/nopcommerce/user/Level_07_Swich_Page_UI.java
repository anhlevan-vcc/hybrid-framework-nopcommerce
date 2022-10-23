package com.nopcommerce.user;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import commons.BaseTest;
import pageObject.HomePageObject;
import pageObject.LoginPageObject;
import pageObject.MyProductReviewPageObject;
import pageObject.OrdersPageObject;
import pageObject.AddressPageObject;
import pageObject.BackInStockSubscriptionsPageObject;
import pageObject.ChangePasswordPageObject;
import pageObject.CustomerInfoPageObject;
import pageObject.DownloadableProductsPageObject;
import pageObject.PageGeneratorManager;
import pageObject.RegisterPageObject;
import pageObject.RewardPointPageObject;

public class Level_07_Swich_Page_UI extends BaseTest {
	private WebDriver driver;
	private HomePageObject homePage;
	private LoginPageObject loginPage;
	private RegisterPageObject registerPage;
	private CustomerInfoPageObject customerinfoPage;
	private AddressPageObject addressPage;
	private MyProductReviewPageObject myProductReviewPage;
	private RewardPointPageObject rewardPointPage;
	private OrdersPageObject ordersPage;
	private DownloadableProductsPageObject downloadableProductsPage;
	private BackInStockSubscriptionsPageObject backInStockSubscriptionsPage;
	private ChangePasswordPageObject changePasswordPage;

	private String validEmail, firstName, lastName, password;

	@Parameters("browser")
	@BeforeClass
	public void beforeClass(String browserName) {
		driver = getBrowserDriver(browserName);

		homePage = PageGeneratorManager.getHomePage(driver);

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
		customerinfoPage = homePage.openMyAccountPage();
		customerinfoPage.clickToNewsletterCheckbox();
	}

	@Test
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
	public void User_04_Swich_Role() {
		// Role User => Role Admin

		// Role Admin => Role User
	}

	@AfterClass
	public void afterClass() {
		driver.quit();
	}

}
