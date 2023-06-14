package sec02;

public class TryEx {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		try {
			Class.forName("java.lang.String2");
		} catch (ClassNotFoundException e) {
			System.out.println(e.getMessage() );
			
		}
	}

}
