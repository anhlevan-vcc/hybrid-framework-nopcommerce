package javaOOP;

public class Topic_09_Constructor {
	public long shortTimeout = 10;
	protected long longTimeout = 20;

	// Constructor- hàm khởi tạo có tên trùng với tên class
	protected Topic_09_Constructor() {
		System.out.println("Constructor của class cha 1");

	}

	protected Topic_09_Constructor(String name) {
		System.out.println("Constructor của class cha 2");

	}

	protected Topic_09_Constructor(int number) {
		System.out.println("Constructor của class cha 3");

	}
}
