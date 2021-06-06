package co.memo.view;

import java.util.ArrayList;
import java.util.Scanner;

import co.memo.access.MemoList2;
import co.memo.model.Memo2;
import co.memo.util.ScannerUtil2;

public class MemoCliApp2 {
	//MemoList 객체를 생성. 그래야 여기 함수들을 쓸 수 있다.
	MemoList2 memoList2 = new MemoList2();
	Memo2 memos = new Memo2();
	
	
	//메뉴 목록 선택창 띄우는 함수
	public void menu() {
		System.out.println("============================메모 관리 프로그램============================");
		System.out.println("1.메모등록 2. 메모수정 3. 메모삭제 4. 메모전체조회 5. 날짜로조회 6. 메모로조회 0. 종료");
		System.out.println("=====================================================================");
	}
	
	public void appMainStart() {
		
		int menuNum;
		//메뉴 목록 선택창 띄우기
		menu();
		
		
		do {
			//메뉴 번호 입력하기 (이게 저 위로 올라가 있으면 안되는듯)
			menuNum = ScannerUtil2.insertInt();
			
			
			switch (menuNum) {
			
			case 1: insert(); break; //등록
			case 2: update(); break; //수정
			case 3: delete(); break; //삭제
			case 4: selectAll(); break; //전체조회
			case 5: selectDate(); break; //날짜조회
			case 6: selectContent(); break; //내용조회
			}
			

		} while (menuNum != 0);
		
		
		
	}
	
	
	public void insert() {
		Memo2 memos = new Memo2();
		memos = ScannerUtil2.memoInsert();
		memoList2.insert(memos);
	}
	
	//그냥 list 출력하면 [[추가된메모사항객체1],[추가된메모사항객체2],[추가된메모사항객체3]] 이렇게 나옴.
	//for문을 돌려야 각각 하나의 메모사항 객체가 다음줄에 출력됨.
	public void selectAll() {
		ArrayList<Memo2> list = memoList2.selectAll();
		for (Memo2 m : list) {
			System.out.println(m);
		}
		
	}
	

	public void update() {
		//아예 새 객체를 만들어서 MemoList2에 있는 update 함수를 씀. 날짜를 비교하기 위해서.
		Memo2 memo = new Memo2();
		System.out.println("수정하고싶은 날짜를 목록에서 입력하세요.");
		memo.setDate(ScannerUtil2.str());
		System.out.println("변경하고 싶은 내용을 입력하세요.");
		memo.setContent(ScannerUtil2.str());
		memoList2.update(memo);
		System.out.println("변경이 완료되었습니다.");
		
		
	}
	
	public void delete() {
		System.out.println("삭제할 날짜를 정확히 입력하세요. ex) 20190304");
		String date = ScannerUtil2.str();
		
		memoList2.delete(date);
		System.out.println("삭제가 완료되었습니다.");
	}
	
	public void selectDate() {
		System.out.println("검색할 날짜를 정확히 입력하세요. ex) 20190304");
		String date = ScannerUtil2.str();
		
		memoList2.selectDate(date);
		
	}
	
	public void selectContent() {
		System.out.println("검색할 내용 일부를 입력하세요.");
		String content = ScannerUtil2.str();
		memoList2.selectContent(content);
	}
	
	
}
