package student;

import java.time.LocalDateTime;

public class Student {
	Long sid;
	String phone;
	String passwd;
	String name;
	LocalDateTime registerDateTime;
	
	public Student(String phone, String passwd, String name, LocalDateTime registerDateTime) {
		this.phone = phone;
		this.passwd = passwd;
		this.name = name;
		this.registerDateTime = registerDateTime;
	}

	public Long getSid() {
		return sid;
	}

	public void setSid(Long sid) {
		this.sid = sid;
	}

	public String getPhone() {
		return phone;
	}

	public String getPasswd() {
		return passwd;
	}

	public String getName() {
		return name;
	}

	public LocalDateTime getRegisterDateTime() {
		return registerDateTime;
	}

	//암호 변경 기능 구현
	public void changePassword(String oldPassword, String newPassword) {
		if (!passwd.equals(oldPassword)) 
			throw new WrongIdPasswordException();
		this.passwd = newPassword;	

	}
	
}
