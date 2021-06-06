package view;

import access.FriendList;
import model.Friend;
import util.IntUtil;
import util.StringUtil;

public class FriendApp {
	//여기서는 사용자의 입력된 값을 비교하기 위함.
	//여기 입력된 값과, FriendList를 비교함.
	
	//FriendList에서 재정의된 함수를 쓰기 위한 생성자.
	//생성과 동시에 FriendList 기본생성자 안의 open() 함수 때문에 메모장에 저장된 객체가 불러와진다.
	FriendList friendList = new FriendList();
	
	public void print() {
		System.out.println("친구 목록. 이름, 생일, 핸드폰번호");
		System.out.println("1.입력 2.수정 3.삭제 4.전체조회 5.이름으로조회 6.생일로조회 0.끝");
		System.out.println("----------------------------------------------------");
	}
	
	
	
	public void start() {
		int selectNum;
		
		print();
		
		do {
			System.out.println("메뉴 번호를 입력하세요.");
			selectNum = IntUtil.inputInt();
			
			switch (selectNum) {
			case 1: insert(); break;
			case 2: update(); break;
			case 3: delete(); break;
			case 4: friendList.selectAll(); break;
			case 5: selectName(); break;
			case 6: selectBirth(); break;
			}
		
		} while (selectNum != 0);
		System.out.println("<친구 목록> 앱을 종료합니다.");
	}
	
	//입력된 값을 받기 위한 함수.
	
	public void insert() {
		System.out.println("여기서는 친구의 인적사항을 입력합니다.");
		System.out.println("이름을 입력하세요.");
		String name = StringUtil.inputStr();
		System.out.println("생일을 입력하세요.");
		int birth = IntUtil.inputInt();
		System.out.println("핸드폰 번호를 입력하세요.");
		String tel = StringUtil.inputStr();
		Friend friend = new Friend(name, birth, tel);
		friendList.insert(friend);
		System.out.println("입력이 완료되었습니다.");
	}
	
	public void update() {
		System.out.println("여기서는 친구의 생일과 핸드폰번호를 수정할 수 있습니다.");
		System.out.println("수정할 친구의 이름을 입력하세요.");
		String name = StringUtil.inputStr();
		System.out.println("새로 수정할 생일을 입력하세요.");
		int birth = IntUtil.inputInt();
		System.out.println("새로 수정할 핸드폰번호를 입력하세요.");
		String tel = StringUtil.inputStr();
		friendList.update(new Friend(name, birth, tel));
		System.out.println("수정되었습니다.");
	}
	
	public void delete() {
		System.out.println("삭제할 친구 이름을 입력하세요.");
		String name = StringUtil.inputStr();
		friendList.delete(name);
		System.out.println("삭제되었습니다.");
	}
	
	public void selectName() {
		System.out.println("검색할 친구 이름을 입력하세요.");
		String name = StringUtil.inputStr();
		System.out.println("친구 이름으로 검색한 결과>");
		friendList.selectName(new Friend(name, 0, null));
		
	}
	
	public void selectBirth() {
		System.out.println("검색할 친구 생일을 입력하세요.");
		int birth = IntUtil.inputInt();
		System.out.println("친구 생일으로 검색한 결과>");
		friendList.selectBirth(new Friend(null, birth, null));
	}
	
	
	
	
	
	
}
