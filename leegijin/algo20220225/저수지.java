package algo20220225;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 저수지 {
	static int[] dr = { 1, -1, 0, 0, 1, -1, 1, -1 };
	static int[] dc = { 0, 0, 1, -1, 1, 1, -1, -1 };

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(bf.readLine());
		for (int tc = 1; tc <= t; tc++) {
			int n = Integer.parseInt(bf.readLine());
			char[][] map = new char[n][n];
			for (int i = 0; i < n; i++) {
				StringTokenizer st = new StringTokenizer(bf.readLine());
				for (int j = 0; j < n; j++) {
					map[i][j] = st.nextToken().charAt(0);
				}
			}
			int ans = 0;
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < n; j++) {
					if (map[i][j] == 'W') {
						int cnt = 0;
						for (int d = 0; d < 8; d++) {
							int nrow = i + dr[d];
							int ncol = j + dc[d];
							if (nrow >= 0 && nrow < n && ncol >= 0 && ncol < n && map[nrow][ncol] == 'W') {
								cnt++;
							}
						}
						ans = Math.max(ans, cnt);
					}
				}
			}
			if (ans == 0) {
				System.out.println("#" + tc + " " + 1);
			} else {
				System.out.println("#"+tc+" "+ans);
			}
		}
	}
}
