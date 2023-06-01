package sec01;

public class ExtendTest {
	
	int num;
	String name;
	
	ExtendTest(int num, String name) {
		this.num = num;
		this.name = name;
	}
	
	int i (int num) {
		System.out.println("부모 객체의 i() 실행" );
		return num;
	}
	
	String name (String name) {
		System.out.println("부모 객체의 name() 실행 " + name );
		return name;
	}
	
	
}
