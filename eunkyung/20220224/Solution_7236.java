package day11;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

//저수지 물의 총 깊이 구하기
public class Solution_7236 {

	static int[] dx = { -1, -1, -1, 0, 0, 1, 1, 1 };
	static int[] dy = { -1, 0, 1, -1, 1, -1, 0, 1 };

	public static void main(String[] args) throws NumberFormatException, IOException {
		System.setIn(new FileInputStream("src/day11/저수지깊이.txt"));
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(bf.readLine());

		for (int tc = 1; tc <= T; tc++) {
			int N = Integer.parseInt(bf.readLine());
			char[][] map = new char[N][N];
			int max = 0;
			for (int i = 0; i < map.length; i++) {
				String str = "";
				StringTokenizer st = new StringTokenizer(bf.readLine());
				for (int j = 0; j < map.length; j++) {
					str += st.nextToken();
				}
				map[i] = str.toCharArray();
			}

			for (int i = 0; i < map.length; i++) {
				for (int j = 0; j < map.length; j++) {
					int cnt = 0;
					if (map[i][j] == 'W') {
						for (int d = 0; d < dx.length; d++) {
							int nr = i + dx[d];
							int nc = j + dy[d];
							if (nr >= 0 && nr < N && nc >= 0 && nc < N) {
								if (map[nr][nc] == 'W') {
									cnt++;
								}
							}
						}
						if (cnt == 0) {
							cnt = 1;
						}
						max = Math.max(max, cnt);
					}
				}
			}

			System.out.println("#" + tc + " " + max);
		}
	}
}
