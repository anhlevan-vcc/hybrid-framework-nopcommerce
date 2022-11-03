package javaOOP;

public class Topic_04_Overloading {
	// hàm trồng hàm- nhiều hàm nhưng cùng tên
	// Chỉ cần truyền kiểu dữ liệu và số lượng dữ liệu phù hợp thì sẽ lấy ra hàm đúng tương ứng
	static int plusMethod(int x, int y) {
		return x + y;
	}

	static double plusMethod(double x, double y) {
		return x + y;
	}

	public static void main(String[] args) {

		plusMethod(5, 10);
		plusMethod(5.5, 5.3);
	}

}
