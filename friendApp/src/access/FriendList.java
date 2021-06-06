package access;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

import model.Friend;

public class FriendList implements FriendAccess {
	//여기에 add, remove, set한다.
	//Friend 객체가 여기에 담긴다.
	ArrayList<Friend> friends = new ArrayList<Friend>();
	String path = "c:/hey/friend.txt";
	
	//FriendList 기본생성자. FriendList가 생성될 때, 메모장에 입력된 것들을 불러온다.
	public FriendList() {
		open();
	}
	
	
	public void save() {
		//리스트 객체를 메모장에 출력.
		try {
			//bw = sysoutprint , br = scanner
			BufferedWriter bw = new BufferedWriter(new FileWriter(path));
			//friends 리스트에 있는 입력된 객체들을 하나하나 for문으로 읽어들여서 메모장에 출력.
			for (Friend f : friends) {
				bw.write(String.format("%s,%s,%s\n", f.getName(), f.getBirth(), f.getTel()));
				//toString 형식,밑에 open 형식, 여기 형식 싹 다 일치해야함...
			}
			bw.close();
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void open() {
		try {
			Scanner sc = new Scanner(new File(path));
			
			while (true) {
			//path에 있는 한줄을 입력받는다. br에는 매개변수로 File을 받을 수 없다. scanner만 가능
			//nextLine을 쓰면 문제가 생긴다.......
			String hanjul = sc.next();
			
			//다음 줄이 없으면 while문을 그만둔다.
			if (hanjul == null) break;
			//한줄을 ", " 단위로 잘라서 배열에 넣는다.
			String[] array = hanjul.split(",");
			//그걸 다시 객체에 담는다.
			//객체를 리스트에 추가한다. 따로 쓸 수도 있지만 이렇게 같이 쓸 수도 있다.
			friends.add(new Friend(array[0], Integer.parseInt(array[1]), array[2]));
			
			}
			sc.close();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	
	
	
	
	
	
	@Override
	public void insert(Friend friend) {
		friends.add(friend);
		save();

	}

	@Override
	public void update(Friend friend) {
		for (Friend f : friends) {
			if (f.getName().equals(friend.getName())) {
				f.setBirth(friend.getBirth());
				f.setTel(friend.getTel());
				break;
			}
		}
		save();
		
		
	}

	@Override
	public void delete(String name) {
		for (Friend f : friends) {
			if (f.getName().equals(name)) {
				friends.remove(f);
				break;
			}
		}
		
	}

	@Override
	public void selectAll() {
		// TODO Auto-generated method stub
		for (Friend f : friends) {
			System.out.println(f);
		}
		
	}

	@Override
	public Friend selectName(Friend friend) {
		for (Friend f : friends) {
			if (friend.getName().equals(f.getName())) {
				System.out.println(f);
			}
		}
		return null;
	}

	@Override
	public Friend selectBirth(Friend friend) {
		for (Friend f : friends) {
			if (friend.getBirth() == f.getBirth()) {
				System.out.println(f);
			}
		}
		return null;
	}
	
	
	
	
	
}
