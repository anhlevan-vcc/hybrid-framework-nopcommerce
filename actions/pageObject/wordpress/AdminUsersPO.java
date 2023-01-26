package pageObject.wordpress;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import jdbcTest.MySQLConnUtils;
import jdbcTest.MySQLTestConnection;
import pageUIs.wordpress.AdminDashboardPageUI;
import pageUIs.wordpress.AdminUsersPageUI;

public class AdminUsersPO extends BasePage {
	private WebDriver driver;

	public AdminUsersPO(WebDriver driver) {
		this.driver = driver;
	}

	public int getUsersNumberUI() {
		waitForElementVisible(driver, AdminUsersPageUI.TOTAL_NUMBER_TEXT);
		String totalNumber = getElementText(driver, AdminUsersPageUI.TOTAL_NUMBER_TEXT);
		int total = Integer.parseInt(totalNumber.split(" ")[0]);
		System.out.println("UI= " + total);
		return total;
	}

	public int getUsersNumberDB() {
		Connection conn = MySQLConnUtils.getMySQLConnection();
		Statement statement;
		List<Integer> totalUsers = new ArrayList<Integer>();
		try {
			statement = conn.createStatement();
			String sql = "SELECT * FROM wp_users";
			ResultSet rs = statement.executeQuery(sql);
			while (rs.next()) {
				totalUsers.add(rs.getInt(1));
				System.out.println(rs.getInt(1));
				System.out.println(rs.getString(2));
				System.out.println(rs.getString(3));
				System.out.println(rs.getString(7));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (conn != null) {
					conn.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		System.out.println("DB= " + totalUsers.size());
		return totalUsers.size();
	}
}
