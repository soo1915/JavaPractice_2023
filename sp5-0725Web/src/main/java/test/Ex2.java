package test;

class Test {
	void print() {
		System.out.println("테스트");
	}
}

public class Ex2 {

	public static void main(String[] args) throws ClassNotFoundException, InstantiationException, IllegalAccessException {

		Class<?> hc = Class.forName("test.Test");
		Test hi = (Test) hc.newInstance();
		hi.print();
	}

}
