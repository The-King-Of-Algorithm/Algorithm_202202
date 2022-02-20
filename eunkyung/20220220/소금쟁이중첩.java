package day11;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class 소금쟁이중첩 {
	static int[] dx = { 0, 1, 0 };
	static int[] dy = { 0, 0, 1 };
	static int[][] map;

	public static void main(String[] args) throws IOException {
		System.setIn(new FileInputStream("src/day11/소금쟁이중첩.txt"));
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(bf.readLine());

		for (int tc = 1; tc <= T; tc++) {
			StringTokenizer st = new StringTokenizer(bf.readLine());
			StringBuilder sb = new StringBuilder();
			Queue<Integer> q = new LinkedList<Integer>();

			int N = Integer.parseInt(st.nextToken());
			int K = Integer.parseInt(st.nextToken());
			map = new int[N][N];
			boolean state = true;

			sb.append("#" + tc + " ");
			for (int k = 1; k <= K; k++) {
				st = new StringTokenizer(bf.readLine());
				int r = Integer.parseInt(st.nextToken());
				int c = Integer.parseInt(st.nextToken());
				int d = Integer.parseInt(st.nextToken());
				if (map[r][c] == 0) {
					map[r][c] = k;
					for (int n = 3; n > 0; n--) {
						int nr = r + dx[d] * n;
						int nc = c + dy[d] * n;
						if (isMap(nr, nc)) {
							if (map[nr][nc] == 0) {
								map[nr][nc] = k;
								r = nr;
								c = nc;
							} else {
								state = false;
							}
						} else {
							break;
						}
					}
				} else {
					state = false;
				}

				if (!state) {
					q.offer(k);
				}
			}
			if (state) {
				q.offer(0);
			}

			sb.append(q.peek());
			System.out.println(sb);

		}
	}

	private static boolean isMap(int nr, int nc) {
		if (nr >= 0 && nr < map.length && nc >= 0 && nc < map[0].length) {
			return true;
		}
		return false;
	}
}
