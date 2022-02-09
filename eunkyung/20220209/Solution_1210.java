package hw_20220209;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
//사다리 게임
public class Solution_1210 {
	static int[] dx = { -1, 0, 0 };
	static int[] dy = { 0, -1, 1 };

	public static void main(String[] args) throws NumberFormatException, IOException {
		System.setIn(new FileInputStream("src/사다리게임2.txt"));
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

		for (int test_case = 1; test_case <= 10; test_case++) {
			bf.readLine();
			int N = 100;
			int[][] map = new int[N][N];
			int x = 0;
			int y = 0;
			int move = 0;

			for (int i = 0; i < map.length; i++) {
				StringTokenizer st = new StringTokenizer(bf.readLine());
				for (int j = 0; j < map.length; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
					if (map[i][j] == 2) { // 도착위치 저장
						x = i;
						y = j;
					}
				}
			}
			while (true) {

				if (move == 0) {
					for (int d = 1; d < dx.length; d++) {
						int nx = x + dx[d];
						int ny = y + dy[d];
						if (isMap(nx, ny) && map[nx][ny] == 1) {
							move = d;
							x = nx;
							y = ny;
							break;
						}
					}
				} else {
					int nx = x + dx[move];
					int ny = y + dy[move];
					if (!isMap(nx, ny)) {
						move = 0;
					} else {
						if (map[nx][ny] != 1) {
							move = 0;
						}
					}
				}
				if (isMap(x + dx[move], y + dy[move])) {
					x = x + dx[move];
					y = y + dy[move];
				}
				if (x == 0) {
					System.out.println("#" + test_case + " " + y);
					break;
				}
			}
		}
	}

	private static boolean isMap(int nx, int ny) {
		if (nx < 100 && nx >= 0 && ny < 100 && ny >= 0) {
			return true;
		}
		return false;
	}
}
