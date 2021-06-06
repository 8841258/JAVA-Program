package co.memo.access;

import java.util.ArrayList;

import co.memo.model.Memo2;

public interface MemoAccess2 {
	
	
	//매개변수를 어떻게 주는지가 관건.
	
	public void insert(Memo2 memo);
	
	public void update(Memo2 memo);
	
	public void delete(String date);
	
	public ArrayList<Memo2> selectAll();
	
	public void selectDate(String date);
	
	public void selectContent(String Content);
	
	
	
}
