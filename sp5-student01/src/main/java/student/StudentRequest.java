package student;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class StudentRequest {

	private String phone;
	private String passwd;
	private String confirmPasswd;
	private String name;
	
//	public String getPhone() {
//		return phone;
//	}
//	public void setPhone(String phone) {
//		this.phone = phone;
//	}
//	public String getPasswd() {
//		return passwd;
//	}
//	public void setPasswd(String passwd) {
//		this.passwd = passwd;
//	}
//	public String getConfirmPasswd() {
//		return confirmPasswd;
//	}
//	public void setConfirmPasswd(String confirmPasswd) {
//		this.confirmPasswd = confirmPasswd;
//	}
//	public String getName() {
//		return name;
//	}
//	public void setName(String name) {
//		this.name = name;
//	}
	
	public boolean isPasswordEqualToConfirmPassword() {
		return passwd.equals(confirmPasswd);
	}
}
