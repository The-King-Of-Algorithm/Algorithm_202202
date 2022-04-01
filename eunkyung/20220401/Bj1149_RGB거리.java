package day16;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Bj1149_RGB거리 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(bf.readLine());
		int[][] color = new int[N][3];
		int[][] dp = new int[N][3];

		for (int i = 0; i < color.length; i++) {
			StringTokenizer st = new StringTokenizer(bf.readLine());
			for (int j = 0; j < color[i].length; j++) {
				color[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		dp[0][0] = color[0][0];
		dp[0][1] = color[0][1];
		dp[0][2] = color[0][2];

		for (int i = 1; i < dp.length; i++) {
			dp[i][0] = Math.min(color[i][0] + dp[i - 1][1], color[i][0] + dp[i - 1][2]);
			dp[i][1] = Math.min(color[i][1] + dp[i - 1][0], color[i][1] + dp[i - 1][2]);
			dp[i][2] = Math.min(color[i][2] + dp[i - 1][0], color[i][2] + dp[i - 1][1]);
		}
		Arrays.sort(dp[N - 1]);
		System.out.println(dp[N - 1][0]);

	}
}
