package day17;

import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;
import java.io.BufferedReader;
import java.io.IOException;

public class SW1953_탈주범검거 {
	static int N, M, R, C, L;
	static int[][] map;
	static int[] dx = { -1, 0, 1, 0 };
	static int[] dy = { 0, 1, 0, -1 };
	static int[][] dir = { {}, { 0, 1, 2, 3 }, { 0, 2 }, { 1, 3 }, { 0, 1 }, { 1, 2 }, { 2, 3 }, { 3, 0 } };
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(bf.readLine());
		for (int tc = 1; tc <= T; tc++) {
			StringTokenizer st = new StringTokenizer(bf.readLine());
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			R = Integer.parseInt(st.nextToken());
			C = Integer.parseInt(st.nextToken());
			L = Integer.parseInt(st.nextToken());

			map = new int[N][M];
			for (int i = 0; i < map.length; i++) {
				st = new StringTokenizer(bf.readLine());
				for (int j = 0; j < map[i].length; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			bfs(R, C, tc);
		}

	}

	private static void bfs(int r, int c, int tc) {
		Queue<int[]> q = new LinkedList<int[]>();
		q.offer(new int[] { r, c });
		boolean[][] v = new boolean[N][M];
		v[R][C] = true;
		int n = 1;
		int cnt = 1;

		while (!q.isEmpty() && n++ < L) {
			int size = q.size();
			for (int i = 0; i < size; i++) {
				int[] current = q.poll();
				for (int d = 0; d < dir[map[current[0]][current[1]]].length; d++) {
					int nd = dir[map[current[0]][current[1]]][d];
					int nr = current[0] + dx[nd];
					int nc = current[1] + dy[nd];
					if (nr >= 0 && nr < N && nc >= 0 && nc < M && !v[nr][nc] && map[nr][nc] != 0) {
						for (int d2 = 0; d2 < dir[map[nr][nc]].length; d2++) {
							if (dir[map[nr][nc]][d2] == (nd + 2) % 4) {
								v[nr][nc] = true;
								q.offer(new int[] { nr, nc });
								cnt++;
								break;
							}
						}
					}
				}
			}
		}

		System.out.println("#" + tc + " " + cnt);

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
