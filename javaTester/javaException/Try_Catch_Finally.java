package javaException;

import java.io.FileReader;
import java.io.IOException;

public class Try_Catch_Finally {
	// finally
	// Luôn được thực thi cho dù có ngoại lệ xảy ra hay không
	// Được sử dụng để chèn lệnh "clean-up" vào chương trình như việc: đóng file/ đóng các kết nối (DB)/ quit browser/ clean data test/..
	// Trường hợp mở một file để đọc và ghi dữ liệu vào file - sau khi mọi thao tác với file hoàn tất thì phải đóng kết nối để trả file lại cho các chương trình
	// khác sử dụng - việc đóng kết nối file phải được thực thi mặc dù có xảy ra exception trong quá trình thao tác với file hay không
	// Đối với mỗi khối try - có thể có không hoặc nhiều khối catch - nhưng chỉ có một khối finally
	public static void main(String[] args) {
		FileReader fileReader = null;
		try {
			fileReader = new FileReader("C:\\anh.jpg");
		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			try {
				if (fileReader != null) {
					fileReader.close();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
}
