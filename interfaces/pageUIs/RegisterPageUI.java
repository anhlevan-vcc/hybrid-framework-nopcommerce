package pageUIs;

public class RegisterPageUI {

	public static final String FIRST_NAME_TEXTBOX = "//input[@id='FirstName']";
	public static final String LAST_NAME_TEXTBOX = "//input[@id='LastName']";
	public static final String EMAIL_TEXTBOX = "//input[@id='Email']";
	public static final String PASSWORD_TEXTBOX = "//input[@id='Password']";
	public static final String CONFIRM_PASS_TEXTBOX = "//input[@id='ConfirmPassword']";
	public static final String REGISTER_BUTTON = "//button[@id= 'register-button']";
	public static final String FIRST_NAME_ERROR_MESSAGE = "//span[@id='FirstName-error']";
	public static final String LAST_NAME_ERROR_MESSAGE = "//span[@id='LastName-error']";
	public static final String EMAIL_ERROR_MESSAGE = "//span[@id='Email-error']";
	public static final String PASS_ERROR_MESSAGE = "//span[@id='Password-error']";
	public static final String COMFIRM_PASS_ERROR_MESSAGE = "//span[@id='ConfirmPassword-error']";
	public static final String LOGOUT_LINK = "//a[@class= 'ico-logout']";
	public static final String REGISTER_SUCCESS_MASSAGE = "//div[@class='result']";
	public static final String EXISTING_EMAIL_ERROR_MASSAGE = "//div[contains(@class,'message-error')]//li";
}
