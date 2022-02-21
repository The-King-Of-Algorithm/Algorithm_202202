package IM기출;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class sol32_점프사방 {

	// 우 하 좌 상
	static int[] dr = { 0, 1, 0, -1 };
	static int[] dc = { 1, 0, -1, 0 };

	public static void main(String[] args) throws FileNotFoundException {
		System.setIn(new FileInputStream("Solution32.txt"));
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();

		for (int tc = 1; tc <= T; tc++) {
			int Y = sc.nextInt() + 1;
			int X = sc.nextInt() + 1;
			int N = sc.nextInt(); // 참가자 수
			String[][] map = new String[Y][X];
			int[][] start = new int[N][3]; // 참가자 시작위치, 횟수 0 : 행, 1 : 열, 2: 횟수
			int sum = N * -1000;

			// 숫자판 정보
			for (int r = 1; r < map.length; r++) {
				for (int c = 1; c < map[r].length; c++) {
					map[r][c] = sc.next();
				}
			}
			// 참가자 시작위치 & 횟수
			for (int n = 0; n < N; n++) {
				start[n][0] = sc.nextInt(); // 행
				start[n][1] = sc.nextInt(); // 열
				start[n][2] = sc.nextInt();
			}

			int trap = sc.nextInt(); // 함정 수
			for (int t = 0; t < trap; t++) {
				int r = sc.nextInt();
				int c = sc.nextInt();
				map[r][c] = "0";
			}

			// 참가자 수만큼 반복
			for (int n = 0; n < N; n++) {
				int r = start[n][0];
				int c = start[n][1];
				boolean flag = false;
				// 참가자 점프횟수만큼 반복
				for (int k = 0; k < start[n][2]; k++) {
					int dir = map[r][c].charAt(0) - '0' - 1; // 방향
					int move = map[r][c].charAt(1) - '0'; // 점프칸수
					int nr = r + dr[dir] * move;
					int nc = c + dc[dir] * move;
					if (nr < 1 || nr >= Y || nc < 1 || nc >= X || map[nr][nc].equals("0")) {
						flag = true;
						break;
					} else {
						r = nr;
						c = nc;
					}
				}
				if(!flag) sum += Integer.parseInt(map[r][c]) * 100;
			}

			System.out.printf("#%d %d\n", tc, sum);
		}
	}

}
