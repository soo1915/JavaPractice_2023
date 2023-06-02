package sec05;

public class Aaa {
	int a1 ; //필드
	static int a2; //정적 필드
	
	void println() {
		System.out.println(a1);
		System.out.println(a2);
	}
	
	static void sprintln() {
		Aaa xx = new Aaa() ;
		System.out.println(xx.a1);
		System.out.println(a2);
	}
}
