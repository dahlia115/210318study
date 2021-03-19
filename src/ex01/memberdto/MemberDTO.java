package ex01.memberdto;

public class MemberDTO {
	private String id;
	private String pw;
	private String name;
	private int gender;
	private String age;
	private int hobby;
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getPw() {
		return pw;
	}
	public void setPw(String pw) {
		this.pw = pw;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getGender() {
		return gender;
	}
	public void setGender(int gender) {
		this.gender = gender;
	}
	public String getAge() {
		return age;
	}
	public void setAge(String age) {
		this.age = age;
	}
	public int getHobby() {
		return hobby;
	}
	public void setHobby(int hobby) {
		this.hobby = hobby;
	}
}
