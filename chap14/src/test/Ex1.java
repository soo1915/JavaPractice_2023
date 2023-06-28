package test;

public class Ex1 {

	public static void printArr(int[] arr) {
		for(int a : arr) {
			System.out.println(a);
		}
		System.out.println();
	}
	
	public static void main(String[] args) {

		int[] arr = {2,6,1,4,3,5};
		
		for(int a : arr) {
			System.out.println(a);
		}
		
		
		for(int i = 0; i < arr.length; i++) {
			for(int j = i+1; j<arr.length; j++) {
				if (arr[i] > arr[j]) {
					int temp = 0;
					temp = arr[i];
					arr[i] = arr[j];
					arr[j] = temp;
				}
				printArr(arr);
			}
		}
		
	}

}
