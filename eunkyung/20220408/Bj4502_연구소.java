package day17;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Bj4502_연구소 {
	static int N, M, cnt, max = 0;
	static int[][] map;
	static ArrayList<int[]> list = new ArrayList<int[]>();
	static ArrayList<int[]> virus = new ArrayList<int[]>();
	static int[] dx = { -1, 0, 1, 0 };
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
				if (map[i][j] == 0)
					list.add(new int[] { i, j });
				if (map[i][j] == 2)
					virus.add(new int[] { i, j });
			}
		}
		combination(new int[3], 0, 0);
		//print(map);

		System.out.println(max);
	}

	private static void combination(int[] sel, int idx, int k) {
		if (k == sel.length) {
			//System.out.println(Arrays.toString(sel));
			makewall(sel);
			return;
		}

		for (int i = idx; i < list.size(); i++) {
			sel[k] = i;
			combination(sel, i + 1, k + 1);
		}
	}

	private static void makewall(int[] sel) {
		// 벽 세우기
		for (int i = 0; i < sel.length; i++) {
			int[] current = list.get(sel[i]);
			map[current[0]][current[1]] = 1;
		}
		boolean[][] v = new boolean[N][M];
		cnt = 0;
		for (int i = 0; i < virus.size(); i++) {
			dfs(v, virus.get(i)[0], virus.get(i)[1]);
		}
		max = Math.max(max, list.size() - 3 - cnt);

		// 벽 없애기
		for (int i = 0; i < sel.length; i++) {
			int[] current = list.get(sel[i]);
			map[current[0]][current[1]] = 0;
		}
	}

	private static void dfs(boolean[][] v, int r, int c) {
		for (int d = 0; d < dx.length; d++) {
			int nr = r + dx[d];
			int nc = c + dy[d];
			if (nr >= 0 && nr < N && nc >= 0 && nc < M && !v[nr][nc] && map[nr][nc] == 0) {
				v[nr][nc] = true;
				cnt++;
				dfs(v, nr, nc);
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
