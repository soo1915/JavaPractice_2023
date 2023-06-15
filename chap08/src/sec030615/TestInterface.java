package sec030615;

public interface TestInterface {

	void method1();
	
	default void method2() { //default 메소드는 body가 있음, 구현의 강제성이 없음
		System.out.println("method2");
	}
}
