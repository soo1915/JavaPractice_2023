package sec02.exam01;

public class A {

	Parent field = new Parent() {
		int childField;
		void childMethod() {}
		
		void method2(Parent parent) {
			
		}
		
		@Override
		void parentMethod() {}
		
	};
	void method() {
		Parent localVar = new Parent() {
			int childField;
			void childMethod() {}
			
			@Override
			void parentMethod() {}
			
		};
	}
}
