package hw_20220210;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
//정사각형방
public class Solution_1861 {
	static int[] dx = { -1, 1, 0, 0 };
	static int[] dy = { 0, 0, -1, 1 };
	static int N;

	public static void main(String[] args) throws NumberFormatException, IOException {
		System.setIn(new FileInputStream("src/정사각형방.txt"));
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(bf.readLine());

		for (int test_case = 1; test_case <= T; test_case++) {
			N = Integer.parseInt(bf.readLine());
			int[][] map = new int[N][N];
			int max = 0;
			int res = Integer.MAX_VALUE;

			for (int r = 0; r < map.length; r++) {
				StringTokenizer st = new StringTokenizer(bf.readLine());
				for (int c = 0; c < map.length; c++) {
					map[r][c] = Integer.parseInt(st.nextToken());
				}
			}

			for (int r = 0; r < map.length; r++) {
				for (int c = 0; c < map.length; c++) { // 출발점
					int cnt = 0;
					int or = r;
					int oc = c;
					boolean state = false;

					while (true) {
						for (int d = 0; d < dx.length; d++) { // 사방탐색하며 1크면 위치 이동
							state = false;
							int nr = r + dx[d];
							int nc = c + dy[d];
							if (isMap(nr, nc)) {
								if (map[nr][nc] == map[r][c] + 1) {
									r = nr;
									c = nc;
									state = true;
									cnt++;
									break;
								}
							}
						}
						if (!state)
							break;
					}
					if (cnt > max) {
						max = cnt;
						res = map[or][oc];
					} else if (cnt == max) {
						res = Math.min(res, map[or][oc]);
					}
					r = or;
					c = oc;
				}
			}
			System.out.println("#" + test_case + " " + res + " " + (max+1));
		}
	}

	private static boolean isMap(int nr, int nc) {
		if (nr >= 0 && nr < N && nc >= 0 && nc < N) {
			return true;
		}
		return false;
	}
}
