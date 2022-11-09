package javaOOP.overriding;

public interface Topic_02_Computer_Interface {
	// Nêu ko gán từ khoá abstract thì Interface tự hiểu là hàm abstract
	public void showComputerInfo();

	// trong Interface chỉ đc chứa Abstract method (không đc chứ method thường)
	public abstract void showCpu();
}
