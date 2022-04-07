package day17;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class Bj2573_빙산 {
	static int N, M;
	static int[][] map;
	static ArrayList<int[]> list = new ArrayList<int[]>();
	static int[] dx = { -1, 0, 1, 0 };
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
				if (map[i][j] > 0)
					list.add(new int[] { i, j });
			}
		}
		int year = 0;
		while (true) {
			map = operation(map);
			boolean[][] v = new boolean[N][M];
			int cnt = 0;
			for (int i = 0; i < map.length; i++) {
				for (int j = 0; j < map[i].length; j++) {
					if (!v[i][j] && map[i][j] > 0) {
						cnt++;
						bfs(i, j, v);
					}
				}
			}
			year++;
			if (cnt >= 2) {
				System.out.println(year);
				return;
			}
			if (cnt == 0) {
				System.out.println(0);
				return;
			}
		}

	}

	private static void bfs(int r, int c, boolean[][] v) {
		Queue<int[]> q = new LinkedList<int[]>();
		q.offer(new int[] { r, c });
		v[r][c] = true;

		while (!q.isEmpty()) {
			int[] point = q.poll();
			for (int d = 0; d < dx.length; d++) {
				int nr = point[0] + dx[d];
				int nc = point[1] + dy[d];
				if (nr >= 0 && nr < N && nc >= 0 && nc < M && !v[nr][nc] && map[nr][nc] > 0) {
					v[nr][nc] = true;
					q.offer(new int[] { nr, nc });
				}
			}
		}
	}

	private static int[][] operation(int[][] map) {
		int[][] tmp = new int[N][M];

		for (int i = list.size() - 1; i >= 0; i--) {
			int[] point = list.get(i);
			int cnt = 0;
			for (int d = 0; d < dx.length; d++) {
				int nr = point[0] + dx[d];
				int nc = point[1] + dy[d];
				if (nr >= 0 && nr < N && nc >= 0 && nc < M && map[nr][nc] == 0) {
					cnt++;
				}
			}
			if (map[point[0]][point[1]] - cnt > 0)
				tmp[point[0]][point[1]] = map[point[0]][point[1]] - cnt;
			else {
				list.remove(i);
				tmp[point[0]][point[1]] = 0;
			}
		}
		// print(tmp);
		return tmp;
	}

	private static void print(int[][] map) {
		for (int i = 0; i < map.length; i++) {
			for (int j = 0; j < map[i].length; j++) {
				System.out.print(map[i][j] + " ");
			}
			System.out.println();
		}
		System.out.println();
	}
}
