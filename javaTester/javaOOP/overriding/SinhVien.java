package javaOOP.overriding;

public class SinhVien extends ConNguoi {
	@Override
	// hàm này ở class cha và class con cũng có thì giá trị ở
	// Class con sẽ đc ghi đè vào class con khi chạy ở class Testing
	// Không bắt buộc ghi là @Override ở trên nhưng ghi vào để biết là nó đang đc ghi đè giá trị
	// TH bắt buộc phải @Override khi nó kế thừa 1 abstract class
	public void suatAn() {
		System.out.println("30k");
	}
}
