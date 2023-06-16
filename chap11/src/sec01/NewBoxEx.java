package sec01;

public class NewBoxEx {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		NewBox<String> newBox = new NewBox<String>();
		newBox.set("홍길동");
		String name = newBox.get();
		System.out.println(name);
		
		NewBox<Apple> newBox2 = new NewBox<Apple>();
		newBox2.set(new Apple());
		Apple apple = newBox2.get();
		System.out.println(apple);

		NewBox<Integer> a3 = new NewBox<>(); // <> 안에 생략 가능
		a3.set(100);
		int res = a3.get();
		System.out.println(res);
		
	}

}
