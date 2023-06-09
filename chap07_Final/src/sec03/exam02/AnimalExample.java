package sec03.exam02;

public class AnimalExample {

	public static void main(String[] args) {

		Dog dog = new Dog() ;
		Cat cat = new Cat() ;
		dog.sound();
		cat.sound();
		System.out.println("-----");
		
		// 추상클래스
		Animal animal = null;
		animal = new Dog();
		animal.sound();
		animal = new Cat();
		animal.sound();
		System.out.println("-----");
		
		//메소드의 다형성
		animalSound(new Dog());
		animalSound(new Cat());

	}
	
	// 매개변수의 다형성
	public static void animalSound(Animal animal) {
		animal.sound();
	}

}
