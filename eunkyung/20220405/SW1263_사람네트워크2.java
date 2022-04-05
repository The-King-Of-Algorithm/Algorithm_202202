package day16;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SW1263_사람네트워크2 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(bf.readLine());

		for (int tc = 1; tc <= T; tc++) {
			StringTokenizer st = new StringTokenizer(bf.readLine());
			int N = Integer.parseInt(st.nextToken());
			int[][] adjmat = new int[N][N];

			for (int i = 0; i < adjmat.length; i++) {
				for (int j = 0; j < adjmat.length; j++) {
					adjmat[i][j] = Integer.parseInt(st.nextToken());
					if (i != j && adjmat[i][j] == 0) {
						adjmat[i][j] = 9999999;
					}
				}
			}

			// print(adjmat);
			for (int k = 0; k < N; ++k) {
				for (int i = 0; i < N; ++i) {
					if (i == k)
						continue;
					for (int j = 0; j < N; ++j) {
						if (i == j || k == j)
							continue;
						if (adjmat[i][j] > adjmat[i][k] + adjmat[k][j]) {
							adjmat[i][j] = adjmat[i][k] + adjmat[k][j];
						}
					}
					// print(adjmat);

				}
			}
			// print(adjmat);
			int min = 9898999;
			for (int i = 0; i < adjmat.length; i++) {
				int sum = 0;
				for (int j = 0; j < adjmat.length; j++) {
					sum += adjmat[i][j];
				}
				min = Math.min(min, sum);
			}

			System.out.println("#" + tc + " " + min);

		}
	}

	private static void print(int[][] adjmat) {
		for (int i = 0; i < adjmat.length; i++) {
			for (int j = 0; j < adjmat.length; j++) {
				System.out.print(adjmat[i][j] + " ");
			}
			System.out.println();
		}
		System.out.println();
	}
}

//1
//5 0 1 1 0 0 1 0 1 1 1 1 1 0 0 0 0 1 0 0 0 0 1 0 0 0
