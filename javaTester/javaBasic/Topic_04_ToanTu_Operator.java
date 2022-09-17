package javaBasic;

import java.util.Iterator;

import org.testng.annotations.Test;

public class Topic_04_ToanTu_Operator {

	public static void main(String[] args) {

		int number = 10;
		number += 5;
		System.out.println(number);

		// Chia hết
		System.out.println(number / 5);

		// Chia Lấy số dư
		System.out.println(number % 7);

		System.out.println(number++);
		// in number = 15 ra trước
		// sau mới +1 vào giá trị =16

		System.out.println(++number);
		// +1 vào giá trị = 17
		// rồi mới in giá trị ra

		System.out.println(number--);
		// in ra 17
		// rồi mới -1 = 16

		System.out.println(number);
		// in ra 16

		// Chú ý trong 1 biểu thức VD :50 - a++ + --b + 9
		// Ưu tiên ử lý --b trước => xong đến +-*/ => xong mới đến a++
		// a= 10 , b=10
		// a++ = 11 , --b = 9 / KQ = 50-10+9+9=58

		// in ra trước xong mới tăng dần
		for (int i = 0; i <= 10; i++) {
			System.out.println(i);
		}

		// tăng trước xong mới in ra
		for (int i = 0; i <= 10; ++i) {
			System.out.println(i);
		}

		String address = "hà nội";
		// nếu add BẰNG hà nội thì in ra
		if (address == "hà nội") {
			System.out.println("Đúng rồi");
		}
		// nếu add KHÁC hà nội thì in ra
		if (address != "hà nội") {
			System.out.println("Đúng rồi");
		}
		// nếu add không bằng hà nội thì in ra
		if (!(address == "hà nội")) {
			System.out.println("Đúng rồi");
		}
		// nếu bằng thì nhẩy vào true / không bằng thì nhảy vào false
		// tam nguyên = ? :
		boolean status = (address == "HCM") ? true : false;
		System.out.println(status);

	}

	@Test
	public void TC_01_BaiTap() {
		int a = 10;
		int b = 20;
		a = a + b;
		b = a - b;
		a = a - b;
		System.out.println("a = " + a);
		System.out.println("b = " + b);
	}

	@Test
	public void TC_02_BaiTap() {
		String P1 = "Tuấn";
		int P2 = 23;
		int P3 = P2 + 15;
		System.out.println("After 15, age of " + P1 + " will be " + P3);
	}

	@Test
	public void TC_03_BaiTap() {
		int a = 5;
		int b = 4;
		if (a > b) {
			System.out.println("true");
		}
		if (a < b) {
			System.out.println(false);
		}
	}
}
