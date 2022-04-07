package day16;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Bj2580_스도쿠 {
	static int[][] map;
	static ArrayList<int[]> list = new ArrayList<int[]>();
	static boolean state = false;

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		map = new int[9][9];
		for (int i = 0; i < map.length; i++) {
			StringTokenizer st = new StringTokenizer(bf.readLine());
			for (int j = 0; j < map.length; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if (map[i][j] == 0) {
					list.add(new int[] { i, j });
				}
			}
		}

		//print(map);
		recursive(map, 0);

	}

	private static void recursive(int[][] map, int idx) {
		if (idx == list.size()) {
			state = true;
			print(map);
			return;
		}

		if (!state) {
			int[] current = list.get(idx);
			for (int i = 1; i < 10; i++) {
				if (check(current[0], current[1], i)) {
					map[current[0]][current[1]] = i;
					recursive(map, idx + 1);
					map[current[0]][current[1]] = 0;
				}
			}
		}
	}

	private static boolean check(int r, int c, int num) {
		for (int i = 0; i < map[0].length; i++) {
			if (map[r][i] == num)
				return false;
		}
		for (int i = 0; i < map.length; i++) {
			if (map[i][c] == num)
				return false;
		}
		for (int i = r / 3 * 3; i < r / 3 * 3 + 3; i++) {
			for (int j = c / 3 * 3; j < c / 3 * 3 + 3; j++) {
				if (map[i][j] == num)
					return false;
			}
		}
		return true;
	}

	private static void print(int[][] map) {
		for (int i = 0; i < map.length; i++) {
			for (int j = 0; j < map[i].length; j++) {
				System.out.print(map[i][j] + " ");
			}
			System.out.println();
		}
		//System.out.println();
	}

}
