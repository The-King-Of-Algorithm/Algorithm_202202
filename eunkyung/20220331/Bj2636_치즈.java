package day15;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

import day15.Bj2234_성곽.Wall;

public class Bj2636_치즈 {
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
			bfs(0, 0);
			++cnt;
			if (count(map) == 0) {
				break;
			}
		}
		System.out.println(cnt);
		System.out.println(sum);
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

	private static void bfs(int r, int c) {
		Queue<int[]> q = new LinkedList<int[]>();
		boolean[][] v = new boolean[N][M];
		v[r][c] = true;
		q.offer(new int[] { r, c });

		while (!q.isEmpty()) {
			int[] point = q.poll();
			for (int d = 0; d < dx.length; d++) {
				int nr = point[0] + dx[d];
				int nc = point[1] + dy[d];
				if (nr >= 0 && nr < N && nc >= 0 && nc < M && !v[nr][nc]) {
					if (map[nr][nc] == 0) {
						v[nr][nc] = true;
						q.offer(new int[] { nr, nc });
					} else {
						map[nr][nc] = 0;
						v[nr][nc] = true;
					}
				}
			}
		}
	}
}
