package javaException;

import java.io.File;
import java.io.IOException;

public class Throw {
	// Throw - sử dụng để khai báo một ngoại lệ cụ thể bên trong phương thức - có thể định nghĩa lại thông báo (message) của ngoại lệ
	// Ngoại lệ được khai báo bởi throw sẽ được ném cho ngoại lệ được khai báo với throws của phương thức
	public static void main(String[] args) throws IOException {
		findFile();
	}

	public static void findFile() throws IOException {
		String fileName = "anh.jpg";
		File newFile = new File(fileName);
		if (newFile.exists() && !newFile.isDirectory()) {
			// Action something
		} else {
			throw new IOException("This file not found: " + fileName);
		}
	}
}
