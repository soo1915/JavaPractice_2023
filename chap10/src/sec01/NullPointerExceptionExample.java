package sec01;

public class NullPointerExceptionExample {

	public static void main(String[] args) {
		
		String data = null;
		if (data != null) {
			System.out.println(data.toString());			
		} else {
			System.out.println("null");
		}


	}

}
