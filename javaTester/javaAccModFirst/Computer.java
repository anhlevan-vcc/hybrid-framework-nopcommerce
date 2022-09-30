package javaAccModFirst;

public class Computer {
	private String name; // không công khai-màu đỏ
	String color; // mặc định - màu xanh da trời
	protected int eyeNumber; // màu vàng
	public float weight; // màu xanh lá cây

	// Property(thuộc tính)
	private int ramSize;

	String ramName;

	protected String cpuProductName;

	public int vgaSize;

	// Method(Phương thức)
	private void setRamSize(int ramSize) { // ramSize- biến cục bộ
		// đặt cùng tên thì dùng this để lấy ra biến toàn cục
		// không dùng this thì viết tên khác nhau đi
		this.ramSize = ramSize;
	}

	void setRamProductName(String ramName) {
		this.ramName = ramName;
	}

	protected void setCpuProducName(String cpuProduct) {
		cpuProductName = cpuProduct;
	}

	public void setVgaSize(int vgaSize) {
		this.vgaSize = vgaSize;
	}

	public static void main(String[] args) {
		Computer comp = new Computer();

		// Property(thuộc tính)
		comp.ramSize = 5;
		System.out.println(comp.ramSize);

		// Method(Phương thức)
		comp.setRamSize(6);
		System.out.println(comp.ramSize);
	}
}
