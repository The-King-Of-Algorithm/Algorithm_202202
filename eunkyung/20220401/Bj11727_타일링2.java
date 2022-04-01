package day16;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Bj11727_타일링2 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(bf.readLine());
		long[] dp = new long[N + 1];
		dp[1] = 1;
		if (N > 1)
			dp[2] = 3;

		for (int i = 3; i < dp.length; i++) {
			dp[i] = (dp[i - 1] + 2 * dp[i - 2]) % 10007;
		}
		System.out.println(Arrays.toString(dp));
		System.out.println(dp[N]);
	}
}
