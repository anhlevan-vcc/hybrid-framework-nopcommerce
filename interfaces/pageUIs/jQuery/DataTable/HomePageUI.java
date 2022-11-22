package pageUIs.jQuery.DataTable;

public class HomePageUI {
	public static final String PAGINATION_PAGE_BY_NUMBER = "//li[@class='qgrd-pagination-page']/a[text()='%s']";
	public static final String PAGINATION_PAGE_ACTIVED_BY_NUMBER = "//li[@class='qgrd-pagination-page']//a[@class='qgrd-pagination-page-link active' and text()='%s']";
	public static final String HEADER_TEXTBOX_BY_LABEL_NAME = "//div[text()='%s']/parent::div/following-sibling::input";
	public static final String TOTAL_PAGINAION = "css=ul.qgrd-pagination-ul>li.qgrd-pagination-page";
	public static final String PAGINATION_PAGE_ALL_INDEX = "//ul[@class='qgrd-pagination-ul']//li[@class='qgrd-pagination-page'][%s]/a";
	public static final String ALL_ROW_EACH_PAGE = "//tbody//tr";
	public static final String CUSTOM_ROW_ALL_PAGE = "//tbody//tr//td[@data-key='%s']";

	// index của cột mà mình cần hành động vào
	public static final String COLUMN_INDEX_BY_NAME = "xpath=//tr//td[text()='%s']//preceding-sibling::td";
	public static final String TEXTBOX_BY_COLUMN_INDEX_AND_ROW_INDEX = "xpath=//tbody/tr[%s]/td[%s]/input";
	public static final String DROPDOWN_BY_COLUMN_INDEX_AND_ROW_INDEX = "xpath=//tbody/tr[%s]/td[%s]/select";

	public static final String LOAD_BUTTON = "css=button#btnLoad";

	public static final String CHECKBOX_BY_COLUMN_INDEX_AND_ROW_INDEX = "xpath=//tbody/tr[%s]/td[%s]/input[@type='checkbox']";

	public static final String ICONNAME_BY_ROW_NUMBER = "//tbody/tr[%s]//button[@title='%s']";

}
