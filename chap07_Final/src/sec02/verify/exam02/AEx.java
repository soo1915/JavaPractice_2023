package sec02.verify.exam02;

public class AEx {

	public static void method(B b) {}
	public static void main(String[] args) {

		B b = (B) new A();
		method((B) new A());

	}

}
