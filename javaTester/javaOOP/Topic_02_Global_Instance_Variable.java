package javaOOP;

public class Topic_02_Global_Instance_Variable {
	public static void main(String[] args) {
		Topic_02_Variable_Property_Method student = new Topic_02_Variable_Property_Method();

		// Biến Instance Variable- là biến khởi tạo ở class bên Topic_02_Variable_Property_Method
		// nhưng được dùng ở class bên này. Muốn dùng thì phải new lên với có thể dùng
		student.studentID = 111;

		System.out.println(Topic_02_Variable_Property_Method.studentAdd);
		Topic_02_Variable_Property_Method.studentAdd = "HN";
	}
}
