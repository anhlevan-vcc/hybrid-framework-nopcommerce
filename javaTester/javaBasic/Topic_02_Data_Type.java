package javaBasic;

public class Topic_02_Data_Type {
	static int number;
	
	String address = "HCM";
	
	//Primitive type - Kiểu nguyên thuỷ
	byte bNumber;
	
	short sNumber;
	
	int iNumber;
	
	long lNumber;
	
	float fNumber;
	
	double dNumber;
	
	char cNumber;
	
	boolean status;
	
	//Reference type - Kiểu tham chiếu
	
	public static void main(String[] args) {
		//Biến local
		int stdNumber = 0;
		
		System.out.println(number);
		
		System.out.println(stdNumber);
		
		Topic_02_Data_Type topic = new Topic_02_Data_Type();
		System.out.println(topic.address);
		
	}

}
