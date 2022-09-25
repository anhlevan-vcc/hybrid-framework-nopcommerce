package javaBasic;

import java.util.Scanner;

import org.testng.annotations.Test;

public class Topic_11_Bt_Array {

	Scanner scanner = new Scanner(System.in);

	int number[] = { 5, 4, 5, 9, 3, 2, 8, 55, 100, 41, 50, 23 };

	@Test
	public void TC_01_BT1() {
		int x = 0;
		for (int j = 0; j < number.length; j++) {
			if (x < number[j]) {
				x = number[j];
			}
		}
		System.out.println(x);
	}
}
