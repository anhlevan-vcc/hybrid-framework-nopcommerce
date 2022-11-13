package javaException;

public class Try_Catch_Exception {
	public static void main(String[] args) {

		try {
			// code có thể ném ra ngoại lệ
		} catch (Exception e) {
			// code xử lý ngoại lệ
		}

		try {
			// code có thể ném ra ngoại lệ
		} finally {
			// code trong khối này luôn được thực thi
		}

		try {
			// code có thể ném ra ngoại lệ
		} catch (Exception e) {
			// throw ra exception - stop test case
			throw (e);
		}

		// **** Sử dụng try/ catch
		try {
			int data = 50 / 0;
			System.out.println(data);
		} catch (ArithmeticException e) {
			System.out.println(e);
		}
		System.out.println("Next step");

		// **** Multiple catch
		try {
			int array[] = new int[10];
			array[10] = 30 / 1;
		} catch (ArithmeticException | ArrayIndexOutOfBoundsException e) {
			System.out.println(e.getMessage());
		}

		// **** Multiple catch
		try {
			int a[] = new int[5];
			a[5] = 30 / 0;
		} catch (ArithmeticException e) {
			System.out.println("Step 01 finish");
		} catch (ArrayIndexOutOfBoundsException e) {
			System.out.println("Step 02 finish");
		} catch (Exception e) {
			System.out.println("Step 03 finish");
		}
		System.out.println("Next step");
	}
}
