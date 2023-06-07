package sec02.exam04;

public class DriverEx {

	public static void main(String[] args) {
		
		Driver driver = new Driver();
		//Vehicle vehicle = new Vehicle();
		
		//driver.drive(vehicle);
		
		Pony pony = new Pony();
		driver.drive(pony);
		
		Bus bus = new Bus();
		driver.drive(bus);
		
		Taxi taxi = new Taxi() ;
		driver.drive(taxi);
		
	}

}
