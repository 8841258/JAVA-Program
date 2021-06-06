package access;

import java.util.ArrayList;

import model.Friend;

public interface FriendAccess {
	public void insert(Friend friend);
	
	public void update(Friend friend);
	
	public void delete(String name);
	
	public void selectAll();
	
	public Friend selectName(Friend friend);
	
	public Friend selectBirth(Friend friend);
	
}
