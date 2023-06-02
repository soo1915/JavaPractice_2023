package sec02;

public class Bubble {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int a[] = {10, 3, 1, 4, 2};
		
		for(int i=0; i<a.length-1; i++) {
			for (int j=a.length-1; j>i; j--) {
				if (a[j] < a[j-1]) {
					int tmp = a[j];
					a[j] = a[j-1];
					a[j-1] = tmp;
				}
				System.out.printf("%d, %d\n", i, j);
			}
		}
		for (int num : a) {
			System.out.print(num + ",");
		}
	}

}
