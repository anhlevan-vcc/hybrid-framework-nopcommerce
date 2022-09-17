package javaBasic;

public class Topic_05_EpKieu_Casting {
	//public static void main(String[] args) {

		// Kiểu ngầm định /không mất dữ liệu ép từ bé lên lớn
//		byte bNumber = 15;
//		System.out.println(bNumber);
//		
//		short sNumber = bNumber;
//		System.out.println(sNumber);
//		
//		int iNumber = sNumber;
//		System.out.println(iNumber);
//		
//		long lNumber = iNumber;
//		System.out.println(lNumber);
//		
//		float fNumber = lNumber;
//		System.out.println(fNumber);
//		
//		double dNumber= fNumber;
//		System.out.println(dNumber);

		// Kiểu tường minh
		//double dNumber = 65646464324414123d;

		//float fNumber = (float) dNumber;
		//System.out.println(fNumber);
	//}
	
	public String stdName;
	
	public String getstdName() {
		return stdName;
	}
	
	public void setstdName(String stdName) {
		this.stdName = stdName;
	}
	
	public void showStdName() {
		System.out.println("Student Name = " + stdName);
	}
	
	public static void main(String[] args) {
		Topic_05_EpKieu_Casting st1Student = new Topic_05_EpKieu_Casting();
		
		Topic_05_EpKieu_Casting st2Student = new Topic_05_EpKieu_Casting();
		
		st1Student.setstdName("Lê A");
		st2Student.setstdName("Lê B");
		
		st1Student.showStdName();
		st2Student.showStdName();
		
		//Ép kiểu
		st1Student = st2Student;
		
		st1Student.showStdName();
		st2Student.showStdName();
		
		st2Student.setstdName("Lê C");
		
		st1Student.showStdName();
		st2Student.showStdName();
		
		
	}
}
