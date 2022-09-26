package javaBasic;

import org.testng.annotations.Test;

public class Topic_12_Bt_String {

	String namePage = "Automation 12 2 33 44 5 5 Testing AdvanceDDD";

	@Test
	public void TC_01() {
		char namePageArr[] = namePage.toCharArray();
		int countUpper = 0;
		int countLowser = 0;
		int countNumber = 0;
		for (char x : namePageArr) {
			if (x <= 'Z' && x >= 'A') {
				countUpper++;
			}
			if (x <= 'z' && x >= 'a') {
				countLowser++;
			}
			if (x <= '9' && x >= '0') {
				countNumber++;
			}
		}
		System.out.println("Tổng chữ cái viết hoa = " + countUpper);
		System.out.println("Tổng chữ cái  viết thường = " + countLowser);
		System.out.println("Tổng chữ Số = " + countNumber);
	}

	@Test
	public void TC_02() {
		char namePageArr[] = namePage.toCharArray();

	}
}
