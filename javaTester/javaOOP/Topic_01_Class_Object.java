package javaOOP;

public class Topic_01_Class_Object {
	int numberID;
	String name;
	float diemLyThuyet;
	float diemThucHanh;

	protected Topic_01_Class_Object(int numberID, String name, float diemLyThuyet, float diemThucHanh) {
		super();
		this.numberID = numberID;
		this.name = name;
		this.diemLyThuyet = diemLyThuyet;
		this.diemThucHanh = diemThucHanh;
	}

	protected void showInfoStudent() {

		System.out.println("Tên HS = " + name);
		System.out.println("ID HS = " + numberID);
		System.out.println("Điểm lý thuyết = " + diemLyThuyet);
		System.out.println("Điểm thực hành = " + diemThucHanh);
		float diemTrungBinh = (diemLyThuyet + diemThucHanh * 2) / 3;
		System.out.println("Điểm Trung bình = " + diemTrungBinh);

	}

	public static void main(String[] args) {
		Topic_01_Class_Object hocSinh = new Topic_01_Class_Object(652365, "Lê văn Anh", 8.5f, 8f);
		hocSinh.showInfoStudent();
	}

}
