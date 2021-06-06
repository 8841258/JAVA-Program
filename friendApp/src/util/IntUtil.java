package util;

import java.util.Scanner;

public class IntUtil {
	public static int inputInt() {
		int num2 = 0;
		while (true) {
			try {

				Scanner sc = new Scanner(System.in);
				String num = sc.next();
				num2 = Integer.parseInt(num);
				
				break;

			} catch (Exception e) {
				System.out.println("문자를 입력했습니다. 숫자를 입력하세요.");
			}
		}
		return num2;
	}
}
