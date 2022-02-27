package day13;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Bj18428_감시피하기 {
	static char[][] map;
	static int N;
	static ArrayList<int[]> student = new ArrayList<>();
	static int[] dx = { -1, 0, 1, 0 };
	static int[] dy = { 0, 1, 0, -1 };
	static boolean flag = false;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(bf.readLine());
		map = new char[N][N];

		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(bf.readLine());
			for (int j = 0; j < N; j++) {
				map[i][j] = st.nextToken().charAt(0);
				if (map[i][j] == 'S') {
					student.add(new int[] { i, j });
				}
			}
		}
		for (int cnt = 0; cnt < 3; cnt++) {
			int[][] res = check();
			int max = 0;
			int max_i = -1;
			int max_j = -1;
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					if (res[i][j] > max && map[i][j] != 'S') {
						max = res[i][j];
						max_i = i;
						max_j = j;
					}
				}
			}
			if(max_i>=0 && max_j>=0) {
				map[max_i][max_j] = 'O';
			}
		}

		check();
		if (!flag) {
			System.out.println("YES");
		} else
			System.out.println("NO");
	}

	private static int[][] check() {
		flag = false;
		int[][] v = new int[N][N];
		for (int i = 0; i < student.size(); i++) {
			int[] current = student.get(i);
			for (int d = 0; d < dx.length; d++) {
				boolean state = false;
				int n = 1;
				while (true) {
					int nr = current[0] + dx[d] * n;
					int nc = current[1] + dy[d] * n;
					if (nr >= 0 && nr < N && nc >= 0 && nc < N && map[nr][nc] != 'O') {
						if (map[nr][nc] != 'T') {
							n++;
						} else {
							state = true;
							flag = true;
							break;
						}
					} else
						break;
				}
				if (state) {
					for (int cnt = 1; cnt < n; cnt++) {
						v[current[0] + dx[d] * cnt][current[1] + dy[d] * cnt]++;
					}
				}
			}
		}
		return v;
	}
}
