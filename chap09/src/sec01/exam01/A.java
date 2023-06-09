package sec01.exam01;

public class A {

	String method() {
		class D{
			D() {
				System.out.println("D()");
			}
			String methodDD() {
				return "D";
			}
		}
		
		D d1 = new D();
		return d1.methodDD();
	}
	
	
	static class C{
		int field1;
		static int field2;
		void method1() {}
		static void method2() {};
		
		C() {
			System.out.println("C()");
		}
	}
	
	
	
	A() {
		System.out.println("A()");
	}
	
	
	
	class B{
		
		int field1;
		//static int field2;
		void method1() {}
//		static void method2() {};
		B() {
			System.out.println("B()");
		}
	}
}
