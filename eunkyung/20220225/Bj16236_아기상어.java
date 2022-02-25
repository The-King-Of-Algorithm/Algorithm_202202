package day08;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Bj16236_아기상어 {
	static int[] dx = { 0, 1, 0, -1 };
	static int[] dy = { 1, 0, -1, 0 };

	static class Fish implements Comparable<Fish> {
		int r, c, w, dist;

		public Fish(int r, int c, int w, int dist) {
			super();
			this.r = r;
			this.c = c;
			this.w = w;
			this.dist = dist;
		}

		public Fish() {
		}

		@Override
		public int compareTo(Fish o) {
			if (this.dist == o.dist) {
				if (this.r == o.r) {
					return this.c - o.c;
				} else
					return this.r - o.r;
			} else
				return this.dist - o.dist;
		}

	}

	static ArrayList<Fish> fish = new ArrayList<>();
	static Fish shark = new Fish();
	static int time = 0, N;
	static int[][] map;

	public static void main(String[] args) throws RuntimeException, IOException {
		//System.setIn(new FileInputStream("src/day08/아기상어.txt"));
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(bf.readLine());
		map = new int[N][N];

		for (int i = 0; i < map.length; i++) {
			StringTokenizer st = new StringTokenizer(bf.readLine());
			for (int j = 0; j < map.length; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if (map[i][j] == 9) {
					shark = new Fish(i, j, 2, 0);
					map[i][j] = 0;
				}
			}
		}
		int cnt = 0;
		while (true) {
			distance(shark.r, shark.c);
			if (fish.isEmpty())
				break;

			for (int i = 0; i < fish.size(); i++) {
				if (fish.get(i).w < shark.w) {
					Fish current = fish.get(i);
					shark.r = current.r;
					shark.c = current.c;
					map[current.r][current.c] = 0;
					time += current.dist;
					if (++cnt == shark.w) {
						shark.w++;
						cnt = 0;
					}
					break;
				}
			}
		}
		System.out.println(time);
	}

	private static void distance(int r, int c) {
		Queue<int[]> q = new LinkedList<>();
		boolean[][] v = new boolean[N][N];
		fish = new ArrayList<>();
		q.offer(new int[] { r, c });
		v[r][c] = true;
		int n = 0;

		while (!q.isEmpty()) {
			int size = q.size();
			n++;
			for (int i = 0; i < size; i++) {
				int[] current = q.poll();
				for (int d = 0; d < dx.length; d++) {
					int nr = current[0] + dx[d];
					int nc = current[1] + dy[d];
					if (nr >= 0 && nr < N && nc >= 0 && nc < N && !v[nr][nc] && map[nr][nc] <= shark.w) {
						q.offer(new int[] { nr, nc });
						v[nr][nc] = true;
						if (map[nr][nc] != 0 && map[nr][nc] != shark.w) {
							fish.add(new Fish(nr, nc, map[nr][nc], n));
						}
					}
				}
			}
		}
		Collections.sort(fish);
	}

	private static void print(int[][] map) {
		for (int i = 0; i < map.length; i++) {
			for (int j = 0; j < map.length; j++) {
				System.out.print(map[i][j] + " ");
			}
			System.out.println();
		}
	}
}
