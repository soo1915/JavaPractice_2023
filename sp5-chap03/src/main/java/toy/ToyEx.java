package toy;

public class ToyEx {

	public static void main(String[] args) {

		Toy toy = new Toy();
		while(toy.isBattery()) {
			toy.move();
		}
		System.out.println("배터리 부족으로 멈춤");
	}

}
