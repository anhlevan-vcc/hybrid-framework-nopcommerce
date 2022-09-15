package javaBasic;

public class Topic_01_Variable {
	//hàm khởi tạo cùng tên với class ko có kiểu trả về
	public Topic_01_Variable() {
		
	}
	
	static int studentNumber;
	static boolean status;
	static final String BROSER_NAME = "Chrome"; //hằng số BROSER_NAME
	static int studentPrice;
	
	String studentName = "Selemium";
	
	public static void main(String[] args) {
		int studentPrice = 5;
		//ko in đc vì biến local ko có giá trị mặc định/ muốn dùng thì phải khởi tạo giá trị
		System.out.println(studentPrice);
		System.out.println(studentNumber);
		System.out.println(status);
		//không thể sử dụng biến studentName ở ngoài để in trong static
		//nên cần khởi tạo 1 biến khác
		
		Topic_01_Variable topic = new Topic_01_Variable();
		
		System.out.println(topic.studentName);
		
	}
	// Getter - trả về dữ liệu getText/getCurentUrl/getTitle/getAttribute....
	public String getStudentName() {
		return this.studentName;
	}
	
	//Setter- action click/sendkey/clear/select/back/forward...
	public void setStudentName(String stdName) {
		this.studentName = stdName;
	}
}
//boolean/byte/char/double/float/short/int/long : kiểu dữ liệu nguyên thuỷ
//void : kiểu dữ liệu của hàm - hàm ko cần trả về
//while/for/do - vòng lặp
//switch/ if/ else - biểu thức điều kiện
//break - dùng để thoát khỏi vòng lặp
//continue : bỏ qua 1 testcase
//try/catch / finally: đùng để sử lý ngoại lệ
//extends : kế thừa 1 class
//final : biến đc gán final thì không được gán lại
//import : import thư viện
//instanceof : kiểm tra cái biến đó có phải kiểu dữ liệu này ko
//return :trả về ko dùng cho void
//static: biến tĩnh