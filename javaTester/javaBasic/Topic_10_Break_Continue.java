package javaBasic;

public class Topic_10_Break_Continue {
	public static void main(String[] args) {
		for (int i = 0; i < 10; i++) {
			// Continue dùng để skip qua thằng số 5 không chạy
			if (i == 5) {
				continue;
			}
			System.out.println(i);
		}

		// for lồng nhau: mỗi lần chạy của for trên sẽ apply cho tất cả các lần chạy của for dưới
		// Continue dùng để skip qua thằng số 8 không chạy
		for (int i = 0; i < 5; i++) {
			System.out.println("lần chạy của i " + i);
			for (int j = 0; j < 10; j++) {
				if (j == 8) {
					continue;
				}
				System.out.println("j = " + j);
			}
		}

		// dừng khi in > 10 dùng điều kiện if mà break
		int out, in = 0;
		for (out = 0; out < 10; out++) {

			for (in = 0; in < 20; in++) {
				if (in > 10) {
					break;
				}
				System.out.println("bên trong vòng lặp out: out = " + out + ", in = " + in);
			}
			System.out.println("bên ngoài vòng lặp out: out = " + out + ", in = " + in);
		}
	}

}
