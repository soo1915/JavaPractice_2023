package sec05;

public class Car {

	private int gas;
	private int speed;
		
	void keyTurnOn() {
		System.out.println("키를 돌립니다.");
	}
	
	boolean isLeftGas() {
		if (gas > 0) {
			return true;
		} else {
			return false;
		}
	}
	
	void run() {
		while (isLeftGas()) {
			System.out.println("달립니다. (gas 잔량 : " + gas + " 시속: " + speed + "km/h");
			if (speed <= 100) {
				speed += 10;
			}
			gas -= 1;
		}
		System.out.println("멈춥니다 gas 잔량 : " + gas);
	}
	
	public int getGas() {
		return gas;
	}



	public void setGas(int gas) {
		this.gas = gas;
	}



	public int getSpeed() {
		return speed;
	}



	public void setSpeed(int speed) {
		this.speed = speed;
	}



	public static void main(String[] args) {
		
		Car car = new Car() ;
		car.setGas(20);
		car.keyTurnOn();
		car.run();
	}

}
