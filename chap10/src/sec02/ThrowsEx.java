package sec02;

public class ThrowsEx {

	
	public static void findClass() throws ClassNotFoundException {
		Class.forName("asdf.asdf.asdf");
	}
	public static void main(String[] args) throws ClassNotFoundException {
		findClass();
		System.out.println("여기");
	}

}
