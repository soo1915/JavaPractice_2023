package toy;

public class Battery {

	private int power;

	// DI 방식 : 생성자식
	public Battery(int power) {
		this.power = power;
	}

	public int getPower() {
		return power;
	}

	public void changePower() {
		this.power--;
	}
	
	
}
