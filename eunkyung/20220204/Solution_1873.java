package hw_20220204;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
//상호의 배들필드
public class Solution_1873 {
	public static int[] dx = { -1, 1, 0, 0 };
	public static int[] dy = { 0, 0, -1, 1 };
	public static int r, c, move, H, W;
	public static char[] allow = { '^', 'v', '<', '>' };
	public static char[][] map;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int T = Integer.parseInt(br.readLine());

		for (int test_case = 1; test_case <= T; test_case++) {
			st = new StringTokenizer(br.readLine());
			H = Integer.parseInt(st.nextToken());
			W = Integer.parseInt(st.nextToken());
			map = new char[H][W];

			for (int i = 0; i < H; i++) { //맵을 입력받고 전차의 위치를 구함
				String str = br.readLine();
				for (int j = 0; j < W; j++) {
					map[i][j] = str.charAt(j);
					if (map[i][j] == allow[0]) {
						move = 0;
						r = i;
						c = j;
					} else if (map[i][j] == allow[1]) {
						move = 1;
						r = i;
						c = j;
					} else if (map[i][j] == allow[2]) {
						move = 2;
						r = i;
						c = j;
					} else if (map[i][j] == allow[3]) {
						move = 3;
						r = i;
						c = j;
					}
				}
			}

			int N = Integer.parseInt(br.readLine());
			String str = br.readLine();
			for (int i = 0; i < N; i++) {
				char C = str.charAt(i);
				switch (C) {
				case 'U':
					load(0);
					break;
				case 'D':
					load(1);
					break;
				case 'L':
					load(2);
					break;
				case 'R':
					load(3);
					break;
				case 'S':
					shoot();
					break;
				}
			}
			System.out.print("#" + test_case + " ");
			printMap();

		}
	}

	private static void load(int d) { //입력받은 move값으로 이동
		move = d;
		map[r][c] = allow[move]; //전차 방향 표시 바꿈
		r = r + dx[move];
		c = c + dy[move];

		if (isMap(r, c) && map[r][c] == '.') { //전차가 가려는 방향이 맵 안이고 .이면
			map[r][c] = allow[move];
			map[r - dx[move]][c - dy[move]] = '.';
		} else { //아니면 원위치로 복구
			r = r - dx[move];
			c = c - dy[move];
		}
	}

	private static void shoot() {
		int cnt = 1;
		while (cnt <= W) { //슛이 나가거나 *, #을 만날때까지 반복
			int x = r + dx[move] * cnt;
			int y = c + dy[move] * cnt;
			if (isMap(x, y)) {
				if (map[x][y] == '*') {
					map[x][y] = '.';
					break;
				} else if (map[x][y] == '#') {
					break;
				}
			}
			cnt++;
		}
	}

	private static boolean isMap(int r, int c) {
		if (r >= 0 && r < H && c >= 0 && c < W) {
			return true;
		}
		return false;
	}

	private static void printMap() {
		for (int i = 0; i < H; i++) {
			for (int j = 0; j < W; j++) {
				System.out.print(map[i][j]);
			}
			System.out.println();
		}
	}
}
