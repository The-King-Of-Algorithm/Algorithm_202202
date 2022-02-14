package BAEKJOON;

import java.util.Scanner;

public class silver1_16935_배열돌리기3 {

	static int N, M, R, sel;
	static int[][] map, result;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();
		R = sc.nextInt();
		map = new int[N][M];

		for (int i = 0; i < map.length; i++) {
			for (int j = 0; j < map[i].length; j++) {
				map[i][j] = sc.nextInt();
			}
		}
		
		for(int i = 0; i < R; i++) {
			sel = sc.nextInt();
			switch(sel) {
			case 1: rotate1(); break;
			case 2: rotate2(); break;
			case 3: rotate3(); break;
			case 4: rotate4(); break;
			case 5: rotate5(); break;
			case 6: rotate6(); break;
			}
			N = map.length;
			M = map[0].length;
		}
		
		print(map);
	}

	private static void rotate1() {
		result = new int[N][M];
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				result[i][j] = map[N - 1 - i][j];
			}
		}
		map = result;
	}
	
	private static void rotate2() {
		result = new int[N][M];
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				result[i][j] = map[i][M - 1 - j];
			}
		}
		map = result;
	}
	
	private static void rotate3() {
		result = new int[M][N];
		for (int i = 0; i < M; i++) {
			for (int j = 0; j < N; j++) {
				result[i][j] = map[N-1-j][i];
			}
		}
		map = result;
	}
	
	private static void rotate4() {
		result = new int[M][N];
		for (int i = 0; i < M; i++) {
			for (int j = 0; j < N; j++) {
				result[i][j] = map[j][M-1-i];
			}
		}
		map = result;
	}
	
	private static void rotate5() {
		result = new int[N][M];
		
		// 1
		for (int i = 0; i < N/2; i++) {
			for (int j = 0; j < M/2; j++) {
				result[i][j+M/2] = map[i][j];
			}
		}
		// 2
		for (int i = 0; i < N/2; i++) {
			for (int j = M/2; j < M; j++) {
				result[i+N/2][j] = map[i][j];
			}
		}
		// 3
		for (int i = N/2; i < N; i++) {
			for (int j = M/2; j < M; j++) {
				result[i][j-M/2] = map[i][j];
			}
		}
		// 4
		for (int i = N/2; i < N; i++) {
			for (int j = 0; j < M/2; j++) {
				result[i-N/2][j] = map[i][j];
			}
		}
		map = result;
	}
	
	private static void rotate6() {
		result = new int[N][M];
		
		// 1
		for (int i = 0; i < N/2; i++) {
			for (int j = 0; j < M/2; j++) {
				result[i+N/2][j] = map[i][j];
			}
		}
		// 2
		for (int i = 0; i < N/2; i++) {
			for (int j = M/2; j < M; j++) {
				result[i][j-M/2] = map[i][j];
			}
		}
		// 3
		for (int i = N/2; i < N; i++) {
			for (int j = M/2; j < M; j++) {
				result[i-N/2][j] = map[i][j];
			}
		}
		// 4
		for (int i = N/2; i < N; i++) {
			for (int j = 0; j < M/2; j++) {
				result[i][j+M/2] = map[i][j];
			}
		}
		map = result;
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
