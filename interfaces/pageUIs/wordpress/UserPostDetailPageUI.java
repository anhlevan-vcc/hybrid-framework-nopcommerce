package pageUIs.wordpress;

public class UserPostDetailPageUI {
	public static final String POST_TITLE_TEXT = "//h1[text()='%s']";
	public static final String POST_CURRENT_DATE_TEXT_BY_POST_TITLE = "//h1[text()='%s']/following-sibling::div//time[text()='%s']";
	public static final String POST_BODY_TEXT_BY_POST_TITLE = "//h1[text()='%s']//parent::header/following-sibling::div/p[text()='%s']";
	public static final String POST_AUTHOR_TEXT_BY_POST_TITLE = "//h1[text()='%s']/following-sibling::div//span//a[text()='%s']";

}
