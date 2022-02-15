package algo20220216;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class 설탕배달완탐 {
	static int[] arr = { 3, 5 };
	static int min = 987654321;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(bf.readLine());
		recursive(t, new int[t / 3 + 1], 0, 0, 0);
		if (min == 987654321) {
			System.out.println(-1);
		} else {
			System.out.println(min);
		}
	}

	static void recursive(int t, int sel[], int idx, int current, int start) {

		if (current == t) {
			min = Math.min(min, idx);
			return;
		}

		if (sel.length == idx) {
			return;
		}

		for (int i = start; i < arr.length; i++) {
			sel[idx] = arr[i];
			recursive(t, sel, idx + 1, current + arr[i], i);
			sel[idx] = 0;
		}
	}

}
