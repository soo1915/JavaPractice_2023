package sec01;

public class Ex01 {

	public static void main(String[] args) {

		Object obj1 = new Object();
		Object obj2 = new Object();
		
		boolean result = obj1.equals(obj2);
		System.out.println(result);
		
		result = (obj1 == obj2);
		System.out.println(result);
		
	}

}
