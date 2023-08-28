package spring;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class User {

	// 회원 등록 DTO 
	private int id;
	private String name;
	private String passwd;
	
	public User(String name, String passwd) {
		this.name = name;
		this.passwd = passwd; 
	}
	
	public void changePassword(String oldPassword, String newPassword) {
		if (!passwd.equals(oldPassword))
			throw new WrongIdPasswordException();
		this.passwd = newPassword;
	}

	public boolean matchPassword(String password) {
		return this.passwd.equals(password);
	}
}
