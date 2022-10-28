package pageUIs.nopCommerce.user;

public class RegisterPageUI {

	public static final String FIRST_NAME_TEXTBOX = "XPATH=//input[@id='FirstName']";
	public static final String LAST_NAME_TEXTBOX = "XPATH=//input[@id='LastName']";
	public static final String EMAIL_TEXTBOX = "XPATH=//input[@id='Email']";
	public static final String PASSWORD_TEXTBOX = "XPATH=//input[@id='Password']";
	public static final String CONFIRM_PASS_TEXTBOX = "XPATH=//input[@id='ConfirmPassword']";
	public static final String REGISTER_BUTTON = "XPATH=//button[@id= 'register-button']";
	public static final String FIRST_NAME_ERROR_MESSAGE = "XPATH=//span[@id='FirstName-error']";
	public static final String LAST_NAME_ERROR_MESSAGE = "XPATH=//span[@id='LastName-error']";
	public static final String EMAIL_ERROR_MESSAGE = "XPATH=//span[@id='Email-error']";
	public static final String PASS_ERROR_MESSAGE = "XPATH=//span[@id='Password-error']";
	public static final String COMFIRM_PASS_ERROR_MESSAGE = "XPATH=//span[@id='ConfirmPassword-error']";
	public static final String LOGOUT_LINK = "XPATH=//a[@class= 'ico-logout']";
	public static final String REGISTER_SUCCESS_MASSAGE = "XPATH=//div[@class='result']";
	public static final String EXISTING_EMAIL_ERROR_MASSAGE = "XPATH=//div[contains(@class,'message-error')]//li";
}
