package day16;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Bj11722_가장긴감소하는부분수열 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(bf.readLine());
		int[] arr = new int[N];
		int[] LIS = new int[N];
		Arrays.fill(LIS, 1);
		StringTokenizer st = new StringTokenizer(bf.readLine());
		for (int i = 0; i < arr.length; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}

		int max = 0;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < i; j++) {
				if (arr[i] < arr[j] && LIS[j] + 1 > LIS[i]) {
					LIS[i] = LIS[j] + 1;
				}
			}
			max = Math.max(max, LIS[i]);
		}
		
		System.out.println(max);
	}
}
