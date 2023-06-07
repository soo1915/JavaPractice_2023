package jsp0607;

public class Person {

	private String name;
	private String address;
	private String phone;
	private String email;
	private int birthday; //19880607
	
	
	@Override
	public String toString() {
		return "Person [name=" + name + ", address=" + address + ", phone=" + phone + ", email=" + email + ", birthday="
				+ birthday + "]";
	}
	public Person() {}
	public Person(String name, String address, String phone, String email, int birthday) {
		super();
		this.name = name;
		this.address = address;
		this.phone = phone;
		this.email = email;
		this.birthday = birthday;
	}
	
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public int getBirthday() {
		return birthday;
	}
	public void setBirthday(int birthday) {
		this.birthday = birthday;
	}
	
	
	
	
}
