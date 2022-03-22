package day15;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Bj14503_로봇청소기 {
	static int[] dx = { -1, 0, 1, 0 }; // 북 동 남 서
	static int[] dy = { 0, 1, 0, -1 };
	static int N, M, cnt = 1;
	static int[][] map;

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new int[N][M];
		st = new StringTokenizer(bf.readLine());
		int r = Integer.parseInt(st.nextToken());
		int c = Integer.parseInt(st.nextToken());
		int d = Integer.parseInt(st.nextToken());

		for (int i = 0; i < map.length; i++) {
			st = new StringTokenizer(bf.readLine());
			for (int j = 0; j < map[i].length; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		robotClear(r, c, d);
		System.out.println(cnt);

	}

	private static void robotClear(int r, int c, int d) {
		if (map[r][c] == 0)
			map[r][c] = 2;

		for (int i = 0; i < 4; i++) {
			d = (d + 3) % 4;
			int nr = r + dx[d];
			int nc = c + dy[d];
			if (nr >= 0 && nr < N && nc >= 0 && nc < M && map[nr][nc] == 0) {
				++cnt;
				robotClear(nr, nc, d);
				return;
			}
		}
		int nr = r + dx[(d + 2) % 4];
		int nc = c + dy[(d + 2) % 4];
		if (nr >= 0 && nr < N && nc >= 0 && nc < M && map[nr][nc] != 1) {
			robotClear(r + dx[(d + 2) % 4], c + dy[(d + 2) % 4], d);
		}
	}
//	private static void print(int[][] map) {
//		for (int i = 0; i < map.length; i++) {
//			for (int j = 0; j < map[i].length; j++) {
//				System.out.print(map[i][j] + " ");
//			}
//			System.out.println();
//		}
//	}
}
