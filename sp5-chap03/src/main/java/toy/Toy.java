package toy;

public class Toy {

//	private Battery battery = new Battery(10);
	private Battery battery;
	
	// DI 방식 : setter
	public void setBattery(Battery battery) {
		this.battery = battery;
	}
	
	
	public void move() {
		System.out.println("장난감 움직인다");
		battery.changePower();
	}
	public boolean isBattery() {
		return battery.getPower() > 0;
	}
}
