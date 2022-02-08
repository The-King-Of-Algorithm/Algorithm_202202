package SWEA;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class D3_6958 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());

		for (int tc = 1; tc <= T; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			int M = Integer.parseInt(st.nextToken());
			int[] score = new int[N];
			int cnt_p = 0; // 1등한 사람의 수
			int cnt_s = 0; // 1등이 푼 문제 수

			for (int i = 0; i < N; i++) {
				StringTokenizer st1 = new StringTokenizer(br.readLine());
				// 점수 더하기
				for (int j = 0; j < M; j++) {
					score[i] += Integer.parseInt(st1.nextToken());
				}
				// 1등 문제 수 구하기
				cnt_s = Math.max(cnt_s, score[i]);				
			}
			
			for(int a : score) {
				if(cnt_s <= a) cnt_p++;
			}
			
			System.out.printf("#%d %d %d\n", tc, cnt_p, cnt_s);
		}

	}

}