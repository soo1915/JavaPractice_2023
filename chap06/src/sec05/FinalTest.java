package sec05;

public class FinalTest {

	static final int z = 23;
	final int x ;
	final String ssn;
	
	
	
	public FinalTest(int x, String ssn) {
		super();
		this.x = x;
		this.ssn = ssn;
	}



	public static void main(String[] args) {
		// TODO Auto-generated method stub
		FinalTest ft = new FinalTest(10, "홍");
//		ft.x = 40;
//		System.out.println(ft.ssn);
		final int y ;
//		y = 400;
//		y = 700;
		System.out.println(FinalTest.z);
		
	}

}
