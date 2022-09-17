package javaBasic;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Topic_02_Data_Type {
	static int number;

	String address = "HCM";
	
	public static void main(String[] args) {
		// Biến local
		int stdNumber = 0;

		System.out.println(number);

		System.out.println(stdNumber);

		Topic_02_Data_Type topic = new Topic_02_Data_Type();
		System.out.println(topic.address);
		
		Scanner scanner = new Scanner(System.in);
		String name = scanner.nextLine();
		System.out.println(name);
		System.out.println(name);
		System.out.print(name);
		System.out.print(name);

	}

	// Primitive type - Kiểu nguyên thuỷ
	byte bNumber = 10;

	short sNumber = 1000;

	int iNumber = 50000;

	long lNumber = 50000;

	float fNumber = 50000.5f;

	double dNumber = 5.6d;

	char cNumber = '1';

	boolean status = true;

	// Reference type - Kiểu tham chiếu

	// String
	String addressN = "HCM";

	// Array
	Integer[] studentNumber = { 10, 20, 50 };
	String[] studentaddress = { "Hà nội", "Hồ chí minh", "Việt Nam" };

	// Class
	Topic_02_Data_Type pic;

	// Interface
	WebDriver driver;

	// Object
	Object nameObject;

	// Collection: List/Set/Queue/Map
	List<WebElement> homePageLinks = driver.findElements(By.className("a"));
	Set<String> allWindows = driver.getWindowHandles();

	List<String> productName = new ArrayList<String>();

	
	

	public void clickToElement() {
		address.trim();
		addressN.toUpperCase();
		studentNumber.clone();
		studentaddress.clone();
		pic.toString();
		driver.close();
		nameObject.hashCode();
		homePageLinks.clear();
		allWindows.clear();
		productName.size();
	}

	

}
