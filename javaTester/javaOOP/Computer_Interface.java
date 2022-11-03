package javaOOP;

public interface Computer_Interface {
	// Nêu ko gán từ khoá abstract thì Interface tự hiểu là hàn abstract
	public void showComputerInfo();

	// trong Interface chỉ đc chứa Abstract method (không đc chứ method thường)
	public abstract void showCpu();
}
