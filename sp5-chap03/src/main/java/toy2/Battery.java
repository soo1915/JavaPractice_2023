package toy2;

public class Battery {

	private int power;

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
