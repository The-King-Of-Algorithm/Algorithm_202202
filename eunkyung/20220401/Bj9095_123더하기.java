package day16;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Bj9095_123더하기 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(bf.readLine());
		for (int tc = 0; tc < T; tc++) {
			int N = Integer.parseInt(bf.readLine());
			int[] dp = new int[N + 1];
			dp[1] = 1;
			if(N > 1) dp[2] = 2;
			if(N > 2) dp[3] = 4;
			
			for (int i = 4; i < dp.length; i++) {
				dp[i] = dp[i - 1] + dp[i - 2] + dp[i - 3];
			}
			System.out.println(dp[N]);
		}

	}
}
