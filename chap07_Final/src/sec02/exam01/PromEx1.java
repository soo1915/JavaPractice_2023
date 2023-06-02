package sec02.exam01;

class A{}

class B extends A{}
class D extends B{}

class C extends A{}
class E extends C{}

public class PromEx1 {
	public static void main(String[] args) {

		B x1 = new D();
		
		
//		B b = new B();
//		C c = new C();
//		D d = new D();
//		E e = new E();
//		
//		A a1 = b;
//		A a2 = c;
//		A a3 = d;
//		A a4 = e;
		

	}

}
