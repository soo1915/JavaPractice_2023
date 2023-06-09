package sec01.exam03;

public class MyClassExample {

	public static void main(String[] args) {
		System.out.println("1)------------"); // 필드 다형성

		MyClass myClass1 = new MyClass();
		myClass1.rc.turnOn();
		myClass1.rc.setVolume(5);
		
		System.out.println("2)------------"); // 매개변수 다형성
		
		MyClass myClass2 = new MyClass(new Audio());
		
		System.out.println("3)------------");//메소드 안에 로컬 변수
		
		MyClass myClass3 = new MyClass();
		myClass3.methodA();
		
		System.out.println("4)------------"); // 일반 메소드에서
		
		MyClass myClass4 = new MyClass();
		myClass4.methodB(new Television());
	}

}
