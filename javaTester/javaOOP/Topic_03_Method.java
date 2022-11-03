package javaOOP;

public class Topic_03_Method {

	// Non- Static
	void showcarName() {
		System.out.println("Toyota");
	}

	// Static
	static void showcarColor() {
		System.out.println("Toyota");
	}

	public static void main(String[] args) {
		// Hàm static gọi vào trong 1 hàm static khác được
		showcarColor();

		// muốn gọi hàm non-static thì phải gọi qua instance/ Object
		Topic_03_Method object = new Topic_03_Method();
		object.showcarName();

		// trong class thì gọi
		showcarColor();

		// Ngoài class thì goi như này Tênclass.tên hàm
		Topic_03_Method.showcarColor();
	}

}
