package sec02;

public class ArrayEx2 {

	public static void main(String[] args) {
		int[] scores = {70, 80, 90, 60};
		int sum = method(scores);
		for(int i=0; i<scores.length; i++) {
			System.out.println(scores[i]);
		}
		System.out.println("총점 " + sum);
	}
	
	public static int method(int[] nums) {
		int sum = 0;
		for (int i=0; i<nums.length; i++) {
			nums[i] += 10;
			sum += nums[i];
		}
		return sum; 
	}
}
