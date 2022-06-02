package day19;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Bj14499_주사위굴리기 {
	static int N, M, x, y, K, s = 6;
	static int[][] map;
	static int[] dx = { 0, 0, 0, -1, 1 };
	static int[] dy = { 0, 1, -1, 0, 0 };
	static int[] state = { 0, 0, 0, 0, 0, 0, 0 };

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		x = Integer.parseInt(st.nextToken());
		y = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		map = new int[N][M];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(bf.readLine());
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		st = new StringTokenizer(bf.readLine());
		for (int i = 0; i < K; i++) {
			move(Integer.parseInt(st.nextToken()));
		}
	}

	private static void move(int k) {
		if (k == 1) { // 동쪽
			if (!ckeck(x, y + 1))
				return;
			int tmp = state[3];
			state[3] = state[1];
			state[1] = state[4];
			state[4] = state[6];
			state[6] = tmp;
		} else if (k == 2) { // 서쪽
			if (!ckeck(x, y - 1))
				return;
			int tmp = state[4];
			state[4] = state[1];
			state[1] = state[3];
			state[3] = state[6];
			state[6] = tmp;
		} else if (k == 3) { // 북쪽
			if (!ckeck(x - 1, y))
				return;
			int tmp = state[2];
			state[2] = state[1];
			state[1] = state[5];
			state[5] = state[6];
			state[6] = tmp;
		} else if (k == 4) { // 남쪽
			if (!ckeck(x + 1, y))
				return;
			int tmp = state[5];
			state[5] = state[1];
			state[1] = state[2];
			state[2] = state[6];
			state[6] = tmp;
		}
		copy(6);
		System.out.println(state[1]);

	}

	private static void copy(int i) {
		if (map[x][y] == 0) {
			map[x][y] = state[i];
		} else {
			state[i] = map[x][y];
			map[x][y] = 0;
		}
	}

	private static boolean ckeck(int r, int c) {
		if (r >= 0 && r < N && c >= 0 && c < M) {
			x = r;
			y = c;
			return true;
		}
		return false;
	}
//
//	private static void print(int[][] map) {
//		for (int i = 0; i < map.length; i++) {
//			for (int j = 0; j < map[i].length; j++) {
//				System.out.print(map[i][j] + " ");
//			}
//			System.out.println();
//		}
//		System.out.println();
//	}
}
