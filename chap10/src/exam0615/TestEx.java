package exam0615;

public class TestEx {

	public static void main(String[] args) {

		Test test = new Test();
		try {
			test.setX(-100);
		} catch (TestException e) {
			// TODO Auto-generated catch block
			//e.printStackTrace();
			System.out.println(e.getMessage());
		}
	}

}
