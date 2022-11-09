package javaOOP.overloading;

public class Topic_11_OverLoading {
	// OverLoading nạp chồng - phạm vi trong 1 class giống bài Topic 04
	// hàm trồng hàm- nhiều hàm nhưng cùng tên
	// Chỉ cần truyền kiểu dữ liệu và số lượng dữ liệu phù hợp thì sẽ lấy ra hàm đúng tương ứng
	private int firstNumber;
	private int secondNumber;

	// hàm chồng hàm cũng đc dùng để gọi constructor vì cũng có thể có nhiều constructor cùng tên nhưng khác tham số
	public Topic_11_OverLoading() {

	}

	public Topic_11_OverLoading(String namePage) {

	}

	public Topic_11_OverLoading(int numberPage) {

	}

	// Hàm chồng hàm với method
	public void sumNumber() {
		System.out.println(this.firstNumber + this.secondNumber);
	}

	public void sumNumber(int firstNumber, int secondNumber) {
		System.out.println(firstNumber + secondNumber);
	}

	public void sumNumber(double firstNumber, double secondNumber) {
		System.out.println(firstNumber + secondNumber);
	}

	public void sumNumber(float firstNumber, int secondNumber) {
		System.out.println(firstNumber + secondNumber);
	}

	public static void main(String[] args) {
		Topic_11_OverLoading topic = new Topic_11_OverLoading();
		topic.sumNumber();
		topic.sumNumber(5, 10);
		topic.sumNumber(2.5, 10.5);
		topic.sumNumber(5.5, 10);
	}

}
