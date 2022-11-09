package javaOOP.overriding;

public class HocSinh extends ConNguoi {
	@Override
	// hàm này ở class cha và class con cũng có thì giá trị ở
	// Class con sẽ đc ghi đè vào class con khi chạy ở class Testing
	// Không bắt buộc ghi là @Override ở trên nhưng ghi vào để biết là nó đang đc ghi đè giá trị
	public void suatAn() {
		System.out.println("10k");
	}
}
