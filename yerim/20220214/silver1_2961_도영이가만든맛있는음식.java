package BAEKJOON;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class silver1_2961_도영이가만든맛있는음식 {

	static int N, result;
	static int[] sour, bitter;
	static boolean[] v;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		N = Integer.parseInt(br.readLine());
		sour = new int[N];
		bitter = new int[N];
		result = Integer.MAX_VALUE;
		v = new boolean[N];

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			sour[i] = Integer.parseInt(st.nextToken());
			bitter[i] = Integer.parseInt(st.nextToken());
		}

		subset(0);

		System.out.println(result);
	}

	private static void subset(int k) {
		int sour_sum = 1, bitter_sum = 0, cnt = 0;
		
		if (k == N) {
			for (int i = 0; i < N; i++) {
				if(v[i]) {
					sour_sum *= sour[i];
					bitter_sum += bitter[i];
					cnt++;
				}
			}
			// 공집합일때 빼야함!!!!!!!!!!!!!!!!!!!!!!!!
			if(cnt == 0) return;
			
			result = Math.min(result, Math.abs(bitter_sum - sour_sum));

			return;
		}
		
		v[k] = true;
		subset(k + 1);
		v[k] = false;
		subset(k+1);
	}

}
