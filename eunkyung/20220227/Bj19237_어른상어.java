package day13;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class Bj19237_어른상어 {
	static class Point {
		int shark, num, smell;

		public Point() {

		}

		public Point(int shark, int num, int smell) {
			super();
			this.shark = shark;
			this.num = num;
			this.smell = smell;
		}
	}

	static class Shark implements Comparable<Shark> {
		int r, c, d, num;
		int[][] dir;

		public Shark(int r, int c, int num) {
			super();
			this.r = r;
			this.c = c;
			this.num = num;
			dir = new int[5][4];
		}

		@Override
		public int compareTo(Shark o) {
			return this.num - o.num;
		}
	}

	static int N, M, k;
	static int[] dx = { 0, -1, 1, 0, 0 };
	static int[] dy = { 0, 0, 0, -1, 1 };
	static Point[][] map;
	static ArrayList<Shark> shark = new ArrayList<>();

	public static void main(String[] args) throws IOException {
		System.setIn(new FileInputStream("src/day13/엄마상어.txt"));
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());
		map = new Point[N][N];

		for (int i = 0; i < map.length; i++) {
			st = new StringTokenizer(bf.readLine());
			for (int j = 0; j < map.length; j++) {
				int n = Integer.parseInt(st.nextToken());
				if (n != 0) {
					map[i][j] = new Point(n, n, k);
					shark.add(new Shark(i, j, n));
				} else
					map[i][j] = new Point();
			}
		}

		Collections.sort(shark);
		st = new StringTokenizer(bf.readLine());
		for (int i = 0; i < M; i++) {
			shark.get(i).d = Integer.parseInt(st.nextToken());
		}

		for (int i = 0; i < M; i++) {
			for (int j = 0; j < 4; j++) {
				st = new StringTokenizer(bf.readLine());
				for (int k = 0; k < 4; k++) {
					shark.get(i).dir[j + 1][k] = Integer.parseInt(st.nextToken());
				}
			}
		}

		int time = 0;
		while (true) {
			time++;
			sharkMoving();
			if (shark.size() == 1) {
				System.out.println(time);
				break;
			}
			if (time >= 1000) {
				System.out.println(-1);
				break;
			}
		}

	}

	private static void sharkMoving() {
		ArrayList<Shark> tmpshark = new ArrayList<>();

		for (int n = 0; n < shark.size(); n++) {
			Shark current = shark.get(n);
			boolean state = false;
			int[] save = new int[3];
			boolean flag = false;
			for (int nd = 0; nd < current.dir[current.d].length; nd++) {
				int nr = current.r + dx[current.dir[current.d][nd]];
				int nc = current.c + dy[current.dir[current.d][nd]];

				if (nr >= 0 && nr < N && nc >= 0 && nc < N) {
					if (map[nr][nc].smell == 0) {
						state = true;
						// 상어가 없거나 자기보다 큰 상어이면 잡아먹고 들어감
						if (map[nr][nc].shark == 0 || map[nr][nc].shark > current.num) {
							map[nr][nc].shark = current.num;
							current.r = nr;
							current.c = nc;
							current.d = current.dir[current.d][nd];
							tmpshark.add(current);
						}
						break;
					} else {
						if (map[nr][nc].num == current.num && !flag) {
							flag = true;
							save = new int[] { nr, nc, current.dir[current.d][nd] };
						}
					}
				}
			}
			if (!state) { // 갈곳 없으면 자기 냄새 위치로..
				current.r = save[0];
				current.c = save[1];
				current.d = save[2];
				tmpshark.add(current);
			}
		}
		shark.clear();
		shark.addAll(tmpshark);
		spraying();
		set();
	}

	private static void set() {
		for (int i = 0; i < shark.size(); i++) {
			Shark current = shark.get(i);
			map[current.r][current.c].num = current.num;
			map[current.r][current.c].smell = k;
			map[current.r][current.c].shark = current.num;
		}
	}

	private static void spraying() {
		for (int i = 0; i < map.length; i++) {
			for (int j = 0; j < map.length; j++) {
				if (map[i][j].smell > 0) {
					map[i][j].shark = 0;
					if (--map[i][j].smell == 0) {
						map[i][j].num = 0;
					}
				}
			}
		}
	}
}
