package sec01;

class Car{}

public class ClassExample {

	public static void main(String[] args) throws ClassNotFoundException {
		Class clazz = Car.class;

		System.out.println(clazz.getName());
		System.out.println(clazz);
		System.out.println(clazz.getPackageName());
		
		Class clazz2 = Class.forName("sec01.Car");
		System.out.println(clazz2.getName());
		
		Car car = new Car();
		System.out.println(car.getClass());
	}

}
