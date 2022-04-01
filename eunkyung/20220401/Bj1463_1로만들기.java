package day16;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Bj1463_1로만들기 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		int X = Integer.parseInt(bf.readLine());
		int[] dp = new int[X + 1];

		dp[1] = 0;
		if (X > 1)
			dp[2] = 1;
		if (X > 2)
			dp[3] = 1;

		for (int i = 2; i < dp.length; i++) {
			if (dp[i] == 0) {
				dp[i] = dp[i - 1] + 1;
				if (i % 2 == 0) {
					dp[i] = Math.min(dp[i], dp[i / 2] + 1);
				}
				if (i % 3 == 0) {
					dp[i] = Math.min(dp[i], dp[i / 3] + 1);
				}
			}
		}
		// System.out.println(Arrays.toString(dp));
		System.out.println(dp[X]);
	}
}
