package day17;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Bj17141_연구소2 {
	static int N, M, zero = 0, min = 9999999;
	static int[][] map;
	static int[] dx = { -1, 0, 1, 0 };
	static int[] dy = { 0, 1, 0, -1 };

	static ArrayList<int[]> virus = new ArrayList<int[]>();

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new int[N][N];
		for (int i = 0; i < map.length; i++) {
			st = new StringTokenizer(bf.readLine());
			for (int j = 0; j < map[i].length; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if (map[i][j] == 2)
					virus.add(new int[] { i, j });
				if (map[i][j] != 1)
					zero++;
			}
		}
		//print(map);
		combination(new int[M], 0, 0);
		System.out.println(min != 9999999 ? min : -1);
	}

	private static void combination(int[] sel, int k, int idx) {
		if (k == sel.length) {
			//System.out.println(Arrays.toString(sel));
			diffusion(sel);
			return;
		}
		for (int i = idx; i < virus.size(); i++) {
			sel[k] = i;
			combination(sel, k + 1, i + 1);
		}
	}

	private static void diffusion(int[] sel) {
		Queue<int[]> q = new LinkedList<int[]>();
		boolean[][] v = new boolean[N][N];
		for (int i = 0; i < sel.length; i++) {
			int[] current = virus.get(sel[i]);
			map[current[0]][current[1]] = -1;
			q.add(new int[] { current[0], current[1] });
			v[current[0]][current[1]] = true;
		}
		int[] cnt = bfs(q, v, 0);
		if (zero - M == cnt[0]) {
			min = Math.min(min, cnt[1]);
		}

		for (int i = 0; i < sel.length; i++) {
			map[virus.get(sel[i])[0]][virus.get(sel[i])[1]] = 2;
		}
	}

	private static int[] bfs(Queue<int[]> q, boolean[][] v, int cnt) {
		int n = 0;
		while (!q.isEmpty()) {
			int size = q.size();
			n++;
			for (int i = 0; i < size; i++) {
				int[] current = q.poll();
				for (int d = 0; d < dx.length; d++) {
					int nr = current[0] + dx[d];
					int nc = current[1] + dy[d];
					if (nr >= 0 && nr < N && nc >= 0 && nc < N && map[nr][nc] != 1 && map[nr][nc] != -1 && !v[nr][nc]) {
						v[nr][nc] = true;
						q.offer(new int[] { nr, nc });
						cnt++;
					}
				}
			}
		}
		return new int[] { cnt, n-1 };
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
