package BAEKJOON;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class silver3_11399 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[] hour = new int[N];
		int sum = 0;
		

		// 시간 입력
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			hour[i] = Integer.parseInt(st.nextToken());
		}

		// 배열 작은 순서 정렬
		Arrays.sort(hour);
		
		for(int i = 0; i < hour.length; i++) {
			for(int j = 0; j <= i; j++) {
				sum += hour[j];
			}
		}
		
		
		System.out.println(sum);

	}
}
