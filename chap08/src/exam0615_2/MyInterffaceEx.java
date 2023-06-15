package exam0615_2;

public class MyInterffaceEx {

	public static void main(String[] args) {
		
		MyInterface2 my3 = new MyInterface2() {
			
			@Override
			public int method(int x, int y) {
				return x + y;
			}
		};
		
		int res = my3.method(10, 20);
		System.out.println(res);
		
		MyInterface2 my2 = (a, b) -> {
			System.out.println(a + b);
			return a+b;
		};
		
		my2.method(20, 30);
		
		MyInterface2 my6 = (a, b) -> {return a + b;};
		res = my6.method(100, 200);
		System.out.println(res);
		
		
		my2 = (t, v) -> t+v;
		res = my2.method(5, 10);
		System.out.println(res);
		
		
		
		
		
		
		
		
		MyInterface my = new MyInterface() {
			
			@Override
			public void method() {
				System.out.println("my");
				
			}
		};
		my.method();
		//람다식 
		my = () -> {System.out.println("my1");};
		my.method();
		
		my = () -> System.out.println("my2");
		my.method();
	}

}
