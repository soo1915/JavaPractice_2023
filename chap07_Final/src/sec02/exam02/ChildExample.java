package sec02.exam02;

public class ChildExample {

	public static void main(String[] args) {
		Child child = new Child(); // 자동 형변환
		
		Parent parent = child;
		
		parent.method1();
		parent.method2();

		Child ch = (Child) parent; // 강제 형변환
		ch.method3();
	}

}
