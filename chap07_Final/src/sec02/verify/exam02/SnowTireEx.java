package sec02.verify.exam02;

public class SnowTireEx {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		SnowTire snowTire = new SnowTire();
		Tire tire = snowTire;
		
		snowTire.run();
		tire.run();

	}

}
