package sec02;

public class Array2Ex {

	public static void main(String[] args) {
		//int [][] scores = {{95, 80}, {92,96}, {78, 65}};
		
		int[][] scores = {{100,100,100}, {20,100,95}, {50, 80, 90}, {80, 60, 100}};
		
		int korTot = 0;
		int mathTot = 0;
		int engTot = 0;
		for (int i = 0; i<scores.length; i++) {
			int sum = 0;
			korTot += scores[i][0];
			mathTot += scores[i][1];
			engTot += scores[i][2];
			for(int j = 0; j<scores[i].length; j++) {
				sum += scores[i][j];
				System.out.print(scores[i][j] + "\t");
			}
			System.out.println("총점 : " + sum);;
		}
		System.out.println(("-----------------------------------"));
		System.out.print(korTot + "\t");
		System.out.print(mathTot+ "\t");
		System.out.print(engTot + "\t");
		
		
		//System.out.println(scores.length); // 3 출력
		// 2차원은 조건문을 2개 작성
//		for (int i = 0; i<scores.length; i++) {
//			for (int j = 0; j<scores[i].length; j++) {
//				sum += scores[i][j];
//			}
//		}
//		System.out.println("총점 : " + sum);
	}

}
