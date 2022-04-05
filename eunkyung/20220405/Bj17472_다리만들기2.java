package day16;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Bj17472_다리만들기2 {
	static class Edge implements Comparable<Edge> {
		int s, e, w;

		public Edge(int s, int e, int w) {
			super();
			this.s = s;
			this.e = e;
			this.w = w;
		}

		@Override
		public int compareTo(Edge o) {
			return this.w - o.w;
		}

	}

	static int N, M;
	static int[][] map;
	static int[] dx = { -1, 0, 1, 0 };
	static int[] dy = { 0, 1, 0, -1 };
	static boolean[][] v;
	static int[] dist, parent;
	static ArrayList<ArrayList<int[]>> list = new ArrayList<ArrayList<int[]>>();
	static PriorityQueue<Edge> pq = new PriorityQueue<Edge>();

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		map = new int[N][M];
		v = new boolean[N][M];
		list.add(null);
		for (int i = 0; i < map.length; i++) {
			st = new StringTokenizer(bf.readLine());
			for (int j = 0; j < map[i].length; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		int cnt = 1;
		for (int i = 0; i < map.length; i++) {
			for (int j = 0; j < map[i].length; j++) {
				if (map[i][j] == 1 && !v[i][j]) {
					v[i][j] = true;
					map[i][j] = cnt;
					ArrayList<int[]> tmp = new ArrayList<int[]>();
					dfs(i, j, cnt++, tmp);
					list.add(tmp);
				}
			}

		}

		makeset(cnt);

		for (int i = 1; i < list.size(); i++) {
			operation(list.get(i));
		}

		int count = 0;
		int sum = 0;
		while (!pq.isEmpty()) {
			Edge current = pq.poll();
			if (findset(current.s) != findset(current.e)) {
				parent[findset(current.e)] = findset(current.s);
				sum += current.w;
				count++;
			}
			if (count == cnt - 2) {
				System.out.println(sum > 0 ? sum : -1);
				return;
			}
		}
		System.out.println(-1);
	}

	private static void makeset(int cnt) {
		parent = new int[cnt];
		for (int i = 1; i < parent.length; i++) {
			parent[i] = i;
		}
	}

	private static void operation(ArrayList<int[]> arrayList) {
		for (int i = 0; i < arrayList.size(); i++) {
			int[] point = arrayList.get(i);
			for (int d = 0; d < dx.length; d++) {
				int n = 1;
				while (true) {
					int nr = point[0] + dx[d] * n;
					int nc = point[1] + dy[d] * n;
					if (nr >= 0 && nr < N && nc >= 0 && nc < M && map[nr][nc] != point[2]) {
						if (map[nr][nc] == 0)
							++n;
						else {
							if (n - 1 > 1)
								pq.add(new Edge(point[2], map[nr][nc], n - 1));
							break;
						}
					} else {
						break;
					}
				}
			}
		}
	}

	private static int findset(int c) {
		if (parent[c] == c)
			return c;
		return parent[c] = findset(parent[c]);
	}

	private static void dfs(int r, int c, int cnt, ArrayList<int[]> tmp) {
		tmp.add(new int[] { r, c, cnt });
		for (int d = 0; d < dx.length; d++) {
			int nr = r + dx[d];
			int nc = c + dy[d];
			if (nr >= 0 && nr < N && nc >= 0 && nc < M && map[nr][nc] == 1 && !v[nr][nc]) {
				map[nr][nc] = cnt;
				v[nr][nc] = true;
				dfs(nr, nc, cnt, tmp);
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
