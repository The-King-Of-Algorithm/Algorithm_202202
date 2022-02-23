package day11;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;
// 다시 푼 문제
public class 로봇이동거리2 {
	static class Robot {
		int r, c, t;

		public Robot(int r, int c, int t) {
			super();
			this.r = r;
			this.c = c;
			this.t = t;
		}
	}
	static int N, cnt;
	static int[] dx = { -1, 0, 0, 1 };
	static int[] dy = { 0, -1, 1, 0 };
	static int[][] dir = { { 2 }, { 1, 2 }, { 0, 1, 2, 3 } };

	public static void main(String[] args) throws NumberFormatException, IOException {
		System.setIn(new FileInputStream("src/day11/로봇이동거리.txt"));
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(bf.readLine());

		for (int tc = 1; tc <= T; tc++) {
			N = Integer.parseInt(bf.readLine());
			char[][] map = new char[N][N];
			ArrayList<Robot> robot = new ArrayList<>();
			cnt = 0;

			for (int i = 0; i < N; i++) {
				StringTokenizer st = new StringTokenizer(bf.readLine());
				String str = "";
				for (int j = 0; j < N; j++) {
					str += st.nextToken();
				}
				for (int j = 0; j < N; j++) {
					map[i][j] = str.charAt(j);
					char c = 'A';
					if (map[i][j] != 'S' && map[i][j] != 'W') {
						robot.add(new Robot(i, j, map[i][j] - 'A'));
					}
				}
			}

			for (int r = 0; r < robot.size(); r++) {
				Robot R = robot.get(r);
				for (int d = 0; d < dir[R.t].length; d++) {
					int n = 1;
					while (true) {
						int nr = R.r + dx[dir[R.t][d]] * n;
						int nc = R.c + dy[dir[R.t][d]] * n;
						if (nr >= 0 && nr < N && nc >= 0 && nc < N && map[nr][nc] == 'S') {
							cnt++;
							n++;
						} else
							break;
					}
				}
			}
			System.out.println("#" + tc + " " + cnt);
		}
	}
}
