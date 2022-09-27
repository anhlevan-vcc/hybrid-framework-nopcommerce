package javaAccModFirst;

public class Computer {
	private String name; // không công khai-màu đỏ
	String color; // mặc định - màu xanh da trời
	protected int eyeNumber; // màu vàng
	public float weight; // màu xanh lá cây

	// THUỘC TÍNH - Property

	private int ramSize;// biến toàn cục

	// PHƯƠNG THỨC - Method
	private void setRamSize(int ramSize) { // ramSize- biến cục bộ
		// đặt cùng tên thì dùng this để lấy ra biến toàn cục
		// không dùng this thì viết tên khác nhau đi
		this.ramSize = ramSize;
	}

	public static void main(String[] args) {
		Computer comp = new Computer();
		comp.ramSize = 5;

		System.out.println(comp.ramSize);

		comp.setRamSize(6);
		System.out.println(comp.ramSize);
	}
}
