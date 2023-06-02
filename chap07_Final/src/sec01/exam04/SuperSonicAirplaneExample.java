package sec01.exam04;

public class SuperSonicAirplaneExample {

	public static void main(String[] args) {
			
		SuperSonicAirplane sa = new SuperSonicAirplane();
		sa.takeOff();
		sa.fly();
		sa.flyMode = Fly.SUPERSONIC;
		sa.fly();
		sa.flyMode = Fly.NORMAL;
		sa.fly();
		sa.land();

	}

}
