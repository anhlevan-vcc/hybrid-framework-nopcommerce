package javaBasic;

import java.util.ArrayList;

public class Topic_11_Array {

	public static void main(String[] args) {

		int number[] = { 10, 12, 14, 16, 18, 20 };

		// đc khai báo cố định bao nhiêu phần tử
		String student[] = { "anh", "long", "tùng" };

		// lấy ra phần tử
		System.out.println(number[2]);
		System.out.println(number[3]);
		System.out.println(student[1]);
		System.out.println(student[0]);

		for (int i = 0; i < student.length; i++) {
			if (student[i].equals("Long")) {
				System.out.println("Click vào Long");
			}
		}

		for (String name : student) {
			if (name.equals("long")) {
				System.out.println("Click vào Long");
			}
		}

		// muốn trong quá trình chạy mới thêm phần tử vào mảng thì dùng
		ArrayList<String> nameStd = new ArrayList<String>();

		// khi chay code mới add
		for (String std : nameStd) {
			nameStd.add(std);
		}
	}

}
