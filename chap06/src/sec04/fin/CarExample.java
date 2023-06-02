package sec04.fin;

public class CarExample {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Car car = new Car() ;
		
		car.gas = 5;
		
		if(car.isLeftGas()) {
			System.out.println("출발");	
		} else {
			System.out.println("연료 부족으로 멈춤");
		}
		
		car.run();
		
		if(car.isLeftGas()) {
			System.out.println("출발");	
		} else {
			System.out.println("연료 부족으로 멈춤");
		}
	}

}
