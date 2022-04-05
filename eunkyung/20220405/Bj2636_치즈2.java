package day15;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

import day15.Bj2234_성곽.Wall;

public class Bj2636_치즈2 {
	static int N, M;
	static int[][] map;
	static int[] dx = { 1, 0, -1, 0 };
	static int[] dy = { 0, 1, 0, -1 };

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new int[N][M];

		for (int i = 0; i < map.length; i++) {
			st = new StringTokenizer(bf.readLine());
			for (int j = 0; j < map[i].length; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		int cnt = 0;
		int sum = 0;
		while (true) {
			sum = count(map);
			boolean[][] v = new boolean[N][M];
			dfs(0, 0, v);
			//print(map);
			++cnt;
			if (count(map) == 0) {
				break;
			}
		}
		System.out.println(cnt);
		System.out.println(sum);
	}

	private static void dfs(int r, int c, boolean[][] v) {

		for (int d = 0; d < dx.length; d++) {
			int nr = r + dx[d];
			int nc = c + dy[d];
			if (nr >= 0 && nr < N && nc >= 0 && nc < M && !v[nr][nc]) {
				if (map[nr][nc] == 0) {
					v[nr][nc] = true;
					dfs(nr, nc, v);
				} else {
					map[nr][nc] = 0;
					v[nr][nc] = true;
				}
			}
		}
	}

	private static int count(int[][] map) {
		int sum = 0;
		for (int i = 0; i < map.length; i++) {
			for (int j = 0; j < map[i].length; j++) {
				if (map[i][j] == 1) {
					++sum;
				}
			}
		}
		return sum;
	}

	private static void print(int[][] map) {
		for (int r = 0; r < N; r++) {
			for (int c = 0; c < M; c++) {
				System.out.print(map[r][c] + " ");
			}
			System.out.println();
		}
	}

}
