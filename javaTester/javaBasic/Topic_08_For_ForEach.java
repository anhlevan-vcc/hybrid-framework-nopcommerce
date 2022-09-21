package javaBasic;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class Topic_08_For_ForEach {
	WebDriver driver;
	Scanner scanner = new Scanner(System.in);

	// @Test
	public void TC_01_For() {

		for (int i = 0; i < 10; i++) {
			System.out.println(i);
		}
		System.out.println("==============");

		for (int i = 1; i <= 5; i++) {
			System.out.println(i);
		}
	}

	// @Test
	public void TC_02_For_chaynguocmang() {

		for (int i = 10; i > 0; i--) {
			System.out.println(i);
		}
		System.out.println("==============");

	}

	// @Test
	public void TC_03_For() {
//		List<WebElement> allLInk = driver.findElements(By.cssSelector(""));
//		allLInk.size();
		// mảng dạng array/list/set/queue (index) phải bắt đầu từ i=0

		String[] addressName = { "ha noi", "ho chi minh", "hai phong", "bac giang" };

		for (int i = 0; i < addressName.length; i++) {
			if (addressName[i].equals("ha noi")) {
				// action
				System.out.println("tìm thấy " + addressName[i]);
				break;
			}
		}
	}
	// chú ý nếu ko dùng break thì nó sẽ chạy cho hết các phần tử trong mảng
	// dù đã tìm thấy phần tử cần tìm ngược lại thì tìm thấy sẽ thoát khỏi vòng lặp

	// @Test
	// vòng lặp qua hết all giá trị
	public void TC_04_ForEach() {

		String[] cityName = { "ha noi", "ho chi minh", "hai phong", "bac giang" };

		// Java Collection
		// Class: ArrayList/LinkedList/Vector
		// Interface: List/Set/Queue

		List<String> cityAddress = new ArrayList<String>();
		System.out.println(cityAddress.size());
		// Add lúc coding
		cityAddress.add("ha nam");
		cityAddress.add("ha giang");
		cityAddress.add("long an");
		System.out.println(cityAddress.size());
		// vừa chạy vừa add
		for (String city : cityName) {
			cityAddress.add(city);
		}
		System.out.println(cityAddress.size());

		for (String addCity : cityAddress) {
			System.out.println(addCity);
		}
	}

	// @Test
	public void TC_05_BT1() {
		int number = scanner.nextInt();
		for (int i = 0; i <= number; i++) {
			System.out.print((i + " "));
		}
	}

	// @Test
	public void TC_06_BT2() {
		int numberA = scanner.nextInt();
		int numberB = scanner.nextInt();
		for (int i = numberA; i <= numberB; i++) {
			System.out.print((i + " "));
		}
	}

	// @Test
	public void TC_07_BT3() {
		int sum = 0;
		int numberA = scanner.nextInt();
		for (int i = 1; i <= numberA; i++) {
			if (i % 2 == 0) {
				sum += i;
			}
		}
		System.out.println(sum);
	}

	// @Test
	public void TC_08_BT4() {
		int sum = 0;
		int numberA = scanner.nextInt();
		int numberB = scanner.nextInt();
		for (int i = numberA; i <= numberB; i++) {
			sum += i;
		}
		System.out.println(sum);
	}

	// @Test
	public void TC_09_BT5() {
		int sum = 0;
		int numberA = scanner.nextInt();
		for (int i = 0; i <= numberA; i++) {
			if (i % 2 == 1) {
				sum += i;
			}
		}
		System.out.println(sum);
	}

	// @Test
	public void TC_10_BT6() {
		int numberA = scanner.nextInt();
		int numberB = scanner.nextInt();
		for (int i = numberA; i <= numberB; i++) {
			if (i % 3 == 0) {
				System.out.print(i + " ");
			}
		}
	}

	@Test
	public void TC_11_BT7() {
		int sum = 1;
		int numberA = scanner.nextInt();
		for (int i = 1; i <= numberA; i++) {
			sum *= i;
		}
		System.out.println(sum);
	}
}
