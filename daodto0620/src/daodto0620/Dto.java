package daodto0620;

public class Dto {

	private int num;
	private String str;
	
	public Dto(int num, String str) {
		super();
		this.num = num;
		this.str = str;
	}

	public int getNum() {
		return num;
	}

	public void setNum(int num) {
		this.num = num;
	}

	public String getStr() {
		return str;
	}

	public void setStr(String str) {
		this.str = str;
	}

	@Override
	public String toString() {
		return "Dto [num=" + num + ", str=" + str + "]";
	}
	
	
}
