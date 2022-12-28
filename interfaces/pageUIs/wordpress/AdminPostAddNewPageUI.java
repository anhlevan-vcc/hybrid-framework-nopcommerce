package pageUIs.wordpress;

public class AdminPostAddNewPageUI {
	// class* :dùng để lấy 1 đoạn trong 1 class dài của css
	public static final String TITLE_TEXTBOX = "css=h1[class*='wp-block wp-block-post-title']";
	public static final String BODY_TEXTBOX_BEFORE_CLICK = "//p[@class='block-editor-default-block-appender__content']";
	public static final String BODY_TEXTBOX_AFTER_CLICK = "//p[@class='block-editor-rich-text__editable block-editor-block-list__block wp-block is-selected wp-block-paragraph rich-text']";
	public static final String BODY_EDIT_TEXTBOX_BEFORE_CLICK = "//p[@class='block-editor-rich-text__editable block-editor-block-list__block wp-block wp-block-paragraph rich-text']";
	public static final String PUBLISH_OR_UPDATE_BUTTON = "//button[contains(@class,'editor-post-publish-button')]";
	public static final String PRE_PUBLISH_BUTTON = "css=button.editor-post-publish-button";
	public static final String PUBLISHED_OR_UPDATE_MESSAGE = "//div[@class='components-snackbar__content' and text()='%s']";
}
