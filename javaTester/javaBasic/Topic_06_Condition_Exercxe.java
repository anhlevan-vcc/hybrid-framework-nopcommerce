package javaBasic;

import java.util.Scanner;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

public class Topic_06_Condition_Exercxe {
	WebDriver driver;
	String projectPath = System.getProperty("user.dir");
	Scanner scanner = new Scanner(System.in);
	
	//@Test
	public void TC_01() {
		int number = scanner.nextInt();
		if (number % 2 == 0) {
			System.out.println("Ô " + number + " là số chẵn");
		} else {
			System.out.println("Ngược lại " + number + " là số lẻ");
		}
	}
	
	//@Test
	public void TC_02() {
		int numberA = scanner.nextInt();
		int numberB = scanner.nextInt();
		if (numberA >= numberB) {
			System.out.println(numberA + " lớn hơn hoặc bằng " + numberB);
		} else {
			System.out.println(numberA + " nhỏ hơn " + numberB);
		}
	}
	
	//@Test
	public void TC_03() {
		String NameA = scanner.nextLine();
		String NameB = scanner.nextLine();
		if (NameA.equals(NameB)) {
			System.out.println("Giống nhau");
		} else {
			System.out.println("Khác nhau");
		}
	}
	
	//@Test
	public void TC_04() {
		int number1 = scanner.nextInt();
		int number2 = scanner.nextInt();
		int number3 = scanner.nextInt();
		if (number1 > number2 && number1 > number3) {
			System.out.println("Number 1 lớn nhất");
		} else if (number2 > number1 && number2 > number3) {
			System.out.println("Number 2 lớn nhất");
		} else {
			System.out.println("Number 3 lớn nhất");
		}
	}

	//@Test
	public void TC_05() {
		int numberAA = scanner.nextInt();
		if (10 < numberAA && numberAA < 100) {
			System.out.println(numberAA + " trong khoảng 10-100");
		} else {
			System.out.println(numberAA + " ngoài khoảng 10-100");
		}
	}
	
	//@Test
	public void TC_06() {
		float numberA = scanner.nextFloat();
		
		if (0 < numberA && numberA < 5) {
			System.out.println(numberA + " Điểm D");
		} else if (5 <= numberA && numberA < 7.5) {
			System.out.println(numberA + " Điểm C");
		} else if (7.5 <= numberA && numberA < 8.5) {
			System.out.println(numberA + " Điểm B");
		} else if (8.5 <= numberA && numberA < 10){
			System.out.println(numberA + " Điểm A");
		} else {
			System.out.println(numberA + " Nhập sai");
		}
	}
	
	@Test
	public void TC_07() {
		int month = scanner.nextInt();
		if (month == 1 || month == 3 || month == 5 || month == 6 || month == 8 || month == 10 || month == 12) {
			System.out.println(month + " 31 ngày");
		} else if (month == 4 || month == 7 || month == 9 || month == 11){
			System.out.println(month + " 30 ngày");
		} else if (month == 2){
			System.out.println(month + " 28 ngày");
		} else {
			System.out.println(month + " Nhập sai");
		}
	}
}





















