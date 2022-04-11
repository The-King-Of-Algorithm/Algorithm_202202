package day18;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class Bj19238_스타트택시 {
	static int N, M, K, r, c;
	static int[][] map;
	static Point[][] smap;
	static int[] dx = { -1, 0, 1, 0 };
	static int[] dy = { 0, 1, 0, -1 };

	static class Point implements Comparable<Point> {
		int r, c, dr, dc, d;

		public Point(int r, int c, int dr, int dc, int d) {
			super();
			this.r = r;
			this.c = c;
			this.dr = dr;
			this.dc = dc;
			this.d = d;
		}

		@Override
		public String toString() {
			return "Point [r=" + r + ", c=" + c + ", dr=" + dr + ", dc=" + dc + ", d=" + d + "]";
		}

		@Override
		public int compareTo(Point o) {
			if (this.r == o.r) {
				return this.c - o.c;
			}
			return this.r - o.r;
		}

	}

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		map = new int[N][N];
		smap = new Point[N][N];

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(bf.readLine());
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		st = new StringTokenizer(bf.readLine());
		r = Integer.parseInt(st.nextToken()) - 1;
		c = Integer.parseInt(st.nextToken()) - 1;

		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(bf.readLine());
			int sr = Integer.parseInt(st.nextToken()) - 1;
			int sc = Integer.parseInt(st.nextToken()) - 1;
			int dr = Integer.parseInt(st.nextToken()) - 1;
			int dc = Integer.parseInt(st.nextToken()) - 1;
			smap[sr][sc] = new Point(sr, sc, dr, dc, 0);
		}

		int cnt = 0;
		while (true) {
			//System.out.println(K);
			Point num = bfs(r, c, -1, -1);
			//System.out.println(num);
			if (num != null) {
				cnt++;
				//System.out.println(K);
				Point num2 = bfs(num.r, num.c, num.dr, num.dc);
				smap[num.r][num.c] = null;
				if (num2 != null) {
					System.out.println(num2);
					r = num2.r;
					c = num2.c;
				} else
					break;
			} else
				break;
			// print(map);
		}
		if (cnt == M)
			System.out.println(K);
		else {
			System.out.println(-1);
		}
	}

	private static Point bfs(int r, int c, int dr, int dc) {
		Queue<Point> q = new LinkedList<>();
		PriorityQueue<Point> pq = new PriorityQueue<>();
		boolean[][] v = new boolean[N][N];
		q.offer(new Point(r, c, 0, 0, 0));
		if (dr == -1 && smap[r][c] != null)
			pq.offer(new Point(r, c, smap[r][c].dr, smap[r][c].dc, 0));
		v[r][c] = true;

		while (!q.isEmpty()) {
			int size = q.size();
			if (!pq.isEmpty()) {
				Point current = pq.poll();
				if (K - current.d > 0) {
					//System.out.println("##");
					K -= current.d;
					return current;
				}
				K = -1;
				return null;
			}
			for (int i = 0; i < size; i++) {

				Point current = q.poll();
				for (int d = 0; d < dx.length; d++) {
					int nr = current.r + dx[d];
					int nc = current.c + dy[d];
					if (nr >= 0 && nr < N && nc >= 0 && nc < N && !v[nr][nc] && map[nr][nc] != 1) {
						v[nr][nc] = true;
						q.offer(new Point(nr, nc, 0, 0, current.d + 1));
						if (dr == -1 && smap[nr][nc] != null)
							pq.offer(new Point(nr, nc, smap[nr][nc].dr, smap[nr][nc].dc, current.d + 1));
						if (dr == nr && dc == nc) {
							//System.out.println("설마");
							if (K - (current.d + 1) >= 0) {
								K += current.d + 1;
								//System.out.println("여기");
								return new Point(nr, nc, 0, 0, current.d + 1);
							}
							K = -1;
							return null;
						}
					}

				}
			}
		}
		return null;

	}

	private static void print(int[][] map) {
		for (int i = 0; i < map.length; i++) {
			for (int j = 0; j < map.length; j++) {
				System.out.print(map[i][j] + " ");
			}
			System.out.println();
		}
		System.out.println();
	}

}
