package IM기출;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class sol11_로봇이동거리 {

	// 우 좌 상 하
	static int[] dr = { 0, 0, -1, 1 };
	static int[] dc = { 1, -1, 0, 0 };

	public static void main(String[] args) throws FileNotFoundException {
		System.setIn(new FileInputStream("Solution11.txt"));
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();

		for (int tc = 1; tc <= T; tc++) {
			int N = sc.nextInt();
			String[][] map = new String[N][N];
			int cnt = 0;

			for (int r = 0; r < map.length; r++) {
				for (int c = 0; c < map[r].length; c++) {
					map[r][c] = sc.next();
				}
			}

			for (int r = 0; r < map.length; r++) {
				for (int c = 0; c < map[r].length; c++) {
					if (map[r][c].equals("A")) {
						int a = 1;
						while (true) {
							int nr = r + dr[0] * a;
							int nc = c + dc[0] * a;
							if (nr < 0 || nr >= N || nc < 0 || nc >= N || !map[nr][nc].equals("S")) {
								break;
							}
							cnt++;
							a++;
						}
					} else if (map[r][c].equals("B")) {
						for (int d = 0; d < 2; d++) {
							int a = 1;
							while (true) {
								int nr = r + dr[d] * a;
								int nc = c + dc[d] * a;
								if (nr < 0 || nr >= N || nc < 0 || nc >= N || !map[nr][nc].equals("S")) {
									break;
								} else {
									cnt++;
									a++;
								}
							}
						}
					} else if (map[r][c].equals("C")) {
						for (int d = 0; d < 4; d++) {
							int a = 1;
							while (true) {
								int nr = r + dr[d] * a;
								int nc = c + dc[d] * a;
								if (nr < 0 || nr >= N || nc < 0 || nc >= N || !map[nr][nc].equals("S")) {
									break;
								} else {
									cnt++;
									a++;
								}
							}
						}
					}
				}
			}

			System.out.printf("#%d %d\n", tc, cnt);
		}

	}

}
