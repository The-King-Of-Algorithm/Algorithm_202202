package day06;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 점프사방 {
	static int[] dx = { 0, 0, 1, 0, -1 };
	static int[] dy = { 0, 1, 0, -1, 0 };

	static public class Person {
		int r;
		int c;
		int cnt;

		public Person(int r, int c, int cnt) {
			super();
			this.r = r;
			this.c = c;
			this.cnt = cnt;
		}

		@Override
		public String toString() {
			return "people [r=" + r + ", c=" + c + ", cnt=" + cnt + "]";
		}

	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		System.setIn(new FileInputStream("src/day06/점프사방.txt"));
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(bf.readLine());

		for (int tc = 1; tc <= T; tc++) {
			StringTokenizer st = new StringTokenizer(bf.readLine());
			int X = Integer.parseInt(st.nextToken());
			int Y = Integer.parseInt(st.nextToken());
			int N = Integer.parseInt(st.nextToken());
			int[][] map = new int[X][Y];
			Person[] p = new Person[N];

			for (int i = 0; i < map.length; i++) {
				st = new StringTokenizer(bf.readLine());
				for (int j = 0; j < map[i].length; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}

			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(bf.readLine());
				int r = Integer.parseInt(st.nextToken());
				int c = Integer.parseInt(st.nextToken());
				int n = Integer.parseInt(st.nextToken());
				p[i] = new Person(r - 1, c - 1, n);
			}

			st = new StringTokenizer(bf.readLine());
			int TN = Integer.parseInt(st.nextToken());
			for (int i = 0; i < TN; i++) {
				int r = Integer.parseInt(st.nextToken());
				int c = Integer.parseInt(st.nextToken());
				map[r - 1][c - 1] = 0;
			}
			
			int sum = 0;
			for (int i = 0; i < p.length; i++) {
				boolean state = true;
				for (int j = 0; j < p[i].cnt; j++) {
					String str = Integer.toString(map[p[i].r][p[i].c]);
					int d = str.charAt(0) - '0';
					int count = str.charAt(1) - '0';
					int nr = p[i].r + dx[d] * count;
					int nc = p[i].c + dy[d] * count;
					if (nr >= 0 && nc < X && nc >= 0 && nc < Y && map[nr][nc] != 0) {
						p[i].r = nr;
						p[i].c = nc;
					} else {
						sum -= 1000;
						state = false;
						break;
					}
				}
				if (state) {
					sum += map[p[i].r][p[i].c] * 100 - 1000;
				}
			}

			System.out.println("#" + tc + " " + sum);

		}
	}
}
