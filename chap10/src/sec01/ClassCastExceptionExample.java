package sec01;

class Animal {}
class Dog extends Animal{}
class Cat extends Animal{}
class Lion {}

public class ClassCastExceptionExample {

	public static void changeDog(Animal animal) {
		if (animal instanceof Dog) {
			Dog dog = (Dog) animal;			
		} else {
			System.out.println("안됨");
		}
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Dog dog = new Dog();
		Cat cat = new Cat();
		Lion lion = new Lion();
	
		changeDog(cat);

	}

}
