package day06;
//사탕게임

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Baek_3085 {
	static int[] dx = { 0, 0, -1, 1 };
	static int[] dy = { -1, 1, 0, 0 };
	static int max = 0;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(bf.readLine());
		char[][] map = new char[N][N];

		for (int i = 0; i < map.length; i++) {
			String str = bf.readLine();
			for (int j = 0; j < map.length; j++) {
				map[i][j] = str.charAt(j);
			}
		}

		operation(map);
		for (int i = 0; i < map.length; i++) {
			for (int j = 0; j < map.length; j++) {
				for (int d = 0; d < dx.length; d++) {
					int nr = i + dx[d];
					int nc = j + dy[d];
					if (nr >= 0 && nr < N && nc >= 0 && nc < N) {
						if (map[i][j] != map[nr][nc]) {
							char tmp = map[i][j];
							map[i][j] = map[nr][nc];
							map[nr][nc] = tmp;
							operation(map);
						}
						char tmp = map[i][j];
						map[i][j] = map[nr][nc];
						map[nr][nc] = tmp;
					}

				}

			}
		}
		System.out.println(max);

	}

//	private static void print(char[][] map) {
//		for (int i = 0; i < map.length; i++) {
//			for (int j = 0; j < map.length; j++) {
//				System.out.print(map[i][j]);
//			}
//			System.out.println();
//		}
//	}

	private static void operation(char[][] map) {
		for (int i = 0; i < map.length; i++) {
			int cnt = 1;
			char c = map[i][0];
			for (int j = 1; j < map.length; j++) {
				if (map[i][j] == c) {
					cnt++;
				} else {
					max = Math.max(cnt, max);
					c = map[i][j];
					cnt = 1;
				}
			}
			max = Math.max(cnt, max);
		}

		for (int j = 0; j < map.length; j++) {
			int cnt = 1;
			char c = map[0][j];
			for (int i = 1; i < map.length; i++) {
				if (map[i][j] == c) {
					cnt++;
				} else {
					max = Math.max(cnt, max);
					c = map[i][j];
					cnt = 1;
				}
			}
			max = Math.max(cnt, max);
		}
	}

}
