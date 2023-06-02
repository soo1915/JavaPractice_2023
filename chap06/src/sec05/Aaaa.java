package sec05;

public class Aaaa {

	private static Aaaa a1 = new Aaaa();
	private Aaaa() {}
	
	static Aaaa mmm() {
		return a1;
	}
	
	void test() {
		System.out.println(a1);
	}
}
