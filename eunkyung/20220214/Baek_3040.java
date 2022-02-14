package hw_20220214;

import java.util.Scanner;

public class Baek_3040 {
	// 백설 공주와 일곱 난쟁이
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int[] arr = new int[9];

		for (int i = 0; i < 9; i++) {
			arr[i] = sc.nextInt();
		}

		combination(arr, new int[7], 0, 0);
	}

	private static void combination(int[] arr, int[] sel, int start, int k) {
		if (k == sel.length) {
			operation(sel);
			return;
		}
		for (int i = start; i < arr.length; i++) {
			sel[k] = arr[i];
			combination(arr, sel, i + 1, k + 1);
		}
	}

	private static void operation(int[] sel) {
		int sum = 0;
		for (int i = 0; i < sel.length; i++) {
			sum += sel[i];
		}
		if (sum == 100) {
			for (int i = 0; i < sel.length; i++) {
				System.out.println(sel[i]);
			}
		}
	}
}
