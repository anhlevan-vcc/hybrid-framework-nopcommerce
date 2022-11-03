package javaOOP;

public abstract class Computer_Abstract {
	public void showComputerInfo() {
		System.out.println("Ram");
	}

	// Abstract class thì mới tạo đc hàm abstract method
	// khung để cho các class con kế thừa phải override(ghi đè) lại (imlement-thực hiện) lại
	public abstract void showCpu();
}
