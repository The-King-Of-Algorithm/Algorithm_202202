package day13;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class 기지국 {
	static int[] dx = { -1, 0, 1, 0 };
	static int[] dy = { 0, 1, 0, -1 };
	static int[] cnt = { 1, 2, 3 };

	public static void main(String[] args) throws IOException {
		System.setIn(new FileInputStream("src/day13/기지국.txt"));
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(bf.readLine());
		for (int tc = 1; tc <= T; tc++) {
			int N = Integer.parseInt(bf.readLine());
			char[][] map = new char[N][N];
			ArrayList<int[]> list = new ArrayList<int[]>();

			for (int i = 0; i < map.length; i++) {
				String str = bf.readLine();
				for (int j = 0; j < map.length; j++) {
					map[i][j] = str.charAt(j);
					if (map[i][j] != 'X' && map[i][j] != 'H')
						list.add(new int[] { i, j });
				}
			}
			
			for (int i = 0; i < list.size(); i++) {
				int[] current = list.get(i);
				for (int d = 0; d < dx.length; d++) {
					int n = 1;
					while (n <= cnt[map[current[0]][current[1]] - 'A']) {
						int nr = current[0] + dx[d] * n;
						int nc = current[1] + dy[d] * n;
						if (nr >= 0 && nr < N && nc >= 0 && nc < N && map[nr][nc] == 'H') {
							map[nr][nc] = 'X';
							n++;
						} else
							break;
					}
				}
			}

			int sum = 0;
			for (int i = 0; i < map.length; i++) {
				for (int j = 0; j < map.length; j++) {
					if (map[i][j] == 'H') {
						sum++;
					}
				}
			}
			System.out.println(sum);
			//print(map);
		}
	}
}
