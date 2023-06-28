package test;

class ClassA {
	ClassA(){
		System.out.println('A');
		this.prn();		
	}

	void prn() {
		System.out.println('B');
	}
}

class ClassB extends ClassA {
	ClassB() {
		super();
		System.out.println('D');
	}
	
	void prn() {
		System.out.println('E');
	}
	
	void prn(int x) {
		System.out.println(x);
	}
}


public class Practice {

	public static void main(String[] args) {
		
		int x = 7;
		ClassB cal = new ClassB();
		cal.prn(x);
	
	}
}
