package sec02.exam04;

class Tire {
	
}

class Atire extends Tire {
	
}

public class Car {

	Tire t1 ; // 부모 클래스
	
	Car() {
		//Tire t2 = new Tire();
		Atire t2 = new Atire();
		method(t2); 
	}
	
	void method(Tire tire) {
		t1 = tire;
		//	t1 = new Atire() ; // 필드의 다형성, 자식 클래스
	}
}
