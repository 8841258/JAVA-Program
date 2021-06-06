package co.memo.access;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

import co.memo.model.Memo2;
import co.memo.util.ScannerUtil2;

public class MemoList2 implements MemoAccess2 {
	ArrayList<Memo2> memos2 = new ArrayList<Memo2>();
	
	
	
	//프로그램이 실행될 때, 이전에 메모장에 저장했던 데이터들 불러오기
	public void open () throws FileNotFoundException {
		//Scanner(System.in)이면 사용자가 입력하는 거지만 지금은
		//Scanner(new File(~))이므로 파일에 있는걸 입력함
		Scanner sc = new Scanner(new File("c:/hey/memo2.txt"));
		
		while (true) { // 한 줄씩 읽는거라 while로 반복한다.
			//한 줄씩 불러들여서 배열에 담고, 그걸 다시 객체로 만든다.
			//그리고 그 객체를 다시 리스트에 넣는다.
			String str = sc.next();
			if (str == null) break; //다음 내용이 없으면 반복을 그만한다.
			String[] arr = str.split(" ");
			memos2.add(new Memo2(arr[0], arr[1]));
			//원칙대로라면 객체를 생성해서 변수 지정해야하지만 한 번밖에 안쓰여서 이렇게 쓴듯.
			
			
		}
		
		
		
		
		
		
	}
	
	
	//입력값을 메모장에 저장
	public void SaveIntoTxt () throws IOException {
		BufferedWriter bw = new BufferedWriter(new FileWriter("d:/hey/memo2.txt"));
		for (Memo2 m : memos2) {
			bw.write(String.format("/s /s", m.getDate(), m.getContent()));
		}
		bw.close();
	}
	
	
	@Override
	public void insert(Memo2 memo) {
		memos2.add(memo);
		
	}

	@Override
	public void update(Memo2 memo) {
		for (Memo2 m : memos2) {
			if (m.getDate().equals(memo.getDate())) {
				m.setContent(memo.getContent());
				
			break;
			}
			
		}
		
	}

	@Override
	public void delete(String date) {
		for (Memo2 m : memos2) {
			if (m.getDate().equals(date)) {
				memos2.remove(m);
				break; //break를 걸지 않으면 삭제하고 또 삭제하려고 한다. 한 가지 항목만 삭제해야하므로...
			}
			}
		
	}

	@Override
	public ArrayList<Memo2> selectAll() {
		return memos2;
	}

	@Override
	public void selectDate(String date) {

		for (Memo2 m : memos2) {
			if (m.getDate().equals(date)) {
				System.out.println(m);
			}
		}
		
	}

	@Override
	public void selectContent(String Content) {
		for (Memo2 m : memos2) {
			if (m.getContent().contains(Content)) {
				System.out.println(m);
			}
		}
		
	}	
	
	
	
	
}
