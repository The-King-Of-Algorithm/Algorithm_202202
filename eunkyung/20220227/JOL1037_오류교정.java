package day13;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class JOL1037_오류교정 {
	static int[][] map, check;
	static boolean[][] v, v_c;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(bf.readLine());
		map = new int[N][N];
		check = new int[2][N];
		v = new boolean[N][N];
		v_c = new boolean[2][N];

		for (int i = 0; i < map.length; i++) {
			StringTokenizer st = new StringTokenizer(bf.readLine());
			for (int j = 0; j < map.length; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if (map[i][j] == 1) {
					check[0][i]++;
					check[1][j]++;
				}
			}
		}

		if (!operation()) {
			for (int i = 0; i < map.length; i++) {
				if (v_c[0][i]) {
					for (int j = 0; j < map.length; j++) {
						v[i][j] = true;
					}
				}
				if (v_c[1][i]) {
					for (int j = 0; j < map.length; j++) {
						v[j][i] = true;

					}
				}
			}

			for (int i = 0; i < map.length; i++) {
				for (int j = 0; j < map.length; j++) {
					if (!v[i][j]) {
						if (~map[i][j] == 1) {
							check[0][i]++;
							check[1][j]++;
							if (operation()) {
								System.out.println("Change bit (" + (i + 1) + "," + (j + 1) + ")");
								return;
							}
							check[0][i]--;
							check[1][j]--;
						} else {
							check[0][i]--;
							check[1][j]--;
							if (operation()) {
								System.out.println("Change bit (" + (i + 1) + "," + (j + 1) + ")");
								return;
							}
							check[0][i]++;
							check[1][j]++;
						}
					}
				}
			}
			System.out.println("Corrupt");
			return;
		}
		System.out.println("OK");
	}

	private static boolean operation() {
		boolean state = true;

		for (int i = 0; i < check.length; i++) {
			for (int j = 0; j < check[i].length; j++) {
				if (check[i][j] % 2 == 0) {// 짝수
					v_c[i][j] = true;
				} else {
					state = false;
				}
			}
		}
		if (state) {
			return true;
		}
		return false;
	}
}
