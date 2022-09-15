package javaBasic;

import org.testng.annotations.Test;

public class Topic_02_Exercxe {
	@Test
	public void TC_01() {
		int a = 6;
		int b = 3;
		
		System.out.println("Tổng = " + (a + b));
		System.out.println("Hiệu = " + (a - b));
		System.out.println("Tích = " + (a * b));
		System.out.println("Thương = " + (a / b));
	}
	
	@Test
	public void TC_02() {
		float a = 6.6f;
		float b = 8.5f;
		
		System.out.println("Diện tích = " + (a * b));
		
	}
	
	@Test
	public void TC_03() {
		String name = "Automation FC";
		
		System.out.println("Hello " + name);
		
	}
}
