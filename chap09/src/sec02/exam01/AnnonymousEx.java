package sec02.exam01;

public class AnnonymousEx {

	public static void main(String[] args) {
		
		Annonymous anony = new Annonymous();
		
//		anony.field.wake();
//		
//		anony.method1();
		
		anony.method2(new Person() {

		void work() {
			System.out.println("출근");
		}

		@Override
		void wake() {
			System.out.println("6시 기상");
			work();
		}
		
	});
		
	}

}
