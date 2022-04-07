package day17;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class SW1249_보급로 {
	static int N;
	static int[][] map, tmp;
	static int[] dx = { -1, 0, 1, 0 };
	static int[] dy = { 0, 1, 0, -1 };

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(bf.readLine());
		for (int tc = 1; tc <= T; tc++) {
			N = Integer.parseInt(bf.readLine());
			map = new int[N][N];
			tmp = new int[N][N];

			for (int i = 0; i < map.length; i++) {
				String str = bf.readLine();
				for (int j = 0; j < map.length; j++) {
					map[i][j] = str.charAt(j) - '0';
				}
			}

			for (int i = 0; i < tmp.length; i++) {
				Arrays.fill(tmp[i], Integer.MAX_VALUE);
			}
			bfs();
			System.out.println("#" + tc + " " + tmp[N - 1][N - 1]);
		}
	}

	private static void bfs() {
		Queue<int[]> q = new LinkedList<int[]>();
		q.offer(new int[] { 0, 0 });
		tmp[0][0] = 0;

		while (!q.isEmpty()) {
			int[] point = q.poll();
			for (int d = 0; d < dx.length; d++) {
				int nr = point[0] + dx[d];
				int nc = point[1] + dy[d];
				if (nr >= 0 && nr < N && nc >= 0 && nc < N) {
					if (tmp[nr][nc] > tmp[point[0]][point[1]] + map[nr][nc]) {
						tmp[nr][nc] = tmp[point[0]][point[1]] + map[nr][nc];
						q.offer(new int[] { nr, nc });
					}
				}
			}
		}
	}

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
