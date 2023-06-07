package sec02.exam04.animal;

public class FeedEx {

	public static void main(String[] args) {

		Feed feed = new Feed();
		
		Dog dog = new Dog();
		Cat cat = new Cat();
		
		
		feed.feed(dog);
		System.out.println("---------------");
		feed.feed(cat);
		

	}

}
