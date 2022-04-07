package day17;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Bj4485_녹색옷입은애가젤다지 {
	static int N;
	static int[][] map, tmp;
	static int[] dx = { -1, 0, 1, 0 };
	static int[] dy = { 0, 1, 0, -1 };

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		int tc = 1;
		while (true) {
			N = Integer.parseInt(bf.readLine());
			if (N == 0)
				return;

			map = new int[N][N];
			tmp = new int[N][N];

			for (int i = 0; i < map.length; i++) {
				StringTokenizer st = new StringTokenizer(bf.readLine());
				for (int j = 0; j < map.length; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			for (int i = 0; i < tmp.length; i++) {
				Arrays.fill(tmp[i], Integer.MAX_VALUE);
			}
			//print(map);

			bfs();
			System.out.println("Problem " + tc++ + ": " + tmp[N - 1][N - 1]);
		}

	}

	private static void bfs() {
		Queue<int[]> q = new LinkedList<int[]>();
		q.offer(new int[] { 0, 0 });
		tmp[0][0] = map[0][0];

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
