package day20;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Bj15684_사다리조작 {
	static int N, M, H;
	static boolean[][] map;
	static ArrayList<int[]> list = new ArrayList<int[]>();
	static int[][] dir = { { 0, -1 }, { 0, 1 } };
	static int Ans = -1;

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		H = Integer.parseInt(st.nextToken());
		map = new boolean[H + 1][N + 2];

		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(bf.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			map[a][b] = true;
		}

		for (int i = 1; i < map.length; i++) {
			for (int j = 1; j < map[i].length-1; j++) {
				if (!map[i][j])
					list.add(new int[] { i, j });
			}
		}

		for (int i = 0; i <= 3; i++) {
			combination(0, 0, new int[i]);
		}
		System.out.println(Ans);

	}

	private static void combination(int index, int k, int[] sel) {
		if (Ans != -1)
			return;
		if (k == sel.length) {
			backtracking(sel);
			return;
		}
		for (int i = index; i < list.size(); i++) {
			sel[k] = i;
			combination(i + 1, k + 1, sel);
		}
	}

	private static void backtracking(int[] sel) {
		boolean state = true;
		for (int i = 0; i < sel.length; i++) {
			int r = list.get(sel[i])[0];
			int c = list.get(sel[i])[1];
			map[r][c] = true;
			// 양옆이 있으면 안하고..
			for (int d = 0; d < dir.length; d++) {
				if (r + dir[d][0] >= 1 && r + dir[d][0] <= H && c + dir[d][1] >= 1 && c + dir[d][1] <= N) {
					if (map[r + dir[d][0]][c + dir[d][1]]) state = false;
				}
			}
		}
		if (state) {
			//print(map);
			if (operation(map))
				Ans = sel.length;
		}

		// 백트래킹
		for (int i = 0; i < sel.length; i++) {
			map[list.get(sel[i])[0]][list.get(sel[i])[1]] = false;
		}
	}

	private static boolean operation(boolean[][] map) {
		for (int n = 1; n < map[0].length; n++) {// 열마다 사다리타기
			int c = n;
			int r = 1;
			while (r <= H) {
				//System.out.println(r+"  "+c);
				if (map[r][c]) c++;
				else if (c - 1 >= 1 && map[r][c - 1]) c--;
				r++;
			}
			if (c != n) return false;
		}
		return true;
	}

	private static void print(boolean[][] map2) {
		for (int i = 1; i < map2.length; i++) {
			for (int j = 1; j < map2[i].length-1; j++) {
				System.out.print(map2[i][j] + " ");
			}
			System.out.println();
		}
		System.out.println();
	}
}
