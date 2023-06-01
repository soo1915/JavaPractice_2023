package sec01;

public class ExtendTestMain {

	public static void main(String[] args) {
		
//		ExtendTestChild etc = new ExtendTestChild("홍길동", 2, "당근", 2000, 3000);
//		
		ExtendTestChild etc = new ExtendTestChild("홍길멍", 2);
		etc.object = "당근";
		etc.x = 2000;
		etc.y = 3000;
		
		
		ExtendTest et = new ExtendTest(2, "홍길순");
		et.name("홍길순");
		etc.name("당근");
		etc.carrotMarket();
		System.out.println(etc.carrotTot());
		

	}

}
