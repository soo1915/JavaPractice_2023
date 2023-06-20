package daodto0620.fin;

public class Dto {

	private int id;
	private String name;
	private String addr;
	private String phone;
	
	public Dto(int id, String name, String addr, String phone) {
		super();
		this.id = id;
		this.name = name;
		this.addr = addr;
		this.phone = phone;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddr() {
		return addr;
	}

	public void setAddr(String addr) {
		this.addr = addr;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	@Override
	public String toString() {
		return "Dto [id=" + id + ", name=" + name + ", addr=" + addr + ", phone=" + phone + "]";
	}
	
	
}
