package sec01;

interface MyInterface {
	String method(String str);
}

public class MyInterfaceEx {

	public static void main(String[] args) {
		MyInterface mi = new MyInterface() {
			
			@Override
			public String method(String str) {
				return str+100;
				
			}

		};
		
		System.out.println(mi.method("hi"));
		String str = mi.method("hello!!");
		System.out.println(str);
		
		//람다식
		MyInterface mi1 = (aa) -> {return aa+100;};
		System.out.println(mi1.method("hellooooo"));
		
		
//		// 람다식
//		MyInterface mi1 = () -> {System.out.println("method");};
//		// 람다식 실행
//		mi.method();
		
	}

}
