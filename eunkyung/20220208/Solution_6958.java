package day05;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
//동철이의 프로그래밍 대회
public class Solution_6958 {
	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(bf.readLine());

		for (int test_case = 1; test_case <= T; test_case++) {
			StringTokenizer st = new StringTokenizer(bf.readLine());
			int N = Integer.parseInt(st.nextToken());
			int M = Integer.parseInt(st.nextToken());
			int[][] arr = new int[N][M + 1]; //각 행의 맨 뒤에 맞춘 개수 저장
			int max = 0;
			int people = 0;

			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(bf.readLine());
				int cnt = 0;
				for (int j = 0; j < M; j++) {
					arr[i][j] = Integer.parseInt(st.nextToken());
					if (arr[i][j] == 1) {
						cnt++;
					}
				}
				max = Math.max(max, cnt);
				arr[i][M] = cnt;
			}

			for (int i = 0; i < N; i++) {
				if (arr[i][M] == max) {
					people++;
				}
			}
			System.out.println("#" + test_case + " " + people + " " + max);
		}
	}
}