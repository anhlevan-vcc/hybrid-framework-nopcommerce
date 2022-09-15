package com.nopcommerce.user;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.AfterClass;

public class User_01_Register_Login {
	//Biến toàn cục - không đặt trong testcase phạm vi sử dụng toàn bộ
	String homePagrUrl = "";

	@BeforeClass
	public void beforeClass() {
		
	}

	@Test
	public void TC_01() {
		//Biến cục bộ - đặt trong testcase- phạm vi dùng trong testcase
		String homePagrUrl = "";
		System.out.println(homePagrUrl);
		if (1<2) {
			//Biến cục bộ nhưng chỉ dùng trong cái khối lệnh
			String homePageTitle = "";
			System.out.println(homePageTitle);
		}
	}


	@AfterClass
	public void afterClass() {
		
	}

}
