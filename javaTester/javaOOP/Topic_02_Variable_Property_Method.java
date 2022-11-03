package javaOOP;

public class Topic_02_Variable_Property_Method {

	// Access Modifier : private
	// Data Type: String
	// Variable Name : StudentName
	// Variable Value: AutomationFC
	private String StudentName = "AutomationFC"; // Biến toàn cục (Global Variable-khởi tạo và dùng trong 1 class)

	// Static variable - có thể gán lại giá trị
	// Dùng trong 1 hàm Static - gọi trực tiếp không thông qua đối tượng
	// Ra ngoài class khác thì có thể gọi trực tiếp bằng tên Class ko cần NEW
	public static String studentAdd = "HCM";
	// Dùng trong phạm vi class hiện tại
	private static String studentPhone = "0123456";

	// Final variable- không cho gán lại dữ liệu (override) dùng để cố định dữ liệu
	// Hàm static muốn gọi dùng thì phải thông qua Object New lên để dùng
	final String country = "Việt Nam";

	// Static Final variable = hằng số
	// không đc ghi đè
	// có thể truy cập rông rãi cho tất cả các instance/thread
	static final float PI_NUMBER = 3.14f;

	// Access Modifier : default
	int studentID = 1002;

	// Phạm vi Hàm - Static (method)
	public static void main(String[] args) {
		// Local variable - biến cục bộ (Trong hàm)
		String StudentName = "AutomationFC";
		if (StudentName.startsWith("Auto")) {
			// Local variable - biến cục bộ (Trong Block code)
			int number = 100;
		}
		// Static variable - có thể gán lại giá trị
		studentAdd = "Hà Nội";
		studentPhone = "00000";
	}

	// Constructor
	public Topic_02_Variable_Property_Method() {
		// Local variable - biến cục bộ (Trong hàm khởi tạo - Constructor)

		if (this.StudentName.startsWith("Auto")) {
			// Local variable - biến cục bộ (Trong Block code)
			int number = 100;
		}
	}

	// Phạm vi Hàm - non Static (method)
	public void display() {
		// Local variable - biến cục bộ (hàm)
		String StudentName = "AutomationFC";

	}
}
