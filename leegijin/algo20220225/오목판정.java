package algo20220225;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 오목판정 {
	static int dr[] = { 0, 1, 1, -1 }; // 우 //하 //왼 아래 위 대각
	static int dc[] = { 1, 0, 1, 1 };
	static int n;
	static char[][] map;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(bf.readLine());
		for (int tc = 1; tc <= t; tc++) {
			n = Integer.parseInt(bf.readLine());
			map = new char[n][n];
			for (int i = 0; i < n; i++) {
				String s = bf.readLine();
				for (int j = 0; j < n; j++) {
					map[i][j] = s.charAt(j);
				}
			}
			int flag = 0;
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < n; j++) {
					if (map[i][j] == 'o' && flag == 0) {
						if (check(i, j)) {
							flag = 1;
						}
					}
				}
			}
			if (flag == 0) {
				System.out.println("#" + tc + " NO");
			} else {
				System.out.println("#" + tc + " YES");
			}
		}
	}

	private static boolean check(int row, int col) {
		
		for (int d = 0; d < 4; d++) {
			int cr = row;
			int cc = col;
			int cnt =1;
			while (true) {
				int nrow = cr + dr[d];
				int ncol = cc + dc[d];
				if(nrow>=0 && nrow<n && ncol>=0 && ncol<n && map[nrow][ncol]=='o') {
					cnt++;
					cr=nrow;
					cc=ncol;
				}
				else {
					break;
				}
			}
			//System.out.println(row+" "+col+" "+d+" "+cnt);
			if(cnt>=5) {
				return true;
			}
		}
		return false;
	}
}
