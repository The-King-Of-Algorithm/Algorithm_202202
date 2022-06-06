package day21;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Bj2638_치즈 {
	static int N, M;
	static int[][] map;
	static boolean state = true;
	static int[] dx = { -1, 0, 1, 0 };
	static int[] dy = { 0, 1, 0, -1 };

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new int[N][M];

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(bf.readLine());
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
//		print(map);

		int cnt = 0;
		while (state) {
			state = false;
			bfs();
			if (state) {
//				System.out.println("트루");
				malt();
				reset(); // 다시 돌려놔
				cnt++;
//				print(map);
			}
		}

		System.out.println(cnt);

	}

	private static void reset() {
		for (int i = 0; i < map.length; i++) {
			for (int j = 0; j < map[i].length; j++) {
				if (map[i][j] != 0) {
					map[i][j] = 1;
				}
			}
		}
	}

	private static void malt() {
		for (int i = 0; i < map.length; i++) {
			for (int j = 0; j < map[i].length; j++) {
				if (map[i][j] > 2) {
					map[i][j] = 0;
				}
			}
		}
	}

	private static void bfs() {
		Queue<int[]> q = new LinkedList<int[]>();
		boolean[][] v = new boolean[N][M];
		q.offer(new int[] { 0, 0 });

		while (!q.isEmpty()) {
			int[] current = q.poll();
			for (int d = 0; d < dx.length; d++) {
				int nr = current[0] + dx[d];
				int nc = current[1] + dy[d];
				if (nr >= 0 && nr < N && nc >= 0 && nc < M) {
					if (map[nr][nc] != 0) {
//						System.out.println(nr + " " + nc);
						state = true;
						map[nr][nc]++;
					}
					if (map[nr][nc] == 0 && !v[nr][nc]) {
						v[nr][nc] = true;
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
