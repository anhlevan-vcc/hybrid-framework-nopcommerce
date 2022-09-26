package javaBasic;

import org.testng.annotations.Test;

public class Topic_12_String {
	// string là tập hợp chuỗi ký tự
	public static void main(String[] args) {
		// Khai báo theo kiểu nguyên thuỷ
		String a = "cat";
		String b = a;
		String c = b;

		// Khai báo theo kiểu Đối tượng cũng giống như nguyên thuỷ
		String d = new String("cat");

		System.out.println(a == b);
		System.out.println(b == c); // gán biến mới d cùng tên với c thì System.out.println(c == d); // false vì là 2 biến khác nhau
		System.out.println(c.equals(d));// true vì đang so sánh equals (bằng nhau)

	}

	@Test
	public void TC_01() {

		String addName = "Automation Fc";
		String addCity = "Hà nội";
		// Độ dài của chuỗi
		int doDai = addName.length();
		System.out.println(doDai);
		System.out.println("Độ dài chuỗi ký tự = " + addName.length());
		System.out.println("In ra 1 ký tự theo index = " + addName.charAt(1));
		System.out.println("Nỗi chuỗi = " + addName.concat(addCity));
		System.out.println("Nỗi chuỗi = " + addName + addCity);

		// Tuyệt đối
		System.out.println("Kiểm tra 2 chuỗi bằng nhau TUYỆT đối = " + addName.equals(addCity));
		System.out.println("Kiểm tra 2 chuỗi bằng nhau TUYỆT đối = " + addName.equals("Automation Fc"));

		// Tương đối
		System.out.println("Kiểm tra 2 chuỗi bằng nhau TƯƠNG đối k phân biết hoa thường = " + addName.equalsIgnoreCase("AUTOMATION FC"));

		// startsWith/ endsWith/ contains
		System.out.println("Có bắt đầu bằng = " + addName.startsWith("Au"));
		System.out.println("Có kết thúc bằng = " + addName.endsWith("Fc"));
		System.out.println("Có Chứa nội dung = " + addName.contains("on "));

		// VỊ trí kí tự ,chuỗi ký tự
		System.out.println("Vị trí của = " + addName.indexOf("to"));
		System.out.println("Vị trí của = " + addName.indexOf("A"));
		System.out.println("Vị trí của = " + addName.indexOf("ti"));

		System.out.println("Tách 1 ký tự/1 chuỗi trong chuỗi = " + addName.substring(2));
		System.out.println("Tách 1 ký tự/1 chuỗi trong chuỗi = " + addName.substring(2, 5));

		// Split : tách chuỗi thành 1 mảng dựa vào ký tự , chuối ký tự
		// Dùng trong Alert
		String chuoiTen = "Lê văn Anh//16/01/1990";
		// tách từ chỗ có //
		String chuoiTens[] = chuoiTen.split("//");
		System.out.println(chuoiTens[0]); // chuỗi 1 là Lê văn anh có index=0
		System.out.println(chuoiTens[1]); // chuỗi 1 là 16/01/1990 có index=1

		// Replace: thay thế kí tự, chuỗi => kí tự, chuỗi khác
		String giaTien = "$1601";
		giaTien = giaTien.replace("$", "");
		System.out.println(giaTien);

		// convert qua kiểu số thực để tính toán(sắp xếp) đc vì sau khi convert nó vẫn là chuỗi
		float giaTienF = Float.parseFloat(giaTien);
		System.out.println(giaTienF);

		// convert ngược lại số qua chuỗi
		String.valueOf(giaTienF);

		// Cắt hết khoảng trắng /xuống dòng /tab trung trim()
		String helloWord = "    \n   \t    Hello anh bạn   \n     ";
		System.out.println(helloWord);
		System.out.println(helloWord.trim());

		// Phương thức isEmpty() khi chuỗi trống trả về true, có kí tự trả về false.
		String helloWord1 = "  ";
		String helloWord2 = "111";
		System.out.println(helloWord1.isEmpty());
		System.out.println(helloWord2.isEmpty());

		// chuỗi toàn bộ là khoảng trắng thì trả ra true/ có ký tự khác khoảng trắng thì false
		System.out.println(helloWord1.isBlank());
		System.out.println(helloWord2.isBlank());

		// Dynamic locator
		// Đại điện cho 1 chuỗi %s
		// %b %t %d
		String dynamicButtonXpath = "//button[@id='%s']";
		System.out.println("Click Login " + dynamicButtonXpath.format(dynamicButtonXpath, "login"));
		System.out.println("Click Search " + dynamicButtonXpath.format(dynamicButtonXpath, "search"));
		System.out.println("Click Register " + dynamicButtonXpath.format(dynamicButtonXpath, "register"));
		// Click Login //button[@id='login']
		// Click Search //button[@id='search']
		// Click Register //button[@id='register']
	}
}
