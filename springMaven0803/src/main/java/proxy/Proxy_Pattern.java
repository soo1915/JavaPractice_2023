package proxy;

public class Proxy_Pattern {

	public static void main(String[] args) {
		
		// 프록시 사용
		Image img1 = new Proxy_Image("test1.jpg");
		img1.displayImage();
		
		System.out.println();
		
		// 프록시 사용 아님
		Image img2 = new Real_Image("test1.jpg");
		img2.displayImage();
	}

}
