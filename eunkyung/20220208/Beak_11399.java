package day05;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
//ATM.. 순열
public class Beak_11399 {
	static int min = Integer.MAX_VALUE;

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(bf.readLine());
		int[] arr = new int[N];
		StringTokenizer st = new StringTokenizer(bf.readLine());

		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		select(arr, new boolean[N], 0, 0, 0);
		System.out.println(min);
	}

	private static void select(int[] arr, boolean[] v, int sum, int sum2, int k) {
		if (k == arr.length) {
			min = Math.min(min, sum2);
			return;
		}
		for (int i = 0; i < arr.length; i++) {
			if (v[i] == false) {
				v[i] = true;
				sum += arr[i];
				sum2 += sum;
				select(arr, v, sum, sum2, k + 1);
				v[i] = false;
				sum2 -= sum;
				sum -= arr[i];
			}
		}

	}
}
