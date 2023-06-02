package sec04.practice;

public class CarExample {

	public static void main(String[] args) {
		
		Car car = new Car();
		
		car.gas = 5;
		
		
		if(car.isLeftGas()) {
			System.out.println("연료 있다");
		} else {
			System.out.println("연료 없다");
		}
		
		car.run();
		if(car.isLeftGas()) {
			System.out.println("연료 있다");
		} else {
			System.out.println("연료부족으로 멈춤");
		}
	}

}
