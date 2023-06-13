package sec02.exam01;

public class Annonymous {
	//필드
	Person field = new Person() {

		void work() {
			System.out.println("출근");
		}

		@Override
		void wake() {
			System.out.println("6시 기상");
			work();
		}
		
	};
	
	void method1() {
		// 지역변수
		Person localVar = new Person() {

			void work() {
				System.out.println("출근");
			}

			@Override
			void wake() {
				System.out.println("6시 기상");
				work();
			}
			
		};
		localVar.wake();
	}
	
	void method2(Person person) {
		person.wake();
	}
}
