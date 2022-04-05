package day16;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Bj17136_색종이붙이기 {
	static int[] paper = { 0, 5, 5, 5, 5, 5 };
	static int[][] map = new int[10][10];
	static int min = Integer.MAX_VALUE;

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		for (int i = 0; i < map.length; i++) {
			StringTokenizer st = new StringTokenizer(bf.readLine());
			for (int j = 0; j < map.length; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		//print(map);
		searchPoint(0);
		System.out.println(min == Integer.MAX_VALUE ? -1 : min);

	}

	private static void searchPoint(int cnt) {
		int sr = -1;
		int sc = -1;
		for (int i = 0; i < map.length; i++) {
			for (int j = 0; j < map.length; j++) {
				if (map[i][j] == 1) {
					sr = i;
					sc = j;
					solve(i, j, cnt);
					return;
				}
			}
		}
		if (sr == -1 && sc == -1) {
			min = Math.min(min, cnt);
			return;
		}
	}

	private static void solve(int r, int c, int cnt) {
		int size = getSize(r, c);

		for (int s = 1; s <= size; s++) {
			if (paper[s] > 0) {
				paper[s]--;
				for (int i = r; i < r + s; i++) {
					for (int j = c; j < c + s; j++) {
						map[i][j] = 0;
					}
				}

				searchPoint(cnt + 1);

				paper[s]++;
				for (int i = r; i < r + s; i++) {
					for (int j = c; j < c + s; j++) {
						map[i][j] = 1;
					}
				}
			}
		}

	}

	private static int getSize(int r, int c) {
		int size = 6;
		while (--size > 1) {
			boolean state = true;
			L: for (int i = r; i < r + size; i++) {
				for (int j = c; j < c + size; j++) {
					if (i < 0 || i >= 10 || j < 0 || j >= 10 || map[i][j] == 0) {
						state = false;
						break L;
					}
				}
			}
			if (state) {
				return size;
			}
		}
		return size;
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
