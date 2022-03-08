package day15;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Bj2583_영역구하기 {
	static int[][] map;
	static int N, M;
	static int[] dx = { -1, 0, 1, 0 };
	static int[] dy = { 0, 1, 0, -1 };
	static boolean[][] v;

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());
		M = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		map = new int[N][M];
		v = new boolean[N][M];

		for (int k = 0; k < K; k++) {
			st = new StringTokenizer(bf.readLine());
			int lr = Integer.parseInt(st.nextToken());
			int lc = Integer.parseInt(st.nextToken());
			int rr = Integer.parseInt(st.nextToken());
			int rc = Integer.parseInt(st.nextToken());
			for (int i = lr; i < rr; i++) {
				for (int j = lc; j < rc; j++) {
					map[i][j] = 1;
				}
			}
		}
		ArrayList<Integer> list = new ArrayList<Integer>();
		for (int i = 0; i < map.length; i++) {
			for (int j = 0; j < map[i].length; j++) {
				if (map[i][j] == 0 && !v[i][j]) {
					list.add(bfs(i, j));
				}
			}
		}

		Collections.sort(list);
		System.out.println(list.size());
		for (int i = 0; i < list.size(); i++) {
			System.out.print(list.get(i) + " ");
		}
	}

	private static Integer bfs(int r, int c) {
		Queue<int[]> q = new LinkedList<int[]>();
		v[r][c] = true;
		q.offer(new int[] { r, c });
		int cnt = 1;
		while (!q.isEmpty()) {
			int[] point = q.poll();
			for (int d = 0; d < dx.length; d++) {
				int nr = point[0] + dx[d];
				int nc = point[1] + dy[d];

				if (nr >= 0 && nr < N && nc >= 0 && nc < M && !v[nr][nc] && map[nr][nc] == 0) {
					cnt++;
					v[nr][nc] = true;
					q.offer(new int[] { nr, nc });
				}
			}
		}
		return cnt;
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
