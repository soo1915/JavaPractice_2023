package sec030615;

public interface MyInterface {

	void method1();
	default void method2() {// 10년 후에 추가
		System.out.println("method2");
	}
}
