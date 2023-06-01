package sec02;

public class MethodEx {

	public static int sum(int num) {
		int sum = 0;
		for (int i = 1; i <= num; i++) {
			sum += i;
			
		}
		return sum;
	}
	
	public static int[] tot(int nums[]) {
		
		
		int tot = 0;
		for (int i = 0; i<nums.length; i++) {
			nums[i] += 10;
			tot += nums[i];
		}
		System.out.println("총점 : " + tot);	
		
		return nums;
	}
	
	public static void main(String[] args) {
		int num2 = 100;
		
		System.out.println("1부터 "+num2 + "까지의 합계 : " + sum(100));	
		
		int[] scores = {78, 73, 89, 70};
		scores = tot(scores);
		for (int i=0; i<scores.length ; i++) {
			System.out.println(scores[i]);
		}
		 
		
		
		
	}
}
