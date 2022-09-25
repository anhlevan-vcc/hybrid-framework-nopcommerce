package javaBasic;

import java.util.Scanner;

import org.testng.annotations.Test;

public class Topic_09_While_Do_While {
	static Scanner scanner = new Scanner(System.in);

	// @Test
	// VÒng lặp for dùng cho các mảng xác nhận được giá trị dừng từ A => B
	public static void TC_01_For() {
		int number = scanner.nextInt();
		for (int i = number; i < 100; i++) {
			if (i % 2 == 0) {
				System.out.println(i);
			}
		}
	}

	// @Test
	// While dùng cho trường hợp ko biết điểm dừng của 1 mảng
	// VD:gán x bằng 1 điều kiện x # 0 thì chạy câu lệnh trong while => nhập tới khi nào x=0 thì dừng lại, còn nhập x#0 thì tiếp tục chạy
	public static void TC_02_While() {
		int x = 1;
		while (x != 0) {
			System.out.println("nhap 0 dừng lại, nhập 1 tiếp tục ");
			x = scanner.nextInt();

		}
	}

	// @Test
	// vòng lặp vô tận muốn thoát ra thì thêm điều kiện cho nó để break
	public static void TC_03_While() {
		int i = 0;
		while (true) {
			System.out.println(i);
			i++;
			if (i == 100) {
				break;
			}
		}
	}

	@Test
	public static void TC_01_BT1() {
		int i = scanner.nextInt();
		while (i <= 100) {
			if (i % 2 == 0) {
				System.out.println(i);
			}
			i++;
		}
	}
}
