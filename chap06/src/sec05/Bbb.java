package sec05;

public class Bbb {

	String x ;
	String y;
	String z;
	
	@Override
	public String toString() {
		return "Bbb [x=" + x + ", y=" + y + ", z=" + z + "]";
	}
	
	void method() {
		System.out.println(this.toString());
	}

	Bbb() {}
	
	public Bbb(String x, String y, String z) {
		super();
		this.x = x;
		this.y = y;
		this.z = z;
	}

	public static void main(String[] args) {
		Bbb bb = new Bbb("홍", "010", "서대문");
		Bbb bb1 = new Bbb("서대문", "홍", "010");
		
		
		bb.method();
		System.out.println(bb1);
		
		
	}

}
