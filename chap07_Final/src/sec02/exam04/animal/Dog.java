package sec02.exam04.animal;

public class Dog extends Animal{

	@Override
	void eat() {
		System.out.println("강아지가 먹는다.");
	}


	void walk() {
		System.out.println("강아지가 산책한다.");
	}

}
