package co.memo.model;

public class Memo2 {
	private String date;
	private String content;
	
	public Memo2 () {}
	
	public Memo2 (String date, String content) {
		this.date = date;
		this.content = content;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	@Override
	public String toString() {
		return "메모 저장 목록 [" + date + ", " + content + "]";
	}
	
	
	
	
	
}
