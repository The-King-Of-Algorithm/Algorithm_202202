package day18;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Bj20056_마법사상어와파이어볼 {
	static int N, M, K;
	static Ball[][] map;
	static int[] dx = { -1, -1, 0, 1, 1, 1, 0, -1 };
	static int[] dy = { 0, 1, 1, 1, 0, -1, -1, -1 };
	static ArrayList<Ball> ball = new ArrayList<>();

	static class Ball {
		int r, c, m, s, d, cnt, dir;

		public Ball(int r, int c, int m, int s, int d) {
			super();
			this.r = r;
			this.c = c;
			this.m = m;
			this.s = s;
			this.d = d;
		}

		@Override
		public String toString() {
			return "Ball [r=" + r + ", c=" + c + ", m=" + m + ", s=" + s + ", d=" + d + "]";
		}

	}

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());

		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(bf.readLine());
			int r = Integer.parseInt(st.nextToken()) - 1;
			int c = Integer.parseInt(st.nextToken()) - 1;
			int m = Integer.parseInt(st.nextToken());
			int s = Integer.parseInt(st.nextToken());
			int d = Integer.parseInt(st.nextToken());
			ball.add(new Ball(r, c, m, s, d));
		}

		for (int k = 0; k < K; k++) {
			//System.out.println(ball);
			fireballMove();
			//System.out.println(ball);
		}

		int sum = 0;
		for (int i = 0; i < ball.size(); i++) {
			sum += ball.get(i).m;
		}

		System.out.println(sum);

	}

	private static void fireballMove() {
		map = new Ball[N][N];
		ArrayList<Ball> tmp = new ArrayList<>();
		for (int i = 0; i < ball.size(); i++) {
			Ball current = ball.get(i);
			for (int s = 0; s < current.s; s++) {
				current.r += dx[current.d];
				current.c += dy[current.d];
				if (current.r < 0 || current.r >= N)
					current.r = (current.r + N) % N;
				if (current.c < 0 || current.c >= N)
					current.c = (current.c + N) % N;
			}

			//System.out.println(current.r + " " + current.c);
			if (map[current.r][current.c] == null) {
				//current.d = current.d % 2;
				map[current.r][current.c] = current;
				map[current.r][current.c].cnt = 1;
				//map[current.r][current.c].d = current.d % 2;
				map[current.r][current.c].dir = 0;

			} else {
				if (current.d % 2 != map[current.r][current.c].d % 2)
					map[current.r][current.c].dir = 1;
				map[current.r][current.c].m += current.m;
				map[current.r][current.c].s += current.s;
				map[current.r][current.c].cnt++;
			}
		}

		//print(map);
		for (int i = 0; i < map.length; i++) {
			for (int j = 0; j < map.length; j++) {
				if (map[i][j] != null) {
					if (map[i][j].cnt > 1 && map[i][j].m / 5 > 0) {
						for (int d = 0; d < dx.length; d++) {
							if (map[i][j].dir == d % 2) {
								tmp.add(new Ball(i, j, map[i][j].m / 5, map[i][j].s / map[i][j].cnt, d));
							}
						}
					} else if (map[i][j].cnt == 1 && map[i][j].m > 0) {
						tmp.add(new Ball(i, j, map[i][j].m, map[i][j].s, map[i][j].d));
					}
				}
			}
		}

		//System.out.println("tmp" + tmp);

		ball.clear();
		ball.addAll(tmp);
	}

	private static void print(Ball[][] map) {
		for (int i = 0; i < map.length; i++) {
			for (int j = 0; j < map.length; j++) {
				System.out.print(map[i][j] + " ");
			}
			System.out.println();
		}
		System.out.println();
	}
}
