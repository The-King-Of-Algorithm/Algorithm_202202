package day21;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Bj20058_마법사상어와파이어스톰 {
	static int N, Q, max;
	static int[][] map;
	static int[] dx = { -1, 0, 1, 0 };
	static int[] dy = { 0, 1, 0, -1 };
	static boolean[][] v;

	public static void main(String[] args) throws IOException {

		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());
		N = Integer.parseInt(st.nextToken());
		Q = Integer.parseInt(st.nextToken());
		map = new int[(int) Math.pow(2, N)][(int) Math.pow(2, N)];
		v = new boolean[(int) Math.pow(2, N)][(int) Math.pow(2, N)];

		for (int i = 0; i < map.length; i++) {
			st = new StringTokenizer(bf.readLine());
			for (int j = 0; j < map.length; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		st = new StringTokenizer(bf.readLine());
		for (int q = 0; q < Q; q++) {
			int L = Integer.parseInt(st.nextToken());
			move(map.length, (int) Math.pow(2, L));
			malt();
		}

		int sum = 0;
		for (int i = 0; i < map.length; i++) {
			for (int j = 0; j < map.length; j++) {
				sum += map[i][j];
			}
		}
		System.out.println(sum);

		for (int i = 0; i < map.length; i++) {
			for (int j = 0; j < map.length; j++) {
				if (map[i][j] != 0 && !v[i][j]) {
					bfs(i, j);
				}
			}
		}
		System.out.println(max);

	}

	private static void bfs(int i, int j) {
		Queue<int[]> q = new LinkedList<int[]>();
		v[i][j] = true;
		q.offer(new int[] { i, j });
		int cnt = 1;
		while (!q.isEmpty()) {
			int[] current = q.poll();
			for (int d = 0; d < dx.length; d++) {
				int nr = current[0] + dx[d];
				int nc = current[1] + dy[d];
				if (nr >= 0 && nr < map.length && nc >= 0 && nc < map.length && map[nr][nc] != 0 && !v[nr][nc]) {
					v[nr][nc] = true;
					q.offer(new int[] { nr, nc });
					cnt++;
				}
			}
		}
		max = Math.max(max, cnt);
	}

	private static void move(int ML, int L) {
		if (L == 1) return;
		int[][] tmp = new int[ML][ML];
		for (int i = 0; i < ML; i += L) {
			for (int j = 0; j < ML; j += L) {
				int c = j + L - 1;
				for (int a = i; a < i + L; a++) {
					int r = i;
					for (int b = j; b < j + L; b++) {
						tmp[r++][c] = map[a][b];

					}
					c--;
				}

			}
		}
		map = tmp;
	}

	private static void malt() {
		ArrayList<int[]> list = new ArrayList<int[]>();
		for (int i = 0; i < map.length; i++) {
			for (int j = 0; j < map.length; j++) {
				if (map[i][j] == 0)
					continue;
				int cnt = 0;
				for (int d = 0; d < dx.length; d++) {
					int nr = i + dx[d];
					int nc = j + dy[d];
					if (nr >= 0 && nr < map.length && nc >= 0 && nc < map.length && map[nr][nc] != 0)
						cnt++;
				}
				if (cnt < 3)
					list.add(new int[] { i, j });

			}
		}

		for (int i = 0; i < list.size(); i++) {
			map[list.get(i)[0]][list.get(i)[1]]--;
		}
	}

//	private static void print(int[][] map) {
//		for (int i = 0; i < map.length; i++) {
//			for (int j = 0; j < map.length; j++) {
//				System.out.print(map[i][j] + " ");
//			}
//			System.out.println();
//		}
//		System.out.println();
//	}
}
