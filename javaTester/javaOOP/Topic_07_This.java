package javaOOP;

public class Topic_07_This {
	// This truy cập tới biến/hàm trong cùng 1 class
	private int firstNumber;
	private int secondNumber;

	public Topic_07_This(int firstNumber, int secondNumber) {
		this.firstNumber = firstNumber;
		this.secondNumber = secondNumber;
	}

	public void sumNumber() {
		System.out.println(firstNumber + secondNumber);
	}

	public void showNumber() {
		this.sumNumber();
		sumNumber();
	}

	public static void main(String[] args) {
		Topic_07_This topic = new Topic_07_This(5, 10);
		topic.sumNumber();
	}

}
