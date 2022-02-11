package day07;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

//배열 돌리기3
public class Baek_16935 {
	static int[][] map;
	static int N, M, R;

	public static void main(String[] args) throws IOException {
		System.setIn(new FileInputStream("src/16935.txt"));
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		R = Integer.parseInt(st.nextToken());
		map = new int[N][M];

		for (int i = 0; i < map.length; i++) {
			st = new StringTokenizer(bf.readLine());
			for (int j = 0; j < map[i].length; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		int[] c = new int[R];
		st = new StringTokenizer(bf.readLine());
		for (int i = 0; i < c.length; i++) {
			c[i] = Integer.parseInt(st.nextToken());
		}

		for (int i = 0; i < R; i++) {
			N = map.length;
			M = map[0].length;

			switch (c[i]) {
			case 1:
				one();
				break;
			case 2:
				two();
				break;
			case 3:
				three();
				break;
			case 4:
				four();
				break;
			case 5:
				five();
				break;
			case 6:
				six();
				break;
			}
		}
		print(map);
	}

	private static void six() {
		int[][] newmap = new int[N][M];
		int r = N / 2;
		int c = M / 2;

		for (int i = 0; i < r; i++) {
			for (int j = 0; j < c; j++) {
				newmap[i + r][j] = map[i][j];
			}
		}
		for (int i = 0; i < r; i++) {
			for (int j = c; j < M; j++) {
				newmap[i][j - c] = map[i][j];
			}
		}
		for (int i = r; i < N; i++) {
			for (int j = c; j < M; j++) {
				newmap[i - r][j] = map[i][j];
			}
		}
		for (int i = r; i < N; i++) {
			for (int j = 0; j < c; j++) {
				newmap[i][j + c] = map[i][j];
			}
		}
		map = newmap;
	}

	private static void five() {
		int[][] newmap = new int[N][M];
		int r = N / 2;
		int c = M / 2;

		for (int i = 0; i < r; i++) {
			for (int j = 0; j < c; j++) {
				newmap[i][j + c] = map[i][j];
			}
		}
		for (int i = 0; i < r; i++) {
			for (int j = c; j < M; j++) {
				newmap[i + r][j] = map[i][j];
			}
		}
		for (int i = r; i < N; i++) {
			for (int j = c; j < M; j++) {
				newmap[i][j - c] = map[i][j];
			}
		}
		for (int i = r; i < N; i++) {
			for (int j = 0; j < c; j++) {
				newmap[i - r][j] = map[i][j];
			}
		}
		map = newmap;

	}

	private static void four() {
		int[][] newmap = new int[M][N];
		for (int i = 0; i < map.length; i++) {
			for (int j = 0; j < map[i].length; j++) {
				newmap[M - 1 - j][i] = map[i][j];
			}
		}
		map = newmap;
	}

	private static void three() {
		int[][] newmap = new int[M][N];
		for (int i = 0; i < map.length; i++) {
			for (int j = 0; j < map[i].length; j++) {
				newmap[j][N - 1 - i] = map[i][j];
			}
		}
		map = newmap;
	}

	private static void two() {
		int[][] newmap = new int[N][M];
		int center = M / 2;
		for (int cnt = 0; cnt < R; cnt++) {
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < center; j++) {
					newmap[i][j] = map[i][M - j - 1];
					newmap[i][M - j - 1] = map[i][j];
				}
			}
		}
		map = newmap;
	}

	private static void one() {
		int[][] newmap = new int[N][M];
		int center = N / 2;
		for (int cnt = 0; cnt < center; cnt++) {
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < M; j++) {
					newmap[i][j] = map[N - i - 1][j];
					newmap[N - i - 1][j] = map[i][j];
				}
			}
		}
		map = newmap;
	}

	private static void print(int[][] map) {
		for (int i = 0; i < map.length; i++) {
			for (int j = 0; j < map[i].length; j++) {
				System.out.print(map[i][j] + " ");
			}
			System.out.println();
		}
	}

}
