package sec02;

public class FinalEx {

	public static void main(String[] args) {
		int max = 0;
		int[] array4 = {1,5,3,8,2};
		
		for (int i = 0; i < array4.length; i++) {
			if (array4[i]>max) {
				max = array4[i];
			}
		}
		System.out.println(max);
		
		int[][] arr5 = {
				{95, 86},
				{83, 92, 96},
				{78, 83, 93, 87, 88}
		};
		
		int sum = 0;
		double avg = 0.0;
		
		for (int i = 0; i<arr5.length; i++) {
			for (int j = 0; j<arr5[i].length; j++) {
				sum += arr5[i][j];
			}
		}
		
		avg = (double)sum / 10;
		System.out.println(sum);
		System.out.println(avg);
	}

}
