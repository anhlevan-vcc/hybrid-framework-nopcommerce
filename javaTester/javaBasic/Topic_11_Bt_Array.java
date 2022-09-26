package javaBasic;

import java.util.Scanner;

import org.testng.annotations.Test;

public class Topic_11_Bt_Array {

	Scanner scanner = new Scanner(System.in);

	// @Test
	public void TC_01_BT() { // sắp sếp theo thứ tự tăng dần trong mảng
		int number[] = { 5, 4, 5, 9, 3, 2, 8, 55, 100, 41, 50, 23 };
		int x = 0;
		for (int j = 0; j < number.length; j++) {
			if (x < number[j]) {
				x = number[j];
			}
		}
		System.out.println(x);
	}

	// @Test
	public void TC_02_BT() { // tính tổng số đầu cuối trong mảng
		int arr[] = { 5, 4, 5, 9, 3, 2, 8, 55 };
		int x = 0;
		x = arr[0] + arr[arr.length - 1];
		System.out.println(x);
	}

	// @Test
	public void TC_03_BT() { // in ra các số chẵn trong mảng
		int numberA[] = { 5, 4, 5, 9, 3, 2, 8, 55, 100, 41, 50, 23 };
		for (int i = 0; i < numberA.length; i++) {
			if (numberA[i] % 2 == 0) {
				System.out.print(numberA[i] + " ");
			}
		}
	}

	// @Test
	public void TC_04_BT() { // Tính tổng số lẻ nguyên dương trong mảng
		int numberA[] = { 3, 4, 7, 9, -3, 2, 8, -55, 100, -41, 50, 1 };
		int x = 0;

		for (int i = 0; i < numberA.length; i++) {
			if (numberA[i] % 2 == 1 && numberA[i] > 0) {
				x += numberA[i];
				System.out.println(x);

			}
		}
	}

	// @Test
	public void TC_05_BT() {
		int numberA[] = { 3, 4, 7, 19, -3, 2, 18, -55, 100, -41, 50, 1 };
		for (int i = 0; i < numberA.length; i++) {
			if (numberA[i] >= 0 && numberA[i] <= 10) {
				System.out.println(numberA[i]);
			}
		}
	}

	@Test
	public void TC_06_BT() {
		int x = 0;
		int numberA[] = { 3, 4, 7, 19, -3, 2, 18, -55, 100, -41, 50, 1 };
		for (int i = 0; i < numberA.length; i++) {
			x = x + numberA[i];
		}
		System.out.println(x);
		float tungBinh = x / numberA.length;
		System.out.println(tungBinh);
	}

}
