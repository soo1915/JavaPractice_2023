package sec01.exam04;

public class SuperSonicAirplane extends Airplane{
	
	public Fly flyMode = Fly.NORMAL;
	
	@Override
	public void fly() {
		if(flyMode == Fly.SUPERSONIC) {
			System.out.println("초음속비행합니다.");
		}else {
			super.fly();
		}
	}
	
	
}
