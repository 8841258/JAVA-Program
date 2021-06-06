package model;

public class Friend {
	private String name; //이름
	private int birth; //생일
	private String tel; //폰번호
	
	public Friend () {}
	
	public Friend (String name, int birth, String tel) {
		this.name = name;
		this.birth = birth;
		this.tel = tel;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getBirth() {
		return birth;
	}

	public void setBirth(int birth) {
		this.birth = birth;
	}

	public String getTel() {
		return tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}

	@Override
	public String toString() {
		return name + "," + birth + "," + tel;
	}
	
	
	
	
}
