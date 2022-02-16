package day06;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
//쿼드트리
public class Baek_1992 {
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(bf.readLine());
		int[][] map = new int[N][N];

		for (int i = 0; i < map.length; i++) {
			String str = bf.readLine();
			for (int j = 0; j < map.length; j++) {
				map[i][j] = str.charAt(j) - '0';
				map[i][j] = str.charAt(j) - '0';
			}
		}
		recursive(map, N);
		System.out.println(sb);
	}

	private static void recursive(int[][] map, int N) {
		if (!check(map)) {
			N /= 2;

			int[][] map1 = new int[N][N];
			for (int r = 0; r < N; r++) {
				for (int c = 0; c < N; c++) {
					map1[r][c] = map[r][c];
				}
			}

			int[][] map2 = new int[N][N];
			for (int r = 0; r < N; r++) {
				for (int c = N; c < map.length; c++) {
					map2[r][c - N] = map[r][c];
				}
			}

			int[][] map3 = new int[N][N];
			for (int r = N; r < map.length; r++) {
				for (int c = 0; c < N; c++) {
					map3[r - N][c] = map[r][c];
				}
			}

			int[][] map4 = new int[N][N];
			for (int r = N; r < map.length; r++) {
				for (int c = N; c < map.length; c++) {
					map4[r - N][c - N] = map[r][c];
				}
			}
			sb.append("(");
			recursive(map1, N);
			recursive(map2, N);
			recursive(map3, N);
			recursive(map4, N);
			sb.append(")");

		} else {
			sb.append(map[0][0]);
		}
	}

	private static boolean check(int[][] map) {
		int n = map[0][0];
		for (int i = 0; i < map.length; i++) {
			for (int j = 0; j < map.length; j++) {
				if (n != map[i][j]) {
					return false;
				}
			}
		}
		return true;
	}
}
