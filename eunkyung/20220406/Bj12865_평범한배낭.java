package day16;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

public class Bj12865_평범한배낭 {

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		int[][] dp = new int[N][K + 1];

		st = new StringTokenizer(bf.readLine());
		int W = Integer.parseInt(st.nextToken());
		int V = Integer.parseInt(st.nextToken());
		for (int j = 1; j < K + 1; j++) {
			if (j >= W) {
				dp[0][j] = V;
			}
		}

		for (int i = 1; i < N; i++) {
			st = new StringTokenizer(bf.readLine());
			W = Integer.parseInt(st.nextToken());
			V = Integer.parseInt(st.nextToken());
			for (int j = 1; j < K + 1; j++) {
				if (j >= W) {
					dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j - W] + V);
				} else {
					dp[i][j] = dp[i - 1][j];
				}
			}
		}
//		for (int i = 0; i < dp.length; i++) {
//			System.out.println(Arrays.toString(dp[i]));
//		}

		System.out.println(dp[N - 1][K]);
	}
}
