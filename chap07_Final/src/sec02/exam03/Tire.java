package sec02.exam03;

public class Tire {

	public int maxRotation;
	public int accumlatedRotation;
	public String location;
	
	public Tire(String location, int maxRotation) {
		this.location = location;
		this.maxRotation = maxRotation;
		
	}
	
	public boolean roll() {
		++accumlatedRotation;
		if(accumlatedRotation<maxRotation) {
			System.out.println(location + "Tire 수명 : " + (maxRotation-accumlatedRotation) + "회");
			return true;
		} else {
			System.out.println("***" + location + "Tire 펑크 ***");
			return false;
		}
	}
}
