package pageUIs.wordpress;

public class AdminPostSearchPageUI {
	public static final String ADD_NEW_BUTTON = "css=a.page-title-action";
	public static final String SEARCH_TEXTBOX = "css=input#post-search-input";
	public static final String SEARCH_POSTS_BUTTON = "css=input#search-submit";
	/*
	 * Lấy ra index của cột bằng id của header VD:Nhập %s = title sẽ lấy ra index của cột title là 2 Truyền index= 2 xuống %s ở ngay dưới
	 */
	public static final String TABLE_HEADER_INDEX_BY_HEADER_ID = "//table[contains(@class,'table-view-list posts')]//th[@id='%s']/preceding-sibling::*";
	/*
	 * Lấy ra giá trị của hàng trong bảng bằng header index VD:Truyền index =2 vào %s 1 vị trí của cột. %s 2 giá trị tại vị trí cột đó
	 */
	public static final String TABLE_ROW_VALUE_BY_HEADER_INDEX = "//table[contains(@class,'table-view-list posts')]/tbody/tr/*[%s]//a[text()='%s']";
}
