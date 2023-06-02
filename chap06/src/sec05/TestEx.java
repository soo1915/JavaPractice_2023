package sec05;

public class TestEx {

	int x;
	static int y = 200; // 지역 변수
	
	void printX() {
		System.out.println(x);
	}
	
	
	public static void main(String[] args) {
		TestEx te = new TestEx();
		te.x = 100;
		te.printX();		
		printY();
	}
	
	public static void printY() {
		
		System.out.println(y);
	}

}
