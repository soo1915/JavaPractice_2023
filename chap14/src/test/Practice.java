package test;

public class Practice {

	public static void main(String[] args) {
		
		int[] sc = {95, 71, 84};
		int sum = 0;
		for(int nn : sc) {
			sum = sum + nn;
		}
		
		System.out.println(sum);
		double avg = sum/3;
		System.out.println(avg);
	
	}
}
