package javaOOP;

//final class không cho phép class khác kế thừa nhưng cho new lên để dùng
public final class Topic_05_Non_Access_Modifier {
	// Static: Variable/Method
	// Dùng cho tất cả các Instance/object
	// Phạm vi toàn bộ system sử dụng nó
	// Có thể override (ghi đè) nó
	// Ngoài class thì truy cập trực tiếp từ tên class ko ko cần new
	static String browserName = "chrome";

	// Non-Static
	String severName = "Testing";

	// final không cho phép gán lại /override (ghi đè)
	final String colorCar = "red";

	// hàm Non-Static
	public void clickElement(String elementName) {
		System.out.println(elementName);

	}

	// hàm Static
	public static void sendKeyToElement(String elementName) {
		System.out.println(elementName);
	}

	// Final
	// Không cho phép ghi đè ở class khác mặc dù đang kế thừa class này
	public final void setcarName() {

	}

	public static void main(String[] args) {
		// Truy cập biến Static
		System.out.println(browserName);
		browserName = "firefox";

		// Truy cập biến Non Static
		Topic_05_Non_Access_Modifier topic = new Topic_05_Non_Access_Modifier();
		System.out.println(topic.severName);

		// Truy cập hàm Static trực tiếp được
		sendKeyToElement("link");

		// Truy cập hàm Non-Static thông qua object
		topic.clickElement("link");
	}
}
