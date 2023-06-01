package sec01;

public class Rectangle {
	private int x;
	private int y;
	
	public Rectangle() {
			
	}
	
	public Rectangle(int x, int y) {
		super() ;
		this.x = x;
		this.y = y;
	}
	
	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}
	
	

	double areaRec() {
		double size = (double)x * y;
		return size;
		
	}
	
	String areaRec(String area) {
		return area;
		
	}

}
