package day08;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Bj17144_미세먼지안녕 {

	static class Point {
		int r, c, w;

		public Point(int r, int c, int w) {
			super();
			this.r = r;
			this.c = c;
			this.w = w;
		}
	}

	static int[][] map;
	static int[] dx = { 0, -1, 0, 1 };
	static int[] dy = { 1, 0, -1, 0 };
	static int[][] dir = { { 0, 1, 2, 3 }, { 0, 3, 2, 1 } };
	static int R, C, T;

	public static void main(String[] args) throws IOException {
		//System.setIn(new FileInputStream("src/day08/미세먼지.txt"));
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		T = Integer.parseInt(st.nextToken());
		map = new int[R][C];
		int airx = 0;
		int airy = 0;
		boolean state = false;
		for (int i = 0; i < map.length; i++) {
			st = new StringTokenizer(bf.readLine());
			for (int j = 0; j < map[i].length; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if (map[i][j] == -1 && !state) {
					airx = i;
					airy = j;
					state = true;
				}
			}
		}

		for (int t = 0; t < T; t++) {
			diffusion();
			rotation(airx, airy);
		}

		int total = 0;
		for (int i = 0; i < map.length; i++) {
			for (int j = 0; j < map[i].length; j++) {
				if (map[i][j] > 0) {
					total += map[i][j];
				}
			}
		}
		System.out.println(total);
	}

	private static void rotation(int airx, int airy) {
		int[][] tmp = new int[R][C];
		boolean[][] v = new boolean[R][C];
		int r = airx;
		int c = airy;

		for (int cnt = 0; cnt < 2; cnt++) {
			outer: for (int d = 0; d < dir[cnt].length; d++) {
				while (true) {
					int nr = airx + dx[dir[cnt][d]];
					int nc = airy + dy[dir[cnt][d]];
					if (nr >= 0 && nr < R && nc >= 0 && nc < C && !v[nr][nc]) {
						if (map[nr][nc] == -1) {
							break outer;
						}
						if (map[airx][airy] != -1) {
							tmp[nr][nc] = map[airx][airy];
						}
						airx = nr;
						airy = nc;
						v[nr][nc] = true;
					} else
						break;
				}
			}
			airx = r + 1;
			airy = c;
		}
		for (int i = 0; i < map.length; i++) {
			for (int j = 0; j < map[i].length; j++) {
				if (v[i][j] && map[i][j] != -1)
					map[i][j] = tmp[i][j];
			}
		}
	}

	private static void diffusion() {
		int[][] tmp = new int[R][C];
		ArrayList<Point> point = new ArrayList<>();

		for (int i = 0; i < tmp.length; i++) {
			for (int j = 0; j < tmp[i].length; j++) {
				if (map[i][j] > 0) {
					point.add(new Point(i, j, map[i][j]));
				}
			}
		}

		for (int i = 0; i < point.size(); i++) {
			Point current = point.get(i);
			Queue<Point> q = new LinkedList<>();
			for (int d = 0; d < dx.length; d++) {
				int nr = current.r + dx[d];
				int nc = current.c + dy[d];

				if (nr >= 0 && nr < R && nc >= 0 && nc < C && map[nr][nc] != -1) {
					q.offer(new Point(nr, nc, tmp[nr][nc]));
				}
			}

			int c = map[current.r][current.c] / 5;
			tmp[current.r][current.c] += map[current.r][current.c] - c * q.size();
			while (!q.isEmpty()) {
				Point p = q.poll();
				tmp[p.r][p.c] += c;
			}
		}
		for (int i = 0; i < map.length; i++) {
			for (int j = 0; j < map[i].length; j++) {
				if (map[i][j] != -1)
					map[i][j] = tmp[i][j];
			}
		}
	}
}
