package co.memo.util;

import java.util.InputMismatchException;
import java.util.Scanner;

import co.memo.model.Memo2;

public class ScannerUtil2 {
	
	static Scanner scanner = new Scanner(System.in);
	
	
	//메모 사항 입력받는 유틸
	public static Memo2 memoInsert() {
		System.out.println("날짜를 입력하세요.");
		String date = scanner.next();
		System.out.println("메모를 입력하세요.");
		String Content = scanner.next();
		System.out.println("입력이 완료되었습니다.");
		Memo2 memo = new Memo2(date, Content);
		return memo;
	}
	
	
	//숫자 입력받는 유틸
	public static int insertInt() {
		int menunum = 0;
		
		while (true) {
		
		try {
			System.out.print("메뉴 번호를 입력해주세요.");
			menunum = scanner.nextInt();
			
			break;
		} catch (InputMismatchException e) {
			System.out.println("숫자 형식으로 입력하세요.");
		}
	}
		//여기다 리턴문 써야되는거 아닌가?
		return menunum;
	}
	
	
	//문자열 입력받는 유틸
	public static String str() {
		String stri = scanner.next();
		return stri;
	}
	
	
}
