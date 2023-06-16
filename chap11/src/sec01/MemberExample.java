package sec01;

public class MemberExample {

	public static void main(String[] args) {
		
		String str1 = new String("test");
		String str2 = new String("test");
		
		System.out.println(str1.hashCode());
		System.out.println(str2.hashCode());
		
		if(str1 == str2) {
			System.out.println("같다");
		} else {
			System.out.println("다르다");
		}
		
		Member obj1 = new Member("blue");
		Member obj2 = new Member("blue");
		Member obj3 = new Member("red");

		System.out.println(obj1.hashCode());
		System.out.println(obj2.hashCode());
		System.out.println(obj3.hashCode());
		
		if(obj1.equals(obj2)) {
			System.out.println("같음");
		} else {
			System.out.println("다름");
		}
		
		if(obj1.equals(obj3)) {
			System.out.println("같음");
		} else {
			System.out.println("다름");
		}
	}

}
